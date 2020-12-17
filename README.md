
# Insurance policy

1.The project has developed a data model for the simplified field of insurance:
#### * OSAGO - compulsory insurance
#### * CASCO - voluntary insurance
2. Implemented the ability to print the contents of the insurance policy in JSON and XML formats 

## Version: 1.0
 [InsurancePolicy](https://github.com/AndreiKviatkouski/InsurancePolicy)

# Using
```
git clone https://github.com/AndreiKviatkouski/InsurancePolicy
cd InsurancePolicy
mvnw spring-boot:run
```
## Technological Stack
*   Spring Boot 2.3.4-RELEASE
*   Spring Boot Web
*   Spring Boot Devtools
*   Spring Boot Data Jpa
*   Project Lombok
*   PostgreSQL
*   Hibernate Validator 6.1.6.Final

## Dependencies

 <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
           <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-validator</artifactId>
            <version>6.1.6.Final</version>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>com.fasterxml.jackson.dataformat</groupId>
            <artifactId>jackson-dataformat-xml</artifactId>
        </dependency>
    </dependencies>
    
   
 ## Database configuration
 spring.datasource.url=jdbc:postgresql://localhost:5432/insurance
 spring.datasource.username={login}
 spring.datasource.password={password}
 
 ## Available endpoints
 
 `http://localhost:8080/client` - client page
 
 `http://localhost:8080/form` - insurance form page.
 
  ## Repo owner: Andrei Kviatkouski
  

