package com.github.alicjawozniak.beatbutler.view;

import com.github.alicjawozniak.beatbutler.ResourceLoader;
import com.github.alicjawozniak.beatbutler.controller.Controller;
import com.github.alicjawozniak.beatbutler.controller.actions.NextAction;
import com.github.alicjawozniak.beatbutler.controller.actions.PlayAction;
import com.github.alicjawozniak.beatbutler.controller.actions.PreviousAction;
import com.github.alicjawozniak.beatbutler.controller.actions.ToggleShuffleAction;
import com.github.alicjawozniak.beatbutler.model.Song;
import com.github.alicjawozniak.beatbutler.model.library.Library;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class PlayerView {
    Controller c = Controller.getInstance();

    //TagEditorView editorView = new TagEditorView();
    private JPanel mainPnl;
    private JTree libraryTree;
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
        libraryTree.setModel(new Library());
        libraryTree.setRootVisible(false);
        libraryTree.setCellRenderer(new LibraryCellRenderer());

        frame.pack();
        frame.setVisible(true);
    }

    public Image getDefaultCover() {
        return defaultCover;
    }

    // playlistPnl
    /*
    public Song[] getPlaylistSelectedSongs() {
        return playlistList;
    }*/

    public void setCover(Image cover) {
        ImageIcon icon = new ImageIcon(cover.getScaledInstance(albumLbl.getWidth(), albumLbl.getHeight(), Image.SCALE_SMOOTH));
        albumLbl.setIcon(icon);
    }

    public void setPlayingNowSong(String song, int time) {
        playingNowLbl.setText(song);
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
}
