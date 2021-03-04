package semWeb;

import org.apache.jena.rdf.model.InfModel;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.reasoner.Reasoner;
import org.apache.jena.reasoner.ReasonerRegistry;
import org.apache.jena.reasoner.rulesys.GenericRuleReasoner;
import org.apache.jena.reasoner.rulesys.Rule;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.vocabulary.RDFS;

public class ReasoningRules {
    public static void main(String argv[]) {
        // Change these to your real path
        String data_name = argv[0]; // "colin.ttl";
        String schema_name = argv[1]; // "colin-schema.ttl";
        Model data = RDFDataMgr.loadModel(data_name).add(RDFDataMgr.loadModel(schema_name));

        String rules = "[rule1: (?p rdfs:subPropertyOf ?q) (?a ?p ?b) -> (?a ?q ?b)]";
        Reasoner reasoner = new GenericRuleReasoner(Rule.parseRules(rules));
        InfModel infmodel =  ModelFactory.createInfModel(reasoner, data);

        Resource colin = infmodel.getResource("ex:colin");
        System.out.println("Everything about colin:");
        PrintHelper.printStatements(infmodel, colin, null, null);
    }
}
