package TicTacToe;

import Model.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TicTacToe extends JFrame {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 400;

    private Game game;
    private JPanel buttonPanel;
    private ArrayList<JButton> buttons;

    // Creates the UI for the tic tac toe game.
    // Effects: Creates the UI for the tic Tic Tac Toe game using a collection of buttons, and putting them on a panel.
    public TicTacToe() {
        super("Tic Tac Toe");

        game = new Game();
        setSize(WIDTH, HEIGHT);
        setLayout(new BorderLayout());
        createMenus();

        buttonPanel = new JPanel();

        buttonPanel.setLayout(new GridLayout(game.getNumRows(), game.getNumColumns()));

        buttons = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            final JButton button = new JButton("");
            final int count = i;
            buttons.add(button);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    action(button, count);
                    button.setFont(new Font("Arial", Font.PLAIN, 40));
                    isGameOver();
                }
            });

            for (JButton next : buttons) {
                buttonPanel.add(next);
            }

            Container c = getContentPane();

            c.add(buttonPanel, BorderLayout.CENTER);

            setVisible(true);
        }
    }


    // Updates the UI in the case the game is over.
    // MODIFIES: this
    // EFFECTS: Updates the UI in the game in the case the game is over, by dusplaying an on screen message.
    public void isGameOver() {
        if (game.IsOver() && !game.getWinner().equals("Draw")) {
            JOptionPane.showMessageDialog(null, "Game is over. " + game.getWinner() + " has won", "Good Game", JOptionPane.PLAIN_MESSAGE);
        }
        else if (game.IsOver() && game.getWinner().equals("Draw")) {
            JOptionPane.showMessageDialog(null, "Game is a draw. ", "Good Game", JOptionPane.PLAIN_MESSAGE);
        }
    }

    // Updates the UI on screen for the effects of a move made by user.
    // MODIFIES: this
    // EFFECTS: Updates the button pressed by the user with X or O depending on current player.
    public void action(JButton button, int num) {
        if (button.getText().equals("") && game.getCurrentPlayer() == 1) {
            button.setText("X");
            button.setBackground(Color.yellow);
            game.playerMove(num);
        }
        else if (button.getText().equals("") && game.getCurrentPlayer() == 2) {
            button.setText("O");
            button.setBackground(Color.cyan);
            game.playerMove(num);
        }
    }

    // Resets the game.
    // MODIFIES: this
    // EFFECTS: Creates a new game.
    public void resetToOriginal() {
        game = new Game();
        for (JButton next : buttons) {
            next.setText("");
        }
    }

    // Creates the menu for the program.
    // MODIFIES: this
    // EFFECTS: Creates the menu for the program.
    private void createMenus() {
        JMenuBar menuBar = new JMenuBar();
        JMenu gameMenu = new JMenu("File");

        JMenuItem menuItem = new JMenuItem("New Game");
        menuItem.addActionListener(new TicTacToeGame());
        gameMenu.add(menuItem);
        menuBar.add(gameMenu);
        menuItem.setAccelerator(KeyStroke.getKeyStroke("control N"));
        this.setJMenuBar(menuBar);
    }

    // Triggers the creation of a new game.
    private class TicTacToeGame extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            resetToOriginal();
        }
    }

    public static void main(String args[]) {
        new TicTacToe();
    }
}