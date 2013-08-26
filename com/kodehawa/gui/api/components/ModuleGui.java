package com.kodehawa.gui.api.components;

import java.util.ArrayList;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.Direction;
import net.minecraft.util.MathHelper;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.kodehawa.CheatingEssentials;
import com.kodehawa.gui.api.render.ModGuiUtils;
import com.kodehawa.module.core.CheatingEssentialsModule;
import com.kodehawa.module.enums.EnumGuiCategory;
import com.kodehawa.module.handlers.ModuleManager;

public class ModuleGui extends GuiScreen
{
    /**
     * @author godshawk | Luna
     */

    public ArrayList<Frame> frames;

    public ModuleGui()
    {
        frames = new ArrayList<Frame>();
        initFrames();

        for (Frame e : frames)
        {
            e.minimized = true;
        }
    }

    @Override
    public boolean doesGuiPauseGame()
    {
        return false;
    }

    @Override
    public void initGui()
    {
        Keyboard.enableRepeatEvents(true);
    }

    @Override
    public void onGuiClosed()
    {
        Keyboard.enableRepeatEvents(true);
    }

    @Override
    protected void keyTyped(char c, int i)
    {
        if (i == 1)
        {
            mc.displayGuiScreen(null);
            return;
        }

        for (Frame e : this.frames)
        {
            for (Item t : e.children)
            {

            }
        }
    }


    @Override
    public void drawScreen(int i, int j, float f)
    {
        for (Frame e : frames)
        {
            e.update();

            if (e.toBeAdded.size() > 0)
            {
                for (Item q : e.toBeAdded)
                {
                    e.addChild(q);
                }

                e.toBeAdded.clear();
            }

            if (e.toBeRemoved.size() > 0)
            {
                for (Item q : e.toBeRemoved)
                {
                    e.removeChild(q);
                }

                e.toBeRemoved.clear();
            }
        }

        this.mouseDragged(i, j);


    }

    @Override
    protected void mouseClicked(int i, int j, int k)
    {
        for (Frame e : frames)
        {
            e.onClick(i, j);
        }
    }

    public void mouseDragged(int i, int j)
    {
        for (Frame e : frames)
        {
            int q = (e.x - i) / 2;
            int r = (e.y - j) / 2;
            q += i - (e.width / 4);
            r += j - (e.oldHeight / 4);
            e.drag(q, r);
        }
    }

    @Override
    protected void mouseMovedOrUp(int par1, int par2, int par3)
    {
        for (Frame e : frames)
        {
            e.mouseUp();
        }
    }


    public void makeWorldFrame()
    {
        Frame wFrame = new Frame(CheatingEssentials.modinstance, 10, 10, 120, 20, /*0xFF000055*/0x96777777, 0xaa000000, "World");

        for (CheatingEssentialsModule m : ModuleManager.getInstance().modules)
        {
            if(m.getType() == EnumGuiCategory.WORLD){
                Button b = new Button(m.name, 0x00007700, 0xffffff, m);
            b.setWidth(wFrame.width - 6);
            b.setHeight(wFrame.oldHeight - 8);
            wFrame.addChild(b);
            }
        }

        wFrame.setPinnable(true);
        addFrame(wFrame);
    }

    public void makeRenderFrame()
    {
        Frame rFrame = new Frame(CheatingEssentials.modinstance, 130, 50, 120, 20, 0x96777777, 0xaa000000, "Render");

        for (CheatingEssentialsModule m : ModuleManager.getInstance().modules)
        {
            if(m.getType() == EnumGuiCategory.RENDER){
                Button b = new Button(m.name, 0x00007700, 0xffffff, m);
                b.setWidth(rFrame.width - 6);
                b.setHeight(rFrame.oldHeight - 8);
                rFrame.addChild(b);
            }
        }

        rFrame.setPinnable(true);
        addFrame(rFrame);
    }
    
    
    public void makeF3UtilsFrame(){
    	Frame f3Frame = new Frame(CheatingEssentials.getCheatingEssentials(), 10, 50, 120, 20, 0x96777777, 0xaa000000, "Utils");
    	
    	for (CheatingEssentialsModule m : ModuleManager.getInstance().modules)
        {
            if(m.getType() == EnumGuiCategory.UTILS){
                Button b = new Button(m.name, 0x00007700, 0xffffff, m);
            b.setWidth(f3Frame.width - 6);
            b.setHeight(f3Frame.oldHeight - 8);
            f3Frame.addChild(b);
            }
        }

        f3Frame.setPinnable(true);
        addFrame(f3Frame);
    	
    }

