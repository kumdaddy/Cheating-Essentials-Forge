package com.reeszrbteam.ce.gui.click.windows;

import com.kodehawa.ce.module.core.CheatingEssentialsModule;
import com.kodehawa.ce.module.enums.EnumGuiCategory;
import com.kodehawa.ce.module.handlers.ModuleManager;
import com.reeszrbteam.ce.gui.click.elements.YAWWindow;

public class WindowUtils extends YAWWindow {

	public WindowUtils() {
		super("Utils", 94, 154);
	}
	
	public YAWWindow init()
	{
		for(CheatingEssentialsModule mod: ModuleManager.getInstance().modules)
		{
			if(mod.getType() == EnumGuiCategory.UTILS)
			{
				addButton(mod);
			}
		}
		return this;
	}

}
