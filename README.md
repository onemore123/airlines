# HERE WILL BE THE README

## API

### 1. Create new passenger
In order to create new passenger use **POST** query like in the example below:
```
curl -v -X POST localhost:8080/passenger -H 'Content-Type:application/json' -d '{"name": "Samwise Gamgee", "age": "34", "phone":"+79998887780"}'
```
###### Body description:
* *name* - contains *first name* and *last name* properties, separated by space
* *age* - contains passenger age
* *phone* - contains passenger **unique** phone

### 2. Get available seats number by flight and seat type
```
curl -v -X GET "http://localhost:8080/flight/info?flightId=1&type=ECONOMY_CLASS" -H 'Content-Type:application/json'
```
###### Parameters description:
* *flightId* - contains flight unique identifier.
* *type* - contains one of two available seat types
    * BUSINESS_CLASS - business class available seats number
    * ECONOMY_CLASS - economy class available seats number
