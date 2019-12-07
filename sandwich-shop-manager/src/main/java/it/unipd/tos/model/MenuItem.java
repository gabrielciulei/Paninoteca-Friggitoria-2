////////////////////////////////////////////////////////////////////
// [Gabriel] [Ciulei] [1169766]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.model;

public class MenuItem {
    public enum ItemType {
        PANINO, FRITTO, BEVANDA
    }

    ItemType itemType;
    String name;
    double price;

    public MenuItem(ItemType type, String name, double price) {
        this.itemType = type;
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    public ItemType getItemType() {
        return this.itemType;
    }

}