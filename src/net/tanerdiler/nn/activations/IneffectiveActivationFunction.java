package net.tanerdiler.nn.activations;

public class IneffectiveActivationFunction implements ActivationFunction
{
    public double calc(double x)
    {
        return x;
    }
}
