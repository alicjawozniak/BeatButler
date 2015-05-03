package com.github.alicjawozniak.beatbutler.view;

import javax.swing.*;
import java.io.File;

/**
 * @author Tomasz Wójcik
 */
public class FolderChooser {
    private static File lastDir;
    private JFileChooser chooser;

    public FolderChooser() {
        chooser = new JFileChooser(lastDir);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setMultiSelectionEnabled(true);
    }

    public void show() {
        chooser.showDialog(new JDialog(), "Import folder");
        lastDir = chooser.getCurrentDirectory();
    }

    public File[] getSelectedFiles() {
        return chooser.getSelectedFiles();
    }
}
