package com.kodehawa.module.classes;

import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.entity.EntityPlayerSP;

import com.kodehawa.CheatingEssentials;
import com.kodehawa.module.annotations.ModuleExperimental;
import com.kodehawa.module.core.CheatingEssentialsModule;
import com.kodehawa.module.enums.EnumGuiCategory;
import com.kodehawa.module.handlers.ModuleManager;
import com.reeszrbteam.ce.util.EntitySpectator;

public class Spectator extends CheatingEssentialsModule {

	private EntityOtherPlayerMP entity = /* new EntityOtherPlayerMP(CheatingEssentials.getMinecraftInstance().theWorld, "") */ null;
	public EntitySpectator freecamEnt = /* new EntitySpectator(CheatingEssentials.getMinecraftInstance().theWorld, "")*/ null;
	private double freecamX, freecamY, freecamZ, freecamPitch, freecamYaw;

    @ModuleExperimental( setAs = "Crasheable / WIP / Unstable" )
	public Spectator() {
		super("Spectate", "Spectate and Spy on People", "1.6.2", 0, EnumGuiCategory.RENDER, true);
        super.setTick(true);
	}

	@Override
	public void onEnableModule() {
		
	}

	@Override
	public void onDisableModule() {
		
	}

	@Override
	public void tick() {
		if(getEnabled() && freecamEnt != null)
		{
			freecamEnt.rotationPitch = CheatingEssentials.getMinecraftInstance().thePlayer.rotationPitch;
			freecamEnt.rotationYaw = CheatingEssentials.getMinecraftInstance().thePlayer.rotationYaw;
			freecamEnt.rotationYawHead = CheatingEssentials.getMinecraftInstance().thePlayer.rotationYawHead;
		}
		try {
			if(getEnabled() && freecamEnt != null)
			{
				EntityPlayerSP player = CheatingEssentials.getMinecraftInstance().thePlayer;
				freecamEnt.inventory = player.inventory;
				freecamEnt.yOffset = player.yOffset;
				freecamEnt.ySize = player.ySize;
				freecamEnt.flyMode = ModuleManager.getInstance().getModuleByClass(Fly.class).getEnabled();
				freecamEnt.setMovementInput(player.movementInput);
				freecamEnt.rotationPitch = player.rotationPitch;
				freecamEnt.rotationYaw = player.rotationYaw;
				freecamEnt.rotationYawHead = player.rotationYawHead;
				freecamEnt.setSprinting(player.isSprinting());
				
				if(CheatingEssentials.getMinecraftInstance().renderViewEntity != freecamEnt)
				{
					CheatingEssentials.getMinecraftInstance().renderViewEntity = freecamEnt;
				}
			}else if(isActive())
			{
				this.toggleModule();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
