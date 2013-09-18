package com.kodehawa.ce.vanilla;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiSmallButton;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RGuiChest extends GuiChest
{
   // private IInventory lowerChestInventory;
    
    public RGuiChest(IInventory par1iInventory, IInventory par2iInventory) {
		super(par1iInventory, par2iInventory);
	//	lowerChestInventory = par2iInventory;
	}
    
    @Override
    public void initGui(){
    	super.initGui();
        int POS_Y = (height - ySize) / 2 + 28;
        String BUTTON_STEAL = "Raid";
        String BUTTON_SAVE = "Store";
        this.buttonList.add(new GuiSmallButton(1, width / 2 - 140, POS_Y, 50, 20, BUTTON_STEAL));
        this.buttonList.add(new GuiSmallButton(4, width / 2 + 90, POS_Y, 50, 20, BUTTON_SAVE));
    }
    
    public void actionPerformed(GuiButton button){
    	if(button.id == 1){
    		/*try{
    		for(int x = 0; x < lowerChestInventory.getSizeInventory(); x++){
    			mc.playerController.windowClick(inventorySlots.windowId, x, 0, 1, mc.thePlayer);
    		   }
    		}
    		catch(Exception e){}*/
    		if(button.id == 4){
    			try{
    				//You doesn't work. I hate u.
    	    		for(int x = 0; x < inventorySlots.inventorySlots.size(); x++){
    	    			mc.playerController.windowClick(inventorySlots.windowId, x, 0, 1, mc.thePlayer);
    	    		}
    			}
    			catch(Exception e){
    				e.printStackTrace();
    			}
    		}
    	}
    }
}
