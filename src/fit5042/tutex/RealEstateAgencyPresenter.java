/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex;

import fit5042.tutex.gui.RealEstateAgencyGUI;
import fit5042.tutex.gui.SimpleGUIImpl;
import fit5042.tutex.repository.PropertyRepository;
import fit5042.tutex.repository.PropertyRepositoryFactory;
import fit5042.tutex.repository.entities.Property;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * TODO Exercise 1B Step 2 This class will be used for Exercise 1B.
 *
 * Only start this upon the completion of Exercise 1A
 *
 * Before you start this exercise, you will need an understanding of the MVP
 * Model View Presenter design pattern used.
 *
 * Please refer to the provided example to aid you in completing this exercise.
 *
 * This is the presenter. It will use both the Model and the View
 *
 *
 *
 * This class implements ActionListener.
 *
 * This class also contains a main method that would be used.
 *
 * @author Jian
 */
public class RealEstateAgencyPresenter implements ActionListener {

    private String name;
    private PropertyRepository propertyRepository;
    private RealEstateAgencyGUI gui;
    private int propertyId;

    public RealEstateAgencyPresenter(String name) {
        this.name = name;
        try {
            this.propertyRepository = PropertyRepositoryFactory.getInstance();

            this.propertyRepository.addProperty(new Property(1, "4/44 lansdowne road, St Kilda East VIC 3183, Australia", 2, 150, 420000));
            this.propertyRepository.addProperty(new Property(2, "9 Toorak road, Melbourne VIC 3186, Australia", 2, 150, 420000));
            this.propertyRepository.addProperty(new Property(3, "71 High Street road, Melbourne VIC 3176, Australia", 2, 150, 420000));
            this.propertyRepository.addProperty(new Property(4, "22 Flinders Street, Melbourne VIC 3003, Australia", 2, 150, 420000));
            this.propertyRepository.addProperty(new Property(5, "41 Kings road, Melbourne VIC 3234, Australia", 2, 150, 420000));

        } catch (Exception ex) {
            Logger.getLogger(RealEstateAgencyPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        RealEstateAgencyPresenter presenter = new RealEstateAgencyPresenter("Real Estate Agency");
        presenter.runMethod();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == gui.getAddButton()) {
            this.addProperty();
        } else if (e.getSource() == gui.getSearchButton()) {
            this.searchProperty();
        } else if (e.getSource() == gui.getViewButton()) {
            this.viewAllProperty();
        } else {
            System.exit(0);
        }
    }

    private void runMethod() {
        gui = new SimpleGUIImpl(this);
    }

    private void addProperty() {
        try {
            Property property = gui.getPropertyDetails();
            propertyRepository.addProperty(property);
            gui.displayPopUpMessage("Property added successfully...!!");
            viewAllProperty();
            gui.clearTextFields();
        } catch (Exception ex) {
           gui.displayPopUpMessage("Failed to add Property " + ex.getMessage());
        }

    }

    private void searchProperty() {
        try {
            propertyId = gui.getPropertyId();
            Property propertyDetail = propertyRepository.searchPropertyById(propertyId);
            if (propertyDetail == null) {
                gui.displayPopUpMessage("Property does not exist");
            } else {
                gui.displayPropertyDetails(propertyDetail);
            }
        } catch (Exception ex) {
            gui.displayPopUpMessage("Failed to view Property " + ex.getMessage());
        }
    }

    private void viewAllProperty() {
        try {
            gui.clearTextFields();
            List<Property> propertyList;
            propertyList = this.propertyRepository.getAllProperties();
            if (propertyList.isEmpty() || propertyList == null) {
                gui.displayPopUpMessage("No Property Found");
            } else {
                gui.displayPropertyDetails(propertyList);
            }

        } catch (Exception ex) {
            gui.displayPopUpMessage("Failed to view Property " + ex.getMessage());
        }
    }

}
