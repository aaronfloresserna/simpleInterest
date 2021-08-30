# Simple Interest Calculator 
Aplazo wants to build a Returns calculator. the returns calculator will allow the user to calculate the returns for the following kind of deals

Simple Interest, return

```
   I = P * r * t
```

* P = the principal amount (the initial deposit)
* r = the monthly interest rate (percentage % i.e if rate of interest is 5% then input will be 5)
* t = the number of months the money is borrowed for

The returns should show weekly payments, t is multiplied by 4 (number of weeks per month), i.e 
"t" = 1 month = 4 weeks 


#### Technology Stack

* Spring Boot
* Swagger UI
* Rest
* Java 15
* Git
* H2 Data Base
* Docker

### Clone the repository at your local machine.

```
$ git clone https://github.com/aaronfloresserna/simpleInterest.git
```


### How to run the `Simple Interest Calculator`


```
$ cd simpleInterest
$ mvn spring-boot:run

```

### For Returns Calculator Rest API, Please click on the link below,

* [ReturnsCalculator](http://localhost:8080/swagger-ui.html).

![Swagger UI](/src/main/resources/images/swagger_ui.png "Swagger UI")
![Swagger UI](/src/main/resources/images/simple_interest.png "Simple Interest")
