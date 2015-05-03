package com.github.alicjawozniak.beatbutler.model;

import com.github.alicjawozniak.beatbutler.model.library.Library;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class PlayerModel {
    private PlaybackState playbackState = PlaybackState.STOPPED;
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private Playlist currentPlaylist = new Playlist();
    private Library library = new Library();

    public Playlist getCurrentPlaylist() {
        return currentPlaylist;
    }

    public void setCurrentPlaylist(Playlist currentPlaylist) {
        this.currentPlaylist = currentPlaylist;
    }

    public Library getLibrary() {
        return library;
    }

    public PlaybackState getPlaybackState() {
        return playbackState;
    }

    public void setPlaybackState(PlaybackState newState) {
        PlaybackState oldState = playbackState;
        playbackState = newState;
        changeSupport.firePropertyChange("playbackState", oldState, newState);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
}
