public class Deadline extends Task {
    protected String moreInfo;

    public Deadline(String description, String moreInfo, boolean saveTask) {
        super(description, moreInfo, saveTask);
        this.moreInfo = moreInfo;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + this.moreInfo + ")";
    }
}
