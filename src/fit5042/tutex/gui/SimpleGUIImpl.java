package fit5042.tutex.gui;

import fit5042.tutex.repository.entities.Property;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 *
 * TODO Exercise 1B Step 1 This entire class is incomplete. You will need to
 * complete this class.
 *
 * Only start this upon the completion of Exercise 1A
 *
 * Before you start this exercise, you will need an understanding of the MVP
 * Model View Presenter design pattern used.
 *
 * Please refer to the provided example to aid you in completing this exercise.
 *
 * This is the View. It contains the graphical user interface.
 *
 * This class both extends JFrame and implements the RealEstateAgencyGUI.
 *
 * You have the option of doing this manually or using the drag & drop tool to
 * construct the UI.
 *
 * @author Jian
 * @version 2017-06-16
 */
public class SimpleGUIImpl extends JFrame implements RealEstateAgencyGUI{
    
    private final JLabel propertyIdLabel;
    private final JLabel addressLabel;
    private final JLabel bedroomCountLabel;
    private final JLabel sizeLabel;
    private final JLabel priceLabel;
    
    private final JTextField propertyIdField;
    private final JTextField addressField;
    private final JTextField bedroomCountField;
    private final JTextField sizeField;
    private final JTextField priceField;
    
    private final JTextArea dataArea;
    
    private final JButton addButton;
    private final JButton searchButton;
    private final JButton viewButton;
    private final JButton closeButton;
    
    private final JPanel inputPanel;
    private final JPanel buttonPanel;
    
    private int propertyId;

    public SimpleGUIImpl(ActionListener actionListener) {
        
        propertyIdLabel=new JLabel("Property ID");
        addressLabel=new JLabel("Address");
        bedroomCountLabel = new JLabel("Number of Bedrooms");
        sizeLabel = new JLabel("Size");
        priceLabel = new JLabel("Price");
        
        propertyIdField = new JTextField();
        addressField = new JTextField();
        bedroomCountField = new JTextField();
        sizeField = new JTextField();
        priceField = new JTextField();
        
        dataArea = new JTextArea();
        dataArea.setEditable(false);
        
        addButton = new JButton("Add");
        searchButton = new JButton("Search");
        viewButton = new JButton("View");
        closeButton = new JButton("Close");
        
        closeButton.addActionListener(actionListener);
        addButton.addActionListener(actionListener);
        viewButton.addActionListener(actionListener);
        searchButton.addActionListener(actionListener);
        
        inputPanel = new JPanel();
        buttonPanel=new JPanel();
        
        
        inputPanel.add(propertyIdLabel);
        inputPanel.add(propertyIdField);
        inputPanel.add(addressLabel);
        inputPanel.add(addressField);
        inputPanel.add(bedroomCountLabel);
        inputPanel.add(bedroomCountField);
        inputPanel.add(sizeLabel);
        inputPanel.add(sizeField);
        inputPanel.add(priceLabel);
        inputPanel.add(priceField);
        
        buttonPanel.add(addButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(viewButton);
        buttonPanel.add(closeButton);
       
        Container container = this.getContentPane();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.setLayout(new BorderLayout());
        inputPanel.setLayout(new GridLayout(5, 2));
        container.add(inputPanel, BorderLayout.NORTH);
        container.add(new JScrollPane(dataArea), BorderLayout.CENTER);
        container.add(buttonPanel, BorderLayout.SOUTH);
        buttonPanel.setLayout(new GridLayout(1, 4));
        this.setSize(600, 540);
        
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void clearTextFields() {
        propertyIdField.setText("");
        addressField.setText("");
        bedroomCountField.setText("");
        sizeField.setText("");
        priceField.setText("");
    }

    @Override
    public void displayPopUpMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    @Override
    public void displayPropertyDetails(Property property) {
        dataArea.setText(property.toString());
    }

    @Override
    public void displayPropertyDetails(List<Property> properties) {
        dataArea.setText("");
        properties .forEach((property) -> {
            dataArea.append(property.toString()+"\n");
        });
    }

    @Override
    public JButton getAddButton() {
        return addButton;
    }

    @Override
    public JButton getCloseButton() {
        return closeButton;
    }

    @Override
    public JButton getSearchButton() {
        return searchButton;
    }

    @Override
    public JButton getViewButton() {
        return viewButton;
    }

    @Override
    public Property getPropertyDetails() {
        if (propertyIdField.getText()==null)
            return null;
        Property p=new Property(Integer.parseInt(propertyIdField.getText()), addressField.getText(), Integer.parseInt(bedroomCountField.getText()), Double.parseDouble(sizeField.getText()),Double.parseDouble(priceField.getText()));
        return p;
        
    }

    @Override
    public int getPropertyId() {
        propertyId=Integer.parseInt(propertyIdField.getText());
        return propertyId;
    }

}
