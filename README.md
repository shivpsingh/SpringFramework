# Learning Spring Framework

## Why Spring?

Spring is a lightweight framework easy to use. It is released around 2001 in parallel to EJB which had a bad reputation as the framework has several flaws and heavy code is required to build an application with it.

## What's in Spring 5?

Updated java minimum version to java 8

Deprecated legacy project like Velocity.

Added Spring Web Flux

## Spring Framework Overview

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

### Dependency Injection

The approach to full fill the needs of object creation and requirement.

**Injection Types**

1. Constructor Injection
2. Setter Injection

---

## XML Configuration

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

### Bean Scope

1. Singleton ( Default )
2. Prototype
3. request
4. session
5. global-session

```java
<bean id="myCoach"
		class="com.codedevunlocked.iocdemo.BaseballCoach"
		scope="prototype">
</bean>
```

### Bean Lifecycle

```java
<bean id="myCoach"
		class="com.codedevunlocked.iocdemo.BaseballCoach"
		scope="prototype"
		init-method="doInit"
		destroy-method="doClean">
</bean>
```

---

---

## Java Annotations

Special labels / markers added to Java Classes. Provide meta-data about class.

Spring will scan the whole project package specified as in xml.

```java
<context:component-scan base-package="come.example" />
```

### Adding Component Scan

Add annotation to specify bean id:

```java
@Component("beanId")
class Sample implements SomeInterface {}
```

or Add below annotation to specify bean id:

```java
@Component // default bean Id will be -- sampleClass
class SampleClass implements SomeInterface {}

```

### Add Auto wiring — Annotation dependency Injection

Spring can automatically search for a class with given property by type ( class or interface ) once find and inject it.

**3 type of injection**

1. Constructor Injection

    ```java
    @Component
    class SampleClass implements SampleInterface {
    	@AutoWired
    	SampleClass(DependClass db) {
    	}
    }

    interface DependClass {}

    @Component
    class SampleDependClass implements DependClass {
    }
    ```

2. Setter Injection

    ```java
    @Component
    class SampleClass implements SampleInterface {
    	@AutoWired
    	setSampleInterfaceDepend(DependClass s) {
    	}

    	// Note: Any method can be AutoWired it doesn't require to be a setter

    	@AutoWired
    	doSomeStuff(DependClass s) {
    	}

    }

    interface DependClass {}

    @Component
    class SampleDependClass implements DependClass {
    }
    ```

3. Fields Injection ( Uses Reflection Design Pattern )

    ```java
    @Component
    class SampleClass implements SampleInterface {
    	@AutoWired
    	DependClass s;

    }

    interface DependClass {}

    @Component
    class SampleDependClass implements DependClass {
    }
    ```

---

### Reflection Design Pattern

Can also be called **Class Manipulator.** 

( Manipulate fields, methods in a class - Can slow Program )

Reference: 

[https://www.youtube.com/watch?v=9IRQEd0I3vQ&list=PLL-4P1BOZnWygYW-VUcb-naU4Fp6ibwfz](https://www.youtube.com/watch?v=9IRQEd0I3vQ&list=PLL-4P1BOZnWygYW-VUcb-naU4Fp6ibwfz)

Sample Code block:

```java
public class SampleClass {}

import java.lang.reflect.*;

public class SampleReflect {

	public static void main(String[] args) {
		Class reflectClass = SampleClass.class;
		constructor = reflectClass.getConstructor(new Class[]{DependClass e});
		constructor.setSampleInterfaceDepend(DependClass e);
	}
}
```

---

## Bean Scope with Annotations

Default Scope of beans is - Singleton.

Apply scope with Annotations.

```java

@Component
@Scope("singleton")
@Scope("prototype")
class SampleClass implements SampleInterface {}
```

### Bean Life cycle

Calls Initialise method and destroyer method.

same as - in XML Configuration: [Learning Spring Framework](https://www.notion.so/Learning-Spring-Framework-c7e8700d71fb44609fe2f3cb907490cd) 

init-method

destroy-method

```java
@Component
class SampleClass implements SampleInterface {
	@PostConstruct
	init() {}

	@PreDestroy
	clean() {}
}
```

---

# Java Source Code - Configuration

There are three types of configurations:

1. Full XML Config
2. XML Component Scan
3. Java Configuration Class

```java
@Configuration
@ComponentScan("full_package_name")
class ConfigClass {
}

// In Main class

AnnotationConfigApplicationContext ct = new AnnotationConfigApplicationContext(
	Conflig.class
)
```

### Define Beans in Java Config Class

```java
// Dependent Class

@Component
class DependClass implements DependInterface {}

// Component Class

@Component
class SampleClass implements SampleInterface {
	SampleClass(DependInterface d) {}
}

// Configuration Class

@Configuration
class SampleConfig {
	@Bean
	DependInterface dependClass() {
		return new DependClass();
	}

	@Bean
	SampleInterface sampleClass() {
		return new SampleClass(dependClass());
	}
}

// Main Class

class MainClass {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ct = new AnnotationConfigApplicationContext(SampleConfig.class);
		ct.getBean("sampleClass", SampleInterface.class);
	}
}
```

### Add Properties file to Java Config

```java
// Component Class

@Component
class SampleClass implements SampleInterface {
	@Value("{foo.name}")
	String name;
}

// Configuration Class

@Configuration
@PropertySource("classpath:com.fullpackagename")
class SampleConfig {

}

```
