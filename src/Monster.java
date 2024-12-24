import java.util.Random;

public class Monster {

    int power;
    Random random;

    public Monster() {
        this.random = new Random();
        this.power = random.nextInt(200);
    }

    public int getPower() {
        return power;
    }

    @Override
    public String toString() {
        return "M";
    }

}
