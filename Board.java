package tictactoe;

public class Board {
	
	public int size;
	public char mat[][];
	
	public Board(int size){
		this.size=size;
		this.mat=new char[size][size];
		
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				mat[i][j]='-';
			}
		}
	}
	
	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}


	public void printConfiguration() {
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
	}
}