    public void makePlayerFrame()
    {
        Frame pFrame = new Frame(CheatingEssentials.modinstance, 130, 10, 120, 20, 0x96777777, 0xaa000000, "Player");

        for (CheatingEssentialsModule m : ModuleManager.getInstance().modules)
        {
            if(m.getType() == EnumGuiCategory.PLAYER){
            Button b = new Button(m.name, 0x00007700, 0xffffff, m);
            b.setWidth(pFrame.width - 6);
            b.setHeight(pFrame.oldHeight - 8);
            pFrame.addChild(b);
        }
        }

        pFrame.setPinnable(true);
        addFrame(pFrame);
    }

    public void makeKeybindsFrame()
    {
        Frame kFrame = new Frame(CheatingEssentials.modinstance, 10, 30, 120, 20, 0x96777777, 0xaa000000, "Keybinds")
        {
            @Override
            public void update()
            {
                this.draw();
                this.children.clear();

                for (CheatingEssentialsModule m : ModuleManager.getInstance().modules)
                {
                    Label l = new Label(m.name + " - " + Keyboard.getKeyName(m.keybind), 0xffffff);
                    l.setParent(this, (x) + 3, (y) - 21);
                    addChild(l);
                }
                    Label l1 = new Label("New Radar" + " - " + Keyboard.getKeyName(Keyboard.KEY_I), 0xffffff);
                    l1.setParent(this, (x) + 4, y - 22);
                    addChild(l1);

                    Label l2 = new Label("Enabled Modules" + " - "  + Keyboard.getKeyName(Keyboard.KEY_Z), 0xffffff);
                    l2.setParent(this, (x) + 5, y - 23);
                    addChild(l2);
            }
            @Override
            public void draw()
            {
                // TODO Auto-generated method stub
                if (bgcolor2 > -1)
                {
                    ModGuiUtils.drawRect(x, y, x + width, y + oldHeight, bgcolor);
                    ModGuiUtils.drawRect(x, y, x + width, y + oldHeight, (int)(bgcolor * 1.1));
                }
                else
                {
                    ModGuiUtils.drawGradientRect(x, y, x + width, y + oldHeight, bgcolor, bgcolor2);
                    ModGuiUtils.drawRect(x, y + oldHeight, x + width, y + height, bgcolor2);
                }

                /**
                 * Minimize button
                 */
                ModGuiUtils.drawFilledCircle((x + width) - 8, y + 7, 2.5, 0xFF00CC00);

                if (minimized)
                {
                    ModGuiUtils.drawFilledCircle((x + width) - 8, y + 7, 2.5, 0xFF007700);
                }

                if (pinnable)
                {
                    ModGuiUtils.drawFilledCircle((x + width) - 16, y + 7, 2.5, 0xff72a9dc);

                    if (pinned)
                    {
                        ModGuiUtils.drawFilledCircle((x + width) - 16, y + 7, 2.5, 0xaa000000);
                    }
                }

                ModGuiUtils.drawHorizontalLine(this.x + 2, (this.x + this.width) - 2, (this.y + this.oldHeight) - 6, 2, 0xff550055);
                CheatingEssentials.modinstance.getMinecraftInstance().fontRenderer.drawString(this.text, this.x + 3, this.y + 3, 0xff87b5ff);

                if (minimized)
                {
                    this.height = oldHeight;
                }
                else
                {
                    this.height = (int)(oldHeight + ((oldHeight * this.children.size()) / 1.4) + 5) / 2;
                }

                if (!minimized)
                {
                    GL11.glPushMatrix();
                    GL11.glScaled(0.5, 0.5, 0.5);

                    for (Item e : children)
                    {
                        e.x = ((this.x) + 3) * 2;
                        int offset = oldHeight;
                        offset /= 8;
                        offset += 4;
                        e.y = ((this.y) + (offset * (this.children.indexOf(e) + 1)) + 15) * 2;
                        e.update();
                    }

                    GL11.glScaled(1, 1, 1);
                    GL11.glPopMatrix();
                }
            }
        };
        kFrame.setPinnable(true);
        addFrame(kFrame);
    }

