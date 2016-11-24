package DatabaseObjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Customer
{

    @SerializedName("Social")
    @Expose
    int social;
    @SerializedName("Address")
    @Expose
    String address;
    @SerializedName("City")
    @Expose
    String city;
    @SerializedName("State")
    @Expose
    String state;
    @SerializedName("Zip")
    @Expose
    String zip;
    @SerializedName("FirstName")
    @Expose
    String firstName;
    @SerializedName("LastName")
    @Expose
    String lastName;
    public String getLastName() {
        return this.lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFirstName() {
        return this.firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getZip() {
        return this.zip;
    }
    public void setZip(String zip) {
        this.zip = zip;
    }
    public String getState() {
        return this.state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getCity() {
        return this.city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public int getSocial() {
        return this.social;
    }
    public void setSocial(int social) {
        this.social = social;
    }
}
