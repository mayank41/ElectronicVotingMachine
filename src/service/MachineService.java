package service;

import model.Machine;
import model.Party;

import java.util.List;

public class MachineService {
    Machine machine;

    public MachineService() {
        machine = new Machine();
    }

    public void vote(Party party, String voterId) {
        if(machine.isBlackListedVoterId(voterId)) {
            return;
        }
        if(machine.alreadyVoted(voterId)) {
            machine.addToBackListed(voterId);
            return;
        }
        party.addVote();
        machine.addToVotedList(voterId);
    }

    public Party getWinner() {
        Party winner = null;
        int highestVoteCountPartyCount = 0;
        List<Party> parties = machine.getParties();
        for(Party party : parties) {
            if(winner == null) {
                winner = party;
                highestVoteCountPartyCount = 1;
            } else {
                if(party.getVoteCount() > winner.getVoteCount()) {
                    winner = party;
                    highestVoteCountPartyCount = 1;

                } else if(party.getVoteCount() == winner.getVoteCount()) {
                    highestVoteCountPartyCount++;
                }
            }
        }
        return (highestVoteCountPartyCount == 1) ? winner : null;
    }

    public void addParty(Party party) {
        machine.addParty(party);
    }
}
