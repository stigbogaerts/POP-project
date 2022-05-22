package fact.it.schedule.model;

import java.util.ArrayList;

public class Day {

    private ArrayList<TimeBlock> schedule = new ArrayList<>();

    public Day() {
    }

    public ArrayList<TimeBlock> getSchedule() {
        return schedule;
    }

    public void setSchedule(ArrayList<TimeBlock> schedule) {
        this.schedule = schedule;
    }

    public void addToSchedule(TimeBlock timeBlock){
        schedule.add(timeBlock);
    }



    public TimeBlock getdate(int number){

        TimeBlock block = schedule.get(number);


        return block;
    }

    public String toString(){
        String text = "";
        for (TimeBlock timeblock : schedule) {
            text = text + timeblock.toString();
        }
        return text;
    }
}
