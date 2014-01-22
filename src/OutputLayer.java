import static java.lang.String.format;



public class OutputLayer extends Layer
{
    private double error;

    public OutputLayer(int neuronCount)
    {
        super("O", neuronCount, new SigmoidActivationFunction());
    }
    
    public double error () {
        return this.error;
    }
    
    public void propagate (TrainingOutput trainingOutput)
    {
        double error = 0;
        for (int i = 0; i<neurons.size(); i++) {
            Neuron neuron = neurons.get(i);
            
            double diff = neuron.output() - trainingOutput.get(i);
            error += Math.pow(diff, 2);
            
            double sigma = neuron.output() * (1 - neuron.output()) * (neuron.output() - trainingOutput.get(i));
            
            neuron.setSigma (sigma);
            
            neuron.propagate();
        }
        
        this.error = (1/2) * error;
    }

}
