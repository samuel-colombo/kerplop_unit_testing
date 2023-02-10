package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Goal extends GamePiece {

	public Goal(int location) {
		super('G', "Land on the goal to win the game", location);
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		int currLocation = this.getLocation();
		System.out.println(currLocation);
		if(currLocation==playerLocation) {
			System.out.println("hit"); 
			return InteractionResult.ADVANCE;
		}
		return InteractionResult.NONE;
	}

}
