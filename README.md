[![Java CI with Maven](https://github.com/crisywini/piggy-bank/actions/workflows/maven.yml/badge.svg?branch=develop&event=push)](https://github.com/crisywini/piggy-bank/actions/workflows/maven.yml)

# Piggy Bank 🐷💰

This project allows you to manage information about your savings in a piggy bank.

Here are some functionalities:

- Create coins
- Create a Piggy Bank
- Find a Piggy Bank by its id
- Close a Piggy Bank
- Calculate the total in your Piggy Bank
- Delete a Piggy Bank


## Usage

Installed Maven and Java 17.

Download the repo and run the next command in the root folder:

    mvn spring-boot:run 


Then you can use the localhost:8080/ the exposed services at this moment are:

| Service | Method | Description |
|--|--|--|
| */coins* | POST | Saves a coin definition |
| */piggy-banks* | POST | Saves a Piggy Bank |
| */piggy-banks/{id}* | GET | Finds a Piggy Bank by its id |
| */piggy-banks/close/{id}* | PATCH | Close a Piggy Bank (like breaking it) |
| */piggy-banks/total/{id}* | GET | Calculates the total amount in a specific Piggy Bank |
| */piggy-banks/{id}* | DELETE | Deletes a Piggy Bank |

