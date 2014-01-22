
public class HiddenLayer extends Layer
{
    protected HiddenLayer(int index, int neuronCount)
    {
        super("H"+index, neuronCount, new SigmoidActivationFunction());
    }

    public void propagate()
    {
        for (int i = 0;  i < neurons.size(); i++) {
            Neuron neuron = neurons.get(i);
            
            double sumOfSigmaToNextLayer = neuron.sumOfOutSynapseSigmas();
            
            double sigma = neuron.output() * (1 - neuron.output()) * sumOfSigmaToNextLayer;
            
            neuron.setSigma(sigma);
            
            neuron.propagate();
        }
    }
}
