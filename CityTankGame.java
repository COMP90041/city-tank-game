import objects.*;
import graphics.*;
import utilities.*;
import java.util.Scanner;

public class CityTankGame
{
	private static final int BORDERWIDTH = 40;
	private static final int BORDERHEIGHT = 80;
	
	
	
  public static void main(String[] args)
  {
    //Create a scanner to take user input
    Scanner keyboard = new Scanner(System.in);

    //Create a player tank
    Tank playerTank = new Tank(35, 38);
    playerTank.setColor(Color.ANSI_RED);

    //Create a few enemy tanks
    Tank enemyTank1 = new Tank(5, 20, Commands.Direction.DOWN);
    Tank enemyTank2 = new Tank(5, 60, Commands.Direction.RIGHT);
    
    Bullet playerTankBullet = new Bullet(25, 40, 10, 1);
    Bullet enemyTank1Bullet = new Bullet(10, 22, 10, 1);
    Bullet enemyTank2Bullet = new Bullet(7, 65, 1, 10);
    
    

    Stone stone1 = new Stone(10, 20);
    Stone stone2 = new Stone(12, 20);
    Stone stone3 = new Stone(30, 38);
    Stone stone4 = new Stone(30, 40);
    Stone stone5 = new Stone(32, 36);

    //Create the main renderer and add player tank, bullet and stone
    Renderer mainRenderer = new Renderer(BORDERHEIGHT, BORDERWIDTH);
    mainRenderer.addTank(playerTank);
    mainRenderer.addTank(enemyTank1);
    mainRenderer.addTank(enemyTank2);
    
    mainRenderer.addBullet(playerTankBullet);
    mainRenderer.addBullet(enemyTank1Bullet);
    mainRenderer.addBullet(enemyTank2Bullet);   
    
    mainRenderer.addStone(stone1);
    mainRenderer.addStone(stone2);
    mainRenderer.addStone(stone3);
    mainRenderer.addStone(stone4);
    mainRenderer.addStone(stone5);
    

    //The main game loop
    do
    {
      //Clear the screen
      Commands.clearScreen();

      //Re-render the game screen
      mainRenderer.render();

      //Get user command
      System.out.println("Control your tank by typing a character and press Enter. ");
      System.out.println("W: up, A: left, S: right, Z: down, Q: quit the game.");
      String tempString = keyboard.next();
      char option = Character.toLowerCase(tempString.charAt(0));

      //Quit the game if Q is pressed
      if (option == 'q') break;

      //Control the player tank
      switch (option)
      {
        case 'w':
          playerTank.move(Commands.Direction.UP, mainRenderer);
          
          break;
        case 'z':
          playerTank.move(Commands.Direction.DOWN, mainRenderer);
          
          break;
        case 'a':
          playerTank.move(Commands.Direction.LEFT, mainRenderer);
          
          break;
        case 's':
          playerTank.move(Commands.Direction.RIGHT, mainRenderer);
          
          break;
        default:
          //do nothing
          break;
      }
    }  while (true);
    keyboard.close();
  }
}
