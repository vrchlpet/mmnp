
package org.cvut.vrchlpet.MFileType;

import java.io.IOException;
import org.openide.filesystems.FileObject;
import org.openide.loaders.DataNode;
import org.openide.loaders.DataObjectExistsException;
import org.openide.loaders.MultiDataObject;
import org.openide.loaders.MultiFileLoader;
import org.openide.nodes.CookieSet;
import org.openide.nodes.Node;
import org.openide.nodes.Children;
import org.openide.util.Lookup;


    /**
     *
     * Trida, reprezentujici data typu ".mm"/".MM" a akce pro otevreni metamodelu v editoru
     *
     * @author Vrchlavsky Petr
     * @version 1.0
     */
public class MMDataObject extends MultiDataObject {

    public MMDataObject(FileObject pf, MultiFileLoader loader) throws DataObjectExistsException, IOException {
        super(pf, loader);
        CookieSet cookies = getCookieSet();
        cookies.add((Node.Cookie) new MMOpenSupport(getPrimaryEntry()));// podpora otevreni metamodelu v editoru
        cookies.add((Node.Cookie) new ModelData(pf.getPath())); // zabalena data - serializer pro nahrani metamodelu + samotny metamodel

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
