package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import levelPieces.Bull;
import levelPieces.Motorcyclist;
import levelPieces.Ninja;
import levelPieces.Sinkhole;
import levelPieces.Tiger;

public class TestInteractions {
	/*
	 * pieces with interaction: Bull, Goal, Motorcyclist, Ninja, Sinkhole, Tiger
	 */

	// test if Bull only hit player in front of it, based on its current direction
	@Test
	public void testBull() {
		// create board
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		// create a new Bull and add to board
		Bull billy = new Bull(3, 'R');
		gameBoard[3] = billy;
		// hit player if in front of billy the bull facing Right
		assertEquals(InteractionResult.HIT, billy.interact(gameBoard, 4));
		// loop to ensure no interaction if not in front of
		// back of billy
		for(int i = 0; i < 4; i++) {
			assertEquals(InteractionResult.NONE, billy.interact(gameBoard, i));
		}
		// far from bully
		for(int i = 5; i < GameEngine.BOARD_SIZE; i++) {
			assertEquals(InteractionResult.NONE, billy.interact(gameBoard, i));
		}
		// create another Bull add to board, face a different direction
		Bull jason = new Bull(5, 'L');
		gameBoard[5] = jason;
		// hit player if in front of jason the bull facing Left
		assertEquals(InteractionResult.HIT, jason.interact(gameBoard, 4));
		// more loops to ensure no interaction
		// back of jason
		for(int i = 5; i < GameEngine.BOARD_SIZE; i++) {
			assertEquals(InteractionResult.NONE, jason.interact(gameBoard, i));
		}
		// far from jason
		for(int i = 0; i < 4; i++) {
			assertEquals(InteractionResult.NONE, jason.interact(gameBoard, i));
		}

	}
	// test if Motercyclist only kill the player at the same location
	@Test
	public void testMotorcyclist() {
		// create board
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		// create a new Motercyclist and add to board
		Motorcyclist johnson = new Motorcyclist(3);
		gameBoard[3] = johnson;
		// kill player if in the same space
		assertEquals(InteractionResult.KILL, johnson.interact(gameBoard, 3));
		// loops for ensuring no interaction in other spaces
		for(int i = 0; i < 3; i++) {
			assertEquals(InteractionResult.NONE, johnson.interact(gameBoard, i));
		}
		// far from bully
		for(int i = 4; i < GameEngine.BOARD_SIZE; i++) {
			assertEquals(InteractionResult.NONE, johnson.interact(gameBoard, i));
		}
	}
	// test if Ninja hit player within range of 3
	@Test
	public void testNinjaRange() {
		// create board
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		// create a new ninja and add to board
		Ninja a = new Ninja(7);
		gameBoard[7] = a;
		// loops to check hit players if in range
		for(int i = 4; i < 6; i++) {
			assertEquals(InteractionResult.HIT, a.interact(gameBoard, i));
		}
		for(int i = 9; i < 11; i++) {
			assertEquals(InteractionResult.HIT, a.interact(gameBoard, i));
		}
		// loops to check kill players if in execute reach
		for(int i = 6; i < 9; i++) {
			assertEquals(InteractionResult.KILL, a.interact(gameBoard, i));
		}
		// loops to ensure no interaction out of range
		for(int i = 0; i < 4; i++) {
			assertEquals(InteractionResult.NONE, a.interact(gameBoard, i));
		}
		for(int i = 12; i < GameEngine.BOARD_SIZE; i++) {
			assertEquals(InteractionResult.NONE, a.interact(gameBoard, i));
		}
	}
	// test if Sinkhole kill player within range of 1
	@Test
	public void testSinkhole() {
		// create board
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		// create a new Sinkhole and add to board
		Sinkhole b = new Sinkhole(7);
		gameBoard[7] = b;
		// loop to check kill player if in range
		// loops to check kill players if in execute reach
		for(int i = 6; i < 9; i++) {
			assertEquals(InteractionResult.KILL, b.interact(gameBoard, i));
		}
		// loops to ensure no interaction out of range
		for(int i = 0; i < 6; i++) {
			assertEquals(InteractionResult.NONE, b.interact(gameBoard, i));
		}
		for(int i = 10; i < GameEngine.BOARD_SIZE; i++) {
			assertEquals(InteractionResult.NONE, b.interact(gameBoard, i));
		}
	}
	// test if tiger kill plater within range of 3
	@Test
	public void testTiger() {
		// create board
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		// create a new Tiger and add to board
		Tiger tony = new Tiger(13);
		gameBoard[13] = tony;
		// loop to check if player in range to be kill by tony the Tiger
		for(int i = 10; i < 17; i++) {
			assertEquals(InteractionResult.KILL, tony.interact(gameBoard, i));
		}
		// loops to ensure no interaction outside of tony's range
		for(int i = 0; i < 10; i++) {
			assertEquals(InteractionResult.NONE, tony.interact(gameBoard, i));
		}
		for(int i = 18; i < GameEngine.BOARD_SIZE; i++) {
			assertEquals(InteractionResult.NONE, tony.interact(gameBoard, i));
		}
	}
}
