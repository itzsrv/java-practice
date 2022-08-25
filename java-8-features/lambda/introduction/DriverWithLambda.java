package lambda.introduction;

public class DriverWithLambda {

    public void perform(Greeting greeting){
        greeting.greet();
    }

    public static void main(String[] args) {
        DriverWithLambda driver = new DriverWithLambda();

        driver.perform(()->System.out.println("Greets Hello"));

        driver.perform(()->System.out.println("Greets Hi"));
    }
}
