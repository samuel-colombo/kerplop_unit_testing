package levelPieces;

import java.util.ArrayList;

import gameEngine.Drawable;
import gameEngine.Moveable;

public class LevelSetup {
	private int levelNum;
	private Drawable[] board;
	private ArrayList<Moveable> movingPieces;
	private ArrayList<GamePiece> interactingPieces;
	private int startLoc;

	
	public LevelSetup() {
		super();
		this.levelNum = 0;
		this.movingPieces = new ArrayList<Moveable>();
		this.interactingPieces = new ArrayList<GamePiece>();
		this.startLoc = 0;
		this.board = new Drawable[20];
	}
	
	public void createLevel(int num) {
		if (num==1) this.playLevelOne();
			
	}
	
	public Drawable[] getBoard() {
		return this.board;
	}
	
	public ArrayList<Moveable> getMovingPieces() {
		return this.movingPieces;
	}
	
	public ArrayList<GamePiece> getInteractingPieces() {
		return this.interactingPieces;
	}
	
	public int getPlayerStartLoc() {
		return this.startLoc;
	}
	
	public void playLevelOne() {
		this.levelNum=1;
		this.startLoc=1;
		
		//create Goal
		Goal goal = new Goal(8);
		this.board[8] = goal;
		this.interactingPieces.add(goal);
		
		//create rocks
		this.board[3] = new Rock();
		this.board[19] = new Rock();
		
		//create Bull
		Bull billy = new Bull(15,'L');
		this.board[15] = billy;
		this.interactingPieces.add(billy);
		this.movingPieces.add(billy);
		
		//create Sinkhole
		Sinkhole sandy = new Sinkhole(17);
		this.board[17] = sandy;
		this.interactingPieces.add(sandy);
	}
	
	public void playLevelTwo() {
		this.levelNum=2;
		this.startLoc=10;

		//create Goal
		Goal goal = new Goal(6);
		this.board[6] = goal;
		this.interactingPieces.add(goal);
		
		//create rocks
		this.board[8] = new Rock();
		this.board[3] = new Rock();
		
		
		//create motorcyclist
		Motorcyclist mildred = new Motorcyclist('5');
		this.board[5] = mildred;
		this.interactingPieces.add(mildred);
		this.movingPieces.add(mildred);
		
		//create ninja
		Ninja ned = new Ninja(19);
		this.board[19] = ned;
		this.interactingPieces.add(ned);
		this.movingPieces.add(ned);
		
	}
}
