import java.util.Locale;
import java.util.Scanner;
public class Main {

    public static void main(String []args){
        int days = 30;
        Simulation sim = new Simulation();
        sim.runStores(days);

        days += 1;
        sim.initializeStores(days);
        SimulationInvoker invoker = new SimulationInvoker();
        SimulationCommand command = new SimulationCommand(sim); //command

        invoker.setCommand(command); //invoker
        sim.commandLineInterface(invoker, days);
        sim.finish(days);
    }
}
