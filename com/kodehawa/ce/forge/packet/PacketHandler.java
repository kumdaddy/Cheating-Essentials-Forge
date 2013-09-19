package com.kodehawa.ce.forge.packet;

import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;

import com.kodehawa.ce.forge.loader.CE_ForgeLoader;

import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;

public class PacketHandler implements IPacketHandler {

	private volatile static PacketHandler instance;
	
	@Override
	public void onPacketData(INetworkManager manager,
			Packet250CustomPayload packet, Player player) {
		packet.channel="Cheating Essentials Packets";
   	    PacketDispatcher.sendPacketToServer(packet);
   	    CE_ForgeLoader.instance().log("#Sended Packet:" +packet+ " correctly.");
	}
	
	public static PacketHandler instance(){
		if(instance == null){
			instance = new PacketHandler();
		}
		return instance;
	}
	
}
