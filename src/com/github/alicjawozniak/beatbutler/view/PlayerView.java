package com.github.alicjawozniak.beatbutler.view;

import com.github.alicjawozniak.beatbutler.ResourceLoader;
import com.github.alicjawozniak.beatbutler.controller.PlayerController;
import com.github.alicjawozniak.beatbutler.controller.actions.*;
import com.github.alicjawozniak.beatbutler.model.Song;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.io.IOException;

public class PlayerView {
    PlayerController c = PlayerController.getInstance();

    //TagEditorView editorView = new TagEditorView();
    private JPanel mainPnl;
    private JList<Song> playlistList;
    private JLabel playingNowLbl;
    private JButton prevBtn;
    private JButton playBtn;
    private JButton nextBtn;
    private JLabel progressLbl;
    private JSlider progressSlr;
    private JLabel albumLbl;
    private JSlider volumeSlr;

    private JToggleButton shuffleBtn;

    private JTabbedPane libraryPnl;
    private JList artistsList;
    private JList albumsList;
    private JList songsList;
    private JList playlistsList;
    private JToggleButton repeatBtn;
    private JLabel songLengthLbl;

    private Image defaultCover;

    public PlayerView() {
        final JFrame frame = new JFrame("BeatButler");

        // default cover art
        try {
            defaultCover = ResourceLoader.getImage("tmp-album.png");
        } catch (IOException e) {
            e.printStackTrace();
            defaultCover = null;
        }

        //frame.setUndecorated(true); /*todo własna ramka*/
        frame.setContentPane(mainPnl);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // menu bar
        frame.setJMenuBar(new PlayerMenuBar().getBar());

        // sliders
        volumeSlr.setModel(c.getModel().getVolumeModel());
        progressSlr.setModel(c.getModel().getProgressModel());
        progressSlr.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = c.getModel().getProgressModel().getValue();
                progressLbl.setText(String.format("%2d:%02d", value / 60, value % 60));
            }
        });

        // buttons
        playBtn.setAction(PlayAction.getInstance());
        nextBtn.setAction(new NextAction());
        prevBtn.setAction(new PreviousAction());

        shuffleBtn.setAction(ToggleShuffleAction.getInstance());
        repeatBtn.setAction(ToggleRepeatAction.getInstance());

        // playlist
        playlistList.setModel(c.getModel().getCurrentPlaylist());
        playlistList.setCellRenderer(new PlaylistCellRenderer());

        // library

        frame.pack();
        frame.setVisible(true);
    }

    public void updateSong() {
        Song song = c.getModel().getCurrentSong();

        playingNowLbl.setText(String.format("%s - %s", song.getArtist(), song.getTitle()));

        Image cover = song.getCover();
        if (cover == null) {
            cover = defaultCover;
        }
        ImageIcon icon = new ImageIcon(cover.getScaledInstance(albumLbl.getWidth(), albumLbl.getHeight(), Image.SCALE_SMOOTH));
        albumLbl.setIcon(icon);

        songLengthLbl.setText(String.format("%2d:%02d", song.getTime() / 60, song.getTime() % 60));
    }

    public void updatePlaylist() {
        playlistList.setModel(c.getModel().getCurrentPlaylist());
    }
}