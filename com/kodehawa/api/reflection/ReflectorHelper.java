package com.kodehawa.api.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import com.kodehawa.CheatingEssentials;

public class ReflectorHelper {

    /**
     * Help in reflection methods and fields when used.
     */

    public static Object getPrivateValue(Class class1, Object obj, String s) throws IllegalArgumentException, SecurityException, NoSuchFieldException
    {
        try
        {
            Field field = class1.getDeclaredField(s);
            field.setAccessible(true);
            return field.get(obj);
        }
        catch (Exception e){}

        return null;
    }

    public static Object getPrivateMethod(Class class1, Object obj, String s) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, SecurityException
    {
        try
        {
            Method[] methods = class1.getDeclaredMethods();
            for (int i = 0; i < methods.length; i++){
                if (methods[i].getName().equals(s)){
                    getPrivateMethod(class1, obj, i);
                }
        }
        }
        catch (Exception e){}

        return null;
    }

    public static Object getPrivateMethod(Class class1, Object o, int num) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, SecurityException {
        try{
            Method m = class1.getDeclaredMethods()[num];
            CheatingEssentials.CELogAgent( "Method id / integer: " + class1.getDeclaredMethods()[num] );
            m.setAccessible(true);
            return m.invoke(o);
        }
        catch (Exception e){}
        return null;
    }

    public static void setFinalStatic(Field field, Object newValue) throws Exception {
        field.setAccessible(true);

        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

        field.set(null, newValue);
    }

    public static Field findFieldOfTypeInClass(final Class source, final Class type) {
        for (final Field e : source.getDeclaredFields()) {
            if (e.getType().equals(type)) {
                return e;
            }
    }
        return null;
    }


    public static Method findMethodOfTypeInClass(final Class source, final Class type){
        for(Method m : source.getDeclaredMethods()){
            if(m.getTypeParameters().equals(type)){
                return m;
            }
        }
        return null;
    }

}
