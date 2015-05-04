package com.github.alicjawozniak.beatbutler.controller.actions;

import com.github.alicjawozniak.beatbutler.ResourceLoader;
import com.github.alicjawozniak.beatbutler.controller.PlayerController;
import com.github.alicjawozniak.beatbutler.model.PlaybackState;
import com.github.alicjawozniak.beatbutler.model.PlayerModel;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class PlayAction extends AbstractAction {
    private final static ImageIcon PLAY_ICON = ResourceLoader.getImageIcon("MD-play.png");
    private final static ImageIcon PAUSE_ICON = ResourceLoader.getImageIcon("MD-pause.png");
    private static PlayerController c = PlayerController.getInstance();
    private static PlayAction instance = new PlayAction();

    private PlayAction() {
        super("Play", PLAY_ICON);
    }

    public static PlayAction getInstance() {
        return instance;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PlayerModel model = c.getModel();

        switch (model.getPlaybackState()) {
            case PAUSED:
            case STOPPED: // play
                model.play();
                break;
            case PLAYING: // pause
                model.pause();
                break;
        }
    }

    public void changeState(PlaybackState state) {
        switch (state) {
            case STOPPED:
            case PAUSED:
                putValue(SMALL_ICON, PLAY_ICON);
                break;
            case PLAYING:
                putValue(SMALL_ICON, PAUSE_ICON);
                break;
        }
    }
}
