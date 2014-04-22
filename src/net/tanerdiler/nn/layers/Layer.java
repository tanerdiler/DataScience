package net.tanerdiler.nn.layers;

import java.util.ArrayList;
import java.util.List;

import net.tanerdiler.nn.activations.ActivationFunction;
import net.tanerdiler.nn.core.Neuron;


public abstract class Layer
{
    private String name;
    
    protected List<Neuron> neurons = new ArrayList<Neuron>();
    
    private Layer previous;
    private Layer next;
    
    protected Layer(String name, int neuronCount, ActivationFunction func)
    {
        this.name = name;
        for (int i=0;  i<neuronCount;  i++) {
            neurons.add(new Neuron(name+"N"+i, func));
        }
    }
    
    public void execute()
    {
        for (Neuron neuron : neurons){
            neuron.execute();
        }
    }
    
    public void add (Neuron neuron) {
        neurons.add(neuron);
    }
    
    public void connect (Layer layer) {
        layer.previous = this;
        this.next = layer;
        
        for (Neuron neuron : neurons) {
            this.next.connect(neuron);
        }
    }
    
    private void connect(Neuron neuronOnPreviousLayer)
    {
        for (Neuron neuron :  neurons) {
            neuronOnPreviousLayer.connect(neuron);
        }
    }

    public Layer previous () {
        return previous;
    }
    
    public Layer next () {
        return next;
    }
    
    public String name () {
        return name;
    }

    public void print()
    {
        for (Neuron neuron : neurons) {
            neuron.print();
        }
    }
}
