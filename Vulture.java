//Andrew Liu
//Programming Assignment 10
//Create a vulture
//Vulture
//Version 1.0
//3/6/2013
import java.awt.*;
public class Vulture extends Bird
{
/**
* boolean hunger is whether or not the Vulture wants to eat
*/
	private boolean hunger;
/**
* Constructor
* no parameters
*/
	public Vulture()
	{
		hunger = true;
	}
/**
* fight determines what attack the vulture will use, which is the same as bird
* @param String opponent is the appearance of the opponent
* @return Attack is the Attack which has been selected
*/
	public Attack fight(String opponent)
	{
		hunger = true;
		return super.fight(opponent);//same as bird
	}
/**
* getColor gets the color of the vulture
* no parameters
* @return Color is the color of the vulture
*/
	public Color getColor()
	{
		return Color.BLACK;//always black
	}
/**
* toString returns the appearance of the animal
* no parameters
* @return String is the appearance
*/
	public String toString()
	{
		return super.toString();//same as bird
	}
/**
* eat returns whether or not to eat
* no parameters
* @return boolean is whether or not the animal will eat
*/
	public boolean eat()
	{
		boolean eat = hunger;//gets hungry after a fight or when born
		if(eat)
		{
			hunger = false;
		}
		return eat;
	}
/**
* getMove determines which direction the animal will move in.
* no parameters
* @return Direction is the direction the animal will move in
*/
	public Direction getMove()
	{
		return super.getMove();//same as bird
	}

}