package tests;

import org.junit.jupiter.api.Test;

import gameEngine.*;
import levelPieces.*;

public class TestMovingPieces {
	
	/*
	 * Testing tiger's movement behavior
	 * Expected behavior:
	 * 		when more than 3 away from player, move 1 spot towards player
	 * 		when three or less, kill player (interaction)
	 * 		because interaction happens here, movement should NOT
	 */
	@Test
	public void testTigerMovement() {
		
		//initialize board
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		int playerLoc;
		int tiggyLoc;
		
		/*
		 * Have player start on right side, tiger on left
		 */
		Tiger tiggy = new Tiger(0); //tiggy starts on left
		playerLoc = 19; //player starts on right
		tiggy.move(gameBoard, playerLoc);
		tiggyLoc = tiggy.getLocation();
		assert(tiggyLoc == 1); //test if tiger has moved right (correct behavior)
		
		/*
		 * Have player start on right side, tiger on right
		 */
		tiggy.setLocation(19); //tiggy starts on right
		playerLoc = 19; //player starts on right
		tiggy.move(gameBoard, playerLoc);
		tiggyLoc = tiggy.getLocation();
		assert(tiggyLoc == 19); //test if tiger hasn't moved (correct behavior)
		
		/*
		 * Have player start on left side, tiger on left
		 */
		tiggy.setLocation(0); //tiggy starts on left
		playerLoc = 0; //player starts on right
		tiggy.move(gameBoard, playerLoc);
		tiggyLoc = tiggy.getLocation();
		assert(tiggyLoc == 0); //test if tiger hasn't moved (correct behavior)
		
		/*
		 * Have player start on left side, tiger on right
		 */
		tiggy.setLocation(19); //tiggy starts on right
		playerLoc = 0; //player starts on right
		tiggy.move(gameBoard, playerLoc);
		tiggyLoc = tiggy.getLocation();
		assert(tiggyLoc == 18); //test if tiger has moved left (correct behavior)
		
	}
	
	/*
	 * Testing bull movement type
	 * Expected movement behavior:
	 * 		if direction is 'L', move left 1
	 * 		if direction is 'R', move right 1
	 * 		if direction other char, don't move
	 */
	@Test
	public void testBullMovement() {
		
		//initialize board
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		int playerLoc;
		
		/*
		 * Testing 'L' [Left] Bull movement
		 */
		Bull lefty = new Bull(19,'L'); //Bull starts on right side
		playerLoc = 0; //player starts on left side
		
		//Move left 5 times
		for (int i = 0; i < 5; i++) {
			lefty.move(gameBoard, playerLoc);
		}
		
		//Assert LEFTY has moved to position 14
		assert (lefty.getLocation() == 14);
		
		/*
		 * Testing 'R' [Right] Bull movement
		 */
		Bull righty = new Bull(0,'R'); //Bull starts on left side
		playerLoc = 19; //player starts on right side
		
		//Move right 5 times
		for (int i = 0; i < 5; i++) {
			righty.move(gameBoard, playerLoc);
		}
		
		//Assert RIGHTY has moved to position 5
		assert (righty.getLocation() == 5);
		
		/*
		 * Testing '*' [No Move] Bull movement
		 */
		char [] bad_chars = {'a', 'A', 'f', 'Z', 'q', 'l', 'r'};
		playerLoc = 0; //player starts on left
		
		for (char c: bad_chars) { //test all bad characters
			Bull lazy = new Bull(9, c); //bull starts in middle
			
			// "move" 5 times
			for (int i = 0; i < 5; i++) {
				lazy.move(gameBoard, playerLoc);
			}
			
			//assert Lazy Bull has stayed put
			assert (lazy.getLocation() == 9);
		}
	}
}
