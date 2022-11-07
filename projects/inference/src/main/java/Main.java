import org.apache.jena.rdf.model.InfModel;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.reasoner.Reasoner;
import org.apache.jena.reasoner.ReasonerRegistry;
import org.apache.jena.riot.RDFDataMgr;

public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: inference tbox.ttl abox.ttl");
            return;
        }
        Model model = RDFDataMgr.loadModel(args[1]);
        Model schema = RDFDataMgr.loadModel(args[0]);
        Reasoner rdfs_reasoner = ReasonerRegistry.getRDFSReasoner();
        InfModel inf_model = ModelFactory.createInfModel(rdfs_reasoner, schema, model);
        inf_model.write(System.out, "TURTLE");
    }
}