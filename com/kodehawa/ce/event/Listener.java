package com.kodehawa.ce.event;

import java.util.EventListener;

public interface Listener extends EventListener
{
    public void onEvent(Event event);
}
