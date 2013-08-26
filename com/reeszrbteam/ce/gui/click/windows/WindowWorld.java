package com.reeszrbteam.ce.gui.click.windows;

import com.kodehawa.module.core.CheatingEssentialsModule;
import com.kodehawa.module.enums.EnumGuiCategory;
import com.kodehawa.module.handlers.ModuleManager;
import com.reeszrbteam.ce.gui.click.elements.YAWWindow;

public class WindowWorld extends YAWWindow
{
	public WindowWorld()
	{
		super("World", 186, 14);
	}
	
	public YAWWindow init()
	{
		for(CheatingEssentialsModule mod: ModuleManager.getInstance().modules)
		{
			if(mod.getType() == EnumGuiCategory.WORLD)
			{
				addButton(mod);
			}
		}
		return this;
	}
}