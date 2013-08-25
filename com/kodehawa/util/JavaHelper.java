package com.kodehawa.util;

public class JavaHelper {

   public static boolean convertIntToBoolean( int i ){
       if(i == 1){
         return true;
       }
           return false;
   }

       public static boolean searchClass( final String className ){
           try{
               Class.forName(className);
               return true;
           }
           catch(ClassNotFoundException e){
               return false;
           }
       }


}
