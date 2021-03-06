package cz.datalite.zk.bind;

import org.zkoss.zk.ui.AbstractComponent;
import org.zkoss.zk.ui.Component;

/**
 * Interface for BinderHelper defining the util methods which it has to
 * implement to properly work with databinding. This interface is designed based
 * the GoF pattern strategy to support multiple versions for binding.
 *
 * @author Karel Cemus
 */
public interface BinderHelper {

    /**
     * Loads all component attributes
     *
     * @param comp component to be loaded
     */
    void loadComponent( Component comp );

    /**
     * Loads the attribute of the component
     *
     * @param comp component to be loaded
     * @param attribute attribute to be loaded
     */
    @Deprecated
    void loadComponentAttribute( Component comp, String attribute );

    /**
     * Stores the component using databinding
     *
     * @param comp comopnent to be stored
     * 
     * @return whether all related bindings was saved successfully
     */
    boolean saveComponent( Component comp );

    /**
     * Saves the attribute of the component
     *
     * @param comp component to be saved
     * @param attribute attribute to be saved
     * 
     * @return whether the binding was saved successfully
     */
    @Deprecated
    boolean saveComponentAttribute( Component comp, String attribute );

    /**
     * Load given attributes on the given component
     *
     * @param comp component to be loaded
     * @param attributes list of attributes to be loaded
     */
    @Deprecated
    void loadComponentAttributes( Component comp, String[] attributes );

    /**
     * Registers the annotation on component
     *
     * @param component annotated component
     * @param property property of the component
     * @param annotName annotation name
     * @param value annotation value
     */
    void registerAnnotation( final AbstractComponent component, final String property, final String annotName, final String value );

    /**
     * Sends the notification that the model has changed
     * 
     * @param bean instance of bean with model
     * @param model property name
     * @since ZK-DL 1.4.0 and ZK 6, binding 2.0
     */
    void notifyChange( Object bean, String model );

    /**
     * Returns the version of data binding what the helper supports
     *
     * @return version of data binding
     */
    int version();
    
    /**
     * Resolves converter name in the context of current binding
     * 
     * @param converter converter name, class or method
     * @param component component with converter
     * @return 
     */
    Object resolveConverter( final String converter, final Component component );
}
