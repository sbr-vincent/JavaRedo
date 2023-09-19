import java.util.ArrayList;
import java.util.Arrays;

public class CafeUtil {
    public int getStreakGoal(int numWeeks) {
        int sum = 0;

        for( int i = 1; i <= numWeeks; i++){
            sum += i;
        }

        return sum;
    }

    public double getOrderTotal(double[] prices){
        double sum = 0;

        for(double i : prices){
            sum += i;
        }

        return sum;
    }

    public void displayMenu(ArrayList<String> menuItems){

        for(int i = 0; i < menuItems.size(); i++){
            System.out.println(String.format("%s  %s", i, menuItems.get(i)));
        }
    }

    public void addCustomer(ArrayList<String> customers){
        String userName = System.console().readLine();

        System.out.println(String.format("Hello, %s", userName));

        System.out.println(String.format("There are %s people in front of you.", customers.size()));

        customers.add(userName);
        System.out.println(customers);
    }

}