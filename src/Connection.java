
public class Connection
{
    private double weight;
    private double trainingRate = 0.2;
    
    private Neuron from;
    private Neuron to;
    
    public Connection (Neuron from, Neuron to)
    {
        this.from = from;
        this.to = to;
    }
    
    public double output ()
    {
        return weight * from.output();
    }
    
    public double weight ()
    {
        return weight;
    }
    
    public double input ()
    {
        return from.output();
    }
    
    public Neuron from ()
    {
        return from;
    }
    
    public Neuron to () {
        return to;
    }

    public void update()
    {
        this.weight -= trainingRate * from.output() * to.sigma();
    }
}
