/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wtc.swingy.view.GUI;

import com.wtc.swingy.controller.Controller;
import com.wtc.swingy.controller.GameController;
import com.wtc.swingy.model.Champion;
import com.wtc.swingy.model.Screens;
import com.wtc.swingy.view.ImageUtil;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import com.wtc.swingy.model.ChampionClass;
import com.wtc.swingy.model.Level;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
/**
 *
 * @author Ruben
 */
public class MainFrame extends javax.swing.JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    GamePanel gpnl;
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {    
//        INIT Components
        initComponents();
    }
    
    public void setView(Screens ViewName) {
//        Container cPane = this.getContentPane();
        switch (ViewName)
        {
            case MAIN: {
//                if (cPane != MainPanel)
                    this.setContentPane(MainPanel);
                break;
            }
            case NEW: {
                this.setContentPane(NewPanel);
                break;
            }
            case LOAD: {
                this.setContentPane(LoadPanel);
                break;
            }
            case GAME: {
                this.initializeGame();
                break;
            }
        }
        this.revalidate();
        this.repaint();
    }
    
    private void initializeGame() {
        if (gpnl == null)
        {
           gpnl = new GamePanel(GameController.level.getSize());
           this.setContentPane(gpnl);
        }
        this.UpdateGame(gpnl);
        gpnl.renderlabels();
    }
    
    private void UpdateGame(GamePanel gpnl) {
        int lblWidth = 100;
        int lblHeight = 100;
        
        if (gpnl.getWidth() > 0 && gpnl.getHeight() > 0)
        {
            lblWidth = gpnl.getWidth() / GameController.level.getSize();
            lblHeight = gpnl.getHeight() / GameController.level.getSize();
        }
        
        for (Champion Champ : GameController.level.getChampions()) {
            if (Champ.isUserGenerated())
            {
                if (!(GameController.prev_x == 0 && GameController.prev_y == 0))
                {
                    JLabel tmp1 = new JLabel();
                    gpnl.SetLabel(Champ.getPlayerx() - GameController.prev_x , Champ.getPlayery() + GameController.prev_y, tmp1);
                }
            }
                JLabel tmp = new JLabel();
                tmp.setIcon(
                    ImageUtil.scaleImage(
                            new ImageIcon("src/main/resources/" + Champ.getChampionClass() + ".png"),
                            lblWidth,
                            lblHeight
                    )
            );
                tmp.setToolTipText("A:" + Champ.getAttack() + " D:" + Champ.getDefence() + " HP:"+ Champ.getHitPoints() + " XP:"+ Champ.getExperience());
                gpnl.SetLabel(Champ.getPlayerx() , Champ.getPlayery(), tmp);
        }
        gpnl.renderlabels();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NewPanel = new javax.swing.JPanel();
        lblFormClass = new javax.swing.JLabel();
        lblFormName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        cbxChampClass = new javax.swing.JComboBox<ChampionClass>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtStats = new javax.swing.JTextArea();
        lblUserName = new javax.swing.JLabel();
        btnPlay = new javax.swing.JButton();
        btnMain = new javax.swing.JButton();
        ImgChamp = new javax.swing.JLabel();
        LoadPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstSavedGames = new javax.swing.JList<>();
        ImgChamp1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtStats1 = new javax.swing.JTextArea();
        btnMain1 = new javax.swing.JButton();
        btnPlay1 = new javax.swing.JButton();
        lblUserName1 = new javax.swing.JLabel();
        MainPanel = new javax.swing.JPanel();
        ImgMainMenu = new javax.swing.JLabel();
        PnlButtons = new javax.swing.JPanel();
        btnNewGame = new javax.swing.JButton();
        btnLoadGame = new javax.swing.JButton();
        btnSwitchUI = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        NewPanel.setBackground(new java.awt.Color(0, 0, 0));
        NewPanel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                NewPanelComponentResized(evt);
            }
        });

        lblFormClass.setBackground(new java.awt.Color(0, 0, 0));
        lblFormClass.setFont(new java.awt.Font("Calisto MT", 1, 18)); // NOI18N
        lblFormClass.setForeground(new java.awt.Color(255, 255, 255));
        lblFormClass.setText("Class");

        lblFormName.setBackground(new java.awt.Color(0, 0, 0));
        lblFormName.setFont(new java.awt.Font("Calisto MT", 1, 18)); // NOI18N
        lblFormName.setForeground(new java.awt.Color(255, 255, 255));
        lblFormName.setText("Name");

        txtName.setBackground(new java.awt.Color(102, 102, 102));
        txtName.setFont(new java.awt.Font("Calisto MT", 1, 18)); // NOI18N
        txtName.setForeground(new java.awt.Color(255, 255, 255));
        txtName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtNameMouseExited(evt);
            }
        });

        cbxChampClass.setBackground(new java.awt.Color(102, 102, 102));
        cbxChampClass.setFont(new java.awt.Font("Colonna MT", 1, 18)); // NOI18N
        cbxChampClass.setForeground(new java.awt.Color(255, 255, 255));
        cbxChampClass.setModel(
            new DefaultComboBoxModel<ChampionClass>(ChampionClass.values())
        );
        cbxChampClass.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxChampClassItemStateChanged(evt);
            }
        });

        txtStats.setBackground(new java.awt.Color(102, 102, 102));
        txtStats.setColumns(20);
        txtStats.setFont(new java.awt.Font("Calisto MT", 1, 18)); // NOI18N
        txtStats.setForeground(new java.awt.Color(255, 255, 255));
        txtStats.setRows(5);
        jScrollPane1.setViewportView(txtStats);

        lblUserName.setBackground(new java.awt.Color(0, 0, 0));
        lblUserName.setFont(new java.awt.Font("Calisto MT", 1, 24)); // NOI18N
        lblUserName.setForeground(new java.awt.Color(255, 255, 255));
        lblUserName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUserName.setText("Create a Champion");

        btnPlay.setBackground(new java.awt.Color(0, 0, 0));
        btnPlay.setForeground(new java.awt.Color(255, 255, 255));
        btnPlay.setText("Play");
        btnPlay.setEnabled(false);
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });

        btnMain.setBackground(new java.awt.Color(0, 0, 0));
        btnMain.setForeground(new java.awt.Color(255, 255, 255));
        btnMain.setText("Main");
        btnMain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMainActionPerformed(evt);
            }
        });

        ImgChamp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ImgChamp.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout NewPanelLayout = new javax.swing.GroupLayout(NewPanel);
        NewPanel.setLayout(NewPanelLayout);
        NewPanelLayout.setHorizontalGroup(
            NewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NewPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(NewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(NewPanelLayout.createSequentialGroup()
                        .addComponent(lblFormName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(NewPanelLayout.createSequentialGroup()
                        .addComponent(lblFormClass, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxChampClass, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(NewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUserName, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NewPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnMain, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ImgChamp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        NewPanelLayout.setVerticalGroup(
            NewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NewPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(NewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(NewPanelLayout.createSequentialGroup()
                        .addGroup(NewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFormName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(NewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFormClass, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxChampClass, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(65, 65, 65)
                .addGroup(NewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NewPanelLayout.createSequentialGroup()
                        .addComponent(ImgChamp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(NewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMain, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE))
                .addContainerGap())
        );

        LoadPanel.setBackground(new java.awt.Color(0, 0, 0));
        LoadPanel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                LoadPanelComponentResized(evt);
            }
        });

        jScrollPane2.setBackground(new java.awt.Color(102, 102, 102));
        jScrollPane2.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setFont(new java.awt.Font("Calisto MT", 1, 12)); // NOI18N

        lstSavedGames.setBackground(new java.awt.Color(102, 102, 102));
        lstSavedGames.setForeground(new java.awt.Color(255, 255, 255));
        lstSavedGames.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstSavedGames.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lstSavedGames.setSelectionBackground(new java.awt.Color(153, 255, 255));
        lstSavedGames.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstSavedGamesValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lstSavedGames);

        ImgChamp1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ImgChamp1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        txtStats1.setBackground(new java.awt.Color(102, 102, 102));
        txtStats1.setColumns(20);
        txtStats1.setFont(new java.awt.Font("Calisto MT", 1, 18)); // NOI18N
        txtStats1.setForeground(new java.awt.Color(255, 255, 255));
        txtStats1.setRows(5);
        jScrollPane3.setViewportView(txtStats1);

        btnMain1.setBackground(new java.awt.Color(0, 0, 0));
        btnMain1.setForeground(new java.awt.Color(255, 255, 255));
        btnMain1.setText("Main");
        btnMain1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMain1ActionPerformed(evt);
            }
        });

        btnPlay1.setBackground(new java.awt.Color(0, 0, 0));
        btnPlay1.setForeground(new java.awt.Color(255, 255, 255));
        btnPlay1.setText("Play");
        btnPlay1.setEnabled(false);
        btnPlay1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlay1ActionPerformed(evt);
            }
        });

        lblUserName1.setBackground(new java.awt.Color(0, 0, 0));
        lblUserName1.setFont(new java.awt.Font("Calisto MT", 1, 24)); // NOI18N
        lblUserName1.setForeground(new java.awt.Color(255, 255, 255));
        lblUserName1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUserName1.setText("Create a Champion");

        javax.swing.GroupLayout LoadPanelLayout = new javax.swing.GroupLayout(LoadPanel);
        LoadPanel.setLayout(LoadPanelLayout);
        LoadPanelLayout.setHorizontalGroup(
            LoadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoadPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LoadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(LoadPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(LoadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(LoadPanelLayout.createSequentialGroup()
                                .addComponent(ImgChamp1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(28, 28, 28))
                            .addComponent(lblUserName1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoadPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnMain1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPlay1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        LoadPanelLayout.setVerticalGroup(
            LoadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoadPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LoadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LoadPanelLayout.createSequentialGroup()
                        .addComponent(lblUserName1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ImgChamp1, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(LoadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPlay1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMain1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Swingy");
        setBackground(new java.awt.Color(0, 0, 0));

        MainPanel.setBackground(new java.awt.Color(0, 0, 0));
        MainPanel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                ResizeMainPnlImages(evt);
            }
        });

        ImgMainMenu.setAutoscrolls(true);
        ImgMainMenu.setIconTextGap(0);
        ImgMainMenu.setPreferredSize(new java.awt.Dimension(960, 440));

        PnlButtons.setBackground(new java.awt.Color(0, 0, 0));

        btnNewGame.setBackground(new java.awt.Color(0, 0, 0));
        btnNewGame.setForeground(new java.awt.Color(255, 255, 255));
        btnNewGame.setText("New Game");
        btnNewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewGameActionPerformed(evt);
            }
        });

        btnLoadGame.setBackground(new java.awt.Color(0, 0, 0));
        btnLoadGame.setForeground(new java.awt.Color(255, 255, 255));
        btnLoadGame.setText("Load Game");
        btnLoadGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadGameActionPerformed(evt);
            }
        });

        btnSwitchUI.setBackground(new java.awt.Color(0, 0, 0));
        btnSwitchUI.setForeground(new java.awt.Color(255, 255, 255));
        btnSwitchUI.setText("Switch UI");
        btnSwitchUI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSwitchUIActionPerformed(evt);
            }
        });

        btnExit.setBackground(new java.awt.Color(0, 0, 0));
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PnlButtonsLayout = new javax.swing.GroupLayout(PnlButtons);
        PnlButtons.setLayout(PnlButtonsLayout);
        PnlButtonsLayout.setHorizontalGroup(
            PnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlButtonsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnNewGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSwitchUI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLoadGame, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        PnlButtonsLayout.setVerticalGroup(
            PnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlButtonsLayout.createSequentialGroup()
                .addContainerGap(301, Short.MAX_VALUE)
                .addComponent(btnNewGame, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLoadGame, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSwitchUI, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addComponent(ImgMainMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 939, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PnlButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PnlButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ImgMainMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewGameActionPerformed
         GameController.initializeNew();
         txtStats.setText(GameController.Champ.toString());
    }//GEN-LAST:event_btnNewGameActionPerformed

    private void btnLoadGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadGameActionPerformed
        GameController.initializeLoad();
        // SET LOAD 
        DefaultListModel<String> model = new DefaultListModel<String>();
        for(Level lvl : GameController.levels){
            model.addElement(lvl.toString());
        }
        lstSavedGames.setModel(model);
    }//GEN-LAST:event_btnLoadGameActionPerformed

    private void btnSwitchUIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSwitchUIActionPerformed
        this.dispose();
        GameController.SwitchUI("MAIN");
    }//GEN-LAST:event_btnSwitchUIActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        GameController.Exit();
    }//GEN-LAST:event_btnExitActionPerformed

    private void ResizeMainPnlImages(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_ResizeMainPnlImages
//        System.out.println("RESIZE?");
    ImgMainMenu.setIcon(
                    ImageUtil.scaleImage(
                        new ImageIcon("src/main/resources/MainMenu.png"),
                        MainPanel.getWidth() - PnlButtons.getWidth(),
                        MainPanel.getHeight()
                    )
            );
    }//GEN-LAST:event_ResizeMainPnlImages

    private void NewPanelComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_NewPanelComponentResized
        ImgChamp.setIcon(
                ImageUtil.scaleImage(
                        new ImageIcon("src/main/resources/" + GameController.chosenClass.name() + ".png"),
                        NewPanel.getWidth() - txtStats.getWidth(),
                        MainPanel.getHeight() - (btnMain.getHeight() * 2) - lblUserName.getHeight()
                )
        );
    }//GEN-LAST:event_NewPanelComponentResized

    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
       GameController.initializeGame("NEW");
       this.addKeyListener(new Controller(){});
    }//GEN-LAST:event_btnPlayActionPerformed

    private void btnMainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMainActionPerformed
          GameController.initializeMain();
    }//GEN-LAST:event_btnMainActionPerformed

    private void txtNameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNameMouseExited
        if (!txtName.getText().isBlank())
        {
            if (!txtName.getText().equals(GameController.Champ.getName()))
            {
                lblUserName.setText(GameController.PlayerNameUpdate(txtName.getText()));
                btnPlay.setEnabled(GameController.ValidateStart());
                txtStats.setText(GameController.Champ.toString());
            }
        }
        
    }//GEN-LAST:event_txtNameMouseExited

    private void cbxChampClassItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxChampClassItemStateChanged
        GameController.chosenClass = (ChampionClass) cbxChampClass.getSelectedItem();
        GameController.Champ.setChampionClass(GameController.chosenClass);
        NewPanelComponentResized(null);
        txtStats.setText(GameController.Champ.toString());
    }//GEN-LAST:event_cbxChampClassItemStateChanged

    private void btnMain1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMain1ActionPerformed
 
        lstSavedGames.setSelectedIndex(-1);
        ImgChamp1.setIcon(null);
        lblUserName1.setText("Choose a Champion");
        GameController.initializeMain();
    }//GEN-LAST:event_btnMain1ActionPerformed

    private void btnPlay1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlay1ActionPerformed
        GameController.initializeGame("OLD");
        this.addKeyListener(new Controller(){});
    }//GEN-LAST:event_btnPlay1ActionPerformed

    private void LoadPanelComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_LoadPanelComponentResized
        if (GameController.chosenClass != null && !GameController.chosenClass.name().isBlank())
        {
            ImgChamp1.setIcon(
                ImageUtil.scaleImage(
                        new ImageIcon("src/main/resources/" + GameController.chosenClass.name() + ".png"),
                        LoadPanel.getWidth() - txtStats1.getWidth(),
                        LoadPanel.getHeight() - (btnMain1.getHeight() + lblUserName.getHeight() + lstSavedGames.getHeight())
                )
            );
            lblUserName1.setText(GameController.Champ.getName());
        }
       
    }//GEN-LAST:event_LoadPanelComponentResized

    private void lstSavedGamesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstSavedGamesValueChanged
        txtStats1.setText(GameController.LoadGame(lstSavedGames.getSelectedIndex()));
        LoadPanelComponentResized(null);
        btnPlay1.setEnabled(GameController.ValidateStart());
                
    }//GEN-LAST:event_lstSavedGamesValueChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ImgChamp;
    private javax.swing.JLabel ImgChamp1;
    private javax.swing.JLabel ImgMainMenu;
    private javax.swing.JPanel LoadPanel;
    public javax.swing.JPanel MainPanel;
    private javax.swing.JPanel NewPanel;
    private javax.swing.JPanel PnlButtons;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLoadGame;
    private javax.swing.JButton btnMain;
    private javax.swing.JButton btnMain1;
    private javax.swing.JButton btnNewGame;
    private javax.swing.JButton btnPlay;
    private javax.swing.JButton btnPlay1;
    private javax.swing.JButton btnSwitchUI;
    private javax.swing.JComboBox<ChampionClass> cbxChampClass;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblFormClass;
    private javax.swing.JLabel lblFormName;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JLabel lblUserName1;
    private javax.swing.JList<String> lstSavedGames;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextArea txtStats;
    private javax.swing.JTextArea txtStats1;
    // End of variables declaration//GEN-END:variables

}
