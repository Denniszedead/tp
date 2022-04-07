package manageezpz.model;

import java.nio.file.Path;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import manageezpz.commons.core.GuiSettings;
import manageezpz.logic.parser.Prefix;
import manageezpz.model.person.Person;
import manageezpz.model.task.Deadline;
import manageezpz.model.task.Event;
import manageezpz.model.task.Priority;
import manageezpz.model.task.Task;
import manageezpz.model.task.Todo;

/**
 * The API of the Model component.
 */
public interface Model {
    /** {@code Predicate} that always evaluate to true to show all tasks */
    Predicate<Task> PREDICATE_SHOW_ALL_TASKS = unused -> true;
    /** {@code Predicate} that always evaluate to true */
    Predicate<Person> PREDICATE_SHOW_ALL_PERSONS = unused -> true;

    /**
     * Replaces user prefs data with the data in {@code userPrefs}.
     */
    void setUserPrefs(ReadOnlyUserPrefs userPrefs);

    /**
     * Returns the user prefs.
     */
    ReadOnlyUserPrefs getUserPrefs();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Sets the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the user prefs' address book file path.
     */
    Path getAddressBookFilePath();

    /**
     * Sets the user prefs' address book file path.
     */
    void setAddressBookFilePath(Path addressBookFilePath);

    /**
     * Replaces address book data with the data in {@code addressBook}.
     */
    void setAddressBook(ReadOnlyAddressBook addressBook);

    /** Returns the AddressBook */
    ReadOnlyAddressBook getAddressBook();

    /**
     * Returns true if a person with the same identity as {@code person} exists in the address book.
     */
    boolean hasPerson(Person person);

    /**
     * Deletes the given person.
     * The person must exist in the address book.
     */
    void deletePerson(Person target);

    /**
     * Adds the given person.
     * {@code person} must not already exist in the address book.
     */
    void addPerson(Person person);

    /**
     * Replaces the given person {@code target} with {@code editedPerson}.
     * {@code target} must exist in the address book.
     * The person identity of {@code editedPerson} must not be the same as another existing person in the address book.
     */
    void setPerson(Person target, Person editedPerson);

    void increaseNumOfTasks(Person person);

    void decreaseNumOfTasks(Person person);

    /** Returns an unmodifiable view of the filtered person list */
    ObservableList<Person> getFilteredPersonList();

    /**
     * Updates the filter of the filtered person list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredPersonList(Predicate<Person> predicate);


    //=========== ManageEZPZ (Tasks) ==================================================================================

    /**
     * Deletes the given task.
     * The task must exist in the task list.
     */
    void deleteTask(Task task);

    /**
     * Updates the task with the edited person.
     * The task must exist in the task list.
     */
    void updateTaskWithEditedPerson(Task task, int assigneesIndex, Person editedPerson);

    /**
     * Marks the given task.
     * The task must exist in the task list.
     */
    Task markTask(Task task);

    /**
     * unMarks the given task.
     * The task must exist in the task list.
     */
    Task unmarkTask(Task task);

    Task tagPriorityToTask(Task task, Priority priority);

    /**
     * Finds the given task.
     * The task must exist in the task list.
     */
    void findTask(Task task);

    /**
     * Tags the given task.
     * The task must exist in the task list.
     * @param task
     * @param person
     */
    Task tagEmployeeToTask(Task task, Person person);

    /**
     * Untags the given task.
     * The task must exist in the task list.
     * @param task
     * @param person
     */
    Task untagEmployeeFromTask(Task task, Person person);

    /**
     * Adds the given task.
     * {@code task} must not already exist in the task list
     */
    void addTask(Task task);

    /**
     * Adds the given todo.
     * {@code todo} must not already exist in the task list
     */
    void addTodo(Todo todo);

    /**
     * Adds the given event.
     * {@code event} must not already exist in the task list
     */
    void addEvent(Event event);

    /**
     * Adds the given deadline.
     * {@code deadline} must not already exist in the task list
     */
    void addDeadline(Deadline deadline);

    /**
     * Updates the filter of the filtered task list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredTaskList(Predicate<Task> predicate);

    /** Returns an unmodifiable view of the filtered task list. */
    ObservableList<Task> getFilteredTaskList();

    /**
     * Returns true if a task with the same identity as {@code Task} exists in the task list.
     */
    boolean hasTask(Task task);

    /**
     * Returns true if a task with the same identity as {@code todo} exists in the task list.
     */
    boolean hasTodo(Todo todo);

    /**
     * Returns true if a task with the same identity as {@code deadline} exists in the task list.
     */
    boolean hasDeadline(Deadline deadline);

    /**
     * Returns true if a task with the same identity as {@code event} exists in the task list.
     */
    boolean hasEvent(Event event);

    /**
     * Returns true if a {@code Task} is tagged.
     */
    boolean isEmployeeTaggedToTask(Task task, Person p);

    /**
     * Replaces the given task {@code target} with {@code editedTask}.
     * {@code target} must exist in the task list.
     * The task identity of {@code editedTask} must not be the same as another existing task in the task list.
     */
    void setTask(Task target, Task editedTask);
}
