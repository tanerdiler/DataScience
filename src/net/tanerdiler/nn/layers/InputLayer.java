package net.tanerdiler.nn.layers;
import net.tanerdiler.nn.activations.IneffectiveActivationFunction;
import net.tanerdiler.nn.training.TrainingInput;


public class InputLayer extends Layer
{
    public InputLayer(int neuronCount)
    {
        super("I", neuronCount, new IneffectiveActivationFunction());
    }
    
    public void input(TrainingInput input)
    {
        for (int i = 0; i<neurons.size(); i++) {
            neurons.get(i).setInitOutput(input.get(i));
        }
    }
}
