package com.pursuitapps.smallgame;

public class Reflector {

		public int xPos;
		public int yPos;
		
		int xCoordinate;
		int yCoordinate;
		
		public int reflectorType;
		public int width;
		public int height;
		public double angleRadians; 
		public double angleDegrees;
		
		public int movement;
		public int movementScale;
		
		private CommonData cdata;
		
		int currentDirection;
				
		public Reflector()
		{
			
		}
		
		public Reflector(int x,int y,int h,double degrees)
		{
			xPos=x*cdata.ScreenUnit;
			yPos=y*cdata.ScreenUnit;
			
			xCoordinate=x*cdata.ScreenUnit;
			yCoordinate=y*cdata.ScreenUnit;
			
			currentDirection=1;
			
			
			if(degrees ==90)
			{
				height=30;
				width=h*cdata.ScreenUnit;
			}
			else
			{
				height=h*cdata.ScreenUnit;		
				width =30;
			}
			angleDegrees=degrees;
			angleRadians=Math.toRadians(degrees);		
		}	
		
		public Reflector(int x, int y, int h, double degrees,int m,int mScale)
		{
			xPos=x*50;
			yPos=y*50;
			
			currentDirection=1;
			
			xCoordinate=x*cdata.ScreenUnit;
			yCoordinate=y*cdata.ScreenUnit;
			
			if(degrees ==90)
			{
				height=30;
				width=h*cdata.ScreenUnit;
			}
			else
			{
				height=h*cdata.ScreenUnit;		
				width =30;
			}
			angleDegrees=degrees;
			angleRadians=Math.toRadians(degrees);	
			movement=m;
			movementScale=mScale*cdata.ScreenUnit;
			
		}
		
		public int checkCollision(float x,float y)
		{
			if(movement == 1)
			{
				if((currentDirection > 0) && (xPos <= (xCoordinate + movementScale)))
				xPos +=5;
				
				if((currentDirection < 0) && (xPos  >= xCoordinate ))
				xPos-=5;		
				
				
				if((xPos < xCoordinate)||(xPos > (xCoordinate + movementScale)))
					currentDirection*=-1;
			}	
			
			if(movement == 2)
			{
				if((currentDirection > 0) && (yPos <= (yCoordinate + movementScale)))
				yPos +=5;
				
				if((currentDirection < 0) && (yPos  >= yCoordinate))
				yPos-=5;		
				
				
				if((yPos < yCoordinate)||(yPos > (yCoordinate + movementScale)))
					currentDirection*=-1;
			}		
				
				
			if((x >= xPos  ) && (x <= (xPos+width)) && (y >= yPos)&& (y<=(yPos+ height)))
				return 1;
			else
				return 0;
		}
		
}
