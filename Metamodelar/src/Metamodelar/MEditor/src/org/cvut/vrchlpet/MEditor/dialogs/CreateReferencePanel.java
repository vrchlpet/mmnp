/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CreateReferencePanel.java
 *
 * Created on 14.4.2011, 16:00:05
 */

package org.cvut.vrchlpet.MEditor.dialogs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import org.cvut.vrchlpet.MController.IMasterController;
import org.cvut.vrchlpet.MCore.core.Element;
import org.cvut.vrchlpet.MCore.core.Reference;
import org.cvut.vrchlpet.MCore.core.Relation;

/**
 *
 * @author Vrchli
 */
public class CreateReferencePanel extends javax.swing.JPanel implements ActionListener{

    private IMasterController controller;
    private String element;
    private JDialog container;

    /** Creates new form CreateReferencePanel */
    public CreateReferencePanel(IMasterController controller, String element, JDialog container) {
        initComponents();
        this.controller = controller;
        this.container = container;
        setElement(element);


        btCancel.addActionListener(this);
        btCreate.addActionListener(this);

        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lbElementName = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        chRelation = new java.awt.Choice();
        jPanel2 = new javax.swing.JPanel();
        chOppositeElement = new java.awt.Choice();
        btCreate = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();

        jLabel1.setText(org.openide.util.NbBundle.getMessage(CreateReferencePanel.class, "CreateReferencePanel.jLabel1.text")); // NOI18N

        lbElementName.setText(org.openide.util.NbBundle.getMessage(CreateReferencePanel.class, "CreateReferencePanel.lbElementName.text")); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(CreateReferencePanel.class, "CreateReferencePanel.jPanel1.border.title"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chRelation, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(chRelation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(CreateReferencePanel.class, "CreateReferencePanel.jPanel2.border.title"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chOppositeElement, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(chOppositeElement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btCreate.setText(org.openide.util.NbBundle.getMessage(CreateReferencePanel.class, "CreateReferencePanel.btCreate.text")); // NOI18N

        btCancel.setText(org.openide.util.NbBundle.getMessage(CreateReferencePanel.class, "CreateReferencePanel.btCancel.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbElementName, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                        .addComponent(btCreate)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbElementName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCreate)
                    .addComponent(btCancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btCreate;
    private java.awt.Choice chOppositeElement;
    private java.awt.Choice chRelation;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbElementName;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();


        if ( source == btCancel) {
            container.dispose();
        } else if ( source == btCreate) {
            String relName = chRelation.getSelectedItem();
            Element sourceE = controller.getMModel().getModelInfo().findElement(element);
            String targetEName = chOppositeElement.getSelectedItem();
            Element targetE = controller.getMModel().getModelInfo().findElement(targetEName);
            Reference ref = controller.getElementManager().makeConnection(sourceE, targetE, relName);
            container.dispose();
            ReferenceEditorDialog referenceEditorDialog = new ReferenceEditorDialog(controller, ref);

        }
    }

    /**
     * @param controller the controller to set
     */
    public void setController(IMasterController controller) {
        this.controller = controller;
    }

    /**
     * @param element the element to set
     */
    public void setElement(String element) {
        this.element = element;

        lbElementName.setText(element);

        for ( Relation rel : controller.getMModel().getModel().getRelations()) {
            chRelation.add(rel.getNameSpace());
        }

        for ( Element el : controller.getMModel().getModel().getElements()) {
            chOppositeElement.add(el.getNameSpace());
        }
    }

}