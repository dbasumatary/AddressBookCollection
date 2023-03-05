package com.addressbookcollection;

/*Creating contacts and storing the values*/
public class Contacts {
    public String firstName, lastName, address, email, city, state;       //instance variables created
    public long zipCode, phoneNumber;
    /*Creating a constructor */
    public Contacts(String firstName, String lastName, String address,String city,String state, long zipCode,long phoneNumber,String email)
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
    public String getFirstName()                                  //Using getter to obtain the properties
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
    public long getZip()
    {
        return zipCode;
    }
    public long getPhoneNumber()
    {
        return phoneNumber;
    }
    public String getEmail()
    {
        return email;
    }
    public void setFirstName(String firstName)                     //Using setter to set the values
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
    public void setZipCode(long zipCode)
    {
        this.zipCode = zipCode;
    }
    public void setPhoneNumber(long phoneNumber)
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
