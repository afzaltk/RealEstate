package fit5042.tutex;

import fit5042.tutex.repository.PropertyRepository;
import fit5042.tutex.repository.PropertyRepositoryFactory;
import fit5042.tutex.repository.entities.Property;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        System.out.println("5 Properties Created Succssfully");
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("Properties Listed below -");
        displayProperty();
        System.out.println("----------------------------------------------------------------------------------------");
        searchProperty();
        System.out.println("----------------------------------------------------------------------------------------");
    }

    private void createProperty() {
        try {
            propertyRepository.addProperty(new Property(1, "Lansdowne", 2, 300, 45000));
            propertyRepository.addProperty(new Property(2, "Stkilda", 3, 500, 55000));
            propertyRepository.addProperty(new Property(3, "Caulfield", 3,400, 40000));
            propertyRepository.addProperty(new Property(4, "clayton", 2, 600, 65000));
            propertyRepository.addProperty(new Property(5, "melbourne", 2, 300, 100000));
        } catch (Exception ex) {
            System.out.println("Property not created " + ex.getMessage());
        }
        
    }

    private void displayProperty() {
        try {
            for (Property property : propertyRepository.getAllProperties()) {
			System.out.println(property.toString());
		}
            
        } catch (Exception ex) {
            System.out.println("Property not listed : " + ex.getMessage());
        }
    }

    private void searchProperty() {
        try {
            Scanner sc=new Scanner(System.in);
            System.out.print("Enter the property ID to search ");
            int propertyId=sc.nextInt();
            Property propertyDetail=propertyRepository.searchPropertyById(propertyId);
            if (propertyDetail==null)
            {
                System.out.println("Propert does not exist");
            }
            else {
                System.out.println(propertyDetail.toString());
            }
        } catch (Exception ex) {
            Logger.getLogger(RealEstateAgency.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

}
