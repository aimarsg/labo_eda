package eda;

import java.util.ArrayList;

public class Par {
    String actor;
    Double pageRank;

    public Par(String actor, Double pageRank) {
        this.actor = actor;
        this.pageRank = pageRank;
    }
    public int compareTo(Par p){
        // si lo que hay entre parentesis es menor -> 1
        // si lo que hay entre parentesis es igual -> 0
        //  si lo que hay entre parentesis es mayor -> -1
        return (this.pageRank.compareTo(p.pageRank));
    }
}
