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

### Command

There is a SimulationInvoker, SimulationCommand and a SimulationReceiver(simulation) class. Simulation receiver is passed to SimulationCommand and SimulationCommand is passed to SimulationInvoker. On receiving User's request, invoker invokes the command which in turn runs the receiver's respective execute functions.

### Singleton

Logger is lazily implemented to keep track of daily activities in separate files and tracker eagerly instantiated and is used to keep track of the items sold, bought and damaged by every clerk.

### Abstract Factory

Abstract factory has an abstract GuitarKitFactory class from which two concrete classes are implemented. The concrete classes are NorthSideFactory and SouthSideFactory, these two implementations are used to create objects of the custom guitar kit, that comprises of bridge, knob set, covers, neck, pickguard, pickups. We also have have an abstract class called CustomGuitar which has a price variable from which all the north side and south side guitar kit objects inherit. So in the command for the interactive user, based on the location chosen, the respective guitar kit objects are retrieved and presented to the user

# Assumptions and implementations

- Functional flow of components are moved to accommodate running two stores, initially the simulation was run in the store class, now a new class is created to handle the orchestration of the two store simultaneously.
- A pool of six clerk are initialized at the start and on a given day are alloted to a store based on the previously established conditions.
- We assumed given 3 clerks worked well for one store, we just doubled the number of clerks
- In case a clerk were to fall sick, he/she is replaced with another person to run the store.
- A new function in added in clerk to get the current system time
- In the command line interface, buying and selling items from/to the customer is randomized.
- Both stores are initialized for the next day before command line interface is presented to the user.
- The menu is show only the first time and the user is required to chose the store he wants to buy the custom guitar kit from.
- We assume that all the components of the custom guitar kit will be chosen and not skipped
- The Custom guitar kit once created is tracked as a Item and tabulated in the total when the store closes
- Abstract factory, command and singleton are implemented as per the description above
- The tracker is implemented with eager instantiation and the logger is implemented with lazy instantiation.
- Junit cases are written covering the functionality test of multiple components.
- **The output file generation is specific to mac systems and its required to already have the "outputs" directory.**
- **Prior to running the program, please clear the currently generated output files.**


# Changes in UML compared to previous submission

- Added SimulationInvoker, SimulationCommand and additional methods to Simulation and MusicStore class.
- The name of the store is propagated across functions where details are printed and announcements are done.
- No changes to abstract factory and singleton.
