/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cvut.MMN.core;

import java.io.IOException;
import org.cvut.MMN.model.Metamodel;
import org.openide.filesystems.FileObject;
import org.openide.loaders.DataNode;
import org.openide.loaders.DataObjectExistsException;
import org.openide.loaders.MultiDataObject;
import org.openide.loaders.MultiFileLoader;
import org.openide.nodes.CookieSet;
import org.openide.nodes.Node;
import org.openide.nodes.Children;
import org.openide.util.Lookup;

public class MMDataObject extends MultiDataObject {

    public MMDataObject(FileObject pf, MultiFileLoader loader)
            throws DataObjectExistsException, IOException {

        super(pf, loader);
        CookieSet cookies = getCookieSet();
        cookies.add((Node.Cookie) new MMOpenSupport(getPrimaryEntry()));
        cookies.add((Node.Cookie) new MetamodelData(pf.getPath()));
    }

    @Override
    protected Node createNodeDelegate() {
        return new DataNode(this, Children.LEAF, getLookup());
    }

    @Override
    public Lookup getLookup() {
        return getCookieSet().getLookup();
    }
}
