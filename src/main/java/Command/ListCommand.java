package Command;
import Oracle.TaskList;
import Oracle.Ui;

public class ListCommand implements Command{
    @Override
    public boolean execute(Ui ui, TaskList tasks) {
        ui.showList(tasks.getTasks());
        return true;
    }
}