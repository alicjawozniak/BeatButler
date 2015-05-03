package com.github.alicjawozniak.beatbutler.controller.actions;

import com.github.alicjawozniak.beatbutler.controller.Controller;
import com.github.alicjawozniak.beatbutler.model.Song;
import com.github.alicjawozniak.beatbutler.view.FolderChooser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Tomasz Wójcik
 */
public class ImportFolderAction extends AbstractAction {
    private Controller c = Controller.getInstance();

    public ImportFolderAction() {
        super("Import folder");
    }

    private static Collection<File> getFilesFromFolder(Collection<File> files, File dir) {
        File[] dirContents = dir.listFiles();
        if (dirContents == null) {
            return files;
        }

        for (File file : dirContents) {
            if (file.isDirectory()) {
                getFilesFromFolder(files, file);
            } else {
                files.add(file);
            }
        }

        return files;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        FolderChooser chooser = new FolderChooser();
        chooser.show();
        File[] dirs = chooser.getSelectedFiles();

        List<File> files = new ArrayList<File>();
        for (File dir : dirs) {
            getFilesFromFolder(files, dir);
        }

        for (File file : files) {
            c.getModel().getCurrentPlaylist().add(new Song(file));
        }
    }
}
