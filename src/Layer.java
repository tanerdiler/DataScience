import java.util.ArrayList;
import java.util.List;


public abstract class Layer
{
    private Type type;
    
    protected List<Neuron> neurons = new ArrayList<Neuron>();
    
    private Layer previous;
    private Layer next;
    
    protected Layer(int neuronCount, ActivationFunction func)
    {
        for (int i=0;  i<neuronCount;  i++) {
            neurons.add(new Neuron(func));
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
    
    public Type type () {
        return type;
    }
}
