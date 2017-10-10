package org.hmx.example.assertj.swing;

public class MainApp {

    /**
     * Run me, to use the app yourself.
     *
     * @param args ignored
     */
    public static void main(String[] args) {
        MainApp.showWindow().setSize(600, 600);
    }

    /**
     * Internal standard method to initialize the view, returning the main JFrame (also to be used in automated tests).
     *
     * @return initialized JFrame instance
     */
    public static MainWindow showWindow() {
        MainWindow mainWindow = new MainWindow();
        mainWindow.setVisible(true);
        return mainWindow;
    }
}
