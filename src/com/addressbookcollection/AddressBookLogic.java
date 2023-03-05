package com.addressbookcollection;

import java.util.Scanner;
import java.util.*;
/*Writing the logic for the address book system*/
public class AddressBookLogic{
    Scanner scannerObject = new Scanner(System.in);
    public static ArrayList<Contacts> addressList = new ArrayList<>();                     //Creating an arraylist to store the values
    String firstName,lastName,address,city, state,email, zipCode, phoneNumber;             //All inputs are treated as string
    public void operation() {                                                //Method to input the operation the user wants to perform
        boolean flag = true;
        do{                                                              //Using a do-while loop
            System.out.println("\nChoose the following operation you want to perform");
            Scanner scannerObject = new Scanner(System.in);
            System.out.println("1. Add new entry\n2. Display Contacts\n3. Edit entry\n4. Delete entry\n5. Exit");
            switch (scannerObject.nextInt()) {
                case 1:
                    addContacts();
                    break;
                case 2:
                    displayContacts();
                    break;
                case 3:
                    editContacts();
                    break;
                case 4:
                    deleteContacts();
                    break;
                case 5:
                    flag = false;
                    System.out.println("Thank You !");
            }
        }while(flag);
    }
    public Contacts inputDetails() {                                                 //Method to add new contact details
        System.out.print("Enter first name: ");
        Scanner scanner = new Scanner(System.in);                               //Using scanner to input the details
        firstName = scanner.next();
        System.out.print("Enter last name: ");
        lastName = scanner.next();
        System.out.print("Enter address : ");
        address = scanner.next();
        System.out.print("Enter city name: ");
        city = scanner.next();
        System.out.print("Enter state name: ");
        state = scanner.next();
        System.out.print("Enter email address: ");
        email = scanner.next();
        System.out.print("Enter zip code: ");
        zipCode = scanner.next();
        System.out.print("Enter phone number: ");
        phoneNumber = scanner.next();
        Contacts contacts = new Contacts(firstName,lastName,address,city, state,email, zipCode, phoneNumber);
        addressList.add(contacts);
        return contacts;
    }
    public void addContacts() {                             // Method to create an object of Contact class with user input
        System.out.print("Please enter how many contacts you want to add: ");
        int n = scannerObject.nextInt();
        for (int i = 0; i < n; i++) {
            addressList.add(inputDetails());           //Adding the method inputDetails to the address list
            System.out.println();
        }
    }
    public void displayContacts() {                        // Display all the contacts in the address book arraylist

        for (Contacts contact : addressList) {         //Checking the entries and display them
            System.out.println(contact);
        }
    }
    public int findContact() {                             // Method to find the contact with name in the address book array list
        System.out.print("Please enter the first name of the person: ");
        String firstName = scannerObject.next();
        for (Contacts contact : addressList) {          //Checking the entries and searching for the first name
            if (firstName.compareToIgnoreCase(contact.getFirstName()) == 0) {
                return addressList.indexOf(contact);
            }
        }
        return -1;
    }
    public void editContacts() {                            // Method to edit contacts and then store into the array list
        int index = findContact();
        if (index == -1) {
            System.out.println("ERROR: There is no such contact");
            return;
        }
        System.out.println("Contact matched! Please enter the new details of the contact");
        addressList.set(index, inputDetails());
    }
    public void deleteContacts() {                         /*Method to delete contact by searching for the name and then delete*/
        int index = findContact();
        if (index == -1) {
            System.out.println(" ERROR: No such contact");
            return;
        }
        addressList.remove(index);
        System.out.println(" Contact deleted!");
    }
}
