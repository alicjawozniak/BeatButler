package com.github.alicjawozniak.beatbutler.controller.actions;

import com.github.alicjawozniak.beatbutler.controller.PlayerController;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * @author Tomasz W�jcik
 */
public class QuitAction extends AbstractAction {
    public QuitAction() {
        super("Quit");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PlayerController.getInstance().quit();
    }
}
