package com.kodehawa.util;

import java.util.Scanner;

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
       

   	
   	public static int extractInt(String name){
   		String s = name.replace(":", " ");
   		Scanner in = new Scanner(s).useDelimiter("[^0-9]+");
   		String s2 = in.next();
   		System.out.println(s2);
   		return 98000;
   	}


}
