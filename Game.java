package tictactoe;
import java.util.Scanner;

public class Game {
	
	Player player[];
	Board board;
	int noOfMoves;
	int turn;
	boolean res;
	String zero,cross;
	
	public Game(Player player[], Board board ) {
	    this.player=player;
		this.board=board;
		this.turn=0;
		this.noOfMoves=0;
		this.res=false;
		
		StringBuilder z=new StringBuilder();
		StringBuilder c=new StringBuilder();
		
		for(int i=0;i<board.size;i++) {
			z.append('O');
			c.append('X');
		}
		
		this.zero=z.toString();
		this.cross=c.toString();
		
	}
	
	public void printConfiguration() {
		for(int i=0;i<board.size;i++) {
			for(int j=0;j<board.size;j++) {
				System.out.print(board.mat[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public void play() {
		
		printConfiguration();
		
		while(!res) {
			
		noOfMoves++;
		
		int idx=getIndex();
		
		int row=idx/board.size;
		int col=idx%board.size;
		
		board.mat[row][col]=player[turn].getSymbol();
		
		if(noOfMoves>=board.size*board.size) {
			System.out.println("Game Draw");
			return;
		}
		
		if(noOfMoves >=2*board.size-1 && check()==true) {
			res=true;
			printConfiguration();
			System.out.println("winner is : "+player[turn].getName());
			return;
		}
		
		
		turn =(turn+1)%2;
		printConfiguration();
		
		}
		
	}
	
	
	
	public int getIndex() {
		
		
		while(true) {
			System.out.println("Player : "+player[turn].getName()+" give a position");
			Scanner sc=new Scanner(System.in);
			int pos=sc.nextInt()-1;
			
			int sz=board.size;
			
			int row=pos/sz;
			int col=pos%sz;
			
			if(row<0 || row>=sz || col<0 || col>=sz) {
				System.out.println("Invalid Position.");
				continue;
			}
			
			if(board.mat[row][col]!='-') {
				System.out.println("Position is occupied.");
				continue;
			}
			
			return pos;
			
		}
		
	}
	
	public boolean check() {
		int sz=board.size;
		
		//row wise
		for(int i=0; i<sz;i++) {
			StringBuilder sb =new StringBuilder();
			
			for(int j=0;j<sz;j++) {
				sb.append(board.mat[i][j]);
			}
			
			String pattern =sb.toString();
			if(pattern.equals(zero) || pattern.equals(cross)) {
				return true;
			}
			
		}
		
		//column wise
		
		for(int i=0;i<sz;i++) {
			StringBuilder sb= new StringBuilder();
			
			for(int j=0;j<sz;j++) {
				sb.append(board.mat[j][i]);
			}
			
			String pattern =sb.toString();
			
			if(pattern.equals(zero) || pattern.equals(cross)) {
				return true;
			}
			
		}
		
		//diagonal
		int i=0,j=0;
		
		StringBuilder sb=new StringBuilder();
		
		while(i<sz) {
			sb.append(board.mat[i][j]);
			i++;
			j++;
		}
		
		String pattern =sb.toString();
		
		if(pattern.equals(zero) || pattern.equals(cross)) {
			return true;
		}
		
		//antidiagonal
		i=0;
		j=sz-1;
		
		sb=new StringBuilder();
		
		while(i<sz) {
			sb.append(board.mat[i][j]);
			i++;
			j--;
		}
		
		pattern =sb.toString();
		
		if(pattern.equals(zero) || pattern.equals(cross)) {
			return true;
		}
		
		
		return false;
	}
}
