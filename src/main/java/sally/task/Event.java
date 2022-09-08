package sally.task;

import sally.task.Task;

/**
 * Event class to represent new Event task
 *
 * @author liviamil
 */

public class Event extends Task {
    String moreInfo;
    public Event(String description, String moreInfo, boolean saveTask) {
        super(description, moreInfo, saveTask);
        this.moreInfo = moreInfo;
        this.taskType = Type.EVENT;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + this.moreInfo + ")";
    }
}
