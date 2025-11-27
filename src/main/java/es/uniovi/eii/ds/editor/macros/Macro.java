package es.uniovi.eii.ds.editor.macros;

import java.util.ArrayList;
import java.util.List;

public class Macro implements Action {

    private List<Action> actions = new ArrayList<>();

    public void add(Action action) {
        actions.add(action);
    }

    @Override
    public void execute() {
        for (Action action : actions) {
            action.execute();
        }
    }
}
