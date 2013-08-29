package com.kodehawa.ce.forge.common.events;

import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.EventPriority;
import net.minecraftforge.event.ForgeSubscribe;

import com.kodehawa.ce.CheatingEssentials;
import com.kodehawa.ce.event.events.EventRender3D;
import com.kodehawa.ce.forge.tick.TickHandler;

public class EventRegisterer {

	@ForgeSubscribe(priority=EventPriority.HIGH)
	public void onRenderWorldLastEvent(RenderWorldLastEvent e){
		com.kodehawa.ce.event.EventHandler.getInstance().call(new EventRender3D(this));
	}
	
    @ForgeSubscribe(priority=EventPriority.NORMAL)
	public void renderGameOverlay(RenderGameOverlayEvent event){
		TickHandler.instance().startGuiRendering();
	}
	
	
}
