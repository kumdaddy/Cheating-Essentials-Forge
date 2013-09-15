package com.kodehawa.ce.forge.tick;

import java.util.EnumSet;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityEnderChest;

import com.kodehawa.ce.core.RGuiChest;

import cpw.mods.fml.common.IScheduledTickHandler;
import cpw.mods.fml.common.TickType;

public class TickHandlerRGuiChest implements IScheduledTickHandler {

	public TickHandlerRGuiChest(){}
	
	
	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		if(Minecraft.getMinecraft().theWorld != null)
		for(Object o : Minecraft.getMinecraft().theWorld.loadedTileEntityList) {
			if(o instanceof TileEntityChest) {
				TileEntityChest chest = (TileEntityChest) o;
         if(Minecraft.getMinecraft().currentScreen instanceof GuiChest ){
        		IInventory ii = Block.chest.getInventory(Minecraft.getMinecraft().theWorld, chest.xCoord, chest.yCoord, chest.zCoord);
        	 Minecraft.getMinecraft().displayGuiScreen(new RGuiChest(Minecraft.getMinecraft().thePlayer.inventory, ii ));
			} 
         }
		}
		if(Minecraft.getMinecraft().theWorld != null)
		for(Object o : Minecraft.getMinecraft().theWorld.loadedTileEntityList) {
			if(o instanceof TileEntityEnderChest) {
				TileEntityEnderChest chest = (TileEntityEnderChest) o;
         if(Minecraft.getMinecraft().currentScreen instanceof GuiChest ){
        		IInventory ii = Block.chest.getInventory(Minecraft.getMinecraft().theWorld, chest.xCoord, chest.yCoord, chest.zCoord);
        	 Minecraft.getMinecraft().displayGuiScreen(new RGuiChest(Minecraft.getMinecraft().thePlayer.inventory, ii ));
			} 
         }
		}
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {}

	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.CLIENT, TickType.RENDER, TickType.WORLD);
	}

	@Override
	public String getLabel() {
		return null;
	}

	@Override
	public int nextTickSpacing() {
		return 0;
	}
}
