public class ExitCommand implements Command{
    @Override
    public boolean execute(Ui ui, TaskList tasks) {
        ui.showGoodbye();
        return false;
    }
}
