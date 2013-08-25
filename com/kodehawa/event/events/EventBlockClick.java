package com.kodehawa.event.events;


import com.kodehawa.event.Event;
import com.kodehawa.util.Vector3D;

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
