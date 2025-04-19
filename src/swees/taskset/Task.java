package swees.taskset;

public class Task {

    private int period;
    private int deadline;
    private Chunk chunk;

    public Task(int period, int deadline, Chunk chunk) {
        this.period = period;
        this.deadline = deadline;
        this.chunk = chunk;
    }

}