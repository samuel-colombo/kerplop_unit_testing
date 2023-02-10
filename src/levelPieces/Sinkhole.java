package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Sinkhole extends GamePiece {

	public Sinkhole(int location) {
		super('S', "Sinkhole: if player moves to a spot adjacent to the sinkhole, it swallows them up (dies)", location);
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		int currLocation = this.getLocation();
		if (Math.abs(currLocation-playerLocation)<=1) return InteractionResult.KILL;
		return InteractionResult.NONE;
	}
}
