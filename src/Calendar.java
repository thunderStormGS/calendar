import java.text.*;
import java.util.*;
import java.time.*;

public class Calendar {

	static ArrayList<String> cal = new ArrayList<String>();
	
	
	public static boolean addEvent(String newEvent)
	{
		cal.add(newEvent);
		return true;
	}
	
	public static List<String> getCal()
	{
		return cal;
	}
	

}
