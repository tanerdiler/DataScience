
public class HiddenLayer extends Layer
{
    protected HiddenLayer(int neuronCount)
    {
        super(neuronCount, new SigmoidActivationFunction());
    }

    public void updateWeight()
    {
        for (int i = 0;  i < neurons.size(); i++) {
            Neuron neuron = neurons.get(i);
            
            double sumOfSigmaToNextLayer = neuron.sumOfSigma();
            
            double sigma = neuron.output() * (1 - neuron.output()) * sumOfSigmaToNextLayer;
            
            neuron.setSigma(sigma);
            
            neuron.updateWeight();
        }
    }
}
