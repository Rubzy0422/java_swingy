package com.wtc.swingy.View.GUI;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.wtc.swingy.model.Champion;
import com.wtc.swingy.model.Level;

import java.awt.*;
import java.awt.event.*;

public class GUIView {
    private static JFrame frame;
    private static JTextField txtName;
    private static JTextPane textPane;
    private String chosenClass = "warrior";
    private static Champion Champ = null; 
    private static Level Map = null; 
    private static int plevel = 1;

    private static EntityManagerFactory factory;
    private javax.persistence.EntityManager em;

    private void ClearFrame() {
            if (frame == null) {
                frame = new JFrame();
                frame.setForeground(new Color(255, 255, 255));
                frame.getContentPane().setBackground(Color.BLACK);
                frame.setBounds(10, 10, 1024, 768);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().setLayout(new BorderLayout());
            }
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.getContentPane().removeAll();
            frame.repaint();
    }

    public ImageIcon scaleImage(ImageIcon icon, int w, int h)
    {
        int nw = icon.getIconWidth();
        int nh = icon.getIconHeight();

        if(icon.getIconWidth() > w)
        {
            nw = w;
            nh = (nw * icon.getIconHeight()) / icon.getIconWidth();
        }

        if(nh > h)
        {
            nh = h;
            nw = (icon.getIconWidth() * nh) / icon.getIconHeight();
        }

        return new ImageIcon(icon.getImage().getScaledInstance(nw, nh, Image.SCALE_DEFAULT));
    }


    public void initializeNew() {
        ClearFrame();
        // Init Looks

        // Create a Level
        JLabel label = new JLabel("Stats:");
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Tahoma", Font.BOLD, 15));

        textPane = new JTextPane();
        textPane.setForeground(Color.WHITE);
        textPane.setBackground(Color.DARK_GRAY);

        final JLabel HeroImg = new JLabel();
        HeroImg.setFont(new Font("Tahoma", Font.PLAIN, 40));
        HeroImg.setBackground(Color.BLACK);
        HeroImg.setText("Select Champion");

        JButton btnMainMenu = new JButton("Menu");
        btnMainMenu.setForeground(Color.WHITE);
        btnMainMenu.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnMainMenu.setBackground(Color.BLACK);

        final JButton btnPlay = new JButton("Play");
        btnPlay.setForeground(Color.WHITE);
        btnPlay.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnPlay.setBackground(Color.BLACK);
        btnPlay.setEnabled(false);

        JLabel lblName = new JLabel("Name:");
        lblName.setForeground(Color.WHITE);
        lblName.setFont(new Font("Tahoma", Font.BOLD, 15));

        txtName = new JTextField();
        txtName.setBackground(Color.DARK_GRAY);
        txtName.setForeground(Color.WHITE);
        txtName.setColumns(10);

        ImageIcon icon = scaleImage(new ImageIcon("src/main/resources/warrior.png"), 1024, 768);
        HeroImg.setIcon(icon);

        final JComboBox<String> comboBox = new JComboBox<String>();
        comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"warrior", "skeleton", "spearman"}));

        JLabel lblClass = new JLabel("Class:");
        lblClass.setForeground(Color.WHITE);
        lblClass.setFont(new Font("Tahoma", Font.BOLD, 15));


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
                                                                        .addComponent(label, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
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
                                                .addComponent(label, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
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
//        frmNew.setForeground(new Color(0, 0, 0));
//        frmNew.setBounds(10, 10, 1024, 768);
//        frmNew.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Map = new Level(plevel);
        // SAVE LEVEL // DONT PERSIST
        factory = Persistence.createEntityManagerFactory("puapi");
        em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(Map);


        Champ = new Champion(txtName.getText(), chosenClass, 1, 0, true, Map);
        textPane.setText(Champ.toString());

        // Controllers
        txtName.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    HeroImg.setText(txtName.getText());
                    btnPlay.setEnabled(!txtName.getText().isEmpty());
                    Champ.setName(txtName.getText());
                    textPane.setText(Champ.toString());
                }
            });
        btnMainMenu.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    initializeMain();
                    Champ = null;
                }
            });
            comboBox.addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {    
                    btnPlay.setEnabled(true);
                    try {
                        chosenClass = comboBox.getSelectedItem().toString().toLowerCase();
                        ImageIcon icon = scaleImage(new ImageIcon("src/main/resources/" + chosenClass + ".png"), 1024, 768);
                        HeroImg.setIcon(icon);
                        Champ.setChampionClass(chosenClass);
                        textPane.setText(Champ.toString());
                    }
                    catch (Exception ex){
                        System.out.println(ex);
                    }
                }
            });
            btnPlay.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    initializeGame(plevel);

                            // Don't Commit yet!
                        em.persist(Map);
                        em.persist(Champ);
                        em.getTransaction().commit();
                        em.close();
                        factory.close();

                   System.out.println(Champ);
                }
            });

        frame.setVisible(true);
    }

    public void initializeMain() {
        ClearFrame();
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        JLabel BackGroundImg = new JLabel();
        BackGroundImg.setFont(new Font("Tahoma", Font.PLAIN, 40));
        BackGroundImg.setBackground(Color.BLACK);
        try {
            ImageIcon icon = scaleImage(new ImageIcon("src/main/resources/MainMenu.png"), 2024, 1000);
            BackGroundImg.setIcon(icon);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(BackGroundImg, GroupLayout.DEFAULT_SIZE, 815, Short.MAX_VALUE)
                                .addGap(18)
                                .addComponent(panel, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addGap(11)
                                                .addComponent(BackGroundImg, GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE))
                                        .addComponent(panel, GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE))
                                .addContainerGap())
        );

        JButton btnLoadGame = new JButton("Load Game");
        btnLoadGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                initializeLoad();
