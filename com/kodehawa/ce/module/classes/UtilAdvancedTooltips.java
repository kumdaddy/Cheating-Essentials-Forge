package com.kodehawa.ce.module.classes;

import com.kodehawa.ce.module.core.CheatingEssentialsModule;
import com.kodehawa.ce.module.enums.EnumGuiCategory;

public class UtilAdvancedTooltips extends CheatingEssentialsModule {

    public UtilAdvancedTooltips( ) {
        super("Advanced Tooltips", "", "1.6.2", 0, EnumGuiCategory.UTILS, true);
    }

    @Override
    public void onEnableModule() {
    	getMinecraft().gameSettings.advancedItemTooltips = !getMinecraft().gameSettings.advancedItemTooltips;
    	getMinecraft().gameSettings.saveOptions();
    }

    @Override
    public void onDisableModule() {
    	getMinecraft().gameSettings.advancedItemTooltips = !getMinecraft().gameSettings.advancedItemTooltips;
    	getMinecraft().gameSettings.saveOptions();
    }

}
