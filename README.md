# Spring Boot Authentication with Redis

A scalable Spring Boot authentication system leveraging Redis as a distributed cache to improve login performance and session management.

## Overview

This project demonstrates a modern approach to implementing authentication in Spring Boot applications using Redis for distributed caching. It's designed to handle high-volume login requests efficiently while maintaining security best practices.

## Features

- 🔐 Secure authentication with Spring Security
- ⚡ Fast session management using Redis
- 🔄 Distributed cache support for scalability
- 🎯 JWT token generation and validation
- 📊 Improved login performance
- 🛡️ Protection against common security vulnerabilities

## Technology Stack

- **Framework**: Spring Boot
- **Authentication**: Spring Security
- **Cache**: Redis
- **Language**: Java
- **Build Tool**: Maven/Gradle (specify your choice)

## Getting Started

### Prerequisites

- Java 8 or higher
- Redis server
- Maven/Gradle (choose your build tool)

### Installation

1. Clone the repository:
```bash
git clone https://github.com/JavaDeveloper-Sinku/springboot-auth-redis.git
cd springboot-auth-redis
```

2. Install dependencies:
```bash
mvn clean install
```

3. Configure Redis connection in `application.properties`:
```properties
spring.redis.host=localhost
spring.redis.port=6379
```

4. Run the application:
```bash
mvn spring-boot:run
```

## Configuration

Update your `application.properties` or `application.yml` file with your Redis configuration:

```properties
# Redis Configuration
spring.redis.host=localhost
spring.redis.port=6379
spring.redis.password=
spring.redis.timeout=2000ms

# JWT Configuration
jwt.secret=your-secret-key
jwt.expiration=3600000
```

## Usage

### Authentication Endpoints

- **POST** `/auth/register` - Register a new user
- **POST** `/auth/login` - User login (returns JWT token)
- **POST** `/auth/logout` - User logout
- **GET** `/auth/validate` - Validate token

### Example Request

```bash
curl -X POST http://localhost:8080/auth/login \
  -H "Content-Type: application/json" \
  -d '{"username":"user","password":"password"}'
```

## Performance Benefits

- **Session Caching**: User sessions stored in Redis for instant retrieval
- **Distributed Architecture**: Support for multiple server instances
- **Reduced Database Queries**: Frequently accessed data cached in memory
- **Scalability**: Handles concurrent users efficiently

## Project Structure

```
springboot-auth-redis/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/auth/
│   │   │       ├── config/
│   │   │       ├── controller/
│   │   │       ├── service/
│   │   │       ├── model/
│   │   │       └── repository/
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── pom.xml
└── README.md
```

## Contributing

Contributions are welcome! Please feel free to submit pull requests or open issues for bugs and feature requests.

## License

This project is open source and available under the MIT License.

## Author

**JavaDeveloper-Sinku**

## Support

For issues, questions, or suggestions, please open an issue on the [GitHub repository](https://github.com/JavaDeveloper-Sinku/springboot-auth-redis/issues).

---

Happy coding! 🚀
