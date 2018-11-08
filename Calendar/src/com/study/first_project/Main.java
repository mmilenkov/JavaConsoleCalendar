package com.study.first_project;

import java.util.Calendar;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Possibly replace?
	    Calendar today = Calendar.getInstance();
        CustomCalendar test = new CustomCalendar();
        test.genCal(today.get(Calendar.MONTH),today.get(Calendar.YEAR));

        EventHolder eh = new EventHolder();
        Scanner scan = new Scanner(System.in);

        //Calendar loop till quit (default case)
        String quit = "N";
        while (quit.equals("N")) {
            System.out.println("What would you like to do?");
            System.out.println("1. Move forward a month");
            System.out.println("2. Move back a month");
            System.out.println("3. Print a list of events");
            System.out.println("4. Add/Edit an event");
            System.out.println("5. Delete an event");
            System.out.println("6. Quit");
            System.out.println();
            int action = scan.nextInt();

            switch (action)
            {
                case 1:
                    test.nextMonth();
                    break;
                case 2:
                    test.previousMonth();
                    break;
                case 3:
                    eh.printSchedule();
                    break;
                case 4:
                    eh.addEvent();
                    break;
                case 5:
                    eh.removeEvent();
                    break;
                case 6:
                    quit = "";
                    break;
                default:
                    System.out.println("Not a valid Selection!");
                    break;
            }
        }
        scan.close();
    }
}
