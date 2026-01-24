1. There are two ways of using logs in Java Spring Boot applications: using the default logging framework (Logback) or by configuring a different logging framework (like Log4j2).
2. To use the default Logback logging framework, you can simply use the `Logger` class from the `org.slf4j` package. Here's an example:

```javaimport org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;  
@SpringBootApplication
public class MySpringBootApplication {
    private static final Logger logger = LoggerFactory.getLogger(MySpringBootApplication.class);   
      public static void main(String[] args) {
         SpringApplication.run(MySpringBootApplication.class, args);
         logger.info("Application started successfully.");
      }
}
```
3. If you want to use slf4j we use @Slf4j annotation from lombok library. Here's an example:

```javaimport lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
@Slf4j
public class MySpringBootApplication {

      public static void main(String[] args) {
         SpringApplication.run(MySpringBootApplication.class, args);
         log.info("Application started successfully.");
      }
   }
```
