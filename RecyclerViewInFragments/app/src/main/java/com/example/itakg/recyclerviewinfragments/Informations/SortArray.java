package com.example.itakg.recyclerviewinfragments.Informations;

/**
 * Created by itakg on 11/8/2017.
 */

public class SortArray {
    private static int[] numbers=new int[30];
    private static String[] s=new String[30];
    public static String[] getSortedArray(String array[])
    {
        int i=0,j=0,temp=0;
        for(i=0;i<30;i++)
            numbers[i]=Integer.parseInt(array[i]);
        for(i=0;i<30;i++)
        {
            for(j=0;j<30-1-i;j++)
            {
                if(numbers[j]>numbers[j+1])
                {
                    temp=numbers[j];
                    numbers[j]=numbers[j+1];
                    numbers[j+1]=temp;
                }
            }
        }
        for(i=0;i<30;i++)
        {
          s[i]=String.valueOf(numbers[i]);
        }
        return s;
    }
}
