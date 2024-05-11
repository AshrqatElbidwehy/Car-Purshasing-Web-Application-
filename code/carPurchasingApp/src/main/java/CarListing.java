
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
public class CarListing extends javax.swing.JFrame {

    /**
     * Creates new form CarListingPage
     */
           private Connection conn;
          private JPanel carListingPanel;
          Point  listingWindowLocation ;
          Dimension  listingWindowSize ;

        public CarListing() {
        initComponents();
     //   carListingPanel = new JPanel(); // Initialize the JPanel
      //  setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.WHITE); 

        // Create navigation bar panel
        JPanel navBarPanel = createNavBarPanel();
        add(navBarPanel, BorderLayout.NORTH);

        // Create panel for car listings
        carListingPanel = new JPanel(new GridLayout(0, 2, 10, 10)); 
        carListingPanel.setBackground(Color.WHITE); 
        carListingPanel.setBorder(new EmptyBorder(10, 10, 10, 10)); 
        List<String> searchResults = new ArrayList<>(); 

        populateCarListings(carListingPanel,searchResults);

        JScrollPane scrollPane = new JScrollPane(carListingPanel);
        add(scrollPane, BorderLayout.CENTER);
                listingWindowLocation = this.getLocation();
                 listingWindowSize = this.getSize();
        
    }

    private JPanel createNavBarPanel() {
        JPanel navBarPanel = new JPanel(new BorderLayout());
        navBarPanel.setBackground(Color.RED); 

        // Title button (Clickable "Car Purchasing App")
        JLabel titleLabel = new JLabel("Car Purchasing App", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBorder(new EmptyBorder(10, 0, 10, 0)); // Add padding
        navBarPanel.add(titleLabel, BorderLayout.CENTER);

        
//user acc pg

        JButton userIconBtn = new JButton(new ImageIcon("user.png")); 
        userIconBtn.setContentAreaFilled(true);
        userIconBtn.setBackground(Color.red);
        userIconBtn.setBorderPainted(true); 
        userIconBtn.setText("user");
          userIconBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Direct to user account
//                SearchPage searchPage = new SearchPage();
//                searchPage.setVisible(true);
            }
        });
          
        navBarPanel.add(userIconBtn, BorderLayout.EAST);

        
       // search pg
       
        JButton searchIconBtn = new JButton(new ImageIcon("search.jpeg"));
        searchIconBtn.setContentAreaFilled(true); 
        searchIconBtn.setBorderPainted(true); 
        searchIconBtn.setBackground(Color.red);
        searchIconBtn.setText("Search!");
        navBarPanel.add(searchIconBtn, BorderLayout.WEST);
  


           searchIconBtn.addActionListener(new ActionListener() {
               
            @Override
            public void actionPerformed(ActionEvent e) {
      
                // Direct to SearchPage
                      setVisible(false);
                      CarSearch searchPage = new CarSearch(conn);
                      searchPage.setSize(listingWindowSize);
                      searchPage.setLocation(listingWindowLocation);
                      searchPage.setVisible(true);
                      dispose();
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
                  setVisible(false);
                     CarAdvertisement advertisementPage = new CarAdvertisement();
                   
                   
                      advertisementPage.setSize(listingWindowSize);
                      advertisementPage.setLocation(listingWindowLocation);
                      advertisementPage.setVisible(true);
                      dispose();
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
        setMinimumSize(new java.awt.Dimension(740, 750));
        setPreferredSize(new java.awt.Dimension(740, 750));

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
        
    private void populateCarListings(JPanel carListingPanel, List<String> searchResults) {
        try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/car-purchasing-app", "root", ""); // Connect to the database
        if (conn != null) {
            String sql = "SELECT * FROM car";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                // Retrieve car details
                String model = rs.getString("model-name");
                double price = rs.getDouble("price");
                byte[] imageData = rs.getBytes("car image");

                // Create a panel to display car details
                JPanel carPanel = new JPanel(new BorderLayout());
              //  carPanel.setPreferredSize(new Dimension(300, 200));
                carPanel.setBackground(Color.WHITE);
                Border border = new LineBorder(Color.BLACK, 1);
                carPanel.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));

                // Display car image
                try {
                    ImageIcon icon = new ImageIcon(imageData);
                    Image scaledImage = icon.getImage().getScaledInstance(320, 100, Image.SCALE_SMOOTH);
                    icon = new ImageIcon(scaledImage);
                    JLabel imageLabel = new JLabel(icon);
                    carPanel.add(imageLabel, BorderLayout.NORTH);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                // Display car details
                JLabel modelLabel = new JLabel("Model: " + model);
                JLabel priceLabel = new JLabel("Price: EGP " + price);
                modelLabel.setHorizontalAlignment(JLabel.CENTER);
                priceLabel.setHorizontalAlignment(JLabel.CENTER);
                JPanel infoPanel = new JPanel(new GridLayout(2, 1));
                infoPanel.add(modelLabel);
                infoPanel.add(priceLabel);
                infoPanel.setBackground(Color.WHITE);
                carPanel.add(infoPanel, BorderLayout.CENTER);

                // Button to view details
                JButton detailsButton = new JButton("View Car Details");
             //   detailsButton.setPreferredSize(new Dimension(190, 40));
                detailsButton.setBackground(Color.red);
                detailsButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Handle button click event
                    }
                });
                JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
                buttonPanel.add(detailsButton);
                buttonPanel.setBackground(Color.WHITE);
                carPanel.add(buttonPanel, BorderLayout.SOUTH);

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

    public void updateCarListings(String searchedModel) {
        // Clear existing listings
    carListingPanel.removeAll();

    // Search for cars matching the searched model
    try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/car-purchasing-app", "root", ""); // Connect to the database
        if (conn != null) {
            String sql = "SELECT * FROM car WHERE `model-name` LIKE ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + searchedModel + "%"); // Use '%' for wildcard search
            ResultSet rs = pst.executeQuery();

            // Populate car listings with search results
            while (rs.next()) {
                // Retrieve car details
                String model = rs.getString("model-name");
                double price = rs.getDouble("price");
                byte[] imageData = rs.getBytes("car image");

                // Create a panel to display car details
                JPanel carPanel = new JPanel(new BorderLayout());
                //carPanel.setPreferredSize(new Dimension(300, 200));
                carPanel.setBackground(Color.WHITE);
                Border border = new LineBorder(Color.BLACK, 1);
                carPanel.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));

                // Display car image
                try {
                    ImageIcon icon = new ImageIcon(imageData);
                    Image scaledImage = icon.getImage().getScaledInstance(320, 100, Image.SCALE_SMOOTH);
                    icon = new ImageIcon(scaledImage);
                    JLabel imageLabel = new JLabel(icon);
                    carPanel.add(imageLabel, BorderLayout.NORTH);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                // Display car details
                JLabel modelLabel = new JLabel("Model: " + model);
                JLabel priceLabel = new JLabel("Price: EGP " + price);
                modelLabel.setHorizontalAlignment(JLabel.CENTER);
                priceLabel.setHorizontalAlignment(JLabel.CENTER);
                JPanel infoPanel = new JPanel(new GridLayout(2, 1));
                infoPanel.add(modelLabel);
                infoPanel.add(priceLabel);
                infoPanel.setBackground(Color.WHITE);
                carPanel.add(infoPanel, BorderLayout.CENTER);

                // Button to view details
                JButton detailsButton = new JButton("View Car Details");
                detailsButton.setPreferredSize(new Dimension(190, 40));
                detailsButton.setBackground(Color.red);
                detailsButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Handle button click event
                    }
                });
                JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
                buttonPanel.add(detailsButton);
                buttonPanel.setBackground(Color.WHITE);
                carPanel.add(buttonPanel, BorderLayout.SOUTH);

                carListingPanel.add(carPanel);
            }

            rs.close();
            pst.close();
            conn.close();
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    // Repaint the panel to reflect the changes
    carListingPanel.revalidate();
    carListingPanel.repaint();
    }

