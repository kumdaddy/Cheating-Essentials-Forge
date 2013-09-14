package com.reeszrbteam.ce.gui.click.windows;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

import com.reeszrbteam.ce.gui.click.elements.YAWButton;
import com.reeszrbteam.ce.gui.click.elements.YAWWindow;
import com.reeszrbteam.ce.util.CEUtils;

public class WindowRadar extends YAWWindow {
	public WindowRadar() {
		super("Radar", 2, 114);
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
			Minecraft.getMinecraft().fontRenderer.drawString(getTitle(), getX() + 2 + dragX, getY() + dragY + 2, 0x55FFFF);
			
			CEUtils.drawGradientBorderedRect(getX() + 70 + dragX, getY() + 2 + dragY, getX() + 78 + dragX, getY() + 10 + dragY, 1F, 0xFF666666, isPinned() ? 0xFF777777 : 0xFF888888, isPinned() ? 0xFF555555 : 0xFF666666);
			CEUtils.drawGradientBorderedRect(getX() + 80 + dragX, getY() + 2 + dragY, getX() + 88 + dragX, getY() + 10 + dragY, 1F, 0xFF666666, isExtended() ? 0xFF777777 : 0xFF888888, isExtended() ? 0xFF555555 : 0xFF666666);
			
			if(isExtended())
			{
				int rect = 0;
				for(Object o: Minecraft.getMinecraft().theWorld.playerEntities) {
					EntityPlayer e = (EntityPlayer) o;
					if(e != Minecraft.getMinecraft().thePlayer && !e.isDead) {
						rect += 10;
					}
				}
				
				CEUtils.drawGradientBorderedRect(getX() + dragX, getY() + 14 + dragY, getX() + 90 + dragX, getY() + rect + 14 + dragY, 0.5F, 0xFF000000, 0xFF999999, 0xFF777777);
				
				int count = 0;
				for(Object o: Minecraft.getMinecraft().theWorld.playerEntities)
				{
					EntityPlayer e = (EntityPlayer) o;
					if(e != Minecraft.getMinecraft().thePlayer && !e.isDead)
					{
						int distance = (int)Minecraft.getMinecraft().thePlayer.getDistanceToEntity(e);
						String text = "";
						if(distance <= 20)
						{
							text = "\247c" + e.username + "\247f: " + (int)distance;
						}else
						if(distance <= 50 && distance > 20)
						{
							text = "\2476" + e.username + "\247f: " + (int)distance;
						}else
						if(distance > 50)
						{
							text = "\247a" + e.username + "\247f: " + (int)distance;
						}
						int xPosition = getX() + 2 + dragX;
						int yPosition = getY() + (10 * count) + 13 + dragY;
						Minecraft.getMinecraft().fontRenderer.drawString(text, xPosition, yPosition, 0x55FFFF);
						count++;
					}
				}
				
				if(rect == 0 && count == 0)
				{
					CEUtils.drawGradientBorderedRect(getX() + dragX, getY() + 14 + dragY, getX() + 90 + dragX, getY() + 24.5 + dragY, 0.5F, 0xFF000000, 0xFF999999, 0xFF777777);
					Minecraft.getMinecraft().fontRenderer.drawString("No one in range.", getX() + 2 + dragX, getY() + 15 + dragY, 0x55FFFF);
				}
				
				for(YAWButton button: buttons)
				{
					button.draw();
				}
				
				/*for(YAWSlider slider: sliders)
				{
					slider.draw(x);
				}*/
			}
		}
	}
}

