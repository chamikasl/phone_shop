package data;

import java.util.ArrayList;
import business.Phone;


public class PhoneDP implements IPhone{
	
	private ArrayList<Phone> phoneList;
	
	public PhoneDP() {
		phoneList=new ArrayList<Phone>();
		
	}

	@Override
	public boolean add(Phone p) {
		return phoneList.add(p);
		
	}

	@Override
	public boolean delete(int phoneID) {
		Phone p=get(phoneID);
		if (p!=null) {
			return phoneList.remove(p);
		}else {
			return false;
		}
		
		
	}

	@Override
	public boolean update(Phone p) {
		Phone ph=get(p.getPhoneID());
		if (p!=null) {
			phoneList.remove(ph);
			return phoneList.add(p);
			
		}else 
			return false;
		}
			
			
		
		

	@Override
	public Phone get(int phoneID) {
		ArrayList<Phone> pList=getall();
		for(Phone p:pList) {
			if(p.getPhoneID()==phoneID) {
				return p;
			}
		}
		
		return null;
	}

	@Override
	public ArrayList<Phone> getall() {
		// TODO Auto-generated method stub
		return phoneList;
	}
	

}
