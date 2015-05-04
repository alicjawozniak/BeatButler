package com.github.alicjawozniak.beatbutler.controller.actions;

import com.github.alicjawozniak.beatbutler.controller.PlayerController;
import com.github.alicjawozniak.beatbutler.model.PlaylistModel;
import com.github.alicjawozniak.beatbutler.model.Song;
import com.github.alicjawozniak.beatbutler.view.FileChooser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;

/**
 * @author Tomasz Wójcik
 */
public class ImportFilesAction extends AbstractAction {
    PlayerController c = PlayerController.getInstance();

    public ImportFilesAction() {
        super("Import");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.show();

        File[] files = fileChooser.getSelectedFiles();
        PlaylistModel currentPlaylist = c.getModel().getCurrentPlaylist();
        //Library library = c.getModel().getLibrary();

        for (File file : files) {
            currentPlaylist.add(new Song(file));
            //library.add(new Song(file));
        }
    }
}
