////////////////////////////////////////////////////////////////////
// [Gabriel] [Ciulei] [1169766]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business.exception;

public class RestaurantBillException extends Exception {
    /**
     *  Something went wrong with the bill
     */
    private static final long serialVersionUID = 1L;

    public RestaurantBillException(String message) {
        super(message);
    }
}