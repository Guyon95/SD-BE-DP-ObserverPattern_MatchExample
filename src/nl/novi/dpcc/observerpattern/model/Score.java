package nl.novi.dpcc.observerpattern.model;

import lombok.Getter;
import lombok.Setter;

public class Score {

    @Getter @Setter
    private String team;
    @Getter @Setter
    private int score;
    @Getter @Setter
    private int yellow;
    @Getter @Setter
    private int red;

    public Score() {
    }

    public Score(String team) {
        this.team = team;
    }
}
