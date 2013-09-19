package com.kodehawa.ce.vanilla.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;

import org.lwjgl.input.Keyboard;

import com.kodehawa.ce.module.core.CheatingEssentialsModule;
import com.kodehawa.ce.module.handlers.ModuleManager;
import com.kodehawa.ce.util.FileManager;
import com.kodehawa.ce.util.Utils;

public class CommandBind extends CommandBase {

	@Override
	public String getCommandName() {
		return "cbind";
	}
	
	@Override
    public boolean canCommandSenderUseCommand(ICommandSender icommandsender){
		return true;
    }

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		return "command.ce.bind";
	}
	
	@Override
	public void processCommand(ICommandSender icommandsender, String[] args) {
		if(icommandsender instanceof EntityPlayer)
		try{
		if(args[0].equalsIgnoreCase("add")) {
			for(CheatingEssentialsModule m : ModuleManager.getInstance().modules) {
				if(m.name.replace(" ", "").equalsIgnoreCase(args[1])) {
					if(Keyboard.getKeyIndex(args[2].toUpperCase()) == 0) {
						Utils.getInstance().addChatMessage("Invalid key.");
						return;
					}
					m.setKeybinding(Keyboard.getKeyIndex(args[2].toUpperCase()));
                    FileManager.saveKeybinding();
                    Utils.getInstance().addChatMessage(m.name + " bound to: " + Keyboard.getKeyName(m.getKeybinding()));
					break;
				}
			}
		}
		if(args[0].equalsIgnoreCase("del")) {
			for(CheatingEssentialsModule m : ModuleManager.getInstance().modules) {
				if(m.getKeybinding() == Keyboard.getKeyIndex(args[1].toUpperCase())) {
					m.setKeybinding(0);
                    FileManager.saveKeybinding();
                    Utils.getInstance().addChatMessage("Unbound: " + args[1].toUpperCase());
					break;
				}
			}
		}
		if(args[0].equalsIgnoreCase("clearall")) {
			for(CheatingEssentialsModule m : ModuleManager.getInstance().modules) {
				m.setKeybinding(0);
                FileManager.saveKeybinding();
                Utils.getInstance().addChatMessage("All Keys Unbound.");
			}
		}
	} catch(Exception e) {
		e.printStackTrace();
		Utils.getInstance().addChatMessage("Usage: " + getCommandUsage(icommandsender));
		}
	}
}
