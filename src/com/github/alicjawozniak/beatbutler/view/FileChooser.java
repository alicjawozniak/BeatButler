package com.github.alicjawozniak.beatbutler.view;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

/**
 * @author Tomasz Wójcik
 */
public class FileChooser {
    private static File lastDir;
    private JFileChooser chooser;

    public FileChooser() {
        chooser = new JFileChooser(lastDir);
        chooser.setFileFilter(new FileNameExtensionFilter("Audio files", "mp3", "aac"));
        chooser.setMultiSelectionEnabled(true);
    }

    public void show() {
        chooser.showDialog(new JDialog(), "Import");
        lastDir = chooser.getCurrentDirectory();
    }

    public File[] getSelectedFiles() {
        return chooser.getSelectedFiles();
    }
}
