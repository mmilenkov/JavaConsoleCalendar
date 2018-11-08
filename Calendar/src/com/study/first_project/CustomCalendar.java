package com.study.first_project;
import java.util.Calendar;

class CustomCalendar
{
    private int currMonth;
    private int currYear;
    private String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sep", "Oct", "Nov", "Dec"};
    private int daysInMonth;
    private String[] Days = {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
    private EventHolder eh = new EventHolder();

    CustomCalendar ()
    {
        Calendar today = Calendar.getInstance();
        currMonth = today.get(Calendar.MONTH);
        currYear = today.get(Calendar.YEAR);
        daysInMonth = today.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    void nextMonth()
    {
        currYear = (currMonth == 11) ? currYear +1 : currYear;
        currMonth = (currMonth+ 1) %12;
        genCal(currMonth, currYear);
    }

    void previousMonth()
    {
        currYear = (currMonth == 0) ? currYear -1 : currYear;
        currMonth = (currMonth == 0) ? 11 : currMonth -1;
        genCal(currMonth, currYear);
    }

    void genCal( int month, int year)
    {
        // Find first day of the month. Might be outdated - Java 7
        Calendar re = Calendar.getInstance();
        re.set(Calendar.MONTH,month);
        re.set(Calendar.YEAR,year);
        re.set(Calendar.DAY_OF_MONTH,1);
        int firstDay = (re.get(Calendar.DAY_OF_WEEK))-1;

        int date = 1;

        String monthAndYear = months[month] + " " + Integer.toString(year);

        System.out.println(monthAndYear);
        for ( int i = 0; i< 7; i++)
        {
            System.out.print(Days[i] + " ");
        }
        System.out.println(" ");
        for(int i =0; i<6; i++) {
            for (int j = 0; j < 7; j++) {
                if (i == 0 && j < firstDay)
                {
                    System.out.print("  " + "  ");
                }
                else if (date > daysInMonth)
                {
                    break;
                }
                else
                {
                    if(date < 10) {
                        System.out.print("  " + date + " ");
                        date++;
                    }
                    else {
                        date++;
                        System.out.print(" " + date + " ");
                    }
                }
            }
            System.out.println(" ");
        }
        System.out.println("List of events:");
        eh.printMonth(month);
        System.out.println();
    }
}


