package com.github.alicjawozniak.beatbutler.model;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Tomasz Wójcik
 */
public class SongTest {
    private Song song;

    @Before
    public void setUp() throws Exception {
        song = new Song("C:\\Users\\Tomasz\\Music\\Dark Tranquility - Discography\\1997 - The Mind's I (Deluxe Ed. 2005)\\15 - Archetype.mp3");
    }

    @Test
    public void testGetAlbumImage() throws Exception {

    }

    @Test
    public void testGetArtist() throws Exception {
        System.out.println(song.getArtist());
    }

    @Test
    public void testGetTitle() throws Exception {
        System.out.println(song.getTitle());
    }

    @Test
    public void testGetTime() throws Exception {
        System.out.println(song.getTime());
    }

    @Test
    public void testGetInfo() throws Exception {
        System.out.println(song.getInfo());
    }
}