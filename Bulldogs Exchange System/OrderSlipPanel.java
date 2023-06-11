
package BulldogsExchange;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class OrderSlipPanel extends ContentPanel implements ActionListener {
    private JPanel orderSlipPanel, itemsPanel;;
    private JButton confirm, print, next, previous, uniforms, sizes, merchandise, price ;
    private JLabel orderSlipLabel;
    private JTable table;

    OrderSlipPanel(int color) {
        super(color);

        itemsPanel = new JPanel();
        itemsPanel.setBackground(new Color(0xFFFF78));
        itemsPanel.setBounds(0, 0, 685, 585);
        itemsPanel.setLayout(null);
        
        uniforms = new JButton("UNIFORMS");
        
        sizes = new JButton("SIZES");
        
        next = new JButton("NEXT");
        next.setHorizontalAlignment(SwingConstants.CENTER);
        next.setFont(new Font("Tahoma", Font.BOLD, 15));
        next.setBackground(new Color(0x293478));
        next.setForeground(Color.WHITE);
        next.setBounds(375, 525, 115, 25);
        next.setFocusable(false);
        next.addActionListener(this);
        
        previous = new JButton("PREVIOUS");
        previous.setHorizontalAlignment(SwingConstants.CENTER);
        previous.setFont(new Font("Tahoma", Font.BOLD, 15));
        previous.setBackground(new Color(0x293478));
        previous.setForeground(Color.WHITE);
        previous.setBounds(175, 525, 115, 25);
        previous.setFocusable(false);
        previous.addActionListener(this);
        
        orderSlipPanel = new JPanel();
        orderSlipPanel.setBackground(new Color(0xFFBD59));
        orderSlipPanel.setBounds(685, 0, 500, 585);
        orderSlipPanel.setLayout(null);

        orderSlipLabel = new JLabel("ORDER SLIP FORM");
        orderSlipLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
        orderSlipLabel.setForeground(new Color(0x293476));
        orderSlipLabel.setBounds(110, 20, 280, 30);
        orderSlipLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center the label horizontally
        
        confirm = new JButton("CONFIRM");
        confirm.setHorizontalAlignment(SwingConstants.CENTER);
        confirm.setFont(new Font("Tahoma", Font.BOLD, 15));
        confirm.setBackground(new Color(0x293478));
        confirm.setForeground(Color.WHITE);
        confirm.setBounds(100, 525, 115, 25);
        confirm.setFocusable(false);
        confirm.addActionListener(this);

        print = new JButton("PRINT");
        print.setHorizontalAlignment(SwingConstants.CENTER);
        print.setFont(new Font("Tahoma", Font.BOLD, 15));
        print.setBackground(new Color(0x293478));
        print.setForeground(Color.WHITE);
        print.setBounds(300, 525, 115, 25);
        print.setFocusable(false);
        print.addActionListener(this);

        // Create the data model
        String[] columnNames = {"ITEM CODE", "SIZE", "QUANTITY", "UNIT PRICE", "AMOUNT"};
        OrderTableModel model = new OrderTableModel(columnNames);

        // Create the table
        table = new JTable(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setRowHeight(40); // Set the height of each cell
        TableColumn column;
        for (int i = 0; i < table.getColumnCount(); i++) {
            column = table.getColumnModel().getColumn(i);
            if (i == 0) {
                column.setPreferredWidth(150); // Set width of ITEMS column
            } else {
                column.setPreferredWidth(100); // Set width of other columns
            }
        }

        // Create the scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(600, 100));
        scrollPane.setBounds(20, 70, 460, 423);

        table.setFillsViewportHeight(true); // Remove excess part at the bottom

        orderSlipPanel.add(orderSlipLabel);
        orderSlipPanel.add(scrollPane);
        orderSlipPanel.add(confirm);
        orderSlipPanel.add(print);
        
        itemsPanel.add(next);
        itemsPanel.add(previous);

        addPanel(orderSlipPanel);
        addPanel(itemsPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static class OrderTableModel extends AbstractTableModel {
    private String[] columnNames;
    private Object[][] data;
    private double totalAmount = 0.0;

        public OrderTableModel(String[] columnNames) {
            this.columnNames = columnNames;
            this.data = new Object[][]{
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"END", "END", "END", "TOTAL: ", "0.00"}
            };
        }

        @Override
        public int getRowCount() {
            return data.length;
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public String getColumnName(int column) {
            return columnNames[column];
        }

        @Override
        public Object getValueAt(int row, int column) {
            return data[row][column];
        }

        @Override
        public void setValueAt(Object value, int row, int column) {
            data[row][column] = value;
            fireTableCellUpdated(row, column); // Notify listeners about the updated value
            if (column == 2 || column == 3) {
                updateAmount(row);
            }
        }

        @Override
        public Class<?> getColumnClass(int column) {
            return String.class;
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return true;
        }

        private void updateAmount(int row) {
            String quantityStr = (String) data[row][2];
            String unitPriceStr = (String) data[row][3];
            if (!quantityStr.isEmpty() && !unitPriceStr.isEmpty()) {
                int quantity = Integer.parseInt(quantityStr);
                double unitPrice = Double.parseDouble(unitPriceStr);
                double amount = quantity * unitPrice;
                data[row][4] = String.format("%.2f", amount);
                fireTableCellUpdated(row, 4); // Notify listeners about the updated amount
            }

            // Calculate the total amount
            double totalAmount = 0.0;
            for (int r = 0; r < data.length - 1; r++) { // Exclude the last row
                String amountStr = (String) data[r][4];
                if (!amountStr.isEmpty()) {
                    double amount = Double.parseDouble(amountStr);
                    totalAmount += amount;
                }
            }

            // Update the "Total" cell in the last row
            int lastRow = data.length - 1;
            data[lastRow][4] = String.format("%.2f", totalAmount);
            fireTableCellUpdated(lastRow, 4); // Notify listeners about the updated total amount
        }
    }
}    
