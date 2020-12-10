package nl.novi.dpcc.observerpattern.model;

import lombok.Getter;
import lombok.Setter;

public class score {

    @Getter @Setter
    private String homeTeam;

    @Getter @Setter
    private String awayTeam;


    @Getter @Setter
    private int score_home;
    @Getter @Setter
    private int score_away;
    @Getter @Setter
    private int yellow_home;
    @Getter @Setter
    private int yellow_away;
    @Getter @Setter
    private int red_home;
    @Getter @Setter
    private int red_away;

    public score() {
    }
}
