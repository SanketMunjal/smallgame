package com.pursuitapps.smallgame;

public class Obstacle {

	public int xPos;
	public int yPos;
	
	private int xCoordinate;
	private int yCoordinate;
	
	public int isAlive;
	public int radius;
	public int moveX;
	public static int screenWidth;
	public static int screenHeight;
	private CommonData cdata;
	
	public Obstacle()
	{
		xCoordinate=0;
		yCoordinate=0;
		xPos=0;
		yPos=0;		
		radius=0;
		moveX=0;
		
	}
	
	public Obstacle(int x,int y,int r,int move)
	{
		xCoordinate =x*cdata.ScreenUnit;
		yCoordinate =y*cdata.ScreenUnit;
		xPos=x*cdata.ScreenUnit;
		yPos=y*cdata.ScreenUnit;
		radius =r*cdata.ScreenUnit;
		isAlive=1;
		moveX=move;
						
	}
	
	public int checkCollision(float x,float y,int screenWidth)
	{
		if(moveX !=0)
		{
			if((xPos < (xCoordinate-radius)) ||(xPos > screenWidth))
				moveX*=-1;
		
		xPos+=moveX;
		}
		
		
		if((x >= xPos- radius) && (x <= xPos+radius) && (y >= yPos-radius)&& (y <= yPos+ radius))
			return 1;
		else
			return 0;
	}
	
}
