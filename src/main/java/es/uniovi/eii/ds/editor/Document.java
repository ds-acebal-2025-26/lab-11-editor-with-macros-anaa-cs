package es.uniovi.eii.ds.editor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class Document {

    private StringBuilder text;

    public Document() {
        text = new StringBuilder("");
    }

    public String getText() {
        return text.toString();
    }

    public void loadFromFile(String filename) throws IOException {
        text = new StringBuilder(readFile(filename));
    }

    private String readFile(String filename) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader(filename));
        String line;
        StringBuilder result = new StringBuilder();
        while ((line = input.readLine()) != null) {
            result.append(line);
        }
        input.close();
        return result.toString();
    }

    public void insert(String[] words) {
        for (String word : words) {
            text.append(word + " ");
        }
    }

    public void delete() {
        int indexOfLastWord = text.toString().trim().lastIndexOf(" ");
        if (indexOfLastWord == -1)
            text = new StringBuilder("");
        else
            text.setLength(indexOfLastWord + 1);
    }

    public void replace(String find, String replace) {
        text = new StringBuilder(text.toString().replaceAll(Pattern.quote(find), replace));
    }
}
