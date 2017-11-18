package com.example.itakg.tictactoegame;

/**
 * Created by itakg on 7/14/2017.
 */

public class Logic {

    public static boolean checkIntersection1(int i)
    {
        int mygame[]=MainActivity.myGameState;
        if(mygame[0]==i&&mygame[3]==i&&mygame[6]==i)
        {

            return true;}
       else if(mygame[1]==i&&mygame[4]==i&&mygame[7]==i)
        {
            return true;}
        else if(mygame[2]==i&&mygame[5]==i&&mygame[8]==i)
        {
            return true;}
        else if(mygame[0]==i&&mygame[1]==i&&mygame[2]==i)
        {
            return true;}
        else if(mygame[3]==i&&mygame[4]==i&&mygame[5]==i)
        {
            return true;}
        else if(mygame[6]==i&&mygame[7]==i&&mygame[8]==i)
        {
            return true;}
        else if(mygame[0]==i&&mygame[4]==i&&mygame[8]==i)
        {
        return true;}
        else if(mygame[2]==i&&mygame[4]==i&&mygame[6]==i)
        {
            return true;}
        else
            return  false;
    }
}
