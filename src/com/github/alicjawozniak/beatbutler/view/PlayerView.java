package com.github.alicjawozniak.beatbutler.view;

import com.github.alicjawozniak.beatbutler.controller.actions.NextAction;
import com.github.alicjawozniak.beatbutler.controller.actions.PlayAction;
import com.github.alicjawozniak.beatbutler.controller.actions.PreviousAction;
import com.github.alicjawozniak.beatbutler.controller.actions.ToggleShuffleAction;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import java.awt.*;

public class PlayerView {
    TagEditorView editorView = new TagEditorView();
    PlayerMenuBar menuBar = new PlayerMenuBar();
    private JPanel mainPnl;
    private JTree libraryTree;
    private JList<String> playlistList;
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

    public PlayerView() {
        final JFrame frame = new JFrame("BeatButler");
        //frame.setUndecorated(true); /*todo własna ramka*/
        frame.setContentPane(mainPnl);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // menu bar
        frame.setJMenuBar(menuBar.getBar());

        // playBtn

        // volumeSld
        volumeSlr.setValue(0);

        // progressSlr
        progressSlr.setValue(0);

        // buttons
        playBtn.setAction(new PlayAction());
        nextBtn.setAction(new NextAction());
        prevBtn.setAction(new PreviousAction());
        shuffleBtn.setAction(new ToggleShuffleAction());

        playBtn.setHideActionText(true);
        nextBtn.setHideActionText(true);
        prevBtn.setHideActionText(true);
        shuffleBtn.setHideActionText(true);

        // library
        // todo przenieść do oddzielnej klasy

        MutableTreeNode jTreeRoot = new DefaultMutableTreeNode();

        MutableTreeNode[] categories = new MutableTreeNode[]{
                new DefaultMutableTreeNode("Songs"),
                new DefaultMutableTreeNode("Albums"),
                new DefaultMutableTreeNode("Artists"),
                new DefaultMutableTreeNode("Playlists"),
        };

        for (int i = 0; i < categories.length; i++) {
            jTreeRoot.insert(categories[i], i);
        }

        libraryTree.setModel(new DefaultTreeModel(jTreeRoot));
        libraryTree.setRootVisible(false);

        frame.pack();
        frame.setVisible(true);
    }

    // playlistPnl
    public void setPlaylistSongs(String[] songs) {
        playlistList.setListData(songs);
    }

    public int[] getPlaylistSelectedSongs() {
        return playlistList.getSelectedIndices();
    }

    public void setAlbumCover(byte[] imageData) {
        albumLbl.setIcon(new ImageIcon(imageData));
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
