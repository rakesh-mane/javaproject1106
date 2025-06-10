public class SimpleAlarmClock {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Set alarm time in format HH:mm (24-hour format): ");
        String alarmTime = scanner.nextLine();
        System.out.println("Enter an optional alarm message (or leave blank): ");
        String message = scanner.nextLine();
        if (message.isEmpty()) {
            message = "Wake up!";
        }
        scheduleAlarm(alarmTime, message);
        scanner.close();
    }
    public static void scheduleAlarm(String alarmTime, String message) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                System.out.println(message);
                timer.cancel();
            }
        };
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
            Date alarmDate = dateFormat.parse(alarmTime);
            System.out.println("Alarm set for " + alarmTime);
            timer.schedule(task, alarmDate);
        } catch (Exception e) {
            System.out.println("Invalid time format.");
        }
    }
}
2. Alarm Clock with Interface
This example demonstrates how to set an alarm using an interface. It takes the alarm time as input and checks if the entered time is past the current time.
Java

import java.time.LocalTime;
import java.util.Scanner;

interface Alarm {
    void setAlarm(String time);
    String showAlarm();
}

class Monday implements Alarm {
    private String time;
    
    @Override
    public void setAlarm(String time) {
        this.time = time;
        LocalTime alarm = LocalTime.parse(time);
        LocalTime now = LocalTime.now();
        if (alarm.isBefore(now)) {
            System.out.println("I'll wake you up later!");
        } else {
            System.out.println("Alarm is set for tomorrow!");
        }
    }
    @Override
    public String showAlarm() {
        return time;
    }
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Monday m = new Monday();
        String alarmer;
        System.out.print("Enter time for alarm in this format (HH:MM): ");
        alarmer = reader.nextLine();
        m.setAlarm(alarmer);
        m.showAlarm();
    }
}
