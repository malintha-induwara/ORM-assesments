public class Dog extends Animal{


    @Override
    public void run() {
        System.out.println("Dog Run");
    }

    @Override
    public void run(int speed) {
        System.out.println("Dog speed is "+speed);
    }

    @Override
    public void hello(){
        System.out.println("ddd");
    }

}

