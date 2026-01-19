package com.codesnippet.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    // --- Pointcut Examples for Different Designators ---

    // 1. execution: Matches execution of any method in ProductService
    // Example: Any method in ProductService
    // @Pointcut("execution(* com.codesnippet.demo.service.ProductService.*(..))")
    // private void anyMethodInProductService(){};

    // Example: Only addProduct method in ProductService
    // @Pointcut("execution(* com.codesnippet.demo.service.ProductService.addProduct(..))")
    // private void addProductExecution(){};

    // 2. within: Matches all join points (methods) within ProductService
    // @Pointcut("within(com.codesnippet.demo.service.ProductService)")
    // private void withinProductService(){};

    // 3. this: Matches join points where the proxy implements the given type (ProductService)
    // @Pointcut("this(com.codesnippet.demo.service.ProductService)")
    // private void proxyImplementsProductService(){};

    // 4. target: Matches join points where the target object is an instance of ProductService
    // @Pointcut("target(com.codesnippet.demo.service.ProductService)")
    // private void targetIsProductService(){};

    // 5. @annotation: Matches methods annotated with a specific annotation (e.g., @Deprecated)
    // @Pointcut("@annotation(java.lang.Deprecated)")
    // private void deprecatedMethods(){};

    // 6. @within: Matches types (classes) annotated with a specific annotation (e.g., @Service)
    // @Pointcut("@within(org.springframework.stereotype.Service)")
    // private void withinServiceAnnotatedClass(){};

    // 7. @target: Matches beans where the target class is annotated with a specific annotation
    // @Pointcut("@target(org.springframework.stereotype.Service)")
    // private void targetServiceAnnotatedClass(){};

    // 8. args: Matches methods with specific argument types (e.g., String)
    // @Pointcut("args(java.lang.String,..)")
    // private void methodsWithStringArg(){};

    @Pointcut("execution(* com.codesnippet.demo.service.ProductService.addProduct(..))")
    private void executionDesignator(){};

    @Pointcut("within(com.codesnippet.demo.service.ProductService)")
    private void withinDesignator(){};
    /*
        Before execution of addProduct the log is appeared , 
        execution is a designator
        (   * -> any return type
            function (com.codesnippet.demo.service.ProductService.addProduct(..))
            addProduct(..) -> accept any parameters
        )
    
    */
    @Before("withinDesignator()")
    public void log(){
        System.out.println("Aspect log is called before using within designator");
    }

    /*
        execution(* com.codesnippet.demo.service.ProductService.*
        include all the functions for this class

         execution(* com.codesnippet.demo.service.*
         include all the classes for this folder
    */

     @After("executionDesignator()")
    public void loggingAfter(){
        System.out.println("Aspect loggingAfter is called after annotation using executionDesignator");
    }

    @Around("execution(* com.codesnippet.demo.service.ProductService.addProduct(..))")
    public Object loggingAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println(" Log Aspect is called before the execution");
         Object obj = proceedingJoinPoint.proceed();
        System.out.println("Call after addProduct");
        return obj;
    }

    // @AfterReturning
    // @AfterThrowing

}
