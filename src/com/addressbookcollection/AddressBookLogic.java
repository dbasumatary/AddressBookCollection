package com.addressbookcollection;
import java.util.Scanner;
import java.util.Iterator;
import java.util.*;

public class AddressBookLogic{
    Scanner scannerObject = new Scanner(System.in);

    //Creating an arraylist to store the contacts
    List<Contacts> addressList = new ArrayList<>();
    String firstName,lastName,address,city, state,email, zipCode, phoneNumber;
    public void operation() {                            //Method to input the operation the user wants to perform
        boolean flag = true;
        do{                                             //Using a do-while loop
            System.out.println("\nChoose the following operation you want to perform");
            Scanner scannerObject = new Scanner(System.in);
            System.out.println("1. Add new entry\n2. Edit existing entry\n3. Exit");
            switch (scannerObject.nextInt()) {
                case 1:
                    addContacts();
                    break;
                case 2:
                    editContacts();
                    break;
                case 3:
                    flag = false;
                    System.out.println("Thank You !");
            }
        }while(flag);
    }
    public void addContacts() {                           //Method to add new contact details
        System.out.println("Enter first name: ");
        Scanner scanner = new Scanner(System.in);
        firstName = scanner.next();
        System.out.println("Enter last name: ");
        lastName = scanner.next();
        System.out.println("Enter address : ");
        address = scanner.next();
        System.out.println("Enter city name: ");
        city = scanner.next();
        System.out.println("Enter state name: ");
        state = scanner.next();
        System.out.println("Enter email address: ");
        email = scanner.next();
        System.out.println("Enter zip code: ");
        zipCode = scanner.next();
        System.out.println("Enter phone number: ");
        phoneNumber = scanner.next();
        Contacts contacts = new Contacts(firstName,lastName,address,city, state,email, zipCode, phoneNumber);
        addressList.add(contacts);
        System.out.println(addressList);                           //Printing the list
    }
    public void editContacts(){                                       //Method to edit existing contact details
        System.out.println("Enter the first name:");
        String firstName = scannerObject.next();
        Iterator<Contacts> iterator = addressList.listIterator();     //Access and returns a list iterator over the elements
        while(iterator.hasNext()) {                                  //returns true if it has another token in its input
            Contacts person = iterator.next();
            if(firstName.equals(person.getFirstName()) ) {         //Checking if user input name equals the name stored
                System.out.println("\nChoose the following you want to change:");
                System.out.println("1. First Name\n2. Last Name\n3. Phone Number\n4. Email\n5. City\n6. State\n7. Zip Code\n8. Address");
                int choice = scannerObject.nextInt();

                switch(choice) {                                                //Switch case to edit person details
                    case 1:
                        System.out.println("Enter the correct first name :");
                        String FirstName = scannerObject.next();
                        person.setFirstName(FirstName);
                        break;
                    case 2:
                        System.out.println("Enter the correct last name :");
                        String lastName = scannerObject.next();
                        person.setLastName(lastName);
                        break;
                    case 3:
                        System.out.println("Enter the correct phone number :");
                        String phoneNumber = scannerObject.next();
                        person.setPhoneNumber(phoneNumber);
                        break;
                    case 4:
                        System.out.println("Enter the correct email address :");
                        String email = scannerObject.next();
                        person.setEmail(email);
                        break;
                    case 5:
                        System.out.println("Enter the correct city :");
                        String city = scannerObject.next();
                        person.setCity(city);
                        break;
                    case 6:
                        System.out.println("Enter the correct state :");
                        String state = scannerObject.next();
                        person.setState(state);
                        break;
                    case 7:
                        System.out.println("Enter the correct zip code :");
                        String zip = scannerObject.next();
                        person.setZipCode(zip);
                        break;
                    case 8:
                        System.out.println("Enter the correct address :");
                        String address = scannerObject.next();
                        person.setAddress(address);
                        break;
                }
            } else {
                System.out.println("Provided name doesn't exist");
                System.out.println("Please enter the correct first name");
            }
        }
    }
}