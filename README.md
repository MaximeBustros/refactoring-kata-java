# Refactoring Kata Test

## Introduction

We have a service that expose a route which give the amount a customer should pay given its cart
and its type.

This route was created ages ago, and nobody really knows who coded it or how it really works.
Nonetheless, as the business changes frequently, this class has already been modified many times,
making it harder to understand at each step.

Today, once again, the PO wants to add some new stuff to it and add the management for young customers.
But this class is already complex enough and just adding a new behaviour to it won't work this time.

Your mission, should you decide to accept it, is to **refactor `ShoppingController` to make it
understandable by the next developer** and easy to change afterwards. Now is the time for you to
show your exceptional skills and make this implementation better, extensible, and ready for future
features.

Sadly for you, this route is called everywhere, and **you can't change its signature**.

This exercise **should not last longer than 1,5 hour** (but this can be too short to do it all and
you can take longer if you want).

You can run the example file to see the method in action.

## Deliverables
What do we expect from you:
- the link of the git repository
- several commits, with an explicit message each time
- a file / message / email explaining your process and principles you've followed

## Prerequisite

- Java 11

## How to run the code

- You can start the application using maven: `./mvnw`. It will expose a route POST accessible at `http://localhost:8080/shopping
- You can launch the tests with `./mvnw test`

## Things left to do
So I took around 1h20-30 min to do the exercice here are the things left to do.

- Add a unit tests for ShoppingController, and the new classes
- Having unit tests for the ShoppingController should help us better refactor the code.
As it would allow us to avoid breaking currently working scenarios. Unit test also create a documentation for other developers to check what cases were already tested and enable them to better debug in the future.
- Using a the right HTTP methods for the operation (Follow RESTful API best practices)
    - Post is not a good method to use for retrieving the price of items.
    - Using the Body in a get method is bad practice
- Disect into smaller pieces of code that are more explicit
- Rename any variable that does not make a lot of sense or is not very explicit,
    - Names using single letter should be avoided at all cost
- Use the logger to log when Exeptions occur, and log the parameters getting inputed into the function
- Also give a more explicit error of the answer for the user if he made a bad request,
- That way he can understand what is expected of him as input to the request.
- Create method for checking if you are in a discount period and write it in another Java file as it could be reused through the application.
- Rename item class into Product class, with a name and a unit price, we shouldn't be having logic in the controller to determine the price of an item.
- A user should have a method that retrieves prices of cart, that method would call the cart of the sum of prices of it's items
- A cart should have CartItem class that should have an Product and the number of that Product
- Customers should have a way to add items to their cart through a post method
- And the logic for prices too high when adding items to cart
- As this would allow customers not know in advance that it is not possible for them to have a Cart with a total cost of over XXX Amount knowing their type.

Looking forward to discussing what I did and want I want to do extra for this application.
:)


