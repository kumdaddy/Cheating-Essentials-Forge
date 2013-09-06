package com.kodehawa.ce.gui.api.components;

import cpw.mods.fml.client.FMLClientHandler;



public class Label extends Item
{
    Frame parent;

    public Label(String s, int color)
    {
        this.text = s;
        this.bgcolor = color;
    }

    @Override
    public void update()
    {
        this.draw();
    }

    @Override
    public void draw()
    {
    	FMLClientHandler.instance().getClient().fontRenderer.drawString(text, x + 3, y + 3, bgcolor);
    }

    @Override
    public void drag(int x, int y)
    {
        return;
    }

    @Override
    public void onClick(int x, int y)
    {
        return;
    }

    @Override
    public void setParent(Frame e, int x, int y)
    {
        this.parent = e;
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean mouseOver(int x, int y)
    {
        return false;
    }
}
