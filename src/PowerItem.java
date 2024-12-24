import java.util.Random;

public class PowerItem extends Item {

    private Random random;

    public PowerItem() {
        this.random = new Random();
    }

    @Override
    public int applyEffect() {
        int powerInc = random.nextInt(20) + 10;
        System.out.println("You found a power item! Power increased by " + powerInc);
        return powerInc;
    }

    @Override
    public String toString() {
        return "P";
    }

}
