# Simple Interest Calculator 
Aplazo simple interest project. The project calculator will allow the user to calculate and generates the list of payments of the simple interest of a credit that must be paid in n terms and in weekly form.

Simple Interest 

```
   I = P * r * t
```

* P = the principal amount (the initial deposit)
* r = the monthly interest rate (percentage % i.e if rate of interest is 5% then input will be 5.0)
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

### For Simple Interest calculator Rest API, Please click on the link below

* [Simple Interest calculator](http://localhost:8080/swagger-ui.html).

![Swagger UI](/src/main/resources/images/swagger.PNG "Swagger UI")

![Swagger UI](/src/main/resources/images/simpleInterest.PNG "Simple Interest")

REQUEST                HTTP STATUS             RESPONSE

{                      200 
  "amount": 10000,
  "rate": 3.86,
  "terms": 1
}                                      [
                                             {
                                                "payment_number": 1,
                                                "amount": 2596.5,
                                                "payment_date": "2021-08-30"
                                             },
                                             {
                                                "payment_number": 2,
                                                "amount": 2596.5,
                                                "payment_date": "2021-09-06"
                                             },
                                             {
                                                "payment_number": 3,
                                                "amount": 2596.5,
                                                "payment_date": "2021-09-13"
                                             },
                                             {
                                                "payment_number": 4,
                                                "amount": 2596.5,
                                                "payment_date": "2021-09-20"
                                             }
                                          ]


{                      400 
  "rate": 3.86,
  "terms": 1
}                                         {
                                             "message": "amount property required",
                                             "status": 400,
                                             "httpStatus": "BAD_REQUEST",
                                             "timeStamp": "2021-08-30T19:37:37.5326703-04:00"
                                          }    

{                      400 
  "amount": 10000,
  "rate": 3.86,
  "terms": -1
}                             
                                          {
                                             "message": "terms has to be grater than 0 or not null",
                                             "status": 400,
                                             "httpStatus": "BAD_REQUEST",
                                             "timeStamp": "2021-08-30T19:39:10.1276785-04:00"
                                          }                             

### For Health endpoint, click on the link below

* [Health Endpoint](http://localhost:8080/actuator/health).

![Health ep](/src/main/resources/images/health.PNG "Simple Interest health")

### For h2 Data Base, Please click on the link below

* [H2 Data Base](http://localhost:8080/h2).

![H2 db](/src/main/resources/images/h2.PNG "Simple Interest h2 data base")

### JUnit test coverage

![H2 db](/src/main/resources/images/testCoverage.PNG "Simple Interest test coverage")
