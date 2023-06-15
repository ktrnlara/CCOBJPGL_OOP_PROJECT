package BulldogsExchange;



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.table.*;
import java.util.Arrays;
import java.util.List;

class OrderSlipPanel extends ContentPanel {

    private DefaultTableModel tableModel;
    private JPanel orderSlipPanel, tablePanel;
    private JTable table;
    private JScrollPane tableSP;
    private JTextField amount;
    private JLabel orderSlipLabel, note;

    private JLabel itemCodeLabel, quantityLabel, sizeLabel;
    private JTextField itemCodeLabelTF;
    private JButton confirm, add, remove;
    private JComboBox sizeCB, quantityCB;
    
    private JFrame uListFrame, mListFrame;
    private JPanel itemsPanel, merchPanel,uListPanel, mListPanel;
    private JButton next, previous, itemsFL, merchFL;
    private JLabel uniformsLabel, merchLabel, uLabel;
    private JScrollPane uniformsList, merchList, unifList, merchfList;

    private ArrayList<Integer> numberList = new ArrayList<>();


    OrderSlipPanel(int color) {
        super(color);
        
        itemsPanel = new JPanel();
        itemsPanel.setBackground(new Color(0x000066));
        itemsPanel.setBounds(0, 0, 685, 585);
        itemsPanel.setLayout(null);
        
        uniformsLabel = new JLabel("MERCHANDISE");
        uniformsLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
        uniformsLabel.setForeground(new Color(0xFCD421));
        uniformsLabel.setBounds(200, 25, 280, 30);
        uniformsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        
        List<String> imagePaths = Arrays.asList(
        "unif1.jpg",
        "unif2.jpg",
        "unif3.jpg",
        "unif4.jpg",
        "unif5.jpg",
        "unif6.jpg",
        "unif1.1.jpg",
        "unif1.2.jpg",
        "unif2.1.jpg",
        "unif2.2.jpg",
        "unif3.1.jpg",
        "unif3.2.jpg",
        "unif4.1.jpg",
        "unif4.2.jpg",
        "unif5.1.jpg",
        "unif6.1.jpg"
        );

        int imageHeight = 425; // Set the desired height for the images
        int yPos = 10; // Starting position for the first image label

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Use BoxLayout to stack the images vertically

        for (String imagePath : imagePaths) {
            ImageIcon imageIcon = new ImageIcon(imagePath);
            int originalWidth = imageIcon.getIconWidth();
            int originalHeight = imageIcon.getIconHeight();

            int scaledWidth = (int) (imageHeight * ((double) originalWidth / originalHeight));

            Image image = imageIcon.getImage().getScaledInstance(scaledWidth, imageHeight, Image.SCALE_SMOOTH); // Resize the image
            imageIcon = new ImageIcon(image);

            JLabel imageLabel = new JLabel(imageIcon);
            imageLabel.setBounds(10, yPos, imageIcon.getIconWidth(), imageIcon.getIconHeight());
            panel.add(imageLabel);

            yPos += imageIcon.getIconHeight() + 10; // Increment the y-position for the next image
        }

        uniformsList = new JScrollPane(panel);
        uniformsList.setBounds(50, 75, 590, 425); // Adjust the bounds based on your desired positioning within itemsPanel

        next = new JButton("Merchandise");
        next.setHorizontalAlignment(SwingConstants.CENTER);
        next.setFont(new Font("Tahoma", Font.BOLD, 15));
        next.setBackground(new Color(0xFCD421));
        next.setForeground(Color.BLACK);
        next.setBounds(380, 525, 150, 25);
        next.setFocusable(false);
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            List<String> imagePaths = Arrays.asList(
                "merch1.jpg",
                "merch1.1.jpg",
                "merch2.jpg",
                "merch2.1.jpg",
                "merch3.jpg",
                "merch3.1.jpg",
                "merch4.jpg",
                "merch.1.jpg",
                "merch5.jpg",
                "merch5.1.jpg",
                "merch6.jpg",
                "merch6.1.jpg",
                "merch7.jpg",
                "merch7.1.jpg",
                "merch7.2.jpg",
                "merch7.3.jpg",
                "merch7.4.jpg",
                "merch7.5.jpg"
            );

            int imageHeight = 425; // Set the desired height for the images
            int yPos = 10; // Starting position for the first image label

            merchPanel = new JPanel();
            merchPanel.setBackground(new Color(0x000066));
            merchPanel.setBounds(0, 0, 685, 585);
            merchPanel.setLayout(null);

            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Use BoxLayout to stack the images vertically

            for (String imagePath : imagePaths) {
                ImageIcon imageIcon = new ImageIcon(imagePath);
                int originalWidth = imageIcon.getIconWidth();
                int originalHeight = imageIcon.getIconHeight();

                int scaledWidth = (int) (imageHeight * ((double) originalWidth / originalHeight));

                Image image = imageIcon.getImage().getScaledInstance(scaledWidth, imageHeight, Image.SCALE_SMOOTH); // Resize the image
                imageIcon = new ImageIcon(image);

                JLabel imageLabel = new JLabel(imageIcon);
                imageLabel.setBounds(10, yPos, imageIcon.getIconWidth(), imageIcon.getIconHeight());
                panel.add(imageLabel);

                yPos += imageIcon.getIconHeight() + 10; // Increment the y-position for the next image
            }

            merchList = new JScrollPane(panel);
            merchList.setBounds(50, 75, 590, 425); // Adjust the bounds based on your desired positioning within merchPanel
            merchPanel.add(merchList); // Add uniformsList to the merchPanel
            merchLabel = new JLabel("MERCHANDISE");
            merchLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
            merchLabel.setForeground(new Color(0xFCD421));
            merchLabel.setBounds(200, 25, 280, 30);
            merchLabel.setHorizontalAlignment(SwingConstants.CENTER);
            
            merchPanel.add(merchLabel); // Add merchLabel to merchPanel
            merchPanel.add(merchFL);
            
            // Remove all components from itemsPanel except the buttons
            Component[] components = itemsPanel.getComponents();
                for (Component component : components) {
                    if (!(component instanceof JButton)) {
                        itemsPanel.remove(component);
                    }
                }

                itemsFL.setVisible(false);
                next.setVisible(false);
                previous.setVisible(true);
                itemsPanel.setLayout(null); // Set layout to null for custom positioning
                itemsPanel.add(merchPanel); // Add merchPanel to the itemsPanel

                itemsPanel.revalidate();
                itemsPanel.repaint();
            }
        });
                
        previous = new JButton("Uniforms");
        previous.setHorizontalAlignment(SwingConstants.CENTER);
        previous.setFont(new Font("Tahoma", Font.BOLD, 15));
        previous.setBackground(new Color(0xFCD421));
        previous.setForeground(Color.BLACK);
        previous.setBounds(150, 525, 150, 25);
        previous.setFocusable(false);
        previous.setVisible(false); 
        previous.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                itemsPanel.remove(merchPanel); // Remove merchPanel from itemsPanel
                itemsPanel.add(uniformsList); // Add uniformsList back to itemsPanel
                itemsPanel.add(uniformsLabel);
                itemsPanel.add(next); // Add next button back to itemsPanel
                itemsPanel.add(itemsFL);
                
                merchPanel.setVisible(false); // Hide the merchPanel
                next.setVisible(true);
                previous.setVisible(false);
                itemsFL.setVisible(true);
                
                itemsPanel.revalidate(); // Revalidate the itemsPanel
                itemsPanel.repaint(); // Repaint the itemsPanel
            }
        });
        
        itemsFL = new JButton("View Full List");
        itemsFL.setHorizontalAlignment(SwingConstants.CENTER);
        itemsFL.setFont(new Font("Tahoma", Font.BOLD, 15));
        itemsFL.setBackground(new Color(0xFCD421));
        itemsFL.setForeground(Color.BLACK);
        itemsFL.setBounds(150, 525, 150, 25);
        itemsFL.setFocusable(false);
        itemsPanel.add(itemsFL);
        itemsFL.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame uListFrame = new JFrame("UNIFORM LIST");
                uListFrame.setSize(1000, 1000);
                
                JLabel uLabel = new JLabel("OFFICIAL UNIFORM LIST");
                uLabel.setFont(new Font("Tahoma", Font.BOLD, 45));
                uLabel.setForeground(new Color(0xFFBD59));
                uLabel.setBounds(150, 25, 700, 60);
                uLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center the label horizontally
                
                // Create the merchPanel
                JPanel uListPanel = new JPanel();
                uListPanel.setBackground(new Color(0x293478));
                uListPanel.setBounds(0, 0, 1000, 1000);
                uListPanel.setLayout(null);

                // Create the list of image paths
                List<String> imagePaths = Arrays.asList(
                  "ufl1.jpg",
                  "ufl3.jpg",
                  "ufl4.jpg",
                  "ufl5.jpg",
                  "ufl6.jpg",
                  "ufl8.jpg",                  
                  "ufl9.jpg",
                  "ufl11.jpg",
                  "ufl3.jpg",
                  "uf14.jpg",
                  "ufl5.jpg",
                  "ufl6.jpg"
                );

                int imageHeight = 1257; // Set the desired height for the images
                int imageWidth = 780; // Set the desired width for the images
                int yPos = 10; // Starting position for the first image label

                JPanel panel = new JPanel();
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Use BoxLayout to stack the images vertically

                for (String imagePath : imagePaths) {
                    ImageIcon imageIcon = new ImageIcon(imagePath);
                    Image originalImage = imageIcon.getImage();
                    Image scaledImage = originalImage.getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH); // Resize the image
                    imageIcon = new ImageIcon(scaledImage);

                    JLabel imageLabel = new JLabel(imageIcon);
                    imageLabel.setBounds(10, yPos, imageWidth, imageHeight);
                    panel.add(imageLabel);

                    yPos += imageHeight + 10; // Increment the y-position for the next image
                }

                JScrollPane unifList = new JScrollPane(panel);
                unifList.setBounds(100, 100, 800, 600); // Adjust the size of the scroll pane to accommodate the resized images


                // Add components to the merchPanel
                uListPanel.add(uLabel);
                uListPanel.add(unifList);

                // Add the merchPanel to the frame
                uListFrame.getContentPane().add(uListPanel);

                // Set frame properties
                uListFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                uListFrame.setLocationRelativeTo(null); // Center the frame on the screen
                uListFrame.setVisible(true); // Make the frame visible
            }
        });
        
        merchFL = new JButton("View Full List");
        merchFL.setHorizontalAlignment(SwingConstants.CENTER);
        merchFL.setFont(new Font("Tahoma", Font.BOLD, 15));
        merchFL.setBackground(new Color(0xFCD421));
        merchFL.setForeground(Color.BLACK);
        merchFL.setBounds(380, 525, 150, 25);
        merchFL.setFocusable(false);
