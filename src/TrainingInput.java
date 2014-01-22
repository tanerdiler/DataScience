import java.util.ArrayList;
import java.util.List;


public class TrainingInput
{
    private List<Double> inputs = new ArrayList<Double>();
    
    public TrainingInput (double... inputValues) {
        for (double value : inputValues) {
            inputs.add(value);
        }
    }

    public Double get (int i)
    {
        return inputs.get(i);
    }
    
    public TrainingInput add (Double value)
    {
        inputs.add(value);
        return this;
    }

}
