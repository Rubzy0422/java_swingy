package com.wtc.swingy.View.GUI;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.wtc.swingy.controller.Controller;
import com.wtc.swingy.controller.GameController;
import com.wtc.swingy.model.Champion;
import com.wtc.swingy.model.ChampionClass;
import com.wtc.swingy.model.Level;

import java.awt.*;
import java.awt.event.*;

public final class GUIView {
    private static JFrame frame;
    private static JPanel jPanel;
    private static JTextPane textPane;
    private static JTextField txtName;

    private static void ClearFrame() {
        if (frame == null) {
            frame = new JFrame();
            frame.setForeground(Color.WHITE);
            frame.getContentPane().setBackground(Color.BLACK);
            frame.addKeyListener(new Controller(){});
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.getContentPane().removeAll();
        frame.repaint();
        jPanel = new JPanel();
    }

    public static ImageIcon scaleImage(final ImageIcon icon, final int w, final int h) {
        int nw = icon.getIconWidth();
        int nh = icon.getIconHeight();

        if (icon.getIconWidth() > w) {
            nw = w;
            nh = (nw * icon.getIconHeight()) / icon.getIconWidth();
        }

        if (nh > h) {
            nh = h;
            nw = (icon.getIconWidth() * nh) / icon.getIconHeight();
        }

        return new ImageIcon(icon.getImage().getScaledInstance(nw, nh, Image.SCALE_DEFAULT));
    }

    public static void initializeNew() {
        ClearFrame();

        final JLabel lblStats = new JLabel("Stats:");
        lblStats.setForeground(Color.WHITE);
        lblStats.setFont(new Font("Tahoma", Font.BOLD, 15));

        textPane = new JTextPane();
        textPane.setForeground(Color.WHITE);
        textPane.setBackground(Color.DARK_GRAY);

        // HeroImage
        final JLabel HeroImg = new JLabel();
        HeroImg.setFont(new Font("Tahoma", Font.PLAIN, 40));
        HeroImg.setBackground(Color.BLACK);
        HeroImg.setText("Select Champion");
        final ImageIcon icon = scaleImage(new ImageIcon("src/main/resources/" + GameController.chosenClass.name() + ".png"), 1024, 768);
        HeroImg.setIcon(icon);

        // Menu Button
        final JButton btnMainMenu = new JButton("Menu");
        btnMainMenu.setForeground(Color.WHITE);
        btnMainMenu.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnMainMenu.setBackground(Color.BLACK);

        // Play Button
        final JButton btnPlay = new JButton("Play");
        btnPlay.setForeground(Color.WHITE);
        btnPlay.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnPlay.setBackground(Color.BLACK);
        btnPlay.setEnabled(false);

        // NAME INPUT
        // Name Label
        final JLabel lblName = new JLabel("Name:");
        lblName.setForeground(Color.WHITE);
        lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
        // Name TEXT
        txtName = new JTextField();
        txtName.setBackground(Color.DARK_GRAY);
        txtName.setForeground(Color.WHITE);
        txtName.setColumns(10);

        // CLASS INPUT
        // Class Label
        final JLabel lblClass = new JLabel("Class:");
        lblClass.setForeground(Color.WHITE);
        lblClass.setFont(new Font("Tahoma", Font.BOLD, 15));

        // Class ComboBox
        final JComboBox<ChampionClass> comboBox = new JComboBox<ChampionClass>();
        comboBox.setModel(new DefaultComboBoxModel<ChampionClass>(ChampionClass.values()));


        GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addGroup(groupLayout.createSequentialGroup()
                                                                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(lblStats, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(textPane, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
                                                                .addGap(311)
                                                                .addComponent(HeroImg, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE))
                                                        .addGroup(groupLayout.createSequentialGroup()
                                                                .addComponent(btnMainMenu, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(btnPlay, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(30))
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblName, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblClass, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtName, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap(602, Short.MAX_VALUE))))
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(27)
                                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblName, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblClass, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(104)
                                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addComponent(lblStats, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                                                .addGap(6)
                                                .addComponent(textPane, GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE))
                                        .addComponent(HeroImg, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE))
                                .addGap(18)
                                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnPlay, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnMainMenu, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
                                .addGap(64))
        );