//        merchFL.addActionListener(this); // Register the action listener
        merchFL.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame mListFrame = new JFrame("MERCHANDISE LIST");
                mListFrame.setSize(1000, 1000);
                
                JLabel mLabel = new JLabel("OFFICIAL MERCHANDISE LIST");
                mLabel.setFont(new Font("Tahoma", Font.BOLD, 45));
                mLabel.setForeground(new Color(0xFFBD59));
                mLabel.setBounds(140, 25, 700, 60);
                mLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center the label horizontally
                
                // Create the merchPanel
                JPanel mListPanel = new JPanel();
                mListPanel.setBackground(new Color(0x293478));
                mListPanel.setBounds(0, 0, 1000, 1000);
                mListPanel.setLayout(null);

                // Create the list of image paths
                List<String> imagePaths = Arrays.asList(
                    "mfl1.jpg",
                    "mfl2.jpg",
                    "mfl3.jpg",
                    "mfl4.jpg",
                    "mfl6.jpg",
                    "mfl7.jpg"
                );

                int imageHeight = 1257; // Set the desired height for the images
                int imageWidth = 780; // Set the desired width for the images
                int yPos = 10; // Starting position for the first image label

                JPanel panel = new JPanel();
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Use BoxLayout to stack the images vertically

                for (String imagePath : imagePaths) {
                    ImageIcon imageIcon = new ImageIcon(imagePath);
                    Image originalImage = imageIcon.getImage();
                    Image scaledImage = originalImage.getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH); // Resize the image
                    imageIcon = new ImageIcon(scaledImage);

                    JLabel imageLabel = new JLabel(imageIcon);
                    imageLabel.setBounds(10, yPos, imageWidth, imageHeight);
                    panel.add(imageLabel);

                    yPos += imageHeight + 10; // Increment the y-position for the next image
                }

                JScrollPane merchfList = new JScrollPane(panel);
                merchfList.setBounds(100, 100, 800, 600); // Adjust the size of the scroll pane to accommodate the resized images


                // Add components to the merchPanel
                mListPanel.add(mLabel);
                mListPanel.add(merchfList);

                // Add the merchPanel to the frame
                mListFrame.getContentPane().add(mListPanel);

                // Set frame properties
                mListFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                mListFrame.setLocationRelativeTo(null); // Center the frame on the screen
                mListFrame.setVisible(true); // Make the frame visible
            }
        });
        
        

        orderSlipPanel = new JPanel();
        orderSlipPanel.setBackground(new Color(0xFCD421));
        orderSlipPanel.setBounds(685, 0, 500, 585);
        orderSlipPanel.setLayout(null);

        orderSlipLabel = new JLabel("ORDER SLIP FORM");
        orderSlipLabel.setHorizontalAlignment(JLabel.CENTER);
        orderSlipLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
        orderSlipLabel.setForeground(new Color(0x293476));
        orderSlipLabel.setBounds(20, 20, 460, 30);

        String text = "Before you add items please check the size chart and items offered";

        note = new JLabel("<html><div style='text-align: center;'>" + text + "</div></html>");
        note.setHorizontalAlignment(JLabel.CENTER);
        note.setFont(new Font("Tahoma", Font.BOLD, 11));
        note.setBounds(20, 60, 460, 15);

        itemCodeLabel = new JLabel("ENTER ITEM CODE:");
        itemCodeLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        itemCodeLabel.setForeground(Color.BLACK);
        itemCodeLabel.setBounds(30, 90, 200, 20);

        itemCodeLabelTF = new JTextField();
        itemCodeLabelTF.setFont(new Font("Tahoma", Font.BOLD, 16));
        itemCodeLabelTF.setForeground(Color.BLACK);
        itemCodeLabelTF.setBounds(210, 90, 262, 25);

        quantityLabel = new JLabel("QUANTITY:");
        quantityLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        quantityLabel.setForeground(Color.BLACK);
        quantityLabel.setBounds(30, 130, 120, 20);

        String qty[] = {"1", "2", "3", "4", "5"};

        quantityCB = new JComboBox(qty);
        quantityCB.setForeground(Color.BLACK);
        quantityCB.setBackground(Color.WHITE);
        ((JLabel) quantityCB.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        quantityCB.setBounds(140, 130, 100, 25);

        sizeLabel = new JLabel("ITEM SIZE:");
        sizeLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        sizeLabel.setForeground(Color.BLACK);
        sizeLabel.setBounds(260, 130, 120, 20);

        String sizes[] = {"XS", "S", "M", "L", "XL", "2XL", "3XL", "4XL", "5XL", "6XL", "MTO", "N/A"};

        sizeCB = new JComboBox(sizes);
        sizeCB.setForeground(Color.BLACK);
        sizeCB.setBackground(Color.WHITE);
        ((JLabel) sizeCB.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        sizeCB.setBounds(370, 130, 100, 25);

        add = new JButton("ADD");
        add.setHorizontalAlignment(SwingConstants.CENTER);
        add.setFont(new Font("Tahoma", Font.BOLD, 15));
        add.setBackground(new Color(0x33FF33));
        add.setForeground(Color.WHITE);
        add.setBounds(220, 170, 115, 25);
        add.setFocusable(false);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItem();
            }
        });

        remove = new JButton("REMOVE");
        remove.setHorizontalAlignment(SwingConstants.CENTER);
        remove.setFont(new Font("Tahoma", Font.BOLD, 15));
        remove.setBackground(new Color(0XFF3333));
        remove.setForeground(Color.WHITE);
        remove.setBounds(355, 170, 115, 25);
        remove.setFocusable(false);
        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String select = JOptionPane.showInputDialog(null, "ENTER THE ID:", "Delete Item", JOptionPane.INFORMATION_MESSAGE);
                if (select != null && !select.isEmpty()) {
                    int id = Integer.parseInt(select);

                    int rowCount = tableModel.getRowCount();
                    boolean found = false;
                    for (int i = 0; i < rowCount; i++) {
                        int rowId = (int) tableModel.getValueAt(i, 0);
                        if (rowId == id) {
                            tableModel.removeRow(i);
                            numberList.remove(i);
                            updateRowNumbers();
                            found = true;
                            break; 
                        }
                    }

                    if (found) {
                        updateTotal();
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid ID", "Error", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No ID entered", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        tablePanel = new JPanel();
        tablePanel.setBounds(25, 210, 450, 300);
        tablePanel.setLayout(new BorderLayout());

        String[] columnNames = {"ID", "ITEM CODE", "ITEM", "DESCRIPTION", "SIZE", "QUANTITY", "UNIT PRICE", "AMOUNT"};

        tableModel = new DefaultTableModel();
        for (String columnName : columnNames) {
            tableModel.addColumn(columnName);
        }

        table = new JTable(tableModel);
        table.setRowHeight(40);
        table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 12));
        table.getTableHeader().setForeground(Color.WHITE);
        table.getTableHeader().setBackground(new Color(0x293478));
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);
        table.setOpaque(true);
        table.setEnabled(false);

        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 
        TableColumnModel columnModel = table.getColumnModel();

        columnModel.getColumn(0).setPreferredWidth(25); 
        columnModel.getColumn(1).setPreferredWidth(150); 
        columnModel.getColumn(2).setPreferredWidth(150);
        columnModel.getColumn(3).setPreferredWidth(350); 
        columnModel.getColumn(4).setPreferredWidth(100); 
        columnModel.getColumn(5).setPreferredWidth(100);
        columnModel.getColumn(6).setPreferredWidth(100); 
        columnModel.getColumn(7).setPreferredWidth(100); 

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, centerRenderer);

        tableSP = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        amount = new JTextField(10);
        amount.setFont(new Font("Tahoma", Font.BOLD, 15));
        amount.setForeground(Color.WHITE);
        amount.setBackground(new Color(0x293478));
        amount.setHorizontalAlignment(SwingConstants.RIGHT);
        amount.setEditable(false);

        tablePanel.add(tableSP, BorderLayout.CENTER);
        tablePanel.add(amount, BorderLayout.SOUTH);

        confirm = new JButton("CONFIRM");
        confirm.setHorizontalAlignment(SwingConstants.CENTER);
        confirm.setFont(new Font("Tahoma", Font.BOLD, 15));
        confirm.setBackground(new Color(0x293478));
        confirm.setForeground(Color.WHITE);
        confirm.setBounds(200, 530, 115, 25);
        confirm.setFocusable(false);
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tableModel.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "No item selected.", "Order Confirmation", JOptionPane.WARNING_MESSAGE);
                } else {
                    int confirmation = JOptionPane.showConfirmDialog(null, "Do you want to confirm your orders?", "Order Confirmation", JOptionPane.YES_NO_OPTION);
                    if (confirmation == JOptionPane.YES_OPTION) {
                        String _totalAmount = getTotalAmount();
                        OrderSlipSummaryFrame summary = new OrderSlipSummaryFrame(_totalAmount);
                        int[] selectedColumns = {1, 4, 5, 6, 7};
                        summary.addColumnsToDestinationTable(getColumnData(tableModel, selectedColumns));

                        tableModel.setRowCount(0);
                        numberList.clear();

                        updateTotal();
                    }
                }
            }
        });
        
        itemsPanel.add(next);
        itemsPanel.add(previous);
        itemsPanel.add(uniformsList);
        itemsPanel.add(uniformsLabel);

        orderSlipPanel.add(tablePanel);
        orderSlipPanel.add(itemCodeLabel);
        orderSlipPanel.add(quantityLabel);
        orderSlipPanel.add(sizeLabel);
        orderSlipPanel.add(itemCodeLabelTF);
        orderSlipPanel.add(quantityCB);
        orderSlipPanel.add(sizeCB);
        orderSlipPanel.add(add);
        orderSlipPanel.add(remove);
        orderSlipPanel.add(confirm);
        orderSlipPanel.add(orderSlipLabel);
        orderSlipPanel.add(note);

        addPanel(orderSlipPanel);
        addPanel(itemsPanel);

    }

    private void addItem() {
        ItemManagement itemManagement = new ItemManagement("", "", "", "", 0);

        String itemCode = itemCodeLabelTF.getText();
        String validateItemCode = itemManagement.getItemCode(itemCode);
        String item = itemManagement.getItem(itemCode);
        String description = itemManagement.getDescription(itemCode);
        String size = (String) sizeCB.getSelectedItem();
        String quantity = (String) quantityCB.getSelectedItem();
        double unitPrice = itemManagement.getPrice(itemCode, size);

        if (!itemCode.isEmpty() && !quantity.isEmpty() && !size.isEmpty()) {

            if (!itemCode.equals(validateItemCode)) {
                JOptionPane.showMessageDialog(null, "Invalid item code!", "Error", JOptionPane.ERROR_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(null, "Successfully added item!", "Add item", JOptionPane.INFORMATION_MESSAGE);

                int qty = Integer.parseInt(quantity);
                double price = unitPrice;
                double amount = qty * price;

                int rowNumber = numberList.size() + 1;
                numberList.add(rowNumber);

                tableModel.addRow(new Object[]{rowNumber, itemCode, item, description, size, quantity, price, amount});

                clearFields();

                updateTotal();
            }

        } else {
            JOptionPane.showMessageDialog(null, "You need to insert ITEM CODE!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateTotal() { 
        double total = 0.0;
        int rowCount = tableModel.getRowCount();

        for (int i = 0; i < rowCount; i++) {
            String priceString = tableModel.getValueAt(i, 7).toString();
            double price = Double.parseDouble(priceString);
            total += price;
        }

        amount.setText("Total Amount: " + total);
    }

    private void updateRowNumbers() {
        int rowCount = tableModel.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            tableModel.setValueAt(i + 1, i, 0);
            numberList.set(i, i + 1);
        }
    }

    private void clearFields() {
        itemCodeLabelTF.setText("");
        quantityCB.setSelectedItem(Integer.valueOf(0));
        sizeCB.setSelectedItem(Integer.valueOf(0));
    }

    private Vector<Vector<Object>> getColumnData(DefaultTableModel model, int[] columnIndices) {
        Vector<Vector<Object>> columnData = new Vector<>();

        for (int i = 0; i < model.getRowCount(); i++) {
            Vector<Object> rowData = new Vector<>();
            for (int columnIndex : columnIndices) {
                rowData.add(model.getValueAt(i, columnIndex));
            }
            columnData.add(rowData);
        }

        return columnData;
    }

    private String getTotalAmount() {
        String totalAmount = amount.getText();

        String total_amount = totalAmount;

        return total_amount;
    }
}
