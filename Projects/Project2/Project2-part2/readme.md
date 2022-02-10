# Team members
<br>

- **Srinivas Akhil Mallela**
- **Krishna Likhitha**
- **Vishal Prabhachandar**

<br>

# JDK versions used (respectively)
<br>

- Java JDK 17
- Java JDK 17
- Open JDK Amazon Corretto-11.0.13.8.1

 <br>

# OO concepts in code

- Mandolin.java - Inheritance
  - This class shows an example of multi level inheritance. Mondolin inherits from Stringed class, which in turn inherits from Instruments class and that inherits from Item class

- CleanTheStore.java - Polymorphism
  - Objects of subclasses are handled by a single Item reference

- CashRegister.java - Cohesion
  - Cash register.java is only about the cash register and the money in it

- listItemsSold - Identity
  - Holds objects of all subclasses with different identity. Every objects of same subclass have different identity

- MusicStore.java - Encapsulation
  - All the data is hidden and methods are properly specified.

- Clerk.java - Abstraction
 The clerk will perform the work related only to him

<br>

# Assumptions

- Random names are generated for the item name
- Assumed store simulation starts on a Monday
- Assuming CD class in player as PlayersCD so classes don't have the same names
- We will get random clerk using random function and verify that they have not worked continuously
- In PlaceAnOrder class the item of a particular type ordered will arrive on the same day. However, different items will arrive on different days.

<br>

# Changes in UML compared to previous submission

- Cables class name changed, misspelled as Cabels
- Variable access type changed to private or protected, was initially public
  - This was done as public getters and setters were used to manipulate them
- Additional functionality added to Utils class
    - getRandomSize function
    - getRandomCondition
    - getRandomInt
    - getRandomName
- Unwanted functions removed from Clerk class as clerk actions could be directly accessed from objects initialized through the constructor
- getAttribute function removed from Item abstract class as it was not required
- updateInventory function removed from inventory class as it was not required
- listItemsSold list moved from OpenTheStore class to MusicStore

Changes were made to remove redundancy or add missing functionality through additional functions. Bulk portion of UML, with regards to classes, inheritance, composition and orchestration flow didn't change much.

<a href="https://github.com/vishalprabha/CSCI5448-OOAD/blob/main/Projects/Project2/Project2-part2/UMLChanged.pdf"> Updated UML diagram </a>
<br>

# Note
- Ignore errors in PlaceAnOrder class line 149, the code functions as expected regardless
- Ignore errors in OuterUtils class line 102, the code functions as expected regardless
