import java.io.*;
import java.text.*;
import java.util.*;
import java.time.*;

public class CalendarDriver {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		try {
			read();
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		Calendar cal = new Calendar();
		List<String> calen = Calendar.getCal();
		
		//function to load arraylist text file and parse
		
		Scanner kb = new Scanner(System.in);
		String e = kb.nextLine();
		
		Calendar.addEvent(e);
		
		
		System.out.println(calen);
		
		try {
			write(calen);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//get information from user about specific event
		//inquire about date, then event type (such as doctor appointment)
		
		//correct date format to use in structure
		//event added with user defined date
		
		//Date x = df.parse() <- compare dates to determine if date has already passed
		
		
		
		//set up arraylist to accept user input + date to compare
		//arraylist needs functions for add, delete, autopurge based on date
		//arraylist needs to save to file and file needs to be parsed for autopurge function
		//upon loading program, parse arraylist file and conduct search to purge events past due
		dateComparison(calen);
	}
	
	public static void write(List<String> calen) throws IOException
	{
		File file = new File("Calendar.txt");
		file.createNewFile();
		FileWriter out = new FileWriter(file, true);
		PrintWriter pw = new PrintWriter(out);
		int size = calen.size();
		for(int i = 0;i<size;i++)
		{
			pw.write(calen.get(i).toString() + "\n");
		}
		pw.close();
		out.close();
	}
	
	public static void read() throws IOException, ParseException
	{
		String FN = "Calendar.txt";
		String line = null;
		FileReader reader = new FileReader(FN);
		BufferedReader br = new BufferedReader(reader);
		
		System.out.println("Events already marked on calendar\n");
		while((line = br.readLine()) != null)
		{
			System.out.println(line);
	
		}
		System.out.println("\n");
		br.close();
		
	}
	public static void dateComparison(List<String> calen) throws ParseException, IOException
	{
		File oldF = new File("Calendar.txt");
		File newF = new File("Calendar_Most_Up_To_Date.txt");
		
		String line;
		FileReader reader = new FileReader(oldF);
		BufferedReader br = new BufferedReader(reader);
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(newF));
		
		while((line = br.readLine()) != null)
		{
			System.out.println(line);
			String[] days = line.trim().split("\\s+");
			System.out.println("Date is: " + days[0]);
			
			Date date = new Date();
			SimpleDateFormat df = new SimpleDateFormat("MM/dd/yy");
			String d = df.format(date);
			Date date1 = df.parse(days[0]);
			
			
			if(date.compareTo(date1) > 0)
			{
				System.out.println("This event is out of date, purging");
			
			}
			if(date.compareTo(date1) < 0)
			{
				System.out.println("Valid event date");
				bw.write(line + System.getProperty("line.separator"));
			}
			if(date.compareTo(date1) == 0)
			{
				System.out.println("Event scheduled for today");
				bw.write(line + System.getProperty("line.separator"));
			}
		}
		br.close();
		bw.close();
		oldF.delete();
		newF.renameTo(oldF);
		
	}

}
