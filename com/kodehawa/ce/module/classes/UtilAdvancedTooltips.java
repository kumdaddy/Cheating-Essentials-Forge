package com.kodehawa.ce.module.classes;

import com.kodehawa.ce.CheatingEssentials;
import com.kodehawa.ce.module.core.CheatingEssentialsModule;
import com.kodehawa.ce.module.enums.EnumGuiCategory;

public class UtilAdvancedTooltips extends CheatingEssentialsModule {

	//FUCK YOU -1
    public UtilAdvancedTooltips( ) {
        super("Advanced Tooltips", "", "1.6.2", 0, EnumGuiCategory.UTILS, true);
    }

    @Override
    public void onEnableModule() {
        CheatingEssentials.getMinecraftInstance().gameSettings.advancedItemTooltips = !CheatingEssentials.getMinecraftInstance().gameSettings.advancedItemTooltips;
        CheatingEssentials.getMinecraftInstance().gameSettings.saveOptions();
    }

    @Override
    public void onDisableModule() {
        CheatingEssentials.getMinecraftInstance().gameSettings.advancedItemTooltips = !CheatingEssentials.getMinecraftInstance().gameSettings.advancedItemTooltips;
        CheatingEssentials.getMinecraftInstance().gameSettings.saveOptions();
    }

}
