package user;
import business.Phone;
import data.PhoneDP;
import java.util.ArrayList;

import business.Phone;
public class Main {
	
	public static void main(String[] args) {
		PhoneDP pDP=new PhoneDP();
		
		Phone p1=new Phone(1001,"Apple","i5",35000);
		Phone p2=new Phone(1002,"Samsung","J7",25000);
		Phone p3=new Phone(1003,"Itel","Magic",15000);
		
		pDP.add(p1);
		pDP.add(p2);
		pDP.add(p3);
		
		Phone p26=pDP.get(1025);
		if(p26!=null) {
			System.out.println(p26.getPhoneID()+" "+p26.getName()+" "+p26.getBrand()+" "+p26.getPrice());
		}
		
		Phone p4=new Phone(1003,"Itel","Magic57",15000);
		pDP.update(p4);
		
		pDP.delete(1001);
		
		
		ArrayList<Phone> phoneList=pDP.getall();
		for(Phone p:phoneList) {
			System.out.println(p.getPhoneID()+" "+p.getName()+" "+p.getBrand()+" "+p.getPrice());
		}
	}

}
