package rs.vicko.minesweeper;

import java.util.List;

public class Target
{
	private int xDim;
	private int yDim;
	private List<Flag> flags;

	public Target()
	{
		super();
	}

	public Target(int xDim, int yDim, List<Flag> flags)
	{
		super();
		this.xDim = xDim;
		this.yDim = yDim;
		this.flags = flags;
	}

	public int getxDim()
	{
		return xDim;
	}

	public void setxDim(int xDim)
	{
		this.xDim = xDim;
	}

	public int getyDim()
	{
		return yDim;
	}

	public void setyDim(int yDim)
	{
		this.yDim = yDim;
	}

	public List<Flag> getFlags()
	{
		return flags;
	}

	public Flag getFlag(int x, int y)
	{
		for (Flag flag : flags)
		{
			if (flag.getX() == x && flag.getY() == y)
			{
				return flag;
			}
		}

		return null;
	}

}
