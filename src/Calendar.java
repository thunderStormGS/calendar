import java.text.*;
import java.util.*;
import java.time.*;

public class Calendar {
	//Initializes the calendar using the ArrayList Data Structure
	static ArrayList<String> cal = new ArrayList<String>();
	
	//A method to add events to the calendar
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
