package com.github.alicjawozniak.beatbutler.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class PlayerModel {
    private PlaybackState playbackState = PlaybackState.STOPPED;
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

    public PlaybackState getPlaybackState() {
        return playbackState;
    }

    public void setPlaybackState(PlaybackState newState) {
        PlaybackState oldState = playbackState;
        playbackState = newState;
        changeSupport.firePropertyChange("playbackState", oldState, newState);
    }
}
