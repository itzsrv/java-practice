package lambda.introduction;


public class Driver{

    public void perform(Greeting greeting){
        greeting.greet();
    }

    public static void main(String[] args) {
        Driver driver = new Driver();

        Greeting helloGreeting = new HelloGreeting();
        
        driver.perform(helloGreeting);

        Greeting hiGreeting = new HiGreeting();
        driver.perform(hiGreeting);
        
    }
}