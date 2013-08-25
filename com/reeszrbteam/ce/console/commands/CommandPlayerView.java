package com.reeszrbteam.ce.console.commands;

import net.minecraft.entity.player.EntityPlayer;

import com.kodehawa.CheatingEssentials;
import com.reeszrbteam.ce.console.BaseCommand;

public class CommandPlayerView extends BaseCommand {
	public CommandPlayerView() {
		super("playerview", "ReesZRB", "1.6.2");
	}

	@Override
	public void runCommand(String s, String[] args) {
		try {
			if(args[0].equalsIgnoreCase("off")) {
				CheatingEssentials.getMinecraftInstance().renderViewEntity = CheatingEssentials.getMinecraftInstance().thePlayer;
				CheatingEssentials.getCheatingEssentials().getUtils().addChatMessage("Now viewing normally.");
				return;
			}
			for(Object o : CheatingEssentials.getMinecraftInstance().theWorld.loadedEntityList) {
				if(o instanceof EntityPlayer) {
					EntityPlayer e = (EntityPlayer) o;
					if(e.username.equalsIgnoreCase(args[0])) {
						CheatingEssentials.getMinecraftInstance().renderViewEntity = e;
					}
				}
			}
		} catch(Exception e) {
			CheatingEssentials.getCheatingEssentials().getUtils().addChatMessage("Invalid player or arguments. Usage: " + getSyntax());
		}
	}

	@Override
	public String getDescription() {
		return "Lets you see another player's camera";
	}

	@Override
	public String getSyntax() {
		return "playerview <name>";
	}
}
