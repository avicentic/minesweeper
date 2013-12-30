package rs.vicko.minesweeper;

import java.util.Collections;

import org.apache.log4j.Logger;
import org.junit.Test;

public class MinsweeperTest
{
	private static Logger logger = Logger.getLogger(MinsweeperTest.class);

	@Test
	public void testGenerateTarget()
	{

		Minesweeper minesweeper = new MinesweeperImpl();
		logger.debug("Start test testCallMeProcess...");
		Target target = minesweeper.generateTarget(10, 10, 15);

		logger.debug(String.format("Generisano %s flagova", target.getFlags().size()));

		Collections.sort(target.getFlags(), new FlagComparator());

		for (Flag flag : target.getFlags())
		{
			logger.debug(flag);
		}

		TargetHint targetHint = minesweeper.generateTargetHint(target);
		for (int i = 0; i < targetHint.getxDim(); i++)
		{
			String line = "";
			for (int j = 0; j < targetHint.getyDim(); j++)
			{
				line += (targetHint.getHint(i, j).isMine() ? "*" : targetHint.getHint(i, j).getNeighbors()) + " ";
			}
			logger.debug(line);
		}

	}

}
