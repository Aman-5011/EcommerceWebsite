# 🛒 AmanMart - Full-Stack E-Commerce Platform
https://share.google/0tWvx4rzUW4Ccbdxj

AmanMart is a modern, full-stack e-commerce web application built to provide a seamless shopping experience. It features a responsive React frontend and a robust Spring Boot backend, allowing users to browse products, manage their shopping carts, and place orders, while administrators can manage inventory and product details.

---

## ✨ Key Features

* **Comprehensive Product Management:** Administrators can add, update, and delete products, including handling image uploads directly through the platform.
* **Intelligent Search:** Users can search for products in real-time. The backend dynamically filters results across product names, descriptions, brands, and categories.
* **Robust Order Processing:** 
  * Generates unique order IDs (e.g., `ORD...`) for tracking.
  * Automatically validates and deducts product stock quantities when an order is placed.
  * Calculates total prices dynamically based on item quantity and product price.
* **Secure Data Transfer:** Utilizes a Data Transfer Object (DTO) pattern to securely transmit order requests and responses between the client and server.
* **Shopping Cart & Local Storage:** A dynamic cart system powered by React Context API that persists user selections using local storage.
* **Dynamic UI Themes:** Built-in support for light and dark themes for an accessible user experience.

---

## 🛠️ Technology Stack

### **Frontend**
* **Framework:** React.js powered by Vite.
* **Routing & State:** React Router DOM and Context API.
* **Styling:** Bootstrap CSS, Bootstrap Icons, and custom CSS.
* **HTTP Client:** Axios for API communication.
* **Alerts:** React Toastify for non-intrusive notifications.

### **Backend**
* **Framework:** Spring Boot and Spring Web MVC.
* **Language:** Java 21.
* **Database:** PostgreSQL with Spring Data JPA for Object-Relational Mapping.
* **Architecture:** Layered architecture (Controllers, Services, Repositories, Entities, and DTOs).
* **Utilities:** Lombok to reduce Java boilerplate.

---

## 📂 Project Architecture

The application is strictly separated into a client-server architecture:

```text
AmanMart/
│
├── Backend/ (Spring Boot)
│   ├── controller/      # REST API endpoints mapping (OrderController, ProductController)
│   ├── model/           # Database Entities (Product, Order, OrderItem)
│   ├── dto/             # Data Transfer Objects for secure request/response handling
│   ├── service/         # Core business logic and transaction management
│   └── repo/            # Data access layer interfacing with PostgreSQL
│
└── Frontend/ (React)
    ├── src/
    │   ├── components/  # Reusable UI components (Cart, Navbar, CheckoutPopup, etc.)
    │   ├── Context/     # AppContext for global cart and data state
    │   └── App.jsx      # Main application router
```

---

## 🔌 API Endpoints

The Spring Boot backend exposes the following primary REST endpoints:

| HTTP Method | Endpoint | Description |
| :--- | :--- | :--- |
| `GET` | `/api/products` | Retrieves a list of all products. |
| `GET` | `/api/product/{id}` | Retrieves a single product by its ID. |
| `GET` | `/api/product/{id}/image` | Fetches the raw image data (byte array) for a product. |
| `POST` | `/api/product` | Adds a new product along with its image. |
| `PUT` | `/api/product/{id}` | Updates an existing product's details and image. |
| `DELETE` | `/api/product/{id}` | Deletes a product from the database. |
| `GET` | `/api/products/search` | Searches products based on a keyword. |
| `POST` | `/api/orders/place` | Places a new order, validates stock, and calculates totals. |
| `GET` | `/api/orders` | Retrieves all placed orders. |

---

## 🚀 Local Setup Instructions

### Prerequisites
* JDK 21
* Node.js (v16+)
* PostgreSQL

### 1. Backend Configuration
1. Open the `Backend/SpringEcom` directory.
2. Update the `application.properties` file with your PostgreSQL credentials:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/your_db_name
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   ```
3. Run the application using the Maven wrapper:
   ```bash
   ./mvnw spring-boot:run
   ```
   *The API will run on `http://localhost:8080`.*

### 2. Frontend Configuration
1. Open the `Frontend` directory.
2. Install the required Node packages:
   ```bash
   npm install
   ```
3. Set the backend API URL in your environment file (`.env`):
   ```env
   VITE_BASE_URL=http://localhost:8080
   ```
4. Start the Vite development server:
   ```bash
   npm run dev
   ```
5. Open the local address (e.g., `http://localhost:5173`) in your browser to start shopping!
