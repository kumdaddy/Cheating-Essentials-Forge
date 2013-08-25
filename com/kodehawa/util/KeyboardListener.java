package com.kodehawa.util;

import com.kodehawa.module.ModuleBase;
import com.kodehawa.module.ModuleManager;
import com.kodehawa.module.loader.BaseLoader;
import org.lwjgl.input.Keyboard;

import com.kodehawa.CheatingEssentials;
import com.kodehawa.event.EventHandler;
import com.kodehawa.event.events.EventKey;

public class KeyboardListener {

	private volatile static KeyboardListener instance;
    private boolean[ ] keymap;

	
	public KeyboardListener(){
		
        keymap = new boolean[ 256 ];
        BaseLoader.keyInit();
        handleKeys();
	}
	

	/**
	 * Module keybinding.
	 * It handles the events and toggle the specified mod with the keybinding specified in the module class and CModLoader.
	 * Also it handles the GUI key, that shows a hacked-client-style GUI. Sorry for that.
	 * I'm making another GUI, promise :)
	 */
	
    public void handleKeys( ) {
    	//TODO: Module Keys
        for(ModuleBase m : ModuleManager.getInstance().modules) {
            int key = m.getKeybinding();
            if( getKeyStateFromMap( key ) ) {
               m.toggleModule();
                break;
            }
          }
        }
    
        /**
        * Get key things.
        * Like the old CheckKey :)
        */
       public boolean getKeyStateFromMap( int i ) {
        if( CheatingEssentials.getMinecraftInstance().currentScreen != null ) {
            return false;
        }
        if( Keyboard.isKeyDown( i ) != keymap[ i ] ) {
            return keymap[ i ] = !keymap[ i ];
        } else {
            return false;
        }
    }

	
	public static KeyboardListener getInstance(){
		if(instance == null){
			instance = new KeyboardListener();
		}
		return instance;
	}
	
}
