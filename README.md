# Difference Between URI and URL

**URI (Uniform Resource Identifier):**
- A URI is a string that uniquely identifies a resource on the internet or a local network.
- It can be further classified as a URL or a URN.
- Example: `https://example.com/resource`, `urn:isbn:0451450523`

**URL (Uniform Resource Locator):**
- A URL is a type of URI that not only identifies a resource but also provides a means of locating it by describing its primary access mechanism (such as its network location).
- Every URL is a URI, but not every URI is a URL.
- Example: `https://example.com/index.html`, `ftp://ftp.example.com/file.txt`

**Key Differences:**
- A URI can be a name, a location, or both for a resource, while a URL is always a locator (it tells you how to access the resource).
- All URLs are URIs, but URNs (Uniform Resource Names) are URIs that are not URLs.

**Summary Table:**

| Feature | URI | URL |
|---------|-----|-----|
| Identifies resource | Yes | Yes |
| Locates resource | Sometimes | Always |
| Example | urn:isbn:0451450523 | https://example.com |

# Interceptors in Spring Boot

## Important Information to Note

- **Purpose**: Interceptors are used to intercept HTTP requests and responses in Spring MVC. They allow pre-processing and post-processing of web requests.
- **Common Use Cases**: Logging, authentication, authorization, modifying requests/responses, measuring execution time, etc.
- **Implementation**: Implement the `HandlerInterceptor` interface or extend `HandlerInterceptorAdapter` (deprecated in recent Spring versions).
- **Methods**:
	- `preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)`: Called before the controller method. Return `true` to continue, `false` to abort.
	- `postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)`: Called after the controller method, before the view is rendered.
	- `afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)`: Called after the complete request has finished.
- **Registration**: Interceptors are registered via a `WebMvcConfigurer` implementation using the `addInterceptors` method.
- **Order**: Multiple interceptors can be chained. The order of execution is the order of registration.
- **Difference from Filters**: Filters are part of the Servlet specification and work at a lower level, while interceptors are specific to Spring MVC and work at the controller level.


## Interview Questions and Answers on Interceptors

1. **What is an interceptor in Spring MVC and how is it different from a filter?**
	- An interceptor is a component in Spring MVC that allows you to intercept HTTP requests and responses at the controller level. Filters are part of the Servlet API and work at a lower level, before the request reaches the DispatcherServlet. Interceptors are more tightly integrated with Spring and can access Spring-specific features.

2. **What are the main methods of the `HandlerInterceptor` interface and when are they called?**
	- `preHandle`: Called before the controller method. Used for pre-processing (e.g., authentication, logging).
	- `postHandle`: Called after the controller method, before the view is rendered. Used for modifying the ModelAndView.
	- `afterCompletion`: Called after the complete request has finished. Used for cleanup activities.

3. **How do you register an interceptor in a Spring Boot application?**
	- Implement the `HandlerInterceptor` interface, then register it by overriding the `addInterceptors` method in a class that implements `WebMvcConfigurer`.
	- Example:
	  ```java
	  @Configuration
	  public class WebConfig implements WebMvcConfigurer {
			@Override
			public void addInterceptors(InterceptorRegistry registry) {
				 registry.addInterceptor(new LoggingInterceptor());
			}
	  }
	  ```

4. **Can you modify the request or response in an interceptor? Give an example.**
	- Yes, you can modify headers, attributes, or even the body (with wrappers) in the request/response objects. For example, you can add a custom header in `postHandle`:
	  ```java
	  response.addHeader("X-Custom-Header", "value");
	  ```

5. **How do you stop the execution of a request in an interceptor?**
	- Return `false` from the `preHandle` method. This will prevent the controller from being executed and the response will be sent immediately.

6. **What is the order of execution if multiple interceptors are registered?**
	- Interceptors are executed in the order they are registered for `preHandle`, and in reverse order for `postHandle` and `afterCompletion`.

7. **What are some common use cases for interceptors?**
	- Logging, authentication, authorization, measuring execution time, modifying requests/responses, auditing, etc.

8. **How do you pass data from a preHandle to postHandle or afterCompletion?**
	- You can use the `HttpServletRequest`'s attributes to store data in `preHandle` and retrieve it in `postHandle` or `afterCompletion`:
	  ```java
	  request.setAttribute("startTime", System.currentTimeMillis());
	  ```

9. **What is the difference between `postHandle` and `afterCompletion`?**
	- `postHandle` is called after the controller method but before the view is rendered. `afterCompletion` is called after the entire request is completed, including view rendering. `afterCompletion` is useful for resource cleanup.

10. **How would you implement logging for all incoming requests using an interceptor?**
	 - Create an interceptor that logs request details in `preHandle` and/or `afterCompletion`. Register it via `WebMvcConfigurer`.
	 - Example:
		```java
		public class LoggingInterceptor implements HandlerInterceptor {
			 @Override
			 public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
				  System.out.println("Incoming request: " + request.getRequestURI());
				  return true;
			 }
		}
		```

What is Interceptors in Spring Boot?
Interceptors in Spring Boot are components that allow you to intercept and manipulate HTTP requests and responses before they reach the controller or after they leave the controller. They are typically used for cross-cutting concerns such as logging, authentication, authorization, and request modification.
Interceptors are implemented by creating a class that implements the HandlerInterceptor interface and overriding its methods: preHandle, postHandle, and afterCompletion. You can then register the interceptor with the Spring MVC configuration to apply it to specific URL patterns or all requests.
