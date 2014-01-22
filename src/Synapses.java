import java.util.ArrayList;
import java.util.List;


public class Synapses
{
    private List<Synapse> synapses = new ArrayList<Synapse>();
    
    public void add (Synapse synapse) {
        synapses.add(synapse);
    }

    public double sum()
    {
        double sum = 0;
        for (Synapse synapse : synapses) {
            sum += synapse.output();
        }
        return sum;
    }

    public void propagate()
    {
        for (Synapse synapse : synapses) {
            synapse.propagate();
        }
    }

    public double sumOfSigma()
    {
        double sumOfSigma = 0;
        for (Synapse synapse : synapses) {
            sumOfSigma += synapse.weight() * synapse.to().sigma();
        }
        return sumOfSigma;
    }

    public void print()
    {
        for (Synapse synapse : synapses) {
            System.out.println("w : "+synapse.weight()+" ; input : " + synapse.input() + " ; output " + synapse.output());
        }
    }
}
