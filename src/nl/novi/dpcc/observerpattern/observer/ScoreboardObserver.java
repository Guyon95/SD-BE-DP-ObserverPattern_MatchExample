package nl.novi.dpcc.observerpattern.observer;

import lombok.Getter;
import lombok.Setter;
import nl.novi.dpcc.observerpattern.domain.MatchEventType;
import nl.novi.dpcc.observerpattern.domain.Message;
import nl.novi.dpcc.observerpattern.model.score;
import nl.novi.dpcc.observerpattern.subject.MatchSubject;
import nl.novi.dpcc.observerpattern.subject.Subject;


public class ScoreboardObserver implements Observer {

    private final Subject matchSubject;

    private final score score;


    public ScoreboardObserver(Subject matchSubject, nl.novi.dpcc.observerpattern.model.score score) {
        this.matchSubject = matchSubject;
        this.score = score;
    }

    public void update(Message message) {
        String clubname = message.getClubName();
        MatchEventType eventType = message.getMatchEventType();

        if (message.getClubName().equalsIgnoreCase(score.getHomeTeam())) {
            if (eventType == MatchEventType.GOAL) {
                score.setScore_home(score.getScore_home() + 1);

            } else if (eventType == MatchEventType.YELLOW_CARD) {
                score.setYellow_home(score.getYellow_home() + 1);

            } else if (eventType == MatchEventType.RED_CARD) {
                score.setRed_home(score.getRed_home() + 1);
            }
        } else {
            if (eventType == MatchEventType.GOAL) {
                score.setScore_away(score.getScore_away() + 1);

            } else if (eventType == MatchEventType.YELLOW_CARD) {
                score.setYellow_away(score.getYellow_away() + 1);

            } else if (eventType == MatchEventType.RED_CARD) {
                score.setRed_away(score.getRed_away() + 1);
            }
        }

        //StringBuilder sb = new StringBuilder("The ").append(favouriteClub).append("-crowd ");
    }
}
