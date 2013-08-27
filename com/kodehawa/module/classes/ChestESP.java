package com.kodehawa.module.classes;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityEnderChest;

import org.lwjgl.input.Keyboard;

import com.kodehawa.CheatingEssentials;
import com.kodehawa.module.annotations.ModuleLoader;
import com.kodehawa.module.core.CheatingEssentialsModule;
import com.kodehawa.module.enums.EnumGuiCategory;
import com.reeszrbteam.ce.util.CEUtils;

public class ChestESP extends CheatingEssentialsModule {

	@ModuleLoader(type = "Module")
	public ChestESP( ) {
		super("Chest Finder", "Find ALL chests!", "1.6.2", Keyboard.KEY_N,
				EnumGuiCategory.RENDER, true);
		super.setRender(true);
	}
	
	@Override
	public void onRenderInModule( ){
		if(isActive()){
			for(Object o : CheatingEssentials.getMinecraftInstance().theWorld.loadedTileEntityList) {
				if(o instanceof TileEntityChest) {
					TileEntityChest chest = (TileEntityChest)o;
					this.drawESP(chest, chest.xCoord, chest.yCoord, chest.zCoord, chest.prevLidAngle);
				}
				if(o instanceof TileEntityEnderChest) {
					TileEntityEnderChest chest = (TileEntityEnderChest)o;
					this.drawESP2(chest, chest.xCoord, chest.yCoord, chest.zCoord, chest.prevLidAngle);
				}
			}
		}
	}
	
	public void drawESP(TileEntityChest chest, double x, double y, double z, float f) {
		if(isActive()){
			if(!(chest.xCoord == 0 && chest.yCoord == 0 && chest.zCoord == 0)) {
				CheatingEssentials.getMinecraftInstance().entityRenderer.disableLightmap(f);
				CEUtils.drawESP(x - RenderManager.renderPosX, y - RenderManager.renderPosY, z - RenderManager.renderPosZ, 0.0F, 1.0F - chest.getDistanceFrom(CheatingEssentials.getMinecraftInstance().thePlayer.posX, CheatingEssentials.getMinecraftInstance().thePlayer.posY, CheatingEssentials.getMinecraftInstance().thePlayer.posZ) / 20000, 1.0F);
				CheatingEssentials.getMinecraftInstance().entityRenderer.enableLightmap(f);
			}
		}
	}
	public void drawESP2(TileEntityEnderChest chest, double x, double y, double z, float f) {
		if(isActive()){
			if(!(chest.xCoord == 0 && chest.yCoord == 0 && chest.zCoord == 0)) {
				CheatingEssentials.getMinecraftInstance().entityRenderer.disableLightmap(f);
				CEUtils.drawESP(x - RenderManager.renderPosX, y - RenderManager.renderPosY, z - RenderManager.renderPosZ, 0.0F, 1.0F - chest.getDistanceFrom(CheatingEssentials.getMinecraftInstance().thePlayer.posX, CheatingEssentials.getMinecraftInstance().thePlayer.posY, CheatingEssentials.getMinecraftInstance().thePlayer.posZ) / 20000, 1.0F);
				CheatingEssentials.getMinecraftInstance().entityRenderer.enableLightmap(f);
			}
		}
	}

	@Override
	public void onEnableModule() {
		
	}

	@Override
	public void onDisableModule() {
		
	}

}
