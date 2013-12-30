package rs.vicko.minesweeper;

import java.util.ArrayList;
import java.util.Collections;

import org.apache.log4j.Logger;
import org.junit.Test;

public class MinesweeperTest
{
	private static Logger logger = Logger.getLogger(MinesweeperTest.class);

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

	@Test
	public void testGenerateTargetHint()
	{

		Minesweeper minesweeper = new MinesweeperImpl();
		logger.debug("Start test testCallMeProcess...");
		Target target = new Target();
		target.setxDim(10);
		target.setyDim(10);
		target.setFlags(new ArrayList<Flag>());
		target.getFlags().add(new Flag(0, 1));
		target.getFlags().add(new Flag(0, 2));
		target.getFlags().add(new Flag(0, 3));
		target.getFlags().add(new Flag(1, 1));

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
