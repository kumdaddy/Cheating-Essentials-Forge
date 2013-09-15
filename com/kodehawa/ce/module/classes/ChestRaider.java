package com.kodehawa.ce.module.classes;

import com.kodehawa.ce.module.annotations.ModuleExperimental;
import com.kodehawa.ce.module.annotations.ModuleTechnical;
import com.kodehawa.ce.module.core.CheatingEssentialsModule;
import com.kodehawa.ce.module.enums.EnumGuiCategory;

@ModuleExperimental
@ModuleTechnical
public class ChestRaider extends CheatingEssentialsModule{

	/**
	 * Just for count it as a technical module, like GUI
	 */
	public ChestRaider() {
		super("Chest Raider", "", EnumGuiCategory.NONE, true);
	}


}
