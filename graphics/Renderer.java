package graphics;

import objects.*;

public class Renderer
{
  private Tank[] tanks;
  private Stone[] stones;
  private Brick[] bricks;

  private int tankCount;
  private int stoneCount;
  private int brickCount;

  private int width, height;
  private char[][] bitmap;

  private char borderChar = '.';

  public Renderer(int aWidth, int aHeight)
  {
    width = aWidth;
    height = aHeight;
    tanks = new Tank[21];
    stones = new Stone[30];
    bricks = new Brick[40];
    tankCount = stoneCount = brickCount = 0;
  }

  public int getTankCount() {
    return tankCount;
  }

  public Tank[] getTanks() {
    return tanks;
  }

  public int getStoneCount() {
    return stoneCount;
  }

  public Stone[] getStones() {
    return stones;
  }

  public int getBrickCount() {
    return brickCount;
  }

  public Brick[] getBricks() {
    return bricks;
  }

  public int getHeight() {
    return height;
  }

  public int getWidth() {
    return width;
  }

  public char[][] getBitMap() {
    return bitmap;
  }

  public void addTank(Tank aTank)
  {
    if (tankCount < 21)
    {
      tanks[tankCount] = aTank;
      tankCount++;
    }
    else
    {
      System.out.println("Fatal Error!");
      System.exit(1);
    }
  }

  public void addStone(Stone aStone)
  {
    if (stoneCount < 30)
    {
      stones[stoneCount] = aStone;
      stoneCount++;
    }
    else
    {
      System.out.println("Fatal Error!");
      System.exit(1);
    }
  }

  public void addBrick(Brick aBrick)
  {
    if (brickCount < 40)
    {
      bricks[brickCount] = aBrick;
      brickCount++;
    }
    else
    {
      System.out.println("Fatal Error!");
      System.exit(1);
    }
  }

  public void render()
  {
    int i, j;
    bitmap = new char[height][width];
    //clear the screen
    for (i = 0; i < height; i++)
    {
      for (j = 0; j < width; j++)
      {
        bitmap[i][j] = ' ';
      }
    }
    
    // render objects
    // render tanks
    for (int index = 0; index < tankCount; index++)
    {
      Tank aTank = tanks[index];
      char[][] aTankBitmap = aTank.draw();
      for (i = 0; i < aTank.getHeight(); i++)
      {
        for (j = 0; j < aTank.getWidth(); j++)
        {
          bitmap[aTank.getRowPos() + i][aTank.getColPos() + j] = aTankBitmap[i][j];
        }
      }
    }

    // render stones
    for (int index = 0; index < stoneCount; index++)
    {
      Stone aStone = stones[index];
      char[][] aStoneBitmap = aStone.draw();
      for (i = 0; i < aStone.getHeight(); i++)
      {
        for (j = 0; j < aStone.getWidth(); j++)
        {
          bitmap[aStone.getRowPos() + i][aStone.getColPos() + j] = aStoneBitmap[i][j];
        }
      }
    }

    // render bricks
    for (int index = 0; index < brickCount; index++)
    {
      Brick aBrick = bricks[index];
      char[][] aBrickBitmap = aBrick.draw();
      for (i = 0; i < aBrick.getHeight(); i++)
      {
        for (j = 0; j < aBrick.getWidth(); j++)
        {
          bitmap[aBrick.getRowPos() + i][aBrick.getColPos() + j] = aBrickBitmap[i][j];
        }
      }
    }

    //output to the screen
    //including the border
    for (i = 0; i < width + 2; i++)
    {
      System.out.print(Color.ANSI_RED + borderChar + Color.ANSI_RESET);
    }
    System.out.println();

    //main playing screen
    for (i = 0; i < height; i++)
    {
      System.out.print(Color.ANSI_RED + borderChar + Color.ANSI_RESET);
      for (j = 0; j < width; j++)
      {
        System.out.print(bitmap[i][j]);
      }
      System.out.println(Color.ANSI_RED + borderChar + Color.ANSI_RESET);
    }

    for (i = 0; i < width + 2; i++)
    {
      System.out.print(Color.ANSI_RED + borderChar + Color.ANSI_RESET);
    }
    System.out.println();
  }
}
