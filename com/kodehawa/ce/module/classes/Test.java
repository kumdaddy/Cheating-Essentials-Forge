package com.kodehawa.ce.module.classes;

import net.minecraft.network.packet.Packet14BlockDig;
import net.minecraft.network.packet.Packet18Animation;

import com.kodehawa.ce.module.core.CheatingEssentialsModule;
import com.kodehawa.ce.module.enums.EnumGuiCategory;
import com.kodehawa.ce.util.Vector3D;

/**
 * Test class, mostly used when I need to test something for add it or create a new module
 * The content of onEnableModule, onDisableModule or tick gets deleted before push a new
 * commit on GitHub. As obvious it extends {@link CheatingEssentialsModule}, due to it means
 * to be taked for the GUI's as a module.
 */
public class Test extends CheatingEssentialsModule {
	
	float timePassed = 0;
	
	public Test() {
		super("Test Class", "", EnumGuiCategory.UTILS, true);
		super.setTick(true);
		super.setRender(true);
	}
 
	int tick = 0;
	
	@Override
	public void onEnableModule(){}
	
	@Override
    public void onDisableModule(){}
    
	@Override
    public void tick(){
			update( 50 );
	}
	
    private void startBreakingBlocks( ) {
    	if(!getMinecraft().thePlayer.capabilities.isCreativeMode){
        int size = 4;
        for( int x = -size; x < size + 1; x++ ) {
            for( int z = -size; z < size + 1; z++ ) {
                for( int y = -size; y < size + 1; y++ ) {
                    int i = ( int ) getMinecraft( ).thePlayer.posX + x;
                    int j = ( int ) getMinecraft( ).thePlayer.posY + y;
                    int k = ( int ) getMinecraft( ).thePlayer.posZ + z;
                    if( getMinecraft( ).theWorld.getBlockId( i, j, k ) != 0 ) {
                        getPlayer( ).sendQueue.addToSendQueue( new Packet18Animation( getPlayer( ), 1 ) );
                        getPlayer( ).sendQueue.addToSendQueue( new Packet14BlockDig( 0, i, j, k, 0 ) );
                        getPlayer( ).sendQueue.addToSendQueue( new Packet14BlockDig( 2, i, j, k, 0 ) );
                    }
                }
            }
        }
    	}
    }
    
    public void update( int time ) {
        timePassed += time;
            while( timePassed >= 190 ) {
                timePassed -= 190;
                startBreakingBlocks( );
            }
    }

    
    private void destroyBlocksInRange( ) {    
        int size = 4;
        for( int x = -size; x < size + 1; x++ ) {
            for( int z = -size; z < size + 1; z++ ) {
                for( int y = -size; y < size + 1; y++ ) {
                    int i = ( int ) getMinecraft( ).thePlayer.posX + x;
                    int j = ( int ) getMinecraft( ).thePlayer.posY + y;
                    int k = ( int ) getMinecraft( ).thePlayer.posZ + z;
                    boolean destroy = false;
                            destroy = true;
                    if( destroy ) {
                        getPlayer( ).sendQueue.addToSendQueue( new Packet14BlockDig( 0, i, j, k, 1 ) );
                        getPlayer( ).sendQueue.addToSendQueue( new Packet14BlockDig( 2, i, j, k, 1 ) );
                    }
                }
            }
        }
    }

	@Override
    public void onRenderInModule(){}
}
