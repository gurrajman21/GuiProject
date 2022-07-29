package cp213;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;
import java.util.List;
import cp213.*;
import javax.swing.*;

/**
 * The GUI for the Order class.
 *
 * @author Gurraj Singh
 * @author Abdul-Rahman Mawlood-Yunis
 * @author David Brown
 * @version 2022-05-20
 */
@SuppressWarnings("serial")
public class OrderPanel extends JPanel {
	List<JTextField> orderNum = new ArrayList<JTextField>();
    /**
     * Implements an ActionListener for the 'Print' button. Prints the current
     * contents of the Order to a system printer or PDF.
     */
	Order order = new Order();
	JLabel subtotalNum = new JLabel("0");
	JLabel taxNum = new JLabel("0");
	JLabel totalNum = new JLabel("0");
	JButton printing = new JButton("Print");
	private Menu menu;
    private class PrintListener implements ActionListener {

	@Override
	public void actionPerformed(final ActionEvent e) {
		PrinterJob job = PrinterJob.getPrinterJob();
		PageFormat pf = job.defaultPage();
		job.setPrintable(order,pf);
		if(job.printDialog()) {
		try {
			job.print();
		}
		catch
			(PrinterException ex)
		{
			System.out.println(ex);
		}
		}
	}
}
    private class HotListen implements FocusListener{

	@Override
	public void focusGained(FocusEvent e) {
		System.out.println("FocusGained");
	}

	@Override
	public void focusLost(FocusEvent e) {
		
		String source = orderNum.get(0).getText();
		if(source.equals("")){
			System.out.println("no input");
		}
		else {
		MenuItem item = menu.getItem(0);
		order.update(item, Integer.valueOf(source));
		subtotalNum.setText(order.getSubTotal().toString());
		taxNum.setText(String.format("%.2f", order.getTaxes()));
		totalNum.setText(String.format("%.2f", order.getTotal()));
		System.out.println(order.getSubTotal());
		System.out.println(order.getTaxes());
		System.out.println(order.getTotal());
		}
	}
		
	}
    private class HamListen implements FocusListener{

    	@Override
    	public void focusGained(FocusEvent e) {
    		System.out.println("FocusGained");
    	}


		@Override
		public void focusLost(FocusEvent e) {
			String source = orderNum.get(1).getText();
			if(source.equals("")){
				System.out.println("no input");
			}
			else {
    		MenuItem item = menu.getItem(1);
    		order.update(item, Integer.valueOf(source));
    		subtotalNum.setText(order.getSubTotal().toString());
    		taxNum.setText(String.format("%.2f", order.getTaxes()));
    		totalNum.setText(String.format("%.2f", order.getTotal()));
    		System.out.println(order.getSubTotal());
    		System.out.println(order.getTaxes());
    		System.out.println(order.getTotal());
			}
		}
    		
    	}
    private class CheeseListen implements FocusListener{

    	@Override
    	public void focusGained(FocusEvent e) {
    		System.out.println("FocusGained");
    		
    	}

		@Override
		public void focusLost(FocusEvent e) {
			String source = orderNum.get(2).getText();
			if(source.equals("")){
				System.out.println("no input");
			}
			else {
    		MenuItem item = menu.getItem(2);
    		order.update(item, Integer.valueOf(source));
    		subtotalNum.setText(order.getSubTotal().toString());
    		taxNum.setText(String.format("%.2f", order.getTaxes()));
    		totalNum.setText(String.format("%.2f", order.getTotal()));
    		System.out.println(order.getSubTotal());
    		System.out.println(order.getTaxes());
    		System.out.println(order.getTotal());
			}
		}
    		
    	}
    private class FriesListen implements FocusListener{

    	@Override
    	public void focusGained(FocusEvent e) {
    		System.out.println("FocusGained");
    		
    	}

		@Override
		public void focusLost(FocusEvent e) {
			String source = orderNum.get(3).getText();
			if(source.equals("")){
				System.out.println("no input");
			}
			else {
    		MenuItem item = menu.getItem(3);
    		order.update(item, Integer.valueOf(source));
    		subtotalNum.setText(order.getSubTotal().toString());
    		taxNum.setText(String.format("%.2f", order.getTaxes()));
    		totalNum.setText(String.format("%.2f", order.getTotal()));
    		System.out.println(order.getSubTotal());
    		System.out.println(order.getTaxes());
    		System.out.println(order.getTotal());
			}
		}
    		
    	}
    private class PouListen implements FocusListener{

