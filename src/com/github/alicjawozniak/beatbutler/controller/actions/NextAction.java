package com.github.alicjawozniak.beatbutler.controller.actions;

import com.github.alicjawozniak.beatbutler.ResourceLoader;
import com.github.alicjawozniak.beatbutler.controller.PlayerController;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class NextAction extends AbstractAction {
    public NextAction() {
        super("Next", ResourceLoader.getImageIcon("MD-next.png"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PlayerController.getInstance().getModel().next();
    }
}