    public void makeRadarFrame()
    {
        final Radar r = new Radar();
        Frame rFrame = new Frame(CheatingEssentials.modinstance, 250, 30, 120, 20, 0x96777777, 0xaa000000, "Radar")
        {
            @Override
            public void update()
            {
                this.draw();

                if (!this.minimized)
                {
                    r.drawRadar(this.x + 60, this.y + 70);
                    this.height = 125;
                }
                else
                {
                    this.height = 20;
                }
            }
        };
        rFrame.setPinnable(true);
        addFrame(rFrame);
    }

    public void makeActivesFrame()
    {
        Frame aFrame = new Frame(CheatingEssentials.modinstance, 130, 30, 120, 20, 0x96777777, 0xaa000000, "Active Cheats")
        {
            @Override
            public void update()
            {
                this.draw();
                this.children.clear();

                for (String s : ModuleManager.getInstance().enabledModules)
                {
                    Label l = new Label(s, 0xffffff);
                    l.setParent(this, (x) + 3, (y) - 21);
                    addChild(l);
                }
            }
            @Override
            public void draw()
            {
                // TODO Auto-generated method stub
                if (bgcolor2 > -1)
                {
                    ModGuiUtils.drawRect(x, y, x + width, y + oldHeight, bgcolor);
                    ModGuiUtils.drawRect(x, y, x + width, y + oldHeight, (int)(bgcolor * 1.1));
                }
                else
                {
                    ModGuiUtils.drawGradientRect(x, y, x + width, y + oldHeight, bgcolor, bgcolor2);
                    ModGuiUtils.drawRect(x, y + oldHeight, x + width, y + height, bgcolor2);
                }

                /**
                 * Minimize button
                 */
                ModGuiUtils.drawFilledCircle((x + width) - 8, y + 7, 2.5, 0xFF00CC00);

                if (minimized)
                {
                    ModGuiUtils.drawFilledCircle((x + width) - 8, y + 7, 2.5, 0xFF007700);
                }

                if (pinnable)
                {
                    ModGuiUtils.drawFilledCircle((x + width) - 16, y + 7, 2.5, 0xff72a9dc);

                    if (pinned)
                    {
                        ModGuiUtils.drawFilledCircle((x + width) - 16, y + 7, 2.5, 0xaa000000);
                    }
                }

                ModGuiUtils.drawHorizontalLine(this.x + 2, (this.x + this.width) - 2, (this.y + this.oldHeight) - 6, 2, 0xff550055);
                CheatingEssentials.modinstance.getMinecraftInstance().fontRenderer.drawString(this.text, this.x + 3, this.y + 3, 0xff87b5ff);

                if (minimized)
                {
                    this.height = oldHeight;
                }
                else
                {
                    this.height = (oldHeight + ((oldHeight * this.children.size()) / 2));
                }

                if (!minimized)
                {
                    for (Item e : children)
                    {
                        e.x = (this.x) + 3;
                        int offset = oldHeight;
                        offset /= 4;
                        offset += 4;
                        e.y = (this.y) + (offset * (this.children.indexOf(e) + 1)) + 10;
                        e.update();
                    }
                }
            }
        };
        aFrame.setPinnable(true);
        addFrame(aFrame);
    }

