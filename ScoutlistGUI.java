package ui;

import model.Player;
import model.Scoutlist;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ScoutlistGUI extends JFrame implements ActionListener {
    private DefaultTableModel tableModel;
    private JTable table;
    private Scoutlist scoutlist;

    public ScoutlistGUI(Scoutlist read) {
        this.scoutlist = read;
        final String[] columnLabels = new String[]{
                "Index",
                "Name",
                "Age",
                "Hometeam",
                "Position",
                "Rating",
                "Foot",
                "Status"
        };

        tableModel = new DefaultTableModel(null, columnLabels) {
        };
        table = new JTable(tableModel);
        this.populateTableRows();

        add(new JScrollPane(table));
        setTitle("scout list");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private void populateTableRows() {
        for (int i = 0; i < scoutlist.getList().size(); i++) {
            Player player = scoutlist.getPlayers().get(i);
            Object[] tableRow = new Object[]{
                    i,
                    player.getName(),
                    player.getAge(),
                    player.getHometeam(),
                    player.getPosition(),
                    player.getRating(),
                    player.getFoot(),
                    player.getStatus(),
            };
            tableModel.addRow(tableRow);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
