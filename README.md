Utilisation de l'api - GIROUX GWENAEL

GET:

liste complète de tous les restaurants: localhost:8080/restaurants
Restaurant par ID : localhost:8080/restaurants/{id}

POST:

localhost:8080/restaurants

Ajouter un livre:

JSON

{
	"name" : "{name}",
	"address" : "{address}",
}

PUT
Moidifier un livre
{
	"id" : "{id}"
	"name" : "{name}",
	"address" : "{address}",
}

DELETE

supprimer un restaurant par ID: localhost:8080/restaurants/{id}

