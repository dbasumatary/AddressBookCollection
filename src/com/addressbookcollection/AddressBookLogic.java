package com.addressbookcollection;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
/*Writing all the logic*/
public class AddressBookLogic {
    List<Contacts> addressList = new ArrayList<>();                         //Creating an arraylist to store the values
    String firstName,lastName,address,city, state, email, zipCode, phoneNumber;
    public void addContacts() {
        System.out.print("Enter First name: ");
        Scanner scanner = new Scanner(System.in);
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
        System.out.println(addressList);                 //Printing the list

    }
}