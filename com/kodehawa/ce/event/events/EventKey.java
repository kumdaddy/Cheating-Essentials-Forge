package com.kodehawa.ce.event.events;

import com.kodehawa.ce.event.Event;

/**
 * Used for sending key presses
 *
 * @author godshawk
 *
 */
public class EventKey extends Event
{
    private int key;

    public EventKey(Object source, int key)
    {
        super(source);
        this.key = key;
    }

    public int getKey()
    {
        return this.key;
    }
}
