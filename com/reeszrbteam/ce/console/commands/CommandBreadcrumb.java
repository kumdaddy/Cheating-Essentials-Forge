package com.reeszrbteam.ce.console.commands;

import com.kodehawa.CheatingEssentials;
import com.kodehawa.module.classes.Breadcrumb;
import com.reeszrbteam.ce.console.BaseCommand;

public class CommandBreadcrumb extends BaseCommand {

    public CommandBreadcrumb() {
        super("breadcrumb", "ReesZRB", "1.6.2");
    }

    @Override
    public void runCommand(String s, String[] args) {
        try {
            if(args[0].equalsIgnoreCase("clear")) {
                Breadcrumb.positionsList.clear();
                CheatingEssentials.getCheatingEssentials().getUtils().addChatMessage("Cleared breadcrumbs.");
            }
        } catch(Exception e) {}
    }

    @Override
    public String getDescription() {
        return "Clears breadcrumbs.";
    }

    @Override
    public String getSyntax() {
        return "breadcrumb clear";
    }
}