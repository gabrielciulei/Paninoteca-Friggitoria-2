////////////////////////////////////////////////////////////////////
// [Gabriel] [Ciulei] [1169766]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import java.util.List;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.business.TakeAwayBill;
import it.unipd.tos.business.exception.RestaurantBillException;


public class RestaurantBill implements TakeAwayBill {
    @Override
    public double getOrderPrice(List<MenuItem> itemsOrdered) throws RestaurantBillException {
        double total = 0;
        for(MenuItem item : itemsOrdered) {
            total += item.getPrice();
        }
        return total;
    }
}