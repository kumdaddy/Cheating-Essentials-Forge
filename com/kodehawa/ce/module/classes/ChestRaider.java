package com.kodehawa.ce.module.classes;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityEnderChest;

import com.kodehawa.ce.module.annotations.ModuleExperimental;
import com.kodehawa.ce.module.annotations.ModuleTechnical;
import com.kodehawa.ce.module.core.CheatingEssentialsModule;
import com.kodehawa.ce.module.enums.EnumGuiCategory;
import com.kodehawa.ce.vanilla.RGuiChest;

@ModuleExperimental
public class ChestRaider extends CheatingEssentialsModule{

	public ChestRaider() {
		super("Chest Raider", "", EnumGuiCategory.WORLD, true);
		super.setTick(true);
	}
	
	public void tick(){
		if(Minecraft.getMinecraft().currentScreen != null)
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
			if(Minecraft.getMinecraft().currentScreen != null)
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
}
