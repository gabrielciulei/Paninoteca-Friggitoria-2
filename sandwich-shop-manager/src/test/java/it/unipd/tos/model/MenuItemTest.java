////////////////////////////////////////////////////////////////////
// [Gabriel] [Ciulei] [1169766] 
////////////////////////////////////////////////////////////////////
package it.unipd.tos.model;

import static org.junit.Assert.*;
import org.junit.Test;

public class MenuItemTest {
    MenuItem item = new MenuItem(MenuItem.ItemType.PANINO, "Nome panino", 10.00);
    @Test
    public void model_construction_getPrice() {
        assertEquals(10.0, item.getPrice(), 0);
    }
    
    @Test
    public void model_construction_getItemType() {
        assertEquals(MenuItem.ItemType.PANINO, item.getItemType());
    }
}