
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author amira
 */
public class CarListingPage extends javax.swing.JFrame {

    /**
     * Creates new form CarListingPage
     */
    public CarListingPage() {
        initComponents();
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.WHITE); // Set background color for the frame

        // Create navigation bar panel
        JPanel navBarPanel = createNavBarPanel();
        add(navBarPanel, BorderLayout.NORTH);

        // Create panel for car listings
        JPanel carListingPanel = new JPanel(new GridLayout(0, 2, 10, 10)); // Grid layout with 2 columns and spacing
        carListingPanel.setBackground(Color.WHITE); // Set background color for the car listing panel
        carListingPanel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Add padding to the car listing panel

        // Retrieve car data from database and populate the car listings panel
        populateCarListings(carListingPanel);

        // Add the car listings panel to the frame
        JScrollPane scrollPane = new JScrollPane(carListingPanel);
        add(scrollPane, BorderLayout.CENTER);
    }

    private JPanel createNavBarPanel() {
        JPanel navBarPanel = new JPanel(new BorderLayout());
        navBarPanel.setBackground(Color.RED); // Set background color for the navigation bar

        // Title button (Clickable "Car Purchasing App")
        JLabel titleLabel = new JLabel("Car Purchasing App", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBorder(new EmptyBorder(10, 0, 10, 0)); // Add padding
        navBarPanel.add(titleLabel, BorderLayout.CENTER);

        // User icon button
        ImageIcon userIcon = new ImageIcon("/user.png");
        JButton userIconBtn = new JButton(userIcon); // Replace "userIcon.png" with actual icon path
        userIconBtn.setContentAreaFilled(false); // Make button transparent
        userIconBtn.setBorderPainted(false); // Remove border
        navBarPanel.add(userIconBtn, BorderLayout.EAST);

        // Search icon button
        ImageIcon searchIcon = new ImageIcon("/search-normal.png");
        JButton searchIconBtn = new JButton(searchIcon);
        searchIconBtn.setContentAreaFilled(false); // Make button transparent
        searchIconBtn.setBorderPainted(false); // Remove border
        searchIconBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Direct to SearchPage
//                SearchPage searchPage = new SearchPage();
//                searchPage.setVisible(true);
            }
        });
        navBarPanel.add(searchIconBtn, BorderLayout.WEST);

        // Panel for "Cars for Sale" and "Advertise Your Car" buttons
        JPanel buttonsPanel = new JPanel(new GridLayout(1, 2));
        buttonsPanel.setBackground(Color.RED);

        // Cars for Sale button
        JButton carsForSaleBtn = new JButton("Cars for Sale");
        carsForSaleBtn.setForeground(Color.WHITE); // Set text color
        carsForSaleBtn.setContentAreaFilled(false); // Make button transparent
        carsForSaleBtn.setBorderPainted(false); // Remove border
        carsForSaleBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Direct to car listing page (current page)
            }
        });
        buttonsPanel.add(carsForSaleBtn);

        // Advertise Your Car button
        JButton advertiseCarBtn = new JButton("Advertise Your Car");
        advertiseCarBtn.setForeground(Color.WHITE); // Set text color
        advertiseCarBtn.setContentAreaFilled(false); // Make button transparent
        advertiseCarBtn.setBorderPainted(false); // Remove border
        advertiseCarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Direct to CarAdvertisement page
                CarAdvertisement advertisementPage = new CarAdvertisement();
                advertisementPage.setVisible(true);
            }
        });
        buttonsPanel.add(advertiseCarBtn);

        navBarPanel.add(buttonsPanel, BorderLayout.SOUTH);

        return navBarPanel;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1367, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 818, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    

    private void populateCarListings(JPanel carListingPanel) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/car-purchasing-app", "root", ""); // Connect to the database
            if (conn != null) {
                String sql = "SELECT * FROM car";
                PreparedStatement pst = conn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();

                while (rs.next()) {
                    String model = rs.getString("model-name");
                    double price = rs.getDouble("price");
                    byte[] imageData = rs.getBytes("car image"); // Assuming the image data is stored in the database

                    // Create panel for each car listing
                    JPanel carPanel = new JPanel(new BorderLayout());
                    carPanel.setPreferredSize(new Dimension(300, 200)); // Set preferred size for car panel
                    carPanel.setBackground(Color.WHITE); // Set background color for the car panel
                    Border border = new LineBorder(Color.BLACK, 1); // Create border
                    carPanel.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10))); // Add border with padding

                    // Load and display image
                    try {
                        ImageIcon icon = new ImageIcon(imageData);
                        Image scaledImage = icon.getImage().getScaledInstance(320, 100, Image.SCALE_SMOOTH);
                        icon = new ImageIcon(scaledImage);
                        JLabel imageLabel = new JLabel(icon);
                        carPanel.add(imageLabel, BorderLayout.NORTH);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    // Display car model and price
                    JLabel modelLabel = new JLabel("Model: " + model);
                    JLabel priceLabel = new JLabel("Price: EGP " + price);
                    modelLabel.setHorizontalAlignment(JLabel.CENTER); // Center align model label
                    priceLabel.setHorizontalAlignment(JLabel.CENTER); // Center align price label
                    JPanel infoPanel = new JPanel(new GridLayout(2, 1));
                    infoPanel.add(modelLabel);
                    infoPanel.add(priceLabel);
                    infoPanel.setBackground(Color.WHITE); // Set background color for the info panel
                    carPanel.add(infoPanel, BorderLayout.CENTER);

                    // Button to view details
                    JButton detailsButton = new JButton("View Car Details");
                    detailsButton.setPreferredSize(new Dimension(190, 40));
                    detailsButton.setBackground(Color.CYAN);
                    detailsButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // Open car details page
                            // CarDetailsPage detailsPage = new CarDetailsPage(model); // Pass model name to details page
                            // detailsPage.setVisible(true);
                        }
                    });
                    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Panel for button alignment
                    buttonPanel.add(detailsButton);
                    buttonPanel.setBackground(Color.WHITE); // Set background color for the button panel
                    carPanel.add(buttonPanel, BorderLayout.SOUTH);

                    // Add the car panel to the car listings panel
                    carListingPanel.add(carPanel);
                }

                rs.close();
                pst.close();
                conn.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CarListingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CarListingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CarListingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CarListingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CarListingPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
