package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;
import java.util.Random;

public class Ninja extends GamePiece implements Moveable{

	public Ninja(int location) {
		super('N', "Ninja will teleport around randomly, will hit player when within 3, will kill player when within 1.", location);
	}

	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		int currLoca = this.getLocation();
		int originLoca = currLoca;
		Random randInt = new Random();
		// loop while either the next random location is at the same spot or the location is already occupied
		while(currLoca == this.getLocation() || gameBoard[currLoca] != null) {
			currLoca = Math.abs(randInt.nextInt() % 20);
		}
		// set new location with the piece
		gameBoard[currLoca] = this;
		this.setLocation(currLoca);
		// set starting point to be empty
		gameBoard[originLoca] = null;
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		int currLoca = this.getLocation();
		// if player is far, throw darts to damage.
		if (Math.abs(currLoca-playerLocation) <= 3) {
			return InteractionResult.HIT;
		// if player is close, execute
		} else if(Math.abs(currLoca-playerLocation) <= 1) {
			return InteractionResult.KILL;
		// if none, do nothing
		} else {
			return InteractionResult.NONE;
		}
	}
	
	@Override
	public void draw() {
		System.out.print('N');
	}

}
