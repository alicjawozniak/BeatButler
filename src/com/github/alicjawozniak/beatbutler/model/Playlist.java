package com.github.alicjawozniak.beatbutler.model;

import com.sun.istack.internal.NotNull;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * @author Tomasz Wójcik
 */
public class Playlist extends AbstractListModel<Song> implements Iterable<Song> {
    private String name = "New playlist";
    private List<Song> songs = new ArrayList<Song>();

    public String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        if (name == null)
            throw new NullPointerException();

        name = name.replaceAll("[^A-Za-z0-9_ ]", "");

        if (name.isEmpty())
            throw new IllegalArgumentException("name can't be empty");

        this.name = name;
    }

    public void add(@NotNull Song song) {
        if (song == null)
            throw new NullPointerException();

        songs.add(song);
        fireIntervalAdded(this, songs.size() - 1, songs.size() - 1);
    }

    public void remove(int index) {
        songs.remove(index);
        fireIntervalRemoved(this, index, index);
    }

    @Override
    public int getSize() {
        return songs.size();
    }

    @Override
    public Song getElementAt(int index) {
        return songs.get(index);
    }

    @Override
    public Iterator<Song> iterator() {
        return songs.iterator();
    }

    public class TitleComparator implements Comparator<Song> {
        @Override
        public int compare(Song o1, Song o2) {
            return o1.getTitle().compareTo(o2.getTitle());
        }
    }

    public class AlbumComparator implements Comparator<Song> {
        @Override
        public int compare(Song o1, Song o2) {
            return o2.getAlbum().compareTo(o2.getAlbum());
        }
    }

    public class ArtistComparator implements Comparator<Song> {
        @Override
        public int compare(Song o1, Song o2) {
            return o1.getArtist().compareTo(o2.getArtist());
        }
    }
}
