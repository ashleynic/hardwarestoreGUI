/*
 * Hardware Store Management Software v0.1
 * Developed for CS3354: Object Oriented Design and Programming.
 * Copyright: Junye Wen (j_w236@txstate.edu)
 */

package hardwarestore.users;


/**
 *
 * @author Junye Wen
 */
public class Customer extends User {
    private String phoneNumber;
    private String address;

    /**
     * Constructor initializes a customer object with the provided values.
     * @param id
     * @param phoneNumber
     * @param address
     * @param firstName
     * @param lastName
     */
    public Customer(int id, String firstName, String lastName, String phoneNumber, String address) {
        super(id, firstName, lastName, false);
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    /**
     * Get the phone number.
     * @return phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Set the phone number.
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Get the address.
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set the address.
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Returns the attributes of the customer, in a formatted text fashion.
     * @return Formatted Text.
     */
    @Override
    public String getFormattedText() {
        return String.format("| %-10s| %-9s| %-12s| %-12s| Ph#: %12s, Add: %20s |%n",
                "Customer", id, firstName, lastName, phoneNumber, address);
    }

}