package objects;

import graphics.*;
import utilities.*;

public class Bullet extends GameObject{
	
	private static final int DEFAULTBULLETDISTANCE = 10;

	private int maxDistance;
	private int bulletDistance = DEFAULTBULLETDISTANCE;
	
	
	  public Bullet(int rowIndex, int colIndex)
	  {
		  super(rowIndex, colIndex, 1, DEFAULTBULLETDISTANCE, Color.ANSI_BLACK);
	  }
	  public Bullet(int rowIndex, int colIndex, int width, int height)
	  {
		  super(rowIndex, colIndex, width, height, Color.ANSI_BLACK);
	  }
	  
	  public char[][] draw()
	  {
	      //allocate a bitmap for the bullet
		  
		  
		  
		  
		  
	      return super.draw();
	  }
	 
	  public void shootDirection (int rowPos, int colPos, Commands.Direction direction, Renderer mainRenderer) {
		  
		  char[][] bitmap = mainRenderer.getBitMap();
		  // Hit check with the objects
		  				  
		  		switch (direction)
		        {
		          case UP:
		        	  // check if the bullet hit the border
		        	  maxDistance = Math.min(bulletDistance, rowPos);	
		        	  
		        	  
		        	  // check if hit other objects
	        	  		       
		              		            		
		                for (int j = rowPos; j < rowPos - maxDistance; j--) {
		                  if (bitmap[6][21] == '*' || bitmap[colPos + 2][j] == '$' ) {
		                  	maxDistance = Math.min(maxDistance, 5);		                  	
		                  }
		                }	
		              
		  			  setColPos(colPos + 2);
		              setRowPos(rowPos - maxDistance);
		              setHeight(maxDistance);
		              setWidth(1);
		              
		            break;
		          case DOWN:
		        	// check if the bullet hit the border
		        	  maxDistance = Math.min(bulletDistance, mainRenderer.getHeight()-rowPos-5);	
		        	  
		        	  
		        	  // check if hit other objects
		        	  	       
		              		            		
		                for (int j = rowPos; j < rowPos + maxDistance; j++) {
		                  if (bitmap[j][colPos + 2] == '*' || bitmap[j][colPos + 2] == '$' ) {
		                  	maxDistance = Math.min(maxDistance, colPos - j);		                  	
		                  }
		                }	
		              
		  			  setColPos(colPos + 2);
		              setRowPos(rowPos +5);
		              setHeight(maxDistance);
		              setWidth(1);
		            break;
		          case LEFT:
		        	// check if the bullet hit the border
		        	  maxDistance = Math.min(bulletDistance, colPos);	
		        	  
		        	  
		        	  // check if hit other objects
		        	  	       
		              		            		
		                for (int j = colPos; j < rowPos - maxDistance; j--) {
		                  if (bitmap[rowPos+2][j] == '*' || bitmap[rowPos+2][j] == '$' ) {
		                  	maxDistance = Math.min(maxDistance, colPos - j);		                  	
		                  }
		                }	
		              
		  			  setColPos(colPos-maxDistance);
		              setRowPos(rowPos+2);
		              setHeight(1);
		              setWidth(maxDistance);
		              break;
		          case RIGHT:
		        	// check if the bullet hit the border
		        	  maxDistance = Math.min(bulletDistance, mainRenderer.getWidth() - colPos - 5);	
		        	  
		        	  
		        	  // check if hit other objects
		        	  	       
		              		            		
		                for (int j = colPos+5; j < colPos + 5 + maxDistance; j++) {
		                  if (bitmap[rowPos+2][j] == '*' || bitmap[rowPos+2][j] == '$' ) {
		                  	maxDistance = Math.min(maxDistance, j - colPos -5);		                  	
		                  }
		                }	
		              
		  			  setColPos(colPos+5);
		              setRowPos(rowPos+2);
		              setHeight(1);
		              setWidth(maxDistance);
		            break; 
		          default:
		            break;
		        }		
		      
		    // NO Collision check with obstacles in the map
		   
	    
		  
	 }
	  
	 /*
	  public void shootDistance (int height, int width, Commands.Direction direction) {
		  
		  bulletDistance = Math.max(height,  width);
		  
		  switch (direction)
	        {
	          case UP:
	        	  	maxDistance = Math.min(bulletDistance, BORDERHEIGHT - rowPos - 1);	
	        	  	setHeight(maxDistance);
	            break;
	          case DOWN:
	        	  	maxDistance = Math.min(bulletDistance, rowPos-1);
	        	  	setHeight(-maxDistance);
	            break;
	          case LEFT:
	        	  	maxDistance = Math.min(bulletDistance, colPos-1);
	        	  	setWidth(-maxDistance);
	            break;
	          case RIGHT:
	        	  	maxDistance = Math.min(bulletDistance, BORDERWIDTH -colPos -1);
	        	  	setWidth(maxDistance);
	            break;
	          default:
	            break;
	        }	
		  
		  
	  }
*/
	  
