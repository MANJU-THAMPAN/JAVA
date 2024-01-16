import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

class Pet {
    private String name;
    private String type;
    private double price;

    public Pet(String name, String type, double price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " - " + type + " - $" + price;
    }
}

class PetShopPanel extends JPanel {

    private JTextField nameField;
    private JTextField typeField;
    private JTextField priceField;
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton displayAllButton;
    private JButton clearButton;
    private JTextArea displayArea;

    private Map<String, Pet> petMap;

    public PetShopPanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(204, 255, 204));  // Light green background color

        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        inputPanel.setBackground(new Color(204, 255, 204));  // Light green background color

        nameField = new JTextField(20);
        typeField = new JTextField(20);
        priceField = new JTextField(20);
        addButton = new JButton("Add Pet");
        updateButton = new JButton("Update Pet");
        deleteButton = new JButton("Delete Pet");
        displayAllButton = new JButton("Display All Pets");
        clearButton = new JButton("Clear");
        displayArea = new JTextArea(10, 20);
        displayArea.setEditable(false);

        petMap = new HashMap<>();

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPet();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updatePet();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletePet();
            }
        });

        displayAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayAllPets();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });

        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Type:"));
        inputPanel.add(typeField);
        inputPanel.add(new JLabel("Price:"));
        inputPanel.add(priceField);
        inputPanel.add(addButton);
        inputPanel.add(updateButton);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        buttonPanel.setBackground(new Color(204, 255, 204));  // Light green background color
        buttonPanel.add(deleteButton);
        buttonPanel.add(displayAllButton);
        buttonPanel.add(clearButton);

        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(new JScrollPane(displayArea), BorderLayout.SOUTH);
    }

    private void addPet() {
        String name = nameField.getText();
        String type = typeField.getText();
        String priceText = priceField.getText();

        if (!name.isEmpty() && !type.isEmpty() && !priceText.isEmpty()) {
            try {
                double price = Double.parseDouble(priceText);
                Pet pet = new Pet(name, type, price);
                petMap.put(name, pet);
                displayArea.append("Pet added: " + pet + "\n");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(PetShopPanel.this, "Invalid price format. Please enter a number.");
            }
        } else {
            JOptionPane.showMessageDialog(PetShopPanel.this, "Please enter name, type, and price.");
        }
    }

    private void updatePet() {
        String name = nameField.getText();

        if (!name.isEmpty() && petMap.containsKey(name)) {
            String type = typeField.getText();
            String priceText = priceField.getText();

            if (!type.isEmpty() && !priceText.isEmpty()) {
                try {
                    double price = Double.parseDouble(priceText);
                    Pet updatedPet = new Pet(name, type, price);
                    petMap.put(name, updatedPet);
                    displayArea.append("Pet updated: " + updatedPet + "\n");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(PetShopPanel.this, "Invalid price format. Please enter a number.");
                }
            } else {
                JOptionPane.showMessageDialog(PetShopPanel.this, "Please enter type and price for updating.");
            }
        } else {
            JOptionPane.showMessageDialog(PetShopPanel.this, "Pet with name " + name + " not found.");
        }
    }

    private void deletePet() {
        String name = nameField.getText();

        if (!name.isEmpty() && petMap.containsKey(name)) {
            Pet deletedPet = petMap.remove(name);
            displayArea.append("Pet deleted: " + deletedPet + "\n");
        } else {
            JOptionPane.showMessageDialog(PetShopPanel.this, "Pet with name " + name + " not found.");
        }
    }

    private void displayAllPets() {
        displayArea.setText("");
        for (Pet pet : petMap.values()) {
            displayArea.append(pet + "\n");
        }
    }

    private void clearFields() {
        nameField.setText("");
        typeField.setText("");
        priceField.setText("");
        displayArea.setText("");
    }
}

public class PetShopManagementSystem {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Pet Shop Management System");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            PetShopPanel petShopPanel = new PetShopPanel();
            frame.getContentPane().add(petShopPanel);

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
