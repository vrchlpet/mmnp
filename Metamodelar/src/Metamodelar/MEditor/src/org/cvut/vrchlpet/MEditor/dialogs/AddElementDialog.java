

package org.cvut.vrchlpet.MEditor.dialogs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.cvut.vrchlpet.MController.IMasterController;
import org.cvut.vrchlpet.MEditor.controller.AddElement;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class AddElementDialog extends MAbstractDialog implements ActionListener{

    public static final String DEFFAULT_TITLE = "Add element";

    private IMasterController controller;

    private JTextField nameField;
    private JButton okButton;
    private JButton addButton;
    private JLabel nameLabel;




    public AddElementDialog(IMasterController controller) {
        super(DEFFAULT_TITLE);
        this.controller = controller;
        init();
    }

    private void init() {
        JPanel panel = new JPanel();
        nameField = new JTextField(30);
        okButton = new JButton("ok");
        addButton = new JButton("add");
        JPanel buttomPanel = new JPanel();
        buttomPanel.setLayout(new FlowLayout());
        panel.setLayout(new BorderLayout());
        nameLabel = new JLabel("element name: ");
        panel.add(buttomPanel, BorderLayout.SOUTH);
        panel.add(nameLabel, BorderLayout.WEST);
        panel.add(nameField, BorderLayout.CENTER);
        panel.add(addButton, BorderLayout.EAST);
        buttomPanel.add(okButton);

        okButton.addActionListener(this);
        addButton.addActionListener( new AddElement(this));

        setContent(panel);
    }

    public String getElementName() {
        return this.nameField.getText();
    }

    /**
     * @return the model
     */
    public IMasterController getController() {
        return controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.dispose();
    }


}
