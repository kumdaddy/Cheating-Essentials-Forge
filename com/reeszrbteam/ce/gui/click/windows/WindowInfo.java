package com.reeszrbteam.ce.gui.click.windows;

import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.kodehawa.CheatingEssentials;
import com.reeszrbteam.ce.gui.click.elements.YAWButton;
import com.reeszrbteam.ce.gui.click.elements.YAWWindow;
import com.reeszrbteam.ce.util.CEUtils;


public class WindowInfo extends YAWWindow{
    
	public WindowInfo() 
	{
		super("Info", 278, 85 + 13);
	}
	
	@Override
	public void draw(int x, int y)
	{
		if(isOpen())
		{
			if(dragging)
			{
				windowDragged(x, y);
			}
			
			CEUtils.drawGradientBorderedRect(getX() + dragX, getY() + dragY, getX() + 90 + dragX, getY() + 12 + dragY, 0.5F, 0xFF000000, 0xFF999999, 0xFF777777);
			CheatingEssentials.getMinecraftInstance().fontRenderer.drawString(getTitle(), getX() + 2 + dragX, getY() + dragY + 2, 0x55FFFF);
			
			CEUtils.drawGradientBorderedRect(getX() + 70 + dragX, getY() + 2 + dragY, getX() + 78 + dragX, getY() + 10 + dragY, 1F, 0xFF666666, isPinned() ? 0xFF777777 : 0xFF888888, isPinned() ? 0xFF555555 : 0xFF666666);
			CEUtils.drawGradientBorderedRect(getX() + 80 + dragX, getY() + 2 + dragY, getX() + 88 + dragX, getY() + 10 + dragY, 1F, 0xFF666666, isExtended() ? 0xFF777777 : 0xFF888888, isExtended() ? 0xFF555555 : 0xFF666666);
			
			if(isExtended())
			{
				CEUtils.drawGradientBorderedRect(getX() + dragX, getY() + 14 + dragY, getX() + 90 + dragX, getY() + 64 + dragY, 0.5F, 0xFF000000, 0xFF999999, 0xFF777777);
				
				CheatingEssentials.getMinecraftInstance().fontRenderer.drawString(CheatingEssentials.getMinecraftInstance().debug.split(",")[0].toUpperCase(), getX() + 2 + dragX, getY() + 15 + dragY, 0x55FFFF);
				CheatingEssentials.getMinecraftInstance().fontRenderer.drawString("X: " + (int)CheatingEssentials.getMinecraftInstance().thePlayer.posX, getX() + 2 + dragX, getY() + 25 + dragY, 0x55FFFF);
				CheatingEssentials.getMinecraftInstance().fontRenderer.drawString("Y: " + (int)CheatingEssentials.getMinecraftInstance().thePlayer.posY, getX() + 2 + dragX, getY() + 35 + dragY, 0x55FFFF);
				CheatingEssentials.getMinecraftInstance().fontRenderer.drawString("Z: " + (int)CheatingEssentials.getMinecraftInstance().thePlayer.posZ, getX() + 2 + dragX, getY() + 45 + dragY, 0x55FFFF);
				CheatingEssentials.getMinecraftInstance().fontRenderer.drawString(CheatingEssentials.getMinecraftInstance().thePlayer.username, getX() + 2 + dragX, getY() + 55 + dragY, 0x55FFFF);
				
				for(YAWButton button: buttons)
				{
					button.draw();
				}
			}
		}
	}
    public static void Render3DPlayer(int par0, int par1, int par2, float par3, float par4, EntityLivingBase par5EntityLivingBase)
    {
        GL11.glEnable(GL11.GL_COLOR_MATERIAL);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)par0 + dragX, (float)par1 + dragY, 50.0F);
        GL11.glScalef((float)(-par2), (float)par2, (float)par2);
        GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
        float var6 = par5EntityLivingBase.renderYawOffset;
        float var7 = par5EntityLivingBase.rotationYaw;
        float var8 = par5EntityLivingBase.rotationPitch;
        float var9 = par5EntityLivingBase.prevRotationYawHead;
        float var10 = par5EntityLivingBase.rotationYawHead;
        GL11.glRotatef(135.0F, 0.0F, 1.0F, 0.0F);
        RenderHelper.enableStandardItemLighting();
        GL11.glRotatef(-135.0F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-((float)Math.atan((double)(par4 / 40.0F))) * 20.0F, 1.0F, 0.0F, 0.0F);
        par5EntityLivingBase.renderYawOffset = (float)Math.atan((double)(par3 / 40.0F)) * 20.0F;
        par5EntityLivingBase.rotationYaw = (float)Math.atan((double)(par3 / 40.0F)) * 40.0F;
        par5EntityLivingBase.rotationPitch = -((float)Math.atan((double)(par4 / 40.0F))) * 20.0F;
        par5EntityLivingBase.rotationYawHead = par5EntityLivingBase.rotationYaw;
        par5EntityLivingBase.prevRotationYawHead = par5EntityLivingBase.rotationYaw;
        GL11.glTranslatef(0.0F, par5EntityLivingBase.yOffset, 0.0F);
        RenderManager.instance.playerViewY = 180.0F;
        RenderManager.instance.renderEntityWithPosYaw(par5EntityLivingBase, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
        par5EntityLivingBase.renderYawOffset = var6;
        par5EntityLivingBase.rotationYaw = var7;
        par5EntityLivingBase.rotationPitch = var8;
        par5EntityLivingBase.prevRotationYawHead = var9;
        par5EntityLivingBase.rotationYawHead = var10;
        GL11.glPopMatrix();
        RenderHelper.disableStandardItemLighting();
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);
    }
}