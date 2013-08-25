package com.kodehawa.api;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import net.minecraft.client.Minecraft;

import com.kodehawa.CheatingEssentials;
import com.kodehawa.module.ModuleBase;
import com.kodehawa.module.ModuleManager;
import com.kodehawa.util.FileManager;


public class CJarLoader extends Thread {
    
    /**
     * The directory from which we load modules.
     */
    File jarDir = new File( CheatingEssentials.getCheatingEssentials().getMinecraftInstance( ).mcDataDir + File.separator + "modules"
            + File.separator + "files" );
    private static volatile CJarLoader instance;
    
    public CJarLoader( ) {
        // TODO Auto-generated constructor stub
        instance = this;
    	if( !jarDir.exists( ) ) {
            jarDir.mkdirs( );
            jarDir.mkdir( );
        }
    	run( );
    }

    public void loadJars( ) {
     
        try {
            Class c = Minecraft.class;
            String path = c.getProtectionDomain().getCodeSource().getLocation().getPath();
            File file = new File(path.replace("%20", " ").replace("%23", "#")/*+p.replace(".", "/"))*/);
            File[ ] flist = file.listFiles( );
            ArrayList<String> classes = new ArrayList<String>();
            URLClassLoader ucl;
            FileInputStream fis;
            ZipInputStream jis;
            for( File f : flist ) {
                log( "File found: " + f.getName( ) );
                if( f.isFile( ) ) {
                    if( f.getName( ).endsWith( ".jar" ) || f.getName( ).endsWith( ".JAR" )
                            || f.getName( ).endsWith( ".zip" ) || f.getName( ).endsWith( ".ZIP" ) ) {
                        log( "Module found: " + f.getName( ) );
                        log( "Attempting to load classes from " + f.getName( ) + "..." );
                        URL[ ] url = {
                            new URL( "jar:file:///" + file + f.getName( ) + "!/" )
                        };
                        ucl = new URLClassLoader( url );
                        fis = new FileInputStream( f );
                        jis = new ZipInputStream( fis );
                        Class clazz;
                        ZipEntry yolo = null;
                        while( ( yolo = jis.getNextEntry( ) ) != null ) {
                            if( !yolo.isDirectory( ) ) {
                                if( !yolo.getName( ).endsWith( ".class" ) ) {
                                    log( "ZipEntry found: " + yolo.getName( ) );
                                }
                                if( yolo.getName( ).endsWith( ".class" ) ) {
                                    log( "Class found: " + yolo.getName( ) );
                                    clazz = ucl.loadClass( yolo.getName( ).substring( 0, yolo.getName( ).length( ) - 6 )
                                            .replace( "/", "." ) );
                                    log( "Class loaded: " + yolo.getName( ).replace( "/", "." ) );
                                 if(yolo.getName().startsWith("Player_") && yolo.getName().endsWith(".class")){
                                	  Constructor ctr = clazz.getConstructor( );
                                      ModuleBase q = ( ModuleBase ) ctr.newInstance( );
                                      log( "Player Module added: " + yolo.getName( ).replace( "/", "." ) );
                                      ModuleManager.getInstance().addModule( q );
                                 }
                                 if(yolo.getName().startsWith("World_") && yolo.getName().endsWith(".class")){
                               	  Constructor ctr = clazz.getConstructor( );
                                     ModuleBase q = ( ModuleBase ) ctr.newInstance( );
                                     log( "World Module added: " + yolo.getName( ).replace( "/", "." ) );
                                     ModuleManager.getInstance().addModule( q );
                                }
                                if(yolo.getName().startsWith("Util_") && yolo.getName().endsWith(".class")){
                                  	  Constructor ctr = clazz.getConstructor( );
                                        ModuleBase q = ( ModuleBase ) ctr.newInstance( );
                                        log( "Utils Module added: " + yolo.getName( ).replace( "/", "." ) );
                                        ModuleManager.getInstance().addModule( q );
                                   }
                                else{
                                	log("Can't recognize Module type.");
                                }
                        }
                        jis.close( );
                        fis.close( );
                        ucl.close( );
                    }
                }
            }
        }
     }
   }
            catch( Exception ex ) {
            System.out.println( "Error in CE init: " + ex.toString( ) );
            ex.printStackTrace( );
        }
    }
    
    /**
     * Logs a message.
     * 
     * @param s
     */
    public void log( String s ) {
        CheatingEssentials.getCheatingEssentials().CELogAgent( "[External Loader] " + s );
    }

	private volatile boolean stopRequested = false;
	
	public void requestStop() {
		  stopRequested = true;
		}
    
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Thread thread = new Thread("Cheating Essentials Loader Thread");
        thread.setName("Cheating Essentials Loader Thread");
        thread.setPriority(1);
        thread.start();

		while(!stopRequested){
		loadJars();
		
		requestStop();
		}
	}

    public static CJarLoader getInstance(){
        if(instance == null){
            instance = new CJarLoader();
        }
        return instance;
    }
}
