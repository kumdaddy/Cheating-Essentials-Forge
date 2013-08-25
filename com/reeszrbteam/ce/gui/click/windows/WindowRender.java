package com.reeszrbteam.ce.gui.click.windows;

import com.kodehawa.module.ModuleBase;
import com.kodehawa.module.ModuleManager;
import com.kodehawa.module.enums.EnumGuiCategory;
import com.reeszrbteam.ce.gui.click.elements.YAWWindow;


public class WindowRender extends YAWWindow
{
	public WindowRender()
	{
		super("Render", 278, 14);
	}

	public YAWWindow init()
	{
		for(ModuleBase mod: ModuleManager.getInstance().modules)
		{
			if(mod.getType() == EnumGuiCategory.RENDER)
			{
				addButton(mod);
			}
		}
		return this;
	}
}
