package com.kodehawa.ce.forge.tick;

import java.util.EnumSet;

import org.lwjgl.input.Keyboard;

import com.kodehawa.CheatingEssentials;
import com.kodehawa.gui.api.components.Frame;
import com.kodehawa.gui.api.components.ModuleGui;
import com.kodehawa.util.KeyboardListener;
import com.reeszrbteam.ce.console.GuiConsole;
import com.reeszrbteam.ce.gui.click.YouAlwaysWinClickGui;
import com.reeszrbteam.ce.gui.click.elements.YAWWindow;

import cpw.mods.fml.common.IScheduledTickHandler;
import cpw.mods.fml.common.TickType;

public class TickHandler implements IScheduledTickHandler {

	private CheatingEssentials cheatingEssentials;
    private ModuleGui Gui;
    YouAlwaysWinClickGui yaw;
    private GuiConsole Console;
	public static int tick = 0;
	public static int guimode = 0;
	
	public TickHandler( ){
		 cheatingEssentials = new CheatingEssentials( );
	     Gui = new ModuleGui();
	     yaw = new YouAlwaysWinClickGui();
	     Console = new GuiConsole();
	}
	
	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		CheatingEssentials.getCheatingEssentials().tick();
		if( KeyboardListener.getInstance().getKeyStateFromMap(Keyboard.KEY_GRAVE)){
			CheatingEssentials.getMinecraftInstance().displayGuiScreen(Console);

        switch (guimode){
            case 0: for(Frame e : Gui.frames){
                if(e.pinned){ e.update(); e.draw(); }} break;
            case 1: for(YAWWindow window: YouAlwaysWinClickGui.windows){
                if(!(CheatingEssentials.getMinecraftInstance().currentScreen instanceof YouAlwaysWinClickGui)) {
                    if(window.isPinned()){ window.draw(0, 0); }} break;
            }
        }
		}
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		
	}

	@Override
	public EnumSet<TickType> ticks() {
		// TODO Auto-generated method stub
		return EnumSet.of(TickType.CLIENT);
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int nextTickSpacing() {
		// TODO Auto-generated method stub
		return 0;
	}

}
