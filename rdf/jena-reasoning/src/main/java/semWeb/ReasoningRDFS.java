package semWeb;

import org.apache.jena.rdf.model.*;
import org.apache.jena.reasoner.Reasoner;
import org.apache.jena.reasoner.ReasonerRegistry;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.util.PrintUtil;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.RDFS;

public class ReasoningRDFS {
    public static void main(String argv[]) {
        // Change these to your real path
        String data_name = argv[0]; // "colin.ttl";
        String schema_name = argv[1]; // "colin-schema.ttl";
        Model data = RDFDataMgr.loadModel(data_name).add(RDFDataMgr.loadModel(schema_name));

        Reasoner rdfs_reasoner = ReasonerRegistry.getRDFSReasoner();
        InfModel infmodel =  ModelFactory.createInfModel(rdfs_reasoner, data);

        infmodel.write(System.out, "TURTLE");
    }
}
