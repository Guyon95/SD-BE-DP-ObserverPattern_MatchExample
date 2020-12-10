package nl.novi.dpcc.observerpattern;

import nl.novi.dpcc.observerpattern.domain.MatchEventType;
import nl.novi.dpcc.observerpattern.domain.Message;
import nl.novi.dpcc.observerpattern.model.Score;
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
        Score feyenoord = new Score("Feyenoord");
        Score ajax = new Score("Ajax");

        Subject match = new MatchSubject();

        Observer scoreboardFeyenoord = new ScoreboardObserver(feyenoord);
        Observer scoreboardAjax = new ScoreboardObserver(ajax);

        match.attach(ajaxSupporter);
        match.attach(feyenoordSupporter);
        match.attach(neutralSupporter);


        for(int i = 0; i <= 90; i = i + 5) {
            System.out.println("Minute : " + i + "'");
            Message message = pickRandomMessage();
            match.notifyUpdate(message);
            if (message.getClubName().equalsIgnoreCase(feyenoord.getTeam())){
                scoreboardFeyenoord.update(message);
            }
            else{
                scoreboardAjax.update(message);
            }

            Thread.sleep(500);
        }
        System.out.println(feyenoord.getTeam() + " - " + ajax.getTeam());
        System.out.println("Goals " + feyenoord.getScore() + " - " + ajax.getScore());
        System.out.println("Red " + feyenoord.getRed() + " - " + ajax.getRed());
        System.out.println("Yellow " + feyenoord.getYellow() + " - " + ajax.getYellow());
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
