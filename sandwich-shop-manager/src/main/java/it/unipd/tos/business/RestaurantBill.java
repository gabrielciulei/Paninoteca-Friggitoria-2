////////////////////////////////////////////////////////////////////
// [Gabriel] [Ciulei] [1169766]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import java.util.List;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.MenuItem.ItemType;
import it.unipd.tos.business.TakeAwayBill;
import it.unipd.tos.business.exception.RestaurantBillException;


public class RestaurantBill implements TakeAwayBill {
    @Override
    public double getOrderPrice(List<MenuItem> itemsOrdered) throws RestaurantBillException {
        double total = 0;
        if (this.isOrderValid(itemsOrdered) == false) { throw new RestaurantBillException("Non si possono ordinare più di 30 prodotti."); }
        for(MenuItem item : itemsOrdered) {
            total += item.getPrice();
        }

        total -= totalDiscounts(itemsOrdered);
        if (total < 10) total += 0.5;
        return total;
    }

    private boolean isOrderValid(List<MenuItem> itemsOrdered) {
        return itemsOrdered.size() <= 30;
    }

    private double totalDiscounts(List<MenuItem> itemsOrdered) {
        double discounts = 0;
        discounts += discount50OnType(itemsOrdered, MenuItem.ItemType.PANINO, 5);
        discounts += discount10(itemsOrdered, 50);
        return discounts;
    }

    private double discount10(List<MenuItem> itemsOrdered, double overPrice) {
        double total = 0;
        for(MenuItem item : itemsOrdered) { 
            if (item.getItemType() == MenuItem.ItemType.PANINO || item.getItemType() == MenuItem.ItemType.FRITTO) {
                total += item.getPrice();
           }
        }

        if (total >= 50) {
            return total*0.1;
        }
        return 0;
    }

    private double discount50OnType(List<MenuItem> itemsOrdered, MenuItem.ItemType type, int count) {
        double cheapest = 99999999;
        int typesCount = 0;
        for(MenuItem item : itemsOrdered) {
            if (item.getItemType() == type) {
                typesCount++;
                if (item.getPrice() < cheapest) {
                    cheapest = item.getPrice();
                }
            } 
        }

        if (typesCount >= 5) {
            return cheapest/2;
        }
        return 0;
    }

}