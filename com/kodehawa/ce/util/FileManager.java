package com.kodehawa.ce.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;

import net.minecraft.block.Block;

import org.lwjgl.input.Keyboard;

import com.kodehawa.ce.forge.loader.CE_ForgeLoader;
import com.kodehawa.ce.module.classes.BlockESP;
import com.kodehawa.ce.module.core.CheatingEssentialsModule;
import com.kodehawa.ce.module.handlers.ModuleManager;

import cpw.mods.fml.client.FMLClientHandler;

public class FileManager<E, T> {
    public static File mainDir;
    public static File someDir;
    public static File crashDir;
    public static File keyDir;
    private static volatile FileManager instance;

    public FileManager( ) {
        crashDir = new File( FMLClientHandler.instance().getClient().
        		mcDataDir + File.separator + "log");
        keyDir = new File(FMLClientHandler.instance().getClient().
        		mcDataDir, "/config/Cheating Essentials/CEKeybinds.txt");
        someDir = new File( FMLClientHandler.instance().getClient().
        		mcDataDir, "/config/Cheating Essentials/CEBlockESPList.txt");

        if(!keyDir.exists()){
           keyDir.getParentFile().mkdirs();
            try{ keyDir.createNewFile();  saveKeybinding(); }
            catch (IOException e){}
        }
        if(!someDir.exists()){
            someDir.getParentFile().mkdirs();
            try{ someDir.createNewFile();  saveBlockESPList(); }
            catch(IOException e){}
        }
        loadBlockESPList();
        loadKeybindings();
    }
    
    /**
     * Save BlockESP configs. inb4flamewar
     */
    public static void saveBlockESPList(){
        try {
        	CE_ForgeLoader.instance().log("Writting BlockESP block list configuration file...");
            File file = new File( someDir, "" );
            BufferedWriter bufferedwritter = new BufferedWriter( new FileWriter( file ) );
            for( int i : BlockESP.espList ) {
                bufferedwritter.write( i + "\r\n" );
            }
            bufferedwritter.close( );

        } catch( Exception ex ) {
        	CE_ForgeLoader.instance().log("Can't write BlockESP configuration file! Custom blocks for X-Ray will be disabled!");
        	CE_ForgeLoader.instance().log("Error in CE init: " + ex.toString( ) );
        }
    }

    /**
     * Save keybindings
      */
    public static void saveKeybinding(){
        try{
        	CE_ForgeLoader.instance().log("Writing keybinding configuration file...");
            File file = new File(keyDir, "");
            BufferedWriter bufferedwriter = new BufferedWriter( new FileWriter( file ));
            for(CheatingEssentialsModule m : ModuleManager.getInstance().modules){
                bufferedwriter.write("cekey-" + m.getName().toLowerCase().replace(" ", "") + ":" + Keyboard.getKeyName(m.getKeybinding()));
                bufferedwriter.write("\r\n");
            }
            bufferedwriter.close();
        }
        catch (Exception e){
        	CE_ForgeLoader.instance().log("Can't write Keybinding configuration file!");
        	CE_ForgeLoader.instance().log("Error in CE init: " + e.toString());
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
               for(CheatingEssentialsModule m : ModuleManager.getInstance().modules){
                   if(mod.equalsIgnoreCase("cekey-" + m.getName().toLowerCase().replace(" ", ""))) {
                       m.setKeybinding(key);
                   }
               }
            }
        }
        catch (Exception e){
            saveKeybinding();
            CE_ForgeLoader.instance().log("Can't read Keybinding configuration file!");
            CE_ForgeLoader.instance().log("Error in CE init: " + e.toString());
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
        	CE_ForgeLoader.instance().log("Can't load Block ESP list. Unreliable results!");
        	CE_ForgeLoader.instance().log( "Error in CE init: " + ex.toString( ) );
            ex.printStackTrace( );
            saveBlockESPList( );
        }
    }
    
    public static FileManager getInstance() {
        if (instance == null) {
                instance = new FileManager();
        }
        return instance;
}
    

}
