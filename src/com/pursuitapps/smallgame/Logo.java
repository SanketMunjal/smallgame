package com.pursuitapps.smallgame;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.widget.ImageView;

public class Logo extends Activity{

	private Bitmap mBitmapIn;
	
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.logo);
	        
	        mBitmapIn = loadBitmap(R.drawable.p);
	      
	        ImageView in = (ImageView) findViewById(R.id.displayin);
	        in.setImageBitmap(mBitmapIn);
	       
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
				Intent intent=new Intent(this,LevelGridActivity.class);
				startActivity(intent);				
				
			}
		return false;		
		}
	    
	    private Bitmap loadBitmap(int resource) {
	        final BitmapFactory.Options options = new BitmapFactory.Options();
	        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
	        return BitmapFactory.decodeResource(getResources(), resource, options);
	    }
	
}
