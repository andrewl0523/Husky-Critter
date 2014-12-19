//Andrew Liu
//Programming Assignment 10
//Create an ant
//Ant
//Version 1.0
//3/6/2013
import java.awt.*;
public class Ant extends Critter
{
/**
* boolean walk is whether or not the ant will walk north and west or south and east
*/
	private boolean walk;
/**
* int lastMove is the direction the ant
*/
	private int lastMove;
/**
* Constructor
* @param boolean walkSouth controls which direction the ant will move in
*/
	public Ant(boolean walkSouth)
	{
		if(walkSouth)
		{
			lastMove = 2;
		}
		else
		{
			lastMove = 4;
		}
		walk = walkSouth;
	}
/**
* fight determines what attack the ant will use
* @param String opponent is the appearance of the opponent
* @return Attack is the Attack which has been selected
*/
	public Attack fight(String opponent)//ant always scratches
	{
		return Attack.SCRATCH;
	}
/**
* getColor gets the color of the ant
* no parameters
* @return Color is the color of the ant
*/
	public Color getColor()//ant is always red
	{
		return Color.RED;
	}
/**
* toString returns the appearance of the animal
* no parameters
* @return String is the appearance
*/
	public String toString()//ant's appearance is always "%"
	{
		return "%";
	}
/**
* eat returns whether or not to eat
* no parameters
* @return boolean is whether or not the animal will eat
*/
	public boolean eat()//always eats
	{
		return true;
	}
/**
* getMove determines which direction the animal will move in.
* no parameters
* @return Direction is the direction the animal will move in
*/
	public Direction getMove()
	{
		Direction d = Direction.CENTER;
		if(walk)
		{
			if(lastMove == 2)//moves SE
			{
				d = Direction.SOUTH;
				lastMove = 3;
			}
			else
			{
				d = Direction.EAST;
				lastMove = 2;
			}
		}
		else
		{
			if(lastMove == 4)//moves NW
			{
				d = Direction.NORTH;
				lastMove = 1;
			}
			else
			{
				d = Direction.WEST;
				lastMove = 4;
			}
		}
		return d;
	}
}