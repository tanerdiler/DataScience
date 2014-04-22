package net.tanerdiler.nn;
import java.util.ArrayList;
import java.util.List;

import net.tanerdiler.nn.layers.HiddenLayer;
import net.tanerdiler.nn.layers.InputLayer;
import net.tanerdiler.nn.layers.Layer;
import net.tanerdiler.nn.layers.OutputLayer;
import net.tanerdiler.nn.training.TrainingInput;
import net.tanerdiler.nn.training.TrainingOutput;
import net.tanerdiler.nn.training.TraningSet;


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
                HiddenLayer layer = new HiddenLayer(i, counts[i]);
                hiddenLayers.add(layer);
                currentLayer = layer;
            }
            
            if (previousLayer != null) {
                previousLayer.connect(currentLayer);
            }
            
            previousLayer = currentLayer;
        }
    }
    
    public void ask (TraningSet trainingSet) {
        this.trainingSet = trainingSet;
        
        trainingSet.next();
        
        inputLayer.input(trainingSet.input());

        for (int i = 0; i < hiddenLayers.size(); i++) {
            HiddenLayer layer = hiddenLayers.get(i);
            layer.execute();
        }
        
        outputLayer.execute();
        
        outputLayer.print();   
    }
    
    public void train (TraningSet trainingSet) {
        this.trainingSet = trainingSet;
        

        for (int k = 0; k < 2000; k++) {
            trainingSet.next();
            
            inputLayer.input(trainingSet.input());

            for (int i = 0; i < hiddenLayers.size(); i++) {
                HiddenLayer layer = hiddenLayers.get(i);
                layer.execute();
            }
            
            outputLayer.execute();
            
            System.out.println("AFTER EXECUTION");
            
//            for (int i = 0; i < hiddenLayers.size(); i++) {
//                HiddenLayer layer = hiddenLayers.get(i);
//                layer.print();
//            }
            
//            outputLayer.print();
            
            outputLayer.propagate(trainingSet.output());
            
            for (int i = hiddenLayers.size() - 1; i >= 0 ; i--) {
                HiddenLayer layer = hiddenLayers.get(i);
                layer.propagate();
            }
            
            System.out.println("AFTER PROPAGATION");
            
//            for (int i = 0; i < hiddenLayers.size(); i++) {
//                HiddenLayer layer = hiddenLayers.get(i);
//                layer.print();
//            }
            
//            outputLayer.print();            
        }
    }
    
    public static void main (String[] args) {
        Network network = new Network(8,8,8);
        List<TrainingInput> inputs = new ArrayList<TrainingInput>();
        List<TrainingOutput> outputs = new ArrayList<TrainingOutput>();
        
        inputs.add(new TrainingInput(0, 0, 0, 0, 0, 0, 0, 0));
        inputs.add(new TrainingInput(1, 0, 0, 0, 0, 0, 0, 0));
        inputs.add(new TrainingInput(0, 1, 0, 0, 0, 0, 0, 0));
        inputs.add(new TrainingInput(1, 1, 0, 0, 0, 0, 0, 0));
        inputs.add(new TrainingInput(0, 0, 1, 0, 0, 0, 0, 0));
        inputs.add(new TrainingInput(1, 0, 1, 0, 0, 0, 0, 0));
        inputs.add(new TrainingInput(0, 1, 1, 0, 0, 0, 0, 0));
        inputs.add(new TrainingInput(1, 1, 1, 0, 0, 0, 0, 0));
        inputs.add(new TrainingInput(0, 0, 0, 1, 0, 0, 0, 0));
        inputs.add(new TrainingInput(1, 0, 0, 1, 0, 0, 0, 0));
        inputs.add(new TrainingInput(0, 1, 0, 1, 0, 0, 0, 0));
        inputs.add(new TrainingInput(0, 0, 0, 0, 1, 0, 0, 0));
        
        
        outputs.add(new TrainingOutput(0, 0, 0, 0, 0, 0, 0, 0)); 
        outputs.add(new TrainingOutput(1, 0, 0, 0, 0, 0, 0, 0));
        outputs.add(new TrainingOutput(0, 0, 1, 0, 0, 0, 0, 0));
        outputs.add(new TrainingOutput(1, 0, 0, 1, 0, 0, 0, 0));
        outputs.add(new TrainingOutput(0, 0, 0, 0, 1, 0, 0, 0));
        outputs.add(new TrainingOutput(1, 0, 0, 1, 1, 0, 0, 0));
        outputs.add(new TrainingOutput(0, 0, 1, 0, 0, 1, 0, 0));
        outputs.add(new TrainingOutput(1, 0, 0, 0, 1, 1, 0, 0));
        outputs.add(new TrainingOutput(0, 0, 0, 0, 0, 0, 1, 0));
        outputs.add(new TrainingOutput(1, 0, 0, 0, 1, 0, 1, 0));
        outputs.add(new TrainingOutput(0, 0, 1, 0, 0, 1, 1, 0));
        outputs.add(new TrainingOutput(1, 0, 0, 0, 0, 1, 1, 1));
        
        TraningSet trainingSet = new TraningSet(inputs, outputs);
        
        network.train(trainingSet);
//        System.out.println("");
//        System.out.println("");
//        inputs = new ArrayList<TrainingInput>();
//        inputs.add(new TrainingInput(1, 0, 0, 0, 0, 0, 0, 0));
//        trainingSet = new TraningSet(inputs, outputs);
//        network.ask(trainingSet);
//        
//        System.out.println("");
//        System.out.println("");
//        inputs = new ArrayList<TrainingInput>();
//        inputs.add(new TrainingInput(1, 1, 0, 0, 0, 0, 0, 0));
//        trainingSet = new TraningSet(inputs, outputs);
//        network.ask(trainingSet);
//        
//        System.out.println("");
//        System.out.println("");
//        inputs = new ArrayList<TrainingInput>();
//        inputs.add(new TrainingInput(1, 1, 1, 0, 0, 0, 0, 0));
//        trainingSet = new TraningSet(inputs, outputs);
//        network.ask(trainingSet);
        
        
        System.out.println("");
        System.out.println("");
        inputs = new ArrayList<TrainingInput>();
        inputs.add(new TrainingInput(1, 0, 0, 1, 0, 0, 0, 0));
        trainingSet = new TraningSet(inputs, outputs);
        network.ask(trainingSet);
        
        System.out.println("");
        System.out.println("");
        inputs = new ArrayList<TrainingInput>();
        inputs.add(new TrainingInput(0, 0, 1, 1, 0, 0, 0, 0));
        trainingSet = new TraningSet(inputs, outputs);
        network.ask(trainingSet);
    }
    
}
