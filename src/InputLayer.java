
public class InputLayer extends Layer
{
    public InputLayer(int neuronCount)
    {
        super(neuronCount, new IneffectiveActivationFunction());
    }
    
    public void input(TrainingInput input)
    {
        for (int i = 0; i<neurons.size(); i++) {
            neurons.get(i).setInitOutput(input.get(i));
        }
    }
}
