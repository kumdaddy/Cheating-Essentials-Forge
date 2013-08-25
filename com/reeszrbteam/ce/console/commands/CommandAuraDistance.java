package com.reeszrbteam.ce.console.commands;

import com.kodehawa.CheatingEssentials;
import com.kodehawa.module.classes.Mobaura;
import com.reeszrbteam.ce.console.BaseCommand;

public class CommandAuraDistance extends BaseCommand {

	public CommandAuraDistance( ) {
		super("auradistance", "Kodehawa", "1.6.2");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void runCommand(String s, String[] args) {
		// TODO Auto-generated method stub
		try{
			double result = Double.parseDouble(args [ 0 ]);
			if(result <= 100.0D){
			Mobaura.setAuraDistance(result);
			CheatingEssentials.getCheatingEssentials().getUtils().addChatMessage("Aura distance changed to " + result + "!");
			}
			}
			
			catch (Exception e)
	        {
	          CheatingEssentials.getCheatingEssentials().getUtils().addChatMessage("Usage: " + getSyntax());
	        }
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Modify aura distance";
	}

	@Override
	public String getSyntax() {
		// TODO Auto-generated method stub
		return "auradistance <number>";
	}

}
