package net.tanerdiler.nn.layers;
import net.tanerdiler.nn.activations.SigmoidActivationFunction;
import net.tanerdiler.nn.core.Neuron;
import net.tanerdiler.nn.training.TrainingOutput;




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
            System.out.println("diff :: " + neuron.output() +" - "+trainingOutput.get(i)+" = "+diff);
            error += Math.pow(diff, 2);
            
            double sigma = neuron.output() * (1 - neuron.output()) * (neuron.output() - trainingOutput.get(i));
            
            neuron.setSigma (sigma);
            
            neuron.propagate();
        }
        
        this.error = (1/2) * error;
    }

}
