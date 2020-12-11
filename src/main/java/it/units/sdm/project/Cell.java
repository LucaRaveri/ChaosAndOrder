package it.units.sdm.project;

public class Cell {
    private final Coordinates coordinates;
    private Piece piece;

    public Cell(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
