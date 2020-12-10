package nl.novi.dpcc.observerpattern.observer;

import nl.novi.dpcc.observerpattern.domain.MatchEventType;
import nl.novi.dpcc.observerpattern.domain.Message;

public  class SupporterObserver implements Observer {

    private final String favouriteClub;

    public SupporterObserver(String favouriteClub) {
        this.favouriteClub = favouriteClub;
    }

    public void update(Message message) {
        String clubname = message.getClubName();
        MatchEventType eventType = message.getMatchEventType();

        StringBuilder sb = new StringBuilder("The ").append(favouriteClub).append("-crowd ");

        if(favouriteClub.equalsIgnoreCase(clubname)) {
            sb.append(crowdReactionOwnTeam(eventType));
        }else if(favouriteClub.equalsIgnoreCase("neutral")){
            sb.append(crowdReactionNeutral(eventType));
        }
        else {
            sb.append(crowdReactionOpponent(eventType));
        }
        System.out.println(sb.toString());
    }

    private String crowdReactionOwnTeam(MatchEventType eventType) {
        switch(eventType) {
            case GOAL:
                return "cheers.";
            case PENALTY:
                return "cheers the striker for the penalty.";
            case YELLOW_CARD:
                return "boos the referee.";
            case SCHWALBE:
                return "cheers for the schwalbe";
            case RED_CARD:
                return "whistles at the referee";
            case VAR:
                return "cheers and clapping for the decision of the VAR";
        }
        return "leaves the stadium.";
    }

    private String crowdReactionOpponent(MatchEventType eventType) {
        switch(eventType) {
            case GOAL:
                return "shows dismay.";
            case PENALTY:
                return "yells the goalkeeper's name for the penalty.";
            case YELLOW_CARD:
                return "laughs at the yellow player.";
            case SCHWALBE:
                return "yells SCHWALBE!";
            case RED_CARD:
                return "cheers in celebration of the red card.";
            case VAR:
                return  "is angry at the VAR.";
        }
        return "leaves the stadium.";
    }

    private String crowdReactionNeutral(MatchEventType eventType) {
        switch(eventType) {
            case GOAL:
                return "loves the wonderfull goal.";
            case PENALTY:
                return "loves the great decision of the refferee.";
            case YELLOW_CARD:
                return "also thought it was a yellow card.";
            case SCHWALBE:
                return "yells unfair play";
            case RED_CARD:
                return "is in disbelieve of the horroble tackle";
            case VAR:
                return  "loves the VAR, because it is honest.";
        }
        return "leaves the stadium.";
    }

}
