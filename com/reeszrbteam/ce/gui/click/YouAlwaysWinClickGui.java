package com.reeszrbteam.ce.gui.click;

import java.util.ArrayList;

import net.minecraft.client.gui.GuiScreen;

import com.reeszrbteam.ce.gui.click.elements.YAWWindow;
import com.reeszrbteam.ce.gui.click.windows.WindowHub;
import com.reeszrbteam.ce.gui.click.windows.WindowInfo;
import com.reeszrbteam.ce.gui.click.windows.WindowPlayer;
import com.reeszrbteam.ce.gui.click.windows.WindowRadar;
import com.reeszrbteam.ce.gui.click.windows.WindowRender;
import com.reeszrbteam.ce.gui.click.windows.WindowUtils;
import com.reeszrbteam.ce.gui.click.windows.WindowWorld;

public class YouAlwaysWinClickGui extends GuiScreen
{
	public static ArrayList<YAWWindow> windows = new ArrayList<YAWWindow>();
	public static ArrayList<YAWWindow> unFocusedWindows = new ArrayList<YAWWindow>();
	public static boolean isDark = false;
	
	public YAWWindow guiHub = new WindowHub();
	public YAWWindow player = new WindowPlayer().init();
	public YAWWindow world = new WindowWorld().init();
	public YAWWindow info = new WindowInfo();
	public YAWWindow radar = new WindowRadar();
    public YAWWindow render = new WindowRender().init();
    public YAWWindow utils = new WindowUtils().init();
	
	public void initGui()
	{
		guiHub.setOpen(true);
	}
	
	public void onGuiClosed(){}

	public static void sendPanelToFront(YAWWindow window)
	{
		if(windows.contains(window))
		{
			int panelIndex = windows.indexOf(window);
			windows.remove(panelIndex);
			windows.add(windows.size(), window);
		}
	}
	
	public static YAWWindow getFocusedPanel()
	{
		return windows.get(windows.size() - 1);
	}
	
	public void drawScreen(int x, int y, float f)
	{
		for(YAWWindow window: windows)
		{
			window.draw(x, y);
		}
	}
	
	public void mouseClicked(int x, int y, int button)
	{
		try
		{
			for(YAWWindow window: windows)
			{
				window.mouseClicked(x, y, button);
			}
		}catch(Exception e) {}
	}
	
	public void mouseMovedOrUp(int x, int y, int button)
	{
		for(YAWWindow window: windows)
		{
			window.mouseMovedOrUp(x, y, button);
		}
	}
	
	public boolean doesGuiPauseGame()
	{
		return false;
	}
}