	 /* private char shootCheck (Renderer mainRenderer, int rowPos, int colPos, int bulletDistance, Commands.Direction direction) {
		 
		  
		  char[][] bitmap = mainRenderer.getBitMap();

	      // Check if your bullets hit a Tank 
	      	for (int i= rowPos; i < bulletDistance; i++) {
	          if (bitmap[i][colPos] == '*');	     	    
	      	}
	      
	      	
	      	
	      	
		  
		  
		  return True ;
	  }
	  */
	  
	  
	  // public Bullet(int rowIndex, int colIndex, int distance, Commands.Direction direction)
	  //{
	    //this(rowIndex, colIndex);
	    ///curDirection = direction;
	  //}

/*	  public void move(Commands.Direction cmd, Renderer mainRenderer)
	  {
	    //Update the location or the current direction
	    //based on the command received from the player
	    switch (curDirection)
	    {
	      case UP:
	        switch (cmd)
	        {
	          case UP:
	            if(! isCollision(mainRenderer, getRowPos() - 1, getColPos()))
	              setRowPos(getRowPos() - 1);
	            break;
	          case DOWN:
	            if(! isCollision(mainRenderer, getRowPos() + 1, getColPos()))
	              setRowPos(getRowPos() + 1);
	            break;
	          case LEFT:
	            curDirection = Commands.Direction.LEFT;
	            break;
	          case RIGHT:
	            curDirection = Commands.Direction.RIGHT;
	            break;
	          default:
	            break;
	        }
	        break;
	      case DOWN:
	        switch (cmd)
	        {
	          case UP:
	            if(! isCollision(mainRenderer, getRowPos() - 1, getColPos()))
	              setRowPos(getRowPos() - 1);
	            break;
	          case DOWN:
	            if(! isCollision(mainRenderer, getRowPos() + 1, getColPos()))
	              setRowPos(getRowPos() + 1);
	            break;
	          case LEFT:
	            curDirection = Commands.Direction.LEFT;
	            break;
	          case RIGHT:
	            curDirection = Commands.Direction.RIGHT;
	            break;
	          default:
	            break;
	        }
	        break;
	      case LEFT:
	        switch (cmd)
	        {
	          case UP:
	            curDirection = Commands.Direction.UP;
	            break;
	          case DOWN:
	            curDirection = Commands.Direction.DOWN;
	            break;
	          case LEFT:
	            if(! isCollision(mainRenderer, getRowPos(), getColPos() - 1))
	              setColPos(getColPos() - 1);
	            break;
	          case RIGHT:
	            if(! isCollision(mainRenderer, getRowPos(), getColPos() + 1))
	              setColPos(getColPos() + 1);
	            break;
	          default:
	            break;
	        }
	        break;
	      case RIGHT:
	        switch (cmd)
	        {
	          case UP:
	            curDirection = Commands.Direction.UP;
	            break;
	          case DOWN:
	            curDirection = Commands.Direction.DOWN;
	            break;
	          case LEFT:
	            if(! isCollision(mainRenderer, getRowPos(), getColPos() - 1))
	              setColPos(getColPos() - 1);
	            break;
	          case RIGHT:
	            if(! isCollision(mainRenderer, getRowPos(), getColPos() + 1))
	              setColPos(getColPos() + 1);
	            break;
	          default:
	            break;
	        }
	        break;
	      default:
	        break;
	    }
	  }

	   //Overriding draw() in Object class to shoot bullet
	  public char[][] draw()
	  {
	    //allocate a bitmap for the tank
	    char[][] bitmap = super.draw();

	    //update the bitmap accordingly
	    //based on the current direction
	    switch (curDirection)
	    {
	      case UP:
	        
	      case DOWN:
	        bitmap[3][0] = bitmap[3][1] = bitmap[3][3] = bitmap[3][4] = ' ';
	        bitmap[4][0] = bitmap[4][4] = ' ';
	        break;
	      case LEFT:
	        bitmap[0][0] = bitmap[0][1] = ' ';
	        bitmap[1][1] = bitmap[3][1] = ' ';
	        bitmap[4][0] = bitmap[4][1] = ' ';
	        break;
	      case RIGHT:
	        bitmap[0][3] = bitmap[0][4] = ' ';
	        bitmap[1][3] = bitmap[3][3] = ' ';
	        bitmap[4][3] = bitmap[4][4] = ' ';
	        break;
	      default:
	        break;
	    }
	    return bitmap;
	  }

*/	 
	
}
