package com.reeszrbteam.ce.gui.click.elements;

import java.util.ArrayList;

import com.kodehawa.CheatingEssentials;
import com.kodehawa.module.ModuleBase;
import com.reeszrbteam.ce.gui.click.YouAlwaysWinClickGui;
import com.reeszrbteam.ce.util.CEUtils;
import com.reeszrbteam.ce.util.Value;

public class YAWWindow
{
	private String title;
	private int xPos;
	private int yPos;
	
	private boolean isOpen;
	private boolean isExtended;
	private boolean isPinned;
	
	public static int dragX;
	public static int dragY;
	public int lastDragX;
	public int lastDragY;
	protected boolean dragging;
	
	public ArrayList<YAWButton> buttons = new ArrayList<YAWButton>();
	public ArrayList<YAWSlider> sliders = new ArrayList<YAWSlider>();
	
	public YAWWindow(String title, int x, int y)
	{
		this.title = title;
		this.xPos = x;
		this.yPos = y;
		YouAlwaysWinClickGui.windows.add(this);
		YouAlwaysWinClickGui.unFocusedWindows.add(this);
	}
	
	public void windowDragged(int x, int y) {
		dragX = x - lastDragX;
		dragY = y - lastDragY;
	}
	
	private int buttonCount = 0, sliderCount = 0;
	
	public void addButton(ModuleBase mod) {
		buttons.add(new YAWButton(this, mod, xPos + 2, yPos + (11 * buttons.size()) + 16));
	}
	
	public YAWSlider addSlider(Value value)
	{
		return addSlider(value, 10.0F);
	}
	
	public YAWSlider addSlider(Value value, float maxValue)
	{
		return addSlider(value, 0.0F, maxValue, false);
	}
	
	public YAWSlider addSlider(Value value, float minValue, float maxValue, boolean shouldRound)
	{
		YAWSlider slider = new YAWSlider(this, value, xPos + 2, yPos + (18 * sliderCount) + 16, minValue, maxValue, shouldRound);
		sliders.add(slider);
		sliderCount++;
		
		return slider;
	}
	
	public void draw(int x, int y)
	{
		if(isOpen)
		{
			if(dragging)
			{
				windowDragged(x, y);
			}
			
			CEUtils.drawGradientBorderedRect(xPos + dragX, yPos + dragY, xPos + 90 + dragX, yPos + 12 + dragY, 0.5F, 0xFF000000, 0xCF999999, 0xCF777777);
			CheatingEssentials.getMinecraftInstance().fontRenderer.drawString(title, xPos + 2 + dragX, 2 + yPos + dragY, 0x55FFFF);
			
			CEUtils.drawGradientBorderedRect(xPos + 70 + dragX, yPos + 2 + dragY, xPos + 78 + dragX, yPos + 10 + dragY, 1F, 0xFF666666, isPinned ? 0xFF777777 : 0xFF888888, isPinned ? 0xFF555555 : 0xFF666666);
			CEUtils.drawGradientBorderedRect(xPos + 80 + dragX, yPos + 2 + dragY, xPos + 88 + dragX, yPos + 10 + dragY, 1F, 0xFF666666, isExtended ? 0xFF777777 : 0xFF888888, isExtended ? 0xFF555555 : 0xFF666666);
			
			if(isExtended)
			{
				CEUtils.drawGradientBorderedRect(xPos + dragX, yPos + 14 + dragY, xPos + 90 + dragX, yPos + (11 * buttons.size() + 19) + (18 * sliders.size()) + dragY, 0.5F, 0xFF000000, 0xCF999999, 0xCF777777);
				
				for(YAWButton button: buttons)
				{
					button.draw();
					if(x >= button.getX() + dragX && y >= button.getY() + 1 + dragY && x <= button.getX() + 23 + dragX && y <= button.getY() + 10 + dragY)
					{
						button.isOverButton = true;
					}else
					{
						button.isOverButton = false;
					}
				}
				
				for(YAWSlider slider: sliders)
				{
					slider.draw(x);
				}
			}
		}
	}
	
	public void mouseClicked(int x, int y, int button)
	{
		for(YAWButton xButton: buttons)
		{
			xButton.mouseClicked(x, y, button);
		}
		
		for(YAWSlider slider: sliders)
		{
			slider.mouseClicked(x, y, button);
		}
		
		if(x >= xPos + 80 + dragX && y >= yPos + 2 + dragY && x <= xPos + 88 + dragX && y <= yPos + 10 + dragY)
		{
			CheatingEssentials.getMinecraftInstance().sndManager.playSoundFX("random.click", 1.0F, 1.0F);
			isExtended = !isExtended;
		}
		if(x >= xPos + 70 + dragX && y >= yPos + 2 + dragY && x <= xPos + 78 + dragX && y <= yPos + 10 + dragY)
		{
			CheatingEssentials.getMinecraftInstance().sndManager.playSoundFX("random.click", 1.0F, 1.0F);
			isPinned = !isPinned;
		}
		if(x >= xPos + dragX && y >= yPos + dragY && x <= xPos + 69 + dragX && y <= yPos + 12 + dragY)
		{
			YouAlwaysWinClickGui.sendPanelToFront(this);
			dragging = true;
			lastDragX = x - dragX;
			lastDragY = y - dragY;
		}
	}
	
	public void mouseMovedOrUp(int x, int y, int b)
	{
		for(YAWSlider slider: sliders)
		{
			slider.mouseMovedOrUp(x, y, b);
		}
		if(b == 0) {
			dragging = false;
		}
	}
	
	public final String getTitle()
	{
		return this.title;
	}
	
	public final int getX()
	{
		return this.xPos;
	}
	
	public final int getY()
	{
		return this.yPos;
	}
	
	public boolean isExtended()
	{
		return isExtended;
	}
	
	public boolean isOpen()
	{
		return isOpen;
	}
	
	public boolean isPinned()
	{
		return isPinned;
	}
	
	public void setOpen(boolean flag)
	{
		this.isOpen = flag;
	}
	
	public void setExtended(boolean flag)
	{
		this.isExtended = flag;
	}
	
	public void setPinned(boolean flag)
	{
		this.isPinned = flag;
	}
}
