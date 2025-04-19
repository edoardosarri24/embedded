package swees;

import java.util.Set;

import swees.scheduler.RMScheduler;
import swees.taskset.Chunk;
import swees.taskset.Task;
import swees.taskset.Taskset;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Task task1 = new Task(25, 25, new Chunk(10));
        Task task2 = new Task(40, 40, new Chunk(10));
        Task task3 = new Task(100, 100, new Chunk(20));
        Taskset taskset = new Taskset(Set.of(task1, task2, task3));
        RMScheduler scheduler = new RMScheduler(taskset);
        scheduler.schedule();
    }

}