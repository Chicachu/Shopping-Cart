import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 */

/**
 * @author Erica Putsche
 * @version 04/16/2013
 */
public class ItemTest
{
  /**
   * A tolerance used when testing double values for equality.
   */
  private static final Double TOLERANCE = .00001;
  
  /**
   * A string used many times throughout this file.
   */
  private static final String BAMBOO = "Bamboo"; 
  
  /**
   * Another string used many times throughout this file.
   */
  private static final String MESSAGE = "My other item does not equal my same item.";

  /**
   * An item used in tests.
   */
  private Item my_item; 
  
  /**
   * An item used in tests.
   */
  private Item my_same_item;
  
  /**
   * Another item used in tests.
   */
  private Item my_other_item;
  
  /**
   * An item order used in tests.
   */
  private ItemOrder my_item_order;
  
  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp()  //throws Exception
  {
    my_item = new Item("My Little Pony" , 7.99);
    my_other_item = new Item(BAMBOO, 4.99, 10, 45);
    my_same_item = new Item(BAMBOO, 4.99, 10, 45);
    my_item_order = new ItemOrder(my_item, 2);
  }

  /**
   * Test method for {@link Item#hashCode()}.
   */
  @Test
  public void testHashCode()
  {
    assertEquals("Hashcode not correct!", my_item.toString().hashCode(), my_item.hashCode());
    assertEquals("Hashcode not correct!", my_other_item.toString().hashCode(),
                 my_other_item.hashCode());
  }

  /**
   * Test method for {@link Item#Item(java.lang.String, double)}.
   */
  @Test
  public void testItemStringDouble()
  {
    assertEquals("Item toString() is incorrect!", "My Little Pony, $7.99", my_item.toString());
  }

  /**
   * Test method for {@link Item#Item(java.lang.String, double, int, double)}.
   */
  @Test
  public void testItemStringDoubleIntDouble()
  {
    assertEquals("Item toString() is incorrect!", "Bamboo, $4.99 (10 for $45.00)", 
                 my_other_item.toString());
  }

  /**
   * Test method for {@link Item#calculatePriceFor(int)}.
   */
  @Test
  public void testCalculatePriceFor()
  {
    assertEquals(7.99, my_item.calculatePriceFor(1), TOLERANCE);
    assertEquals(9.98, my_other_item.calculatePriceFor(2), TOLERANCE);
    assertEquals(45, my_other_item.calculatePriceFor(10), TOLERANCE); // even bulk quantity
    assertEquals(90, my_other_item.calculatePriceFor(20), TOLERANCE); // large even bulk 
                                                                             // quantity
    assertEquals(54.98, my_other_item.calculatePriceFor(12), TOLERANCE); // bulk + extra
                                                            // 10 for 45 + 2 * 4.99 = 54.98
  }



  /**
   * Test method for {@link Item#equals(java.lang.Object)}.
   */
  @Test
  public void testEqualsObject()
  {
    assertEquals("My other item doesn't equal my same item.", my_other_item, my_same_item);
    assertFalse("My item does not equal my other item.", my_item.equals(my_other_item));
    assertFalse("My item does not equal my item order.", my_item.equals(my_item_order));
    
    my_same_item = new Item(BAMBOO, 4.99, 8, 45);
    assertFalse(MESSAGE, my_other_item.equals(my_same_item));
    
    my_same_item = new Item(BAMBOO, 4.99, 10, 22);
    assertFalse(MESSAGE, my_other_item.equals(my_same_item));
    
    my_same_item = new Item(BAMBOO, 5.99, 5, 22);
    assertFalse(MESSAGE, my_other_item.equals(my_same_item));
    
    my_same_item = new Item("Bamboo2", 5.99, 5, 17);
    assertFalse(MESSAGE, my_other_item.equals(my_same_item));
  }

}
