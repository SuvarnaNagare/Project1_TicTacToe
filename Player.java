package tictactoe;

public class Player {
	
	private String name;
	private char symbol;
	
	public Player(String name,char symbol) {
		this.name=name;
		this.symbol=symbol;
		
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getSymbol() {
		return this.symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
	
	public void printDetails() {
		System.out.println("\nName of the player : "+name);
		System.out.println("Symbol : "+symbol+"\n");
	}
	
}
