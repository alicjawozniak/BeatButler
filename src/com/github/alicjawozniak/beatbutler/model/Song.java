package com.github.alicjawozniak.beatbutler.model;

import com.github.alicjawozniak.beatbutler.controller.Controller;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;
import org.jaudiotagger.tag.images.Artwork;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * @author Tomasz Wójcik
 */
public class Song {
    private static Controller c = Controller.getInstance();
    private AudioFile audioFile;
    private String artist;
    private String title;
    private String album;
    private Image cover;
    private int time;

    public Song(String filename) {
        this(new File(filename));
    }

    public Song(File file) {
        try {
            audioFile = AudioFileIO.read(file);
            Tag tag = audioFile.getTag();

            Artwork artwork = tag.getFirstArtwork();
            cover = artwork != null ? (Image) artwork.getImage() : null;

            album = tag.getFirst(FieldKey.ALBUM);
            title = tag.getFirst(FieldKey.TITLE);
            artist = tag.getFirst(FieldKey.ARTIST);
        } catch (CannotReadException | IOException | ReadOnlyFileException | TagException | InvalidAudioFrameException e) {
            e.printStackTrace();
        }
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public String getAlbum() {
        return album;
    }

    public Image getCover() {
        return cover;
    }

    public String getInfo() {
        return null;
    }

    public int getTime() {
        return time;
    }
}
