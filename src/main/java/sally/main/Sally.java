package sally.main;

import javafx.scene.image.Image;
import sally.command.Command;
import sally.exception.SallyException;
import sally.parser.Parser;
import sally.storage.Storage;
import sally.task.TaskList;
import sally.ui.Ui;

/**
 * Main class for Sally
 *
 * @author liviamil
 */

public class Sally {
    protected boolean isBye = false;
    private TaskList tasks;

    private Image user = new Image(this.getClass().getResourceAsStream("/images/user.png"));
    private Image sally = new Image(this.getClass().getResourceAsStream("/images/sally.png"));

    private static final String filePath = "data/Sally.txt";
    private final Storage storage;
    private final Ui ui;

    /**
     * Constructor for Sally
     *
     * @param filePath Path to file for storage.
     */
    public Sally(String filePath) {
        ui = new Ui();
        storage = new Storage();
        try {
            tasks = new TaskList(storage.load());
        } catch (SallyException e) {
            ui.showError(e.getMessage());
            tasks = new TaskList();
        }
    }

    /**
     * Constructor for Sally with no parameters
     */
    public Sally() {
        ui = new Ui();
        storage = new Storage();
        try {
            tasks = new TaskList(storage.load());
        } catch (SallyException e) {
            ui.showError(e.getMessage());
            tasks = new TaskList();
        }
    }

    /**
     * Handles input for Sally
     *
     * @param stringCommand input to be handled
     */
    public void run(String stringCommand) {
        try {
            Command command = Parser.parseCommand(stringCommand);
            isBye = command.isBye();
            command.execute(tasks, ui, storage);
        } catch (SallyException e) {
            ui.showError(e.getMessage());
        }

        try {
            storage.savesFile(tasks);
        } catch (SallyException e) {
            ui.showError(e.getMessage());
        }
    }

    /**
     * Gets current ui to be returned
     *
     * @return ui to be displayed to user
     */
    public Ui getUi() {
        return this.ui;
    }

    /**
     * Indicates whether Sally should exit
     *
     * @return true if should exit, false otherwise
     */
    public boolean shouldExit() {
        return this.isBye;
    }
}
