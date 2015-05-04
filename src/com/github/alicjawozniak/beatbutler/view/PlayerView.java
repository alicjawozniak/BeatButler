package com.github.alicjawozniak.beatbutler.view;

import com.github.alicjawozniak.beatbutler.ResourceLoader;
import com.github.alicjawozniak.beatbutler.controller.Controller;
import com.github.alicjawozniak.beatbutler.controller.actions.NextAction;
import com.github.alicjawozniak.beatbutler.controller.actions.PlayAction;
import com.github.alicjawozniak.beatbutler.controller.actions.PreviousAction;
import com.github.alicjawozniak.beatbutler.controller.actions.ToggleShuffleAction;
import com.github.alicjawozniak.beatbutler.model.Song;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class PlayerView {
    Controller c = Controller.getInstance();

    //TagEditorView editorView = new TagEditorView();
    private JPanel mainPnl;
    private JList<Song> playlistList;
    private JLabel playingNowLbl;
    private JButton prevBtn;
    private JButton playBtn;
    private JButton nextBtn;
    private JLabel timeLbl;
    private JSlider progressSlr;
    private JLabel albumLbl;
    private JLabel volumeLbl;
    private JSlider volumeSlr;
    private JButton repeatBtn;
    private JButton shuffleBtn;

    private JTabbedPane libraryPnl;
    private JList artistsList;
    private JList albumsList;
    private JList songsList;
    private JList playlistsList;

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

        // volumeSld
        volumeSlr.setValue(0);

        // progressSlr
        progressSlr.setValue(0);

        // buttons
        playBtn.setAction(PlayAction.getInstance());
        nextBtn.setAction(new NextAction());
        prevBtn.setAction(new PreviousAction());
        shuffleBtn.setAction(new ToggleShuffleAction());

        playBtn.setHideActionText(true);
        nextBtn.setHideActionText(true);
        prevBtn.setHideActionText(true);
        shuffleBtn.setHideActionText(true);

        // playlist
        playlistList.setModel(c.getModel().getCurrentPlaylist());
        playlistList.setCellRenderer(new PlaylistCellRenderer());

        // library

        frame.pack();
        frame.setVisible(true);
    }

    // playlistPnl
    /*
    public Song[] getPlaylistSelectedSongs() {
        return playlistList;
    }*/

    public void setPlayingNowSong(String title, String artist, int time, Image cover) {
        playingNowLbl.setText(String.format("%s - %s [%d]", artist, title, time));

        if (cover == null) {
            cover = defaultCover;
        }
        ImageIcon icon = new ImageIcon(cover.getScaledInstance(albumLbl.getWidth(), albumLbl.getHeight(), Image.SCALE_SMOOTH));
        albumLbl.setIcon(icon);

        progressSlr.setValue(0);
        progressSlr.setMaximum(time);
    }

    public int getProgress() {
        return progressSlr.getValue();
    }

    public void setProgress(int progress) {
        timeLbl.setText(String.format("%2d:%02d", progressSlr.getValue() / 60, progressSlr.getValue() % 60)); // todo przenieść do modelu
        progressSlr.setValue(progress);
    }

    public int getVolume() {
        return volumeSlr.getValue();
    }

    public void toggleShuffleBtn(boolean b) {
        shuffleBtn.setBackground(b ? Color.green : repeatBtn.getBackground());
    }

    public int getCurrentSongIndex() {
        return playlistList.getSelectedIndex();
    }
}
