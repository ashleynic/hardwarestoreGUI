/*
 * Hardware Store Management Software v0.1
 * Developed for CS3354: Object Oriented Design and Programming.
 * Copyright: Junye Wen (j_w236@txstate.edu)
 */

package hardwarestore.users;

import java.io.Serializable;

/**
 * User is a superclass for all specific types of actors in the system
 * @author Junye Wen
 */
public abstract class User implements Serializable {

    protected final int id;
    protected String firstName;
    protected String lastName;
    public final boolean isEmployee;

    /**
     * Constructor initializes a user object with the provided values.
     * @param id User ID
     * @param firstName First Name
     * @param lastName Last Name
     */
    public User(int id, String firstName, String lastName, boolean isEmployee) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isEmployee = isEmployee;
    }

    /**
     * Get the last name.
     * @return lastName Last Name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the last name.
     * @param lastName Last Name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get the user ID.
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Get the first name.
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the first name.
     * @param firstName First Name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Abstract print method, to be implemented by subclasses of class User.
     * @return
     */
    public abstract String getFormattedText();
}