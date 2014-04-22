package net.tanerdiler.nn.training;
import java.util.ArrayList;
import java.util.List;



public class TraningSet
{
    private List<TrainingInput> inputs = new ArrayList<TrainingInput>();
    private List<TrainingOutput> outputs = new ArrayList<TrainingOutput>();
    
    private int currentIndex = -1;
    
    public TraningSet (List<TrainingInput> inputs, List<TrainingOutput> outputs) {
        this.inputs = inputs;
        this.outputs = outputs;
    }
    
    public boolean next () {
        currentIndex++;
        if (currentIndex >= size()) {
            currentIndex = 0;
        }
        return true;
    }
    
    public int size () {
        return inputs.size();
    }
    
    public TrainingOutput output()
    {
        return outputs.get(currentIndex);
    }
    
    public TrainingInput input()
    {
        return inputs.get(currentIndex);
    }

}
