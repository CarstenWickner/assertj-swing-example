package org.hmx.example.assertj.swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MainWindow extends JFrame {

    public MainWindow() {
        super("MainWindow");
        this.setContentPane(this.createContentPane());
    }

    private JPanel createContentPane() {
        JTextArea centerArea = new JTextArea();
        centerArea.setName("Center-Area");
        centerArea.setEditable(false);
        JButton northButton = this.createButton("North", centerArea);
        JButton southButton = this.createButton("South", centerArea);
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.add(centerArea);
        contentPane.add(northButton, BorderLayout.NORTH);
        contentPane.add(southButton, BorderLayout.SOUTH);
        return contentPane;
    }

    private JButton createButton(final String text, final JTextArea centerArea) {
        JButton button = new JButton(text);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                centerArea.setText(centerArea.getText() + text + ", ");
            }
        });
        return button;
    }
}
