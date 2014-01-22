
public class Synapse
{
    private double weight;
    private double trainingRate = 0.2;
    private double previousWeightDelta = 0.0;
    private double momentum = 0.5;
    
    private Neuron from;
    private Neuron to;
    
    public Synapse (Neuron from, Neuron to)
    {
        this.from = from;
        this.to = to;
        this.weight = (Math.random() * 2) - 1;
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

    public void propagate()
    {
        double currentWeightDelta = -1 * trainingRate * from.output() * to.sigma();
        this.weight += currentWeightDelta + momentum * previousWeightDelta;
        this.previousWeightDelta = currentWeightDelta;
    }
}
