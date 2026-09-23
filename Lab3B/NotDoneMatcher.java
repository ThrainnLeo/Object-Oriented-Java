package Matcher;

import Model.Task;
import Model.TaskState;

public class NotDoneMatcher implements ITaskMatcher{

    @Override
    public boolean match(Task task){
        //Den ska matcha om taskens tillstånd inte är DONE
        return task.getState() != TaskState.COMPLETED;
    }
}
