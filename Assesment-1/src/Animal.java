public class Animal {
    private double speed;
    private String color;
    private int noOfLegs;


    public void run(){
        System.out.println("This is Run of Animal");
    }
    public void run(int speed){
        System.out.println("This is speed "+speed+" of Animal");
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

