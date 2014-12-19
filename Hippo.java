//Andrew Liu
//Programming Assignment 10
//Create a hippo
//Hippo
//Version 1.0
//3/6/2013
import java.util.*;
import java.awt.*;
public class Hippo extends Critter
{
/**
*int foodLeft is the number of times the hippo will still eat
*/
	private int foodLeft;
/**
* int lastMove is the direction the hippo last moved in
*/
	private int lastMove;
/**
* boolean hungry is whether or not the hippo is hungry
*/
	private boolean hungry;
/**
* int moveCounter is counting how many moves have been made
*/
	private int moveCounter;
/**
* int direction is the direction of movement
*/
	private int direction;
/**
* Constructor
* @param int hunger which controls how much food the hippo will eat
*/
	public Hippo(int hunger)
	{
		if(hunger > 0)//if the hippo is hungry, hungry will be true
		{
			hungry = true;
		}
		else
		{
			hungry = false;
		}
		foodLeft = hunger;
		moveCounter = 6;
		direction = 0;
	}
/**
* fight determines what attack the hippo will use
* @param String opponent is the appearance of the opponent
* @return Attack is the Attack which has been selected
*/
	public Attack fight(String opponent)
	{
		Attack a = Attack.POUNCE;
		if(foodLeft > 0)//hippo will scratch if it is hungry, else it will pounce
		{
			a = Attack.SCRATCH;			
		}
		return a;
	}
/**
* getColor gets the color of the hippo which is gray if it is hungry and white otherwise
* no parameters
* @return Color is the color of the hippo
*/
	public Color getColor()
	{
		Color color = Color.WHITE;//if not hungry, color is white
		if(foodLeft > 0)
		{
			color = Color.GRAY;//color is gray if it is hungry
		}
		return color;
	}
/**
* toString returns the appearance of the animal
* no parameters
* @return String is the appearance
*/
	public String toString()
	{
		return "" + foodLeft;//appearance is hunger level
	}
/**
* eat returns whether or not to eat
* no parameters
* @return boolean is whether or not the animal will eat
*/
	public boolean eat()
	{
		if(foodLeft > 0)
		{
			hungry = true;
			foodLeft--;
		}
		else
		{
			hungry = false;
		}
		return hungry;
	}
/**
* getMove determines which direction the animal will move in.
* no parameters
* @return Direction is the direction the animal will move in
*/
	public Direction getMove()
	{
		Direction d = Direction.CENTER;//hippo moves in a random direction for five turns
		Random r = new Random();
		if(moveCounter > 5)
		{
			moveCounter = 1;
			direction = r.nextInt(4) + 1;
		}
		if(direction == 1)
		{
			d = Direction.NORTH;
		}
		if(direction == 2)
		{
			d = Direction.EAST;
		}
		if(direction == 3)
		{
			d = Direction.SOUTH;
		}
		if(direction == 4)
		{
			d = Direction.WEST;
		}
		moveCounter++;
		return d;
	}
}