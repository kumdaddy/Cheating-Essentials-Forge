package com.kodehawa.ce.playerrelations;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.kodehawa.ce.forge.common.Loader;

import cpw.mods.fml.client.FMLClientHandler;

public class Enemy {

    public final static ArrayList<String> enemyList = new ArrayList<String>();
    private static File enemyFile;
    private volatile static Enemy instance;


    public Enemy( ){
        enemyList.add("PvPTroll");

        enemyFile = new File(FMLClientHandler.instance().getClient().mcDataDir, "/config/Cheating Essentials/CEEnemyList.txt");
        enemyFile.getParentFile().mkdirs();
        try{
           if(!enemyFile.exists()){
               enemyFile.createNewFile();
               writeEnemyFile();
           }
        }
        catch (IOException e){
        }
        loadEnemyFile();


    }

    public static void writeEnemyFile(){
    	Loader.instance().log("Writing Enemy file...");
        try{
           FileWriter filewritter = new FileWriter(enemyFile);
           BufferedWriter bufferedwriter = new BufferedWriter(filewritter);
               for(String string : enemyList){
                   bufferedwriter.write(string + "\r\n");
               }
            bufferedwriter.close();

        }
        catch (Exception e){

        }
    }

    public static void loadEnemyFile(){
        File file = new File(enemyFile, "");
        try {
            FileInputStream dataimput = new FileInputStream( file.getAbsolutePath());
            DataInputStream datastream = new DataInputStream(dataimput);
            BufferedReader reader = new BufferedReader( new InputStreamReader(datastream) );
            String string;
            while( ( string = reader.readLine( ) ) != null ) {
                String line = string.toLowerCase( ).trim( );
                enemyList.add( line + "\r\n" );
            }
            reader.close( );
        } catch (Exception e) {
            e.printStackTrace();
            writeEnemyFile();
        }
    }

    public boolean isEnemyInList( String s ){
        if(enemyList.contains(s)){
            return true;
        }
        else{
            return false;
        }
    }

    public static Enemy getInstance(){
        if(instance == null){
            instance = new Enemy();
        }
        return instance;
    }
}
