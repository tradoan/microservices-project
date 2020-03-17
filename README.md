# Microservices-project
Das Projekt beschreibt einen Online-Shop:

## Struktur des Projekts
Wir haben 3 Microservices: User, Basket und Product.
1. User-Microservice
Enthält User-Daten zur Erstellung einer User-Entity mit Id, FirstName, LastName, Email-Address und Password. Jeder User hat einen Warenkorb.
2. Basket-Microservice
Enthält ProductId, UserId, Quantity und hat eine eigene Id, damit man den Warenkorb einem Nutzer zuordnen kann.
3. Product-Microservice
Enthält ProduktId, Name, Price und Description, um Produkte anzuzeigen.

Außerdem gibt es noch spring cloud services: Eureka Server und Config Server.

## Was macht das Projekt?

Der User kann einen neuen Account erstellen, updaten und löschen. Er kann auch Produkte in eigenen Warenkorb hinzufügen, bearbeiten und entfernen. Das sind die Funktionen von `user-service`.  
`basket-service` dient dazu, dass User den Warenkorb verwalten (einfügen, bearbeiten und entfernen) kann. Der Service ist die Schnittstelle zwischen `user-service` und `product-service`.  
`product-service` speichert alle Produkte. Der User kann direkt alle verfügbaren Produkte ansehen.

## Wie kann das Projekt gestartet werden?

1. Starte `config-server` auf Port `8888`
2. Starte `eureka-server` auf Port `8761`
3. Starte `user-service` auf Port `8081`, `product-service`auf Port 8082 und `basket-service` auf Port `8083`. Man kann es mit `h2`-Profile testen. Das ist als Default in "bootstrap.properties" aktiviert. 
