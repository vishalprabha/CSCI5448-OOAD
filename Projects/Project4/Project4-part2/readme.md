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



### Abstract Factory


# Assumptions and implementations


Assumptions:
- In the command line interface, buying and selling items from/to the customer is randomized.
- Both stores are initialized for the next day before command line interface is presented to the user.

- **The output file generation is specific to mac systems and its required to already have the "outputs" directory.**


# Changes in UML compared to previous submission
- Added SimulationInvoker, SimulationCommand and additional methods to Simulation and MusicStore class.
