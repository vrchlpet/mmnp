

package org.cvut.vrchlpet.Metamodelar.core;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class Classifier implements IPropertyChangeObserver{

    protected String nameSpace;
    protected String description;

    public static final String DEFAULT_NAMESPACE = "empty namespace";
    public static final String DEfAULT_DESCRIPTION = "empty description";

    protected ArrayList<PropertyChangeListener> propertyChangeListeners;

    public Classifier() {
        propertyChangeListeners = new ArrayList<PropertyChangeListener>();
        this.nameSpace = DEFAULT_NAMESPACE;
        this.description = DEfAULT_DESCRIPTION;
    }

    public Classifier(String namseSpace, String description) {
        this();
        this.nameSpace = namseSpace;
        this.description = description;
    }


    @Override
    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        this.propertyChangeListeners.add(pcl);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        this.propertyChangeListeners.remove(pcl);
    }

    @Override
    public void firePropertyChange(String parameterName, Object oldValue, Object newValue) {
        if ( propertyChangeListeners.isEmpty())
            return;

        PropertyChangeEvent pce = new PropertyChangeEvent(this, parameterName, oldValue, newValue);

        for ( PropertyChangeListener pcl : propertyChangeListeners) {
            pcl.propertyChange(pce);
        }
    }

    /**
     * @return the nameSpace
     */
    public String getNameSpace() {
        return nameSpace;
    }

    /**
     * @param nameSpace the nameSpace to set
     */
    public void setNameSpace(String nameSpace) {
        String old = this.nameSpace;
        this.nameSpace = nameSpace;
        firePropertyChange("nameSpace", old, this.nameSpace);
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        String old = this.description;
        this.description = description;
        firePropertyChange("description", old, this.description);
    }

}