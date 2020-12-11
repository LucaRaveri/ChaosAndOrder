package it.units.sdm.project;

public class Piece {
    public enum Signs{
        CROSS,
        CIRCLE
    }

    private final Signs sign;

    public Piece(Signs sign) {
        this.sign = sign;
    }

    public Signs getSign() {
        return sign;
    }

}
