package swees.taskset;

import java.util.logging.Logger;

import swees.utils.LoggingConfig;

public class Chunk {

    private double executionTime;
    private static final Logger log = LoggingConfig.getLogger();

    public Chunk(double executionTime) {
        this.executionTime = executionTime;
    }

}