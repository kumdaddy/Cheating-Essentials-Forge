package com.kodehawa.ce.forge.packet;

import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.ForgeSubscribe;

import com.kodehawa.CheatingEssentials;
import com.kodehawa.module.ModuleBase;
import com.kodehawa.module.ModuleManager;

import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class PacketHandler implements IPacketHandler {

	@Override
	public void onPacketData(INetworkManager manager,
			Packet250CustomPayload packet, Player player) {
		
		CheatingEssentials.CELogAgent("#Sended Packet:" +packet+ " correctly.");
	}

	 @ForgeSubscribe
	 public void onRenderWorld(RenderWorldLastEvent e){
		 for(ModuleBase m : ModuleManager.getInstance().modules){
			 m.onRenderInModule();
		 }
	 }
	
}
