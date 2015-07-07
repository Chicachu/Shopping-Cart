/*
 * Item.java
 * TCSS 305 - Spring 2013 
 */

import java.text.NumberFormat;

/**
 * @author Erica Putsche
 * @version 04/12/2013
 */
public class Item
{
  /**
   * The name of the item.
   */
  private final String my_name;
  
  /**
   * The price of the item.
   */
  private final double my_price; 
  
  /**
   * The bulk quantity of the item.
   */
  private final int my_bulk_quantity;
  
  /**
   * The bulk price of the item.
   */
  private final double my_bulk_price; 
  
  /**
   * Constructs a non-bulk item.
   * 
   * @param a_name The name of the item to be constructed.
   * @param a_price The price of the item to be constructed.
   */
  public Item(final String a_name, final double a_price) 
  {
    my_name = a_name;
    my_price = a_price;
    my_bulk_quantity = 0;
    my_bulk_price = 0.0;
  }
  
  /**
   * Constructs a bulk item.
   * 
   * @param a_name The name of the item to be constructed.
   * @param a_price The price of the item to be constructed.
   * @param a_bulk_quantity The bulk quantity of the item to be constructed.
   * @param a_bulk_price The bulk price of the item to be constructed.
   */
  public Item(final String a_name, final double a_price, final int a_bulk_quantity, 
              final double a_bulk_price) 
  {
    my_name = a_name;
    my_price = a_price; 
    my_bulk_quantity = a_bulk_quantity;
    my_bulk_price = a_bulk_price; 
  }
  
  /**
   * Calculates the price of an item given the quantity.
   * 
   * @param a_quantity The quantity of the item.
   * @return The price of the item based on the quantity.
   */
  public double calculatePriceFor(final int a_quantity) 
  {
    double price; 
    
    if ((this.my_bulk_quantity == 0) || (a_quantity < my_bulk_quantity)) 
    {
      price = a_quantity * my_price;
    } 
    else 
    {
      price = (a_quantity / my_bulk_quantity) * my_bulk_price
            + (a_quantity % my_bulk_quantity) * my_price;
    }
    return price;
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() 
  {
    final NumberFormat nf = NumberFormat.getCurrencyInstance();
    final StringBuilder sb = new StringBuilder(); 
    sb.append(my_name + ", " + nf.format(my_price));
    if (this.my_bulk_quantity != 0) 
    {
      sb.append(" (" + my_bulk_quantity + " for " + nf.format(my_bulk_price) + ")");
    }
    return sb.toString();
  }

  
  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(final Object the_other) 
  {
    boolean equal = false;
    if (the_other instanceof Item) 
    {
      final Item other = (Item) the_other;
      if (this.my_name.equals(other.my_name) && this.my_price == other.my_price
          && this.my_bulk_quantity == other.my_bulk_quantity
              && this.my_bulk_price == other.my_bulk_price) 
      {
        equal = true;
      }
    }
    return equal;
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() 
  {
    return this.toString().hashCode();
  }
}
