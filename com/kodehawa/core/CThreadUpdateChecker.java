package com.kodehawa.core;

import com.kodehawa.CheatingEssentials;

public class CThreadUpdateChecker extends Thread {

	private volatile boolean stopRequested = false;
	public boolean outdatedAlert;
	
	public CThreadUpdateChecker() {
	}
	
	public boolean update( ) {
        outdatedAlert = false;
        try {
        	CheatingEssentials.getCheatingEssentials().CELogAgent( "Checking for a Cheating Essentials update..." );
            String ver;
            Strings.VERSION_FOUND = ver = HTMLParser.getStringFromRemoteServer( "http://kodehawa.260mb.net/updates.txt" );
            if( ver.equals( Strings.MOD_VERSION ) ) {
                // Shouldn't hafta do anything, because we're up to date.
                // Returns false, because no need to update.
            	CheatingEssentials.getCheatingEssentials().CELogAgent( "No new updates has been found!" );
                return false;
                
            } else if( !ver.equals( Strings.MOD_VERSION ) ) {
                if( Integer.parseInt( ver.replaceAll( "\\D+", "" ) ) > Integer.parseInt( Strings.MOD_VERSION.replaceAll(
                        "\\D+", "" ) ) ) {
                    // Obviously, we gotta update!
                	CheatingEssentials.getCheatingEssentials().CELogAgent( "Update found: " + ver );
                	CheatingEssentials.getCheatingEssentials().CELogAgent( "Current version: " + Strings.MOD_VERSION );
                    return true;
                } else {
                    if( !ver.replaceAll( "[^A-Za-z]", "" ).equals( Strings.MOD_VERSION.replaceAll( "[^A-Za-z]", "" ) ) ) {
                    	CheatingEssentials.getCheatingEssentials().CELogAgent( "Update found: " + ver );
                    	CheatingEssentials.getCheatingEssentials().CELogAgent( "Current version: " + Strings.MOD_VERSION );
                        return true;
                    } else {
                    	//We don't want to fave older versions on main servers. Right?
                    	CheatingEssentials.getCheatingEssentials().CELogAgent( "No new updates found! (Older version is on the server, report this to the in the Minecraft Forum post!)" );
                    	outdatedAlert = true;
                        return false;
                    }
                }
            } else {
                throw new NullPointerException( "No update info found!" );
            }
           
        } catch( NullPointerException e ) {
        	CheatingEssentials.getCheatingEssentials().CELogAgent( "Issue getting update information" );
            e.printStackTrace( );
            return false;
        }
    }
	
	public void requestThreadStop() {
		  stopRequested = true;
		}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Thread thread = new Thread("Cheating Essentials Update Checker Main Thread");
        thread.setName("Cheating Essentials Update Checker Main Thread");
        thread.setPriority(3);
        thread.start();
        
        while(!stopRequested){
	    	try {
                update();
	    		requestThreadStop();
			} catch (Exception ex) {
	}
	
}
	}
}
