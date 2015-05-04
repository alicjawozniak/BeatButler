package com.github.alicjawozniak.beatbutler.controller.actions;

import com.github.alicjawozniak.beatbutler.ResourceLoader;
import com.github.alicjawozniak.beatbutler.controller.PlayerController;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * @author Tomasz Wójcik
 */
public class ChangeVolumeAction extends AbstractAction {
    private final static ImageIcon INCREASE_ICON = ResourceLoader.getImageIcon("MD-volume-1.png");
    private final static ImageIcon DECREASE_ICON = ResourceLoader.getImageIcon("MD-volume-3.png");

    private PlayerController c = PlayerController.getInstance();
    private boolean isIncreasing;

    public ChangeVolumeAction(boolean isIncreasing) {
        super((isIncreasing ? "Increase" : "Decrease") + "volume", isIncreasing ? INCREASE_ICON : DECREASE_ICON);
        this.isIncreasing = isIncreasing;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        BoundedRangeModel brm = c.getModel().getVolumeModel();
        brm.setValue(isIncreasing ? brm.getValue() + 10 : brm.getValue() - 10);
    }
}
