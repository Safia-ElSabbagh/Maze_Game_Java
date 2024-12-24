import java.util.Random;

public class HealthItem extends Item {
    private Random random;

    public HealthItem() {
        this.random = new Random();
    }

    @Override
    public int applyEffect() {
        int healthInc = random.nextInt(20) + 10;
        System.out.println("You found a health item! Health increased by " + healthInc);
        return healthInc;
    }

    @Override
    public String toString() {
        return "H";
    }

}
