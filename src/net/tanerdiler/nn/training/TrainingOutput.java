package net.tanerdiler.nn.training;
import java.util.ArrayList;
import java.util.List;


public class TrainingOutput
{
    private List<Double> outputs = new ArrayList<Double>();
    
    public TrainingOutput (double... outputValues)
    {
        for (double value : outputValues) {
            outputs.add(value);
        }
    }

    public Double get (int i)
    {
        return outputs.get(i);
    }
    
    public void add (Double value)
    {
        outputs.add(value);
    }

}
