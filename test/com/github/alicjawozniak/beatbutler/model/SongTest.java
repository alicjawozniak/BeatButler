package com.github.alicjawozniak.beatbutler.model;

import com.github.alicjawozniak.beatbutler.ResourceLoader;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Tomasz Wójcik
 */
public class SongTest {
    private Song song;

    @Before
    public void setUp() throws Exception {
        song = new Song(ResourceLoader.getResource("CrawlThroughKnives.mp3").getFile());
    }

    @Test
    public void testGetArtist() throws Exception {
        System.out.println("artist='" + song.getArtist() + "'");
    }

    @Test
    public void testGetAlbum() throws Exception {
        System.out.println("album='" + song.getAlbum() + "'");
    }

    @Test
    public void testGetTitle() throws Exception {
        System.out.println("title='" + song.getTitle() + "'");
    }

    @Test
    public void testGetTime() throws Exception {
        System.out.println("time=" + song.getTime());
    }
}