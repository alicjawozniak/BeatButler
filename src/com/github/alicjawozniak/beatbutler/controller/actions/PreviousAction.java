package com.github.alicjawozniak.beatbutler.controller.actions;

import com.github.alicjawozniak.beatbutler.ResourceLoader;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class PreviousAction extends AbstractAction {
    public PreviousAction() {
        super("Previous", ResourceLoader.getImageIcon("MD-previous.png"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.paramString());
    }
}
