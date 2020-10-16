import objects.*;
import graphics.*;
import utilities.*;
import java.util.Scanner;
import java.util.Random;

public class CityTankGame
{
  public static void main(String[] args)
  {
    //Create a scanner to take user input
    Scanner keyboard = new Scanner(System.in);
    Random random = new Random();

    //Create a player tank
    Tank playerTank = new Tank(35, 38);
    playerTank.setColor(Color.ANSI_RED);

    //Create a few enemy tanks
    Tank enemyTank1 = new Tank(5, 20, Commands.Direction.DOWN);
    Tank enemyTank2 = new Tank(5, 60, Commands.Direction.RIGHT);

    //Create the main renderer and add game objects
    Renderer mainRenderer = new Renderer(80, 40);
    mainRenderer.addObject(playerTank);
    mainRenderer.addObject(enemyTank1);
    mainRenderer.addObject(enemyTank2);

    mainRenderer.addObject(new Stone(10, 20));
    mainRenderer.addObject(new Stone(12, 20));
    mainRenderer.addObject(new Stone(30, 38));
    mainRenderer.addObject(new Stone(30, 40));
    mainRenderer.addObject(new Stone(32, 36));

    mainRenderer.addObject(new Brick(20, 50));
    mainRenderer.addObject(new Brick(22, 50));
    mainRenderer.addObject(new Brick(20, 52));
    mainRenderer.addObject(new Brick(22, 52));
    mainRenderer.addObject(new Brick(30, 60));
    mainRenderer.addObject(new Brick(30, 62));


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
        case 'f':
          Bullet newBullet = playerTank.fire();
          mainRenderer.addObject(newBullet);
        default:
          //do nothing
          break;
      }

      //allows enemy tanks to move randomly
      enemyTank1.move(Commands.Direction.values()[random.nextInt(3)], mainRenderer);
      enemyTank2.move(Commands.Direction.values()[random.nextInt(3)], mainRenderer);
    }  while (true);
    keyboard.close();
  }
}
