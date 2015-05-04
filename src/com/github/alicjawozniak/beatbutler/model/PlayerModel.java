package com.github.alicjawozniak.beatbutler.model;

import javax.swing.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class PlayerModel {
    private PlaybackState playbackState = PlaybackState.STOPPED;
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private PlaylistModel currentPlaylist = new PlaylistModel();
    private Song currentSong = Song.EMPTY;

    private DefaultBoundedRangeModel volumeModel = new DefaultBoundedRangeModel(0, 0, 0, 100);
    private DefaultBoundedRangeModel progressModel = new DefaultBoundedRangeModel(0, 0, 0, 0);

    private boolean shuffleOn;
    private boolean repeatOn;

    private int currentSongIndex = -1;

    public Song getCurrentSong() {
        return currentSong;
    }

    private void setCurrentSong(Song newSong) {
        Song oldSong = currentSong;
        currentSong = newSong;
        progressModel.setValue(0);
        progressModel.setMaximum(newSong.getTime());
        changeSupport.firePropertyChange("current-song", oldSong, newSong);
    }

    public int getCurrentSongIndex() {
        return currentSongIndex;
    }

    public PlaylistModel getCurrentPlaylist() {
        return currentPlaylist;
    }

    public void setCurrentPlaylist(PlaylistModel newState) {
        PlaylistModel oldPlaylist = currentPlaylist;
        currentPlaylist = newState;
        currentSong = Song.EMPTY;
        currentSongIndex = -1;
        changeSupport.firePropertyChange("current-playlist", oldPlaylist, newState);
    }

    public PlaybackState getPlaybackState() {
        return playbackState;
    }

    public void setPlaybackState(PlaybackState newState) {
        PlaybackState oldState = playbackState;
        playbackState = newState;
        changeSupport.firePropertyChange("state", oldState, newState);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

    public void setShuffleOn(boolean shuffleOn) {
        this.shuffleOn = shuffleOn;
    }

    public void setRepeatOn(boolean repeatOn) {
        this.repeatOn = repeatOn;
    }

    public DefaultBoundedRangeModel getProgressModel() {
        return progressModel;
    }

    public DefaultBoundedRangeModel getVolumeModel() {
        return volumeModel;
    }

    public void next() {
        if (currentSongIndex >= 0 && currentSongIndex < currentPlaylist.getSize()) {
            currentSongIndex++;
            Song song = currentPlaylist.getElementAt(currentSongIndex);
            setCurrentSong(song);
            System.out.println("next");

            if (playbackState == PlaybackState.PLAYING) {
                play();
            }
        } else {
            stop();
        }
    }

    public void previous() {
        if (currentSongIndex > 0 && currentSongIndex <= currentPlaylist.getSize()) {
            currentSongIndex--;
            Song song = currentPlaylist.getElementAt(currentSongIndex);
            setCurrentSong(song);
            System.out.println("previous");

            if (playbackState == PlaybackState.PLAYING) {
                play();
            }
        } else {
            stop();
        }
    }

    public void play() {
        pause();

        if (currentSongIndex < 0 || currentSongIndex >= currentPlaylist.getSize()) {
            if (currentPlaylist.getSize() > 0) {
                currentSongIndex = 0;
                setCurrentSong(currentPlaylist.getElementAt(0));
            } else {
                stop();
                return;
            }
        }

        if (currentSong.isPlayable()) {
            setPlaybackState(PlaybackState.PLAYING);
            System.out.println("playing " + currentSong);
        } else {
            stop();
        }
    }

    public void stop() {
        progressModel.setValue(0);
        setCurrentSong(Song.EMPTY);
        currentSongIndex = -1;
        setPlaybackState(PlaybackState.STOPPED);
        System.out.println("stop");
    }

    public void pause() {
        setPlaybackState(PlaybackState.PAUSED);
        System.out.println("pause");
    }
}
