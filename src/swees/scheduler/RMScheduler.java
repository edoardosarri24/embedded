package swees.scheduler;

import java.util.List;
import java.util.stream.Collectors;

import swees.taskset.Task;
import swees.taskset.Taskset;
import swees.utils.Multiple;

public class RMScheduler {

    private Taskset taskset;

    public RMScheduler(Taskset taskset) {
        this.taskset = taskset;
    }

    public void schedule() {
        List<Task> orderedTasks = this.taskset.orderTasksetByPeriod();
        List<Double> periods = getPeriods(orderedTasks);
        List<Double> events = Multiple.generateMultiplesUpToLCM(periods);
        for (Double x : events) {
            System.out.println("Multiplier: " + x);
        }
    }

    private List<Double> getPeriods(List<Task> orderedTasks) {
        return orderedTasks.stream()
            .map(task -> task.getPeriod())
            .collect(Collectors.toList());   
    }

}