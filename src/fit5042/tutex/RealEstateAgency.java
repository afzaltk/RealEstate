package fit5042.tutex;

import fit5042.tutex.repository.PropertyRepository;
import fit5042.tutex.repository.PropertyRepositoryFactory;
import fit5042.tutex.repository.entities.Property;

/**
 *
 * TODO Exercise 1A Step 3 Complete this class. Please refer to tutorial
 * instructions. This is the main driver class. This class contains the main
 * method for Exercise 1A
 *
 * This program can run without the completion of Exercise 1B.
 *
 * @author Jian
 */
public class RealEstateAgency {

    private String name;
    private final PropertyRepository propertyRepository;

    public RealEstateAgency(String name) throws Exception {
        this.name = name;
        System.out.println(name);
        this.propertyRepository = PropertyRepositoryFactory.getInstance();
    }
     public static void main(String[] args) {
         System.out.println("Real Estate Agency");
        try {
            new RealEstateAgency("Welcome").runMethods();
        } catch (Exception ex) {
            System.out.println("Failed to run" + ex.getMessage());
        }
     }

    private void runMethods() {
        createProperty();
        System.out.println("----------------------------------------------------------------------------------------");
    }

    private void createProperty() {
        try {
            propertyRepository.addProperty(new Property(1, "Lansdowne", 300, 45000));
            propertyRepository.addProperty(new Property(2, "Stkilda", 500, 55000));
            propertyRepository.addProperty(new Property(3, "Caulfield", 400, 40000));
            propertyRepository.addProperty(new Property(4, "clayton", 600, 65000));
            propertyRepository.addProperty(new Property(5, "melbourne", 300, 100000));
        } catch (Exception ex) {
            System.out.println("Property not created " + ex.getMessage());
        }
        
    }

}
