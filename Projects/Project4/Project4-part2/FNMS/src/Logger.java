import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger implements MyListener{
    @Override
    public void notifyEvent(String event, int day, String name) {
        try {

            // Open given file in append mode by creating an
            // object of BufferedWriter class
            BufferedWriter bout = new BufferedWriter(new FileWriter("outputs/Logger-"+day+"-"+name+".txt", true));

            // Writing on output stream
            bout.write(event+"\n");
            // Closing the connection
            bout.close();
        }

        // Catch block to handle the exceptions
        catch (IOException e) {

            // Display message when exception occurs
            System.out.println("exception occurred" + e);
        }

    }

    private static Logger obj = new Logger();
    private Logger() {};
    public static Logger getInstance() {
        return obj;
    }
}