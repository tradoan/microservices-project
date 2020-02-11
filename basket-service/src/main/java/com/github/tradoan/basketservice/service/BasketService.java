package com.github.tradoan.basketservice.service;

import com.github.tradoan.basketservice.client.ProductClient;
import com.github.tradoan.basketservice.model.entity.Basket;
import com.github.tradoan.basketservice.model.entity.BasketDTO;
import com.github.tradoan.basketservice.model.entity.Product;
import com.github.tradoan.basketservice.model.repository.BasketRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Service
public class BasketService {
    @Autowired
    private BasketRepository basketRepository;
    @Autowired
    private ProductClient productClient;

    public BasketService(BasketRepository basketRepository, ProductClient productClient) {
        this.basketRepository = basketRepository;
        this.productClient = productClient;
    }

    public List<Basket> getBasketsByUserId(Long userId) {
        return basketRepository.findByUserId(userId);
    }

    public List<Basket> getAllBaskets() {
        return (List<Basket>) basketRepository.findAll();
    }

    public Basket addNewProductItemForUser(Long userId, Basket basket) {
        Basket oldBasket = basketRepository.findByUserIdAndProductId(userId, basket.getProductId());
        if(oldBasket != null) {
            return updateProductItemForUser(userId, basket);
        }
        else {
            Basket newItem = Basket.builder()
                    .userId((userId))
                    .productId(basket.getProductId())
                    .quantity(basket.getQuantity())
                    .build();
            return basketRepository.save(newItem);
        }
    }

    public void deleteProductItem(Long userId, Long productId) {
        Basket basket = basketRepository.findByUserIdAndProductId(userId, productId);
        basketRepository.delete(basket);
    }

    public Basket updateProductItemForUser(Long userId, Basket basketLine) {
        Basket oldBasket = basketRepository.findByUserIdAndProductId(userId, basketLine.getProductId());
        basketLine.setId(oldBasket.getId());
        basketLine.setUserId(userId);
        return basketRepository.save(basketLine);
    }

    @HystrixCommand(fallbackMethod = "notFoundProductById")
    public Product getProductFromItem(Long id) {
        return productClient.getProductById(id);
    }

    public List<BasketDTO> getProductsForUser(Long userId) {
        List<Basket> items = getBasketsByUserId(userId);

        List<BasketDTO> productItems = new ArrayList<>();

        for(Basket item: items) {
            Product product = productClient.getProductById(item.getProductId());

            BasketDTO productItem = new BasketDTO();
            BeanUtils.copyProperties(item, productItem);

            productItem.setProduct(product);
            productItems.add(productItem);
        }

        return productItems;
    }

    public Product notFoundProductById(Long id) {
        return new Product();
    }
}
