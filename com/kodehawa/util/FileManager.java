package com.kodehawa.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import com.kodehawa.module.ModuleBase;
import com.kodehawa.module.ModuleManager;
import com.kodehawa.module.classes.BlockESP;
import com.kodehawa.module.classes.Xray;

import com.kodehawa.CheatingEssentials;
import org.lwjgl.input.Keyboard;

public class FileManager {
    public static File mainDir;
    public static File someDir;
    public static File crashDir;
    public static File keyDir;
    private static volatile FileManager instance;

    public FileManager( ) {
        crashDir = new File( CheatingEssentials.getCheatingEssentials().getMinecraftInstance().mcDataDir + File.separator + "log");
        keyDir = new File(CheatingEssentials.getMinecraftInstance().mcDataDir, "/config/Cheating Essentials/CEKeybinds.txt");
		mainDir = new File( CheatingEssentials.getCheatingEssentials().getMinecraftInstance().mcDataDir, "/config/Cheating Essentials/CEXrayBlockList.txt");
        someDir = new File( CheatingEssentials.getCheatingEssentials().getMinecraftInstance().mcDataDir, "/config/Cheating Essentials/CEBlockESPList.txt");

        if(!keyDir.exists()){
           keyDir.getParentFile().mkdirs();
            try{
              keyDir.createNewFile();
              saveKeybinding();
            }
            catch (IOException e){
               e.printStackTrace();
            }
        }

        if(!mainDir.exists()){
            mainDir.getParentFile().mkdirs();
            try {
				mainDir.createNewFile();
                saveXrayList();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        if(!someDir.exists()){
            someDir.getParentFile().mkdirs();
            try{
                someDir.createNewFile();
                saveBlockESPList();
            }
            catch(IOException e){
              e.printStackTrace();
            }
        }
        loadXrayList();
        loadBlockESPList();
        loadKeybindings();
    }
	/**
	 * Now with a configurable Xray :D
	 * Write the entire file again when a block it's changed in-game
	 */
	
    public static void saveXrayList( ) {
        try {
        	CheatingEssentials.getCheatingEssentials().CELogAgent("Writting X-Ray list configuration file...");
            File file = new File( mainDir, "" );
            BufferedWriter bufferedwritter = new BufferedWriter( new FileWriter( file ) );
            for( int i : Xray.xrayBlocks ) {
            	bufferedwritter.write( i + "\r\n" );
            }
            bufferedwritter.close( );
        	
        } catch( Exception ex ) {
        	CheatingEssentials.getCheatingEssentials().CELogErrorAgent("Can't write X-Ray configuration file! Custom blocks for X-Ray will be disabled!");
        	 CheatingEssentials.getCheatingEssentials().CELogErrorAgent("Error in CE init: " + ex.toString( ) );
        }
    }

    /**
     * Save BlockESP configs. inb4flamewar
     */
    public static void saveBlockESPList(){
        try {
            CheatingEssentials.getCheatingEssentials().CELogAgent("Writting BlockESP block list configuration file...");
            File file = new File( someDir, "" );
            BufferedWriter bufferedwritter = new BufferedWriter( new FileWriter( file ) );
            for( int i : BlockESP.espList ) {
                bufferedwritter.write( i + "\r\n" );
            }
            bufferedwritter.close( );

        } catch( Exception ex ) {
            CheatingEssentials.getCheatingEssentials().CELogErrorAgent("Can't write BlockESP configuration file! Custom blocks for X-Ray will be disabled!");
            CheatingEssentials.getCheatingEssentials().CELogErrorAgent("Error in CE init: " + ex.toString( ) );
        }
    }

    /**
     * Save keybindings
      */
    public static void saveKeybinding(){
        try{
           CheatingEssentials.CELogAgent("Writing keybinding configuration file...");
            File file = new File(keyDir, "");
            BufferedWriter bufferedwriter = new BufferedWriter( new FileWriter( file ));
            for(ModuleBase m : ModuleManager.getInstance().modules){
                bufferedwriter.write("cekey-" + m.getName().toLowerCase().replace(" ", "") + ":" + Keyboard.getKeyName(m.getKeybinding()));
                bufferedwriter.write("\r\n");
            }
            bufferedwriter.close();
        }
        catch (Exception e){
            CheatingEssentials.CELogErrorAgent("Can't write Keybinding configuration file!");
            CheatingEssentials.CELogErrorAgent("Error in CE init: " + e.toString());
        }
    }

    public static void loadKeybindings(){
        try{
           File file = new File(keyDir, "");
           FileInputStream imput = new FileInputStream( file.getAbsolutePath() );
           DataInputStream stream = new DataInputStream( imput );
           BufferedReader bufferedreader = new BufferedReader( new InputStreamReader( stream ));
           String apetecan;
           while( (apetecan = bufferedreader.readLine() ) != null ){
                String line1 = apetecan.toLowerCase().trim();
                String[ ] s = line1.split(":");
                String mod = s[0];
               int key = Keyboard.getKeyIndex(s[1].toUpperCase());
               for(ModuleBase m : ModuleManager.getInstance().modules){
                   if(mod.equalsIgnoreCase("cekey-" + m.getName().toLowerCase().replace(" ", ""))) {
                       m.setKeybinding(key);
                   //CheatingEssentials.CELogAgent("Binded " + m.getName() + " to: " + Keyboard.getKeyName(key) + " succefully" );
                   }
               }
            }
        }
        catch (Exception e){
            saveKeybinding();
            CheatingEssentials.CELogErrorAgent("Can't read Keybinding configuration file!");
            CheatingEssentials.CELogErrorAgent("Error in CE init: " + e.toString());
        }
    }

    /**
     * Loads BlockESP list
     */
    public static void loadBlockESPList(){
        try {
            File file = new File( someDir, "" );
            FileInputStream fstream = new FileInputStream( file.getAbsolutePath( ) );
            DataInputStream in = new DataInputStream( fstream );
            BufferedReader br = new BufferedReader( new InputStreamReader( in ) );
            String line;
            while( ( line = br.readLine( ) ) != null ) {
                String curLine = line.toLowerCase( ).trim( );
                int id = Integer.parseInt( curLine );
                BlockESP.espList.add( id );
            }
            br.close( );
        } catch( Exception ex ) {
            CheatingEssentials.CELogErrorAgent("Can't load Block ESP list. Unreliable results!");
            CheatingEssentials.CELogErrorAgent( "Error in CE init: " + ex.toString( ) );
            ex.printStackTrace( );
            saveBlockESPList( );
        }
    }
    
    /**
     * Load the integers of the Xray list. Only readed once
     * If a error it's finded it saves the X-Ray list again for prevent errors.
     */
    
    public static void loadXrayList( ) {
        try {
        	File file = new File( mainDir, "" );
            FileInputStream fstream = new FileInputStream( file.getAbsolutePath( ) );
            DataInputStream in = new DataInputStream( fstream );
            BufferedReader br = new BufferedReader( new InputStreamReader( in ) );
            String line;
            while( ( line = br.readLine( ) ) != null ) {
                String curLine = line.toLowerCase( ).trim( );
                int id = Integer.parseInt( curLine );
                Xray.xrayBlocks.add( id );
            }
            br.close( );
        } catch( Exception ex ) {
        	CheatingEssentials.CELogErrorAgent("Can't load X-Ray list. Unreliable results!");
        	CheatingEssentials.CELogErrorAgent( "Error in CE init: " + ex.toString( ) );
            ex.printStackTrace( );
            saveXrayList( );
    } 
    }
    
    public static FileManager getInstance() {
        if (instance == null) {
                instance = new FileManager();
        }
        return instance;
}
    

}
