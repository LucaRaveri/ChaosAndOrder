package it.units.sdm.project.entities;

public enum Role {

    CHAOS, ORDER;

    //TODO: discuss it is worth to keep it or delete it
    public static boolean isEmpty(Role role){
        return role==null;
    }

    public static String toString(Role role) {
        return (role == CHAOS) ? "Chaos" : "Order";
    }

}
