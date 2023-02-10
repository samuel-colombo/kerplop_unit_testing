package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Bull extends GamePiece implements Moveable {
	public char direction;
	
	public Bull(int location, char direction) {
		super('B', "Bull will moves 1 direction and will hurt players in its way.", location);
		this.direction = direction;
	}

	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		int currLoca = this.getLocation();
		// when the set direction is to the Left
		if(direction == 'L' && currLoca != 0) {
			for (int i = 1; i < currLoca; i++) {
				if (gameBoard[currLoca-i] == null) {
					gameBoard[currLoca-i] = this;
					gameBoard[currLoca]=null;
					this.setLocation(currLoca-i);
					break;
				}
			}
		}
		// for set direction is to the Right
		if(direction == 'R' && currLoca != 19) {
			for (int i = 1; i < 20; i++) {
				if (gameBoard[currLoca+i] == null) {
					gameBoard[currLoca+i] = this;
					gameBoard[currLoca]=null;
					this.setLocation(currLoca+i);
					break;
				}
			}
		}
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		int currLoca = this.getLocation();
		if(playerLocation == currLoca+1 && direction == 'R') {
			return InteractionResult.HIT;
		} else if (playerLocation == currLoca-1 && direction == 'L') {
			return InteractionResult.HIT;
		} else {
			return InteractionResult.NONE;
		}
	}
	
	@Override
	public void draw() {
		System.out.print('B');
	}

}
