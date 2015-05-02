package com.github.alicjawozniak.beatbutler;

import com.github.alicjawozniak.beatbutler.model.PlayerModel;
import com.github.alicjawozniak.beatbutler.view.PlayerView;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;

public class Main {
    private static PlayerView view;
    private static PlayerModel model;

    public static void main(String[] args) {
        try {
            System.out.println("BeatButler");
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    model = new PlayerModel();
                    view = new PlayerView();
                }
            });
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    public static PlayerView getView() {
        return view;
    }

    public static PlayerModel getModel() {
        return model;
    }
}