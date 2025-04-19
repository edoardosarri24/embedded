package swees.taskset;

import java.util.logging.Logger;

import swees.utils.LoggingConfig;

public class Chunk {

    private int executionTime;
    private static final Logger log = LoggingConfig.getLogger();

    public Chunk(int executionTime) {
        this.executionTime = executionTime;
    }

}