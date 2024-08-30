package cleo.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Deadline extends Task {
    protected LocalDateTime by;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    DateTimeFormatter printformatter = DateTimeFormatter.ofPattern("MMM dd yyyy hh:mm a");

    /**
     * Creates a new Deadline task.
     *
     * @param description A string containing the description of the task.
     * @param by A string containing the deadline date and time in yyyy-MM-dd HH:mm format.
     * @throws IllegalArgumentException If the date format is invalid or if the deadline is in the past.
     */
    public Deadline(String description, String by) throws IllegalArgumentException {
        super(description);
        try {
            this.by = LocalDateTime.parse(by, formatter);
            if (this.by.isBefore(LocalDateTime.now())) {
                throw new IllegalArgumentException("The deadline cannot be in the past!");
            }
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date and time format! Please use the format 'yyyy-MM-dd HH:mm'.");
        }
    }

    /**
     * Returns the deadline date and time.
     * 
     * @return The deadline date and time in MMM dd yyyy hh:mm a format.
     */
    public String getBy() {
        return this.by.format(printformatter);
    }

    /**
     * Returns a string representation of the Deadline task.
     *
     * @return A string in the format "[D] description (by: deadline)".
     */
    @Override
    public String toString() {
        return "[D] " + super.toString() + " (by: " + getBy() + ")";
    }


}