    	@Override
    	public void focusGained(FocusEvent e) {
    		System.out.println("FocusGained");
    		
    	}

		@Override
		public void focusLost(FocusEvent e) {
			String source = orderNum.get(4).getText();
			if(source.equals("")){
				System.out.println("no input");
			}
			else {
    		MenuItem item = menu.getItem(4);
    		order.update(item, Integer.valueOf(source));
    		subtotalNum.setText(order.getSubTotal().toString());
    		taxNum.setText(String.format("%.2f", order.getTaxes()));
    		totalNum.setText(String.format("%.2f", order.getTotal()));
    		System.out.println(order.getSubTotal());
    		System.out.println(order.getTaxes());
    		System.out.println(order.getTotal());
			}
		}
    		
    	}
    private class PizzaListen implements FocusListener{

    	@Override
    	public void focusGained(FocusEvent e) {
    		System.out.println("FocusGained");
    		
    	}

		@Override
		public void focusLost(FocusEvent e) {
			String source = orderNum.get(5).getText();
			if(source.equals("")){
				System.out.println("no input");
			}
			else {
    		MenuItem item = menu.getItem(5);
    		order.update(item, Integer.valueOf(source));
    		subtotalNum.setText(order.getSubTotal().toString());
    		taxNum.setText(String.format("%.2f", order.getTaxes()));
    		totalNum.setText(String.format("%.2f", order.getTotal()));
    		System.out.println(order.getSubTotal());
    		System.out.println(order.getTaxes());
    		System.out.println(order.getTotal());
			}
		}
    		
    	}
    private class DrinkListen implements FocusListener{

    	@Override
    	public void focusGained(FocusEvent e) {
    		System.out.println("FocusGained");
    		
    	}

		@Override
		public void focusLost(FocusEvent e) {
			String source = orderNum.get(6).getText();
			if(source.equals("")){
				System.out.println("no input");
			}
			else {
    		MenuItem item = menu.getItem(6);
    		order.update(item, Integer.valueOf(source));
    		subtotalNum.setText(order.getSubTotal().toString());
    		taxNum.setText(String.format("%.2f", order.getTaxes()));
    		totalNum.setText(String.format("%.2f", order.getTotal()));
    		System.out.println(order.getSubTotal());
    		System.out.println(order.getTaxes());
    		System.out.println(order.getTotal());
			}
		}
    		
    	}
    public OrderPanel(final Menu menu) {
    	this.menu = menu;
    	JLabel item = new JLabel("Item");
    	JLabel price = new JLabel("Price");
    	JLabel quantity = new JLabel("Quantity");
    	JLabel subtotal = new JLabel("Subtotal:");
    	JLabel tax = new JLabel("Tax:");
    	JLabel total = new JLabel("Total:");
    	JLabel empty = new JLabel("");
    	JLabel empty1 = new JLabel("");
    	JLabel empty2 = new JLabel("");
    	JLabel empty3 = new JLabel("");
    	JLabel empty4 = new JLabel("");
    	this.add(item);
    	this.add(price);
    	this.add(quantity);
    	for(int i=0;i<menu.size();i++) {
    	JLabel itemName = new JLabel(menu.getItem(i).getName().toString());
    	JLabel itemPrice = new JLabel(menu.getItem(i).getPrice().toString());
    	JTextField orderAmount = new JTextField();
    	orderNum.add(orderAmount); 
    	this.add(itemName);
    	 this.add(itemPrice);
    	 this.add(orderAmount);
    	}
    	this.add(subtotal);
    	this.add(empty);
    	this.add(subtotalNum);
    	this.add(tax);
    	this.add(empty1);
    	this.add(taxNum);
    	this.add(total);
    	this.add(empty2);
    	this.add(totalNum);
    	this.add(empty3);
    	this.add(printing);
    	this.add(empty4);
    	
    	layoutView();
    	this.registerListeners();
	}
	private void layoutView(){
		this.setLayout(new GridLayout(12,3,5,5));
		
    }

    private void registerListeners(){
    	this.orderNum.get(0).addFocusListener(new HotListen());
    	this.orderNum.get(1).addFocusListener(new HamListen());
    	this.orderNum.get(2).addFocusListener(new CheeseListen());
    	this.orderNum.get(3).addFocusListener(new FriesListen());
    	this.orderNum.get(4).addFocusListener(new PouListen());
    	this.orderNum.get(5).addFocusListener(new PizzaListen());
    	this.orderNum.get(6).addFocusListener(new DrinkListen());
    	printing.addActionListener(new PrintListener());
    }

}