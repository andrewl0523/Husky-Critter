//Andrew Liu
//Programming Assignment 10
//Create a husky
//Husky
//Version 1.0
//3/6/2013
import java.util.*;
import java.awt.*;
public class Husky_liu2 extends Critter
{
/**
* int moveCounter is counting how many moves have been made
*/
	private int moveCounter;
/**
* int eatCounter is counting how many moves have been made since the last attack
*/
	private int eatCounter;
/**
* int lastMove is the direction the husky last moved in
*/
	private int lastMove;
/**
* Attack a is the last attack
*/
	private boolean mated;
	private Attack a;
	private static Attack lastAttack;
	private static ArrayList<Attack> antAttacks = new ArrayList<Attack>();
	private static ArrayList<Attack> birdAttacks	= new ArrayList<Attack>();
	private static ArrayList<Attack> stoneAttacks = new ArrayList<Attack>();
	private static ArrayList<Attack> hippoAttacks = new ArrayList<Attack>();
	private static ArrayList<Attack> zhippoAttacks = new ArrayList<Attack>();
	private static ArrayList<Attack> huskyAttacks	= new ArrayList<Attack>();
	private static ArrayList<Attack> badantAttacks = new ArrayList<Attack>();
	private static ArrayList<Attack> badbirdAttacks	= new ArrayList<Attack>();
	private static ArrayList<Attack> badstoneAttacks = new ArrayList<Attack>();
	private static ArrayList<Attack> badhippoAttacks = new ArrayList<Attack>();
	private static ArrayList<Attack> badzhippoAttacks = new ArrayList<Attack>();
	private static ArrayList<Attack> badhuskyAttacks	= new ArrayList<Attack>();
	private static String lastOpponent;
	private static int antPounce = 0;
	private static int antRoar = 0;
	private static int antScratch = 0;
	private static int birdPounce = 0;
	private static int birdRoar = 0;
	private static int birdScratch = 0;
	private static int stonePounce = 0;
	private static int stoneRoar = 0;
	private static int stoneScratch = 0;
	private static int zhippoPounce = 0;
	private static int zhippoRoar = 0;
	private static int zhippoScratch = 0;
	private static int hippoPounce = 0;
	private static int hippoRoar = 0;
	private static int hippoScratch = 0;
	private static int huskyPounce = 0;
	private static int huskyRoar = 0;
	private static int huskyScratch = 0;
	private int check = 5;
/**
* String appearance is the husky's current appearance
*/
	private String appearance;
/**
* boolean aggressive is whether or not the husky will act aggressively
*/
	private boolean aggressive;
/**
* boolean invisible is whether or not the husky will be "invisible"
*/
	private boolean invisible;
/**
* Constructor
* no parameters
*/
	public Husky_liu2()
	{
		invisible = false;
		aggressive = true;
		lastMove = 0;
		mated = false;
	}
/**
* fight determines what attack the husky will use, which will beat all standard animals
* @param String opponent is the appearance of the opponent
* @return Attack is the Attack which has been selected
*/
	public Attack fight(String opponent)
	{
		lastOpponent = opponent;
// 		Random rrr = new Random();//random object for random attacks
// 		if(moveCounter < 150)
// 		{
// 			if(opponent.equals("S"))
// 			{
// 				return Attack.POUNCE;
// 			}
// 			else if(opponent.equals("%"))
// 			{
// 				return Attack.ROAR;
// 			}
// 			else if(opponent.equals(">")||opponent.equals("^")||opponent.equals("<")||opponent.equals("V"))
// 			{
// 					return Attack.SCRATCH;
// 			}
// 			else if(opponent.equals("0")||opponent.equals("1")||opponent.equals("2")||opponent.equals("3")||opponent.equals("4")||opponent.equals("5")||opponent.equals("6")||opponent.equals("7")||opponent.equals("8")||opponent.equals("9"))
// 			{
// 				if(opponent.equals("0"))
// 				{
// 					return Attack.SCRATCH;
// 				}
// 				else
// 				{
// 					return Attack.ROAR;
// 				}
// 			}
// 			else
// 			{
// 				int attack = rrr.nextInt(3) + 1;
// 				if(attack == 1)
// 				{
// 					return Attack.ROAR;
// 				}
// 				else if(attack == 2)
// 				{
// 					return Attack.POUNCE;
// 				}
// 				else if(attack == 3)
// 				{
// 					return Attack.SCRATCH;
// 				}
// 			}
// 
// 		}
// 		else
// 		{
			lastOpponent = opponent;
			int i = 0;
			int limit = check;
			if(opponent.equals("%"))
			{
				i = 0;
				if(antAttacks.size() == 0)
				{
					return Attack.ROAR;
				}
				else if(antAttacks.size()<check)
				{
					limit = antAttacks.size()-1;
				}
				for(i = 0; i <= limit-1; i++)
				{
					if(antAttacks.get(i) == Attack.POUNCE)
					{
						antPounce++;
					}
					else if(antAttacks.get(i) == Attack.ROAR)
					{
						antRoar++;
					}
					else if(antAttacks.get(i) == Attack.SCRATCH)
					{
						antScratch++;
					}
				}
				if(antPounce >= antRoar && antPounce >= antScratch)
				{
					lastOpponent = opponent;
					lastAttack = Attack.POUNCE;
					return Attack.POUNCE;
				}
				else if(antScratch >= antRoar && antScratch >= antPounce)
				{
					lastOpponent = opponent;
					lastAttack = Attack.SCRATCH;
					return Attack.SCRATCH;
				}
				else
				{
					lastOpponent = opponent;
					lastAttack = Attack.ROAR;
					return Attack.ROAR;
				}
			}
			else if(opponent.equals("^")||opponent.equals(">")||opponent.equals("<")||opponent.equals("V"))
			{
				i = 0;
				if(birdAttacks.size() == 0)
				{
					return Attack.SCRATCH;
				}
				else if(birdAttacks.size()<check)
				{
					limit = birdAttacks.size()-1;
				}
				for(i = 0; i <= limit-1; i++)
				{
					if(birdAttacks.get(i) == Attack.POUNCE)
					{
						birdPounce++;
					}
					else if(birdAttacks.get(i) == Attack.ROAR)
					{
						birdRoar++;
					}
					else if(birdAttacks.get(i) == Attack.SCRATCH)
					{
						birdScratch++;
					}
				}
				if(birdPounce >= birdRoar && birdPounce >= birdScratch)
				{
					lastOpponent = opponent;
					lastAttack = Attack.POUNCE;
					return Attack.POUNCE;
				}
				else if(birdScratch >= birdRoar && birdScratch >= birdPounce)
				{
					lastOpponent = opponent;
					lastAttack = Attack.SCRATCH;
					return Attack.SCRATCH;
				}
				else
				{
					lastOpponent = opponent;
					lastAttack = Attack.ROAR;
					return Attack.ROAR;
				}
			}
			else if(opponent.equals("S"))
			{
				i = 0;
				if(stoneAttacks.size() == 0)
				{
					return Attack.POUNCE;
				}
				else if(stoneAttacks.size()<check)
				{
					limit = stoneAttacks.size()-1;
				}
				for(i = 0; i <= limit-1; i++)
				{
					if(stoneAttacks.get(i) == Attack.POUNCE)
					{
						stonePounce++;
					}
					else if(stoneAttacks.get(i) == Attack.ROAR)
					{
						stoneRoar++;
					}
					else if(stoneAttacks.get(i) == Attack.SCRATCH)
					{
						stoneScratch++;
					}
				}
				if(stonePounce >= stoneRoar && stonePounce >= stoneScratch)
				{
					lastOpponent = opponent;
					lastAttack = Attack.POUNCE;
					return Attack.POUNCE;
				}
				else if(stoneScratch >= stoneRoar && stoneScratch >= stonePounce)
				{
					lastOpponent = opponent;
					lastAttack = Attack.SCRATCH;
					return Attack.SCRATCH;
				}
				else
				{
					lastOpponent = opponent;
					lastAttack = Attack.ROAR;
					return Attack.ROAR;
				}
	
			}
			else if(opponent.equals("0"))
			{
				i = 0;
				if(zhippoAttacks.size() == 0)
				{
					return Attack.SCRATCH;
				}
				else if(zhippoAttacks.size()<check)
				{
					limit = zhippoAttacks.size()-1;
				}
				for(i = 0; i <= limit-1; i++)
				{
					if(zhippoAttacks.get(i) == Attack.POUNCE)
					{
						zhippoPounce++;
					}
					else if(zhippoAttacks.get(i) == Attack.ROAR)
					{
						zhippoRoar++;
					}
					else if(zhippoAttacks.get(i) == Attack.SCRATCH)
					{
						zhippoScratch++;
					}
				}
				if(zhippoPounce >= zhippoRoar && zhippoPounce >= zhippoScratch)
				{
					lastOpponent = opponent;
					lastAttack = Attack.POUNCE;
					return Attack.POUNCE;
				}
				else if(zhippoScratch >= zhippoRoar && zhippoScratch >= zhippoPounce)
				{
					lastOpponent = opponent;
					lastAttack = Attack.SCRATCH;
					return Attack.SCRATCH;
				}
				else
				{
					lastOpponent = opponent;
					lastAttack = Attack.ROAR;
					return Attack.ROAR;
				}
			}
			else if(opponent.equals("1")||opponent.equals("2")||opponent.equals("3")||opponent.equals("4")||opponent.equals("5")||opponent.equals("6")||opponent.equals("7")||opponent.equals("8")||opponent.equals("9"))
			{
				i = 0;
				if(hippoAttacks.size() == 0)
				{
					return Attack.ROAR;
				}
				else if(hippoAttacks.size()<check)
				{
					limit = hippoAttacks.size()-1;
				}
				for(i = 0; i <= limit-1; i++)
				{
					if(hippoAttacks.get(i) == Attack.POUNCE)
					{
						hippoPounce++;
					}
					else if(hippoAttacks.get(i) == Attack.ROAR)
					{
						hippoRoar++;
					}
					else if(hippoAttacks.get(i) == Attack.SCRATCH)
					{
						hippoScratch++;
					}
				}
				if(hippoPounce >= hippoRoar && hippoPounce >= hippoScratch)
				{
					lastOpponent = opponent;
					lastAttack = Attack.POUNCE;
					return Attack.POUNCE;
				}
				else if(hippoScratch >= hippoRoar && hippoScratch >= hippoPounce)
				{
					lastOpponent = opponent;
					lastAttack = Attack.SCRATCH;
					return Attack.SCRATCH;
				}
				else
				{
					lastOpponent = opponent;
					lastAttack = Attack.ROAR;
					return Attack.ROAR;
				}
			}
			else
			{
				i = 0;
				if(huskyAttacks.size() == 0)
				{
					return Attack.ROAR;
				}
				else if(huskyAttacks.size()<check)
				{
					limit = huskyAttacks.size()-1;
				}
				for(i = 0; i <= limit-1; i++)
				{
					if(huskyAttacks.get(i) == Attack.POUNCE)
					{
						huskyPounce++;
					}
					else if(huskyAttacks.get(i) == Attack.ROAR)
					{
						huskyRoar++;
					}
					else if(huskyAttacks.get(i) == Attack.SCRATCH)
					{
						huskyScratch++;
					}
				}
				if(huskyPounce >= huskyRoar && huskyPounce >= huskyScratch)
				{
					lastOpponent = opponent;
					lastAttack = Attack.POUNCE;
					return Attack.POUNCE;
				}
				else if(huskyScratch >= huskyRoar && huskyScratch >= huskyPounce)
				{
					lastOpponent = opponent;
					lastAttack = Attack.SCRATCH;
					return Attack.SCRATCH;
				}
				else
				{
					lastOpponent = opponent;
					lastAttack = Attack.ROAR;
					return Attack.ROAR;
				}
			}
//		}
//		return null;
	}
/**
* getColor gets the color of the husky
* no parameters
* @return Color is the color of the husky
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
		return " ";
	}
/**
* eat returns whether or not to eat
* no parameters
* @return boolean is whether or not the animal will eat
*/
	public boolean eat()
	{
 		boolean hEat = false;
 		if(eatCounter < 4)//eat if less than 4 moves since an attack
 		{
 			hEat = true;
 		}
 		if(moveCounter > 300)//always eat after 300 moves
 		{
 			hEat = true;
 		}
 		return hEat;
	}
/**
* getMove determines which direction the animal will move in.
* no parameters
* @return Direction is the direction the animal will move in
*/
	public Direction getMove()
	{
// 		if(moveCounter < 200)
// 		{
// 			return Direction.WEST;
// 		}
// 		else
// 		{
			String north = super.getNeighbor(Direction.NORTH);
			String east = super.getNeighbor(Direction.EAST);
			String south = super.getNeighbor(Direction.SOUTH);
			String west = super.getNeighbor(Direction.WEST);
			Random rr = new Random();
			int direct = 0;
			if(!mated)
			{
				if(super.getX()>super.getY() && super.getX()>4)
				{
					return Direction.WEST;
				}
				else if(super.getY()>0)
				{
					return Direction.NORTH;
				}
				else if(super.getX()<super.getY())
				{
					return Direction.EAST;
				}
				else
				{
					return Direction.SOUTH;
				}
			}
			else
			{
				if(north.equals("."))//after 300 moves, eats as much as it can
				{
					lastMove = 1;
					return Direction.NORTH;
				}
				else if(east.equals("."))
				{
					lastMove = 2;
					return Direction.EAST;
				}
				else if(south.equals("."))
				{
					lastMove = 3;
					return Direction.SOUTH;
				}
				else if(west.equals("."))
				{
					lastMove = 4;
					return Direction.WEST;
				}
				else
				{
					direct = rr.nextInt(4) + 1;
					if(direct == 1)
					{
						lastMove = 1;
						return Direction.NORTH;
					}
					if(direct == 2)
					{
						lastMove = 2;
						return Direction.EAST;
					}
					if(direct == 3)
					{
						lastMove = 3;
						return Direction.SOUTH;
					}
					if(direct == 4)
					{
						lastMove = 4;
						return Direction.WEST;
					}
				}
// 			}

		}
		
		moveCounter++;
		eatCounter++;
		return Direction.EAST;
	}
	public void mateEnd()
	{
		mated = true;
	}
	public void win()
	{
		if(lastOpponent.equals("%"))
		{
			antAttacks.add(0,lastAttack);
		}
		else if(lastOpponent.equals("^")||lastOpponent.equals(">")||lastOpponent.equals("<")||lastOpponent.equals("V"))
		{
			birdAttacks.add(0,lastAttack);
		}
		else if(lastOpponent.equals("S"))
		{
			stoneAttacks.add(0,lastAttack);
		}
		else if(lastOpponent.equals("0"))
		{
			zhippoAttacks.add(0,lastAttack);
		}
		else if(lastOpponent.equals("1")||lastOpponent.equals("2")||lastOpponent.equals("3")||lastOpponent.equals("4")||lastOpponent.equals("5")||lastOpponent.equals("6")||lastOpponent.equals("7")||lastOpponent.equals("8")||lastOpponent.equals("9"))
		{
			hippoAttacks.add(0,lastAttack);
		}
		else
		{
			huskyAttacks.add(0,lastAttack);
		}
	}
	public void lose()
	{
		if(lastOpponent.equals("%"))
		{
			if(antAttacks.size()>0)
				antAttacks.remove(lastAttack);
		}
		else if(lastOpponent.equals("^")||lastOpponent.equals(">")||lastOpponent.equals("<")||lastOpponent.equals("V"))
		{
			if(birdAttacks.size()>0)
				birdAttacks.remove(lastAttack);
		}
		else if(lastOpponent.equals("S"))
		{
			if(stoneAttacks.size()>0)
				stoneAttacks.remove(lastAttack);
		}
		else if(lastOpponent.equals("0"))
		{
			if(zhippoAttacks.size()>0)
				zhippoAttacks.remove(lastAttack);
		}
		else if(lastOpponent.equals("1")||lastOpponent.equals("2")||lastOpponent.equals("3")||lastOpponent.equals("4")||lastOpponent.equals("5")||lastOpponent.equals("6")||lastOpponent.equals("7")||lastOpponent.equals("8")||lastOpponent.equals("9"))
		{
			if(hippoAttacks.size()>0)
				hippoAttacks.remove(lastAttack);
		}
		else
		{
			if(huskyAttacks.size()>0)
				huskyAttacks.remove(lastAttack);
		}

	}
}