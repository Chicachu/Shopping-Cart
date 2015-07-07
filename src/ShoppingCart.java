/*
 * ShoppingCart.java
 * TCSS 305 - Spring 2013 
 */
import java.util.HashMap;
import java.util.Map;
/**
 * @author Erica Putsche
 * @version 4/12/2013
 */
public class ShoppingCart
{
  /**
   * Member discount.
   */
  private static final double MY_MEMBER_DISCOUNT = .1;
  
  /**
   * The minimum total a customer must meet before using their member discount.
   */
  private static final double MY_MEMBERSHIP_REQUIREMENT = 20.00;
  
  /**
   * A shopping cart to hold onto ItemOrders.
   */
  private final Map<String, ItemOrder> my_shopping_cart;
  
  /**
   * Is the customer a member or not?
   */
  private boolean my_membership;
  
  /**
   * Constructs an empty shopping cart.
   */
  public ShoppingCart() 
  {
    my_shopping_cart = new HashMap<String, ItemOrder>();
  }
  
  /**
   * Adds an ItemOrder to the shopping cart.
   * @param an_item_order ItemOrder to be added to the shopping cart.
   */
  public void add(final ItemOrder an_item_order) 
  {
    my_shopping_cart.put(an_item_order.toString(), an_item_order);
  }
  
  /**
   * Sets membership status of a customer.
   * @param a_value Whether or not the customer is a member.
   */
  public void setMembership(final boolean a_value) 
  {
    my_membership = a_value;
  }
  
  /**
   * Calculates the total of everything in the shopping cart.
   * @return The total of everything in the shopping cart.
   */
  public double calculateTotal() 
  {
    double total = 0.0; 
    for (Map.Entry<String, ItemOrder> entry : my_shopping_cart.entrySet()) 
    {
      total += entry.getValue().calculatePrice();
    }
    
    if (my_membership && total > MY_MEMBERSHIP_REQUIREMENT) 
    {
      total -= total * MY_MEMBER_DISCOUNT;
    }
    
    return total;
  }
}
