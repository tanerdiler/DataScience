package net.tanerdiler.nn.core;
import net.tanerdiler.nn.activations.ActivationFunction;
import net.tanerdiler.nn.activations.LinearActivationFunction;


public class Neuron
{
    private ActivationFunction  function;
    
    private Synapses inputs = new Synapses();
    private Synapses outputs = new Synapses();

    private double output;
    private double sigma;
    private double bias = (Math.random() * 2) - 1;
    private double previousBiasDelta = 0;
    private double momentum = 0.5;
    private double trainingRate = 0.2;

    private String name;
    
    public Neuron () {
        this.function = new LinearActivationFunction();
    }
    
    public Neuron (String name, ActivationFunction function) {
        this.name = name;
        this.function = function;
    }
    
    public void setInitOutput (double value)
    {
        this.output = value;
    }
    
    public double execute () {
        output = function.calc(inputs.sum() + bias);
        return output;
    }
    
    public double output () {
        return output;
    }
    
    public void connect (Neuron to) {
        Synapse synapse = new Synapse(this, to);
        outputs.add(synapse);
        to.inputs.add(synapse);
    }

    public void propagate()
    {
        double currentBiasDelta = -1 * trainingRate * this.sigma + momentum * previousBiasDelta;
        this.bias += currentBiasDelta;
        this.previousBiasDelta = currentBiasDelta;
        
        inputs.propagate();
    }

    public void setSigma(double sigma)
    {
        this.sigma = sigma;
    }

    public double sumOfOutSynapseSigmas()
    {
        return outputs.sumOfSigma();
    }

    public double sigma()
    {
        return sigma;
    }

    public void print()
    {
        System.out.println(name + " : output =" + output );
        inputs.print();
    }
}
