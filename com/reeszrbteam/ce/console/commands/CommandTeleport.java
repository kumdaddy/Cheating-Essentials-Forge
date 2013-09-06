package com.reeszrbteam.ce.console.commands;

import com.kodehawa.ce.util.Utils;
import com.reeszrbteam.ce.console.BaseCommand;
import com.reeszrbteam.ce.util.Teleport;

public class CommandTeleport extends BaseCommand{

	public CommandTeleport() {
		super("tp", "ReesZRB", "1.6.2");
	}
	
	@Override
	public void runCommand(String s, String[] args) {
		try {
			double x = Double.parseDouble(args[0]);
			double y = Double.parseDouble(args[1]);
			double z = Double.parseDouble(args[2]);
			Teleport.teleport(x, y, z);
			Utils.getInstance().addChatMessage("Teleported to: (" + args[0] + ", " + args[1] + ", " + args[2] + ")");
		} catch(Exception e) {
			e.printStackTrace();
			Utils.getInstance().addChatMessage("Usage: " + getSyntax());
		}	
	}

	@Override
	public String getDescription() {
		return "Teleports to coords.";
	}

	@Override
	public String getSyntax() {
		return "tp <x> <y> <z>";
	}
}
