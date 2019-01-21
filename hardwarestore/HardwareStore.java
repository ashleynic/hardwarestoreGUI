/*
 * Hardware Store Management Software v0.1
 * Developed for CS3354: Object Oriented Design and Programming.
 * Copyright: Junye Wen (j_w236@txstate.edu)
 */
package hardwarestore;

import hardwarestore.items.Appliances;
import hardwarestore.items.Item;
import hardwarestore.items.SmallHardwareItems;
import hardwarestore.users.Customer;
import hardwarestore.users.Employee;
import hardwarestore.users.User;

import java.io.*;
import java.util.*;

/**
 * This class is used to represent a database interface for a list of
 * <CODE>item</CODE>'s. It using a plain-text file "database.txt" to store and
 * write item objects in readable text form. It contains an
 * <CODE>ArrayList</CODE> called <CODE>itemList</CODE> to store the database in
 * a runtime friendly data structure. The <CODE>itemList</CODE> is written to
 * "database.txt" at the end of the <CODE>HardwareStore</CODE> object's life by
 * calling <CODE>writeDatabase()</CODE>. This class also provides methods for
 * adding, removing, and searching for items in the list.
 *
 * @author Junye Wen
 */
public class HardwareStore {

    private static ArrayList<Item> itemList;
    private static ArrayList<User> userList;
    private static ArrayList<Transaction> transactionList;
    private static int userIdCounter;

    private static final String DATA_FILE_NAME = "database.ser";

    /**
     * This constructor creates an empty ArrayList and then calls the 
     * <CODE>readDatabase()</CODE> method to populate items previously stored. 
     *
     * @throws IOException
     */
    public HardwareStore() throws IOException {
        readDatabase();
    }

    /**
     * Method getAllItemsFormatted returns the current list of items in the Arraylist in
     * no particular order.
     *
     * @return a formatted String representation of all the items in itemList.
     */
    public String getAllItemsFormatted() {
        return getFormattedItemList(itemList);
    }

    /**
     * Private method getFormattedItemList used as an auxiliary method to return a given ArrayList
     * of items in a formatted manner.
     *
     * @param items the item list to be displayed.
     * @return a formatted String representation of all the items in the list give as a parameter.
     */
    private String getFormattedItemList(ArrayList<Item> items) {

        String text = " ------------------------------------------------------------------------------------------------------------------\n" +
                String.format("| %-8s| %-25s| %-10s| %-10s| %-20s| %-30s|%n", "Item ID", "Name", "Quantity", "Price", "Item Type", "Category / Brand and type") +
                " ------------------------------------------------------------------------------------------------------------------\n";

        for (Item item : items) {
            text += item.getFormattedText();
            text += " ------------------------------------------------------------------------------------------------------------------\n";
        }
        //text += " ------------------------------------------------------------------------------------------------------------------\n";

        return text;
    }

    /**
     * Method getAllItemsFormatted returns the current list of users in the Arraylist in
     * no particular order.
     *
     * @return a formatted String representation of all the users in userList.
     */
    public String getAllUsersFormatted() {
        return getFormattedUserList(userList);
    }

    /**
     * Private method getFormattedUserList used as an auxiliary method to return a given ArrayList
     * of users in a formatted manner.
     *
     * @param users the user list to be displayed.
     * @return a formatted String representation of all the users in the list give as a parameter.
     */
    private String getFormattedUserList(ArrayList<User> users) {

        String text = " -------------------------------------------------------------------------------------------------\n" +
                String.format("| %-10s| %-9s| %-12s| %-12s| %-45s|%n", "User Type", "User ID", "First Name", "Last Name", "Special") +
                " -------------------------------------------------------------------------------------------------\n";

        for (User user : users) {
            text += user.getFormattedText();
            text += " -------------------------------------------------------------------------------------------------\n";
        }
        //text += " -------------------------------------------------------------------------------------------------\n";

        return text;
    }

    /**
     * Method getAllTransactionsFormatted returns the current list of transactions in the Arraylist in
     * no particular order.
     *
     * @return a formatted String representation of all the transactions in transactionList.
     */
    public String getAllTransactionsFormatted() {
        return getFormattedTransactionList(transactionList);
    }

