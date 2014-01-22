import java.util.ArrayList;
import java.util.List;


public class Network
{
    private InputLayer inputLayer;
    private List<HiddenLayer> hiddenLayers = new ArrayList<HiddenLayer>();
    private OutputLayer outputLayer;
    private TraningSet trainingSet;
    
    public Network (int... counts)
    {
        Layer previousLayer = null;
        Layer currentLayer = null; 
        for (int i = 0; i<counts.length; i++) {
            
            if (i == 0) {
                inputLayer = new InputLayer(counts[i]);
                currentLayer = inputLayer;
            } else if (i == (counts.length - 1)) {
                outputLayer = new OutputLayer(counts[i]);
                currentLayer = outputLayer;
            } else {
                HiddenLayer layer = new HiddenLayer(counts[i]);
                hiddenLayers.add(layer);
                currentLayer = layer;
            }
            
            if (previousLayer != null) {
                previousLayer.connect(currentLayer);
            }
            
            previousLayer = currentLayer;
        }
    }
    
    public void train (TraningSet trainingSet) {
        this.trainingSet = trainingSet;
        
        trainingSet.next();
        
        inputLayer.input(trainingSet.input());

        for (int k = 0; k < 100000000; k++) {
            for (int i = 0; i < hiddenLayers.size(); i++) {
                HiddenLayer layer = hiddenLayers.get(i);
                layer.execute();
            }
            
            outputLayer.execute();
            
            outputLayer.updateWeight(trainingSet.output());
            
            for (int i = hiddenLayers.size() - 1; i >= 0 ; i--) {
                HiddenLayer layer = hiddenLayers.get(i);
                layer.updateWeight();
            }
            
            outputLayer.print();            
        }
    }
    
    public static void main (String[] args) {
        Network network = new Network(2,3,1);
        List<TrainingInput> inputs = new ArrayList<TrainingInput>();
        List<TrainingOutput> outputs = new ArrayList<TrainingOutput>();
        
        inputs.add(new TrainingInput(1,1));
        
        outputs.add(new TrainingOutput(2));
        
        TraningSet trainingSet = new TraningSet(inputs, outputs);
        network.train(trainingSet);
    }
    
}
