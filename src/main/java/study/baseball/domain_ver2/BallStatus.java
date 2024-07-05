package study.baseball.domain_ver2;

public enum BallStatus {
    STRIKE("스트라이크"),
    BALL("볼 "),
    NOTHING("낫싱");
    private String name;

    BallStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
