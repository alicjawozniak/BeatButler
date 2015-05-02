package com.github.alicjawozniak.beatbutler.controller.actions;

import com.github.alicjawozniak.beatbutler.Main;
import com.github.alicjawozniak.beatbutler.ResourceLoader;
import com.github.alicjawozniak.beatbutler.model.PlaybackState;
import com.github.alicjawozniak.beatbutler.model.PlayerModel;
import com.github.alicjawozniak.beatbutler.view.PlayerView;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class PlayAction extends AbstractAction {
    private ImageIcon playIcon = ResourceLoader.getImageIcon("MD-play.png");
    private ImageIcon pauseIcon = ResourceLoader.getImageIcon("MD-pause.png");

    private PlayerModel model = Main.getModel();
    private PlayerView view = Main.getView();

    public PlayAction() {
        super("Play");
        putValue(SMALL_ICON, playIcon);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (model.getPlaybackState()) {
            case PAUSED:
            case STOPPED:
                putValue(SMALL_ICON, pauseIcon);
                model.setPlaybackState(PlaybackState.PLAYING);
                break;
            case PLAYING:
                putValue(SMALL_ICON, playIcon);
                model.setPlaybackState(PlaybackState.PAUSED);
                break;
        }
        System.out.println(e.paramString());
    }
}
