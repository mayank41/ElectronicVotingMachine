package model;

public abstract class Party {
    protected String name;
    protected int voteCount = 0;

    public String getName() {
        return name;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void addVote() {
        voteCount++;
    }

    public void resetVoteCount() {
        voteCount = 0;
    }
}
