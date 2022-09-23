public class Guy {
    private int id;
    private String nick;
    private int rank;

    public Guy(){}

    public Guy(String nick, int rank){
        this.nick = nick;
        this.rank = rank;
    }

    public Guy(int id, String nick, int rank) {
        this.id = id;
        this.nick = nick;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return nick+" "+rank;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }


}
