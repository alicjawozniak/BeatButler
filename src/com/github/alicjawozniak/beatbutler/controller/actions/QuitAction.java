package com.github.alicjawozniak.beatbutler.controller.actions;

import com.github.alicjawozniak.beatbutler.controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * @author Tomasz Wójcik
 */
public class QuitAction extends AbstractAction {
    public QuitAction() {
        super("Quit");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Controller.getInstance().quit();
    }
}
