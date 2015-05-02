package com.github.alicjawozniak.beatbutler.view;

import com.github.alicjawozniak.beatbutler.controller.actions.NextAction;
import com.github.alicjawozniak.beatbutler.controller.actions.PlayAction;
import com.github.alicjawozniak.beatbutler.controller.actions.PreviousAction;
import com.github.alicjawozniak.beatbutler.controller.actions.ToggleShuffleAction;

import javax.swing.*;

public class PlayerMenuBar {
    private JMenuBar bar = new JMenuBar();

    private JMenu fileMenu;
    private JMenu editMenu;
    private JMenu playbackMenu;

    public PlayerMenuBar() {
        fileMenu = new JMenu("File");
        fileMenu.add("New playlist");
        fileMenu.add(new JSeparator());
        fileMenu.add("Import");
        fileMenu.add("Import folder");
        fileMenu.add(new JSeparator());
        fileMenu.add("Quit");

        editMenu = new JMenu("Edit");
        editMenu.add("Cut");
        editMenu.add("Copy");
        editMenu.add("Paste");
        editMenu.add("Delete");
        editMenu.add(new JSeparator());
        editMenu.add("Search");
        editMenu.add("Select all");
        editMenu.add(new JSeparator());
        editMenu.add("Edit tags");

        playbackMenu = new JMenu("Playback");
        playbackMenu.add(new PlayAction());
        playbackMenu.add(new NextAction());
        playbackMenu.add(new PreviousAction());
        playbackMenu.add(new JSeparator());
        playbackMenu.add(new ToggleShuffleAction());
        playbackMenu.add("Repeat");
        playbackMenu.add(new JSeparator());
        playbackMenu.add("Mute");
        playbackMenu.add("Increase volume");
        playbackMenu.add("Decrease volume");

        bar.add(fileMenu);
        bar.add(editMenu);
        bar.add(playbackMenu);
    }

    public JMenuBar getBar() {
        return bar;
    }
}
