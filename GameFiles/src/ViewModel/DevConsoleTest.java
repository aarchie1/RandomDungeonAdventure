package ViewModel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DevConsoleTest {

    DevConsole view = new DevConsole();
    @Test
    void playNewGame() {
        view.playNewGame();
    }
}