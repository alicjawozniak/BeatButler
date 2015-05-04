package com.github.alicjawozniak.beatbutler.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class PlayerModel {
    private PlaybackState playbackState = PlaybackState.STOPPED;
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private Playlist currentPlaylist = new Playlist();
    private Song currentSong = null;

    public Song getCurrentSong() {
        return currentSong;
    }

    public void setCurrentSong(Song currentSong) {
        Song oldSong = this.currentSong;
        this.currentSong = currentSong;
        changeSupport.firePropertyChange("current-song", oldSong, currentSong);
    }

    public Playlist getCurrentPlaylist() {
        return currentPlaylist;
    }

    public void setCurrentPlaylist(Playlist currentPlaylist) {
        this.currentPlaylist = currentPlaylist;
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
