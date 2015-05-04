package com.github.alicjawozniak.beatbutler.controller.actions;

import com.github.alicjawozniak.beatbutler.ResourceLoader;
import com.github.alicjawozniak.beatbutler.controller.PlayerController;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * @author Tomasz Wójcik
 */
public class MuteAction extends AbstractAction {
    private final static ImageIcon ICON = ResourceLoader.getImageIcon("MD-volume-0-alt.png");
    private PlayerController c = PlayerController.getInstance();

    public MuteAction() {
        super("Mute", ICON);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        c.getModel().getVolumeModel().setValue(0);
    }
}
