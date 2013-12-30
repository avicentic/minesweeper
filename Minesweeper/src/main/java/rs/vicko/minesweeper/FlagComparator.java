package rs.vicko.minesweeper;

import java.util.Comparator;

public class FlagComparator implements Comparator<Flag>
{

	@Override
	public int compare(Flag o1, Flag o2)
	{
		return (o1.getY() + 2 ^ 32 * o1.getX()) - (o2.getY() + 2 ^ 32 * o2.getX());
	}

}
