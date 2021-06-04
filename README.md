# SpringFramework

# Why Spring?

Spring is a light weight framework easy to use. It is release around 2001 in parallel to EJB which had a bad reputation as the framework has several flaws and heavy code is required to build a application with it.

# What's in Spring 5?

Updated java minimum version to java 8

Deprecated legacy project like Velocity.

Added Spring Web Flux

# Spring Framework Overview

POJO - Plain old java objects.

Declarative programming using Spring Aspect Oriented Programming.

Spring container primary functions -

1. Create and manager objects ( Inversion of Control )
2. Inject Object's dependencies ( Dependency Injection )

## Inversion of Control

The approach is to outsource the object creation and management of objects.

**3 Methods of applying spring container**

1. XML configuration file
2. Java Annotations
3. Java Source Code

## Dependency Injection

The approach to full fill the needs of object creation and requirement.

**Injection Types**

1. Constructor Injection
2. Setter Injection

---

# XML Configuration

This is legacy system.

Process:

1. Configure Spring beans.

    ```xml
    <beans>
    	<bean id="someId" class="fullclasspath" />
    </beans>
    ```

2. Create a Spring container ( Application Context ).

    ```java
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("name_of_the_config_file.xml")
    ```

3. retrieve Spring Bean.

    ```java
    context.getBean("someId", Interface.class)
    ```

4. Dependency Injection
    1. Constructor

        ```xml
        <bean id="myCoach" class="com.codedevunlocked.iocdemo.BaseballCoach">
        		<constructor-arg ref="myFortune" />
        	</bean>
        ```

    2. Setter

        ```xml
        <bean id="myCoach" class="com.codedevunlocked.iocdemo.TrackCoach">
        		<property name="fs" ref="myFortune" />
        	</bean>
        ```

    3. Adding Literal Values

        ```xml
        <bean id="myCoach" class="com.codedevunlocked.iocdemo.TrackCoach">
        		<property name="fs" ref="myFortune" />
        		<property name="coachName" value="Shiv" />
        	</bean>
        ```

5. Creating a properties file

    ```java
    // Load a properties file
    <context:property-placeholder location="classpath:file.properties">

    // Reference the values from a properties file
    <bean id="myCoach" class="com.codedevunlocked.iocdemo.TrackCoach">
    		<property name="fs" ref="myFortune" />
    		<property name="coachName" value="${foo.coachname}" />
    	</bean>

    ```