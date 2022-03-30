---
layout: page
title: User Guide
---

ManageEZPZ is a **desktop app for that allows managers or supervisors to manage employees and assign tasks to them.  Optimized for use via a Command Line Interface** (CLI) while still having the benefits of a Graphical User Interface (GUI).

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

2. Download the latest `ManageEZPZ.jar` from [here](https://github.com/AY2122S2-CS2103-F11-1/tp/releases).

3. Copy the file to the folder you want to use as the _home folder_ for your ManageEZPZ.

4. Double-click the file to start the app.

5. Start communicating with ManageEZPZ using the command box.

6. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * **`listTask`** : Lists all Tasks.

   * **`addEmployee`**`n/John Doe p/98765432 e/johnd@example.com` : Adds a contact named `John Doe` to ManageEZPZ.

   * **`deleteTask`**`3` : Deletes the 3rd Task shown in the Task list.

   * **`clear`** : Deletes everything from ManageEZPZ.
   
   * **`addTodo desc/read book`** : Adds a todo task with a description of `read book` to the Task list.

   * **`tagTask 1 n/John Doe`** : Assigns the first task on the task list to an employee named John Doe. 

   * **`exit`** : Exits the app.
--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `addEmployee n/NAME`, `NAME` is a parameter which can be used as `add n/John Doe`.

* Parameters for adding employees can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

* If a parameter is expected only once in the command but you specified it multiple times, only the last occurrence of the parameter will be taken.<br>
  e.g. if you specify `p/12341234 p/56785678`, only `p/56785678` will be taken.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

* Task related commands must be strictly lower case.

* Task related parameters must be in sequence as shown in the instruction.

* Parsing parameters of a task is done using the keywords such as `desc/`, `by/` & `at/`, as such, the parsing mechanism would take everything inserted after the keywords.

* All indexes are int based, as such the maximum value is 2147483647 (2<sup>31</sup> - 1).

</div>

### Viewing help : `help`

Shows a message explaining how to access the help page.

![help message](images/helpMessage_new.png)

Format: `help`

### Adding an Employee : `addEmployee`

Adds an employee to ManageEZPZ.

Format: `addEmployee n/NAME p/PHONE_NUMBER e/EMAIL`

Examples:
* `addEmployee n/John Doe p/98765432 e/johnd@example.com`
* `addEmployee p/98754123 n/Betsy Crowe e/betsycrowe@example.com`

### Listing all Employees : `listEmployee`

Shows a list of all employees in ManageEZPZ.

Format: `listEmployee`

### Editing an Employee : `editEmployee`

Edits an existing employee in ManageEZPZ.

Format: `editEmployee INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL]`

* Edits the employee at the specified INDEX.
* The index refers to the index number shown in the displayed employee list.
* The index **must be a positive integer** 1, 2, 3, …​
* Existing values will be updated to the input values.

Examples:
* `editEmployee 1 p/91234567 e/johndoe@example.com` edits the phone number and email address of the 1st employee to be 91234567 and johndoe@example.com respectively. 
* `editEmployee 2 n/Betsy Crower` edits the name of the 2nd person to be Betsy Crower.

### Finding Employees by multiple options : `findEmployee`

Finds employee(s) based on multiple conditions provided.

Note:
* Parameters for finding employees can be entered together in any order.
* You must enter at least one parameter.

Format: `findEmployee [n/NAMES] [p/PHONE_NUMBER] [e/EMAIL]`
* `findEmployee n/[LIST OF NAMES]` finds employees whose names contain any of the words in [LIST OF NAMES].
* `findEmployee p/PHONE_NUMBER` finds employees with the exact phone number.
* `findEmployee e/EMAIL` finds employees with the exact email.

Examples:
* `findEmployee n/Alex`
* `findEmployee p/87438807`
* `findEmployee e/alexyeoh@example.com`
* `findEmployee n/Bernice Yu p/99272758 e/berniceyu@example.com`

### Deleting an Employee : `deleteEmployee`

Deletes the specified employee from ManageEZPZ.

Format: `deleteEmployee INDEX`

* Deletes the employee at the specified INDEX.
* The index refers to the index number shown in the displayed person list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `deleteEmployee 2` deletes the 2nd employee in the displayed employee list.
* `listEmployee` followed by `deleteEmployee 2` sets the displayed employee list to show all employees in ManageEZPZ and deletes the 2nd employee in ManageEZPZ.
* `findEmployee n/Betsy` followed by `deleteEmployee 1` sets the displayed employee list with the results from the findEmployee command and deletes the 1st employee in the displayed employee list.

### Adding a Task : `addTodo`, `addEvent`, `addDeadline`

Adds a task to ManageEZPZ.

Format:
* `addTodo desc/TASK_DESCRIPTION`
* `addDeadline desc/TASK_DESCRIPTION by/DATE TIME`
* `addEvent desc/TASK_DESCRIPTION at/[DATE] START_TIME END_TIME`

Examples:
* `addTodo desc/Powerpoint Slides for Company XYZ`
* `addDeadline desc/Client Proposal Slides by/2022-03-20 1800`
* `addEvent desc/Business Meeting at/2022-02-18 1900 2000`

<div markdown="span" class="alert alert-primary">

**:bulb: Take Note:**

For deadline and event, the DATE must be in this format: YYYY-MM-DD and the TIME in this format: HHmm (in 24 hr format).

</div>

### Listing all Tasks : `listTask`

Shows a list of all tasks in ManageEZPZ.

Format: `listTask`

### Editing a Task : `editTask`

Edits an existing task in ManageEZPZ.

Format:
* `editTask INDEX [desc/NAME]`
* `editTask INDEX []`
* `editTask INDEX []`

Examples:
* `editTask XXX` edits ...
* `editTask XXX` edits ...

### Marking a Task : `markTask`

Marks the specified task in ManageEZPZ as done.

Format: `markTask INDEX`

* Marks the task at the specified `INDEX` as done.
* The index refers to the index number shown in the displayed task list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `markTask 2` marks the 2nd task in the displayed task list as done.
* `listTask` followed by `markTask 2` sets the displayed task list to show all tasks in ManageEZPZ and marks the 2nd task in ManageEZPZ as done.
* `findTask desc/slides` followed by `markTask 1` sets the displayed task list with the results from the findTask command and marks the 1st task in the displayed task list as done.

### Unmarking a Task : `unmarkTask`

Unmarks the specified task in ManageEZPZ, i.e., changes the status back to not done.

Format: `unmarkTask INDEX`

* Unmarks the task at the specified `INDEX` to change the status back to not done.
* The index refers to the index number shown in the displayed Task list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `unmarkTask 2` changes the 2nd task in the displayed task list back to not done.
* `listTask` followed by `unmarkTask 2` sets the displayed task list to show all tasks in ManageEZPZ and changes the 2nd task in ManageEZPZ back to not done.
* `findTask desc/slides` followed by `unmarkTask 1` sets the displayed task list with the results from the findTask command and changes the 1st task in the displayed task list back to not done.

### Finding Tasks by multiple options : `findTask`

Finds task(s) based on multiple conditions provided.

Note:
* Parameters for finding tasks can be entered together in any order.
* You must enter at least one parameter from either Task Type or the valid options.
* Task Type is optional, however, when entered, only one task type is allowed.
* Any other invalid options not stated below will be ignored.

Task Type Available:
* `todo/`: Todos
* `deadline/`: Deadlines
* `event/`: Events

Options:
* `desc/`: Description of the tasks
* `date/`: Date of the task in YYYY-MM-DD (only for deadline and event)
* `priority/`: Priority of task, only `HIGH`, `MEDIUM`, `LOW` and `NONE`
* `assignees/`: The assignees that was assigned to the task (only one full name of assignee allowed)
* `isMarked/`: Whether the task is marked, only `true` or `false`

Format:
* `findTask todo/` finds all todos
* `findTask deadline/` finds all deadlines
* `findTask event/` find all events
* `findTask desc/[LIST OF WORDS]` finds all tasks which contain any of the words in [LIST OF WORDS].
* `findTask date/YYYY-MM-DD` finds all deadlines and events with the date
* `findTask priority/PRIORITY` find all tasks with the given PRIORITY [HIGH, MEDIUM, LOW, NONE]
* `findTask assignees/ASSIGNEE FULL NAME` finds all tasks assigned to the stated assignee (in full name)
* `findTask isMarked/BOOLEAN` finds all tasks that is already marked as done (`true`) or unmarked i.e., not done (`false`)

Example:
* `findTask desc/homework`
* `findTask date/2022-04-16`
* `findTask desc/work priority/HIGH`
* `findTask deadline/ desc/school date/2022-04-16 priority/HIGH assignees/Alex Yeo isMarked/true`
    * Finds the task with a description that contains all the following options:
        * Task type of deadline,
        * description which contains the word “school”,
        * date 2022-04-16,
        * priority high,
        * assigned to Alex Yeoh,
        * and is marked as done.

### Deleting a Task : `deleteTask`

Deletes the specified task from ManageEZPZ.

Format: `deleteTask INDEX`

* Deletes the task at the specified `INDEX`.
* The index refers to the index number shown in the displayed task list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `deleteTask 2` deletes the 2nd task in the displayed task list.
* `listTask` followed by `deleteTask 2` sets the displayed task list to show all tasks in ManageEZPZ and deletes the 2nd task in ManageEZPZ.
* `findTask desc/slides` followed by `deleteTask 1` sets the displayed task list with the results from the findTask command and deletes the 1st task in the displayed task list.

### Tagging a Task to an Employee : `tagTask`

Assigns the specified task to an employee.

Format: `tagTask INDEX n/NAME`
* Assigns the task at the specified `INDEX` to the employee with the specified `NAME`.
* The index refers to the index number shown in the displayed task list. 
* The index **must be a positive integer** 1, 2, 3, …​
* The name must be a valid employee name in ManageEZPZ.

Example: `tagTask 1 n/Alex Yeoh`
* `tagTask 1 n/Alex Yeoh` assigns the 1st task in the displayed task list to the employee with the name Alex Yeoh.
* `listTask` followed by `tagTask 1 n/Alex Yeoh` sets the displayed task list to show all tasks in ManageEZPZ and assigns the 1st task in ManageEZPZ to the employee with the name Alex Yeoh.
* `findTask desc/slides` followed by `tagTask 1 n/Alex Yeoh` sets the displayed task list with the results from the findTask command and assigns the 1st task in the displayed task list to the employee with the name Alex Yeoh.

### Untagging a Task from an Employee : `untagTask`

Deallocates the specified task from an employee.

Format: `untagTask INDEX n/NAME`
* Deallocates the task at the specified `INDEX` from the employee with the specified `NAME`.
* The index refers to the index number shown in the displayed task list.
* The index **must be a positive integer** 1, 2, 3, …​
* The name must be a valid employee name in ManageEZPZ.

Example:
* `untagTask 1 n/Alex Yeoh` deallocates the 1st task in the displayed task list from the employee with the name Alex Yeoh.
* `listTask` followed by `untagTask 1 n/Alex Yeoh` sets the displayed task list to show all tasks in ManageEZPZ and deallocates the 1st task in ManageEZPZ from the employee with the name Alex Yeoh.
* `findTask desc/slides` followed by `untagTask 1 n/Alex Yeoh` sets the displayed task list with the results from the findTask command and deallocates the 1st task in the displayed task list from the employee with the name Alex Yeoh.

### Tagging a Priority to a Task : `tagPriority`

Assigns the specified task with a priority of either HIGH, MEDIUM, LOW or NONE.

Format: `tagPriority INDEX priority/PRIORITY`
* Assigns the task at the specified `INDEX` with the specified priority `PRIORITY`.
* The index refers to the index number shown in the displayed task list.
* The index **must be a positive integer** 1, 2, 3, …​
* The priority must be either `HIGH`, `MEDIUM`, `LOW`, or `NONE`.
* The priority is case-insensitive, e.g., `high`, `HIGH`, `HiGh` or `hIgH` will match as `HIGH`.
* A task with the priority of `NONE` will not have the priority reflected in the displayed task list.

Example: 
* `tagPriority 1 priority/HIGH`
* `tagPriority 1 priority/HIGH` assigns the 1st task in the displayed task list with the priority of `HIGH`.
* `listTask` followed by `tagPriority 1 priority/HIGH` sets the displayed task list to show all tasks in ManageEZPZ and assigns the 1st task in ManageEZPZ with the priority of `HIGH`.
* `findTask desc/slides` followed by `tagPriority 1 priority/HIGH` sets the displayed task list with the results from the findTask command and assigns the 1st task in the displayed task list with the priority of `HIGH`.

### Clearing all entries : `clear`

Clears all entries from the employee list and task list.

Format: `clear`

### Exiting the program : `exit`

Exits the program.

Format: `exit`

### Saving the data

ManageEZPZ data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Editing the data file

ManageEZPZ data are saved as a JSON file `[JAR file location]/data/ManageEZPZ.json`. Advanced users are welcome to update data directly by editing that data file.

<div markdown="span" class="alert alert-warning">

:exclamation: **Caution:**
If your changes to the data file makes its format invalid, ManageEZPZ will discard all data and start with an empty data file at the next run.

</div>

_Details coming soon ..._

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous ManageEZPZ home folder.

--------------------------------------------------------------------------------------------------------------------

## Command summary

### Employee Related Commands

| Action              | Format, Examples                                                                                                 |
|---------------------|------------------------------------------------------------------------------------------------------------------|
| **Add Employee**    | `addEmployee n/NAME p/PHONE_NUMBER e/EMAIL` <br> e.g., `addEmployee n/James Ho p/22224444 e/jamesho@example.com` |
| **List Employees**  | `listEmployee`                                                                                                   |
| **Find Employee**   | `findEmployee OPTIONS` <br> `findEmployee n/Alex Yeoh`                                                           |
| **Edit Employee**   | `editEmployee INDEX n/NAME p/PHONE_NUMBER e/EMAIL` <br> e.g., `edit 2 n/James Lee e/jameslee@example.com`        |
| **Delete Employee** | `deleteEmployee INDEX` <br> e.g., `deleteEmployee 3`                                                             |

### Task Related Commands

| Action                | Format, Examples                                                                                                                |
|-----------------------|---------------------------------------------------------------------------------------------------------------------------------|
| **Add Todo Task**     | `addTodo desc/TASK_DESCRIPTION` <br> e.g., `addTodo desc/read book`                                                             |
| **Add Deadline Task** | `addDeadline desc/TASK_DESCRIPTION by/DATETIME` <br> e.g., `addDeadline desc/return book by/16-02-2022 1800`                    |
| **Add Event Task**    | `addEvent desc/TASK_DESCRIPTION at/DATE START_TIME END_TIME` <br> e.g., `addEvent desc/project meeting at/17-02-2022 1900 2000` |
| **List Tasks**        | `listTasks`                                                                                                                     |
| **Find Task**         | `findTask OPTIONS` <br> e.g.,`findTask todo/`                                                                                   |
| **Mark Task**         | `markTask INDEX` <br> e.g., `markTask 2`                                                                                        |
| **Unmark Task**       | `unmarkTask INDEX` <br> e.g., `unmarkTask 2`                                                                                    |
| **Delete Task**       | `deleteTask INDEX` <br> e.g., `deleteTask 2`                                                                                    |
| **Tag Task**          | `tagTask INDEX n/NAME` <br> e.g.,`tagTask 1 n/Alex Yeoh`                                                                        |
| **Untag Task**        | `untagTask INDEX n/NAME` <br> e.g.,`untagTask 1 n/Alex Yeoh`                                                                    |
| **Tag Priority**      | `tagPriority INDEX priority/PRIORITY` <br> e.g.,`tagPriority 1 priority/HIGH`                                                   |

### Others

| Action    | Format  |
|-----------|---------|
| **Clear** | `clear` |
| **List**  | `list`  |
| **Help**  | `help`  |
| **Exit**  | `exit`  |
