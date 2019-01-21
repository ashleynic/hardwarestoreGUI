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
public class SmallHardwareItems extends Item {
    protected final String category;

    /**
     * Constructor initializes a customer object with the provided values.
     * @param idNumber
     * @param name
     * @param quantity
     * @param price
     * @param category a <b><CODE>String</CODE></b> that represents the category.
     *                â€œDoor&Windowâ€, â€œCabinet& Furnitureâ€, â€œFastenersâ€, â€œStructuralâ€, â€œOtherâ€.
     */
    public SmallHardwareItems(String idNumber, String name, int quantity, float price, String category) {
        super(idNumber, name, quantity, price);
        this.category = category;
    }

    /**
     * Get the category.
     * @return category
     */
    public String getCategory() {
        return category;
    }


    /**
     * Returns the attributes of the small hardware item, in a formatted text fashion.
     * @return Formatted Text.
     */
    @Override
    public String getFormattedText() {
        return String.format("| %-8s| %-25s| %-10s| %-10s| %-20s| %-30s|%n",
                this.getIdNumber(),
                this.getName(),
                Integer.toString(this.getQuantity()),
                String.format("%.2f", this.getPrice()),
                "Small Hardware Items",
                this.getCategory()
        );
    }

}