/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cvut.MMN.view.core;

import java.awt.BorderLayout;
import java.awt.Image;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JToolBar;
import org.cvut.MMN.controller.IController;
import org.cvut.MMN.view.palette.ConCategoryContainer;
import org.cvut.MMN.view.palette.ConPaletteManager;
import org.cvut.MMN.view.palette.MyPaletteActions;
import org.netbeans.core.spi.multiview.CloseOperationState;
import org.netbeans.core.spi.multiview.MultiViewElementCallback;
import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;
import org.netbeans.api.settings.ConvertAsProperties;
import org.netbeans.core.spi.multiview.MultiViewElement;
import org.netbeans.spi.palette.PaletteActions;
import org.netbeans.spi.palette.PaletteController;
import org.netbeans.spi.palette.PaletteFactory;
import org.openide.awt.UndoRedo;
import org.openide.nodes.AbstractNode;
import org.openide.util.Lookup;
import org.openide.util.lookup.Lookups;
import org.openide.util.Utilities;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(dtd = "-//org.cvut.MMN.view.core//ConView//EN",
autostore = false)
public final class ConViewTopComponent extends TopComponent implements MultiViewElement{


    private JToolBar toolbar = new JToolBar();
    private MultiViewElementCallback callback = null;
    private IController controller;

    private JButton btAddCon;
    private Lookup lookup;
    private PaletteController p;

    private JButton btRemoveCon;
    private JButton btEditCon;

    private static ConViewTopComponent instance;
    /** path to the icon used by the component and its open action */
//    static final String ICON_PATH = "SET/PATH/TO/ICON/HERE";
    private static final String PREFERRED_ID = "ConViewTopComponent";

    private ConPaletteManager paletteRoot;

    private JComponent myView;

    public ConViewTopComponent(IController controller) {

        initComponents();

        this.controller = controller;

        Image image = Utilities.loadImage("org/cvut/MMN/view/core/addConnection.gif");
        ImageIcon iconBtAddCon = new ImageIcon(image);
        btAddCon = new JButton(iconBtAddCon);
        btAddCon.addActionListener(new AddConActionListener(this));
        btAddCon.setToolTipText("Add new connection");
        toolbar.setFloatable(false);




        toolbar.add(new JToolBar.Separator());
        toolbar.add(btAddCon);


        Image image2 = Utilities.loadImage("org/cvut/MMN/view/core/removeConnection.gif");
        ImageIcon iconBtRemoveCon = new ImageIcon(image2);
        btRemoveCon = new JButton(iconBtRemoveCon);
        btRemoveCon.addActionListener(new RemoveConnectionActionListener(this));
        btRemoveCon.setToolTipText("Remove connection");
        toolbar.add(btRemoveCon);

        btEditCon = new JButton("Edit");
        btEditCon.addActionListener( new EditConActionListener(this.getController()));
        btEditCon.setToolTipText("Edit shapes");
        toolbar.add(btEditCon);

        GraphSceneImpl scene = new GraphSceneImpl(this.controller);
        scene.addAcceptAction(new SceneAcceptProvider(scene));
        myView = scene.createView();

        scenePane.setViewportView(myView);
        add(scene.createSatelliteView(), BorderLayout.WEST);


        refreshPalette();


    }

    public IController getController() {
        return this.controller;
    }

    public ConPaletteManager getConPaletteManager() {
        return this.paletteRoot;
    }

    public ConViewTopComponent() {
        initComponents();
        setName(NbBundle.getMessage(ConViewTopComponent.class, "CTL_ConViewTopComponent"));
        setToolTipText(NbBundle.getMessage(ConViewTopComponent.class, "HINT_ConViewTopComponent"));
//        setIcon(ImageUtilities.loadImage(ICON_PATH, true));
    }

    public void refreshPalette() {
        paletteRoot = new ConPaletteManager(new ConCategoryContainer(controller));
        PaletteActions a = new MyPaletteActions();
        p = PaletteFactory.createPalette(paletteRoot, a);
    }

    @Override
    public Lookup getLookup() {

        lookup = Lookups.fixed(p);
        return lookup;
    }

    public AbstractNode getPaletteRoot() {
        return this.paletteRoot;
    }



    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scenePane = new javax.swing.JScrollPane();

        setLayout(new java.awt.BorderLayout());
        add(scenePane, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane scenePane;
    // End of variables declaration//GEN-END:variables
    /**
     * Gets default instance. Do not use directly: reserved for *.settings files only,
     * i.e. deserialization routines; otherwise you could get a non-deserialized instance.
     * To obtain the singleton instance, use {@link #findInstance}.
     */
    public static synchronized ConViewTopComponent getDefault() {
        if (instance == null) {
            instance = new ConViewTopComponent();
        }
        return instance;
    }

    /**
     * Obtain the ConViewTopComponent instance. Never call {@link #getDefault} directly!
     */
    public static synchronized ConViewTopComponent findInstance() {
        TopComponent win = WindowManager.getDefault().findTopComponent(PREFERRED_ID);
        if (win == null) {
            Logger.getLogger(ConViewTopComponent.class.getName()).warning(
                    "Cannot find " + PREFERRED_ID + " component. It will not be located properly in the window system.");
            return getDefault();
        }
        if (win instanceof ConViewTopComponent) {
            return (ConViewTopComponent) win;
        }
        Logger.getLogger(ConViewTopComponent.class.getName()).warning(
                "There seem to be multiple components with the '" + PREFERRED_ID
                + "' ID. That is a potential source of errors and unexpected behavior.");
        return getDefault();
    }

    @Override
    public int getPersistenceType() {
        return TopComponent.PERSISTENCE_NEVER;
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    Object readProperties(java.util.Properties p) {
        if (instance == null) {
            instance = this;
        }
        instance.readPropertiesImpl(p);
        return instance;
    }

    private void readPropertiesImpl(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }

    @Override
    protected String preferredID() {
        return PREFERRED_ID;
    }








    @Override
    public JComponent getVisualRepresentation() {
        return this;
    }

    @Override
    public JComponent getToolbarRepresentation(){
        return toolbar;
    }

    @Override
    public Action[] getActions(){
        if(callback != null) {
            return callback.createDefaultActions();
        } else {
            return new Action[]{};
        }
    }

    @Override
    public void componentOpened(){
        //callback.updateTitle("View 1");
    }

    @Override
    public void componentClosed(){}

    @Override
    public void componentShowing(){}

    @Override
    public void componentHidden(){}

    @Override
    public void componentActivated(){
        //callback.updateTitle("View 1");
    }

    @Override
    public void componentDeactivated(){}

    @Override
    public UndoRedo getUndoRedo(){
        return UndoRedo.NONE;
    }

    @Override
    public void setMultiViewCallback(MultiViewElementCallback mvec){
        callback = mvec;
    }

    @Override
    public CloseOperationState canCloseElement(){
        return CloseOperationState.STATE_OK;
    }




}