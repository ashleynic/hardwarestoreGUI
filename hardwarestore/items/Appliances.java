/*
 * Hardware Store Management Software v0.1
 * Developed for CS3354: Object Oriented Design and Programming.
 * Copyright: Junye Wen (j_w236@txstate.edu)
 */

package hardwarestore.items;


/**
 *
 * @author Junye Wen
 */
public class Appliances extends Item {
    protected final String brand;
    protected final String type;

    /**
     * Constructor initializes a customer object with the provided values.
     * @param idNumber
     * @param name
     * @param quantity
     * @param price
     * @param brand
     * @param type a <b><CODE>String</CODE></b> that represents the type.
     *                "Refrigerators", "Washers&Dryers", "Ranges&Ovens", "Small Appliance".
     */
    public Appliances(String idNumber, String name, int quantity, float price, String brand, String type) {
        super(idNumber, name, quantity, price);
        this.brand = brand;
        this.type = type;
    }

    /**
     * Get the brand.
     * @return brand
     */
    public String getBrand() {
        return brand;
    }


    /**
     * Get the type.
     * @return type
     */
    public String getType() {
        return type;
    }


    /**
     * Returns the attributes of the appliance, in a formatted text fashion.
     * @return Formatted Text.
     */
    @Override
    public String getFormattedText() {
        return String.format("| %-8s| %-25s| %-10s| %-10s| %-20s| %-30s|%n",
                this.getIdNumber(),
                this.getName(),
                Integer.toString(this.getQuantity()),
                String.format("%.2f", this.getPrice()),
                "Appliances",
                this.getBrand()+" "+ this.getType()
        );
    }

}