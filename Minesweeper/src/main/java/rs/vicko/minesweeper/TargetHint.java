package rs.vicko.minesweeper;

import java.util.List;

public class TargetHint
{
	private int xDim;
	private int yDim;
	private List<Hint> hints;

	public TargetHint()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public TargetHint(int xDim, int yDim, List<Hint> hints)
	{
		super();
		this.xDim = xDim;
		this.yDim = yDim;
		this.hints = hints;
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

	public List<Hint> getHints()
	{
		return hints;
	}

	public void setHints(List<Hint> hints)
	{
		this.hints = hints;
	}

	public Hint getHint(int x, int y)
	{
		for (Hint hint : hints)
		{
			if (hint.getX() == x && hint.getY() == y)
			{
				return hint;
			}
		}
		return null;
	}

}
