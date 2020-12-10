package nl.novi.dpcc.observerpattern;

import nl.novi.dpcc.observerpattern.domain.MatchEventType;
import nl.novi.dpcc.observerpattern.domain.Message;
import nl.novi.dpcc.observerpattern.model.score;
import nl.novi.dpcc.observerpattern.observer.Observer;
import nl.novi.dpcc.observerpattern.observer.ScoreboardObserver;
import nl.novi.dpcc.observerpattern.observer.SupporterObserver;
import nl.novi.dpcc.observerpattern.subject.MatchSubject;
import nl.novi.dpcc.observerpattern.subject.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Observer ajaxSupporter = new SupporterObserver("Ajax");
        Observer feyenoordSupporter = new SupporterObserver("Feyenoord");
        Observer neutralSupporter = new SupporterObserver("Neutral");
        score score = new score();

        Subject match = new MatchSubject();

        Observer scoreboard = new ScoreboardObserver(match, score);

        match.attach(ajaxSupporter);
        match.attach(feyenoordSupporter);
        match.attach(neutralSupporter);


        score.setHomeTeam("Ajax");
        score.setAwayTeam("Feyenoord");

        for(int i = 0; i <= 90; i = i + 5) {
            Message bericht = pickRandomMessage();
            match.notifyUpdate(bericht);
            scoreboard.update(bericht);

            Thread.sleep(1000);
        }
        System.out.println(score.getHomeTeam() + " - " + score.getAwayTeam());
        System.out.println("Goals " + score.getScore_home() + " - " + score.getScore_away());
        System.out.println("Red " + score.getRed_home() + " - " + score.getRed_away());
        System.out.println("Yellow " + score.getYellow_home() + " - " + score.getYellow_away());
    }

    private static Message pickRandomMessage() {
        List<Message> messages = makeList();
        Random random = new Random();

        return messages.get(random.nextInt(messages.size()));
    }


    private static List<Message> makeList() {
        List<Message> matchReports = new ArrayList<>();
        matchReports.add(new Message("Ajax", MatchEventType.GOAL));
        matchReports.add(new Message("Ajax", MatchEventType.YELLOW_CARD));
        matchReports.add(new Message("Ajax", MatchEventType.RED_CARD));
        matchReports.add(new Message("Ajax", MatchEventType.SCHWALBE));
        matchReports.add(new Message("Ajax", MatchEventType.PENALTY));
        matchReports.add(new Message("Ajax", MatchEventType.VAR));
        matchReports.add(new Message("Feyenoord", MatchEventType.RED_CARD));
        matchReports.add(new Message("Feyenoord", MatchEventType.YELLOW_CARD));
        matchReports.add(new Message("Feyenoord", MatchEventType.SCHWALBE));
        matchReports.add(new Message("Feyenoord", MatchEventType.PENALTY));
        matchReports.add(new Message("Feyenoord", MatchEventType.GOAL));
        matchReports.add(new Message("Feyenoord", MatchEventType.VAR));

        return matchReports;
    }
}
