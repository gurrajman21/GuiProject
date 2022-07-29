package cp213;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.math.BigDecimal;
import java.util.HashMap;

/**
 * Stores a HashMap of MenuItem objects and the quantity of each MenuItem
 * ordered. Each MenuItem may appear only once in the HashMap
 *
 * @author Gurraj Singh
 * @author Abdul-Rahman Mawlood-Yunis
 * @author David Brown
 * @version 2022-05-20
 */
public class Order implements Printable {

    /**
     * The current tax rate on menu items.
     */
    public static final BigDecimal TAX_RATE = new BigDecimal(0.13);

    // Attributes

    private HashMap<MenuItem, Integer> orderItem = new HashMap<>();

    /**
     * Increments the quantity of a particular MenuItem in an Order with a new
     * quantity. If the MenuItem is not in the order, it is added.
     *
     * @param item     The MenuItem to purchase - the HashMap key.
     * @param quantity The number of the MenuItem to purchase - the HashMap value.
     */
    public void add(final MenuItem item, final int quantity) {

	if(!orderItem.containsKey(item)) {
		orderItem.put(item, quantity);
	}
	else {
		orderItem.put(item, orderItem.get(item)+quantity);
	}

    }

    /**
     * Calculates the total value of all MenuItems and their quantities in the
     * HashMap.
     *
     * @return the total price for the MenuItems ordered.
     */
    public BigDecimal getSubTotal() {

	BigDecimal total = new BigDecimal(0);
	for(MenuItem item: orderItem.keySet()) {
		total = total.add(item.getPrice().multiply(new BigDecimal(orderItem.get(item))));
	}

	return total;
    }

    /**
     * Calculates and returns the total taxes to apply to the subtotal of all
     * MenuItems in the order. Tax rate is TAX_RATE.
     *
     * @return total taxes on all MenuItems
     */
    public BigDecimal getTaxes() {

	BigDecimal subTotal = getSubTotal();
	BigDecimal taxes = subTotal.multiply(TAX_RATE);
	

	return taxes;
    }

    /**
     * Calculates and returns the total price of all MenuItems order, including tax.
     *
     * @return total price
     */
    public BigDecimal getTotal() {

	BigDecimal subTotal = getSubTotal();
	BigDecimal taxes = getTaxes();
	BigDecimal total = subTotal.add(taxes);


	return total;
    }

    /*
     * Implements the Printable interface print method. Prints lines to a Graphics2D
     * object using the drawString method. Prints the current contents of the Order.
     */
    @Override
    public int print(final Graphics graphics, final PageFormat pageFormat, final int pageIndex)
	    throws PrinterException {
	int result = PAGE_EXISTS;

	if (pageIndex == 0) {
	    final Graphics2D g2d = (Graphics2D) graphics;
	    g2d.setFont(new Font("MONOSPACED", Font.PLAIN, 12));
	    g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
	    // Now we perform our rendering
	    final String[] lines = this.toString().split("\n");
	    int y = 100;
	    final int inc = 12;

	    for (final String line : lines) {
		g2d.drawString(line, 100, y);
		y += inc;
	    }
	} else {
	    result = NO_SUCH_PAGE;
	}
	return result;
    }

    /**
     * Returns a String version of a receipt for all the MenuItems in the order.
     */
    @Override
    public String toString() {
    
	StringBuilder list = new StringBuilder();
	for(MenuItem item:orderItem.keySet()) {
		float f = item.getPrice().floatValue();
		String receipt1 = String.format("%-12s %s @ $%5.2f = %-2s%5.2f\n",item.getName(),orderItem.get(item),f,"$",f*orderItem.get(item));
		list.insert(0,receipt1);
	}
	String receipt2 = String.format("\n%-26s$%6s\n%-26s$%6.2f\n%-26s$%6.2f","Subtotal:",getSubTotal(),"Taxes:",getTaxes(),"Total:",getTotal());
	list.append(receipt2);
	return list.toString();
    }

    /**
     * Replaces the quantity of a particular MenuItem in an Order with a new
     * quantity. If the MenuItem is not in the order, it is added. If quantity is 0
     * or negative, the MenuItem is removed from the Order.
     *
     * @param item     The MenuItem to update
     * @param quantity The quantity to apply to item
     */
    public void update(final MenuItem item, final int quantity) {

	if(quantity<=0) {
		orderItem.remove(item);
	}
	else {
		orderItem.put(item, quantity);
	}

    }
}