/*
 * ItemOrder.java
 * TCSS 305 - Spring 2013
 */
/*
 * ItemOrder.java
 * TCSS 305 - Spring 2013
 */


/** 
 * @author Erica Putsche
 * @version 4/12/2013
 */
public class ItemOrder
{
  /**
   * Item in the ItemOrder.
   */
  private final Item my_item; 
  
  /**
   * Quantity of each item in the ItemOrder.
   */
  private final int my_quantity;
  
  /**
   * Constructs an ItemOrder.
   * 
   * @param an_item The item to be added to the ItemOrder.
   * @param a_quantity The quantity of the item to be added to the ItemOrder.
   */
  public ItemOrder(final Item an_item, final int a_quantity) 
  {
    my_item = an_item;
    my_quantity = a_quantity;
  }
  
  /**
   * Calculates the price of the ItemOrder.
   * @return The price of the ItemOrder.
   */
  public double calculatePrice() 
  {
    return my_item.calculatePriceFor(my_quantity);
  }
  
  /**
   * Gets the item contained in the ItemOrder.
   * @return The item contained in the ItemOrder.
   */
  public Item getItem() 
  {
    return my_item;
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() 
  {
    return this.my_item.toString();
  }
}
