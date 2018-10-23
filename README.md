# Payspec Payment Infrastructure Project 

The project provides RESTful APIs to manage Bank Account, initiate and process Payments and facilitates both B2B and B2C.

## How to set up
At deployment project uses a servlet installer to install super ADMIN into the database. The is the Customer Key or Super Admin of the entire system.


**superuser** is the only user with **ROLE_ADMIN** so, is the only who can use some of the entry points, for example, *get users*.

## How to run it

This is a multi-layer Maven project built using **Spring framework: 5.1.0.RELEASE**.

To build the project just execute maven `mvn clean package` commands from the project root, with this you'll get a generated war file on target folder.

If you want to run the project in an embedded Tomcat instance execute `mvn tomcat7:run` command also from the project root.

## RESTful API

The API provides the following interfaces

### Login
**POST rest/api/login**

Request:
```
Headers:
Accept: application/json
Content-Type: application/json
Body: {\"username\":\"bolaji@gmail.com\",\"password\":\"password\"}
```

Login success response:
```
Code: 200
Body: {"username":"superuser","loggedIn":true}
```
Login incorrect response:
```
Code: 200
Body: {"loggedIn":false}
```
Login error reponse:
```
Code: 400
Body: empty
```

### Logout
**DELETE rest/api/login**

Request:
```
Headers: Accept: application/json, Content-Type: application/json
Body: {\"username\":\"bolaji@gmail.com\",\"password\":\"password\"}
```

Logout success response:
```
Code: 200
Body: empty
```
Logout error reponse:
```
Code: 400
Body: empty
```

### Get users
**GET rest/api/users**

Request:
```
Headers:
Accept: application/json
```
success response:
```
Code: 200
Body: [{"username":"superuser","email":"superuser@payspec.com"},{"username":"customer1","email":"customer2@payspec.com"},{"username":"customer3","email":"customer2@payspec.com"}]
```
unauthorized response:
```
Code: 401
Body: empty
```

### Get accounts
**GET rest/api/accounts**

request:
```
Headers: Accept: application/json
```
success response:
```
Code: 200
Body: [{\"bankVerificationNumber\":\"0067825\",\"accountNumber\":\"0044534\",\"accountType\":\"SA\",\"user\":{\"userName\":\"cleancut\",\"email\":\"cleancut@gmail.com\"}]
```
unauthorized response:
```
Code: 401
Body: empty
```
### Create account
**POST rest/api/accounts**

request:
```
Headers: Accept: application/json
Body: {\"bankVerificationNumber\":\"0067825\",\"accountNumber\":\"0044534\",\"accountType\":\"SA\",\"user\":{\"userName\":\"cleancut\",\"email\":\"cleancut@gmail.com\"}
```
success response:
```
Code: 200
Body: {"accountNumber":"0042234","bankVerificationNumber":"009331","accountId":0,"balanceAmount":0,"user":{"userName":"abegigrace","email":"amalaabegi@gmail.com","gsmPhoneNumber":"08011122234","password":"vuvogLx0V40JNEu80gGLp6fcVE+T9Z1lbxDXzvdNjwVKbgpO7kyCNMZo","enabled":false,"version":0,"organization":{"name":"Amala Abegi","email":"amalaabegi@gmail.com","phoneNumber":"xxx11122234","products":[]}}}
```
unauthorized response:
```
Code: 401
Body: empty
```

### Get accounts
**GET rest/api/payments**

request:
```
Headers: Accept: application/json
```
success response:
```
Code: 200
Body: [{\"amount\":\"450\",\"paymentDescription\":\"Fresh Meal\",\"paymentType\":\"Inv\",\"paychant\":{\"name\":\"Cleancut Barbers\",\"email\":\"cleancut@gmail.com\"},\"merchant\":{\"name\":\"Amala Abegi\",\"email\":\"amalaabegi@gmail.com\"},\"products\":[{\"productId\":\"119332\",\"name\":\"Amala Abegi\"},{\"productId\":\"119333\",\"name\":"\Semo Abegi\"}]}"]
```
unauthorized response:
```
Code: 401
Body: empty
```
### Create account
**POST rest/api/payments**

request:
```
Headers: Accept: application/json
Body: {\"amount\":\"450\",\"paymentDescription\":\"Fresh Meal\",\"paymentType\":\"Inv\",\"paychant\":{\"name\":\"Cleancut Barbers\",\"email\":\"cleancut@gmail.com\"},\"merchant\":{\"name\":\"Amala Abegi\",\"email\":\"amalaabegi@gmail.com\"},\"products\":[{\"productId\":\"119332\",\"name\":\"Amala Abegi\"},{\"productId\":\"119333\",\"name\":"\Semo Abegi\"}]}"
```
success response:
```
Code: 200
Body: {""}}
```
unauthorized response:
```
Code: 401
Body: empty
```

## How to test it

To verify if it's correctly working you can use, for example with **curl**, read the manual using `man curl` to get details about how to use it, some examples bellow using our local running server on **http://localhost:8080/quatspec **(#How-to-run-it):

##### GET request example
This example will make a **GET** request on path *rest/api/users*, the cookie content is gotten from a successfully login request.
```
 curl -X GET -H'Accept: application/json' -H'Content-Type: application/json' --cookie "JSESSIONID=F642BF70B000FE382DE92E5F7A024C08" -D- http://localhost:8080/quatspec/rest/api/users
```
you'll get in your terminal something similar to this with the *status code* on the first line and the *body of the response* in the last one
```
HTTP/1.1 200 OK
Server: Apache-Coyote/1.1
X-Content-Type-Options: nosniff
X-XSS-Protection: 1; mode=block
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Pragma: no-cache
Expires: 0
X-Frame-Options: DENY
Set-Cookie: JSESSIONID=F9DEDD5E6162EF2A96B443C72764A3DE; Path=/; HttpOnly
Content-Type: application/json
Transfer-Encoding: chunked
Date: Tue, 23 May 2017 12:06:08 GMT

{"username":"user1","loggedIn":true}
```

##### POST request example
This example will make a **POST** request on path *rest/api/login* in our local running server on *localhost:/quatspec/8080*
```
curl -XPOST -H'Accept: application/json' -H'Content-Type: application/json' -d'{"username":"superuser","password":"password"}' -D- http://localhost:8080/rest/api/login
```
you'll get in your terminal something like this with the status code on the first line and the body of the response in the last one
```
HTTP/1.1 200 OK
Server: Apache-Coyote/1.1
X-Content-Type-Options: nosniff
X-XSS-Protection: 1; mode=block
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Pragma: no-cache
Expires: 0
X-Frame-Options: DENY
Set-Cookie: JSESSIONID=F9DEDD5E6162EF2A96B443C72764A3DE; Path=/; HttpOnly
Content-Type: application/json
Transfer-Encoding: chunked
Date: Tue, 23 May 2017 12:06:08 GMT

{"username":"superuser","loggedIn":true}
```



