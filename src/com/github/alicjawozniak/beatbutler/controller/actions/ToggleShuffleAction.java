package com.github.alicjawozniak.beatbutler.controller.actions;

import com.github.alicjawozniak.beatbutler.ResourceLoader;
import com.github.alicjawozniak.beatbutler.controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ToggleShuffleAction extends AbstractAction {
    private final static ImageIcon icon = ResourceLoader.getImageIcon("MD-shuffle.png");
    private final Controller c = Controller.getInstance();

    public ToggleShuffleAction() {
        super("Shuffle");
        putValue(SMALL_ICON, icon);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.paramString());
        c.getView().toggleShuffleBtn(true);
    }
}
