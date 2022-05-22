package fact.it.schedule.model;

import java.time.LocalTime;

public class TimeBlock {
    private LocalTime start;
    private LocalTime end;
    private final String subject;
    private String day;

    public TimeBlock(LocalTime start, LocalTime end, String subject, String day) {
        this.start = start;
        this.end = end;
        this.subject = subject;
        this.day = day;
    }

    public LocalTime getStart() {
        return start;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    public LocalTime getEnd() {
        return end;
    }

    public void setEnd(LocalTime end) {
        this.end = end;
    }

    public TimeBlock(LocalTime start, LocalTime end, String subject) {
        this.start = start;
        this.end = end;
        this.subject = subject;
    }

    public String toString(){

        return day +" "+ subject + " " + start + " " + end + ",\n";
    }
}
