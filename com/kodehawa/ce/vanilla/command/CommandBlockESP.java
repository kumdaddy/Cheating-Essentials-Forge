package com.kodehawa.ce.vanilla.command;

import com.kodehawa.ce.module.classes.BlockESP;
import com.kodehawa.ce.util.FileManager;
import com.kodehawa.ce.util.Utils;
import com.reeszrbteam.ce.util.BlockFilter;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

public class CommandBlockESP extends CommandBase {

	@Override
	public String getCommandName() {
		// TODO Auto-generated method stub
		return "cblockesp";
	}

	@Override
    public boolean canCommandSenderUseCommand(ICommandSender icommandsender){
		return true;
    }
	
	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		// TODO Auto-generated method stub
		return "command.ce.blockesp";
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] args) {
		try {
			if(args[0].equalsIgnoreCase("add")) {
				if(!args[1].equals("0")){
					int id = BlockFilter.BlockNametoID(args[1]);
					String derp = BlockFilter.IDtoBlockName(id);
					BlockESP.espList.add(id);
                    FileManager.saveBlockESPList();
                    Utils.getInstance().addChatMessage("Added " + derp + "(" + id + ")" + " to the BlockESP list.");
				}else{
					Utils.getInstance().addChatMessage("Could not add Air Block into BlockESP!");
				}
			}
			if(args[0].equalsIgnoreCase("idadd")) {
				if(!args[1].equals("0")){
				int id = Integer.parseInt(args[1]);
				BlockESP.espList.add(id);
                FileManager.saveBlockESPList();
                String ID = BlockFilter.IDtoBlockName(id);
				Utils.getInstance().addChatMessage("Added BlockESP ID: " + id + "("+ID+")");
				}
			}
			if(args[0].equalsIgnoreCase("iddel")) {
				if(!args[1].equals("0")){
				int id = Integer.parseInt(args[1]);
				BlockESP.espList.remove(id);
                FileManager.saveBlockESPList();
                String ID = BlockFilter.IDtoBlockName(id);
				Utils.getInstance().addChatMessage("Removed BlockESP ID: " + id + "("+ID+")");
				}
			}
			if(args[0].equalsIgnoreCase("del")) {
				int id = BlockFilter.BlockNametoID(args[1]);
				String derp2 = BlockFilter.IDtoBlockName(id);
				if(BlockESP.espList.contains(id)) {
					BlockESP.espList.remove(BlockESP.espList.indexOf(id));
                    FileManager.saveBlockESPList();
					Utils.getInstance().addChatMessage("Removed " + derp2 + "(" + id + ")" + " from BlockESP.");
				} else {
					Utils.getInstance().addChatMessage(derp2 + "(" + id + ")" + " is not in the BlockESP list.");
				}
			}
			if(args[0].equalsIgnoreCase("clear")) {
				BlockESP.espList.clear();
                FileManager.saveBlockESPList();
				Utils.getInstance().addChatMessage("Cleared BlockESP.");
			}
		} catch(Exception e) {
			Utils.getInstance().addChatMessage("Usage: " + getCommandUsage(icommandsender));
		}
	}

}
