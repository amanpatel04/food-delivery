# 🍽️ Food Service Delivery Platform

A comprehensive food delivery management system built with Spring Boot, featuring a robust backend API and a beautiful Thymeleaf-based.

## ✨ Features

### 🚀 Backend API
- **GET-only RESTful API** for data retrieval operations
- **JWT Authentication** with secure cookie-based sessions
- **JPA/Hibernate** for data persistence with MySQL database
- **Validation** using Bean Validation annotations
- **Exception Handling** with global exception handlers
- **DTO Pattern** for clean API responses

### 🎨 Frontend Dashboard
- **Thymeleaf Templates** for server-side rendering
- **Authentication** with secure login flow
- **Components** with vanilla html and css

### 📊 Business Entities
- **Restaurant Management** - Complete restaurant profiles
- **Customer Management** - Customer data and analytics
- **Order Processing** - Full order details
- **Menu Items** - Restaurant menu items
- **Delivery Drivers** - Driver assignment and tracking
- **Delivery Addresses** - Customer address management
- **Ratings & Reviews** - Restaurant rating system
- **Coupon System** - Discount and promotion management

## 🏗️ Architecture

### Backend (Port: Configurable)
```
src/main/java/com/foodservice/
├── 📁 controller/     # REST API endpoints
├── 📁 service/        # Business logic layer
├── 📁 repository/     # Data access layer
├── 📁 entity/         # JPA entities & DTOs
├── 📁 security/       # JWT & Security config
├── 📁 exception/      # Global exception handlers
├── 📁 config/         # Application configuration
└── 📁 constants/      # Application constants
```

## 🛠️ Technology Stack

### Backend
- **Java 21** - Latest Java LTS version
- **Spring Boot 3.5.12** - Modern Spring framework
- **Spring Data JPA** - Database abstraction
- **MySQL** - Primary database
- **JWT (JJWT)** - Token-based authentication
- **Lombok** - Code generation
- **Maven** - Build & dependency management

### Frontend
- **Spring Boot 3.5.13** - Server-side rendering
- **Thymeleaf** - Template engine
- **WebFlux** - Reactive web client
- **Vanilla JavaScript** - Interactive features

## 🚀 Quick Start

### Prerequisites
- **Java 21** or higher
- **Maven 3.8** or higher
- **MySQL 8.0** or higher
- **Git**

### 1. Clone the Repository
```bash
git clone https://github.com/your-username/food-delivery.git
cd food-delivery
```

### 2. Configuration
```bash
# Copy and configure application properties
cp src/main/resources/application.yaml.sample src/main/resources/application.yaml
```

Edit `application.yaml` with your database credentials:
```yaml
server:
  port: 8081

spring:
  application:
    name: food-service-backend
  datasource:
    url: jdbc:mysql://localhost:3306/food_service_db
    username: your_username
    password: your_password
    driver-class-name: com.mysql.cj.jdbc.Driver
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    database-platform: org.hibernate.dialect.MySQLDialect
```

### 3. Build & Run Backend
```bash
# Build the project
mvn clean install

# Run the backend API
mvn spring-boot:run
```

The backend API will be available at `http://localhost:8081`

### 4. Build & Run Frontend
```bash
# Navigate to frontend directory
cd frontend

# Build and run frontend
mvn clean install
mvn spring-boot:run
```

The frontend dashboard will be available at `http://localhost:8080`

## 📡 API Documentation

### Authentication Endpoints
```
POST /api/v1/auth/login    # User login
GET  /api/v1/auth/logout   # User logout
```

### GET API Endpoints

#### Restaurant Management
```
GET  /api/v1/restaurants/fetch              # List all restaurants (Page<RestaurantResponseDTO>)
GET  /api/v1/restaurants/ratings/{id}       # Get restaurant ratings (Page<RatingResponseDTO>)
GET  /api/v1/restaurants/top-rated           # Get top-rated restaurants (Page<TopRatedRestaurantDTO>)
```

