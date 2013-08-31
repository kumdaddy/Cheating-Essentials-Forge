package com.reeszrbteam.ce.console.commands;

import com.kodehawa.ce.CheatingEssentials;
import com.kodehawa.ce.module.core.CheatingEssentialsModule;
import com.kodehawa.ce.module.handlers.ModuleManager;
import com.reeszrbteam.ce.console.BaseCommand;

public class CommandHardcoreMode extends BaseCommand {

    /**
     * Main constructor. Defines all things that a command needs
     */
    public CommandHardcoreMode( ) {
        super("hardcore", "Kodehawa", "1.6.2");
    }

    @Override
    public void runCommand(String s, String[] args) {
        try{
        	if(args[0].equalsIgnoreCase("enable")){
        		CheatingEssentials.getCheatingEssentials().isHardcoreModeEnabled = true;
        		for(CheatingEssentialsModule module : ModuleManager.getInstance().modules){
        			module.setKeybinding(0);
        		}
    			CheatingEssentials.getCheatingEssentials().getUtils().addChatMessage("Hardcore mode enabled!");
        	}
        	if(args[0].equalsIgnoreCase("disable")){
        		CheatingEssentials.getCheatingEssentials().isHardcoreModeEnabled = false;
        		for(CheatingEssentialsModule module : ModuleManager.getInstance().modules){
        			module.setKeybinding(module.keybind);
        			CheatingEssentials.getCheatingEssentials().getUtils().addChatMessage("Hardcore mode disabled!");
        		}
        	}
                }
            catch(Exception e){
    			CheatingEssentials.getCheatingEssentials().getUtils().addChatMessage("Usage: " + getSyntax());
            }
    }

    @Override
    public String getDescription() {
        return "Toggle Hardcore mode. WIP.";
    }

    @Override
    public String getSyntax() {
        return "hardcore <enable/disable>";
    }
}
