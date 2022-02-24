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

The observer pattern is used to publish the events of interest to keep track. There are two observers which keep track of the events occurring. 
The tracker object is instantiated at the beginning and prints a tabulated report of all the items sold, purchased and damaged every day.
The Logger object is instantiated each day the store runs and prints human-readable events text to a logger file in the outputs directory for each day.

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

New behavior: 

All the new behavior is implemented as described in the UML and OO concepts section. 

Assumptions:
- The electric property of a stringed instrument is set to true or false randomly at each phase (inventory addition, purchase, and customer selling items).
- **The output file generation is specific to mac systems and its required to already have the "outputs" directory.**


# Changes in UML compared to previous submission

- Initial observer implementation is removed and new observer implementation is added.
The new observer contains one interface called MyListener which the observers extend from and we also
have an announcer class which contains a list of listeners and publishes events to the listeners. Finally 
we have two observer classes listening to any published message.

- The return types of the functions present in the Strategy design pattern classes were changed from void to boolean to
to account for tune change from true to false.

- The initial decorator implementation approach is removed. 
A new decorator is added to OpenTheStore class from which additional accessories(items) are sold
when a stringed item is bought.

- Two additional utility functions are added. One to generate a random probability based on double value and another to generate a random boolean value.

- The return type of orchestrate function in CleanTheStore class is changed from void to int to keep track of damaged items.

- The return type of doInventory function in Clerk class is changed from void to int to keep track of damaged items.

- Tune object variable is added to clerk. Additional variables are itemsSold, itemsDamaged and itemsPurchased to keep cumulative counts.

