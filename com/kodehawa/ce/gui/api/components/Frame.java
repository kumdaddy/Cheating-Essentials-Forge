
package com.kodehawa.ce.gui.api.components;

import java.util.ArrayList;

import com.kodehawa.ce.forge.loader.CE_ForgeLoader;
import com.kodehawa.ce.gui.api.render.ModGuiUtils;

import cpw.mods.fml.client.FMLClientHandler;

public class Frame extends Item
{
    /**
     * @author godshawk
     */

    public ArrayList<Item> toBeAdded = new ArrayList<Item>();
    public ArrayList<Item> toBeRemoved = new ArrayList<Item>();
    public ArrayList<Item> children = new ArrayList<Item>();
    boolean minimized = false;
    public boolean pinnable = false;
    public boolean pinned = false;

    /**
     * Should we clear labels? Only used for the console
     */
    public boolean shouldClear = false;
    int oldHeight = 0;

    public Frame(CE_ForgeLoader cb, int x, int y, int w, int h, String s)
    {
        this(cb, x, y, w, h, 0xff666666, s);
    }

    public Frame(CE_ForgeLoader cb, int x, int y, int w, int h, int color, String s)
    {
        this(cb, x, y, w, h, color, -1, s);
    }

    public Frame(CE_ForgeLoader cb, int x, int y, int w, int h, int color, int color2, String s)
    {
        this.c = cb;
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        this.oldHeight = h;
        this.bgcolor = 0xff000055;
        this.bgcolor2 = 0xaa000000;
        this.text = s;
        this.setDraggable(true);
    }

    @Override
    public void update()
    {
        this.draw();
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
        FMLClientHandler.instance().getClient().fontRenderer.drawString(this.text, this.x + 3, this.y + 3, 0xff87b5ff);

        if (minimized)
        {
            this.height = oldHeight;
        }
        else
        {
            this.height = (int)(oldHeight + ((oldHeight * this.children.size()) / 1.4) + 5);
        }

        if (!minimized)
        {
            for (Item e : children)
            {
                e.x = (this.x) + 3;
                int offset = oldHeight;
                offset /= 2;
                offset += 4;
                e.y = (this.y) + (offset * (this.children.indexOf(e) + 1)) + 10;
                e.update();
            }
        }
    }

    @Override
    public void drag(int x, int y)
    {
        // TODO Auto-generated method stub
        if (!this.isDraggable() || !this.isDragging())
        {
            return;
        }

        this.x = x;
        this.y = y;
    }

    @Override
    public void onClick(int x, int y)
    {
        // TODO Auto-generated method stub
        if (this.clickedInside(x, y))
        {
            if (x >= ((this.x + this.width) - 8 - 2.5))
            {
                if (x <= (((this.x + this.width) - 8) + 2.5))
                {
                    if (y >= ((this.y + 7) - 2.5))
                    {
                        if (y <= (this.y + 7 + 2.5))
                        {
                            this.minimized = !this.minimized;
                        }
                    }
                }
            }
            else if (x >= ((this.x + this.width) - 16 - 2.5))
            {
                if (x <= (((this.x + this.width) - 16) + 2.5))
                {
                    if (y >= ((this.y + 7) - 2.5))
                    {
                        if (y <= (this.y + 7 + 2.5))
                        {
                            this.pinned = !this.pinned;
                        }
                    }
                }
            }
            else
            {
                this.setDragging(true);
            }
        }

        if (!this.minimized)
        {
            for (Item e : children)
            {
                e.onClick(x, y);
            }
        }
    }

    public void mouseUp()
    {
        this.setDragging(false);
    }

    public void addChild(Item e)
    {
        children.add(e);
        e.setParent(this, 0, 0);
    }

    public void removeChild(Item e)
    {
        children.remove(e);
    }

    public void addLater(Item e)
    {
        toBeAdded.add(e);
    }

    public void removeLater(Item e)
    {
        toBeRemoved.add(e);
    }

    @Override
    public boolean clickedInside(int x, int y)
    {
        if (x > this.x)
        {
            if (y > this.y)
            {
                if (x < (this.x + this.width))
                {
                    if (y < (this.y + this.oldHeight))
                    {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    @Override
    public boolean mouseOver(int x, int y)
    {
        return false;
    }

    public void setPinnable(boolean state)
    {
        this.pinnable = state;
    }
}
