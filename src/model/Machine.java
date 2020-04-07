package model;

import java.util.ArrayList;
import java.util.List;

public class Machine {

    private List<Party> parties = new ArrayList<>();
    private List<String> voterIds = new ArrayList<>();
    private List<String> blackListedVoterIds = new ArrayList<>();
    
    public Machine() {

    }

    public void addParty(Party party) {
        parties.add(party);
    }

    public boolean isBlackListedVoterId(String voterId) {
        return blackListedVoterIds.contains(voterId);
    }

    public boolean alreadyVoted(String voterId) {
        return voterIds.contains(voterId);
    }

    public void addToBackListed(String voterId) {
        blackListedVoterIds.add(voterId);
    }

    public void addToVotedList(String voterId) {
        voterIds.add(voterId);
    }

    public List<Party> getParties() {
        return parties;
    }

}
