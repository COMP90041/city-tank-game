package objects;

import graphics.*;
import utilities.*;

public class Tank
{
  private int rowPos, colPos;
  private Commands.Direction curDirection;
  private int width, height;

  public Tank(int rowIndex, int colIndex)
  {
    rowPos = rowIndex;
    colPos = colIndex;
    curDirection = Commands.Direction.UP;
    width = 5;
    height = 5;
  }

  public Tank(int rowIndex, int colIndex, Commands.Direction direction)
  {
    this(rowIndex, colIndex);
    curDirection = direction;
  }
  
	/**
	Return the current row position
	*/
  public int getRowPos()
  {
    return rowPos;
  }

  public int getColPos()
  {
    return colPos;
  }

  public int getWidth()
  {
    return width;
  }

  public int getHeight()
  {
    return height;
  }

  public void move(Commands.Direction cmd, Renderer mainRenderer)
  {
    //Update the location or the current direction
    //based on the command received from the player
    switch (curDirection)
    {
      case UP:
        switch (cmd)
        {
          case UP:
            if(! isCollision(mainRenderer, rowPos - 1, colPos)) rowPos--;
            break;
          case DOWN:
            if(! isCollision(mainRenderer, rowPos + 1, colPos)) rowPos++;
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
            if(! isCollision(mainRenderer, rowPos - 1, colPos)) rowPos--;
            break;
          case DOWN:
            if(! isCollision(mainRenderer, rowPos + 1, colPos)) rowPos++;
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
            if(! isCollision(mainRenderer, rowPos, colPos - 1)) colPos--;
            break;
          case RIGHT:
            if(! isCollision(mainRenderer, rowPos, colPos + 1)) colPos++;
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
            if(! isCollision(mainRenderer, rowPos, colPos - 1)) colPos--;
            break;
          case RIGHT:
            if(! isCollision(mainRenderer, rowPos, colPos + 1)) colPos++;
            break;
          default:
            break;
        }
        break;
      default:
        break;
    }
  }

  public char[][] draw()
  {
    //allocate a bitmap for the tank
    char[][] bitmap = new char[getHeight()][getWidth()];
    for (int i = 0; i < getHeight(); i++)
      for (int j = 0; j < getWidth(); j++)
      {
        bitmap[i][j] = '*';
      }

    //update the bitmap accordingly
    //based on the current direction
    switch (curDirection)
    {
      case UP:
        bitmap[0][0] = bitmap[0][4] = ' ';
        bitmap[1][0] = bitmap[1][1] = bitmap[1][3] = bitmap[1][4] = ' ';
        break;
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

  public boolean isCollision(Renderer mainRenderer, int rowPos, int colPos) {
    // Collision check with the borders
    if((rowPos + this.getHeight() > mainRenderer.getHeight()) || (colPos + this.getWidth() > mainRenderer.getWidth()) || rowPos < 0 || colPos < 0)
      return true;
    // Collision check with obstacles in the map
    else {
      char[][] bitmap = mainRenderer.getBitMap();

      // Removes the player tank from the bitmap before checking for collision with enemy tanks
      for (int i = 0; i < this.getHeight(); i++)
        for (int j = 0; j < this.getWidth(); j++)
          bitmap[this.getRowPos() + i][this.getColPos() + j] = ' ';

      for (int i = 0; i < this.getHeight(); i++)
        for (int j = 0; j < this.getWidth(); j++)
         if(bitmap[rowPos + i][colPos + j] != ' ') return true;
    }
    return false;
  }

}