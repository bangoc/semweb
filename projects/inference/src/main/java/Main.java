import org.apache.jena.rdf.model.InfModel;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.reasoner.Reasoner;
import org.apache.jena.reasoner.ReasonerRegistry;
import org.apache.jena.riot.RDFDataMgr;

public class Main {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: inference RDFS tbox.ttl abox.ttl");
            return;
        }
        if (args[0].equals("RDFS")) {
            RDFS.run(args[1], args[2]);
        } else if (args[0].equals("RULES")) {
            RULES.run(args[1], args[2]);
        }
    }
}