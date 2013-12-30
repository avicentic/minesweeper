package rs.vicko.minesweeper;

public interface Minesweeper
{
	Target generateTarget(int xDim, int yDim, int flagNumber);

	TargetHint generateTargetHint(Target target);
}
