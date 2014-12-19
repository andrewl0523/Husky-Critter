//Andrew Liu
//Programming Assignment 10
//Create a bird
//Bird
//Version 1.0
//3/6/2013
import java.awt.*;
public class Bird extends Critter
{
/**
* int moveCounter is counting how many moves have been made
*/
	private int moveCounter;
/**
* int move controls which direction the bird moves in
*/
	private int move;
/**
* int lastMove is the direction the bird last moved in
*/
	private int lastMove;
/**
* Constructor
* no parameters
*/
	public Bird()
	{
		move = 1;
		lastMove = 1;
		moveCounter = 1;
	}
/**
* fight determines what attack the bird will use
* @param String opponent is the appearance of the opponent
* @return Attack is the Attack which has been selected
*/
	public Attack fight(String opponent)
	{
		Attack a = Attack.POUNCE;
		if(opponent.equals("%"))//roars against ants, otherwise pounces
		{
			a = Attack.ROAR;
		}
		return a;
	}
/**
* getColor gets the color of the bird
* no parameters
* @return Color is the color of the bird
*/
	public Color getColor()
	{
		return Color.BLUE;//always blue
	}
/**
* toString returns the appearance of the animal
* no parameters
* @return String is the appearance
*/
	public String toString()//appearance depends on what direction the bird last moved in
	{
		String s = "";
		if(lastMove == 1)
		{
			s = "^" + "";
		}
		if(lastMove == 2)
		{
			s = ">" + "";
		}
		if(lastMove == 3)
		{
			s = "V" + "";
		}
		if(lastMove == 4)
		{
			s = "<" + "";
		}
		return s;
	}
/**
* eat returns whether or not to eat
* no parameters
* @return boolean is whether or not the animal will eat
*/
	public boolean eat()
	{
		return false;//never eats
	}
/**
* getMove determines which direction the animal will move in.
* no parameters
* @return Direction is the direction the animal will move in
*/
	public Direction getMove()
	{
		if(moveCounter > 3)//moves in a clockwise square
		{
			moveCounter = 1;
			move++;
			if(move > 4)
			{
				move = 1;
			}
		}
		Direction d = Direction.CENTER;
		if(moveCounter <= 3)
		{
			if(move == 1)
			{
				d = Direction.NORTH;
				lastMove = 1;
			}
			if(move == 2)
			{
				d = Direction.EAST;
				lastMove = 2;
			}
			if(move == 3)
			{
				d = Direction.SOUTH;
				lastMove = 3;
			}
			if(move == 4)
			{
				d = Direction.WEST;
				lastMove = 4;
			}
		}
	moveCounter++;
	return d;
	}
}