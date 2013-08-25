package com.reeszrbteam.ce.console.commands;

import com.kodehawa.CheatingEssentials;
import com.kodehawa.module.classes.Step;
import com.reeszrbteam.ce.console.BaseCommand;

public class CommandStepHeight extends BaseCommand {

	public CommandStepHeight( ) {
		super("stepHeight", "Kodehawa", "1.6.2");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void runCommand(String s, String[] args) {
		// TODO Auto-generated method stub
		try{
			float result = Float.parseFloat(args [ 0 ]);
			if(result <= 100.0F){
			Step.setStepHeight(result);
			CheatingEssentials.getCheatingEssentials().getUtils().addChatMessage("Step height changed to " + result + "!");
			}
			}
			
			catch (Exception e)
	        {
	          CheatingEssentials.getCheatingEssentials().getUtils().addChatMessage("Usage: " + getSyntax());
	          e.printStackTrace();
	        }
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Modify the step height of blocks";
	}

	@Override
	public String getSyntax() {
		// TODO Auto-generated method stub
		return "stepHeight <float>";
	}

}
