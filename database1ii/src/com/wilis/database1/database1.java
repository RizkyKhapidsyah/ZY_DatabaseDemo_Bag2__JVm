package com.wilis.database1;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

public class database1 extends Activity {
    /** Called when the activity is first created. */
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        DBAdapter db = new DBAdapter(this);

        //---update title---
        db.open();
        if (db.updateTitle(1, 
        		"1234512345", 
        		"Android coding references",
        		"Jakarta Press"))
            Toast.makeText(this, "Update successful.", 
                Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this, "Update failed.", 
                Toast.LENGTH_LONG).show();
        //-------------------
        
        //---retrieve the same title to verify---
        Cursor c = db.getTitle(1);
        if (c.moveToFirst())        
            DisplayTitle(c);
        else
            Toast.makeText(this, "No title found", 
            		Toast.LENGTH_LONG).show();        
        //-------------------        
        db.close();
    }

         	
    public void DisplayTitle(Cursor c)
    {
        Toast.makeText(this, 
                "id: " + c.getString(0) + "\n" +
                "ISBN: " + c.getString(1) + "\n" +
                "TITLE: " + c.getString(2) + "\n" +
                "PUBLISHER:  " + c.getString(3),
                Toast.LENGTH_LONG).show();        
    } 
}
