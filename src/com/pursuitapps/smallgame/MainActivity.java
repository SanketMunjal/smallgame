package com.pursuitapps.smallgame;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;

public class MainActivity extends Activity {

	CommonData cdata;
	MyView myview;
	SensorManager sm;
	public final String TAG ="SMALL GAME - MAIN ACTIVITY";
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int levelNo=1;
        setContentView(R.layout.activity_main);
        cdata = new CommonData();
       
        Intent intent=getIntent();
        levelNo=intent.getIntExtra("level", levelNo);
        Log.i(TAG,"Level no. is "+ levelNo);
        cdata.currentLevel=levelNo-1;
        
        myview = (MyView) findViewById(R.id.myView);
        
        sm=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
    	int sensorType=Sensor.TYPE_ACCELEROMETER;
    	
    	final SensorEventListener mySensorEventListener = new SensorEventListener(){
        	
        	public void onSensorChanged(SensorEvent sensorEvent){
        		if(sensorEvent.sensor.getType()==Sensor.TYPE_ACCELEROMETER){
        			//Log.d(TAG,"X VALUE IS "+ sensorEvent.values[0]+"y value is "+ sensorEvent.values[1]+ "z value is "+ sensorEvent.values[2]);
        			cdata.xAcc=sensorEvent.values[0];        			
        			        			
        		}
        	}

			@Override
			public void onAccuracyChanged(Sensor arg0, int arg1) {
				// TODO Auto-generated method stub
				
			}
    	 };
         
     	
     	sm.registerListener(mySensorEventListener,sm.getDefaultSensor(sensorType),SensorManager.SENSOR_DELAY_NORMAL);
         
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    @Override
	public boolean onTouchEvent(MotionEvent event)
	{
		int action=event.getAction();
		if(action == MotionEvent.ACTION_DOWN)
		{
			Log.i(TAG,"touched you ");
			cdata.ballFired =1;	
			
			if(cdata.fireInProgress == 0)
			{
				cdata.touchX=event.getX();
				cdata.touchY=event.getY();		
			}
			
			if(cdata.gameEnded == 1)
			{
				Intent intent=new Intent(this,EndScreen.class);
				startActivity(intent);
			}
		}
	return false;		
	}
    
    @Override
    public void onRestart()
    {
    	super.onRestart();
    	myview.startGame();
    }
    
    @Override
    public void onPause()
    {
    	super.onPause();
    	myview.stopGame();
    	    	
    }
    
    @Override
    public void onDestroy()
    {    	
    	super.onDestroy();
    	myview.stopGame();
    }
   
    @Override
    public void onResume()
    {
    	super.onResume();
    	myview.startGame();
    }
    
    @Override
    public void onStop()
    {
    	super.onDestroy();
    	myview.stopGame();
    	
    }
    
}
