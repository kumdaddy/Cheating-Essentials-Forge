package com.reeszrbteam.ce.gui.click.windows;

import com.kodehawa.CheatingEssentials;
import com.reeszrbteam.ce.gui.click.YouAlwaysWinClickGui;
import com.reeszrbteam.ce.gui.click.elements.YAWWindow;
import com.reeszrbteam.ce.util.CEUtils;

public class WindowHub extends YAWWindow
{
	public WindowHub()
	{
		super("Gui Hub", 2, 14);
	}
	
	@Override
	public void draw(int x, int y)
	{
		super.draw(x, y);

		if(isExtended())
		{
			CEUtils.drawGradientBorderedRect(2 + dragX, getY() + 14 + dragY, getX() + 90 + dragX, (YouAlwaysWinClickGui.unFocusedWindows.size() * 13) + 15 + dragY, 0.5F, 0xFF000000, 0xFF999999, 0xFF777777);

			int size = 0;
			for(YAWWindow window: YouAlwaysWinClickGui.unFocusedWindows)
			{
				if(!window.getTitle().equalsIgnoreCase(this.getTitle()))
				{
					int yPosition = (12 * size) + 18 + dragY;
					CEUtils.drawGradientBorderedRect(4 + dragX, 12 + yPosition, getX() + 88 + dragX, yPosition + 24, 1.0F, 0xFF444444, !window.isOpen() ? 0xFF777777 : 0xFF555555, !window.isOpen() ? 0xFF555555 : 0xFF666666);

					drawCenteredTTFString(window.getTitle(), 38 + dragX, yPosition + 14, window.isOpen() ? 0x55FFFF : 0xBBBBBB);
					size++;
				}
			}
		}
	}
	
    public void drawCenteredTTFString(String par2Str, int par3, int par4, int par5)
    {
		CheatingEssentials.getMinecraftInstance().fontRenderer.drawStringWithShadow(par2Str, par3 - CheatingEssentials.getMinecraftInstance().fontRenderer.getStringWidth(par2Str) / 4, par4, par5);
    }
	
	@Override
	public void mouseClicked(int x, int y, int button)
	{
		super.mouseClicked(x, y, button);
		
		int size = 0;
		for(YAWWindow window: YouAlwaysWinClickGui.unFocusedWindows)
		{
			if(!window.getTitle().equalsIgnoreCase(this.getTitle()) && this.isExtended())
			{
				int i = (12 * size) + 18;
				if(x >= 4 + dragX && y >= i + 12 + dragY && x <= getX() + 88 + dragX && y <= i + 24 + dragY)
				{
					CheatingEssentials.getMinecraftInstance().sndManager.playSoundFX("random.click", 1.0F, 1.0F);
					window.setOpen(!window.isOpen());
				}
				size++;
			}
		}
	}
}

