package boardgame;

public class Board {

	private int rows;
	private int collumns;
	private Piece[][] pieces;

	public Board(int rows, int collumns) {
		if (rows < 1 || collumns < 1) {
			throw new BoardException("Error ao criar tabuleiro");
		}
		this.rows = rows;
		this.collumns = collumns;
		pieces = new Piece[rows][collumns];
	}

	public int getRows() {
		return rows;
	}

	public int getCollumns() {
		return collumns;
	}

	public Piece piece(int row, int collumn) {
		if(!positionExists(row,collumn)) {
			throw new BoardException("Posição não existe");
		}
		return pieces[row][collumn];
	}

	public Piece piece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Posição não existe");
		}
		return pieces[position.getRow()][position.getCollum()];
	}

	public void placePiece(Piece piece, Position position) {
		if(thereIsAPiece(position)) {
			throw new BoardException("Já existe uma peça em "+position);
		}
		pieces[position.getRow()][position.getCollum()] = piece;
		piece.position = position;
	}

	private boolean positionExists(int row, int collumn) {
		return row >= 0 && row < rows && collumn >= 0 && collumn < collumns;
	}

	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getCollum());
	}

	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Posição não existe");
		}
		return piece(position) != null;
	}
}
