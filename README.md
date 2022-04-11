## Coffeeshop
Coffeeshop is a white-label product intended to work for small companies.
It will have:

- Multiple store management
- Category and product management
- Payment integration
- Order creation (self-service)
- Current orders (so the barista can prepare then)

The idea is to make the project incrementally, ideas for future:

- Online order (client can order from web/app)
- Price management
- Availability
- Coupons
- Prepaid discount
- Login integrations (Google, Apple, etc)
- Product options (e.g. with cup lid, milk type)
- Other payment integrations
- Propose something!

### Order
POST localhost:8080/api/v1/orders
```json
{
  "clientName": "Ana",
  "total": 174,
  "items": ["625383ceefe1c42e5bd4b3d3", "62538420efe1c42e5bd4b3d4"],
  "paid": true
}
```
response
```json
{
  "id": "62538af6efe1c42e5bd4b3db",
  "createdAt": "2022-04-10T22:57:10.516277",
  "clientName": "Ana",
  "total": 174,
  "products": [
    {
      "id": "625383ceefe1c42e5bd4b3d3",
      "image": "http://placeimg.com/640/480",
      "title": "Rustic Frozen Tuna",
      "subtitle": "Unbranded Plastic Computer",
      "description": "bifurcated",
      "price": 167,
      "categoryId": "62536e74efe1c42e5bd4b3d0"
    },
    {
      "id": "62538420efe1c42e5bd4b3d4",
      "image": "http://placeimg.com/640/480",
      "title": "Ergonomic Metal Car",
      "subtitle": "Intelligent Frozen Chicken",
      "description": "bottom-line",
      "price": 263,
      "categoryId": "62536e74efe1c42e5bd4b3d0"
    }
  ],
  "paid": true
}
```