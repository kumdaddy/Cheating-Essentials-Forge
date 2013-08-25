package com.kodehawa.gui.componentbase;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSmallButton;

import org.lwjgl.input.Keyboard;

/**
 * Selectable GUI for different modules. Information GUI too
 * @author Kodehawa
 *
 */

public class CheatingEssentialsTGui extends GuiScreen {


    /**
     * A reference to the screen object that created this. Used for navigating between screens.
     */
    GuiScreen parentScreen;


	/**
	 * There it's also a big posibility to allow searching. WIP GUI
	 */
	
    public CheatingEssentialsTGui(GuiScreen par1GuiScreen)
    {
       this.parentScreen = par1GuiScreen;
    }

    @Override
    public boolean doesGuiPauseGame()
    {
        return false;
    }

    @Override
    public void initGui()
    {
        this.buttonList.add(new GuiSmallButton(12, this.width / 6 - 5, this.height / 12 + 3, "Player"));
        this.buttonList.add(new GuiSmallButton(20, this.width / 6 - 5, this.height / 120 + 40, "World"));
        this.buttonList.add(new GuiSmallButton(36, this.width / 6 - 5, this.height / 140 + 70, "Utils"));
        this.buttonList.add(new GuiButton(88, this.width / 3 - 7, this.height / 37 + 200, "Exit GUI Hub"));

        Keyboard.enableRepeatEvents(true);
    }

    @Override
    public void onGuiClosed()
    {
        Keyboard.enableRepeatEvents(true);
    }

    @Override
    protected void keyTyped(char c, int i)
    {
        if (i == 1)
        {
            mc.displayGuiScreen(null);
            return;
        }

    }

    @Override
    public void drawScreen(int i, int j, float f)
    {
       this.drawDefaultBackground();
       this.drawCenteredString(this.fontRenderer, "Cheating Essentials 3.2.0 for Minecraft 1.6.2", this.width / 2, 5, 16777215);
       
       super.drawScreen(i, j, f);

    }

    @Override
    public void actionPerformed(GuiButton par1GuiButton){

        if (par1GuiButton.id == 88)
        {
            this.mc.displayGuiScreen(null);
        }
    }
}