    /**
     * Private method getFormattedTransactionList used as an auxiliary method to return a given ArrayList
     * of items in a formatted manner.
     *
     * @param transactions the transaction list to be displayed.
     * @return a formatted String representation of all the items in the list give as a parameter.
     */
    private String getFormattedTransactionList(ArrayList<Transaction> transactions) {

        String text = " -----------------------------------------------------------------------------------\n" +
                String.format("| %-10s| %-30s| %-10s| %-12s| %-12s|%n", "Item ID", "Date", "Quantity", "Customer ID", "Employee ID") +
                " -----------------------------------------------------------------------------------\n";

        for (Transaction transaction : transactions) {
            text += transaction.getFormattedText();
            text += " -----------------------------------------------------------------------------------\n";
        }
        //text += " -----------------------------------------------------------------------------------\n";

        return text;
    }



    /**
     * This method is used to add a small hardware item to the itemList ArrayList.
     *
     * @param idNumber a <CODE>String</CODE> representing the ID number of item
     * @param name a <CODE>String</CODE> representing the name of item
     * @param quantity an <CODE>int</CODE> representing the quantity of item
     * @param price a <CODE>float</CODE> representing the price of item
     * @param category a <CODE>String</CODE> representing the category of item
     */
    public static void addNewSmallHardwareItem(String idNumber, String name, int quantity, float price, String category) {
        //If passed all the checks, add the item to the list
        itemList.add(new SmallHardwareItems(idNumber, name, quantity, price, category));
        System.out.println("New small hardware item has been added.");
    }

    /**
     * This method is used to add an appliance to the itemList ArrayList.
     *
     * @param idNumber a <CODE>String</CODE> representing the ID number of item
     * @param name a <CODE>String</CODE> representing the name of item
     * @param quantity an <CODE>int</CODE> representing the quantity of item
     * @param price a <CODE>float</CODE> representing the price of item
     * @param brand a <CODE>String</CODE> representing the brand of item
     * @param type a <CODE>String</CODE> representing the type of item
     */
    public static void addNewAppliance(String idNumber, String name, int quantity, float price, String brand, String type) {
        //If passed all the checks, add the item to the list
        itemList.add(new Appliances(idNumber, name, quantity, price, brand, type));
        System.out.println("New appliance has been added.");
    }


    /**
     * @param firstName a <CODE>String</CODE> representing the first name of user
     * @param lastName a <CODE>String</CODE> representing the last name of user
     * @param phoneNumber a <CODE>String</CODE> representing the telephone number of user
     * @param address a <CODE>String</CODE> representing the address of user
     */
    public static void addCustomer(String firstName, String lastName, String phoneNumber, String address) {
        userList.add(new Customer(userIdCounter++, firstName, lastName, phoneNumber, address));
        sortUserList();
        System.out.println("New customer has been added.");
    }

    /**
     * @param firstName a <CODE>String</CODE> representing the first name of user
     * @param lastName a <CODE>String</CODE> representing the last name of user
     * @param ssn an <CODE>int</CODE> representing the ssn of user
     * @param monthlySalary a <CODE>float</CODE> representing the monthly salary of user
     */
    public static void addEmployee(String firstName, String lastName, int ssn, float monthlySalary) {
        userList.add(new Employee(userIdCounter++, firstName, lastName, ssn, monthlySalary));
        sortUserList();
        System.out.println("New employee has been added.");
    }


    /**
     * Add a certain quantity of the given item index.
     * Preconditions: 1. Item exists.
     * @param itemIndex the index of the item in the itemList
     * @param quantity  the quantity to add
     */
    public void addQuantity(int itemIndex, int quantity) {
        Item temp = getItem(itemIndex);
        temp.setQuantity(temp.getQuantity() + quantity);
        System.out.println("Quantity updated.");
    }

    /**
     * Removes a certain quantity of the given item index. 
     * Preconditions: 1. Item exists. 2. Quantity to remove smaller than current quantity.
     * @param itemIndex the index of the item in the itemList
     * @param quantity  the quantity to remove
     */
    public void removeQuantity(int itemIndex, int quantity) {
        Item temp = getItem(itemIndex);
        temp.setQuantity(temp.getQuantity() - quantity);
        System.out.println("Quantity updated.\n");
    }

    /**
     * Returns all the items that (partially) match the given name.
     * @param name the name to match.
     * @return a string containing a table of the matching items.
     */
    public String getMatchingItemsByName(String name) {
        ArrayList<Item> temp = new ArrayList<Item>();
        for (Item tempItem : itemList) {
            if (tempItem.getName().toLowerCase().contains(name.toLowerCase())) {
                temp.add(tempItem);
            }
        }

        if (temp.size() == 0) {
            return null;
        } else {
            return getFormattedItemList(temp);
        }
    }