public void updateCarListingsPrice(double maxPrice) {    
// Clear existing listings
    carListingPanel.removeAll();

    // Search for cars within the given price range
    try {
        Connection conn = Main.conn();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM car WHERE price <= ?");
        stmt.setDouble(1, maxPrice);
        ResultSet rs = stmt.executeQuery();

        // Populate car listings with search results
        while (rs.next()) {
            // Retrieve car details
            String modelName = rs.getString("model-name");
            double price = rs.getDouble("price");
             byte[] imageData = rs.getBytes("car image");

            // Create a panel to display car details
            JPanel carPanel = new JPanel(new BorderLayout());
            carPanel.setPreferredSize(new Dimension(350, 550));
            carPanel.setBackground(Color.WHITE);
            Border border = new LineBorder(Color.BLACK, 1);
            carPanel.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));

            // Display car image
                try {
                    ImageIcon icon = new ImageIcon(imageData);
                    Image scaledImage = icon.getImage().getScaledInstance(320, 100, Image.SCALE_SMOOTH);
                    icon = new ImageIcon(scaledImage);
                    JLabel imageLabel = new JLabel(icon);
                    carPanel.add(imageLabel, BorderLayout.NORTH);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            // Display car details
            JLabel modelLabel = new JLabel("Model: " + modelName);
            JLabel priceLabel = new JLabel("Price: $" + price);
            modelLabel.setHorizontalAlignment(JLabel.CENTER);
            priceLabel.setHorizontalAlignment(JLabel.CENTER);
            JPanel infoPanel = new JPanel(new GridLayout(2, 1));
            infoPanel.add(modelLabel);
            infoPanel.add(priceLabel);
            infoPanel.setBackground(Color.WHITE);
            carPanel.add(infoPanel, BorderLayout.CENTER);

            // Button to view details
            JButton detailsButton = new JButton("View Details");
            detailsButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Handle button click event to view details of the car
                }
            });
            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            buttonPanel.add(detailsButton);
            buttonPanel.setBackground(Color.WHITE);
            carPanel.add(buttonPanel, BorderLayout.SOUTH);

            // Add the car panel to the listings panel
            carListingPanel.add(carPanel);
        }

        rs.close();
        stmt.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    // Repaint the panel to reflect the changes
    carListingPanel.revalidate();
    carListingPanel.repaint();
}
    
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CarListing().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
