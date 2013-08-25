package com.kodehawa.module.classes;

import java.util.ArrayList;

import net.minecraft.client.Minecraft;

import org.lwjgl.input.Keyboard;

import com.kodehawa.CheatingEssentials;
import com.kodehawa.event.Event;
import com.kodehawa.event.EventHandler;
import com.kodehawa.event.events.EventBlockRender;
import com.kodehawa.module.ModuleBase;
import com.kodehawa.module.enums.EnumGuiCategory;

public class Xray extends ModuleBase {
	
	public static ArrayList< Integer > xrayBlocks = new ArrayList< Integer >( );

	public Xray( ) {
		super("X-Ray", "See all valuable stuff", "1.6.2", Keyboard.KEY_X, EnumGuiCategory.WORLD, true);

        xrayBlocks.add( 8 );
        xrayBlocks.add( 9 );
        xrayBlocks.add( 10 );
        xrayBlocks.add( 11 );
        xrayBlocks.add( 14 );
        xrayBlocks.add( 15 );
        xrayBlocks.add( 16 );
        xrayBlocks.add( 89 );
        xrayBlocks.add( 57 );
        xrayBlocks.add( 73 );
        xrayBlocks.add( 74 );
        xrayBlocks.add( 152 );
        xrayBlocks.add( 153 );
        xrayBlocks.add( 56 );
        xrayBlocks.add( 41 );
        xrayBlocks.add( 42 );
        xrayBlocks.add( 133 );
        xrayBlocks.add( 129 );
        xrayBlocks.add( 137 );
        xrayBlocks.add( 120 );
        xrayBlocks.add( 97 );
        xrayBlocks.add( 88 );
        xrayBlocks.add( 89 );
        xrayBlocks.add( 112 );
        super.setTick(true);
	}
	
	public void onEnableModule(){
		EventHandler.getInstance().registerListener( EventBlockRender.class, this );
        CheatingEssentials.getCheatingEssentials().getMinecraftInstance().renderGlobal.loadRenderers();
	}
 
	public void onDisableModule(){
		EventHandler.getInstance().unRegisterListener( EventBlockRender.class, this );
        CheatingEssentials.getCheatingEssentials().getMinecraftInstance().renderGlobal.loadRenderers();
        CheatingEssentials.getMinecraftInstance().theWorld.provider.registerWorld(Minecraft.getMinecraft().theWorld);
	}
	
	@Override
	public void onEvent(Event e) {
		super.onEvent(e);
		
		if( e instanceof EventBlockRender ) {
            EventBlockRender rEvent = ( EventBlockRender ) e;
            if( rEvent.getType( ).equals( EventBlockRender.EventType.RENDER_XRAY ) ) {
                rEvent.setCancelled( isActive( ) ? true : false );
            }
        }
	}

    @Override
    public void tick() {
        //To change body of implemented methods use File | Settings | File Templates.
        float[] brightness = CheatingEssentials.getMinecraftInstance().theWorld.provider.lightBrightnessTable;
        for(int i = 0; i < brightness.length; i++) {
            brightness[i] = 1.0F;
        }
    }
}
