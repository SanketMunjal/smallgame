package com.pursuitapps.smallgame;

import java.util.HashMap;

import android.util.Log;

public class CommonData {

	public static float zSensorValue;
	public static int ballFired;
	public static int fireInProgress;
	public static float touchX;
	public static float touchY;
	public static double previousShotDegrees;
	public static double shotRadians;
	public static double shotDegrees;
	public static int gameEnded;
	public static int currentLevel;
	public static int ScreenUnit;
	public static Reflector lastReflector;
	
	
	public static float xAcc;
	
	
	public static String TAG="Common Data";
	
	public CommonData()
	{
		ballFired=0;
		fireInProgress=0;
		touchX=0;
		touchY=0;
		zSensorValue=0;
		gameEnded=0;
		previousShotDegrees=0;
		shotDegrees=0;
		xAcc=0;
	}
	
	public static int inSameQuadrant(double oldAngle,double newAngle)
	{
		Log.i(TAG,"inSameQuadrant  "+oldAngle + "newAngle " + newAngle);
		if( ( ((oldAngle > 0) && (oldAngle < 90)) && ((newAngle > 0) && (newAngle < 90)) ) || ( ((oldAngle > 90) && (oldAngle < 180)) && ((newAngle > 90) && (newAngle < 180)) ) || ( ((oldAngle > 180) && (oldAngle < 270)) && ((newAngle > 180) && (newAngle < 270)) ) || ( ((oldAngle > 270) && (oldAngle < 360)) && ((newAngle > 270) && (newAngle < 360)) ))
			return 1;
		else
			return 0;
	}

	public double getReflectedAngle(double obstacleNormalAngle)
	{
		
		return 0;
	}
	
	
	public static void setScreenUnit(int screenWidth)
	{
		ScreenUnit=screenWidth/15;		
	}
}
