package com.github.alicjawozniak.beatbutler;

import com.github.alicjawozniak.beatbutler.controller.PlayerController;
import com.github.alicjawozniak.beatbutler.model.PlayerModel;
import com.github.alicjawozniak.beatbutler.view.PlayerView;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    PlayerController c = PlayerController.getInstance();
                    c.setModel(new PlayerModel());
                    c.setView(new PlayerView());
                }
            });
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }
}