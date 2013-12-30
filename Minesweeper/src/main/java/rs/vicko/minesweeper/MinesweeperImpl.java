package rs.vicko.minesweeper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import android.annotation.SuppressLint;

public class MinesweeperImpl implements Minesweeper
{
	private static Logger logger = Logger.getLogger(MinesweeperImpl.class);

	@SuppressLint("UseSparseArrays")
	@Override
	public Target generateTarget(int xDim, int yDim, int flagNumber)
	{

		Map<Integer, Flag> ret = new HashMap<Integer, Flag>();

		while (ret.size() < flagNumber)
		{
			int rnd = (int) (Math.random() * (xDim * yDim - ret.size())) + 1;
			logger.debug(String.format("rnd=%s, interval=[1,%s]", rnd, xDim * yDim - ret.size()));
			int index = -1;
			for (int i = 0; i < xDim * yDim; i++)
			{
				index++;
				if (!ret.containsKey(i))
				{
					rnd--;
				}
				if (rnd == 0)
				{
					break;
				}
			}
			logger.debug(String.format("index=%s", index));
			logger.debug(String.format("Generated %s, [%s, %s]", index, index / xDim, index % xDim));
			ret.put(index, new Flag(index / xDim, index % xDim));
		}

		return new Target(xDim, yDim, new ArrayList<Flag>(ret.values()));

	}

	@Override
	public TargetHint generateTargetHint(Target target)
	{

		TargetHint ret = new TargetHint(target.getxDim(), target.getyDim(), new ArrayList<Hint>());

		for (int i = 0; i < target.getxDim(); i++)
		{
			for (int j = 0; j < target.getyDim(); j++)
			{
				int neighbors = 0;
				boolean mine = (target.getFlag(i, j) != null) ? true : false;

				for (int ii = i - 1; ii <= i + 1; ii++)
				{
					for (int jj = j - 1; jj <= j + 1; jj++)
					{
						if (ii != jj && target.getFlag(ii, jj) != null)
						{
							neighbors++;
						}
					}
				}

				ret.getHints().add(new Hint(i, j, neighbors, mine));
			}
		}

		return ret;
	}
}
