package levelPieces;

import gameEngine.Drawable;

public class Rock implements Drawable{

	private String label;
	private char symbol;

	public Rock() {
		super();
		this.label = "Rock, just sits there and does nothing.";
		this.symbol = 'R';
	}
	
	@Override
	public void draw() {
		System.out.print('R');
	}
	
	@Override
	public String toString() {
		return symbol + " - " + label;
	}
	
	

}
