import java.io.IOException;

public class UnmarkCommand extends Command {
    private final int index;

    public UnmarkCommand(int index) {
        this.index= index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Task task = tasks.getTask(index);
        String taskInString = task.toString();
        if (task.isDone) {
            task.markAsUndone();
            String unmarkTask = task.toString();
            ui.showUnmarked(unmarkTask);
            try {
                storage.savesFile(tasks);
            } catch (SallyException e) {
                System.out.println("Oops! File Not Found");
            }
        } else {
            ui.showPreviouslyUnmarked(taskInString);
        }
    }

    @Override
    public boolean isBye() {
        return false;
    }
}