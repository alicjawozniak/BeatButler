package com.github.alicjawozniak.beatbutler.controller.actions;

import com.github.alicjawozniak.beatbutler.ResourceLoader;
import com.github.alicjawozniak.beatbutler.controller.PlayerController;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ToggleShuffleAction extends AbstractAction {
    private final static ImageIcon ICON = ResourceLoader.getImageIcon("MD-shuffle.png");
    private static ToggleShuffleAction instance;

    private PlayerController c = PlayerController.getInstance();

    private ToggleShuffleAction() {
        super("Shuffle", ICON);
        putValue(SELECTED_KEY, false);
    }

    public static ToggleShuffleAction getInstance() {
        if (instance == null) {
            instance = new ToggleShuffleAction();
        }
        return instance;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        c.getModel().setShuffleOn((Boolean) getValue(SELECTED_KEY));
    }
}
