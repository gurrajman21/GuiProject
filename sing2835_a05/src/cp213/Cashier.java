package cp213;
import java.util.*;
/**
 * Wraps around an Order object to ask for MenuItems and quantities
 *
 * @author Gurraj Singh
 * @author Abdul-Rahman Mawlood-Yunis
 * @author David Brown
 * @version 2022-05-20
 */
public class Cashier {

    // Attributes
    private Menu menu = null;

    /**
     * Constructor.
     *
     * @param menu A Menu.
     */
    public Cashier(Menu menu) {
	this.menu = menu;
    }

    /**
     * Prints the menu.
     */
    private void printCommands() {
	System.out.println("\nMenu:");
	System.out.printf(menu.toString());
	System.out.println("\nPress 0 when done.");
	System.out.println("Press any other key to see the menu again.\n");
    }

    /**
     * Asks for commands and quantities. Prints a receipt when all orders have been
     * placed.
     *
     * @return the completed Order.
     */
    public Order takeOrder() {
    Scanner input = new Scanner(System.in);
	Order order = new Order();
	System.out.println("Welcome to WLU Foodorama!");
	printCommands();
	int command = -1;
	while(command != 0) {
		try {
		System.out.println("Command: ");
		command = input.nextInt();
		if(command>0&&command<8) {
			System.out.println("How many do you want? ");
			int quantity = input.nextInt();
			MenuItem item = menu.getItem(command-1);
			order.add(item, quantity);
			
		}
		else if(command!=0){
			printCommands();
		}
		if(command == 0) {
			System.out.println("----------------------------------------");
			System.out.println("Receipt");
			System.out.println(order.toString());
			input.close();
		}
		}
		catch(InputMismatchException e) {
			input.next();
			System.out.println("Not a valid number");
		}
	}
	

	return order;
    }
    public Menu getMenu() {
    	return menu;
    }
    public void setMenu(Menu menu) {
    	this.menu = menu;
    }
}