    /**
     * Returns all the items with current quantity lower than (or equal) the
     * given threshold.
     * @param quantity the quantity threshold.
     * @return a string containing a table of the matching items.
     */
    public String getMatchingItemsByQuantity(int quantity) {
        ArrayList<Item> temp = new ArrayList<Item>();
        for (Item tempItem : itemList) {
            if (tempItem.getQuantity() <= quantity) {
                temp.add(tempItem);
            }
        }

        if (temp.isEmpty()) {
            return null;
        } else {
            return getFormattedItemList(temp);
        }
    }

    /**
     * This method can be used to find a item in the Arraylist of items.
     *
     * @param id a <CODE>String</CODE> that represents the ID of
     * the item that to be searched for.
     * @return the <CODE>Item</CODE> in the Arraylist of
     * items, or null if the search failed.
     */
    public Item findItem(String id) {
        Item item = null;
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getIdNumber().equals(id)) {
                item = itemList.get(i);
                break;
            }

        }
        return item;
    }


    /**
     * This method can be used to find a item in the Arraylist of items.
     *
     * @param idNumber a <CODE>String</CODE> that represents the ID number of
     * the item that to be searched for.
     * @return the <CODE>int</CODE> index of the items in the Arraylist of
     * items, or -1 if the search failed.
     */
    public int findItemIndex(String idNumber) {
        int index = -1;
        for (int i = 0; i < itemList.size(); i++) {
            String temp = itemList.get(i).getIdNumber();

            if (idNumber.equalsIgnoreCase(temp)) {
                index = i;
                break;
            }

        }
        return index;
    }

    /**
     * This method can be used to find a user in the Arraylist of users.
     *
     * @param id an <CODE>int</CODE> that represents the ID of
     * the user that to be searched for.
     * @return the <CODE>User</CODE> in the Arraylist of
     * users, or null if the search failed.
     */
    public User findUser(int id) {
        User user = null;
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId() == id) {
                user = userList.get(i);
                break;
            }

        }
        return user;
    }


    /**
     * This method can be used to find the index of user in the Arraylist of users.
     *
     * @param id a <CODE>String</CODE> that represents the ID of
     * the user that to be searched for.
     * @return the <CODE>int</CODE> index of the user in the Arraylist of
     * users, or -1 if the search failed.
     */
    public int findUserIndex(int id) {
        int index = -1;
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId() == id) {
                index = i;
                break;
            }

        }
        return index;
    }
    /**
     * This method will edit information of an customer.
     * It will first remove the old entry and add a new one with same user ID
     * @param idInput the <CODE>int</CODE> index of the user's ID
     * @param firstName a <CODE>String</CODE> representing the first name of user
     * @param lastName a <CODE>String</CODE> representing the last name of user
     * @param phoneNumber a <CODE>String</CODE> representing the telephone number of user
     * @param address a <CODE>String</CODE> representing the address of user
     */
    public void editCustomerInformation(int idInput, String firstName, String lastName, String phoneNumber, String address) {
        userList.remove(findUserIndex(idInput));
        userList.add(new Customer(idInput, firstName, lastName, phoneNumber, address));
        sortUserList();
        System.out.println("Customer information updated.");
    }


    /**
     * This method will edit information of an employee.
     * It will first remove the old entry and add a new one with same user ID
     * @param idInput the <CODE>int</CODE> index of the user's ID
     * @param firstName a <CODE>String</CODE> representing the first name of user
     * @param lastName a <CODE>String</CODE> representing the last name of user
     * @param socialSecurityNumber an <CODE>int</CODE> representing the ssn of user
     * @param monthlySalary a <CODE>float</CODE> representing the monthly salary of user
     */
    public void editEmployeeInformation(int idInput, String firstName, String lastName, int socialSecurityNumber, float monthlySalary) {
        userList.remove(findUserIndex(idInput));
        userList.add(new Employee(idInput, firstName, lastName, socialSecurityNumber, monthlySalary));
        sortUserList();
        System.out.println("Employee information updated.");

    }

    /**
     * This method can be used to remove a item in the Arraylist of items.
     *
     * @param itemIndex an <CODE>int</CODE> that represents the Index of
     * the item in the list that to be removed.
     */
    public void removeItem(int itemIndex) {
        itemList.remove(itemIndex);
    }

    /**
     * This method is used to retrieve the Item object from the
     * <CODE>itemList</CODE> at a given index.
     *
     * @param i the index of the desired <CODE>Item</CODE> object.
     * @return the <CODE>Item</CODE> object at the index or null if the index is
     * invalid.
     */
    public Item getItem(int i) {
        if (i < itemList.size() && i >= 0) {
            return itemList.get(i);
        } else {
            System.out.println("Invalid Index.");
            return null;
        }
    }

    /**
     * This method will add a transaction to the list, and remove the quantity for the target item.
     * @param itemId a <CODE>String</CODE> representing the ID of item
     * @param saleQuantity an <CODE>int</CODE> of the quantity
     * @param customerId an <CODE>int</CODE> representing the ID of customer
     * @param employeeId an <CODE>int</CODE> representing the ID of employee
     * @param itemIndex an <CODE>int</CODE> representing the index of item in the list, used to reduce the quantity.
     */
    public void progressTransaction(String itemId, int saleQuantity, int customerId, int employeeId, int itemIndex) {
        transactionList.add(new Transaction(itemId, new Date(), saleQuantity, customerId, employeeId));
        addQuantity(itemIndex, -1*saleQuantity);
    }

    /**
     * This method opens the database file and overwrites it with a
     * serialized representation of all the items in the <CODE>itemList</CODE>,
     * all users in the <CODE>userList</CODE>, all transactions in the
     * <CODE>transactionList</CODE>, and the <CODE>userIdCounter</CODE>.
     * This should be the last method to be called before exiting the program.
     *
     * @throws IOException
     */
    public void writeDatabase() throws IOException {
        //serialize the database
        OutputStream file = null;
        OutputStream buffer = null;
        ObjectOutput output = null;
        try {
            file = new FileOutputStream(DATA_FILE_NAME);
            buffer = new BufferedOutputStream(file);
            output = new ObjectOutputStream(buffer);

            output.writeObject(itemList);
            output.writeObject(userList);
            output.writeObject(transactionList);
            output.writeInt(userIdCounter);

            output.close();
        } catch (IOException ex) {
            System.err.println(ex.toString());
        } finally {
            close(file);
        }
        System.out.println("Done.");
    }

    /**
     * The method opens the database file and initializes the <CODE>itemList</CODE>,
     * <CODE>userList</CODE>, <CODE>transactionList</CODE> and the <CODE>userIdCounter</CODE>
     * with their contents. If no such file exists, then one is created.
     * The contents of the file are "loaded" into the itemList ArrayList in no 
     * particular order. The file is then closed during the duration of the 
     * program until <CODE>writeDatabase()</CODE> is called.
     *
     * @throws IOException
     */
    public void readDatabase() throws IOException {

        System.out.print("Reading database...");

        File dataFile = new File(DATA_FILE_NAME);

        // Try to read existing dealership database from a file
        InputStream file = null;
        InputStream buffer = null;
        ObjectInput input = null;
        try {
            if (!dataFile.exists()) {
                System.out.println("Data file does not exist. Creating a new database.");
                itemList = new ArrayList<Item>();
                userList = new ArrayList<User>();
                transactionList = new ArrayList<Transaction>();
                userIdCounter = 1;
                return;
            }
            file = new FileInputStream(dataFile);
            buffer = new BufferedInputStream(file);
            input = new ObjectInputStream(buffer);

            // Read serialized data
            itemList = (ArrayList<Item>) input.readObject();
            userList = (ArrayList<User>) input.readObject();
            transactionList = (ArrayList<Transaction>) input.readObject();
            userIdCounter = input.readInt();

            input.close();
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.toString());
        } catch (FileNotFoundException ex) {
            System.err.println("Database file not found.");
        } catch (IOException ex) {
            System.err.println(ex.toString());
        } finally {
            close(file);
        }
        System.out.println("Done.");
    }

    /**
     * Auxiliary convenience method used to close a file and handle possible
     * exceptions that may occur.
     *
     * @param c
     */
    public static void close(Closeable c) {
        if (c == null) {
            return;
        }
        try {
            c.close();
        } catch (IOException ex) {
            System.err.println(ex.toString());
        }
    }

    /**
     * This method will sort the item list, based on the item ID.
     */
    public static void sortItemList() {
        itemList.sort(new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                if (o1.getIdNumber().compareTo(o2.getIdNumber())>0) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

    }
    /**
     * This method will sort the user list, based on the user ID.
     */
    public static void sortUserList() {
        userList.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                if (o1.getId()>o2.getId()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

    }
}