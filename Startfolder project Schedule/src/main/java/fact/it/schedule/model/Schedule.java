package fact.it.schedule.model;

public class Schedule {
    private final Monday monday;
    private final Tuesday tuesday;
    private final Wednesday wednesday;
    private final Thursday thursday;
    private final Friday friday;
    private final Saturday saturday;
    private final Sunday sunday;

    public Schedule() {
        this.monday = new Monday();
        this.tuesday = new Tuesday();
        this.wednesday = new Wednesday();
        this.thursday = new Thursday();
        this.friday = new Friday();
        this.saturday = new Saturday();
        this.sunday = new Sunday();
    }

}
