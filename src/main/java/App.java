
import model.Party;
import model.User;
import service.MachineService;
import model.impl.AAP;
import model.impl.BJP;
import model.impl.Congress;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        App app = new App();
        List<Party> parties = new ArrayList<>();

        Party bjp = new BJP();
        Party aap = new AAP();
        Party congress = new Congress();

        MachineService machineService = new MachineService();
        machineService.addParty(bjp);
        machineService.addParty(aap);
        machineService.addParty(congress);

        User user1 = new User("1");
        app.castVote(machineService, bjp, user1);

        User user2 = new User("2");
        app.castVote(machineService, bjp, user2);

        User user3 = new User("3");
        app.castVote(machineService, aap, user3);

        User user4 = new User("4");
        app.castVote(machineService, aap, user4);

        User user5 = new User("5");
        app.castVote(machineService, bjp, user5);

        User user6 = new User("6");
        app.castVote(machineService, congress, user6);

        app.castVote(machineService, aap, user1);
        app.castVote(machineService, congress, user4);
        app.castVote(machineService, congress, user6);

        Party winner = machineService.getWinner();
        if(winner == null) {
            System.out.println("No individual winner.");
        } else {
            System.out.println(winner.getName());
        }
    }

    private void castVote(MachineService machineService, Party party, User user) {
        machineService.vote(party, user.getVoterId());
    }
}
