import java.text.SimpleDateFormat;
import java.util.Calendar;


public class calenderTest {


   
  public static void main(String[] args) {
    Calendar cl = Calendar.getInstance();
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Calendar calendar = Calendar.getInstance();  
    for(int i=0;i<12;i++)
    {
      calendar.set(Calendar.DATE, 1); 
      System.out.println(df.format(calendar.getTime()));
      calendar.add(Calendar.MONTH,-1);
    }


  }

}
