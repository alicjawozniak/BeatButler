package com.github.alicjawozniak.beatbutler.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Tomasz Wójcik
 */
public class PlaylistModelTest {
    private PlaylistModel playlist = new PlaylistModel();

    @Test(expected = NullPointerException.class)
    public void testSetName1() throws Exception {
        playlist.setName(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetName2() throws Exception {
        playlist.setName("");
    }

    @Test
    public void testSetName3() throws Exception {
        playlist.setName("%#$%*%^&!?.,za¿ó³æ gêœl¹ jaŸñ");
        Assert.assertEquals("za gl ja", playlist.getName());
    }

    @Test
    public void testSetName4() throws Exception {
        playlist.setName("test");
        Assert.assertEquals("test", playlist.getName());
    }
}