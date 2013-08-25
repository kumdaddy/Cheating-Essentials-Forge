package com.kodehawa.api;

import com.kodehawa.CheatingEssentials;
import com.kodehawa.gui.api.components.Frame;
import com.kodehawa.gui.api.components.Item;
import com.kodehawa.render.GLHelper;
import com.kodehawa.util.wrapper.Wrapper;


public class ApiMethods {
    
	
    public static CheatingEssentials getCE( ) {
        return CheatingEssentials.getCheatingEssentials( );
    }
    
    /**
     * Returns the Wrapper. This has many useful methods in it.
     * 
     * @return
     */
    public static Wrapper getWrapper( ) {
        return getCE( ).getModWrapper( );
    }
    
    /**
     * Returns a new instance of the GLHelper. This class is used for things
     * such as drawing ESP boxes.
     * 
     * @return
     */
    public static GLHelper getGLHelper( ) {
        return new GLHelper( );
    }
    
    
    
    /**
     * Adds a Frame to the GUI. Not much to say here...
     * 
     * @param e
     */
    public static void addFrame( Frame e ) {
        
    }

    
    /**
     * Adds the child to the Frame specified by the given name.
     * 
     * @param frame
     * @param child
     */
    public static void addChildToFrame( String frame, Item child ) {
        for( Frame e : getWrapper( ).getGui( ).frames ) {
            if( e.text.equalsIgnoreCase( frame ) ) {
                e.addChild( child );
                break;
            }
        }
    }
}
