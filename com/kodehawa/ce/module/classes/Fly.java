package com.kodehawa.ce.module.classes;

import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.network.packet.Packet13PlayerLookMove;

import org.lwjgl.input.Keyboard;

import com.kodehawa.ce.CheatingEssentials;
import com.kodehawa.ce.module.annotations.ModuleLoader;
import com.kodehawa.ce.module.core.CheatingEssentialsModule;
import com.kodehawa.ce.module.enums.EnumGuiCategory;

public class Fly extends CheatingEssentialsModule {

	@ModuleLoader(type = "Module")
	public Fly( ) {
		super("Fly", "Fly like a bird!", "1.6.2", Keyboard.KEY_R,
				EnumGuiCategory.PLAYER, true);
        super.setTick(true);
	}


	@Override
    public void onEnableModule(){
		CheatingEssentials.getMinecraftInstance().thePlayer.capabilities.isFlying = true;
	}
	
	@Override
	public void onDisableModule(){
		CheatingEssentials.getMinecraftInstance().thePlayer.capabilities.isFlying = false;
	}
	
	@Override
	public void tick() {
		if(!CheatingEssentials.getMinecraftInstance().thePlayer.capabilities.isFlying){
			CheatingEssentials.getMinecraftInstance().thePlayer.capabilities.isFlying = true;
		}
		
	    EntityClientPlayerMP ep = CheatingEssentials.getCheatingEssentials().getMinecraftInstance().thePlayer;
        ep.sendQueue.addToSendQueue(new Packet13PlayerLookMove(ep.motionX, -999.0D, -999.0D, ep.motionZ,
                ep.rotationYaw, ep.rotationPitch, !ep.onGround));
	}
}
