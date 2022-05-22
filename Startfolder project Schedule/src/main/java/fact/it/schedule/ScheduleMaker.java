package fact.it.schedule;

import fact.it.schedule.model.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.FileWriter;   // Import the FileWriter class

public class ScheduleMaker {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<String> check;
        Saturday saturday = new Saturday();
        Sunday sunday = new Sunday();
        Monday monday = new Monday();
        Tuesday tuesday = new Tuesday();
        Wednesday wednesday = new Wednesday();
        Thursday thursday = new Thursday();
        Friday friday = new Friday();
        String day = "";
        String subject = "";
        LocalTime start = LocalTime.parse("00:00");
        LocalTime end = LocalTime.parse("00:00");
        try {
            File myObj = new File("test.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                for (String a:data.split(",")
                     ) {
                    int i = 0;
                    for (String b:a.split(" ")
                         ) {
                        switch (i){
                            case (0) ->
                                day = b;
                            case (1) ->
                                subject = b;
                            case (2) ->
                                start = LocalTime.parse(b);
                            case (3) ->
                                end = LocalTime.parse(b);
                            default -> {
                            }
                        }
                        i += 1;
                    }
                    TimeBlock timeBlock = new TimeBlock(start, end, subject, day);
                    switch (day){
                        case ("Monday") ->
                            monday.addToSchedule(timeBlock);
                        case ("Tuesday") ->
                                tuesday.addToSchedule(timeBlock);
                        case ("Wednesday") ->
                                wednesday.addToSchedule(timeBlock);
                        case ("Thursday") ->
                                thursday.addToSchedule(timeBlock);
                        case ("Friday") ->
                                friday.addToSchedule(timeBlock);
                        case ("Saturday") ->
                                saturday.addToSchedule(timeBlock);
                        case ("Sunday") ->
                                sunday.addToSchedule(timeBlock);
                    }
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println("Schedule maker (Please insure you don't overlap times and everything is spelled correctly)");
        System.out.print("do you want to add a time block?: ");
        String answer = sc.nextLine();
        while (answer.equals("yes")) {
            System.out.print("about what subject?: ");
            subject = sc.nextLine();
            System.out.print("when does it start: ");
            start = LocalTime.parse(sc.nextLine());
            while ((start.isAfter(LocalTime.parse("23:59"))) || (start.isBefore(LocalTime.parse("00:00")))) {
                System.out.println("your start time is to big or to small, enter a new time: ");
                start = LocalTime.parse(sc.nextLine());
            }
            System.out.print("when does it end: ");
            end = LocalTime.parse(sc.nextLine());
            while ((end.isAfter(LocalTime.parse("23:59"))) || (end.isBefore(LocalTime.parse("00:00")))) {
                System.out.println("your end time is to big or to small, enter a new time: ");
                end = LocalTime.parse(sc.nextLine());
            }
            checkTime(start, end, sc);
            System.out.println("start = " + start + " || end = " + end);
            System.out.print("what day:");
            day = sc.nextLine();
            while (!day.equals("")) {
                boolean leave = false;
                switch (day) {
                    case "Monday" -> {
                        while (!leave) {
                            TimeBlock time = new TimeBlock(start, end, subject, day);
                            check = isOverlap(time, monday.getSchedule());
                            System.out.println(check);
                            if (check.get(0).equals("true")) {
                                monday.addToSchedule(time);
                                System.out.println(time);
                                leave = true;
                            }
                            if (check.get(0).equals("false")) {
                                System.out.println(check.get(1));
                                System.out.println("TimeBlock was not added");
                                System.out.print("make a new start: ");
                                start = LocalTime.parse(sc.nextLine());
                                System.out.print("make a new end: ");
                                end = LocalTime.parse(sc.nextLine());
                                checkTime(start, end, sc);
                                leave = false;
                            }
                        }
                    }
                    case "Tuesday" -> {
                        while (!leave) {
                            TimeBlock time = new TimeBlock(start, end, subject, day);
                            check = isOverlap(time, tuesday.getSchedule());
                            System.out.println(check);
                            if (check.get(0).equals("true")) {
                                tuesday.addToSchedule(time);
                                System.out.println(time);
                                leave = true;
                            }
                            if (check.get(0).equals("false")) {
                                System.out.println(check.get(1));
                                System.out.println("TimeBlock was not added");
                                System.out.print("make a new start: ");
                                start = LocalTime.parse(sc.nextLine());
                                System.out.print("make a new end: ");
                                end = LocalTime.parse(sc.nextLine());
                                checkTime(start, end, sc);
                                leave = false;
                            }
                        }
                    }
                    case "Wednesday" -> {
                        while (!leave) {
                            TimeBlock time = new TimeBlock(start, end, subject, day);
                            check = isOverlap(time, wednesday.getSchedule());
                            System.out.println(check);
                            if (check.get(0).equals("true")) {
                                wednesday.addToSchedule(time);
                                System.out.println(time);
                                leave = true;
                            }
                            if (check.get(0).equals("false")) {
                                System.out.println(check.get(1));
                                System.out.println("TimeBlock was not added");
                                System.out.print("make a new start: ");
                                start = LocalTime.parse(sc.nextLine());
                                System.out.print("make a new end: ");
                                end = LocalTime.parse(sc.nextLine());
                                checkTime(start, end, sc);
                                leave = false;
                            }
                        }
                    }
                    case "Thursday" -> {
                        while (!leave) {
                            TimeBlock time = new TimeBlock(start, end, subject, day);
                            check = isOverlap(time, thursday.getSchedule());
                            System.out.println(check);
                            if (check.get(0).equals("true")) {
                                thursday.addToSchedule(time);
                                System.out.println(time);
                                leave = true;
                            }
                            if (check.get(0).equals("false")) {
                                System.out.println(check.get(1));
                                System.out.println("TimeBlock was not added");
                                System.out.print("make a new start: ");
                                start = LocalTime.parse(sc.nextLine());
                                System.out.print("make a new end: ");
                                end = LocalTime.parse(sc.nextLine());
                                checkTime(start, end, sc);
                                leave = false;
                            }
                        }
                    }
                    case "Friday" -> {
                        while (!leave) {
                            TimeBlock time = new TimeBlock(start, end, subject, day);
                            check = isOverlap(time, friday.getSchedule());
                            System.out.println(check);
                            if (check.get(0).equals("true")) {
                                friday.addToSchedule(time);
                                System.out.println(time);
                                leave = true;
                            }
                            if (check.get(0).equals("false")) {
                                System.out.println(check.get(1));
                                System.out.println("TimeBlock was not added");
                                System.out.print("make a new start: ");
                                start = LocalTime.parse(sc.nextLine());
                                System.out.print("make a new end: ");
                                end = LocalTime.parse(sc.nextLine());
                                checkTime(start, end, sc);
                                leave = false;
                            }
                        }
                    }
                    case "Saturday" -> {
                        while (!leave) {
                            TimeBlock time = new TimeBlock(start, end, subject, day);
                            check = isOverlap(time, saturday.getSchedule());
                            System.out.println(check);
                            if (check.get(0).equals("true")) {
                                saturday.addToSchedule(time);
                                System.out.println(time);
                                leave = true;
                            }
                            if (check.get(0).equals("false")) {
                                System.out.println(check.get(1));
                                System.out.println("TimeBlock was not added");
                                System.out.print("make a new start: ");
                                start = LocalTime.parse(sc.nextLine());
                                System.out.print("make a new end: ");
                                end = LocalTime.parse(sc.nextLine());
                                checkTime(start, end, sc);
                                leave = false;
                            }
                        }
                    }
                    case "Sunday" -> {
                        while (!leave) {
                            TimeBlock time = new TimeBlock(start, end, subject, day);
                            check = isOverlap(time, sunday.getSchedule());
                            System.out.println(check);
                            if (check.get(0).equals("true")) {
                                sunday.addToSchedule(time);
                                System.out.println(time);
                                leave = true;
                            }
                            if (check.get(0).equals("false")) {
                                System.out.println(check.get(1));
                                System.out.println("TimeBlock was not added");
                                System.out.print("make a new start: ");
                                start = LocalTime.parse(sc.nextLine());
                                System.out.print("make a new end: ");
                                end = LocalTime.parse(sc.nextLine());
                                checkTime(start, end, sc);
                                leave = false;
                            }
                        }
                    }
                    default -> System.out.println("sorry, you spelled the day wrong");
                }
                System.out.print("other days? (enter the day name, empty for no): ");
                day = sc.nextLine();
                if (!day.equals("")) {
                    System.out.print("same time? (no to change time): ");
                    String ans = sc.nextLine();
                    if (ans.equals("no")) {
                        System.out.print("when does it start: ");
                        start = LocalTime.parse(sc.nextLine());
                        System.out.print("when does it end: ");
                        end = LocalTime.parse(sc.nextLine());
                    }
                }
            }
            System.out.println("do you want to add another time block?: ");
            answer = sc.nextLine();
        }
        LocalDate date = LocalDate.now();
        DateTimeFormatter new_date = DateTimeFormatter.ofPattern("MMM_dd");
        String formattedDate = date.format(new_date);
        String file = "Week_" + formattedDate;
        file = file + ".txt";
        try {
            File myObj = new File("../" + file);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try {
            FileWriter myWriter = new FileWriter("../" + file);
            myWriter.write(String.valueOf(monday));
            myWriter.write(String.valueOf(tuesday));
            myWriter.write(String.valueOf(wednesday));
            myWriter.write(String.valueOf(thursday));
            myWriter.write(String.valueOf(friday));
            myWriter.write(String.valueOf(saturday));
            myWriter.write(String.valueOf(sunday));
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static List<String> isOverlap(TimeBlock newTimeBlock, ArrayList<TimeBlock> timeBlockList) {
        List<String> toReturn = new ArrayList<>();
        LocalTime myStart = newTimeBlock.getStart();
        LocalTime myEnd = newTimeBlock.getEnd();
        for (TimeBlock timeblock : timeBlockList
        ) {
            LocalTime otherStart = timeblock.getStart();
            LocalTime otherEnd = timeblock.getEnd();
            if (myStart.isBefore(otherEnd) && myStart.isAfter(otherStart)) {
                toReturn.add(0, "false");
                toReturn.add(1, "Start to small");
                return toReturn;
            }
            if (myEnd.isBefore(otherEnd) && myEnd.isAfter(otherStart)) {
                toReturn.add(0, "false");
                toReturn.add(1, "End to big");
                return toReturn;
            }
            if (myStart.isBefore(otherStart) && myEnd.isAfter(otherEnd)) {
                toReturn.add(0, "false");
                toReturn.add(1, "encasing");
                return toReturn;
            }
        }
        toReturn.add(0, "true");
        toReturn.add(1, "no error");
        return toReturn;
    }
    public static void checkTime(LocalTime start, LocalTime end, Scanner sc){
        boolean right = false;
        while (!right) {
            if ((start.isAfter(end)) || (start.equals(end))) {

                System.out.println("your start or end time is wrong, which one do you want to change or do you want to switch?");
                String var = sc.nextLine();

                if (var.equals("start")) {
                    System.out.println("what start time do you want?");
                    start = LocalTime.parse(sc.nextLine());
                    while ((start.isAfter(LocalTime.parse("23:59"))) || (start.isBefore(LocalTime.parse("00:00")))) {
                        System.out.println("your start time is to big or to small, enter a new time: ");
                        start = LocalTime.parse(sc.nextLine());
                    }
                }
                if (var.equals("end")) {
                    System.out.println("what end time do you want?");
                    end = LocalTime.parse(sc.nextLine());
                    while ((end.isAfter(LocalTime.parse("23:59"))) || (end.isBefore(LocalTime.parse("00:00")))) {
                        System.out.println("your end time is to big or to small, enter a new time: ");
                        end = LocalTime.parse(sc.nextLine());
                    }
                }
                if (var.equals("switch")) {
                    System.out.println("switch");
                    LocalTime number = start;
                    start = end;
                    end = number;
                }
            }
            if (start.isBefore(end)) {
                right = true;
            }
        }
    }
}
