package cleo.task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import cleo.CleoException;

/**
 * Represents a list of tasks. Provides methods to add, remove, retrieve tasks,
 * and print the list of tasks. Tasks are stored internally in an ArrayList.
 */

public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Adds a task to the list.
     *
     * @param task the task to be added.
     */
    public void addTask(Task task) {
        tasks.add(task);
        System.out.println("Cleo: Got it. I have added this task:");
        System.out.println(task);
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
    }

    /**
     * Removes a task from the list.
     *
     * @param taskNumbers the index of the task that will be removed.
     */
    public void removeTask(int... taskNumbers) {
        List<Integer> validTaskNumbers = Arrays.stream(taskNumbers)
                .boxed()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());

        for (int taskIndex : validTaskNumbers) {
            Task removedTask = tasks.remove(taskIndex);
        }

    }
    /**
     * Returns the task at the specified index.
     *
     * @param taskNumber the index of the task.
     * @return the task at the specified index.
     */
    public Task getTask(int taskNumber) {
        return tasks.get(taskNumber);
    }
    /**
     * Marks the task at the specified index as done.
     *
     * @param taskNumber is an integer for the task index.
     */
    public void setDone(int taskNumber) {
        Task task = tasks.get(taskNumber);
        task.setDone();
        System.out.println("Cleo: Great job! I've marked this task as done:");
        System.out.println("    " + task);
    }

    /**
     * Marks the task at the specified index as not done.
     *
     * @param taskNumber is an integer for the task index.
     */
    public void setUndone(int taskNumber) {
        Task task = tasks.get(taskNumber);
        task.setUndone();
        System.out.println("Cleo: Okay! I've unmarked this task as not done yet:");
        System.out.println("    " + task);
    }
    /**
     * Returns the size of the task list.
     *
     * @return the size of the task list as an integer.
     */
    public int size() {
        return tasks.size();
    }

    /**
     * Prints all the tasks in the list.
     *
     * @return A string containing all tasks in the list.
     */
    public String listTasks() {
        if (tasks.isEmpty()) {
            return "Cleo: No tasks yet!";
        } else {
            StringBuilder result = new StringBuilder("Cleo: Here are your tasks:\n");
            for (int i = 0; i < tasks.size(); i++) {
                result.append((i + 1)).append(". ").append(tasks.get(i)).append("\n");
            }
            return result.toString();
        }
    }
    /**
     * Finds tasks in the task list based on the provided keyword.
     *
     * @param keyword the keyword to search for in the task descriptions.
     * @return A string containing the list of matching tasks.
     * @throws CleoException if the keyword is empty or no matching tasks are found.
     */
    public String findTask(String keyword) throws CleoException {
        if (keyword.isEmpty()) {
            throw new CleoException("Enter the keyword you want to search for.");
        }
        StringBuilder result = new StringBuilder();
        int count = 0;

        for (int i = 0; i < tasks.size(); i++) {
            Task task = getTask(i);
            if (task.toString().toLowerCase().contains(keyword.toLowerCase())) {
                result.append((count + 1)).append(". ").append(task).append("\n");
                count++;
            }
        }

        if (count == 0) {
            throw new CleoException("No matching tasks found in list!");
        } else {
            return "Cleo: Here are the matching task(s) in your list:\n" + result.toString();
        }
    }
}
