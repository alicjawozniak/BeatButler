package com.github.alicjawozniak.beatbutler.controller.actions;

import com.github.alicjawozniak.beatbutler.ResourceLoader;
import com.github.alicjawozniak.beatbutler.controller.Controller;
import com.github.alicjawozniak.beatbutler.model.PlaybackState;

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
        switch (c.getModel().getPlaybackState()) {
            case PAUSED:
            case STOPPED: // play
                putValue(SMALL_ICON, pauseIcon);
                c.getModel().setPlaybackState(PlaybackState.PLAYING);
                break;
            case PLAYING: // pause
                putValue(SMALL_ICON, playIcon);
                c.getModel().setPlaybackState(PlaybackState.PAUSED);
                break;
        }
    }
}
