package rs.vicko.minesweeper;

public class Hint
{
	private int x;
	private int y;
	private int neighbors;
	private boolean mine;

	public Hint()
	{
		super();
	}

	public Hint(int x, int y, int neighbors, boolean mine)
	{
		super();
		this.x = x;
		this.y = y;
		this.neighbors = neighbors;
		this.mine = mine;
	}

	public int getX()
	{
		return x;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return y;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public int getNeighbors()
	{
		return neighbors;
	}

	public void setNeighbors(int neighbors)
	{
		this.neighbors = neighbors;
	}

	public boolean isMine()
	{
		return mine;
	}

	public void setMine(boolean mine)
	{
		this.mine = mine;
	}

}
