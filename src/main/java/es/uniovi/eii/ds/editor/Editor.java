package es.uniovi.eii.ds.editor;

import es.uniovi.eii.ds.editor.actions.*;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Editor {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    private Document document;

    private Map<String, Macro> macros = new HashMap<>();
    private Macro macro;
    private String macroName;

    public Editor() {
        document = new Document();
    }

    public Document getDocument() {
        return document;
    }

    public void open(String filename) {
        try {
            executeAction(new Open(document, filename));
        } catch (UncheckedIOException e) {
            System.out.println("It could not be read");
        }
    }

    public void insert(String[] words) {
        executeAction(new Insert(document, words));
    }

    public void delete() {
        executeAction(new Delete(document));
    }

    public void replace(String find, String replace) {
        executeAction(new Replace(document, find, replace));
    }

    public void recordMacro(String name) {
        macro = new Macro();
        macroName = name;
    }

    public boolean isRecordingMacro() {
        return macro != null;
    }

    public void stopRecording() {
        if (!isRecordingMacro())
            return;
        macros.put(macroName, macro);
        macro = null;
        macroName = null;
    }

    public void executeMacro(String name) {
        executeAction(macros.get(name));
    }

    private void executeAction(Action action) {
        action.execute();
        if (isRecordingMacro()) {
            macro.add(action);
        }
    }
}
