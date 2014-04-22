package net.tanerdiler.nn.activations;
import net.tanerdiler.nn.functions.Sigmoid;


public class SigmoidActivationFunction implements ActivationFunction
{
    public double calc(double x)
    {
        return Sigmoid.calc(x);
    }
}
