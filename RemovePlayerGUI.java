package ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class RemovePlayerGUI extends JFrame implements ActionListener {
    private ScoutlistGUI scoutlistGUI;
    private JTextField indexField;

    public RemovePlayerGUI(ScoutlistGUI scoutlistGUI) {
        super("remove player");
        this.scoutlistGUI = scoutlistGUI;
        this.setRemovePlayer();
        this.setLabelsFieldsButtons();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void setRemovePlayer() {
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setPreferredSize(new Dimension(400, 200));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));
        setLayout(null);
    }

    private void setLabelsFieldsButtons() {
        JLabel indexLabel = new JLabel("Which player to remove", JLabel.CENTER);
        indexLabel.setBounds(26, 35, 200, 20);
        add(indexLabel);
        indexLabel.setForeground(Color.black);

        indexField = new JTextField(30);
        indexField.setBounds(200, 35, 200, 20);
        add(indexField);

        JButton finishButton = new JButton("remove");
        finishButton.setBounds(170,90,100,20);
        add(finishButton);
        finishButton.setActionCommand("FINISH_ACTION");
        finishButton.addActionListener(this);
        finishButton.setForeground(Color.black);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("FINISH_ACTION")) {
            int index = Integer.parseInt(indexField.getText());
            ScoutApp.removePlayer(index);
            scoutlistGUI.dispose();
            new ScoutlistGUI(ScoutApp.getList());
        }
    }
}
