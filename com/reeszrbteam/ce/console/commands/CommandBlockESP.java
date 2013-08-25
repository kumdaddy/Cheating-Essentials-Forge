package com.reeszrbteam.ce.console.commands;

import com.kodehawa.CheatingEssentials;
import com.kodehawa.module.classes.BlockESP;
import com.kodehawa.util.FileManager;
import com.reeszrbteam.ce.console.BaseCommand;
import com.reeszrbteam.ce.util.BlockFilter;

public class CommandBlockESP extends BaseCommand {
	public CommandBlockESP() {
		super("blockesp", "ReesZRB", "1.6.2");
	}

	@Override
	public void runCommand(String s, String[] args) {
		try {
			if(args[0].equalsIgnoreCase("add")) {
				if(!args[1].equals("0")){
					int id = BlockFilter.BlockNametoID(args[1]);
					String derp = BlockFilter.IDtoBlockName(id);
					BlockESP.espList.add(id);
                    FileManager.saveBlockESPList();
                    CheatingEssentials.getCheatingEssentials().getUtils().addChatMessage("Added " + derp + "(" + id + ")" + " to the BlockESP list.");
				}else{
					CheatingEssentials.getCheatingEssentials().getUtils().addChatMessage("Could not add Air Block into BlockESP!");
				}
			}
			if(args[0].equalsIgnoreCase("del")) {
				int id = BlockFilter.BlockNametoID(args[1]);
				String derp2 = BlockFilter.IDtoBlockName(id);
				if(BlockESP.espList.contains(id)) {
					BlockESP.espList.remove(BlockESP.espList.indexOf(id));
                    FileManager.saveBlockESPList();
					CheatingEssentials.getCheatingEssentials().getUtils().addChatMessage("Removed " + derp2 + "(" + id + ")" + " from BlockESP.");
				} else {
					CheatingEssentials.getCheatingEssentials().getUtils().addChatMessage(derp2 + "(" + id + ")" + " is not in the BlockESP list.");
				}
			}
			if(args[0].equalsIgnoreCase("clear")) {
				BlockESP.espList.clear();
                FileManager.saveBlockESPList();
				CheatingEssentials.getCheatingEssentials().getUtils().addChatMessage("Cleared BlockESP.");
			}
		} catch(Exception e) {
			CheatingEssentials.getCheatingEssentials().getUtils().addChatMessage("Usage: " + getSyntax());
		}
	}

	@Override
	public String getDescription() {
		return "Adds and removes blocks from the search list";
	}

	@Override
	public String getSyntax() {
		return "blockesp add/del <block name>, blockesp clear";
	}
}