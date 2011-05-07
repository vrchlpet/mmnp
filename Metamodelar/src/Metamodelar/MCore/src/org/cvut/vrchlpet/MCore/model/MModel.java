

package org.cvut.vrchlpet.MCore.model;

import java.util.ArrayList;
import java.util.Date;
import org.cvut.vrchlpet.MCore.core.Model;
import org.cvut.vrchlpet.MCore.util.IModelBuilder;
import org.cvut.vrchlpet.MCore.util.IModelInfo;
import org.cvut.vrchlpet.MCore.util.Notifyer;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class MModel extends Notifyer implements IMModel{


    private IModelBuilder builder;
    private ArrayList<Author> authors;
    private Date theCreationDate; // datum vytvoreni;
    private IModelInfo info;

    
    public MModel() {}
    
    public MModel(IModelBuilder builder, IModelInfo info) {
        this.builder = builder;
        this.builder.setMModel(this);
        this.authors = new ArrayList<Author>();
        this.theCreationDate = new Date();
        this.info = info;
        info.setMModel(this);
    }

    @Override
    public Model getModel() {
        return this.builder.getModel();
    }


    /**
     * @return the authors
     */
    @Override
    public ArrayList<Author> getAuthors() {
        return this.authors;
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
