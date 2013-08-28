package com.reeszrbteam.ce.gui.click.windows;

import com.kodehawa.ce.module.core.CheatingEssentialsModule;
import com.kodehawa.ce.module.enums.EnumGuiCategory;
import com.kodehawa.ce.module.handlers.ModuleManager;
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