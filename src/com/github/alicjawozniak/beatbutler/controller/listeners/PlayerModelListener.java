package com.github.alicjawozniak.beatbutler.controller.listeners;

import com.github.alicjawozniak.beatbutler.controller.PlayerController;
import com.github.alicjawozniak.beatbutler.controller.actions.PlayAction;
import com.github.alicjawozniak.beatbutler.model.PlaybackState;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * @author Tomasz Wójcik
 */
public class PlayerModelListener implements PropertyChangeListener {
    PlayerController c = PlayerController.getInstance();

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String property = evt.getPropertyName();

        switch (property) {
            case "current-song":
                c.getView().updateSong();
                break;

            case "current-playlist":
                c.getView().updatePlaylist();
                break;

            case "state":
                PlaybackState state = (PlaybackState) evt.getNewValue();
                PlayAction action = PlayAction.getInstance();

                action.changeState(state);
                break;
        }
    }
}
