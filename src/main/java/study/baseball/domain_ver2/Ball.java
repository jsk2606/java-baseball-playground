package study.baseball.domain_ver2;

public class Ball {

    int position;
    int input;
    public Ball(int position, int input) {
        this.position = position;
        this.input = input;
    }

    public int getInput(){
        return this.input;
    }

    public int getPosition(){
        return this.position;
    }
}
