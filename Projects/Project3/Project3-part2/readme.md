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

# OO patterns in code

### Decorator

The decorator pattern is used to sell additional accessory items when a stringed item is sold.
We decorate the item sold using the DecoratingItem class and apply the necessary conditions describe to sell additional accessories.
Once an item of stringed class is sold, we then check the probability of selling the defined accessories.
If there is chance of being sold the respective decorating class is called to sell and update the accessories accordingly.

### Strategy

The strategy pattern is used to assign the tune algorithm dynamically to a particular clerk at random. The different tune algorithm objects are created and then assigned to a clerk object when they are instantiated. The respective tune algorithms contain the tune logic method with the conditions described in the question.

### Observer

The observer pattern is used to publish the events of interest in order to keep track. 

<br>

# Assumptions and implementations

Changes to store:

1. Inorder to not place order for any new clothing items, a check is done at the DoInventory class(operation).
2. If an item being sold by a customer belongs to the clothing class, a tabulation is done using countClothing function and if clothing items are found to be zero, the clothing item being sold is not bought.
3.  The number of random buying customers were generated using a poisson distribution with help from logic present on stack overflow. Implement as a function in the OuterUtils class.

Changes to Clerks:

1. A new clerk object was created when musicStore class was instantiated, with a unique damage percentage of 10
2. After a clerk is chosen, logic has been built such that, there is a 10% change they fall sick. It’s assumed that only one clerk can fall sick and they will be replaced by another clerk if they are sick along with an announcement.

Changes to items:

1. New classes are added to the respective subclasses.
2. The equalized, tuned, and adjusted property are initially set to false when items are added to the inventory, placing an order, and when purchasing from a customer.
3. In the OpenTheStore class where buying and selling is orchestrated, when an item of type stringed, wind or players arrive, their respective probability of sale is increased based on the description if their respective boolean property is set true.

Assumptions:
1. The electric property of a stringed instrument is set to true or false randomly at each phase (inventory addition, purchase, and customer selling items).
2. The output file generation is specific to mac systems and its required to already have the outputs directory.



<br>

# Changes in UML compared to previous submission



# Note
