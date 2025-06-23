import org.apache.jena.rdf.model.InfModel;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.reasoner.rulesys.GenericRuleReasoner;
import org.apache.jena.reasoner.rulesys.Rule;
import org.apache.jena.reasoner.Reasoner;
import org.apache.jena.reasoner.ReasonerRegistry;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.vocabulary.ReasonerVocabulary;

public class RULES {
  public static void run(String rules, String data) {
    GenericRuleReasoner reasoner = new GenericRuleReasoner(Rule.rulesFromURL(rules));
    Model model = RDFDataMgr.loadModel(data);
    InfModel infmodel = ModelFactory.createInfModel(reasoner, model);
    infmodel.write(System.out, "TURTLE");
  }
}