package com.github.alicjawozniak.beatbutler.controller.actions;

import com.github.alicjawozniak.beatbutler.ResourceLoader;
import com.github.alicjawozniak.beatbutler.controller.PlayerController;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ToggleRepeatAction extends AbstractAction {
    private final static ImageIcon ICON = ResourceLoader.getImageIcon("MD-repeat.png");
    private static ToggleRepeatAction instance;

    private PlayerController c = PlayerController.getInstance();

    private ToggleRepeatAction() {
        super("Repeat", ICON);
        putValue(SELECTED_KEY, false);
    }

    public static ToggleRepeatAction getInstance() {
        if (instance == null) {
            instance = new ToggleRepeatAction();
        }
        return instance;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        c.getModel().setRepeatOn((Boolean) getValue(SELECTED_KEY));
    }
}
