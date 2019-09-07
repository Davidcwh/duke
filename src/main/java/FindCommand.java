/**
 * Represents the command of finding tasks with a specified keyword in a Duke object's tasks.
 */
public class FindCommand extends Command {
    protected String keyWord;

    /**
     * Creates a FindCommand object.
     *
     * @param keyWord Keyword to search for in the list of tasks.
     */
    public FindCommand(String keyWord) {
        this.keyWord = keyWord;
    }

    /**
     * Executes the search and retrieval of all the Task objects in a Duke object's TaskList object that
     * contains the keyword. The tasks as retrieved as a new TaskList object which is then listed to the user.
     *
     * @param tasks TaskList object to search in.
     * @param ui Duke object's Ui object to display any results from the search.
     * @param storage Duke object's Storage object to access file for loading/saving tasks.
     * @return String list of tasks found.
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws Exception {
        TaskList tasksWithKeyword = tasks.findTasks(this.keyWord);
        assert tasksWithKeyword != null: "List of tasks returned from search should never be null"; // Postcondition for findTasks method.
        return ui.showFindTasksMessage(tasksWithKeyword);
    }
}
