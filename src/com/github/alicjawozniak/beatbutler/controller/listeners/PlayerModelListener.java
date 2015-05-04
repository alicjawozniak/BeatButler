package com.github.alicjawozniak.beatbutler.controller.listeners;

import com.github.alicjawozniak.beatbutler.controller.Controller;
import com.github.alicjawozniak.beatbutler.model.Song;
import com.github.alicjawozniak.beatbutler.view.PlayerView;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * @author Tomasz Wójcik
 */
public class PlayerModelListener implements PropertyChangeListener {
    Controller c = Controller.getInstance();

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String property = evt.getPropertyName();
        if (property.equals("current-song")) {
            PlayerView view = c.getView();
            Song song = (Song) evt.getNewValue();
            view.setPlayingNowSong(song.getTitle(), song.getArtist(), song.getTime(), song.getCover());
        }
    }
}
