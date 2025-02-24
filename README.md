# Spring course Repository

## Context
This repository represents my initial contact with Java Spring

## Endpoints

### POST /products
Creates a new product.

**Request:**
- Body: `{ "name": "string", "price": "number" }`

**Response:**
- 201 Created: Product created successfully.
- 400 Bad Request: Invalid data.
- 500 Internal Server Error: Server error occurred.

### GET /products
Returns a list of all products.

**Response:**
- 200 OK: Returns the list of products.
- 500 Internal Server Error: Server error occurred.

### GET /products/{id}
Returns a specific product by ID.

**Request:**
- Parameters: `id` (ID of the product to be returned)

**Response:**
- 200 OK: Returns the product.
- 404 Not Found: Product not found.
- 500 Internal Server Error: Server error occurred.

### PUT /products/{id}
Updates an existing product by ID.

**Request:**
- Parameters: `id` (ID of the product to be updated)
- Body: `{ "name": "string", "price": "number" }`

**Response:**
- 200 OK: Product updated successfully.
- 400 Bad Request: Invalid data.
- 404 Not Found: Product not found.
- 500 Internal Server Error: Server error occurred.

### DELETE /products/{id}
Removes an existing product by ID.

**Request:**
- Parameters: `id` (ID of the product to be removed)

**Response:**
- 200 OK: Product removed successfully.
- 404 Not Found: Product not found.
- 500 Internal Server Error: Server error occurred.
