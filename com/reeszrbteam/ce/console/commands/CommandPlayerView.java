package com.reeszrbteam.ce.console.commands;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

import com.kodehawa.ce.util.Utils;
import com.reeszrbteam.ce.console.BaseCommand;

public class CommandPlayerView extends BaseCommand {
	public CommandPlayerView() {
		super("playerview", "ReesZRB", "1.6.2");
	}

	@Override
	public void runCommand(String s, String[] args) {
		try {
			if(args[0].equalsIgnoreCase("off")) {
				Minecraft.getMinecraft().renderViewEntity = Minecraft.getMinecraft().thePlayer;
				Utils.getInstance().addChatMessage("Now viewing normally.");
				return;
			}
			for(Object o : Minecraft.getMinecraft().theWorld.loadedEntityList) {
				if(o instanceof EntityPlayer) {
					EntityPlayer e = (EntityPlayer) o;
					if(e.username.equalsIgnoreCase(args[0])) {
						Minecraft.getMinecraft().renderViewEntity = e;
					}
				}
			}
		} catch(Exception e) {
			Utils.getInstance().addChatMessage("Invalid player or arguments. Usage: " + getSyntax());
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
