package Matcher;

import Model.Task;
import Model.Prio;

public class PrioMatcher implements ITaskMatcher{
    private final Prio requiredPrio;

    public PrioMatcher(Prio requiredPrio){
        this.requiredPrio = requiredPrio;
    }

    // Matchar om taskens prioritet är exakt densamma som den önskade prioriteten.
    @Override
    public boolean match(Task task) {
        return task.getPrio() == requiredPrio;
    }
}
