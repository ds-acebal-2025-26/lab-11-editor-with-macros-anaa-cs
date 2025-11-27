package es.uniovi.eii.ds.editor.actions;

import es.uniovi.eii.ds.editor.Document;

public class Delete implements Action {

    private Document document;

    public Delete(Document document) {
        this.document = document;
    }

    @Override
    public void execute() {
        document.delete();
    }
}
