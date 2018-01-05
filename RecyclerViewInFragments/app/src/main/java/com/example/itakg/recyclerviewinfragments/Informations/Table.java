package com.example.itakg.recyclerviewinfragments.Informations;

/**
 * Created by itakg on 11/8/2017.
 */

public class Table {
    private static int[] numbers=new int[10];
    private static String[] s=new String[10];
    public static String[] getTable(int n)
    {
       for(int i=0;i<10;i++)
       {
           numbers[i]=n*(i+1);
       }
        for(int i=0;i<10;i++)
        {
            s[i]=String.valueOf(numbers[i]);
        }
        return s;
    }
}
