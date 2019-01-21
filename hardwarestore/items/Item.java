/*
 * Hardware Store Management Software v0.1
 * Developed for CS3354: Object Oriented Design and Programming.
 * Copyright: Junye Wen (j_w236@txstate.edu)
 */
package hardwarestore.items;

/**
 * This class is a very simple representation of a hardware item. For parameters
 * except <CODE>quantity</CODE>, there are only getter methods and no setter methods as
 * basic info of an item cannot be mutated once initialized.
 *
 * An item object can also call the override methods
 * <CODE>equals()</CODE>
 *
 * @author Junye Wen
 */

import java.io.Serializable;

public abstract class Item implements Serializable {

    protected final String idNumber;
    protected final String name;
    protected int quantity;
    protected final float price;

    /**
     * This constructor initializes the item object. The constructor provides no
     * user input validation. That should be handled by the class that creates a
     * item object.
     *
     * @param idNumber a <b><CODE>String</CODE></b> that represents the ID
     *                 random string of length 5 â€“ can contain letters and numbers
     * @param name a <b><CODE>String</CODE></b> that represents the name
     * @param price an <b><CODE>float</CODE></b> that represents the price
     */
    public Item(String idNumber, String name, int quantity, float price) {
        this.idNumber = idNumber;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    /**
     * This method returns the item's tracking number.
     *
     * @return a <b><CODE>String</CODE></b> that is the ID number of the item.
     */
    public String getIdNumber() {
        return idNumber;
    }

    /**
     * This method returns the item's name.
     *
     * @return a <b><CODE>String</CODE></b> that is the item's name.
     */
    public String getName() {
        return name;
    }

    /**
     * This method returns the item's quantity.
     *
     * @return an <b><CODE>int</CODE></b> that is the item's weight
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * This method set the item's quantity.
     *
     *  @param quantity a <b><CODE>int</CODE></b> that represents the quantity
     */
    public void setQuantity(int quantity) {
        this.quantity= quantity;
    }

    /**
     * This method returns the item's price.
     *
     * @return a <b><CODE>float</CODE></b> that is the item's price
     */
    public float getPrice() {
        return price;
    }

    /**
     * This method provides a way to compare two item objects.
     *
     * @param c a <b><CODE>Item</CODE></b> object that is used to compare to
     * <b><CODE>this</CODE></b> item. Two orders are equal if their ID is the
     * same.
     * @return the <CODE>boolean</CODE> value of the comparison.
     */
    public boolean equals(Item c) {
        return c.getIdNumber().equals(this.idNumber);
    }

    /**
     * Abstract print method, to be implemented by subclasses of class User.
     * @return
     */
    public abstract String getFormattedText();
}