    public void makeInfoFrame()
    {
        final Frame iFrame = new Frame(CheatingEssentials.modinstance, 250, 10, 120, 20, 0x96777777, 0xaa000000, "Player Info")
        {
            @Override
            public void update()
            {
                this.draw();
                String dim = "Overworld";
                String dir = "NORTH";
                int d = mc.thePlayer.dimension;

                if (d == -1)
                {
                    dim = "Nether";
                }

                if (d == 0)
                {
                    dim = "Overworld";
                }

                if (d == 1)
                {
                    dim = "The End";
                }

                int var24 = MathHelper.floor_double(((mc.thePlayer.rotationYaw * 4.0F) / 360.0F) + 0.5D) & 3;
                dir = Direction.directions [ var24 ];

                try
                {
                    children.clear();
                    //addChild(new Label("FPS: " + EntityRenderer.performanceToFps(Minecraft.getMinecraft().), 0xffffff));
                    addChild(new Label("X: " + (int) CheatingEssentials.getMinecraftInstance().thePlayer.posX, 0xffffff));
                    addChild(new Label("Y: " + (int) CheatingEssentials.getMinecraftInstance().thePlayer.posY, 0xffffff));
                    addChild(new Label("Z: " + (int) CheatingEssentials.getMinecraftInstance().thePlayer.posZ, 0xffffff));
                    addChild(new Label("Dimension: " + dim, 0xffffff));
                    addChild(new Label("Facing: " + dir, 0xffffff ));
                    addChild(new Label("Username: " + mc.thePlayer.username, 0xffffff));
                    addChild(new Label("", 0xffffff));
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            @Override
            public void draw()
            {
                // TODO Auto-generated method stub
                if (bgcolor2 > -1)
                {
                    ModGuiUtils.drawRect(x, y, x + width, y + oldHeight, bgcolor);
                    ModGuiUtils.drawRect(x, y, x + width, y + oldHeight, (int)(bgcolor * 1.1));
                }
                else
                {
                    ModGuiUtils.drawGradientRect(x, y, x + width, y + oldHeight, bgcolor, bgcolor2);
                    ModGuiUtils.drawRect(x, y + oldHeight, x + width, y + height, bgcolor2);
                }

                /**
                 * Minimize button
                 */
                ModGuiUtils.drawFilledCircle((x + width) - 8, y + 7, 2.5, 0xFF00CC00);

                if (minimized)
                {
                    ModGuiUtils.drawFilledCircle((x + width) - 8, y + 7, 2.5, 0xFF007700);
                }

                if (pinnable)
                {
                    ModGuiUtils.drawFilledCircle((x + width) - 16, y + 7, 2.5, 0xff72a9dc);

                    if (pinned)
                    {
                        ModGuiUtils.drawFilledCircle((x + width) - 16, y + 7, 2.5, 0xaa000000);
                    }
                }

                ModGuiUtils.drawHorizontalLine(this.x + 2, (this.x + this.width) - 2, (this.y + this.oldHeight) - 6, 2, 0xff550055);
                CheatingEssentials.modinstance.getMinecraftInstance().fontRenderer.drawString(this.text, this.x + 3, this.y + 3, 0xff87b5ff);
                

                if (minimized)
                {
                    this.height = oldHeight;
                }
                else
                {
                    this.height = (int)(oldHeight + ((oldHeight * this.children.size()) / 1.4) + 5) / 2;
                }

                if (!minimized)
                {
                    GL11.glPushMatrix();
                    GL11.glScaled(0.5, 0.5, 0.5);

                    for (Item e : children)
                    {
                        e.x = ((this.x) + 3) * 2;
                        int offset = oldHeight;
                        offset /= 8;
                        offset += 4;
                        e.y = ((this.y) + (offset * (this.children.indexOf(e) + 1)) + 15) * 2;
                        e.update();
                    }

                    GL11.glScaled(1, 1, 1);
                    GL11.glPopMatrix();
                }
            }
        };
        iFrame.setPinnable(true);
        addFrame(iFrame);
    }

    public void addFrame(Frame e)
    {
        frames.add(e);
    }

    public void initFrames()
    {
        makeWorldFrame();
        makePlayerFrame();
        makeRadarFrame();
        makeInfoFrame();
        makeActivesFrame( );
        makeRenderFrame();
        makeF3UtilsFrame();
        makeKeybindsFrame();
    }
}
