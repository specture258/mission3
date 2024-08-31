package lotto.model.domain;

public enum Rank {

    FIRST(2_000_000_000,1),
    SECOND(30_000_000,2),
    THIRD(1_5000_000,3),
    FOURTH(50_000,4),
    FIFTH(5_000 ,5);

    private final int money;
    private final int count;

    Rank(int money, int count){
        this.money = money;
        this.count = count;
    }

    public int getMoney() {
        return money;
    }

    public int getCount() {
        return count;
    }
}
