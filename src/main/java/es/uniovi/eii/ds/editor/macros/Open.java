package es.uniovi.eii.ds.editor.macros;


import es.uniovi.eii.ds.editor.Document;

import java.io.IOException;
import java.io.UncheckedIOException;

public class Open implements Action {

    private Document document;
    private String filename;

    public Open(Document document, String filename) {
        this.document = document;
        this.filename = filename;
    }

    @Override
    public void execute() {
        try {
            document.loadFromFile(filename);
        } catch (IOException e) {
            throw new UncheckedIOException(null, e);
        }
    }
}
