package com.kodehawa.ce.vanilla;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiSmallButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RGuiChest extends GuiContainer
{
    private static final ResourceLocation field_110421_t = new ResourceLocation("textures/gui/container/generic_54.png");
    private IInventory upperChestInventory;
    private IInventory lowerChestInventory;

    private int inventoryRows;

    public RGuiChest(IInventory par1IInventory, IInventory par2IInventory)
    {
        super(new ContainerChest(par1IInventory, par2IInventory));
        this.upperChestInventory = par1IInventory;
        this.lowerChestInventory = par2IInventory;
        this.allowUserInput = false;
        short short1 = 222;
        int i = short1 - 108;
        this.inventoryRows = par2IInventory.getSizeInventory() / 9;
        this.ySize = i + this.inventoryRows * 18;
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
    		try{
    		for(int x = 0; x < lowerChestInventory.getSizeInventory(); x++){
    			mc.playerController.windowClick(inventorySlots.windowId, x, 0, 1, mc.thePlayer);
    		   }
    		}
    		catch(Exception e){}
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

    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
        this.fontRenderer.drawString(this.lowerChestInventory.isInvNameLocalized() ? this.lowerChestInventory.getInvName() : I18n.getString(this.lowerChestInventory.getInvName()), 8, 6, 4210752);
        this.fontRenderer.drawString(this.upperChestInventory.isInvNameLocalized() ? this.upperChestInventory.getInvName() : I18n.getString(this.upperChestInventory.getInvName()), 8, this.ySize - 96 + 2, 4210752);
    }

    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(field_110421_t);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.inventoryRows * 18 + 17);
        this.drawTexturedModalRect(k, l + this.inventoryRows * 18 + 17, 0, 126, this.xSize, 96);
    }
}
