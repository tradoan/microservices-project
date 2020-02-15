# Microservices-project
Das Projekt beschreibt ein Online-Shop:

## Structur des Projekts
Wir haben 3 Microservices: User, Basket und Product.
1. Microservice: User
Enthält User-Daten zur Erstellung einer User-Entity mit Id, FirstName, LastName, Email-Address und Password. Jeder User hat einen Warenkorb.
2. Microservice: Basket
Enthält ProductId, UserId, Quantity und hat eine eigene Id, damit man den Warenkorb einem Nutzer zuordnen kann.
3. Microservice: Product
Enthält ProduktId, Name, Price und Description um Produkte anzuzeigen.

Außerdem gibt es noch spring cloud services: Eureka Server und Config Server.

## Was macht das Projekt?

User kann einen neuen Account erstellen, updaten und löschen. User kann auch Produkte in eigenen Warenkorb hinzufügen, bearbeiten und entfernen. Das sind die Funktionen von `user-service`.  
`basket-service` dient dazu, dass User den Warenkorb verwalten (einfügen, bearbeiten und entfernen) kann. Das Service ist die Schnittstelle zwichen `user-service`und `product-service`.  
`product-service` speichert alle Produkte. User kann direkt alle verfügbaren Produkte ansehen.

## Wie kann das Projekt gestartet werden?

1. Starte `config-server` auf Port 8888
2. Starte `eureka-server` auf Port 8761
3. Starte `user-service` auf Port 8081, `product-service`auf Port 8082 und `basket-service` auf Port 8083. Mann kann mit `h2`-Profile testen. Das ist als Default in "bootstrap.properties" activiert. 
