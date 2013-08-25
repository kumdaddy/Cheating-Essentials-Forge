package com.reeszrbteam.ce.console;

import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.multiplayer.NetClientHandler;
import net.minecraft.util.ChatAllowedCharacters;

import org.lwjgl.input.Keyboard;

import com.reeszrbteam.ce.util.CEUtils;
 
public class GuiConsole extends GuiScreen
{
    ArrayList cmds = new ArrayList();
    public static ArrayList OrgName = new ArrayList();
    public static ArrayList NameP = new ArrayList();
    protected String message = "";
    private int updateCounter = 0;
    public NetClientHandler sendQueue;
    private static final String allowedCharacters = ChatAllowedCharacters.allowedCharacters;
 
    public GuiConsole()
    {
        this.cmds.clear();
        for(BaseCommand c : CommandManager.commands){
        	this.cmds.add(c.getCommand() + " - " + c.getDescription());
        }
    }
    public GuiConsole(Minecraft mc)
    {
    	this.mc = mc;
    }
    public void addChatMessage(String s)
    {
    	mc.thePlayer.addChatMessage(s);
    }

	/**
     * Adds the buttons (and other controls) to the screen in question.
     */
    public void initGui()
    {
        Keyboard.enableRepeatEvents(true);
    }
 
    /**
     * Called when the screen is unloaded. Used to disable keyboard repeat events
     */
    public void onGuiClosed()
    {
    	this.message = "";
        Keyboard.enableRepeatEvents(false);
    }
 
    /**
     * Called from the main game loop to update the screen.
     */
    public void updateScreen()
    {
        ++this.updateCounter;
    }
 
    /**
     * Fired when a key is typed. This is the equivalent of KeyListener.keyTyped(KeyEvent e).
     */
    protected void keyTyped(char var1, int var2)
    {
        String var3;
 
        if (var1 == 22)
        {
            var3 = GuiScreen.getClipboardString();
 
            if (var3 != null)
            {
                this.message = this.message + var3;
            }
        }
 
        if (var2 == 1)
        {
            this.mc.displayGuiScreen((GuiScreen)null);
        }
        else if (var2 == 28)
        {
            var3 = this.message.trim();
            String[] var4;
            String var5;
            
            CommandManager.getInstance().runCommands("." + var3);
            
            this.mc.displayGuiScreen((GuiScreen)null);
        }
        else
        {
            if (var2 == 14 && this.message.length() > 0)
            {
                this.message = this.message.substring(0, this.message.length() - 1);
            }
 
            if (allowedCharacters.indexOf(var1) >= 0 && this.message.length() < 100)
            {
                this.message = this.message + var1;
            }
        }
    }
 
    /**
     * Draws the screen and all the components in it.
     */
    public void drawScreen(int var1, int var2, float var3)
    {
        int var4 = 24;
 
        for (int var5 = 0; var5 < this.cmds.size(); ++var5)
        {
            String var6 = (String)this.cmds.get(var5);
 
            if (var6.startsWith(this.message) && this.message.length() > 0)
            {
                CEUtils.drawBorderedRect(83 + 4, var4 - 6,83 + this.fontRenderer.getStringWidth(var6) + 8, var4 + 6, 1, -15066598, -14145496);
                
            	this.drawString(this.fontRenderer, var6,83 + 6, var4 - 4, 16777215);
                var4 += 14;
            }
        }
 
        CEUtils.drawBorderedRect( 83 + 4, 0, this.width - 60, 12, 1, -15066598, -14145496);
        this.fontRenderer.drawString("CE Console ",  83 + 10, 2, 0x55FFFF);
        this.drawString(this.fontRenderer, "" + (this.updateCounter / 12 % 2 != 0 ? "\u00a7b>\u00a77 " : "\u00a73>\u00a77 ") + this.message + (this.updateCounter / 12 % 2 != 0 ? " \u00a7b_" : " \u00a73_"), this.fontRenderer.getStringWidth("CE Console ") + 83 + 10, 2, 14737632);
        super.drawScreen(var1, var2, var3);
    }
}