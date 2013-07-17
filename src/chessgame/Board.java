package chessgame;

import pieces.Pawn;

import java.util.ArrayList;

/**
 * 체스판 클래스 
 * @author YoungNamLee
 */


public class Board {
	
	static final String NEWLINE = System.getProperty("line.separator");
	
	public ArrayList<ArrayList<Pawn>> chessBoard = new ArrayList<ArrayList<Pawn>>();
	
	//생성자 
	public Board(){			
	}
	
	//Board_구성 
	public void initalizeBoard() {
		this.setLow(); //열 생성 
		this.setEmptyLine(); //빈공간 생성  
		this.setPawnLine(); //Pawn 정렬 
		}
	
	
	public void setLow(){
		for(int i = 0; i < 8 ; i++){
			chessBoard.add(i, new ArrayList<Pawn>());
		}	
	}
	
	public void setEmptyLine(){
		for(int i = 0 ; i < 8 ; i++){
			for(int j = 0; j<8 ; j++){
				chessBoard.get(i).add(j, new Pawn(Pawn.EMPTY));
			}
		}
	}
	
	public void setPawnLine(){
		for(int i = 0; i < 8 ; i++){
			chessBoard.get(1).set(i, new Pawn(Pawn.PLAYER_BLACK));
			chessBoard.get(6).set(i, new Pawn(Pawn.PLAYER_WHITE));
		}
	}

	public String boardPrint() {
		StringBuilder boardPrint = new StringBuilder();
		
		for(int i = 0 ; i < 8 ; i++){
			for(int j = 0; j<8 ; j++){
				boardPrint.append(chessBoard.get(i).get(j).pawnPrint);
			}
			boardPrint.append(NEWLINE);
		}
		
		return boardPrint.toString();
	}
}
