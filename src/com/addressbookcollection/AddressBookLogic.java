package com.addressbookcollection;
import java.util.Scanner;
import java.util.*;

/*Writing the logic for the address book system*/
public class AddressBookLogic{
    Scanner scannerObject = new Scanner(System.in);
    Map<String, Contacts> contactList = new HashMap<String,Contacts>();

    public static ArrayList<Contacts> addressList = new ArrayList<>();                     //Creating an arraylist to store the values
    public ArrayList<Contacts> getContact() {
        return new ArrayList<Contacts>(contactList.values());
    }
    String firstName,lastName,address,city, state,email, zipCode, phoneNumber;             //All inputs are treated as string


    public void operation() {                                                //Method to input the operation the user wants to perform
        boolean flag = true;
        do{                                                              //Using a do-while loop
            System.out.println("\nChoose the following operation you want to perform");
            Scanner scannerObject = new Scanner(System.in);
            System.out.println("1. Add new entry\n2. Display Contacts\n3. Edit entry\n4. Delete entry\n5. Count people by City" +
                               "\n6. Count people by State\n7. Exit");
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
                    countByCity();
                    break;
                case 6:
                    countByState();
                    break;
                case 7:
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
        int input = scannerObject.nextInt();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your first name: ");
        String firstname = scanner.nextLine();

        //Optional is used to represent a value that may or may not be present.
        //It is generally used as a return type for methods that might not always have a result to return
        //It helps to reduce the number of null pointer exceptions
        Optional<Contacts> checkName = addressList
                .stream()                                                     //sequencing of data from source
                .filter(name -> firstname.equals(name.getFirstName()))        //executes an intermediate operation
                .findFirst();                                                 //This method finds the first element in a Stream.

        //isPresent() method to check if it contains a non-null value.
        if(checkName.isPresent()){
            System.out.println("The name already exists");
            System.out.println("Please input another name");
        }
        else {
            Contacts contacts = inputDetails();
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

    //Count number of people by city
    public void countByCity(){
        System.out.println("Enter the name of city : ");
        String inputCity = scannerObject.next();
        long count = addressList.stream()
                .filter(city -> inputCity.equals(city.getCity()))
                .count();
        System.out.println("Total number of persons count as per city "+ inputCity + " are: " + count);
    }

    //Count number of people by state
    public void countByState(){
        System.out.println("Enter the name of state : ");
        String inputState = scannerObject.next();
        long count = addressList.stream()
                .filter(state -> inputState.equals(state.getState()))
                .count();
        System.out.println("Total number of persons count as per state "+ inputState + " are: " + count);
    }

    public static void main(String[] args) {
        AddressBookLogic addressBookLogic = new AddressBookLogic();
        addressBookLogic.operation();
    }
}

