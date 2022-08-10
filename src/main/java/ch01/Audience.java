package ch01;

/**
 * 관람객, 소지품을 보관하기 위한 가방을 소지한다
 */
public class Audience {
    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public Bag getBag() {
        return bag;
    }
}
