public class Animal {
    private double speed;
    private String color;
    private int noOfLegs;

    public Animal(double speed, String color, int noOfLegs) {
        this.speed = speed;
        this.color = color;
        this.noOfLegs = noOfLegs;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNoOfLegs() {
        return noOfLegs;
    }

    public void setNoOfLegs(int noOfLegs) {
        this.noOfLegs = noOfLegs;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "speed=" + speed +
                ", color='" + color + '\'' +
                ", noOfLegs=" + noOfLegs +
                '}';
    }
}

