package com.reeszrbteam.ce.console.commands;

import com.kodehawa.CheatingEssentials;
import com.kodehawa.module.classes.Xray;
import com.kodehawa.util.FileManager;
import com.reeszrbteam.ce.console.BaseCommand;
import com.reeszrbteam.ce.util.BlockFilter;

public class CommandXray extends BaseCommand
{
	public CommandXray()
	{
		super("xray", "ReesZRB, Kodehawa", "1.6.2");
	}

	@Override
	public void runCommand(String s, String[] args)
	{
		try
		{
			if(args[0].equalsIgnoreCase("add"))
			{
				int id = BlockFilter.BlockNametoID(args[1]);
				String blockname = BlockFilter.IDtoBlockName(id);
				if(!Xray.xrayBlocks.contains(id))
				{
					Xray.xrayBlocks.add(id);
					CheatingEssentials.getCheatingEssentials().getUtils().addChatMessage("Added " + blockname + "(" + id + ") to xray list.");
					CheatingEssentials.getMinecraftInstance().renderGlobal.loadRenderers();
					FileManager.saveXrayList();
				}else
				{
					CheatingEssentials.getCheatingEssentials().getUtils().addChatMessage(blockname + "(" + id + ") is already in the xray list.");
				}
			}else if(args[0].equalsIgnoreCase("del") || args[0].equalsIgnoreCase("rem"))
			{
				int id = BlockFilter.BlockNametoID(args[1]);
				String blockname = BlockFilter.IDtoBlockName(id);
				if(Xray.xrayBlocks.contains(id))
				{
					Xray.xrayBlocks.remove(Xray.xrayBlocks.indexOf(id));
					CheatingEssentials.getCheatingEssentials().getUtils().addChatMessage("Removed " + blockname + "(" + id + ") from xray list.");
					CheatingEssentials.getMinecraftInstance().renderGlobal.loadRenderers();
					FileManager.saveXrayList();
				}else
				{
					CheatingEssentials.getCheatingEssentials().getUtils().addChatMessage(blockname + "(" + id + ") is not in the xray list.");
				}
			}
		}catch(Exception e)
		{
			CheatingEssentials.getCheatingEssentials().getUtils().addChatMessage("Usage: " + getSyntax());
			e.printStackTrace();
		}
	}

	@Override
	public String getDescription() 
	{
		return "Custom xray.";
	}

	@Override
	public String getSyntax() 
	{
		return "xray add/del <BlockName>";
	}
}