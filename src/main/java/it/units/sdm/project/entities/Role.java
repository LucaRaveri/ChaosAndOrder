package it.units.sdm.project.entities;

public enum Role {

    CHAOS, ORDER;

    public boolean isEmpty(){
        return this==null;
    }

    public static String toString(Role role) {
        return (role == CHAOS) ? "Chaos" : "Order";
    }

}