        frame.getContentPane().setLayout(groupLayout);


        // Initial Text 
        textPane.setText(GameController.Champ.toString());


        // Controllers
        txtName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(final KeyEvent e) {
                HeroImg.setText(GameController.PlayerNameUpdate(txtName.getText()));
                btnPlay.setEnabled(GameController.ValidateStart());
                textPane.setText(GameController.Champ.toString());
            }
        });
    
        btnMainMenu.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                GameController.initializeMain();
            }
        });

        comboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(final ItemEvent e) {
                try {
                    GameController.chosenClass = (ChampionClass)comboBox.getSelectedItem();
                    final ImageIcon icon = scaleImage(new ImageIcon("src/main/resources/" + GameController.chosenClass.name() + ".png"), 1024, 768);
                    HeroImg.setIcon(icon);
                    System.out.println(GameController.chosenClass);
                    GameController.Champ.setChampionClass(GameController.chosenClass);
                    textPane.setText(GameController.Champ.toString());
                } catch (final Exception ex) {
                    System.out.println(ex);
                }
            }
        });
        
        btnPlay.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                GameController.initializeGame("NEW");
            }
        });
        
        frame.setVisible(true);
    }

    public static void initializeMain() {
        ClearFrame();
       
        final JLabel BackGroundImg = new JLabel();
        BackGroundImg.setFont(new Font("Tahoma", Font.PLAIN, 40));
        BackGroundImg.setBackground(Color.BLACK);

        try {
            final ImageIcon icon = scaleImage(new ImageIcon("src/main/resources/MainMenu.png"), 2024, 1000);
            BackGroundImg.setIcon(icon);
        } catch (final Exception ex) {
            System.out.println(ex);
        }

        final JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
       
       
        final JButton btnLoadGame = new JButton("Load Game");
        btnLoadGame.setForeground(Color.WHITE);
        btnLoadGame.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnLoadGame.setBackground(Color.BLACK);


        final JButton btnNewGame = new JButton("New Game");
        btnNewGame.setForeground(Color.WHITE);
        btnNewGame.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewGame.setBackground(Color.BLACK);


        final JButton btnExit = new JButton("Exit");
        btnExit.setForeground(Color.WHITE);
        btnExit.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnExit.setBackground(Color.BLACK);

        final GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
        groupLayout
                .setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup().addContainerGap()
                                .addComponent(BackGroundImg, GroupLayout.DEFAULT_SIZE, 815, Short.MAX_VALUE).addGap(18)
                                .addComponent(panel, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addGroup(groupLayout.createSequentialGroup()
                        .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(groupLayout.createSequentialGroup().addGap(11).addComponent(BackGroundImg,
                                        GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE))
                                .addComponent(panel, GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE))
                        .addContainerGap()));
        final GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(gl_panel.createSequentialGroup().addContainerGap()
                        .addGroup(gl_panel.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(btnExit, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                .addComponent(btnLoadGame, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                .addComponent(btnNewGame, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 117,
                                        Short.MAX_VALUE))
                        .addContainerGap()));
        gl_panel.setVerticalGroup(gl_panel.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
                GroupLayout.Alignment.TRAILING,
                gl_panel.createSequentialGroup().addContainerGap(329, Short.MAX_VALUE).addComponent(btnNewGame)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(btnLoadGame)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(btnExit).addGap(297)));
        panel.setLayout(gl_panel);

        frame.getContentPane().setLayout(groupLayout);
        frame.setVisible(true);  
        

        //  ========================================= CONTROLLER Linkers ==============================================================================
        btnLoadGame.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                GameController.initializeLoad();
            }
        });

        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                GameController.Exit();
            }
        });

        btnNewGame.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                GameController.initializeNew();
            }
        });
    }


    public static void initializeLoad() {
        ClearFrame();

        final JLabel label = new JLabel("Stats:");
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Tahoma", Font.BOLD, 15));

        final JTextPane textPane = new JTextPane();
        textPane.setForeground(Color.WHITE);
        textPane.setBackground(Color.DARK_GRAY);

        final JLabel HeroImg = new JLabel();
        HeroImg.setFont(new Font("Tahoma", Font.PLAIN, 40));
        HeroImg.setBackground(Color.BLACK);
        HeroImg.setText("Select Champion");

        final JButton btnMainMenu = new JButton("Menu");
        btnMainMenu.setForeground(Color.WHITE);
        btnMainMenu.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnMainMenu.setBackground(Color.BLACK);

        final JButton btnPlay = new JButton("Play");
        btnPlay.setForeground(Color.WHITE);
        btnPlay.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnPlay.setEnabled(false);
        btnPlay.setBackground(Color.BLACK);
       
        final JScrollPane scrollUsers = new JScrollPane();
        final GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout
                        .createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup().addGap(19).addComponent(scrollUsers,
                                GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout
                                .createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(groupLayout.createSequentialGroup()
                                        .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(label, GroupLayout.PREFERRED_SIZE, 156,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textPane, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
                                        .addGap(311)
                                        .addComponent(HeroImg, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE))
                                .addGroup(groupLayout.createSequentialGroup()
                                        .addComponent(btnMainMenu, GroupLayout.PREFERRED_SIZE, 103,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(btnPlay,
                                                GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)))))
                        .addGap(30)));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addGroup(groupLayout.createSequentialGroup().addGap(20)
                        .addComponent(scrollUsers, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
                        .addGap(42)
                        .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(groupLayout.createSequentialGroup()
                                        .addComponent(label, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                                        .addGap(6)
                                        .addComponent(textPane, GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE))
                                .addComponent(HeroImg, GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE))
                        .addGap(18)
                        .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(btnPlay, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnMainMenu, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
                        .addGap(64)));

        final JList<String> lstLoadGame = new JList<String>();
        lstLoadGame.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(final ListSelectionEvent e) {
                System.out.println("CHANGE!");
            }
        });
        lstLoadGame.setModel(new AbstractListModel<String>() {
            /**
             *
             */
            private static final long serialVersionUID = 1L;
            String[] values = new String[] {" a" , "b", "c"};

            public int getSize() {
                return values.length;
            }

            public String getElementAt(final int index) {
                return values[index];
            }
        });
        lstLoadGame.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lstLoadGame.setForeground(Color.WHITE);
        lstLoadGame.setBackground(Color.DARK_GRAY);
        scrollUsers.setViewportView(lstLoadGame);

        frame.getContentPane().setLayout(groupLayout);
        frame.setVisible(true);

        //============================================================== CONTROLLER LINKERS =====================================================
        btnMainMenu.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                initializeMain();
            }
        });
        btnPlay.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                GameController.initializeGame("Load");
            }
        });
    }

    public static void initializeGame() {
        ClearFrame();
        updateMap(GameController.level);
    }

    public static void updateMap(final Level Map) {
        ClearFrame();
        jPanel.setLayout(new GridLayout(GameController.level.getSize(), GameController.level.getSize()));
        jPanel.setBackground(Color.BLACK);
        for (int y = 0; y < Map.getSize(); y++)
            for (int x = 0; x < Map.getSize(); x++) {
                boolean set = false;
                final JLabel tmp = new JLabel();
                for (final Champion Champ : Map.getChampions()) {
                    if (Champ.getPlayerx() == x && Champ.getPlayery() == y) {
                        final ImageIcon icon = scaleImage(
                                new ImageIcon("src/main/resources/" + Champ.getChampionClass() + ".png"), 100, 100);
                        tmp.setIcon(icon);
                        tmp.setText("");
                        set = true;
                        break;
                    }

                }
                if (!set) {
                    final ImageIcon icon = scaleImage(new ImageIcon("src/main/resources/Empty.png"),100, 100);
                    tmp.setIcon(icon);
                    tmp.setText("");
                }
                jPanel.add(tmp);
            }
     
        frame.add(jPanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        frame.requestFocus();
    }
}