//                System.out.println("LOAD GAME");
            }
        });
        btnLoadGame.setForeground(Color.WHITE);
        btnLoadGame.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnLoadGame.setBackground(Color.BLACK);

        JButton btnNewGame = new JButton("New Game");
        btnNewGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                initializeNew();
//                System.out.println("New GAME");
            }
        });
        btnNewGame.setForeground(Color.WHITE);
        btnNewGame.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewGame.setBackground(Color.BLACK);

        JButton btnExit = new JButton("Exit");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnExit.setForeground(Color.WHITE);
        btnExit.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnExit.setBackground(Color.BLACK);
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
                gl_panel.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_panel.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_panel.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(btnExit, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                        .addComponent(btnLoadGame, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                        .addComponent(btnNewGame, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                                .addContainerGap())
        );
        gl_panel.setVerticalGroup(
                gl_panel.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, gl_panel.createSequentialGroup()
                                .addContainerGap(329, Short.MAX_VALUE)
                                .addComponent(btnNewGame)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLoadGame)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExit)
                                .addGap(297))
        );
        panel.setLayout(gl_panel);

        frame.getContentPane().setLayout(groupLayout);
        frame.setVisible(true);
    }

    public void initializeLoad() {
        ClearFrame();

        JLabel label = new JLabel("Stats:");
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Tahoma", Font.BOLD, 15));

        JTextPane textPane = new JTextPane();
        textPane.setForeground(Color.WHITE);
        textPane.setBackground(Color.DARK_GRAY);

        final JLabel HeroImg = new JLabel();
        HeroImg.setFont(new Font("Tahoma", Font.PLAIN, 40));
        HeroImg.setBackground(Color.BLACK);
        HeroImg.setText("Select Champion");


        JButton btnMainMenu = new JButton("Menu");
        btnMainMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                initializeMain();
            }
        });
        btnMainMenu.setForeground(Color.WHITE);
        btnMainMenu.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnMainMenu.setBackground(Color.BLACK);

        final JButton btnPlay = new JButton("Play");
        btnPlay.setForeground(Color.WHITE);
        btnPlay.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnPlay.setEnabled(false);
        btnPlay.setBackground(Color.BLACK);
        btnPlay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                initializeGame(Map.getSize());
            }
        });

        JScrollPane scrollUsers = new JScrollPane();
        GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addGap(19)
                                                .addComponent(scrollUsers, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addGroup(groupLayout.createSequentialGroup()
                                                                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(label, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(textPane, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
                                                                .addGap(311)
                                                                .addComponent(HeroImg, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE))
                                                        .addGroup(groupLayout.createSequentialGroup()
                                                                .addComponent(btnMainMenu, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(btnPlay, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)))))
                                .addGap(30))
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(20)
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
                                .addGap(64))
        );


        JList<String> lstLoadGame = new JList<String>();
        lstLoadGame.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                btnPlay.setEnabled(true);
                try {
                    chosenClass = "skeleton";
                    ImageIcon icon = scaleImage(new ImageIcon("src/main/resources/" + chosenClass + ".png"), 1024, 768);
                    HeroImg.setIcon(icon);
                    HeroImg.setText("username");
                }
                catch (Exception ex){
                    System.out.println(ex);
                }
            }
        });
        lstLoadGame.setModel(new AbstractListModel<String>() {
            /**
             *
             */
            private static final long serialVersionUID = 1L;
            String[] values = new String[] {};
            public int getSize() {
                return values.length;
            }
            public String getElementAt(int index) {
                return values[index];
            }
        });
        lstLoadGame.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lstLoadGame.setForeground(Color.WHITE);
        lstLoadGame.setBackground(Color.DARK_GRAY);
        scrollUsers.setViewportView(lstLoadGame);

        frame.getContentPane().setLayout(groupLayout);
        frame.setVisible(true);

    }

    public void initializeGame(int lvlsize) {
        ClearFrame();
        // Create layout and add buttons to show restraints

        
        JPanel jPanel = new JPanel(new GridLayout(lvlsize, lvlsize));
        
        frame.setContentPane(jPanel);
        frame.pack();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

