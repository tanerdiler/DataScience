
public class Neuron
{
    private ActivationFunction  function;
    
    private Connections inputs = new Connections();
    private Connections outputs = new Connections();

    private double output;
    private double sigma;
    
    public Neuron () {
        this.function = new IneffectiveActivationFunction();
    }
    
    public Neuron (ActivationFunction function) {
        this.function = function;
    }
    
    public void setInitOutput (double value)
    {
        this.output = value;
    }
    
    public double execute () {
        output = function.calc(inputs.sum());
        return output;
    }
    
    public double output () {
        return output;
    }
    
    public void connect (Neuron to) {
        Connection connection = new Connection(this, to);
        outputs.add(connection);
        to.inputs.add(connection);
    }

    public void updateWeight()
    {
        inputs.update();
    }

    public void setSigma(double sigma)
    {
        this.sigma = sigma;
    }

    public double sumOfSigma()
    {
        return outputs.sumOfSigma();
    }

    public double sigma()
    {
        return sigma;
    }
}
