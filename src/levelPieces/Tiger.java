package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Tiger extends GamePiece implements Moveable{


	public Tiger(int location) {
		super('T', "Tiger moves 1 space at a time, unless player is within 3, then the tiger will leap and kill player.", location);
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		int currLocation = this.getLocation();
	
		if (Math.abs(currLocation-playerLocation) <= 3) {
			return InteractionResult.KILL;
		} else return InteractionResult.NONE;
	}

	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		int currLocation = this.getLocation();
		//if walking
		if (Math.abs(currLocation-playerLocation) > 3) {
			if (playerLocation < currLocation) {
				for (int i = 1; i < currLocation; i++)
					if (gameBoard[currLocation-i] == null) {
						gameBoard[currLocation-i]=this;
						this.setLocation(currLocation-i);
						gameBoard[currLocation]=null;
						break;
					}
			} else {
				for (int i = 1; i < 20-currLocation; i++)
					if (gameBoard[currLocation+i] == null) {
						gameBoard[currLocation+i]=this;
						this.setLocation(currLocation+i);
						gameBoard[currLocation]=null;
						break;
					}
			}
		}
	}
	@Override
	public void draw() {
		System.out.print('T');
	}

}
