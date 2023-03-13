package com.addressbookcollection;
import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;

/*Writing the logic for multiple address book system*/
public class AddressBookRegister{
    Scanner scannerObject = new Scanner(System.in);
    private List<Contacts> addressBooks;
    AddressBookLogic addLogic = new AddressBookLogic();
    public AddressBookRegister() {
        this.addressBooks = new ArrayList<>();
    }
    HashMap<String, AddressBookLogic> addressRegister = new HashMap<>();        //Hashmap of the address book
    public void operation() {                                               //Method to input the operation the user wants to perform
        boolean flag = true;
        do{                                                                 //Using a do-while loop
            System.out.println("\nChoose the following operation you want to perform");
            Scanner scannerObject = new Scanner(System.in);
            System.out.println("1. Add new entry\n2. Display Contacts\n3. Edit entry\n4. Delete entry \n5." +
                               " Add Address Book\n6. Search by City\n7. Search by State\n8. Exit");
            switch (scannerObject.nextInt()) {
                case 1:                                         // Add new contacts to the particular address book
                    addContacts();
                    break;
                case 2:
                    displayContacts();                         // Display all the contacts stored in the address book
                    break;
                case 3:
                    editContacts();                           // Edit a contact present in the address book
                    break;
                case 4:
                    deleteContacts();                         // Delete a contact from the address book
                    break;
                case 5:
                    addAddressBook();                          // Add a new address book to the array list
                    break;
                case 6:
                    searchByCity();                           // Search for people by city
                    break;
                case 7:
                    searchByState();                           // Search for people by state
                    break;
                case 8:
                    flag = false;                               //Exit from the program
                    System.out.println("Thank You !");
                default:
                    System.out.println("Please enter a valid option among the above ");          //For invalid choice entered
            }
        }while(flag);
    }
    public AddressBookLogic findAddress(String addBook){                    // To find address book object from the hash map
        for (Map.Entry<String, AddressBookLogic> index : addressRegister.entrySet()){
            if (index.getKey().equalsIgnoreCase(addBook)){
                return index.getValue();
            }
        }
        return null;
    }
    public void addAddressBook() {                                 //Method to create new address book in the hash map.
        System.out.println("Please enter the name of the address book: ");
        String name = scannerObject.next();

        if (addressRegister.get(name) != null) {                  //The name of address book has to be unique

            System.out.println("Warning ERROR !: An address book of this name already exists");
            return;
        }
        addressRegister.put(name, new AddressBookLogic());
    }
    public void addContacts() {                            // Calling the addContacts method from the AddressBookLogic class
        System.out.print("Please enter the name of address book to add: ");
        String string = scannerObject.next();
        AddressBookLogic addBook = findAddress(string);
        if(addBook == null) {
            System.out.println("Warning ERROR !: An address book of this name does not exist");
            return;
        }
        addBook.addContacts();
    }

    //method to search person across address books by city
    public void searchByCity(){
        System.out.print("Enter the name of city where the person resides: ");
        String inputCity= scannerObject.next();
        addressRegister.get(addLogic).addressList.stream()
                .filter(search -> inputCity.equals(search.getCity()))
                .forEach(element -> System.out.println(element));
    }

    //method to search person across address books by state
    public void searchByState(){
        System.out.print("Enter the name of state where the person resides: ");
        String inputState= scannerObject.next();
        addressRegister.get(addLogic).addressList.stream()
                .filter(search -> inputState.equals(search.getState()))
                .forEach(element -> System.out.println(element));
    }


    public void displayContacts() {                        // Calling the displayContacts method from the AddressBookLogic class
        System.out.print("Please enter the name of address book to display: ");
        String string = scannerObject.next();
        AddressBookLogic addBook = findAddress(string);
        if(addBook == null) {
            System.out.println("Warning ERROR !: An address book of this name does not exist");
            return;
        }
        addBook.displayContacts();
    }
    public void editContacts() {                            // Calling the editContacts method from the AddressBookLogic class
        System.out.print("Please enter the name of address book to edit: ");
        String string = scannerObject.next();
        AddressBookLogic addBook = findAddress(string);
        if(addBook == null) {
            System.out.println("Warning ERROR !: An address book of this name does not exist");
            return;
        }
        addBook.editContacts();
    }
    public void deleteContacts() {                         // Calling the deleteContacts method from the AddressBookLogic class
        System.out.print("Please enter the name of address book to delete: ");
        String string = scannerObject.next();
        AddressBookLogic addBook = findAddress(string);
        if(addBook == null) {
            System.out.println("Warning ERROR !: An address book of this name does not exist");
            return;
        }
        addBook.deleteContacts();
    }
}

