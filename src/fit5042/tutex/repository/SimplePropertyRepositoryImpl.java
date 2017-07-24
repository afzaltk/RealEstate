/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.repository;

import fit5042.tutex.repository.entities.Property;
import java.util.ArrayList;
import java.util.List;
import jdk.nashorn.internal.runtime.PropertyListeners;

/**
 * TODO Exercise 1A Step 2 Complete this class.
 * 
 * This class implements the PropertyRepository class. You will need to add the keyword
 * "implements" PropertyRepository. 
 * 
 * @author Jian 
 */
public class SimplePropertyRepositoryImpl implements PropertyRepository{
    
    ArrayList propertyList = new ArrayList();
    

    @Override
    public void addProperty(Property property) throws Exception {
        propertyList.add(property);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Property searchPropertyById(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Property> getAllProperties() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
