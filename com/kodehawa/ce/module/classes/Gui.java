package com.kodehawa.ce.module.classes;

import net.minecraft.client.gui.GuiScreen;

import org.lwjgl.input.Keyboard;

import com.kodehawa.ce.module.annotations.ModuleTechnical;
import com.kodehawa.ce.module.core.CheatingEssentialsModule;
import com.kodehawa.ce.module.enums.EnumGuiCategory;
import com.reeszrbteam.ce.gui.click.YouAlwaysWinClickGui;

@ModuleTechnical
public class Gui extends CheatingEssentialsModule {

    public static int guimode = 1;
    public YouAlwaysWinClickGui reesgui;

    /**
     * Opens {@link ModuleGui} class ({@link GuiScreen}) when fired.
     */
    public Gui( ) {
        super("Gui", "", "1.6.2", Keyboard.KEY_G, EnumGuiCategory.NONE, true);
        reesgui = new YouAlwaysWinClickGui();
    }

    public void onEnableModule() {
        switch(guimode){
            case 1 : displayGuiScreen(reesgui); break;
        }
    }

    public void onDisableModule() {
        switch (guimode){
            case 1: displayGuiScreen(reesgui); break;
        }
    }

}
