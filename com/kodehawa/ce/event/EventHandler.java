package com.kodehawa.ce.event;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.kodehawa.ce.event.events.EventAlert;
import com.kodehawa.ce.event.events.EventBlockClick;
import com.kodehawa.ce.event.events.EventBlockRender;
import com.kodehawa.ce.event.events.EventKey;
import com.kodehawa.ce.event.events.EventMouseClick;
import com.kodehawa.ce.event.events.EventMouseDrag;
import com.kodehawa.ce.event.events.EventRender3D;
import com.kodehawa.ce.event.events.EventSwing;

public class EventHandler
{
    private HashMap < Class < ? extends Event > , CopyOnWriteArrayList< Listener >> eventMap;
    private static volatile EventHandler instance;

    
    public EventHandler()
    {
        eventMap = new HashMap < Class < ? extends Event > , CopyOnWriteArrayList< Listener >> ();
        eventMap.put(EventAlert.class, new CopyOnWriteArrayList< Listener >());
        eventMap.put(EventKey.class, new CopyOnWriteArrayList< Listener >());
        eventMap.put(EventRender3D.class, new CopyOnWriteArrayList< Listener >());
        eventMap.put(EventBlockClick.class, new CopyOnWriteArrayList< Listener >());
        eventMap.put(EventBlockRender.class, new CopyOnWriteArrayList< Listener >());
        eventMap.put(EventMouseClick.class, new CopyOnWriteArrayList< Listener >());
        eventMap.put(EventSwing.class, new CopyOnWriteArrayList< Listener >());
        eventMap.put(EventMouseDrag.class, new CopyOnWriteArrayList< Listener >());
    }

    public void registerListener(Class < ? extends Event > c, Listener m)
    {
        if (eventMap.containsKey(c))
        {
            List l = eventMap.get(c);

            if (!l.contains(m))
            {
                l.add(m);
            }
        }
    }

    public void unRegisterListener(Class < ? extends Event > c, Listener m)
    {
        if (eventMap.containsKey(c))
        {
            List l = eventMap.get(c);

            if (l.contains(m))
            {
                l.remove(m);
            }
        }
    }

    public Event call(Event e)
    {
        if (eventMap.containsKey(e.getClass()))
        {
            List< Listener > l = eventMap.get(e.getClass());

            for (Listener m : l)
            {
                try
                {
                    m.onEvent(e);
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        }
        else
        {
            System.out.println("Event not supported: " + e.toString() + ". Add event into eventMap.");
        }

        return e;
    }
    
    public static EventHandler getInstance() {
        if (instance == null) {
                instance = new EventHandler();
        }
        return instance;
}
}
