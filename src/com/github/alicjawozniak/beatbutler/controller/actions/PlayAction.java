package com.github.alicjawozniak.beatbutler.controller.actions;

import com.github.alicjawozniak.beatbutler.ResourceLoader;
import com.github.alicjawozniak.beatbutler.controller.Controller;
import com.github.alicjawozniak.beatbutler.model.PlaybackState;
import com.github.alicjawozniak.beatbutler.model.PlayerModel;
import com.github.alicjawozniak.beatbutler.model.Song;
import com.github.alicjawozniak.beatbutler.view.PlayerView;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class PlayAction extends AbstractAction {
    private static Controller c = Controller.getInstance();
    private static ImageIcon playIcon = ResourceLoader.getImageIcon("MD-play.png");
    private static ImageIcon pauseIcon = ResourceLoader.getImageIcon("MD-pause.png");

    private static PlayAction instance = new PlayAction();

    private PlayAction() {
        super("Play");
        putValue(SMALL_ICON, playIcon);
    }

    public static PlayAction getInstance() {
        return instance;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PlayerModel model = c.getModel();
        PlayerView view = c.getView();

        switch (model.getPlaybackState()) {
            case PAUSED:
            case STOPPED: // play
                putValue(SMALL_ICON, pauseIcon);
                model.setPlaybackState(PlaybackState.PLAYING);

                Song song = model.getCurrentPlaylist().getElementAt(view.getCurrentSongIndex());
                model.setCurrentSong(song);
                break;
            case PLAYING: // pause
                putValue(SMALL_ICON, playIcon);
                model.setPlaybackState(PlaybackState.PAUSED);
                break;
        }
    }
}
