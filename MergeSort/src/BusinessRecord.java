/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Education Unlimited
 */
public class BusinessRecord {
    private String name;
    private String phoneNumber;
    
    public BusinessRecord(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    
    public String getName() {
        return name;
    }    
    
    public String getPhoneNumber() {
        return phoneNumber; 
    }
    public String stringOut() {
        return name + ", " + phoneNumber;
    }
    public void printOut() {
        System.out.print(stringOut());
    }
    
}
