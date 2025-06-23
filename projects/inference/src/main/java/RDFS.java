import org.apache.jena.rdf.model.InfModel;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.reasoner.Reasoner;
import org.apache.jena.reasoner.ReasonerRegistry;
import org.apache.jena.riot.RDFDataMgr;

public class RDFS {
    public static void run(String tbox, String abox) {
        Model schema = RDFDataMgr.loadModel(tbox);
        Model model = RDFDataMgr.loadModel(abox);
        Reasoner reasoner = ReasonerRegistry.getRDFSReasoner();
        // Reasoner reasoner = ReasonerRegistry.getOWLReasoner();
        InfModel inf_model = ModelFactory.createInfModel(reasoner, schema, model);
        inf_model.write(System.out, "TURTLE");
    }
}