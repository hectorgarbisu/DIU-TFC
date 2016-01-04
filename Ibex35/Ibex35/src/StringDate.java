/**
 *
 * @author geco
 */
public class StringDate {
    private String dateString;
    private int day;
    private int month;
    private int year;
    private String monthString;
    private final String[] months = {"ene","feb","mar","abr","may","jun",
        "jul","ago","sep","oct","nov","dic"};
   
    public StringDate(String date){
        dateString = date;
        if(date==null){
           mockThis();
        }else{
            String[] parts = date.split(" ");
            if(parts==null||parts.length<3){
                mockThis();
            }else{
                if(parts[0].compareToIgnoreCase(("Inicio"))!=0)
                if(parts[0].compareToIgnoreCase(("Fin"))!=0)
                if(parts.length==3){
                    day = Integer.parseInt(parts[0]);
                    monthString = parts[1];
                    year = Integer.parseInt(parts[2]);
                    int i=0;
                    while(i<12&&months[i]!=monthString)i++;
                    month = i;
                }
            }
        }
    }
    public int compareTo(String date2){
        return compareTo(new StringDate(date2));
    }
    public int compareTo(StringDate date2){
        if(date2.getYear()>year)return -1;
        if(date2.getYear()<year)return 1;
        if(date2.getMonth()>month)return -1;
        if(date2.getMonth()<month)return 1;
        if(date2.getDay()>day)return -1;
        if(date2.getDay()>day)return -1;
        return 0;
        
    }
    
    public String getDateString() {
        return dateString;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String getMonthString() {
        return monthString;
    }

    public String[] getMonths() {
        return months;
    }
    
    public String toString(){
       return dateString; 
    }

    private void mockThis() {
        dateString = "32 13 1";
        day = 31;
        month = 13;
        year = 1;
        monthString = "err";        
    }
}
