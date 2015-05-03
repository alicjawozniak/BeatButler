package com.github.alicjawozniak.beatbutler;

import com.github.alicjawozniak.beatbutler.controller.Controller;
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
                    Controller c = Controller.getInstance();
                    c.setModel(new PlayerModel());
                    c.setView(new PlayerView());
                }
            });
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }
}