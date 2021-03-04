package semWeb;

import org.apache.jena.rdf.model.*;
import org.apache.jena.util.PrintUtil;

public class PrintHelper {
    public static void printStatements(InfModel infmodel, Resource s, Property p, Resource o) {
        for (StmtIterator i = infmodel.listStatements(s, p, o); i.hasNext(); ) {
            Statement stmt = i.nextStatement();
            System.out.println(" - " + PrintUtil.print(stmt));
        }
    }
}
