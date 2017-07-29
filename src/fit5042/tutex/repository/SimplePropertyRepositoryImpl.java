/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.repository;

import fit5042.tutex.repository.entities.Property;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jdk.nashorn.internal.runtime.PropertyListeners;

/**
 * TODO Exercise 1A Step 2 Complete this class.
 *
 * This class implements the PropertyRepository class. You will need to add the
 * keyword "implements" PropertyRepository.
 *
 * @author Jian
 */
public class SimplePropertyRepositoryImpl implements PropertyRepository {

    ArrayList<Property> propertyList = new ArrayList<Property>();

    @Override
    public void addProperty(Property property) throws Exception {
        propertyList.add(property);

    }

    @Override
    public Property searchPropertyById(int id) throws Exception {
        for (Property property : propertyList) {
            if (property.getId() == id) {

                return property;
            }
        }

        return null;
    }

    @Override
    public List<Property> getAllProperties() throws Exception {

        return propertyList;

    }
}
