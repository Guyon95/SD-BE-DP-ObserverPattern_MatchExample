package nl.novi.dpcc.observerpattern.observer;

import nl.novi.dpcc.observerpattern.domain.MatchEventType;
import nl.novi.dpcc.observerpattern.domain.Message;
import nl.novi.dpcc.observerpattern.model.Score;



public class ScoreboardObserver implements Observer {

    private final Score score;

    public ScoreboardObserver(Score score) {
        this.score = score;
    }

    public void update(Message message) {
        String clubname = message.getClubName();
        MatchEventType eventType = message.getMatchEventType();

        if (clubname.equalsIgnoreCase(score.getTeam())) {
            if (eventType == MatchEventType.GOAL) {
                score.setScore(score.getScore() + 1);

            } else if (eventType == MatchEventType.YELLOW_CARD) {
                score.setYellow(score.getYellow() + 1);

            } else if (eventType == MatchEventType.RED_CARD) {
                score.setRed(score.getRed() + 1);
            }
        }
    }
}
