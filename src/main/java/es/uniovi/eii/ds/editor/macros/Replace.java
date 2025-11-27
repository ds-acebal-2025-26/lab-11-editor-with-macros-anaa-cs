package es.uniovi.eii.ds.editor.macros;

import es.uniovi.eii.ds.editor.Document;

public class Replace implements Action {

    private Document document;
    private String oldText;
    private String newText;

    public Replace(Document document, String find, String replace) {
        this.document = document;
        oldText = find;
        newText = replace;
    }

    @Override
    public void execute() {
        document.replace(oldText, newText);
    }
}
