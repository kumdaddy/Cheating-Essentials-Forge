package com.kodehawa.ce.forge.common.events;

import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.EventPriority;
import net.minecraftforge.event.ForgeSubscribe;

import com.kodehawa.ce.event.EventHandler;
import com.kodehawa.ce.event.events.EventRender3D;

public class EventRegisterer {

	@ForgeSubscribe(priority=EventPriority.HIGH)
	public void onRenderWorldLastEvent(RenderWorldLastEvent e){
		EventHandler.getInstance().call(new EventRender3D(this));
	}
}
