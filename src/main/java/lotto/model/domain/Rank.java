package lotto.model.domain;

public enum Rank {
    FIFTH(5_000),
    FOURTH(50_000),
    THIRD(1_5000_000),
    SECOND(30_000_000),
    FIRST(2_000_000_000);

    private final int money;

    Rank(int money){
        this.money = money;
    }

    public int getMoney() {
        return money;
    }
}
