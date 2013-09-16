package com.kodehawa.ce.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;

import com.kodehawa.ce.vanilla.AltAxisAlignedBB;

import cpw.mods.fml.client.FMLClientHandler;

public class GLHelper {
    
    public static void drawBoundingBox( AltAxisAlignedBB axisalignedbb ) {
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads( ); // starts x
        tessellator.addVertex( axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.minZ );
        tessellator.addVertex( axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.minZ );
        tessellator.addVertex( axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.minZ );
        tessellator.addVertex( axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.minZ );
        tessellator.addVertex( axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.maxZ );
        tessellator.addVertex( axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.maxZ );
        tessellator.addVertex( axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.maxZ );
        tessellator.addVertex( axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.maxZ );
        tessellator.draw( );
        tessellator.startDrawingQuads( );
        tessellator.addVertex( axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.minZ );
        tessellator.addVertex( axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.minZ );
        tessellator.addVertex( axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.minZ );
        tessellator.addVertex( axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.minZ );
        tessellator.addVertex( axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.maxZ );
        tessellator.addVertex( axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.maxZ );
        tessellator.addVertex( axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.maxZ );
        tessellator.addVertex( axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.maxZ );
        tessellator.draw( ); // ends x
        tessellator.startDrawingQuads( ); // starts y
        tessellator.addVertex( axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.minZ );
        tessellator.addVertex( axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.minZ );
        tessellator.addVertex( axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.maxZ );
        tessellator.addVertex( axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.maxZ );
        tessellator.addVertex( axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.minZ );
        tessellator.addVertex( axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.maxZ );
        tessellator.addVertex( axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.maxZ );
        tessellator.addVertex( axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.minZ );
        tessellator.draw( );
        tessellator.startDrawingQuads( );
        tessellator.addVertex( axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.minZ );
        tessellator.addVertex( axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.minZ );
        tessellator.addVertex( axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.maxZ );
        tessellator.addVertex( axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.maxZ );
        tessellator.addVertex( axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.minZ );
        tessellator.addVertex( axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.maxZ );
        tessellator.addVertex( axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.maxZ );
        tessellator.addVertex( axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.minZ );
        tessellator.draw( ); // ends y
        tessellator.startDrawingQuads( ); // starts z
        tessellator.addVertex( axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.minZ );
        tessellator.addVertex( axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.minZ );
        tessellator.addVertex( axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.maxZ );
        tessellator.addVertex( axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.maxZ );
        tessellator.addVertex( axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.maxZ );
        tessellator.addVertex( axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.maxZ );
        tessellator.addVertex( axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.minZ );
        tessellator.addVertex( axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.minZ );
        tessellator.draw( );
        tessellator.startDrawingQuads( );
        tessellator.addVertex( axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.maxZ );
        tessellator.addVertex( axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.maxZ );
        tessellator.addVertex( axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.minZ );
        tessellator.addVertex( axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.minZ );
        tessellator.addVertex( axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.minZ );
        tessellator.addVertex( axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.minZ );
        tessellator.addVertex( axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.maxZ );
        tessellator.addVertex( axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.maxZ );
        tessellator.draw( ); // ends z
    }
    
    
   
    
    public static void enableDefaults( ) {
        Minecraft.getMinecraft( ).entityRenderer.disableLightmap( 0.0D );
        GL11.glEnable( 3042 );
        GL11.glDisable( 2896 );
        GL11.glDisable( 2929 );
        GL11.glEnable( 2848 );
        GL11.glDisable( 3553 );
        GL11.glHint( 3154, 4354 );
        GL11.glBlendFunc( 770, 771 );
        GL11.glEnable( 32925 );
        GL11.glEnable( 32926 );
        GL11.glShadeModel( 7425 );
        GL11.glLineWidth( 1.8F );
        GL11.glEnable( GL11.GL_BLEND );
        GL11.glDisable( GL11.GL_LIGHTING );
        GL11.glDisable( GL11.GL_DEPTH_TEST );
        GL11.glEnable( GL11.GL_LINE_SMOOTH );
        GL11.glDisable( GL11.GL_TEXTURE_2D );
        GL11.glHint( GL11.GL_LINE_SMOOTH_HINT, GL11.GL_NICEST );
        GL11.glBlendFunc( GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA );
        GL11.glEnable( GL13.GL_MULTISAMPLE );
        GL11.glEnable( GL13.GL_SAMPLE_ALPHA_TO_COVERAGE );
        GL11.glShadeModel( GL11.GL_SMOOTH );
        GL11.glDepthMask( false );
    }
    
