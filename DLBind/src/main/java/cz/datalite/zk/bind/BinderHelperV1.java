package cz.datalite.zk.bind;

import org.zkoss.zk.ui.AbstractComponent;
import org.zkoss.zk.ui.Component;
import org.zkoss.zkplus.databind.Binding;
import org.zkoss.zkplus.databind.DataBinder;

/**
 * Implementation of Binding utils for databinding in version 1.0 what came with
 * ZK in the project beginning.
 *
 * @author Karel Cemus <cemus@datalite.cz>
 */
/* package */ class BinderHelperV1 implements BinderHelper {

    /* package */ static final BinderHelperV1 INSTANCE = new BinderHelperV1();

    protected BinderHelperV1() {
        // inner library class, singleton
    }

    public void loadComponent( Component comp ) {
        getBinder( comp ).loadComponent( comp );
    }

    public void loadComponentAttribute( Component comp, String attribute ) {
        Binding bind = getBinder( comp ).getBinding( comp, attribute );
        if ( bind != null )
            bind.loadAttribute( comp );
    }

    public void saveComponent( Component comp ) {
        getBinder( comp ).saveComponent( comp );
    }

    public void saveComponentAttribute( Component comp, String attribute ) {
        if ( getBinder( comp ) != null ) {
            Binding bind = getBinder( comp ).getBinding( comp, attribute );
            if ( bind != null )
                bind.saveAttribute( comp );
        }
    }

    public void loadComponentAttributes( Component comp, String[] attributes ) {
        for ( String attr : attributes ) {
            loadComponentAttribute( comp, attr );
        }
    }

    public void registerAnnotation( AbstractComponent component, String property, String annotName, String value ) {
        final java.util.Map<String, String[]> map = new java.util.HashMap<String, String[]>();
        map.put( annotName, new String[]{ value } );
        component.addAnnotation( property, "default", map );
    }

    public void notifyChange( Object bean, String model ) {
        throw new UnsupportedOperationException( "Not supported in this version of databinding. Please use binding 2.0 or later." );
    }

    public int version() {
        return 1;
    }

    protected DataBinder getBinder( Component comp ) {
        return ( DataBinder ) comp.getAttributeOrFellow( "binder", true );
    }
}
