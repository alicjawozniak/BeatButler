package com.github.alicjawozniak.beatbutler.controller;

import com.github.alicjawozniak.beatbutler.model.PlayerModel;
import com.github.alicjawozniak.beatbutler.view.PlaybackViewListener;
import com.github.alicjawozniak.beatbutler.view.PlayerView;

import java.util.Timer;
import java.util.TimerTask;

public class PlayerController {
    PlayerView view;
    PlayerModel model;

    public PlayerController(final PlayerView view, PlayerModel model) {
        this.view = view;
        this.model = model;

        this.view.addPlaybackViewListener(new PlaybackViewListener() {
            boolean isPaused = true; //todo przenie滄 do modelu
            int lastSongIndex = -1; //todo przenie滄 do modelu

            @Override
            public void onPlay() {
                // todo usun规 po testach
                if (isPaused) {
                    try {
                        System.out.println("play: playing " + view.getPlaylistSelectedSongs()[0]);
                        lastSongIndex = view.getPlaylistSelectedSongs()[0];
                        view.setPlayingNowSong("song " + lastSongIndex, (int) (Math.random() * 180));
                        view.setIsPaused(true);
                        isPaused = false;

                        final Timer timer = new Timer(); //todo usun规 po testach
                        timer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                if (isPaused)
                                    timer.cancel();
                                else
                                    view.setProgress(view.getProgress() + 1);
                            }
                        }, 1000, 1000);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("play: selection empty");
                    }
                } else {
                    System.out.println("play: paused");
                    view.setIsPaused(false);
                    isPaused = true;
                }
            }

            @Override
            public void onStop() {

            }

            @Override
            public void onNext() {
                // todo usun规 po testach
                if (lastSongIndex < 0 || lastSongIndex >= 3)
                    return;
                System.out.println("play: playing " + ++lastSongIndex);
                view.setPlayingNowSong("song " + lastSongIndex, (int) (Math.random() * 180));
            }

            @Override
            public void onPrevious() {
                // todo usun规 po testach
                if (lastSongIndex <= 0 || lastSongIndex > 3)
                    return;
                System.out.println("play: playing " + --lastSongIndex);
                view.setPlayingNowSong("song " + lastSongIndex, (int) (Math.random() * 180));
            }

            @Override
            public void volumeChanged() {
                System.out.println("volume: " + view.getVolume());
            }

            @Override
            public void progressChanged() {
                System.out.println("progress: " + view.getProgress());
            }

            @Override
            public void playlistChanged() {

            }

            @Override
            public void songChanged() {

            }
        });
    }
}
