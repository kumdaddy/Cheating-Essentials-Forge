package com.kodehawa.module.classes;

import org.lwjgl.input.Keyboard;

import com.kodehawa.module.ModuleBase;

public class UtilReloadChunks extends ModuleBase {

	public UtilReloadChunks( ) {
		super("Reload Chunks", "", Keyboard.KEY_NUMPAD9);
	}

	@Override
	public void onEnableModule() {
		getMinecraft().renderGlobal.loadRenderers();
	}

	@Override
	public void onDisableModule() {
		// TODO Auto-generated method stub
		
	}

}
