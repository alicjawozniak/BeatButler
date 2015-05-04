package com.github.alicjawozniak.beatbutler.controller;

import com.github.alicjawozniak.beatbutler.controller.listeners.PlayerModelListener;
import com.github.alicjawozniak.beatbutler.model.PlayerModel;
import com.github.alicjawozniak.beatbutler.view.PlayerView;

/**
 * @author Tomasz W�jcik
 */
public class Controller {
    private static Controller instance;
    private PlayerView view;
    private PlayerModel model;

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public PlayerView getView() {
        return instance.view;
    }

    public void setView(PlayerView view) {
        instance.view = view;
    }

    public PlayerModel getModel() {
        return instance.model;
    }

    public void setModel(PlayerModel model) {
        model.addPropertyChangeListener(new PlayerModelListener());
        instance.model = model;
    }

    public void quit() {
        System.exit(0);
    }
}
