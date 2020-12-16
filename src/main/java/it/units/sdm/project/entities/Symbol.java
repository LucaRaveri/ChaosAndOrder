package it.units.sdm.project.entities;

public enum Symbol {
    CROSS, CIRCLE;

    public String toString(Symbol symbol) {
        return (symbol == CROSS) ? "Cross" : "Circle";
    }
}