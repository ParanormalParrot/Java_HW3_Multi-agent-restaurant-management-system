import jade.content.onto.BasicOntology;
import jade.content.onto.Ontology;
import jade.content.onto.OntologyException;
import jade.content.schema.ConceptSchema;

public class CustomerOntology extends Ontology {
    public static final String ONTOLOGY_NAME = "CustomerOntology";

    private static final CustomerOntology instance = new CustomerOntology();

    public static CustomerOntology getInstance() {
        return instance;
    }

    private CustomerOntology() {
        super(ONTOLOGY_NAME, BasicOntology.getInstance());
        try {
            add(new ConceptSchema(ONTOLOGY_NAME), Customer.class);
        } catch (OntologyException ontologyException) {
            ontologyException.printStackTrace();
        }
    }
}
