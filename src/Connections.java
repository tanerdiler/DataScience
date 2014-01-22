import java.util.ArrayList;
import java.util.List;


public class Connections
{
    private List<Connection> connections = new ArrayList<Connection>();
    
    public void add (Connection connection) {
        connections.add(connection);
    }

    public double sum()
    {
        double sum = 0;
        for (Connection connection : connections) {
            sum += connection.output();
        }
        return sum;
    }

    public void update()
    {
        for (Connection connection : connections) {
            connection.update();
        }
    }

    public double sumOfSigma()
    {
        double sumOfSigma = 0;
        for (Connection connection : connections) {
            sumOfSigma += connection.weight() * connection.to().sigma();
        }
        return sumOfSigma;
    }
}