    public static void disableDefaults( ) {
        GL11.glDisable( 3042 );
        GL11.glEnable( 3553 );
        GL11.glDisable( 2848 );
        GL11.glEnable( 2896 );
        GL11.glEnable( 2929 );
        GL11.glDisable( 32925 );
        GL11.glDisable( 32926 );
        GL11.glDepthMask( true );
        GL11.glDisable( GL13.GL_SAMPLE_ALPHA_TO_COVERAGE );
        GL11.glDisable( GL13.GL_MULTISAMPLE );
        GL11.glEnable( GL11.GL_TEXTURE_2D );
        GL11.glDisable( GL11.GL_LINE_SMOOTH );
        GL11.glEnable( GL11.GL_DEPTH_TEST );
        GL11.glEnable( GL11.GL_LIGHTING );
        GL11.glDisable( GL11.GL_BLEND );
        Minecraft.getMinecraft( ).entityRenderer.enableLightmap( 0.0D );
    }
    
    public static void lines( AltAxisAlignedBB ax ) {
        GL11.glLineWidth( 1.8F );
        GL11.glPushMatrix( );
        GL11.glBegin( GL11.GL_LINES );
        GL11.glVertex3d( ax.minX, ax.maxY, ax.minZ );
        GL11.glVertex3d( ax.minX, ax.minY, ax.maxZ );
        GL11.glEnd( );
        GL11.glBegin( GL11.GL_LINES );
        GL11.glVertex3d( ax.maxX, ax.maxY, ax.minZ );
        GL11.glVertex3d( ax.maxX, ax.minY, ax.maxZ );
        GL11.glEnd( );
        GL11.glBegin( GL11.GL_LINES );
        GL11.glVertex3d( ax.minX, ax.maxY, ax.minZ );
        GL11.glVertex3d( ax.maxX, ax.maxY, ax.maxZ );
        GL11.glEnd( );
        GL11.glBegin( GL11.GL_LINES );
        GL11.glVertex3d( ax.maxX, ax.minY, ax.maxZ );
        GL11.glVertex3d( ax.minX, ax.maxY, ax.maxZ );
        GL11.glEnd( );
        GL11.glBegin( GL11.GL_LINES );
        GL11.glVertex3d( ax.maxX, ax.maxY, ax.minZ );
        GL11.glVertex3d( ax.minX, ax.minY, ax.minZ );
        GL11.glEnd( );
        GL11.glBegin( GL11.GL_LINES );
        GL11.glVertex3d( ax.maxX, ax.minY, ax.maxZ );
        GL11.glVertex3d( ax.minX, ax.minY, ax.minZ );
        GL11.glEnd( );
        GL11.glPopMatrix( );
    }

    public static void drawOutlinedBoundingBox(AltAxisAlignedBB altAxisAlignedBB)
    {
        Tessellator var2 = Tessellator.instance;
        var2.startDrawing(3);
        var2.addVertex(altAxisAlignedBB.minX, altAxisAlignedBB.minY, altAxisAlignedBB.minZ);
        var2.addVertex(altAxisAlignedBB.maxX, altAxisAlignedBB.minY, altAxisAlignedBB.minZ);
        var2.addVertex(altAxisAlignedBB.maxX, altAxisAlignedBB.minY, altAxisAlignedBB.maxZ);
        var2.addVertex(altAxisAlignedBB.minX, altAxisAlignedBB.minY, altAxisAlignedBB.maxZ);
        var2.addVertex(altAxisAlignedBB.minX, altAxisAlignedBB.minY, altAxisAlignedBB.minZ);
        var2.draw();
        var2.startDrawing(3);
        var2.addVertex(altAxisAlignedBB.minX, altAxisAlignedBB.maxY, altAxisAlignedBB.minZ);
        var2.addVertex(altAxisAlignedBB.maxX, altAxisAlignedBB.maxY, altAxisAlignedBB.minZ);
        var2.addVertex(altAxisAlignedBB.maxX, altAxisAlignedBB.maxY, altAxisAlignedBB.maxZ);
        var2.addVertex(altAxisAlignedBB.minX, altAxisAlignedBB.maxY, altAxisAlignedBB.maxZ);
        var2.addVertex(altAxisAlignedBB.minX, altAxisAlignedBB.maxY, altAxisAlignedBB.minZ);
        var2.draw();
        var2.startDrawing(1);
        var2.addVertex(altAxisAlignedBB.minX, altAxisAlignedBB.minY, altAxisAlignedBB.minZ);
        var2.addVertex(altAxisAlignedBB.minX, altAxisAlignedBB.maxY, altAxisAlignedBB.minZ);
        var2.addVertex(altAxisAlignedBB.maxX, altAxisAlignedBB.minY, altAxisAlignedBB.minZ);
        var2.addVertex(altAxisAlignedBB.maxX, altAxisAlignedBB.maxY, altAxisAlignedBB.minZ);
        var2.addVertex(altAxisAlignedBB.maxX, altAxisAlignedBB.minY, altAxisAlignedBB.maxZ);
        var2.addVertex(altAxisAlignedBB.maxX, altAxisAlignedBB.maxY, altAxisAlignedBB.maxZ);
        var2.addVertex(altAxisAlignedBB.minX, altAxisAlignedBB.minY, altAxisAlignedBB.maxZ);
        var2.addVertex(altAxisAlignedBB.minX, altAxisAlignedBB.maxY, altAxisAlignedBB.maxZ);
        var2.draw();
    }


