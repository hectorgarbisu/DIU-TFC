
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

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
    private final String[] months = {"ene", "feb", "mar", "abr", "may", "jun",
        "jul", "ago", "sep", "oct", "nov", "dic"};

    public StringDate(String date) {
        dateString = date;
        if (date == null) {
            mockThis(3);
        } else {
            String[] parts = date.split(" ");
            if (parts == null || parts.length < 3) {
                mockThis(3);
            } else {
                if (parts[0].compareToIgnoreCase(("Inicio")) != 0) {
                    if (parts[0].compareToIgnoreCase(("Fin")) != 0) {
                        if (parts.length == 3) {
                            day = Integer.parseInt(parts[0]);
                            monthString = parts[1];
                            year = Integer.parseInt(parts[2]);
                            int i = 0;
                            while (i < 12 && months[i].compareTo(monthString) != 0) {
                                i++;
                            }
                            month = i;
                        }
                    } else {
                        mockThis(1);
                    }
                } else {
                    mockThis(2);
                }
            }
        }
//        System.out.println(date+" se ha convertido en "+day+" "+month+" "+year);
    }
    public StringDate(int d, int m, int y){
        day = d;
        month = m;
        year = y;
        dateString = d+" "+months[m]+" "+y;
    }

    static StringDate[] getSortedArray(Set<String> dateSet) {
        String[] str = dateSet.toArray(new String[dateSet.size()]);
        for (int i = 0; i < str.length; i++) {
        }        
        StringDate[] strDt = new StringDate[str.length];
        for (int i = 0; i < strDt.length; i++) {
            strDt[i] = new StringDate(str[i]);
        }
        return bubbleSort(strDt);
    }

    private static StringDate[] bubbleSort(StringDate[] strDt) {
        int j;
        boolean flag = true;   // set flag to true to begin first pass
        StringDate temp;   //holding variable
        while (flag) {
            flag = false;    //set flag to false awaiting a possible swap
            for (j = 0; j < strDt.length - 1; j++) {
                if (strDt[j].compareTo(strDt[j + 1]) > 0) // change to > for ascending sort
                {
                    temp = strDt[j];                //swap elements
                    strDt[j] = strDt[j + 1];
                    strDt[j + 1] = temp;
                    flag = true;              //shows a swap occurred 
                }
            }
        }
        return strDt;
    }
    public int compareTo(String date2) {
        return compareTo(new StringDate(date2));
    }

    public int compareTo(StringDate date2) {
        if (date2.getYear() > year) {
            return -1;
        } else if (date2.getYear() < year) {
            return 1;
        } else if (date2.getMonth() > month) {
            return -1;
        } else if (date2.getMonth() < month) {
            return 1;
        } else if (date2.getDay() > day) {
            return -1;
        } else if (date2.getDay() > day) {
            return 1;
        }
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

    public String toString() {
        return dateString;
    }

    private void mockThis(int i) {
        monthString = "err";
        switch (i) {
            case 1:
                dateString = "Fin del registro";
                day = 99;
                month = 99;
                year = 9999;
                break;
            case 2:
                dateString = "Inicio del registro";
                day = -1;
                month = -1;
                year = -1;
                break;
            default:
                year = 0;
                dateString = "0 0 0";
                day = 0;
                month = 0;
        }
    }
    public static StringDate today(){
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        return new StringDate(day,month,year);
    }
    
}
