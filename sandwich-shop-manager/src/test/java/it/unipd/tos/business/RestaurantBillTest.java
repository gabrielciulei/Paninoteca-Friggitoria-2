////////////////////////////////////////////////////////////////////
// [Gabriel] [Ciulei] [1169766]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import static org.junit.Assert.assertEquals;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import it.unipd.tos.business.RestaurantBill;
import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.MenuItem.ItemType;

public class RestaurantBillTest {

    List<MenuItem> menu = new ArrayList() {{
        add(new MenuItem(ItemType.BEVANDA, "bev 1", 2.0));
        add(new MenuItem(ItemType.FRITTO, "fritto 1", 4.5));
        add(new MenuItem(ItemType.PANINO, "panino 1", 4.5));
        add(new MenuItem(ItemType.PANINO, "panino 2", 4.0));
        add(new MenuItem(ItemType.PANINO, "panino 3", 3.5));
        add(new MenuItem(ItemType.PANINO, "panino 4", 4.5));
        add(new MenuItem(ItemType.PANINO, "panino 5", 3.5));
        add(new MenuItem(ItemType.PANINO, "panino 6", 34.99));
        add(new MenuItem(ItemType.FRITTO, "fritto 2", 3.5));
        add(new MenuItem(ItemType.BEVANDA, "bev 2", 2.0));
        add(new MenuItem(ItemType.PANINO, "panino 7", 3.0));
    }};
    List<MenuItem> orderNo50Discount, order50Discount, random;
    RestaurantBill bill;

    @Before
    public void before() {
        bill = new RestaurantBill();
        orderNo50Discount = new ArrayList() {{
            add(menu.get(2));
            add(menu.get(3));
            add(menu.get(4));
        }};

        random = new ArrayList() {{
            add(menu.get(1));
            add(menu.get(3));
            add(menu.get(4));
            add(menu.get(5));
            add(menu.get(7));
        }};

        order50Discount = new ArrayList() {{
            add(menu.get(2));
            add(menu.get(3));
            add(menu.get(4));
            add(menu.get(5));
            add(menu.get(6));
            add(menu.get(9));
            add(menu.get(10));
        }};
    }

    @Test
    public void orderPrice_50Discount_noDiscount() throws RestaurantBillException {
        double expected = 0;
        for(MenuItem item : orderNo50Discount) {
            expected += item.getPrice();
        }
        assertEquals(expected, bill.getOrderPrice(orderNo50Discount), 0.00);
    }

    @Test
    public void orderPrice_50Discount_hasDiscount() throws RestaurantBillException {
        double expected = 0;
        for(MenuItem item : order50Discount) {
            expected += item.getPrice();
        }
        expected -= 1.5;
        assertEquals(expected, bill.getOrderPrice(order50Discount), 0.00);
    }

}