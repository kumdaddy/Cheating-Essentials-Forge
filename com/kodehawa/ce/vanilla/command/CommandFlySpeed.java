package com.kodehawa.ce.vanilla.command;

import com.kodehawa.ce.util.Utils;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

public class CommandFlySpeed extends CommandBase {

	@Override
	public String getCommandName() {
		// TODO Auto-generated method stub
		return "flyspeed";
	}

	@Override
    public boolean canCommandSenderUseCommand(ICommandSender icommandsender){
		return true;
    }
	
	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		// TODO Auto-generated method stub
		return "/flyspeed <value (0.05 to 0.7>";
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		// TODO Auto-generated method stub
		Float result = Float.parseFloat(astring[ 0 ]);
        if(result <= 0.7){
            Minecraft.getMinecraft().thePlayer.capabilities.setFlySpeed(result);
            Utils.getInstance().addChatMessage("Fly speed changed to: "+result+" succefully");
        }
	}

}
