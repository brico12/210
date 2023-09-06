package ui;

import model.Scoutlist;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI
        extends JFrame implements ActionListener {

    private final Scoutlist scoutlist = new Scoutlist();
    private ScoutlistGUI scoutlistGUI;
    JFrame frame;


    public GUI() {
        frame = new JFrame("Scout list");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setBounds(200, 600, 200, 500);
        frame.setPreferredSize(new Dimension(400, 600));
        ((JPanel) frame.getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));
        frame.setLayout(null);
        setButtons1();
        setButtons2();
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }


    private void setButtons1() {

        JButton addPlayerButton = new JButton("add player");
        addPlayerButton.setBounds(50, 40, 300, 20);
        addPlayerButton.setActionCommand("ADD_ACTION");
        addPlayerButton.addActionListener(this);
        addPlayerButton.setForeground(Color.black);
        frame.add(addPlayerButton);

        JButton removePlayerButton = new JButton("remove player");
        removePlayerButton.setBounds(50, 240, 300, 20);
        removePlayerButton.setActionCommand("REMOVE_ACTION");
        removePlayerButton.addActionListener(this);
        removePlayerButton.setForeground(Color.black);
        frame.add(removePlayerButton);

        JButton printListButton = new JButton("print scout list");
        printListButton.setBounds(50, 80, 300, 20);
        printListButton.setActionCommand("PRINT_ACTION");
        printListButton.addActionListener(this);
        printListButton.setForeground(Color.black);
        frame.add(printListButton);
    }

    private void setButtons2() {
        JButton saveScoutListButton = new JButton("save scout list");
        saveScoutListButton.setBounds(50, 120, 300, 20);
        saveScoutListButton.setActionCommand("SAVE_ACTION");
        saveScoutListButton.addActionListener(this);
        saveScoutListButton.setForeground(Color.black);
        frame.add(saveScoutListButton);

        JButton loadListButton = new JButton("load list from file");
        loadListButton.setBounds(50, 160, 300, 20);
        loadListButton.setActionCommand("LOAD_ACTION");
        loadListButton.addActionListener(this);
        loadListButton.setForeground(Color.black);
        frame.add(loadListButton);

        JButton quitButton = new JButton("quit");
        quitButton.setBounds(50, 200, 300, 20);
        quitButton.setActionCommand("QUIT_ACTION");
        quitButton.addActionListener(this);
        quitButton.setForeground(Color.black);
        frame.add(quitButton);

        JLabel imageLabel = new JLabel(new ImageIcon("data/SCOUT.jpeg"));
        imageLabel.setBounds(50, 250, 300, 300);
        frame.add(imageLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("ADD_ACTION")) {
            ScoutApp.addPlayer();
        } else if (action.equals("REMOVE_ACTION")) {
            ScoutApp.removePlayer();
        } else if (action.equals("PRINT_ACTION")) {
            ScoutApp.printList();
        } else if (action.equals("SAVE_ACTION")) {
            ScoutApp.saveList();
        } else if (action.equals("LOAD_ACTION")) {
            ScoutApp.loadList();
        } else if (action.equals("QUIT_ACTION")) {
            Scoutlist.printLog();
            frame.dispose();
        }
    }
}


