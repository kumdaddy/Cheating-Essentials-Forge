package com.reeszrbteam.ce.gui.click.windows;

import com.kodehawa.ce.module.core.CheatingEssentialsModule;
import com.kodehawa.ce.module.enums.EnumGuiCategory;
import com.kodehawa.ce.module.handlers.ModuleManager;
import com.reeszrbteam.ce.gui.click.elements.YAWWindow;

public class WindowPlayer extends YAWWindow
{
	public WindowPlayer()
	{
		super("Player", 94, 14);
	}
	
	public YAWWindow init()
	{
		for(CheatingEssentialsModule mod: ModuleManager.getInstance().modules)
		{
			if(mod.getType() == EnumGuiCategory.PLAYER)
			{
				addButton(mod);
			}
		}
		return this;
	}
}