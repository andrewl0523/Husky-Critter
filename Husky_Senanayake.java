import java.awt.Color;
import java.awt.Point;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.Random;



public class Husky_Senanayake extends Critter {
	private boolean hasMated = false;
	public boolean isMating = false;
	private boolean isSleeping = false;
	private int turnCount = 0;
	private static final int MOVESTOEVADE = 70;
	private static ArrayList<String> enemyTypes = new ArrayList<String>();
	private static ArrayList<Attack> enemyMoves = new ArrayList<Critter.Attack>();
	private static final int DECAYSIZE = 7;
	private String lastFought;
	private static Attack myLastAttack;
	private static ArrayList<Husky_Senanayake> huskies = new ArrayList<Husky_Senanayake>();
	public Husky_Senanayake() {
		huskies.add(this);
	}
	@Override
	public void sleep() {
		isSleeping = true;
	}
	@Override
	public void wakeup() {
		isSleeping = false;
	}
	public Point getCoordinates() {
		return new Point(getX(), getY());
	}
	@Override
	public void lose() {
		if(lastFought != null && !isMating && !isSleeping)
		{
			enemyTypes.add(lastFought);
			 if (lastFought.matches("^|V|<|>"))
			{
				enemyTypes.add("^");
				enemyTypes.add("V");
				enemyTypes.add("<");
				enemyTypes.add(">");

			}
			else if (lastFought.matches("^[1-9][0-9]*$"))
			{
				for (int i = 1; i<10; i++)
				{
					enemyTypes.add(i + "");
				}
			}
			else
			{
				enemyTypes.add(lastFought);
			}
		}
		if (myLastAttack != null && !isMating && !isSleeping)
		{
			addEnemyMove (myLastAttack);
		}
	}
	private static void addEnemyMove(Attack lastMove) {
		Attack enemyMove = getWinningMove(lastMove);
		
		if (enemyMove != null)
		{
			enemyMoves.add(enemyMove);
			if (enemyMoves.size() > DECAYSIZE)
			{
				enemyMoves.remove(0);
			}
		}
	}
	private static Attack getWinningMove(Attack enemyAttack)
	{
		switch (enemyAttack)
		{
		case ROAR: return Attack.POUNCE;
		case POUNCE: return Attack.SCRATCH;
		case SCRATCH: return Attack.ROAR;
		}
		return null;
	}
	private static Attack getBestMove()
	{
		int roarCounter = 0;
		int pounceCounter = 0;
		int scratchCounter = 0;
		for (Attack attack : enemyMoves)
		{
			switch (attack)
			{
			case ROAR: roarCounter++; break;
			case POUNCE: pounceCounter++; break;
			case SCRATCH: scratchCounter++; break;
			}
		}
		if (roarCounter>=pounceCounter && roarCounter>=scratchCounter)
		{
			return Attack.POUNCE;
		}
		else if (pounceCounter >= roarCounter && pounceCounter >= scratchCounter)
		{
			return Attack.SCRATCH;
		}
		return Attack.ROAR;
		
	}
	@Override
	public void win() {
		lastFought = null;
		myLastAttack = null;

	}
	@Override
	public Attack fight(String opponent) {
		lastFought = opponent;
		if (enemyTypes.contains(opponent))
		{
			return getBestMove();
		}
		if (opponent.equals("%"))
		{
			myLastAttack = Attack.ROAR;
			return Attack.ROAR;
		}
		else if (opponent.matches("^|V|<|>"))
		{
			myLastAttack = Attack.SCRATCH;
			return Attack.SCRATCH;
		}
		else if (opponent.matches("^[1-9][0-9]*$"))
		{
			myLastAttack = Attack.ROAR;
			return Attack.ROAR;
		}
		else if (opponent.equals("0"))
		{
			myLastAttack = Attack.SCRATCH;
			return Attack.SCRATCH;
		}
		else {
			myLastAttack = Attack.POUNCE;
			return Attack.POUNCE;
		}
	}
	@Override
	public boolean eat() {
		if (turnCount < MOVESTOEVADE || isEnemyNearby())
		{
			 return false;
		}
		
		return true;
	}
	public boolean isEnemyNearby()
	{
		for (Direction direction : Direction.values())
		{
			if (direction == Direction.CENTER)
			{
				continue;
			}
			String s = getNeighbor(direction);
			
			if (!(s.equals(" ") || s.equals(".") || isAllyAtDirection(direction)))
			{
				return true;
			}
			
			
		}
		return false;
	}
	private boolean isAllyAtDirection(Direction direction)
	{
		for (Husky_Senanayake husky : huskies)
		{
			if (husky.getCoordinates().equals(getCoordinatesOfDirection(direction)))
			{
				return true;
			}
		}
		return false;
	}
	private boolean isAllyMatingAtDirection (Direction direction)
	{
		for (Husky_Senanayake husky : huskies)
		{
			if (husky.getCoordinates().equals(getCoordinatesOfDirection(direction)))
			{
				if (husky.isMating ==  true)
				{
					return true;
				}
			}
		}
		return false;
	}
	private Point getCoordinatesOfDisplacement(int xDisplacement, int yDisplacement)
	{
		Point point = getCoordinates();
		if (xDisplacement > 0)
		{
			for (int i = 0; i<xDisplacement; i++)
			{
				if (point.x >= getWidth() - 1)
				{
					point.x=0;
					break;
				}
				point.translate(1, 0);
			}
		}
		else if (xDisplacement < 0)
		{
			for (int i = 0; i<xDisplacement; i--)
			{
				if (point.x <= 1)
				{
					point.x=getWidth();
					break;
				}
				point.translate(-1, 0);
			}
		}
		if (yDisplacement > 0)
		{
			for (int i = 0; i<yDisplacement; i++)
			{
				if (point.y >= getHeight() - 1)
				{
					point.y=0;
					break;
				}
				point.translate(0, 1);
			}
			
		}
		else if (yDisplacement < 0)
		{
			for (int i = 0; i<yDisplacement; i--)
			{
				if (point.y <= 1)
				{
					point.y=getHeight();
					break;
				}
				point.translate(0, -1);
			}
		}
		
		return point;
	}
	private Point getCoordinatesOfDirection(Direction direction)
	{
		
		Point point = getCoordinates();
		switch (direction)
		{
		case NORTH: 
			if (point.y <= 1)
			{
				point.y=getHeight();
				break;
			}
			point.translate(0, -1); break;
		case SOUTH: 
			if (point.y >= getHeight() - 1)
			{
				point.y=0;
				break;
			}
			point.translate(0, 1); break;
		case WEST:
			if (point.x <= 1)
			{
				point.x=getWidth();
				break;
			}
			point.translate(-1, 0); break;
		case EAST: 
			if (point.x >= getWidth() - 1)
			{
				point.x=0;
				break;
			}
			point.translate(1, 0); break;

		}
		return point;
	}
	@Override
	public Color getColor() {
		return Color.BLUE;
	}
	@Override
	public Direction getMove() {
		turnCount++;
		if(turnCount < MOVESTOEVADE)
		{
			for (Direction direction : Direction.values())
			{
				if (direction == Direction.CENTER)
				{
					continue;
				}
				String s = getNeighbor(direction);
				if (enemyTypes.contains(s))
				{
					switch (direction)
					{
					case NORTH: return Direction.SOUTH;
					case EAST: return Direction.WEST;
					case SOUTH: return Direction.NORTH;
					default: return Direction.EAST;
					}
				}
				
				
			}
			if(!hasMated)
			{
				int x = getX();
				int y = getY();
				if (x<getWidth()/2 && !isAllyMatingAtDirection(Direction.EAST) && !(isAllyAtDirection(Direction.EAST) && isEnemyNearby()))
				{
					return Direction.EAST;
				}
				else if (x>getWidth()/2 && !isAllyMatingAtDirection(Direction.WEST) && !(isAllyAtDirection(Direction.EAST) && isEnemyNearby()))
				{
					return Direction.WEST;
				}
				else if (y<getHeight()/2 && !isAllyMatingAtDirection(Direction.SOUTH)&& !(isAllyAtDirection(Direction.EAST) && isEnemyNearby()))
				{
					return Direction.SOUTH;
				}
				else if (y>getHeight()/2 && !isAllyMatingAtDirection(Direction.NORTH) && !(isAllyAtDirection(Direction.EAST) && isEnemyNearby()))
				{
					return Direction.NORTH;
				}
				else {
					return Direction.CENTER;
				}
			}
			else {
				return Direction.CENTER;
			}
		}
		
		for (Direction direction : Direction.values())
		{
			if (direction == Direction.CENTER)
			{
				continue;
			}
			String s = getNeighbor(direction);
			if (s.equals("."))
			{
				return direction;
			}
		}
		for (Direction direction : Direction.values())
		{
			if (direction == Direction.CENTER)
			{
				continue;
			}
			String s = getNeighbor(direction);
			if (!s.equals(" ") && !isAllyAtDirection(direction))
			{
				return direction;
			}
		}
			return getRandomDirection();
		
	}
	
	@Override
	public void mateEnd() {
		isMating = false;
		hasMated = true;
	}
	@Override
	public void mate() {
		isMating = true;
	}
	private Direction getRandomDirection()
	{
		Random random = new Random();
		switch(random.nextInt(4))
		{
		case 0: return Direction.NORTH;
		case 1: return Direction.EAST;
		case 2: return Direction.SOUTH;
		default: return Direction.WEST;
		}
	}
	@Override
	public String toString() {
		return (new Random().nextInt(9) + 1) + "" ;
	}
}
