# HERE WILL BE THE README

## API

### 1. Create new passenger
In order to create new passenger use **POST** query like in the example below:
```
curl -v -X POST localhost:8080/passenger -H 'Content-Type:application/json' -d '{"name": "Samwise Gamgee", "age": "34", "phone":"+79998887780"}'
```
######Parameters description:
* *name* - contains *first name* and *last name* properties, separated by space.
* *age* - contains passenger age
* *phone* - contains passenger **unique** phone
