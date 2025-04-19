package swees.taskset;

public class Task {

    private double period;
    private double deadline;
    private Chunk chunk;

    public Task(double period, double deadline, Chunk chunk) {
        this.period = period;
        this.deadline = deadline;
        this.chunk = chunk;
    }

    public double getPeriod() {
        return this.period;
    }

}