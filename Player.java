public class Player {

    private int score = 0;
    private String name;


    public Player(String name){
        this.name = name;
    }

    private void addScore(){
        this.score += 1;
    }

    private void decreaseScore(){
        this.score -= 1;
    }


    public int getScore(){
        return this.score;
    }

}
