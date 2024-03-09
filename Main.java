package tictactoe;


public class Main {

	public static void main(String[] args) {
		System.out.println("TIC TAC TOE GAME\n");
		
		Board b=new Board(3);
		//b.printConfiguration();
		
		Player p1=new Player("Ram",'X');
		Player p2=new Player("Sham",'O');
		
		p1.printDetails();
		p2.printDetails();
		
		Game g=new Game(new Player[] {p1,p2},b);
		g.play();
	}

}