#### Customer Management
```
GET  /api/v1/customers                       # List all customers (List<CustomerDTO>)
GET  /api/v1/customers/{customerId}          # Get customer details (CustomerDTO)
GET  /api/v1/customers/city                  # Get customers by city (List<CustomerDTO>)
GET  /api/v1/customers/{customerId}/addresses # Get customer addresses (List<DeliveryAddressDTO>)
GET  /api/v1/customers/{customerId}/orders   # Get customer orders (List<OrderItemDetailDTO>)
GET  /api/v1/customers/{customerId}/address-count # Get customer address count (Integer)
GET  /api/v1/customers/{customerId}/analytics # Get customer analytics (CustomerAnalyticsDTO)
```

#### Order Management
```
GET  /api/v1/orders/customer/{customerId}    # Get orders by customer (OrderCustomerPageDTO)
GET  /api/v1/orders/detail/{orderId}         # Get order details (OrderWithItemDTO)
GET  /api/v1/orders/revenue/restaurant/{id}   # Get restaurant revenue (RestaurantRevenueDTO)
```

#### Menu Items
```
GET  /api/v1/menu-item/fetchByRestaurant/{restaurantId} # Get restaurant menu (Page<MenuItemResponseDTO>)
```

#### Delivery Drivers
```
GET  /api/v1/drivers                         # List all drivers (List<DeliveryDriverResponseDTO>)
GET  /api/v1/drivers/{driverId}              # Get driver by ID (DeliveryDriverResponseDTO)
GET  /api/v1/drivers/sorted                  # Get all drivers sorted (List<DeliveryDriverResponseDTO>)
GET  /api/v1/drivers/{driverId}/deliveries   # Get driver deliveries (List<DeliveryDriverResponseDTO>)
GET  /api/v1/drivers/{driverId}/orders        # Get driver orders (List<DeliveryDriverResponseDTO>)
GET  /api/v1/drivers/{driverId}/customers     # Get driver customers (List<DeliveryDriverResponseDTO>)
GET  /api/v1/drivers/{driverId}/customers/{customerId}/orders # Get specific customer orders (List<DeliveryDriverResponseDTO>)
GET  /api/v1/drivers/{driverId}/restaurants  # Get driver restaurants (List<DeliveryDriverResponseDTO>)
GET  /api/v1/drivers/{driverId}/total-orders # Get total orders count (Integer)
```

#### Delivery Addresses
```
GET  /api/v1/delivery-address/addresses/{addressId} # Get address by ID (DeliveryAddressDTO)
GET  /api/v1/delivery-address/addresses/city       # Get addresses by city (List<DeliveryAddressDTO>)
```

#### Coupons
```
GET  /api/v1/coupons/order/{id}               # Get coupons by order (List<OrderCouponDTO>)
```

#### Health Check
```
GET  /api/v1/health                          # Application health check
```

## 🎯 Frontend Features

### Dashboard Pages
- **👥 Customers** - Customer management and analytics
- **🍽️ Restaurants** - Restaurant management
- **📦 Orders** - Order processing and tracking
- **🚚 Delivery** - Driver management
- **📍 Addresses** - Delivery address management
- **⭐ Ratings** - Restaurant ratings and reviews
- **💰 Revenue** - Revenue analytics and reports

### UI Components
- **Interactive Tables** - Sort, filter, and paginate data
- **Modal Dialogs** - Forms and confirmations
- **Error Handling** - User-friendly error messages
- **Search & Filter** - Advanced data filtering

## 🔐 Security Features

- **JWT Authentication** - Secure token-based auth
- **HTTP-Only Cookies** - Prevent XSS attacks
- **Password Encryption** - BCrypt password hashing

## 🧪 Testing

### Run Unit Tests
```bash
# Run all tests
mvn test

# Run specific test class
mvn test -Dtest=OrderControllerTest
```

## 📦 Deployment

### Production Build
```bash
# Build backend JAR
mvn clean package

# Build frontend JAR
cd frontend && mvn clean package
```

## 🔄 Continuous Integration

### GitHub Actions Workflow
```yaml
name: CI Pipeline
on:
  push:
    branches: [ main, develop ]
  pull_request:
    branches: [ main ]

jobs:
  test:
    runs-on: ubuntu-latest
    steps:
    - uses: actions/checkout@v3
    - name: Set up JDK 21
      uses: actions/setup-java@v3
      with:
        java-version: '21'
        distribution: 'temurin'
    - name: Run tests
      run: mvn test
    - name: Build project
      run: mvn clean package
```

---

<div align="center">
  <strong>🍽️ Built with passion 🍽️</strong>
</div>
