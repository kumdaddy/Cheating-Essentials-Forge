package com.kodehawa.ce.vanilla;

import net.minecraft.util.AABBPool;

public final class AltAABBLocalPool extends ThreadLocal
{
    protected AABBPool createNewDefaultPool()
    {
        return new AABBPool(300, 2000);
    }

    protected Object initialValue()
    {
        return this.createNewDefaultPool();
    }
}