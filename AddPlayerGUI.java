package ui;

import model.Player;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPlayerGUI extends JFrame implements ActionListener {
    private ScoutlistGUI scoutlistGUI;
    private JTextField nameField;
    private JTextField ageField;
    private JTextField hometeamField;
    private JTextField positionField;
    private JTextField ratingField;
    private JTextField footField;
    private JTextField statusField;

    public AddPlayerGUI(ScoutlistGUI scoutlistGUI) {
        super("add player");
        this.scoutlistGUI = scoutlistGUI;
        this.setAddPlayer();
        this.setLabelsFieldsButtons1();
        this.setLabelsFieldsButtons2();
        this.setLabelsFieldsButtons3();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void setAddPlayer() {
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setPreferredSize(new Dimension(400, 350));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));
        setLayout(null);
    }

    private void setLabelsFieldsButtons1() {
        JLabel label1 = new JLabel("player name: ");
        label1.setBounds(50, 40, 250, 20);
        add(label1);
        label1.setForeground(Color.black);

        nameField = new JTextField(30);
        nameField.setBounds(250, 40, 100, 20);
        add(nameField);


        JLabel label2 = new JLabel(
                "player age: ");
        label2.setBounds(50, 70, 250, 20);
        add(label2);
        label2.setForeground(Color.black);

        ageField = new JTextField(30);
        ageField.setBounds(250, 70, 100, 20);
        add(ageField);


        JLabel label3 = new JLabel(
                "player home team: ");
        label3.setBounds(50, 100, 250, 20);
        add(label3);
        label3.setForeground(Color.black);

        hometeamField = new JTextField(30);
        hometeamField.setBounds(250, 100, 100, 20);
        add(hometeamField);
    }

    private void setLabelsFieldsButtons2() {
        JLabel label4 = new JLabel(
                "position: ");
        label4.setBounds(50, 130, 250, 20);
        add(label4);
        label4.setForeground(Color.black);

        positionField = new JTextField(30);
        positionField.setBounds(250, 130, 100, 20);
        add(positionField);

        JLabel label5 = new JLabel(
                "rating: ");
        label5.setBounds(50, 160, 250, 20);
        add(label5);
        label5.setForeground(Color.black);

        ratingField = new JTextField(30);
        ratingField.setBounds(250, 160, 100, 20);
        add(ratingField);
    }

    private void setLabelsFieldsButtons3() {
        JLabel label6 = new JLabel(
                "foot: ");
        label6.setBounds(50, 190, 250, 20);
        add(label6);
        label6.setForeground(Color.black);

        footField = new JTextField(30);
        footField.setBounds(250, 190, 100, 20);
        add(footField);

        JLabel label7 = new JLabel(
                "status: ");
        label7.setBounds(50, 220, 400, 20);
        add(label7);
        label7.setForeground(Color.black);

        statusField = new JTextField(30);
        statusField.setBounds(250, 220, 100, 20);
        add(statusField);

        JButton finishButton = new JButton("add");
        finishButton.setBounds(250, 250, 100, 20);
        add(finishButton);
        finishButton.setActionCommand("FINISH_ACTION");
        finishButton.addActionListener(this);
        finishButton.setForeground(Color.black);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("FINISH_ACTION")) {
            String name = nameField.getText();
            int age = Integer.parseInt(ageField.getText());
            String hometeam = hometeamField.getText();
            String position = positionField.getText();
            int rating = Integer.parseInt(ratingField.getText());
            Player.Foot foot = Player.Foot.valueOf(footField.getText());
            Player.Status status = Player.Status.valueOf(statusField.getText());
            ScoutApp.addPlayer(
                    new Player(
                            name,
                            age,
                            hometeam,
                            position,
                            rating,
                            foot,
                            status));
            ScoutApp.saveList();
            scoutlistGUI.dispose();
            new ScoutlistGUI(ScoutApp.getList());
            dispose();
        }
    }
}