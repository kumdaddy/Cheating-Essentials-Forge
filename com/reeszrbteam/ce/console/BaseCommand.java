package com.reeszrbteam.ce.console;

/**
 * Main Command Class. All Commands should extends it.
 * @author ReesZRB
 *
 */
public abstract class BaseCommand {
	
	/**
	 * Unlocalized Command
	 */
	private String command;
	
	/**
	 * Command Credits
	 */
	private String credits;
	
	/**
	 * Command Version
	 */
	private String version;

	/**
     * Main constructor. Defines all things that a command needs
     */
	public BaseCommand(String command, String credits, String version) {
		this.command = command;
		this.credits = credits;
		this.version = version;
	}

	/**
	 * Runs Command
	 */
	public abstract void runCommand(String s, String[] args);
	
	/**
	 * Gets Description of a Command
	 */
	public abstract String getDescription();
	
	/**
	 * Gets Syntax of a Command
	 */
	public abstract String getSyntax();
	
	/**
	 * Gets Command
	 */
	public String getCommand() {
		return command;
	}
	
	/**
	 * Gets Credits
	 */
	public String getCredits(){
		return credits;
	}

	/**
	 * Gets Minecraft Version
	 */
	public String getVersion(){
		return version;
	}
}