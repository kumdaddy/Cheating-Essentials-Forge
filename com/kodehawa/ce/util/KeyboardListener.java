package com.kodehawa.ce.util;

import org.lwjgl.input.Keyboard;

import com.kodehawa.ce.module.core.CheatingEssentialsModule;
import com.kodehawa.ce.module.handlers.ModuleManager;

import cpw.mods.fml.client.FMLClientHandler;

public class KeyboardListener {

	private volatile static KeyboardListener instance;
    private boolean[ ] keymap;
	
	public KeyboardListener(){
        keymap = new boolean[ 256 ];
        keyInit();
        handleKeys();
	}
	
    public void keyInit(){
        for(CheatingEssentialsModule m : ModuleManager.getInstance().modules){
            m.getKeybinding();
        }
    }
	
    public void handleKeys( ) {
    	//TODO: Module Keys
        for(CheatingEssentialsModule m : ModuleManager.getInstance().modules) {
            int key = m.getKeybinding();
            if( getKeyStateFromMap( key ) ) {
               m.toggleModule();
                break;
            }
          }
        }
    
       public boolean getKeyStateFromMap( int i ) {
        if( FMLClientHandler.instance().getClient().currentScreen != null ) {
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
