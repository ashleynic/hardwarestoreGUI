/*
 * Hardware Store Management Software v0.1
 * Developed for CS3354: Object Oriented Design and Programming.
 * Copyright: Junye Wen (j_w236@txstate.edu)
 */

package hardwarestore;

import java.io.Serializable;
import java.util.Date;

/**
 * This class represents a transaction in the Hardware Store Software.
 * @author Junye Wen
 */
public class Transaction implements Serializable {
    private final String itemID;
    private final Date saleDate;
    private final int saleQuantity;
    private final int customerId;
    private final int employeeId;

    /**
     * Constructor initializes a SaleTransaction object with the provided values.
     * @param itemID
     * @param saleDate
     * @param saleQuantity
     * @param customerId
     * @param employeeId
     */
    public Transaction(String itemID, Date saleDate, int saleQuantity, int customerId, int employeeId) {
        this.itemID = itemID;
        this.saleDate = saleDate;
        this.saleQuantity = saleQuantity;
        this.customerId = customerId;
        this.employeeId = employeeId;
    }

    /**
     * Get the item ID of this transaction.
     * @return itemID
     */
    public String getItemID() {
        return itemID;
    }

    /**
     * Get the sale date of this transaction.
     * @return saleDate
     */
    public Date getsaleDate() {
        return saleDate;
    }

    /**
     * Get the sale quantity of this transaction.
     * @return saleQuantity
     */
    public int getSaleQuantity() {
        return saleQuantity;
    }

    /**
     * Get the customer ID of this transaction.
     * @return customerId
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * Get the employee ID of this transaction.
     * @return
     */
    public int getEmployeeId() {
        return employeeId;
    }

    public String getFormattedText() {
        return String.format("| %-10s| %-30s| %-10s| %-12s| %-12s|%n",
                itemID, saleDate, saleQuantity, customerId, employeeId);
    }
    @Override
    public String toString() {
        return "Transaction{" + "itemID=" + itemID + ", saleDate=" + saleDate + ",  saleQuantity=" + saleQuantity
                + ", customerId=" + customerId + ", employeeId=" + employeeId + '}';
    }
}