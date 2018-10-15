/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.entities;

import hotel.credit.CreditCard;
import hotel.credit.CreditCardType;
import java.util.Date;
import java.util.List;

/**
 *
 * @author muthukumaranapc
 */
public class testClass {
    
    
    public static void main(String[] args) 
    {
        //Mock objects
        Guest objGuest = new Guest("chathu", "melbourne", 111);
        Room objRoom = new Room(101, RoomType. SINGLE);
        CreditCard objCreditCard = new CreditCard(CreditCardType.VISA, 1, 111);
        Booking booking = new Booking(objGuest, objRoom,new Date() , 10, 1, objCreditCard);
        Hotel hotel = new Hotel();
        

        testCheckedOutRecordService( booking,hotel);
        
        
    }
  
     public static void testServiceCharge(Booking booking) 
    {
        double costOne=100;
        double actualTotal=  costOne;
       
        booking.checkIn();
        System.out.println("Checked in");
        System.out.println("Testing addServiceCharge");
        booking.addServiceCharge(ServiceType.BAR_FRIDGE,  costOne);
        double totalAmount = 0;
        //Bug spotted in booking.getCharges method
	List<ServiceCharge> charges = booking.getCharges();
        for (ServiceCharge serviceCharge : charges) 
        {
            totalAmount += serviceCharge.getCost();
							
        }
        if(totalAmount==actualTotal)
        {
            System.out.println("this one is ture");
        }
        else
        {
            System.out.println("this one is false");
        }
        
    }
     public static void testCheckedOutRecordService( Booking booking, Hotel hotel) {
         
         booking.checkIn(); 
         booking.checkOut();
         System.out.println("New Service..........");  
         booking.addServiceCharge(ServiceType.BAR_FRIDGE, 100);
         
        }

}
