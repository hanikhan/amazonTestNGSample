# Amazon Sample Tests
 - Uses Page Objet Model and TestNG

## Pre-requisites
Add Amazon login details to environment variables
`export AMAZON_USERNAME=<username>`
`export AMAZON_PASSWORD=<password>`
`export SEARCH_STRING=<search string>`

For example, on a Mac or Linux machine, use the following commands for username- abc@xyz.com, password- somepassword, search string- samsung:
`export AMAZON_USERNAME=abc@xyz.com`
`export AMAZON_PASSWORD=somepassword`
`export SEARCH_STRING=samsung`

## To run test:
`mvn compile`
`mvn test -P wishlistTest`
