/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ElementEditorPanel.java
 *
 * Created on 15.4.2011, 13:01:16
 */

package org.cvut.vrchlpet.MEditor.dialogs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import org.cvut.vrchlpet.MEditor.controller.IMasterController;
import org.cvut.vrchlpet.MCore.core.Attribute;
import org.cvut.vrchlpet.MCore.core.Element;
import org.cvut.vrchlpet.MCore.core.Reference;

/**
 *
 * @author Vrchli
 */
public class ElementEditorPanel extends javax.swing.JPanel implements PropertyChangeListener, ActionListener, ItemListener{

    private Element element;
    private IMasterController controller;
    private JDialog container;



    /** Creates new form ElementEditorPanel */
    public ElementEditorPanel(IMasterController controller, Element element, JDialog container) {
        initComponents();
        this.container = container;
        this.controller = controller;
        setElement(element);
        btOk.addActionListener(this);
        btAddAtt.addActionListener(this);
        btAddRef.addActionListener(this);
        btRemoveAtt.addActionListener(this);
        btRemoveRef.addActionListener(this);
        btEditAtt.addActionListener(this);
        btEditRef.addActionListener(this);
        chSuperType.addItemListener(this);
        btRename.addActionListener(this);
        btChangeDesc.addActionListener(this);

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
        chSuperType = new java.awt.Choice();
        jLabel2 = new javax.swing.JLabel();
        lbSuperElement = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        listReferences = new java.awt.List();
        btAddRef = new javax.swing.JButton();
        btRemoveRef = new javax.swing.JButton();
        btEditRef = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        listAtt = new java.awt.List();
        btAddAtt = new javax.swing.JButton();
        btRemoveAtt = new javax.swing.JButton();
        btEditAtt = new javax.swing.JButton();
        btOk = new javax.swing.JButton();
        btRename = new javax.swing.JButton();
        btChangeDesc = new javax.swing.JButton();

        jLabel1.setText(org.openide.util.NbBundle.getMessage(ElementEditorPanel.class, "ElementEditorPanel.jLabel1.text")); // NOI18N

        lbElementName.setText(org.openide.util.NbBundle.getMessage(ElementEditorPanel.class, "ElementEditorPanel.lbElementName.text")); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(ElementEditorPanel.class, "ElementEditorPanel.jPanel1.border.title"))); // NOI18N

        chSuperType.setEnabled(false);

        jLabel2.setText(org.openide.util.NbBundle.getMessage(ElementEditorPanel.class, "ElementEditorPanel.jLabel2.text")); // NOI18N

        lbSuperElement.setText(org.openide.util.NbBundle.getMessage(ElementEditorPanel.class, "ElementEditorPanel.lbSuperElement.text")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chSuperType, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbSuperElement, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbSuperElement))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chSuperType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(ElementEditorPanel.class, "ElementEditorPanel.jPanel2.border.title"))); // NOI18N

        btAddRef.setText(org.openide.util.NbBundle.getMessage(ElementEditorPanel.class, "ElementEditorPanel.btAddRef.text")); // NOI18N

        btRemoveRef.setText(org.openide.util.NbBundle.getMessage(ElementEditorPanel.class, "ElementEditorPanel.btRemoveRef.text")); // NOI18N

        btEditRef.setText(org.openide.util.NbBundle.getMessage(ElementEditorPanel.class, "ElementEditorPanel.btEditRef.text")); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(listReferences, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btEditRef, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btAddRef, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btRemoveRef, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listReferences, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btAddRef)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btRemoveRef)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btEditRef)))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(ElementEditorPanel.class, "ElementEditorPanel.jPanel3.border.title"))); // NOI18N

        btAddAtt.setText(org.openide.util.NbBundle.getMessage(ElementEditorPanel.class, "ElementEditorPanel.btAddAtt.text")); // NOI18N

        btRemoveAtt.setText(org.openide.util.NbBundle.getMessage(ElementEditorPanel.class, "ElementEditorPanel.btRemoveAtt.text")); // NOI18N

        btEditAtt.setText(org.openide.util.NbBundle.getMessage(ElementEditorPanel.class, "ElementEditorPanel.btEditAtt.text")); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(listAtt, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btRemoveAtt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btAddAtt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btEditAtt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(listAtt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btAddAtt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btRemoveAtt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btEditAtt)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btOk.setText(org.openide.util.NbBundle.getMessage(ElementEditorPanel.class, "ElementEditorPanel.btOk.text")); // NOI18N

        btRename.setText(org.openide.util.NbBundle.getMessage(ElementEditorPanel.class, "ElementEditorPanel.btRename.text")); // NOI18N

        btChangeDesc.setText(org.openide.util.NbBundle.getMessage(ElementEditorPanel.class, "ElementEditorPanel.btChangeDesc.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbElementName, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btOk))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btChangeDesc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(btRename)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbElementName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btChangeDesc)
                    .addComponent(btRename))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btOk)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAddAtt;
    private javax.swing.JButton btAddRef;
    private javax.swing.JButton btChangeDesc;
    private javax.swing.JButton btEditAtt;
    private javax.swing.JButton btEditRef;
    private javax.swing.JButton btOk;
    private javax.swing.JButton btRemoveAtt;
    private javax.swing.JButton btRemoveRef;
    private javax.swing.JButton btRename;
    private java.awt.Choice chSuperType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbElementName;
    private javax.swing.JLabel lbSuperElement;
    private java.awt.List listAtt;
    private java.awt.List listReferences;
    // End of variables declaration//GEN-END:variables

    private void fillForm() {
        chSuperType.setEnabled(true);

        chSuperType.removeAll();
        
        lbSuperElement.setText(element.getSuperElement() != null ? element.getSuperElement().getNameSpace() : "------");
        
        
        chSuperType.add("------");
        for ( Element el : element.getModel().getElements()) {
            if ( el != element) {
                if ( !el.getAllSuperElements().contains(element)) {
                    chSuperType.add(el.getNameSpace());
                }
            }
        }
        
        if ( element.getSuperElement() != null) {
            chSuperType.select(element.getSuperElement().getNameSpace());
        }

        lbElementName.setText(element.getNameSpace());

        listReferences.removeAll();
        for (Reference ref : element.getReferences()) {
            listReferences.add(ref.getReferenceType().getNameSpace());
        }

        listAtt.removeAll();
        for ( Attribute at : element.getAttributes()) {
            listAtt.add(at.getName());
        }


    }

    public void setElement(Element el) {
        if ( this.element != null)
            this.element.removePropertyChangeListener(this);

        this.element = el;
        this.element.addPropertyChangeListener(this);
        fillForm();
    }



    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        fillForm();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object s = e.getSource();

        if ( s == btAddAtt) {
            String name = JOptionPane.showInputDialog("Type in the name of the new attribute");
            if ( name == null || name.length() == 0) {
                DialogMessagesManager.showErrorDialog("Empty name!");
                return;
            }


            Attribute at = null;


            if ( (at = controller.getElementManager().createAttribute(element, name)) != null) {
                AttributeEditorDialog attEditorDialog = new AttributeEditorDialog(controller, at);
            } else {
               DialogMessagesManager.showErrorDialog("Exception has occured!");
            }
        } else if ( s == btAddRef) {
            
            CreateReferenceDialog createRefDiag = new CreateReferenceDialog(controller, element.getNameSpace());
        } else if ( s == btRemoveAtt) {
            if ( listAtt.getSelectedIndex() == -1)
                return;
            
            String name = listAtt.getSelectedItem();
            Attribute at = controller.getMModel().getModelInfo().findAttribute(element, name);
            controller.getElementManager().removeAttribute(at);
        } else if ( s == btRemoveRef) {
            if ( listReferences.getSelectedIndex() == -1)
                return;

            Reference ref = element.getReferences().get(listReferences.getSelectedIndex());
            controller.getElementManager().removeReference(element, ref);
        } else if ( s == btEditAtt) {
            if ( listAtt.getSelectedIndex() == -1)
                return;

            String name = listAtt.getSelectedItem();
            Attribute at = controller.getMModel().getModelInfo().findAttribute(element, name);
            AttributeEditorDialog attributeEditorDialog = new AttributeEditorDialog(controller, at);
        } else if ( s == btEditRef) {
            if ( listReferences.getSelectedIndex() == -1)
                return;

            Reference ref = element.getReferences().get(listReferences.getSelectedIndex());
            ReferenceEditorDialog refD = new ReferenceEditorDialog(controller, ref);
        } else if (s == btOk) {
            container.dispose();
        } else if ( s == btChangeDesc) {
            String newText = JOptionPane.showInputDialog(container, "Type in new description", element.getDescription());
            if ( newText != null) {
                controller.getMetaObjectManager().changeDescriptio(element, newText);
            }
        } else if ( s == btRename) {
            String newText = JOptionPane.showInputDialog(container, "Type in new namespace", element.getNameSpace());
            if ( newText != null) {
                if ( controller.getMetaObjectManager().changeNamespace(element, newText)) {
                    fillForm();
                } else {
                    DialogMessagesManager.showErrorDialog("Bad input data");
                }
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if ( chSuperType.getSelectedIndex() == -1)
            return;
        
        if ( chSuperType.getSelectedIndex() == 0) {
            controller.getElementManager().setElementSuperType(element, null);
        }

        String name = chSuperType.getSelectedItem();
        controller.getElementManager().setElementSuperType(element, name);

    }

    /**
     * @param controller the controller to set
     */
    public void setController(IMasterController controller) {
        this.controller = controller;
    }

    void close() {
        if ( element != null)
            element.removePropertyChangeListener(this);
    }

}
