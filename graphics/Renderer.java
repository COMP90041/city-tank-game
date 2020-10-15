package graphics;

import objects.*;

public class Renderer
{
  private Tank[] tanks;
  private Stone[] stones;
  private Brick[] bricks;
  private Bullet[] bullets;

  private int tankCount;
  private int stoneCount;
  private int brickCount;
  private int bulletCount;

  private int width, height;
  private char[][] bitmap;
  private String[][] colourBitmap;

  private char borderChar = '.';

  public Renderer(int aWidth, int aHeight)
  {
    width = aWidth;
    height = aHeight;
    tanks = new Tank[21];
    stones = new Stone[30];
    bricks = new Brick[40];
    bullets = new Bullet[100];
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

  public int getBulletCount() {
    return bulletCount;
  }

  public Bullet[] getBullets() {
    return bullets;
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

  public void addBullet(Bullet aBullet)
  {
    if (bulletCount < 100)
    {
      bullets[bulletCount] = aBullet;
      bulletCount++;
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
    colourBitmap = new String[height][width];

    //clear the screen
    for (i = 0; i < height; i++)
    {
      for (j = 0; j < width; j++)
      {
        bitmap[i][j] = ' ';
        colourBitmap[i][j] = "";
      }
    }
    
    // render objects
    // render tanks
    for (int index = 0; index < tankCount; index++)
    {
      Tank aTank = tanks[index];
      String tankColour = aTank.getColor();
      char[][] aTankBitmap = aTank.draw();
      for (i = 0; i < aTank.getHeight(); i++)
      {
        for (j = 0; j < aTank.getWidth(); j++)
        {
          bitmap[aTank.getRowPos() + i][aTank.getColPos() + j] = aTankBitmap[i][j];
          colourBitmap[aTank.getRowPos() + i][aTank.getColPos() + j] = tankColour;
        }
      }
    }

    // render stones
    for (int index = 0; index < stoneCount; index++)
    {
      Stone aStone = stones[index];
      String stoneColour = aStone.getColor();
      char[][] aStoneBitmap = aStone.draw();
      for (i = 0; i < aStone.getHeight(); i++)
      {
        for (j = 0; j < aStone.getWidth(); j++)
        {
          bitmap[aStone.getRowPos() + i][aStone.getColPos() + j] = aStoneBitmap[i][j];
          colourBitmap[aStone.getRowPos() + i][aStone.getColPos() + j] = stoneColour;
        }
      }
    }

    // render bricks
    for (int index = 0; index < brickCount; index++)
    {
      Brick aBrick = bricks[index];
      String brickColour = aBrick.getColor();
      char[][] aBrickBitmap = aBrick.draw();
      for (i = 0; i < aBrick.getHeight(); i++)
      {
        for (j = 0; j < aBrick.getWidth(); j++)
        {
          bitmap[aBrick.getRowPos() + i][aBrick.getColPos() + j] = aBrickBitmap[i][j];
          colourBitmap[aBrick.getRowPos() + i][aBrick.getColPos() + j] = brickColour;
        }
      }
    }

    // render bullets
    for (int index = 0; index < bulletCount; index++)
    {
      Bullet aBullet = bullets[index];

      aBullet.move(this);
      if (!aBullet.isAlive()) continue;

      String bulletColour = aBullet.getColor();
      char[][] aBulletBitmap = aBullet.draw();
      for (i = 0; i < aBullet.getHeight(); i++)
      {
        for (j = 0; j < aBullet.getWidth(); j++)
        {
          bitmap[aBullet.getRowPos() + i][aBullet.getColPos() + j] = aBulletBitmap[i][j];
          colourBitmap[aBullet.getRowPos() + i][aBullet.getColPos() + j] = bulletColour;
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
          System.out.print(colourBitmap[i][j] + bitmap[i][j] + Color.ANSI_RESET);
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
