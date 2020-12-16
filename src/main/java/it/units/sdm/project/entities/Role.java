package it.units.sdm.project.entities;

public enum Role {

    CHAOS, ORDER;

    public static String toString(Role role) {
        return (role == CHAOS) ? "Chaos" : "Order";
    }

}
