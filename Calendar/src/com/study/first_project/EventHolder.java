package com.study.first_project;

import java.util.ArrayList;
import java.util.Scanner;

//Acts as a database and creates event objects
 class EventHolder {
    //Test arrays - Better way? Database?
    //TODO Add year support. Multiple arrays? - More depth
    private static ArrayList<ArrayList<Events>> outer = new ArrayList<>(12);
    private static ArrayList<Events> jan = new ArrayList<>(31);
    private static ArrayList<Events> feb = new ArrayList<>(28);
    private static ArrayList<Events> mar = new ArrayList<>(31);
    private static ArrayList<Events> apr = new ArrayList<>(30);
    private static ArrayList<Events> may = new ArrayList<>(31);
    private static ArrayList<Events> june = new ArrayList<>(30);
    private static ArrayList<Events> july = new ArrayList<>(31);
    private static ArrayList<Events> aug = new ArrayList<>(31);
    private static ArrayList<Events> sep = new ArrayList<>(30);
    private static ArrayList<Events> oct = new ArrayList<>(31);
    private static ArrayList<Events> nov = new ArrayList<>(30);
    private static ArrayList<Events> dec= new ArrayList<>(31);

    //ArrayList initialisation block.
    static {
        for ( int i=0; i<31;i++)
        {
            jan.add(null);
        }
        outer.add(0,jan);
        for ( int i=0; i<28;i++)
        {
            feb.add(null);
        }
        outer.add(1,feb);
        for ( int i=0; i<31;i++)
        {
            mar.add(null);
        }
        outer.add(2,mar);
        for ( int i=0; i<30;i++)
        {
            apr.add(null);
        }
        outer.add(3,apr);
        for ( int i=0; i<31;i++)
        {
            may.add(null);
        }
        outer.add(4,may);
        for ( int i=0; i<30;i++)
        {
            june.add(null);
        }
        outer.add(5,june);
        for ( int i=0; i<31;i++)
        {
            july.add(null);
        }
        outer.add(6,july);
        for ( int i=0; i<31;i++)
        {
            aug.add(null);
        }
        outer.add(7,aug);
        for ( int i=0; i<30;i++)
        {
            sep.add(null);
        }
        outer.add(8,sep);
        for ( int i=0; i<31;i++)
        {
            oct.add(null);
        }
        outer.add(9,oct);
        for ( int i=0; i<31;i++)
        {
            nov.add(null);
        }
        outer.add(10,nov);
        for ( int i=0; i<31;i++)
        {
            dec.add(null);
        }
        outer.add(11,dec);
    }

    //
    private int[] monthLength = {31,28,31,30,31,30,31,31,30,31,30,31};
    private String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sep", "Oct", "Nov", "Dec"};

    void addEvent() // Can be used to both add and edit events
    {
        Scanner add = new Scanner(System.in); //Possibly not closed, but adding a close closes the one in main
        System.out.println("Which month would you like to add an event for?");
        int m = add.nextInt();
        System.out.println("Which date would you like to add an event for?");
        int d = add.nextInt();
        System.out.println("Which year would you like to add an event for?");
        int y = add.nextInt();
        System.out.println("Please enter a starting time:");
        add.nextLine();
        String s = add.nextLine();
        System.out.println("Please enter an end time:");
        String e = add.nextLine();
        System.out.println("Please enter a location:");
        String l = add.nextLine();

        Events event = new Events(y,m,d,s,e,l);

        switch(m-1)
        {
            case 0:
                jan.set((d-1),event);
                break;
            case 1:
                feb.set((d-1),event);
                break;
            case 2:
                mar.set((d-1),event);
                break;
            case 3:
                apr.set((d-1),event);
                break;
            case 4:
                may.set((d-1),event);
                break;
            case 5:
                june.set((d-1),event);
                break;
            case 6:
                july.set((d-1),event);
                break;
            case 7:
                aug.set((d-1),event);
                break;
            case 8:
                sep.set((d-1),event);
                break;
            case 9:
                oct.set((d-1),event);
                break;
            case 10:
                nov.set((d-1),event);
                break;
            case 11:
                dec.set((d-1),event);
                break;
            default:
                System.out.println("Not a valid month");
                break;
        }

    }

    void removeEvent()
    {
        Scanner remove = new Scanner(System.in);
        System.out.println("Which month would you like to remove an event from?");
        System.out.println("1. - 12.");
        int m = remove.nextInt();
        System.out.println("Which day would you like to remove an event from");
        int d = remove.nextInt();

        switch(m-1)
        {
            case 0:
                jan.set((d-1),null);
                break;
            case 1:
                feb.set((d-1),null);
                break;
            case 2:
                mar.set((d-1),null);
                break;
            case 3:
                apr.set((d-1),null);
                break;
            case 4:
                may.set((d-1),null);
                break;
            case 5:
                june.set((d-1),null);
                break;
            case 6:
                july.set((d-1),null);
                break;
            case 7:
                aug.set((d-1),null);
                break;
            case 8:
                sep.set((d-1),null);
                break;
            case 9:
                oct.set((d-1),null);
                break;
            case 10:
                nov.set((d-1),null);
                break;
            case 11:
                dec.set((d-1),null);
                break;
            default:
                System.out.println("Not a valid month");
                break;
        }
    }

    void printSchedule()
    {
        Scanner print = new Scanner(System.in);
        System.out.println("Would you like to print the schedule for:");
        System.out.println("1. A specific month");
        System.out.println("2. All months");
        int choice = print.nextInt();
        switch (choice)
        {
            case 1:
                //print.close();
                printSpecificMonth();
                break;
            case 2:
                //print.close();
                printAll();
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
    private void printSpecificMonth()
    {
        Scanner pm = new Scanner(System.in);
        System.out.println("Which month would you like to print the schedule for?");
        System.out.println("1-12");
        int m = (pm.nextInt())-1;
        //pm.close();
        printMonth(m);
    }

    private void printAll()
    {
        for (int j = 0; j<12; j++)
        {
            printMonth(j);
        }
    }

    void printMonth(int m) // used by genCal, so cannot be private
    {
        boolean printed = false;
        for ( int i=0; i< monthLength[m];i++)
        {
            if (outer.get(m).get(i) != null)
            {
                Events pEvent = outer.get(m).get(i);
                System.out.println(pEvent.getDate() + " " + (months[pEvent.getMonth()-1]) + " " + pEvent.getYear() + ":");
                System.out.println("At: " + pEvent.getLocation());
                System.out.println("From: " + pEvent.getStart());
                System.out.println("To: " + pEvent.getEnd());
                printed = true;
            }
        }

        if(!printed)
        {
            System.out.println("There are no events in " + months[m]);
        }
    }
}
