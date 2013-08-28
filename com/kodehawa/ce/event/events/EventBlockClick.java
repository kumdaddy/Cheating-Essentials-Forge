package com.kodehawa.ce.event.events;


import com.kodehawa.ce.event.Event;
import com.kodehawa.ce.util.Vector3D;

/**
 * Used for sending AutoTool 'n' stuff
 *
 * @author godshawk
 *
 */
public class EventBlockClick extends Event
{
    private final Vector3D coords;

    public EventBlockClick(Object source, int x, int y, int z)
    {
        super(source);
        coords = new Vector3D(x, y, z);
    }

    public Vector3D getCoords()
    {
        return this.coords;
    }
}
