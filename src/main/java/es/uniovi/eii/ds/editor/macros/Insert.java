package es.uniovi.eii.ds.editor.macros;

import es.uniovi.eii.ds.editor.Document;

public class Insert implements Action{

    private Document document;
    private String[] words;

    public Insert(Document document, String[] words) {
        this.document = document;
        this.words = words;
    }

    @Override
    public void execute() {
        document.insert(words);
    }
}