    public static void drawCrossedOutlinedBoundingBox( AltAxisAlignedBB var0 ) {
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawing( 3 );
        tessellator.addVertex( var0.minX, var0.minY, var0.minZ );
        tessellator.addVertex( var0.maxX, var0.minY, var0.minZ );
        tessellator.addVertex( var0.maxX, var0.minY, var0.maxZ );
        tessellator.addVertex( var0.minX, var0.minY, var0.maxZ );
        tessellator.addVertex( var0.minX, var0.minY, var0.minZ );
        tessellator.draw( );
        tessellator.startDrawing( 3 );
        tessellator.addVertex( var0.minX, var0.maxY, var0.minZ );
        tessellator.addVertex( var0.maxX, var0.maxY, var0.minZ );
        tessellator.addVertex( var0.maxX, var0.maxY, var0.maxZ );
        tessellator.addVertex( var0.minX, var0.maxY, var0.maxZ );
        tessellator.addVertex( var0.minX, var0.maxY, var0.minZ );
        tessellator.draw( );
        tessellator.startDrawing( 1 );
        tessellator.addVertex( var0.minX, var0.minY, var0.minZ );
        tessellator.addVertex( var0.minX, var0.maxY, var0.minZ );
        tessellator.addVertex( var0.maxX, var0.minY, var0.minZ );
        tessellator.addVertex( var0.maxX, var0.maxY, var0.minZ );
        tessellator.addVertex( var0.maxX, var0.minY, var0.maxZ );
        tessellator.addVertex( var0.maxX, var0.maxY, var0.maxZ );
        tessellator.addVertex( var0.minX, var0.minY, var0.maxZ );
        tessellator.addVertex( var0.minX, var0.maxY, var0.maxZ );
        tessellator.addVertex( var0.minX, var0.minY, var0.minZ );
        tessellator.addVertex( var0.minX, var0.maxY, var0.maxZ );
        tessellator.addVertex( var0.maxX, var0.minY, var0.minZ );
        tessellator.addVertex( var0.maxX, var0.maxY, var0.maxZ );
        tessellator.draw( );
    }
    
    
    
    public static void drawTag( String s, double d, double d1, double d2 ) {
        Minecraft mc = FMLClientHandler.instance().getClient();
        float f = 5;
        
        mc.thePlayer.getDistanceSq( d, d1, d2 );
        
        mc.entityRenderer.disableLightmap( 0D );
        d += 0.5D;
        d2 += 0.5D;
        FontRenderer fontrenderer = mc.fontRenderer;
        int color = 0xFFFFFFFF;
        
        float scale = f / 100;
        RenderManager renderManager1 = RenderManager.instance;
        GL11.glPushMatrix( );
        GL11.glTranslatef( ( float ) d, ( float ) d1 + 1.5F, ( float ) d2 - 0.5F );
        GL11.glNormal3f( 0.0F, 1.0F, 0.0F );
        GL11.glRotatef( -renderManager1.playerViewY, 0.0F, 1.0F, 0.0F );
        GL11.glRotatef( renderManager1.playerViewX, 1.0F, 0.0F, 0.0F );
        
        GL11.glScalef( -scale, -scale, scale );
        
        GL11.glDisable( GL11.GL_LIGHTING );
        GL11.glDisable( GL11.GL_DEPTH_TEST );
        GL11.glEnable( GL11.GL_BLEND );
        GL11.glDisable( GL11.GL_FOG );  //lalalal
        GL11.glBlendFunc( 770, 771 );
        byte byte0 = 0;
        fontrenderer.drawStringWithShadow( s, -fontrenderer.getStringWidth( s ) / 2, byte0, color );
        fontrenderer.drawStringWithShadow( s, -fontrenderer.getStringWidth( s ) / 2, byte0, color );
        GL11.glDisable( GL11.GL_BLEND );
        GL11.glEnable( GL11.GL_FOG );
        GL11.glEnable( GL11.GL_DEPTH_TEST );
        GL11.glEnable( GL11.GL_LIGHTING );
        GL11.glColor4f( 1.0F, 1.0F, 1.0F, 1.0F );
        GL11.glPopMatrix( );
        mc.entityRenderer.enableLightmap( 0D );
    }
}
