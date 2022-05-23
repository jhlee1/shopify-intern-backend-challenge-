# This is a shoppify intern backend challenge project

## Description
- I have implemented the first in the second list `When deleting, allow deletion comments and undeletion` 


## APIs
Here is how to use APIs. 

You can check actual examples on `example-request.http` file.

### List inventory items
```
GET http://localhost:8080/inventory/items
```
### Create an inventory item
```
POST http://localhost:8080/inventory/items
Content-Type: application/json

{
"name": "Item number 1",
"description": "Example description"
}
```

### Edit inventory item
```
PUT http://localhost:8080/inventory/items/{itemId}
Content-Type: application/json

{
"name": "Editted item name",
"description": "This item is editted"
}
```

### Delete inventory item
```
DELETE http://localhost:8080/inventory/items/{itemId}
```

### Add comment on inventory item
```
POST http://localhost:8080/inventory/items/addComment/{itemId}
Content-Type: application/json

{
"authorName": "John Doe",
"content": "Example comment on item"
}
```

### Delete comment
```
PUT http://localhost:8080/inventory/items/deleteComment/{commentId}
```

### Undelete comment
```
PUT http://localhost:8080/inventory/items/unDeleteComment/{commentId}
```

