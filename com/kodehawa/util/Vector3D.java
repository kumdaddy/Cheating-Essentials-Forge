package com.kodehawa.util;

public class Vector3D {
    private double x, y, z;
    
    public Vector3D( double x, double y, double z ) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public double getX( ) {
        return this.x;
    }
    
    public double getY( ) {
        return this.y;
    }
    
    public double getZ( ) {
        return this.z;
    }
    
    public void setX( int q ) {
        this.x = q;
    }
    
    public void setY( int q ) {
        this.y = q;
    }
    
    public void setZ( int q ) {
        this.z = q;
    }
    
    public boolean compare( Vector3D v ) {
        return v.getX( ) == x && v.getY( ) == y && v.getZ( ) == z;
    }
}
