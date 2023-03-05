package com.addressbookcollection;

/*Creating contacts and storing the values*/
public class Contacts {
    //instance variables created
    public String firstName, lastName, address, email, city, state, zipCode, phoneNumber;
    /*Creating a constructor */
    public Contacts(String firstName, String lastName, String address,String city,String state, String zipCode,String phoneNumber,String email)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.email= email;
        this.city = city;
        this.state = state;
    }
    public String getFirstName()
    {
        return firstName;
    }
    public String getLastName()
    {
        return lastName;
    }
    public String getAddress()
    {
        return address;
    }
    public String getCity()
    {
        return city;
    }
    public String getState()
    {
        return state;
    }
    public String getZip()
    {
        return zipCode;
    }
    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    public String getEmail()
    {
        return email;
    }
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }
    public void setZipCode(String zipCode)
    {
        this.zipCode = zipCode;
    }
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public void setCity(String city)
    {
        this.city = city;
    }
    public void setState(String state)
    {
        this.state = state;
    }
    @Override
    public String toString() {
        return "Person details: [First Name - " + firstName + ", Last Name - " + lastName + ", Address - " + address
                + ", City - " + city + ", State - " + state + ", Email - " + email + ", Zip Code - " + zipCode + ", Phone Number - " + phoneNumber + "]";
    }
}