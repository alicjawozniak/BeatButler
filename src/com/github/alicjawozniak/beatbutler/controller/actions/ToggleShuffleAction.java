package com.github.alicjawozniak.beatbutler.controller.actions;

import com.github.alicjawozniak.beatbutler.Main;
import com.github.alicjawozniak.beatbutler.ResourceLoader;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ToggleShuffleAction extends AbstractAction {
    private final static ImageIcon icon = ResourceLoader.getImageIcon("MD-shuffle.png");

    public ToggleShuffleAction() {
        super("Shuffle");
        putValue(SMALL_ICON, icon);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.paramString());
        Main.getView().toggleShuffleBtn(true);
    }
}
