

package org.cvut.vrchlpet.MCore.model;


import java.util.Date;
import org.cvut.vrchlpet.MCore.core.Model;
import org.cvut.vrchlpet.MCore.util.Notifyer;

/**
 *
 * Implementace modelu
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class MModel extends Notifyer implements IMModel{


    private IModelBuilder builder;
    private Date theCreationDate; // datum vytvoreni;
    private IModelInfo info;

    
    
    public MModel(IModelBuilder builder, IModelInfo info) {
        this.builder = builder;
        this.builder.setMModel(this);
        this.theCreationDate = new Date();
        this.info = info;
        info.setMModel(this);
    }

    @Override
    public Model getModel() {
        return this.builder.getModel();
    }



    /**
     * @return the theCreationDate
     */
    @Override
    public Date getTheCreationDate() {
        return this.theCreationDate;
    }

    /**
     * @return the factory
     */
    @Override
    public IModelBuilder getBuilder() {
        return this.builder;
    }

    @Override
    public IModelInfo getModelInfo() {
        return this.info;
    }

    @Override
    public void setModelInfo(IModelInfo info) {
        if ( info != null)
            this.info.setMModel(null);
        
        this.info = info;
    }
}
