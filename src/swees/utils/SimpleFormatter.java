package swees.utils;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class SimpleFormatter extends Formatter {
    @Override
    public String format(LogRecord record) {
        // Estrai solo il nome semplice della classe
        String fullClassName = record.getSourceClassName();
        String simpleClassName = fullClassName.substring(fullClassName.lastIndexOf('.') + 1);

        return String.format(
            "%s [%s] %s: %s%n",
            new java.util.Date(record.getMillis()),
            simpleClassName,
            record.getLevel().getName(),
            record.getMessage()
        );
    }
}