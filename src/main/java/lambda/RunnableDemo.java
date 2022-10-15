package lambda;

public class RunnableDemo {

    public static void main(String[] args){
        //Java 7 syntax
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside an anonymous inner class");
            }
        }).start();

        //Expression lambda
        new Thread(() -> System.out.println("Inside Expression lambda")).start();

        //Block lambda
        new Thread(() -> {
            System.out.println("Inside block lambda ");
        }).start();

        //Assign a  lambda function to variable
        Runnable runnable = () -> System.out.println("Assign lambda function to variable");
        new Thread(runnable).start();;
    }
}
