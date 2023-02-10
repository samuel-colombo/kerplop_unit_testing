package levelPieces;

import java.util.Random;
import java.util.concurrent.ConcurrentSkipListSet;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Motorcyclist extends GamePiece implements Moveable{


	public Motorcyclist(int location) {
		super('M', "Motorcyclist moves either right or left (random), will kill player if they are on the same spot.", location);
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		int currLocation = this.getLocation();
		if(currLocation==playerLocation) return InteractionResult.KILL;
		return InteractionResult.NONE;
	}

	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		boolean hit_left = false;
		boolean hit_right = false;
		int currLocation = this.getLocation();
		//Random left or right (0 or 1)
		Random rand = new Random();
		int direction = (int) (Math.round(Math.random()));
		System.out.println(direction);
		//move left if 0, else move right
		//if left and not in first spot
		if (direction==0 && currLocation!=0) {
			gameBoard[currLocation-1]=this;
			gameBoard[currLocation]=null;
			this.setLocation(currLocation-1); 
			//else if going right and not at end
		} else if (currLocation!=19){
			gameBoard[currLocation+1]=this;
			gameBoard[currLocation]=null;
			this.setLocation(currLocation+1); 
		}
		return;
	}
	@Override
	public void draw() {
		System.out.print('M');
	}

}