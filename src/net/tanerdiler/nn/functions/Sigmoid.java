package net.tanerdiler.nn.functions;

public class Sigmoid
{
    public static double calc (double x) {
        return 1 / ( 1 + Math.exp(-x));
    }
    
    public static double derivative (double x) {
        double sigmoid = calc(x);
        return sigmoid * (1 - sigmoid);
    }
    
    public static void main (String[] args) {
        System.out.println("Sigmoid of 0.01 -> "+Sigmoid.calc(-0.06983245109484493+-0.5218221325888899));
        System.out.println("Sigmoid of 1000 -> "+Sigmoid.calc(1000));
        
        System.out.println("Derivative Sigmoid of 0.01 -> "+Sigmoid.derivative(0.01));
        System.out.println("Derivative Sigmoid of 1000 -> "+Sigmoid.derivative(1000));
    }
}
