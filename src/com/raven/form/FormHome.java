package com.raven.form;

import com.raven.component.Item;
import com.raven.event.EventItem;
import com.raven.main.dbase;
import com.raven.model.ModelItem;
import com.raven.swing.ScrollBar;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import javax.swing.SwingUtilities;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FormHome extends javax.swing.JPanel {

    public void setEvent(EventItem event) {
        this.event = event;
    }

    private EventItem event;

    public FormHome() {
        initComponents();
        scroll.setVerticalScrollBar(new ScrollBar());
    }

    public void addItem(ModelItem data) {
        Item item = new Item();
        item.setData(data);
        item.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me)) {
                    event.itemClick(item, data);
                }
            }
        });
        panelItem.add(item);
        panelItem.repaint();
        panelItem.revalidate();
    }

    public void setSelected(Component item) {
        for (Component com : panelItem.getComponents()) {
            Item i = (Item) com;
            if (i.isSelected()) {
                i.setSelected(false);
            }
        }
        ((Item) item).setSelected(true);
    }

    public void showItem(ModelItem data) {
        lbItemName.setText(data.getItemName());
        txtDescription.setText(data.getDescription());
        lbBrand.setText(data.getBrandName());
        DecimalFormat df = new DecimalFormat("P#,##0.00");
        lbPrice.setText(df.format(data.getPrice()));

        int pid1 = data.getItemID();
        String pid2 = String.valueOf(pid1);

        pid.setText(pid2);
        pid.setVisible(false);
    }

    public Point getPanelItemLocation() {
        Point p = scroll.getLocation();
        return new Point(p.x, p.y - scroll.getViewport().getViewPosition().y);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scroll = new javax.swing.JScrollPane();
        panelItem = new com.raven.swing.PanelItem();
        jPanel1 = new javax.swing.JPanel();
        panelShadow1 = new com.raven.swing.PanelShadow();
        txtDescription = new javax.swing.JTextPane();
        lbItemName = new javax.swing.JLabel();
        lbBrand = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        pid = new javax.swing.JLabel();
        panelBorder1 = new com.raven.swing.PanelBorder();
        lbPrice = new javax.swing.JLabel();

        setOpaque(false);

        scroll.setBorder(null);
        scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panelItem.setBackground(new java.awt.Color(51, 51, 51));
        scroll.setViewportView(panelItem);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        panelShadow1.setBackground(new java.awt.Color(239, 243, 251));

        txtDescription.setBorder(null);
        txtDescription.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        txtDescription.setForeground(new java.awt.Color(122, 113, 113));
        txtDescription.setFocusable(false);
        txtDescription.setOpaque(false);

        lbItemName.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        lbItemName.setForeground(new java.awt.Color(73, 69, 69));
        lbItemName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbItemName.setText("Select a Car to Display");

        lbBrand.setFont(new java.awt.Font("sansserif", 3, 14)); // NOI18N
        lbBrand.setForeground(new java.awt.Color(73, 69, 69));
        lbBrand.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbBrand.setText(" ");

        jButton1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton1.setText("Add to Cart");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pid, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lbItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbBrand)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDescription, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pid, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        lbPrice.setBackground(new java.awt.Color(204, 204, 204));
        lbPrice.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        lbPrice.setForeground(new java.awt.Color(73, 69, 69));
        lbPrice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 899, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String query = "INSERT INTO product_info (product_id, product_name,price,product_brand,quantity) VALUES (?, ?, ?, ?, ?)";

        String textValue = lbPrice.getText();
// Remove formatting characters such as commas or currency symbols
        String cleanedTextValue = textValue.replaceAll("[^\\d.]", "");

        Float prodprice = null;
        try {
            prodprice = Float.parseFloat(cleanedTextValue);
        } catch (NumberFormatException e) {
            System.err.println("Error: Cannot convert string to float. Invalid format.");
            // Optionally, handle the error gracefully or provide feedback to the user
        }

        String prods_id = pid.getText();
        int prod_id = Integer.parseInt(prods_id);
        String prodname = lbItemName.getText();
        String prodbrand = lbBrand.getText();

        int prod_quantity = 1;

        try (PreparedStatement preparedStatement = dbase.urcon().prepareStatement(query)) {
            preparedStatement.setInt(1, prod_id);
            preparedStatement.setString(2, prodname);
            preparedStatement.setFloat(3, prodprice);
            preparedStatement.setString(4, prodbrand);
            preparedStatement.setInt(5, prod_quantity);

            preparedStatement.executeUpdate();

            System.out.println("sucess");

        } catch (SQLException e) {
            e.printStackTrace();

        }


    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbBrand;
    private javax.swing.JLabel lbItemName;
    private javax.swing.JLabel lbPrice;
    private com.raven.swing.PanelBorder panelBorder1;
    private com.raven.swing.PanelItem panelItem;
    private com.raven.swing.PanelShadow panelShadow1;
    private javax.swing.JLabel pid;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTextPane txtDescription;
    // End of variables declaration//GEN-END:variables
}
