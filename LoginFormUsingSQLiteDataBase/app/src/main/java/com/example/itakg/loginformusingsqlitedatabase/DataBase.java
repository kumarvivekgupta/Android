package com.example.itakg.loginformusingsqlitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by itakg on 7/18/2017.
 */

public class DataBase {
    DataBaseHelper dataBaseHelper;
    public DataBase(Context context)
    {
       dataBaseHelper=new DataBaseHelper(context);
    }
    public  long insert_data(String name,String password)
    {
        SQLiteDatabase sqLiteDatabase=dataBaseHelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(DataBaseHelper.name,name);
        contentValues.put(DataBaseHelper.pas,password);
        long id=  sqLiteDatabase.insert(DataBaseHelper.TableName,null,contentValues);
        return id;
    }



    public  String getAllData()
    {
        SQLiteDatabase db=dataBaseHelper.getWritableDatabase();
        //We are going to fetch all columns so we will create an array of all column name i.e. SNO,Name,Password.
        String column[]={DataBaseHelper.Sno,DataBaseHelper.name,DataBaseHelper.pas};
        Cursor cursor=db.query(DataBaseHelper.TableName,column,null,null,null,null,null);
        StringBuffer stringBuffer=new StringBuffer();
        while(cursor.moveToNext())
        {
            int cid=cursor.getInt(0);
            String name=cursor.getString(1);
            String pass=cursor.getString(2);
            stringBuffer.append(cid+" "+name+" "+pass+"\n");
        }
        return stringBuffer.toString();
    }



    public String getIndividualData(int id)
    {
        //select name,password from DataBaseTable where name="usn"
        SQLiteDatabase db=dataBaseHelper.getWritableDatabase();
        String column[]={DataBaseHelper.Sno,DataBaseHelper.name,DataBaseHelper.pas};
        Cursor cursor=db.query(DataBaseHelper.TableName,column,DataBaseHelper.Sno+" = '"+id+"'",null,null,null,null);
        StringBuffer stringBuffer=new StringBuffer();
        while(cursor.moveToNext())
        {
            int i1=cursor.getColumnIndex(DataBaseHelper.name);
            int i2=cursor.getColumnIndex(DataBaseHelper.pas);
            String name=cursor.getString(i1);
            String pass=cursor.getString(i2);
            stringBuffer.append(name+" "+pass+"\n");
        }
        return stringBuffer.toString();

    }



    public int updateName(String oldName,String newName)
    {
        //Update DataBaseTable set Name='.....' where Name='naimish'
        SQLiteDatabase sqLiteDatabase=dataBaseHelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(DataBaseHelper.name,newName);
        String[] args={oldName};
        int count=sqLiteDatabase.update(DataBaseHelper.TableName,contentValues,DataBaseHelper.name+" =?",args);
        return count;
    }



    public int deleteRow(String name)
    {
        //DELETE * FROM DataBaseTable where Name='......'
        SQLiteDatabase sqLiteDatabase=dataBaseHelper.getWritableDatabase();
        String[] args={name};
        int count=sqLiteDatabase.delete(DataBaseHelper.TableName,DataBaseHelper.name+" =?",args);
        return count;
    }



   class DataBaseHelper  extends SQLiteOpenHelper
   {
       private  Context c;
       private  static final String DataBaseName="Login Form";
       private  static final String TableName="DataBaseTable";
       private  static final int Version=9;
       private static final String Sno="SNO";
       private  static final String name="UserName";
       private static final String pas="Password";
      private static final String Create_Table="create table DataBaseTable (SNO integer primary key autoincrement, "+"UserName text not null, Password text not null);";
       //private static final String Create_Table="CREATE TABLE "+ TableName +" ("+ Sno +" INTEGER PRIMARY KEY AUTOINCREMENT, "+ name +" VARCHAR(255), "+ pas +" VARCHAR(255));";
       private static final String  Drop_Table="DROP TABLE IF EXISTS DataBaseTable";


       public DataBaseHelper(Context context)
       {

           super(context,DataBaseName,null,Version);
           c=context;
           Log.i("Message:","Constructor was called!!");
       }
       @Override


       public void onCreate(SQLiteDatabase db) {
           Log.i("Message:","onCreate() was called!!");
           //CREATE TABLE Data Base Table (_SNO. INTEGER PRIMARY KEY AUTOINCREMENT, USER NAME VARCHAR(255));
           try {
               db.execSQL(Create_Table);
           }
           catch (SQLException e)
           {
               e.printStackTrace();
               Toast.makeText(c,"An Error is Occured!!"+e,Toast.LENGTH_LONG).show();
           }

       }


       @Override
       public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
           Log.i("Message:","onUpgrade() was called!!");
           try {
               db.execSQL(Drop_Table);
               onCreate(db);
           }
           catch (SQLException e)
           {
               e.printStackTrace();
               Toast.makeText(c,"An Error Occured!!"+e,Toast.LENGTH_LONG).show();
           }


       }
   }
}
