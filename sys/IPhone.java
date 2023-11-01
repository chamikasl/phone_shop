package data;
import business.Phone;
import java.util.ArrayList;

public interface IPhone {
	
	boolean add(Phone p);
	boolean delete(int phoneID);
	boolean update(Phone p);
	Phone get(int phoneID);
	ArrayList<Phone> getall();

}
