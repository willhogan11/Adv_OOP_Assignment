# Adv_OOP_Assignment

- **Student Name:** Will Hogan
- **Student Number:** G00318460
- **College Name:** GMIT
- **Course:** Software Development
- **Module:** Advanced Object Oriented Programming
- **Lecturer:** John Healy
- **Current College Year:** 4th Year 
- **Project Title:** Measuring Stability Using the Reflection API

---

# Application Overview
I have created a Java application that uses reflection to analyse an arbitrary Java Application Archive (JAR) and calculates the positional stability of each of the component classes in its object graph. 

Each class within the Jar file is extracted and analysed and various performance metrics are calculated based on various couplings. 

#### Afferent Couplings 
This refers to the In Degree or the number of edges incident on a type, i.e. the number of
types with a dependency on another type.

#### Efferent Couplings
This refers to the Out Degree or the number of edges emanating from a type, i.e. the number
of types that a given type is dependent upon.

#### Positional Stabilitity
The stability can be anything from 0 - 1, where 0 would be considered very stable and 1 not stable at all.
The stability is calculated / measured by counting the number of dependencies that enter and leave that type. 

The formula can be written as; 

### _I = ce / ca + ce_
Where **_I_** is the Positional Stability, **_ce_** represents the Efferent Couplings and **_ca_** the Afferent couplings.
Once calculated, the results are returned to the Graphical Swing Table that displays the metrics for each class. 

---

# Object Oriented design and Design Pattern implementation

From the outset, i developed my application to be as OOP friendly as possible. I have used the various fundamental pillars of Object oriented Programming throughout the application.

#### Abstraction 
Within this application, I have tried to adhere to the _'Work to an Abstraction and not a Concrete class'_ type of approach.
With this in mind, i created interfaces to not only abstract and decouple, but to also eliminate the possibility of introducing circular dependencies within my program. Another benefit of using an interface, is that it provides an opportunity to create any desired implementation, without having to change the functionality of the Application, which is essential for promoting **Loose Coupling**.

#### Composition
For this appliation, I favoured composition over specification inheritance, and used the 'HAS-A' rule to promote reuse well throughout my classes. An example of this would be the Classes ```CalculateMetrics``` and ```ListClass```. The Former class needs to have a List of class names that the latter provides. So we say that the ```CalculateMetrics``` class 'HAS-A' relationship with the ```ListClass``` class. I also used Delegation within the ```ListClass```, which is essentially a Customised version of the ```java.util.List``` package. I used the 'Override Implement Methods' in Eclipse to allow me to pick and choose methods from that package that suited me. 

#### Encapsulation
The process of data hiding was used throughout all relevant classes in this application. For example all instance variables within a class have been declared as private to stop any access from outside the class. I used mutator methods (getters and setters) to alter the state of these variables where required. 

#### Inheritance (Implementation)
As briefly mentioned, i used composition frequently in my application, however i did use Implementation Inheritance in the form of a classes implementing a specific Interface. This allows for multiple interface implementations, whereas specification doesn't permit multiple inheritance at all. 

#### Single Responsibility Principle


---

# Extras Added

### Swing GUI implementation

### Java Docs

### UML Diagram (See Below)

--- 

# GitHub Project Management

I extensively used github services to manage my Commits, Branches, Issues and Milestones (All issues and milestones are closed now, but they can still be viewed).

--- 

# Execution Instructions

--- 

# UML Class Diagram
