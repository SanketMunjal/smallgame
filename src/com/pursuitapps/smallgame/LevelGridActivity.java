package com.pursuitapps.smallgame;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class LevelGridActivity extends Activity{

	GridView gridView;
	 
	static final String[] numbers = new String[] { 
			"One", "Two", "Three", "Four", "Five",
			"Six", "Seven", "Eight", "Nine", "Ten",
			"Eleven", "Twelve", "13teen", "14teen", "15teen",
			
			};
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridlevel);
        
        gridView = (GridView) findViewById(R.id.gridView1);
        
        final Intent myintent=new Intent(this,MainActivity.class);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, numbers);
 
		gridView.setAdapter(adapter);
 
		gridView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
				int position, long id) {
				if((((TextView)v).getText())== "One")
				{
					myintent.putExtra("level", 1);
				}
				else if((((TextView)v).getText())== "Two")
				{
					myintent.putExtra("level", 2);
				}
				else if((((TextView)v).getText())== "Three")
				{
					myintent.putExtra("level", 3);
				}
				else if((((TextView)v).getText())== "Four")
				{
					myintent.putExtra("level", 4);
				}
				else if((((TextView)v).getText())== "Five")
				{
					myintent.putExtra("level", 5);
				}
				else if((((TextView)v).getText())== "Six")
				{
					myintent.putExtra("level", 6);
				}
				else if((((TextView)v).getText())== "Seven")
				{
					myintent.putExtra("level", 7);
				}
				else if((((TextView)v).getText())== "Eight")
				{
					myintent.putExtra("level", 8);
				}
				else if((((TextView)v).getText())== "Nine")
				{
					myintent.putExtra("level", 9);
				}
				else if((((TextView)v).getText())== "Ten")
				{
					myintent.putExtra("level", 10);
				}
				else if((((TextView)v).getText())== "Eleven")
				{
					myintent.putExtra("level", 11);
				}
				else if((((TextView)v).getText())== "Twelve")
				{
					myintent.putExtra("level", 12);
				}
				else if((((TextView)v).getText())== "13teen")
				{
					myintent.putExtra("level", 13);
				}
				else if((((TextView)v).getText())== "14teen")
				{
					myintent.putExtra("level", 14);
				}
				else if((((TextView)v).getText())== "15teen")
				{
					myintent.putExtra("level", 15);
				}
				else if((((TextView)v).getText())== "6teen")
				{
					myintent.putExtra("level", 16);
				}
				else if((((TextView)v).getText())== "7teen")
				{
					myintent.putExtra("level", 17);
				}
				else if((((TextView)v).getText())== "8teen")
				{
					myintent.putExtra("level", 18);
				}				
				else 
				{
					myintent.putExtra("level", 1);
				}
				
				
				
					startActivity(myintent);	
					Toast.makeText(getApplicationContext(),((TextView) v).getText(), Toast.LENGTH_SHORT).show();
				
			}
		});
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
