# AIRLINES - DASHBOARD APPLICATION

## REQUIREMENTS

There is no docker in the project, yet.
* java 1.8.^
* favourite IDE or text editor
* a little bit of patience

## PROJECT SETUP

Go through the steps below in order to set up the project.

**Step 1** Clone the project from github:
```
$ git clone https://github.com/onemore123/airlines.git
```

**Step 2** Open the directory:
```
$ cd ./airlines
```

**Step 3** Start the project: <br/>
Note: use the *cli* command below or right-click the public static void main in AirlinesApplication and select Run from your IDE.
```
$ ./mvnw clean spring-boot:run
```

**Step 4** Open *localhost:8080* in Chrome: http://localhost:8080/passenger-flight/1/

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

### 3. Get passengers list by flight
Use the flight unique identifier ("*/1*" in the end of the query) to get the list of passengers like in the example below:
```
curl -v -X GET "http://localhost:8080/passenger-flight/1" -H 'Content-Type:application/json'
```

### 4. Check-in passenger
Kindly note, that the passenger should be created before using the Step 1.

*NOTE: at the moment method is implemented with a workaround.*
```
curl -v -X POST localhost:8080/passenger-flight -H 'Content-Type:application/json' -d '{"phone": "+79998887780", "flightId": "1", "seatType": "BUSINESS_CLASS"}'
```
###### Body description:
* *phone* - contains passenger **unique** phone
* *flightId* - contains flight unique identifier.
* *type* - contains one of two available seat types
    * BUSINESS_CLASS - business class available seats number
    * ECONOMY_CLASS - economy class available seats number
