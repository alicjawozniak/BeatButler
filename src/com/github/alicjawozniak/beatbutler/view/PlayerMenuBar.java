package com.github.alicjawozniak.beatbutler.view;

import com.github.alicjawozniak.beatbutler.controller.actions.*;

import javax.swing.*;

public class PlayerMenuBar {
    private JMenuBar bar = new JMenuBar();

    public PlayerMenuBar() {
        JMenu file = new JMenu("File");
        file.add("New playlist"); // todo
        file.add("Save playlist"); // todo
        file.add(new JSeparator());
        file.add(new ImportFilesAction());
        file.add(new ImportFolderAction());
        file.add(new JSeparator());
        file.add(new QuitAction());

        // todo
        JMenu edit = new JMenu("Edit");
        edit.add("Cut");
        edit.add("Copy");
        edit.add("Paste");
        edit.add("Delete");
        edit.add(new JSeparator());
        edit.add("Search");
        edit.add("Select all");
        edit.add(new JSeparator());
        edit.add("Edit tags");
        // ~

        JMenu playback = new JMenu("Playback");
        playback.add(PlayAction.getInstance());
        playback.add(new NextAction());
        playback.add(new PreviousAction());
        playback.add(new JSeparator());
        playback.add(new JCheckBoxMenuItem(ToggleShuffleAction.getInstance()));
        playback.add(new JCheckBoxMenuItem(ToggleRepeatAction.getInstance()));
        playback.add(new JSeparator());
        playback.add(new MuteAction());
        playback.add(new ChangeVolumeAction(true));
        playback.add(new ChangeVolumeAction(false));

        bar.add(file);
        bar.add(edit);
        bar.add(playback);
    }

    public JMenuBar getBar() {
        return bar;
    }
}
