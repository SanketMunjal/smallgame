package com.pursuitapps.smallgame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MyView extends SurfaceView implements SurfaceHolder.Callback{

	Paint backgroundPaint;
	Paint cannonPaint;
	Paint reflectorPaint;
	Paint obstaclePaint;
	Paint cannonNozzelPaint;
	Paint strikerPaint;
		
	public int allLevelsSet;
	
	Context mContext;
	private boolean dialogIsDisplayed = false;
	Activity activity;
	
	private SoundPool soundPool;
	private Map<Integer,Integer> soundMap;
	
	CommonData cdata;
	
	CannonThread cannonThread;
	public final String TAG = "MyView";
	private static final int CONGRATS_SOUND_ID =0;
	private static final int BLAST_SOUND_ID=1;
	private static final int REFLECT_SOUND_ID=2;
	
	private static final int LEVEL_ONE =0;
	private static final int LEVEL_TWO =1;
	private static final int LEVEL_THREE =2;
	private static final int LEVEL_FOUR=3;
	private static final int LEVEL_FIVE=4;
	private static final int LEVEL_SIX=5;
	private static final int LEVEL_SEVEN=6;
	private static final int LEVEL_EIGHT=7;
	private static final int LEVEL_NINE=8;
	private static final int LEVEL_TEN=9;
	private static final int LEVEL_ELEVEN=10;
	private static final int LEVEL_TWELVE=11;
	private static final int LEVEL_THIRTEEN=12;
	private static final int LEVEL_FOURTEEN=13;
	private static final int LEVEL_FIFTEEN=14;
	private static final int LEVEL_SIXTEEN=15;
	private static final int LEVEL_SEVENTEEN=16;
	private static final int LEVEL_EIGHTEEN=17;
	private static final int LEVEL_NINETEEN=18;
	
	private static final int TOTAL_LEVELS=14;
	public static HashMap<Integer,Level> Levels;
	
	int touchPressed;
	
	public MyView(Context context) {
		super(context);
		activity=(Activity)context;
		mContext=context;
		getHolder().addCallback(this);
		Log.i(TAG,"Constructor 1 called");
		
	}

	public void createLevelsForGame(int screenWidth,int screenHeight)
	{
		cdata=new CommonData();
		Levels=new HashMap<Integer,Level>();
		
		Level newLevel=new Level();
		newLevel.obstacleList=	new ArrayList<Obstacle>();
		
		newLevel.obstacleList.add(new Obstacle(4,4,1,0));
		newLevel.obstacleList.add(new Obstacle(10,6,1,0));		
				
		newLevel.reflectorList=null;
		
		Levels.put(LEVEL_ONE,newLevel);		
		
		//FINISHED
		newLevel=new Level();
		newLevel.obstacleList=	new ArrayList<Obstacle>();
		
		newLevel.obstacleList.add(new Obstacle(4,4,1,10));
		newLevel.obstacleList.add(new Obstacle(2,6,1,15));
		newLevel.obstacleList.add(new Obstacle(1,10,1,5));
				
		newLevel.reflectorList=null;
		
		Levels.put(LEVEL_TWO,newLevel);			
				
		//FINISHED
		newLevel=new Level();		
		newLevel.obstacleList=	new ArrayList<Obstacle>();
		newLevel.reflectorList = new ArrayList<Reflector>();
		
		newLevel.obstacleList.add(new Obstacle(6,2,1,0));
		newLevel.obstacleList.add(new Obstacle(12,6,1,0));
		
		newLevel.reflectorList.add(new Reflector(4,4,3,90));
		newLevel.reflectorList.add(new Reflector(10,3,6,0));
	
		Levels.put(LEVEL_THREE,newLevel);	
		
		//FINISHED
		newLevel=new Level();
		newLevel.obstacleList=	new ArrayList<Obstacle>();
		newLevel.reflectorList = new ArrayList<Reflector>();
		
		newLevel.obstacleList.add(new Obstacle(5,9,1,0));
		newLevel.obstacleList.add(new Obstacle(5,1,1,0));
		
		newLevel.reflectorList.add(new Reflector(3,3,5,90));
		newLevel.reflectorList.add(new Reflector(7,0,4,90));
		newLevel.reflectorList.add(new Reflector(3,0,3,0));
		newLevel.reflectorList.add(new Reflector(3,4,6,0));
		newLevel.reflectorList.add(new Reflector(6,6,4,0));
		newLevel.reflectorList.add(new Reflector(3,10,4,90));
		
		newLevel.reflectorList.add((new Reflector(14,4,10,0)));
		Levels.put(LEVEL_FOUR,newLevel);
		
		
		newLevel=new Level();
		newLevel.obstacleList=	new ArrayList<Obstacle>();
		newLevel.reflectorList = new ArrayList<Reflector>();
		
		newLevel.obstacleList.add(new Obstacle(5,6,1,0));
		
		newLevel.reflectorList.add(new Reflector(6,0,5,0));
		newLevel.reflectorList.add(new Reflector(6,8,4,0));
		newLevel.reflectorList.add(new Reflector(0,12,6,90));
		newLevel.reflectorList.add((new Reflector(12,6,8,0)));
		
		Levels.put(LEVEL_FIVE,newLevel);
		
		newLevel=new Level();
		newLevel.obstacleList=	new ArrayList<Obstacle>();
		newLevel.reflectorList = new ArrayList<Reflector>();
		
		newLevel.obstacleList.add(new Obstacle(5,6,1,10));
		
		newLevel.reflectorList.add(new Reflector(3,8,14,90));
		newLevel.reflectorList.add(new Reflector(0,6,3,0));
		newLevel.reflectorList.add(new Reflector(3,8,3,0));
		newLevel.reflectorList.add(new Reflector(0,11,3,0));
		
		Levels.put(LEVEL_SIX,newLevel);
		
		newLevel=new Level();
		newLevel.obstacleList=	new ArrayList<Obstacle>();
		newLevel.reflectorList = new ArrayList<Reflector>();
		
		newLevel.obstacleList.add(new Obstacle(6,6,1,0));
		
		newLevel.reflectorList.add(new Reflector(5,8,14,90));
		newLevel.reflectorList.add(new Reflector(0,6,3,0,2,10));
		
		
		Levels.put(LEVEL_SEVEN,newLevel);
	
		newLevel=new Level();
		newLevel.obstacleList=	new ArrayList<Obstacle>();
		newLevel.reflectorList = new ArrayList<Reflector>();
		
		newLevel.obstacleList.add(new Obstacle(2,1,1,0));
		newLevel.obstacleList.add(new Obstacle(14,1,1,0));
		
		newLevel.reflectorList.add(new Reflector(5,1,6,90));
		newLevel.reflectorList.add(new Reflector(0,5,5,90));
		newLevel.reflectorList.add(new Reflector(11,5,5,90));
		
		
		Levels.put(LEVEL_EIGHT,newLevel);		
		
		newLevel=new Level();
		newLevel.obstacleList=	new ArrayList<Obstacle>();
		newLevel.reflectorList = new ArrayList<Reflector>();
		
		newLevel.obstacleList.add(new Obstacle(2,1,1,0));
		newLevel.obstacleList.add(new Obstacle(14,1,1,0));
		
		newLevel.reflectorList.add(new Reflector(0,2,6,90,1,13));
		newLevel.reflectorList.add(new Reflector(0,5,5,90));
		newLevel.reflectorList.add(new Reflector(10,5,5,90));
		
		Levels.put(LEVEL_NINE,newLevel);
		
		newLevel=new Level();
		newLevel.obstacleList=	new ArrayList<Obstacle>();
		newLevel.reflectorList = new ArrayList<Reflector>();
		
		newLevel.obstacleList.add(new Obstacle(8,10,1,0));
				
		newLevel.reflectorList.add(new Reflector(6,12,4,90));
		newLevel.reflectorList.add(new Reflector(6,6,4,90));
		
		newLevel.reflectorList.add(new Reflector(0,7,5,0,1,5));
		newLevel.reflectorList.add(new Reflector(10,7,5,0));
		
		
		Levels.put(LEVEL_TEN,newLevel);
		
		newLevel=new Level();
		newLevel.obstacleList=	new ArrayList<Obstacle>();
		newLevel.reflectorList = new ArrayList<Reflector>();
		
		newLevel.obstacleList.add(new Obstacle(6,9,1,0));
		newLevel.obstacleList.add(new Obstacle(10,9,1,0));
		
		newLevel.reflectorList.add(new Reflector(4,12,8,90));
		newLevel.reflectorList.add(new Reflector(4,6,8,90));
		
		newLevel.reflectorList.add(new Reflector(0,7,5,0,1,3));
		newLevel.reflectorList.add(new Reflector(8,7,5,0));		
		
		newLevel.reflectorList.add(new Reflector(12,7,5,0,1,3));
				
		Levels.put(LEVEL_ELEVEN,newLevel);
		
		newLevel=new Level();
		newLevel.obstacleList=	new ArrayList<Obstacle>();
		newLevel.reflectorList = new ArrayList<Reflector>();
		
		newLevel.obstacleList.add(new Obstacle(2,2,1,0));
				
		
		//newLevel.reflectorList.add(new Reflector(8,1,3,0));
		
		newLevel.reflectorList.add(new Reflector(8,5,4,0));
		newLevel.reflectorList.add(new Reflector(4,9,4,0));
		
		newLevel.reflectorList.add(new Reflector(0,13,4,90));
		newLevel.reflectorList.add(new Reflector(8,9,6,90));
		
		
		Levels.put(LEVEL_TWELVE,newLevel);
		
		
		newLevel=new Level();		
		newLevel.obstacleList=	new ArrayList<Obstacle>();
		newLevel.reflectorList = new ArrayList<Reflector>();
		
		newLevel.obstacleList.add(new Obstacle(6,2,1,0));
		newLevel.obstacleList.add(new Obstacle(12,6,1,0));
		
		newLevel.reflectorList.add(new Reflector(4,4,3,90));
		newLevel.reflectorList.add(new Reflector(10,3,6,0));
		
		newLevel.reflectorList.add(new Reflector(0,10,6,90,1,14));
		
	
		Levels.put(LEVEL_THIRTEEN,newLevel);	
		
		newLevel=new Level();
		newLevel.obstacleList=	new ArrayList<Obstacle>();
		newLevel.reflectorList = new ArrayList<Reflector>();
		
		newLevel.obstacleList.add(new Obstacle(5,9,1,0));
		newLevel.obstacleList.add(new Obstacle(5,1,1,0));
		
		newLevel.reflectorList.add(new Reflector(3,3,5,90));
		newLevel.reflectorList.add(new Reflector(7,0,4,90));
		newLevel.reflectorList.add(new Reflector(3,0,3,0));
		newLevel.reflectorList.add(new Reflector(3,4,6,0));
		newLevel.reflectorList.add(new Reflector(6,6,4,0));
		newLevel.reflectorList.add(new Reflector(3,10,4,90));
		
		newLevel.reflectorList.add((new Reflector(14,4,3,0,2,8)));
		Levels.put(LEVEL_FOURTEEN,newLevel);
		
		newLevel=new Level();
		newLevel.obstacleList=	new ArrayList<Obstacle>();
		newLevel.reflectorList = new ArrayList<Reflector>();
		
		newLevel.obstacleList.add(new Obstacle(5,6,1,0));
		
		newLevel.reflectorList.add(new Reflector(6,0,5,0));
		newLevel.reflectorList.add(new Reflector(6,8,4,0));
		newLevel.reflectorList.add(new Reflector(0,12,6,90));
		newLevel.reflectorList.add((new Reflector(12,6,3,0,2,6)));
		
		Levels.put(LEVEL_FIFTEEN,newLevel);
			
				
	}
	
	public MyView(Context context, AttributeSet attrs) {
		super(context,attrs);
		mContext=context;
		activity=(Activity)context;
		getHolder().addCallback(this);
		Log.i(TAG,"Constructor 2 called");
		
		soundPool = new SoundPool(1,AudioManager.STREAM_MUSIC,0);
		soundMap = new HashMap<Integer, Integer>();
		soundMap.put(CONGRATS_SOUND_ID, soundPool.load(context,R.raw.abc,1));
		soundMap.put(BLAST_SOUND_ID,soundPool.load(context,R.raw.blast,1));
		soundMap.put(REFLECT_SOUND_ID,soundPool.load(context,R.raw.reflect,1));
		
	}
	
	public MyView(Context context, AttributeSet attrs,int defStyle) {
		super(context,attrs,defStyle);
		mContext=context;
		activity=(Activity)context;
		getHolder().addCallback(this);
		Log.i(TAG,"Constructor 3 called");
	}
	
	@Override
	public void surfaceChanged(SurfaceHolder holder, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		cannonThread =new CannonThread(holder);
		cannonThread.setRunning(true);
		cannonThread.start();			
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder arg0) {
		boolean retry=true;
		cannonThread.setRunning(false);
		while(retry)
		{			
			try
			{
				cannonThread.join();
				retry=false;
			}
			catch(InterruptedException e)
			{
				
			}
		}
		
	}
	
	private void showGameOverDialog(int messageId)
	 {
		 	Log.i(TAG,"SHOW GAME OVER DIALOG");
	         // create a dialog displaying the given String
	         final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getContext());
	         
	        
	         dialogBuilder.setTitle("!!");
	         if((messageId == 1)||(messageId == 8))
	        	 dialogBuilder.setIcon(R.drawable.win1);
	         else if((messageId == 2)||(messageId == 9))
		         dialogBuilder.setIcon(R.drawable.win2);
	         else if((messageId == 3)||(messageId == 10))
		         dialogBuilder.setIcon(R.drawable.win3);
	         else if((messageId == 4)||(messageId == 11))
		         dialogBuilder.setIcon(R.drawable.win4);
	         else if((messageId == 5)||(messageId == 12))
		         dialogBuilder.setIcon(R.drawable.win5);
	         else if((messageId == 6)||(messageId == 13))
		         dialogBuilder.setIcon(R.drawable.win6);
	         else if((messageId == 7)||(messageId == 14))
		         dialogBuilder.setIcon(R.drawable.win7);
	         else
		         dialogBuilder.setIcon(R.drawable.win8);
	         
	         soundPool.play(soundMap.get(CONGRATS_SOUND_ID),1,1,1,0,1f);
	         dialogBuilder.setCancelable(false);
	 
	         
	         // display number of shots fired and total time elapsed
	         if(messageId != 0)
	         {
	        	 dialogBuilder.setMessage(getResources().getString(R.string.level_complete));
	        	 dialogBuilder.setPositiveButton(R.string.nextlevel,new DialogInterface.OnClickListener()	            
	        	 {
	               // called when "Reset Game" Button is pressed
	               @Override
	               public void onClick(DialogInterface dialog, int which)
	               {
	                  dialogIsDisplayed = false;
	                  Log.i(TAG,"notsetting thread to true value is "+ which);
	                 
	                 // cannonThread.setRunning(true);
	               } // end method onClick
	            }); // end anonymous inner class
	         }	
	         else
	         {
	        	 dialogBuilder.setMessage(getResources().getString(R.string.game_complete));
	        	 dialogBuilder.setPositiveButton(R.string.finishgame,new DialogInterface.OnClickListener()	            
	        	 {
	               // called when "Reset Game" Button is pressed
	               @Override
	               public void onClick(DialogInterface dialog, int which)
	               {
	                  dialogIsDisplayed = false;
	                  activity.finish();
	                  Log.i(TAG,"notsetting thread to true value is "+ which);
	                 
	                 // cannonThread.setRunning(true);
	               } // end method onClick
	            }); // end anonymous inner class
	         }
	         
	        	
	        	 
	        	 dialogBuilder.setNegativeButton(R.string.mainMenu,new DialogInterface.OnClickListener()	            
	        	 {
	               // called when "Reset Game" Button is pressed
	               @Override
	               public void onClick(DialogInterface dialog, int which)
	               {
	                  dialogIsDisplayed = false;
	                  Log.i(TAG,"notsetting thread to true value is "+ which);
	                  activity.finish();
	                 // cannonThread.setRunning(true);
	               } // end method onClick
	            } // end anonymous inner class
	        	 
	        	 
	         ); // end call to setPositiveButton
	 
	         activity.runOnUiThread(
	            new Runnable() {
	               public void run()
	               {
	                  dialogIsDisplayed = true;
	                  dialogBuilder.show(); // display the dialog
	               } // end method run
	            } // end Runnable
	         ); // end call to runOnUiThread
	 } // end method showGameOverDialog
	 

	 public void stopGame()
	 {
			if(cannonThread!= null)
			cannonThread.setRunning(false);
	 }
	 
	 public void startGame()
	 {
			if(cannonThread!= null)
			cannonThread.setRunning(true);
	 }
	 
	 
	public class CannonThread extends Thread{
		
		private int counter;
		private int cannonPositionX;
		
		private int changeInX;
		
		
		private int ballDistance;
		float ballPositionX;
		float ballPositionY;		
		
		CommonData cdata;
		SensorManager sm;
			
		private SurfaceHolder surfaceHolder;
		private boolean threadIsRunning = true;
		
		public CannonThread(SurfaceHolder holder)
		{
			counter=0;
			surfaceHolder = holder;
			ballDistance=10;
						
			allLevelsSet=0;
			
			backgroundPaint = new Paint();
			cannonPaint = new Paint();		
			cannonNozzelPaint=new Paint();
			reflectorPaint=new Paint();
			obstaclePaint=new Paint();
			strikerPaint=new Paint();
			
			backgroundPaint.setColor(Color.argb(255,200,102,0));			
			
			cannonPaint.setColor(Color.BLACK);
			
			obstaclePaint.setColor(Color.BLUE);
			reflectorPaint.setColor(Color.DKGRAY);
			cannonNozzelPaint.setColor(Color.BLACK);
			cannonNozzelPaint.setStrokeWidth(20);
			strikerPaint.setColor(Color.BLACK);
			
			cannonPositionX=250;
			changeInX=5;
			
		}
				
		public void findBallPosition(Canvas canvas)
		{		
			if((cdata.ballFired == 1))
			{
									
				if(cdata.fireInProgress == 0)
				{
					cdata.fireInProgress = 1;
					
					Log.i(TAG,"fire in progress now");
					
					ballPositionX =cannonPositionX;
					ballPositionY =canvas.getHeight()-2*cdata.ScreenUnit;
										
					cdata.shotRadians=Math.atan((ballPositionY-cdata.touchY)/(ballPositionX-cdata.touchX));
					cdata.previousShotDegrees=cdata.shotDegrees;
					cdata.shotDegrees=Math.toDegrees(cdata.shotRadians);
			
					if(ballPositionX > cdata.touchX)
					{
						cdata.shotDegrees+=180;
						cdata.previousShotDegrees=cdata.shotDegrees;
						cdata.shotRadians=Math.toRadians(cdata.shotDegrees);
						
					}
					
					Log.i(TAG,"Angle in degrees for ball shooted is "+ cdata.shotDegrees);
					//cdata.shotRadians=Math.toRadians(90 + Math.toDegrees(cdata.shotRadians));					
				}	
				
				if(cdata.fireInProgress == 1)
				{
					ballPositionX+=(ballDistance * Math.cos(cdata.shotRadians)) ;
					ballPositionY+=1.2*(ballDistance * Math.sin(cdata.shotRadians));					
					
					if((ballPositionX < 0) || (ballPositionX > canvas.getWidth()))
					{
						cdata.fireInProgress = 0;
						cdata.ballFired =0;
						cdata.previousShotDegrees=0;
						cdata.shotDegrees=0;
						cdata.shotRadians=0;
					}
					if((ballPositionY < 0 ) || (ballPositionY > canvas.getHeight()))
					{
							cdata.fireInProgress =0;
							cdata.ballFired=0;
							cdata.previousShotDegrees=0;
							cdata.shotDegrees=0;
							cdata.shotRadians=0;
					}					
				}								
				
			}
			else
			{
				ballPositionX=-1;
				ballPositionY=-1;
				cdata.lastReflector=null;
			}
		}
					
		public void updateCannonPosition(Canvas canvas)
		{
			if(cdata.xAcc > 2)
				cannonPositionX-=5;						
			else if(cdata.xAcc < -2)
				cannonPositionX+=5;
			else 
				cannonPositionX+=0;
			
			if((cannonPositionX > canvas.getWidth()))
				cannonPositionX=canvas.getWidth();

			if((cannonPositionX < 0))
				cannonPositionX=0;
		}
		
		public void drawGameElements(Canvas canvas)
		{
			
			int cannonRadius=30;
			int canvasHeight=canvas.getHeight(); 
			int canvasWidth=canvas.getWidth();			
			int collisionDetected=0;
			int numAliveObstacles=0;			
			Level currentLevel=Levels.get(cdata.currentLevel);
						
			
			//Drawing Background
			canvas.drawRect(0,0,canvasWidth,canvasHeight,backgroundPaint);				
						
			//Cannon
			canvas.drawCircle(cannonPositionX, canvas.getHeight()-cannonRadius, cannonRadius, cannonPaint);
			if(cdata.shotDegrees != 0)			
				canvas.drawLine(cannonPositionX,canvas.getHeight()-cannonRadius,cannonPositionX + (int)(50 * Math.cos(cdata.shotRadians)),canvas.getHeight() -cannonRadius- 50,cannonNozzelPaint);
			else
				canvas.drawLine(cannonPositionX,canvas.getHeight()-cannonRadius,cannonPositionX ,canvas.getHeight() - cannonRadius-50,cannonNozzelPaint);
			
						
			int[] gradientColorsObstacle=new int[2];
			gradientColorsObstacle[0]=Color.CYAN;
			gradientColorsObstacle[1]=Color.BLUE;
			
			int[] gradientColorsStriker=new int[2];
			gradientColorsStriker[0]=Color.argb(255,205,0,0);
			gradientColorsStriker[1]=Color.argb(255,255,0,0);
			
			
			float[] gradientPositions=new float[2];
			gradientPositions[0]=0.0f;
			gradientPositions[1]=1.0f;
			
			//RadialGradient radialGradientShader=new RadialGradient(ballPositionX,ballPositionY,20,gradientColorsStriker,gradientPositions,TileMode.CLAMP);
			//strikerPaint.setShader(radialGradientShader);
			
			//Log.i(TAG,"ball X "+ ballPositionX + "ball Y "+ ballPositionY + " fireInProgress "+ cdata.fireInProgress + "ballFired "+cdata.ballFired);
			if((ballPositionX > 0) && (ballPositionY > 0))
			canvas.drawCircle(ballPositionX, ballPositionY, 20, strikerPaint);			
			
			Iterator<Obstacle> itr_obstacle= currentLevel.obstacleList.iterator();
			while(itr_obstacle.hasNext())
			{
				Obstacle obstacle=itr_obstacle.next();
				//Log.i(TAG,"Obstacle xPos "+ obstacle.xPos + "yPos "+ obstacle.yPos);
				if(obstacle.isAlive == 1)
				{
					RadialGradient radialGradientShader=new RadialGradient(obstacle.xPos,obstacle.yPos,obstacle.radius,gradientColorsObstacle,gradientPositions,TileMode.CLAMP);
					obstaclePaint.setShader(radialGradientShader);
					canvas.drawCircle(obstacle.xPos, obstacle.yPos, obstacle.radius, obstaclePaint);				
					collisionDetected=obstacle.checkCollision(ballPositionX,ballPositionY,canvasWidth);
					if(collisionDetected == 1)
					{
						obstacle.isAlive=0;
						soundPool.play(soundMap.get(BLAST_SOUND_ID),1,1,1,0,1f);
					}
					else
						numAliveObstacles++;
					
				}
			}
			
						
			if(currentLevel.reflectorList != null)
			{
				Iterator<Reflector> itr_reflector= currentLevel.reflectorList.iterator();
				while(itr_reflector.hasNext())
				{
					Reflector reflector=itr_reflector.next();
					//Log.i(TAG,"Reflector xPos "+ reflector.xPos + "yPos "+ reflector.yPos);
					canvas.drawRoundRect(new RectF(reflector.xPos,reflector.yPos,reflector.xPos + reflector.width,reflector.yPos + reflector.height),10,10, reflectorPaint);
					collisionDetected=reflector.checkCollision(ballPositionX,ballPositionY);
				if((collisionDetected == 1) && (cdata.lastReflector != reflector))
				{
						Log.i(TAG,"Collision detected old angle"+Math.toDegrees(cdata.shotRadians));
						cdata.lastReflector=reflector;
						
					if(reflector.angleDegrees != 90)
					{
						if((cdata.shotDegrees > 180) && (cdata.shotDegrees < 270))
						{
							cdata.previousShotDegrees=cdata.shotDegrees;
							cdata.shotDegrees-=180;
							//cdata.shotDegrees=90-cdata.shotDegrees;
							cdata.shotDegrees*=-1;
							
						}
						else if(cdata.shotDegrees < 0) 
						{	
							cdata.previousShotDegrees=cdata.shotDegrees;
							cdata.shotDegrees*=-1;
							//cdata.shotDegrees=90-cdata.shotDegrees;
							cdata.shotDegrees+=180;
						}
						else if((cdata.shotDegrees > 90) && (cdata.shotDegrees < 180))
						{
							cdata.previousShotDegrees=cdata.shotDegrees;
							cdata.shotDegrees-=180;
							cdata.shotDegrees*=-1;
						}
						else
						{
							cdata.previousShotDegrees=cdata.shotDegrees;
							cdata.shotDegrees=90-cdata.shotDegrees;
							cdata.shotDegrees+=90;
						}
					}
					else
					{
						if((cdata.shotDegrees < 0) ||	((cdata.shotDegrees > 0)&&(cdata.shotDegrees < 90)))
						{
							cdata.previousShotDegrees=cdata.shotDegrees;
							cdata.shotDegrees*=-1;						
						}
						else if((cdata.shotDegrees > 180) )
						{
							cdata.previousShotDegrees=cdata.shotDegrees;
							cdata.shotDegrees-= 2*(cdata.shotDegrees - 180);
						}
						else if((cdata.shotDegrees > 90) && (cdata.shotDegrees < 180))
						{
							cdata.previousShotDegrees=cdata.shotDegrees;
							cdata.shotDegrees+=2*( 180 -cdata.shotDegrees  );							
						}
						else
						{
							Log.i(TAG,"Angle has not been handled "+ cdata.shotDegrees);
						}		
						
					}
						cdata.shotRadians=Math.toRadians(cdata.shotDegrees);
						soundPool.play(soundMap.get(REFLECT_SOUND_ID),1,1,1,0,1f);
						Log.i(TAG,"Collision detected new angle "+ Math.toDegrees(cdata.shotRadians));
						Log.i(TAG,"ScreenUnit "+cdata.ScreenUnit);
					}
				}
			
			}
			
			
			if(numAliveObstacles == 0)
			{
				Log.i(TAG,"Level Complete SO LOADING NEW LEVEL");
				
				
				if(cdata.currentLevel == TOTAL_LEVELS )
				{
					stopGame();
					showGameOverDialog(0);
					cdata.lastReflector=null;
					cdata.gameEnded=1;		
				}
				else
				{
					ballPositionX=-10;
					ballPositionY=-10;
					showGameOverDialog( cdata.currentLevel+1);
					cdata.lastReflector=null;
					cdata.currentLevel++;
				}
			}
			
		}
		
		public void updateGameElements()
		{			
			if(touchPressed == 50)
			{
				soundPool.play(soundMap.get(CONGRATS_SOUND_ID),1,1,1,0,1f);
			}
			touchPressed =0;			
		}
		
		public void setRunning(boolean running)
		{
			Log.i(TAG,"thread set to "+ threadIsRunning);
			threadIsRunning = running;
		}
		
		@Override
		public void run()
		{
			Canvas canvas = null;
			long previousFrameTime= System.currentTimeMillis();
			
			while(threadIsRunning)
			{
				try
				{
					canvas =surfaceHolder.lockCanvas(null);
					
					synchronized(surfaceHolder)
					{
						
						if((canvas != null) && (allLevelsSet == 0))
						{
							cdata.setScreenUnit(canvas.getWidth());
							createLevelsForGame(canvas.getWidth(),canvas.getHeight());
							allLevelsSet=1;
						}	
						
						long currentTime = System.currentTimeMillis();
						double elapsedTime = currentTime -previousFrameTime;
						previousFrameTime = currentTime;
						updateCannonPosition(canvas);
						findBallPosition(canvas);
						drawGameElements(canvas);
					}
				}
				finally
				{
					if(canvas != null)
						surfaceHolder.unlockCanvasAndPost(canvas);				
				}
				
			}
			
		}

	}
	
	
}
