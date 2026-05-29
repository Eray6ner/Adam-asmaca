package adamasmaca;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class AdamAsmacaForm extends JFrame {
    private final String mainFolder = "C:\\P2Oyun";
    private final String imageFolder = mainFolder + "\\Resimler";
    private final String textFolder = mainFolder + "\\TXTDosyalar";
    private final String wordFile = textFolder + "\\kelimeler.txt";
    private final String passwordFile = textFolder + "\\sifre.txt";
    private final String logFile = textFolder + "\\log.txt";
    private final String gameFile = textFolder + "\\oyunlar.txt";
    private final String[] alphabet = {
        "A", "B", "C", "\u00c7", "D", "E", "F", "G", "\u011e", "H",
        "I", "\u0130", "J", "K", "L", "M", "N", "O", "\u00d6", "P",
        "Q", "R", "S", "\u015e", "T", "U", "\u00dc", "V", "W", "X",
        "Y", "Z"
    };
    private ArrayList<String> words = new ArrayList<>();
    private ArrayList<String> guesses = new ArrayList<>();
    private ArrayList<JLabel> wordBoxes = new ArrayList<>();
    private String selectedWord = "";
    private String[] wordLetters, visibleLetters;
    private int wrongCount = 0, seconds = 0;
    private boolean gameActive = false;
    private boolean darkMode = true;
    private javax.swing.Timer timer;
    private Random random = new Random();
    private Locale turkish = Locale.forLanguageTag("tr-TR");
    private DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public AdamAsmacaForm() {
        initComponents();
        setupTheme();
        getContentPane().setComponentZOrder(buttonTheme, 0);
        setLocationRelativeTo(null);
        prepareFiles();
        writeLog("PROGRAM_ACILDI", "Uygulama baslatildi");
        if (!checkPassword()) {
            System.exit(0);
        }
        showWelcomeMessage();
        setGuessAreaEnabled(false);
        readWords();
        refreshTables();
    }
    public static void main(String[] args) {
        new AdamAsmacaForm().setVisible(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabs = new javax.swing.JTabbedPane();
        panelGameTab = new javax.swing.JPanel();
        panelTop = new javax.swing.JPanel();
        panelInfo = new javax.swing.JPanel();
        labelTime = new javax.swing.JLabel();
        labelWrong = new javax.swing.JLabel();
        labelStatus = new javax.swing.JLabel();
        labelGuesses = new javax.swing.JLabel();
        panelMiddle = new javax.swing.JPanel();
        panelGuessSide = new javax.swing.JPanel();
        panelWord = new javax.swing.JPanel();
        panelGuess = new javax.swing.JPanel();
        labelLetterGuess = new javax.swing.JLabel();
        textLetter = new javax.swing.JTextField();
        labelWordGuess = new javax.swing.JLabel();
        textWord = new javax.swing.JTextField();
        buttonLetter = new javax.swing.JButton();
        buttonWord = new javax.swing.JButton();
        panelImageSide = new javax.swing.JPanel();
        labelImage = new javax.swing.JLabel();
        panelGameButtons = new javax.swing.JPanel();
        buttonStart = new javax.swing.JButton();
        buttonRestart = new javax.swing.JButton();
        panelScoreTab = new javax.swing.JPanel();
        scrollScores = new javax.swing.JScrollPane();
        tableScores = new javax.swing.JTable();
        panelScoreButtons = new javax.swing.JPanel();
        buttonScoreRefresh = new javax.swing.JButton();
        buttonScoreClear = new javax.swing.JButton();
        panelLogTab = new javax.swing.JPanel();
        scrollLogs = new javax.swing.JScrollPane();
        tableLogs = new javax.swing.JTable();
        panelLogButtons = new javax.swing.JPanel();
        buttonLogRefresh = new javax.swing.JButton();
        buttonLogClear = new javax.swing.JButton();
        buttonTheme = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        menuGame = new javax.swing.JMenu();
        itemStart = new javax.swing.JMenuItem();
        itemRestart = new javax.swing.JMenuItem();
        menuSeparator = new javax.swing.JPopupMenu.Separator();
        itemExit = new javax.swing.JMenuItem();
        menuRecords = new javax.swing.JMenu();
        itemRefreshTables = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Adam Asmaca");
        setPreferredSize(new java.awt.Dimension(900, 650));

        labelTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTime.setText("Sure: 0 sn");

        labelWrong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelWrong.setText("Yanlis: 0 / 11");

        labelStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelStatus.setText("Oyuna baslamak icin butona tiklayiniz.");

        javax.swing.GroupLayout panelInfoLayout = new javax.swing.GroupLayout(panelInfo);
        panelInfo.setLayout(panelInfoLayout);
        panelInfoLayout.setHorizontalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoLayout.createSequentialGroup()
                .addComponent(labelTime, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(labelWrong, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(labelStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE))
        );
        panelInfoLayout.setVerticalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelTime, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
            .addComponent(labelWrong, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
            .addComponent(labelStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        labelGuesses.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelGuesses.setText("Tahmin edilen harfler: -");

        javax.swing.GroupLayout panelTopLayout = new javax.swing.GroupLayout(panelTop);
        panelTop.setLayout(panelTopLayout);
        panelTopLayout.setHorizontalGroup(
            panelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labelGuesses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelTopLayout.setVerticalGroup(
            panelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTopLayout.createSequentialGroup()
                .addComponent(panelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(labelGuesses, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout panelWordLayout = new javax.swing.GroupLayout(panelWord);
        panelWord.setLayout(panelWordLayout);
        panelWordLayout.setHorizontalGroup(
            panelWordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 349, Short.MAX_VALUE)
        );
        panelWordLayout.setVerticalGroup(
            panelWordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 146, Short.MAX_VALUE)
        );

        labelLetterGuess.setText("Harf Tahmini:");

        textLetter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textLetterActionPerformed(evt);
            }
        });

        labelWordGuess.setText("Kelime Tahmini:");

        textWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textWordActionPerformed(evt);
            }
        });

        buttonLetter.setText("Harf Tahmin Et");
        buttonLetter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLetterActionPerformed(evt);
            }
        });

        buttonWord.setText("Kelime Tahmin Et");
        buttonWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonWordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelGuessLayout = new javax.swing.GroupLayout(panelGuess);
        panelGuess.setLayout(panelGuessLayout);
        panelGuessLayout.setHorizontalGroup(
            panelGuessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGuessLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelGuessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelLetterGuess, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textLetter)
                    .addComponent(buttonLetter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelWordGuess, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textWord)
                    .addComponent(buttonWord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelGuessLayout.setVerticalGroup(
            panelGuessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGuessLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelLetterGuess)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textLetter, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonLetter, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelWordGuess)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textWord, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonWord, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelGuessSideLayout = new javax.swing.GroupLayout(panelGuessSide);
        panelGuessSide.setLayout(panelGuessSideLayout);
        panelGuessSideLayout.setHorizontalGroup(
            panelGuessSideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelWord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelGuess, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelGuessSideLayout.setVerticalGroup(
            panelGuessSideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGuessSideLayout.createSequentialGroup()
                .addComponent(panelWord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelGuess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        labelImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelImage.setText("Ilk yanlis tahminde 1.jpg gosterilecek");

        buttonStart.setText("Oyuna Basla");
        buttonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStartActionPerformed(evt);
            }
        });

        buttonRestart.setText("Yeniden Baslat");
        buttonRestart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRestartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelGameButtonsLayout = new javax.swing.GroupLayout(panelGameButtons);
        panelGameButtons.setLayout(panelGameButtonsLayout);
        panelGameButtonsLayout.setHorizontalGroup(
            panelGameButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGameButtonsLayout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addComponent(buttonStart, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonRestart, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );
        panelGameButtonsLayout.setVerticalGroup(
            panelGameButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGameButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(buttonStart)
                .addComponent(buttonRestart))
        );

        javax.swing.GroupLayout panelImageSideLayout = new javax.swing.GroupLayout(panelImageSide);
        panelImageSide.setLayout(panelImageSideLayout);
        panelImageSideLayout.setHorizontalGroup(
            panelImageSideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelGameButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelImageSideLayout.setVerticalGroup(
            panelImageSideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImageSideLayout.createSequentialGroup()
                .addComponent(labelImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelGameButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout panelMiddleLayout = new javax.swing.GroupLayout(panelMiddle);
        panelMiddle.setLayout(panelMiddleLayout);
        panelMiddleLayout.setHorizontalGroup(
            panelMiddleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMiddleLayout.createSequentialGroup()
                .addComponent(panelImageSide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelGuessSide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelMiddleLayout.setVerticalGroup(
            panelMiddleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelImageSide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelGuessSide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelGameTabLayout = new javax.swing.GroupLayout(panelGameTab);
        panelGameTab.setLayout(panelGameTabLayout);
        panelGameTabLayout.setHorizontalGroup(
            panelGameTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGameTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelGameTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelMiddle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelGameTabLayout.setVerticalGroup(
            panelGameTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGameTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelMiddle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabs.addTab("Oyun Oynama", panelGameTab);

        tableScores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tarih", "Sure", "Sonuc", "Kelime"
            }
        ));
        scrollScores.setViewportView(tableScores);

        buttonScoreRefresh.setText("Yenile");
        buttonScoreRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonScoreRefreshActionPerformed(evt);
            }
        });

        buttonScoreClear.setText("Temizle");
        buttonScoreClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonScoreClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelScoreButtonsLayout = new javax.swing.GroupLayout(panelScoreButtons);
        panelScoreButtons.setLayout(panelScoreButtonsLayout);
        panelScoreButtonsLayout.setHorizontalGroup(
            panelScoreButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelScoreButtonsLayout.createSequentialGroup()
                .addContainerGap(258, Short.MAX_VALUE)
                .addComponent(buttonScoreRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonScoreClear, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(257, Short.MAX_VALUE))
        );
        panelScoreButtonsLayout.setVerticalGroup(
            panelScoreButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelScoreButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(buttonScoreRefresh)
                .addComponent(buttonScoreClear))
        );

        javax.swing.GroupLayout panelScoreTabLayout = new javax.swing.GroupLayout(panelScoreTab);
        panelScoreTab.setLayout(panelScoreTabLayout);
        panelScoreTabLayout.setHorizontalGroup(
            panelScoreTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelScoreTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelScoreTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollScores)
                    .addComponent(panelScoreButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelScoreTabLayout.setVerticalGroup(
            panelScoreTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelScoreTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollScores, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelScoreButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabs.addTab("Eski Skorlar", panelScoreTab);

        tableLogs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tarih", "Etiket", "Aciklama"
            }
        ));
        scrollLogs.setViewportView(tableLogs);

        buttonLogRefresh.setText("Yenile");
        buttonLogRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLogRefreshActionPerformed(evt);
            }
        });

        buttonLogClear.setText("Temizle");
        buttonLogClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLogClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLogButtonsLayout = new javax.swing.GroupLayout(panelLogButtons);
        panelLogButtons.setLayout(panelLogButtonsLayout);
        panelLogButtonsLayout.setHorizontalGroup(
            panelLogButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLogButtonsLayout.createSequentialGroup()
                .addContainerGap(258, Short.MAX_VALUE)
                .addComponent(buttonLogRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonLogClear, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(257, Short.MAX_VALUE))
        );
        panelLogButtonsLayout.setVerticalGroup(
            panelLogButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLogButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(buttonLogRefresh)
                .addComponent(buttonLogClear))
        );

        javax.swing.GroupLayout panelLogTabLayout = new javax.swing.GroupLayout(panelLogTab);
        panelLogTab.setLayout(panelLogTabLayout);
        panelLogTabLayout.setHorizontalGroup(
            panelLogTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLogTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLogTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollLogs)
                    .addComponent(panelLogButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelLogTabLayout.setVerticalGroup(
            panelLogTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLogTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollLogs, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelLogButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabs.addTab("Loglar", panelLogTab);

        buttonTheme.setText("Aydinlik Mod");
        buttonTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonThemeActionPerformed(evt);
            }
        });

        menuGame.setText("Oyun");

        itemStart.setText("Oyuna Basla");
        itemStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemStartActionPerformed(evt);
            }
        });
        menuGame.add(itemStart);

        itemRestart.setText("Oyunu Yeniden Baslat");
        itemRestart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRestartActionPerformed(evt);
            }
        });
        menuGame.add(itemRestart);
        menuGame.add(menuSeparator);

        itemExit.setText("Cikis");
        itemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemExitActionPerformed(evt);
            }
        });
        menuGame.add(itemExit);

        menuBar.add(menuGame);

        menuRecords.setText("Kayitlar");

        itemRefreshTables.setText("Tablolari Yenile");
        itemRefreshTables.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRefreshTablesActionPerformed(evt);
            }
        });
        menuRecords.add(itemRefreshTables);

        menuBar.add(menuRecords);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabs)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonTheme)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabs)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonTheme))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void buttonStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStartActionPerformed
        startGame();
    }//GEN-LAST:event_buttonStartActionPerformed
    private void buttonRestartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRestartActionPerformed
        startGame();
    }//GEN-LAST:event_buttonRestartActionPerformed
    private void buttonThemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonThemeActionPerformed
        darkMode = !darkMode;
        setupTheme();
        repaint();
    }//GEN-LAST:event_buttonThemeActionPerformed
    private void buttonLetterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLetterActionPerformed
        guessLetter();
    }//GEN-LAST:event_buttonLetterActionPerformed
    private void buttonWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonWordActionPerformed
        guessWord();
    }//GEN-LAST:event_buttonWordActionPerformed
    private void textLetterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textLetterActionPerformed
        guessLetter();
    }//GEN-LAST:event_textLetterActionPerformed
    private void textWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textWordActionPerformed
        guessWord();
    }//GEN-LAST:event_textWordActionPerformed
    private void buttonScoreRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonScoreRefreshActionPerformed
        refreshTables();
    }//GEN-LAST:event_buttonScoreRefreshActionPerformed
    private void buttonScoreClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonScoreClearActionPerformed
        clearFile(gameFile, "oyunlar.txt");
    }//GEN-LAST:event_buttonScoreClearActionPerformed
    private void buttonLogRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLogRefreshActionPerformed
        refreshTables();
    }//GEN-LAST:event_buttonLogRefreshActionPerformed
    private void buttonLogClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLogClearActionPerformed
        clearFile(logFile, "log.txt");
    }//GEN-LAST:event_buttonLogClearActionPerformed
    private void itemStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemStartActionPerformed
        startGame();
    }//GEN-LAST:event_itemStartActionPerformed
    private void itemRestartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRestartActionPerformed
        startGame();
    }//GEN-LAST:event_itemRestartActionPerformed
    private void itemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemExitActionPerformed
        writeLog("PROGRAM_KAPANDI", "Menuden cikis yapildi");
        System.exit(0);
    }//GEN-LAST:event_itemExitActionPerformed
    private void itemRefreshTablesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRefreshTablesActionPerformed
        refreshTables();
    }//GEN-LAST:event_itemRefreshTablesActionPerformed
    private void showWelcomeMessage() {
        JOptionPane.showMessageDialog(this,
                "Adam Asmaca Oyununa Hos Geldiniz\n"
                + "Oyuna Basla butonu ile yeni oyun baslatilir.\n"
                + "11 yanlis tahmin hakkiniz vardir.\n"
                + "Harf tahmini icin kutuya tek harf yazabilirsiniz.\n"
                + "Kelime tahmini alanindan kelimenin tamamini deneyebilirsiniz.\n"
                + "Skorlar ve loglar sekmelerden goruntulenebilir.",
                "Oyun Bilgilendirme", JOptionPane.INFORMATION_MESSAGE);
    }
    private void setupTheme() {
        Color backgroundColor = darkMode ? new Color(15, 23, 42) : new Color(238, 238, 238);
        Color cardColor = darkMode ? new Color(30, 41, 59) : Color.WHITE;
        Color secondCardColor = darkMode ? new Color(51, 65, 85) : new Color(230, 240, 255);
        Color textColor = darkMode ? new Color(226, 232, 240) : new Color(20, 20, 20);
        Color mutedTextColor = darkMode ? new Color(203, 213, 225) : new Color(60, 60, 60);
        Color borderColor = darkMode ? new Color(71, 85, 105) : new Color(180, 180, 180);
        Color fieldColor = darkMode ? new Color(15, 23, 42) : Color.WHITE;
        Color blue = darkMode ? new Color(37, 99, 235) : new Color(70, 130, 180);
        Color green = darkMode ? new Color(22, 163, 74) : new Color(80, 150, 90);
        Color red = darkMode ? new Color(220, 38, 38) : new Color(180, 70, 70);

        getContentPane().setBackground(backgroundColor);
        tabs.setBackground(cardColor);
        tabs.setForeground(textColor);
        tabs.setFont(new Font("Segoe UI", Font.BOLD, 12));
        tabs.setUI(new DarkTabUI(
                darkMode ? new Color(37, 99, 235) : new Color(210, 225, 245),
                darkMode ? new Color(30, 41, 59) : new Color(245, 245, 245),
                darkMode ? new Color(147, 197, 253) : new Color(120, 150, 190),
                darkMode ? Color.WHITE : Color.BLACK));
        panelGameTab.setBackground(backgroundColor);
        panelScoreTab.setBackground(backgroundColor);
        panelLogTab.setBackground(backgroundColor);
        panelTop.setBackground(backgroundColor);
        panelMiddle.setBackground(backgroundColor);
        menuBar.setBackground(cardColor);
        menuGame.setForeground(textColor);
        menuRecords.setForeground(textColor);

        makeCard(panelInfo, secondCardColor, borderColor);
        makeCard(panelGuessSide, cardColor, borderColor);
        makeCard(panelImageSide, cardColor, borderColor);
        makeCard(panelWord, secondCardColor, borderColor);
        makeCard(panelGuess, cardColor, borderColor);
        makeCard(panelGameButtons, backgroundColor, borderColor);
        makeCard(panelScoreButtons, backgroundColor, borderColor);
        makeCard(panelLogButtons, backgroundColor, borderColor);

        styleLabel(labelTime, 14, Font.BOLD, darkMode ? new Color(147, 197, 253) : new Color(40, 90, 150));
        styleLabel(labelWrong, 14, Font.BOLD, darkMode ? new Color(252, 165, 165) : new Color(150, 50, 50));
        styleLabel(labelStatus, 14, Font.BOLD, textColor);
        styleLabel(labelGuesses, 13, Font.BOLD, mutedTextColor);
        styleLabel(labelLetterGuess, 13, Font.BOLD, textColor);
        styleLabel(labelWordGuess, 13, Font.BOLD, textColor);
        labelImage.setForeground(mutedTextColor);

        styleTextField(textLetter, fieldColor, textColor, blue);
        styleTextField(textWord, fieldColor, textColor, blue);
        styleTable(tableScores, cardColor, textColor, borderColor, blue);
        styleTable(tableLogs, cardColor, textColor, borderColor, blue);
        scrollScores.getViewport().setBackground(cardColor);
        scrollLogs.getViewport().setBackground(cardColor);

        styleButton(buttonStart, green);
        styleButton(buttonRestart, blue);
        styleButton(buttonLetter, blue);
        styleButton(buttonWord, blue);
        buttonTheme.setText(darkMode ? "Aydinlik Mod" : "Karanlik Mod");
        styleButton(buttonTheme, new Color(14, 165, 233));
        styleButton(buttonScoreRefresh, blue);
        styleButton(buttonScoreClear, red);
        styleButton(buttonLogRefresh, blue);
        styleButton(buttonLogClear, red);

        for (int i = 0; i < wordBoxes.size(); i++) {
            styleWordBox(wordBoxes.get(i));
        }
    }
    private void makeCard(JPanel panel, Color color, Color borderColor) {
        panel.setBackground(color);
        panel.setBorder(BorderFactory.createCompoundBorder(
                new RoundedBorder(borderColor, 6),
                BorderFactory.createEmptyBorder(8, 8, 8, 8)));
    }
    private void styleButton(JButton button, Color color) {
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setRolloverEnabled(true);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setUI(new RoundedButtonUI(color, 16));
        button.setFont(new Font("Segoe UI", Font.BOLD, 12));
        button.setBorder(BorderFactory.createEmptyBorder(7, 14, 7, 14));
    }
    private void styleTextField(JTextField field, Color backgroundColor, Color textColor, Color borderColor) {
        field.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        field.setBackground(backgroundColor);
        field.setForeground(textColor);
        field.setCaretColor(textColor);
        field.setBorder(BorderFactory.createCompoundBorder(
                new RoundedBorder(borderColor, 5),
                BorderFactory.createEmptyBorder(5, 8, 5, 8)));
    }
    private void styleTable(JTable table, Color backgroundColor, Color textColor, Color gridColor, Color selectionColor) {
        table.setBackground(backgroundColor);
        table.setForeground(textColor);
        table.setGridColor(gridColor);
        table.setSelectionBackground(selectionColor);
        table.setSelectionForeground(Color.WHITE);
        table.getTableHeader().setBackground(darkMode ? new Color(15, 23, 42) : new Color(230, 230, 230));
        table.getTableHeader().setForeground(textColor);
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
    }
    private void styleLabel(JLabel label, int size, int fontStyle, Color color) {
        label.setFont(new Font("Segoe UI", fontStyle, size));
        label.setForeground(color);
    }
    private void styleWordBox(JLabel label) {
        label.setOpaque(true);
        label.setBackground(darkMode ? new Color(15, 23, 42) : Color.WHITE);
        label.setBorder(new RoundedBorder(
                darkMode ? new Color(96, 165, 250) : new Color(90, 140, 190), 5));
        label.setFont(new Font("Segoe UI", Font.BOLD, 24));
        label.setForeground(darkMode ? new Color(226, 232, 240) : Color.BLACK);
    }
    private void startGame() {
        readWords();
        if (words.isEmpty()) {
            JOptionPane.showMessageDialog(this, "kelimeler.txt icinde kelime bulunamadi.");
            return;
        }
        if (timer != null) {
            timer.stop();
        }
        int wordIndex = random.nextInt(words.size());
        selectedWord = words.get(wordIndex).toUpperCase(turkish);
        wordLetters = splitLetters(selectedWord);
        visibleLetters = new String[wordLetters.length];
        wrongCount = 0;
        seconds = 0;
        gameActive = true;
        guesses.clear();
        panelWord.removeAll();
        panelWord.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 25));
        wordBoxes.clear();
        for (int i = 0; i < wordLetters.length; i++) {
            visibleLetters[i] = "*";
            JLabel label = new JLabel("*", SwingConstants.CENTER);
            label.setPreferredSize(new Dimension(48, 48));
            styleWordBox(label);
            panelWord.add(label);
            wordBoxes.add(label);
        }
        panelWord.revalidate();
        panelWord.repaint();
        textLetter.setText("");
        textWord.setText("");
        labelTime.setText("Sure: 0 sn");
        labelWrong.setText("Yanlis: 0 / 11");
        labelStatus.setText("Oyun basladi. Tahmin yapiniz.");
        labelGuesses.setText("Tahmin edilen harfler: -");
        labelImage.setIcon(null);
        labelImage.setText("Ilk yanlis tahminde 1.jpg gosterilecek");
        setGuessAreaEnabled(true);
        timer = new javax.swing.Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                seconds++;
                labelTime.setText("Sure: " + seconds + " sn");
            }
        });
        timer.start();
        writeLog("OYUN_BASLADI", "Yeni oyun baslatildi");
        tabs.setSelectedIndex(0);
    }
    private void guessLetter() {
        String letter = textLetter.getText().trim().toUpperCase(turkish);
        textLetter.setText("");
        checkLetter(letter);
    }
    private void checkLetter(String letter) {
        if (!gameActive) {
            JOptionPane.showMessageDialog(this, "Once oyunu baslatiniz.");
            return;
        }
        if (letter.length() == 0) {
            JOptionPane.showMessageDialog(this, "Harf tahmini giriniz.");
            return;
        }
        letter = splitLetters(letter)[0];
        if (!isTurkishLetter(letter)) {
            JOptionPane.showMessageDialog(this, "Sadece Turkce alfabedeki harfleri kullaniniz.");
            labelStatus.setText("Turkce alfabede olmayan harf: " + letter);
            return;
        }
        if (guesses.contains(letter)) {
            labelStatus.setText("Bu harf daha once tahmin edildi: " + letter);
            return;
        }
        guesses.add(letter);
        writeGuesses();
        boolean correct = false;
        for (int i = 0; i < wordLetters.length; i++) {
            if (wordLetters[i].equals(letter)) {
                visibleLetters[i] = letter;
                wordBoxes.get(i).setText(letter);
                correct = true;
            }
        }
        if (correct) {
            labelStatus.setText("Dogru harf: " + letter);
            checkWin();
        } else {
            labelStatus.setText("Yanlis harf: " + letter);
            wrongGuess();
        }
    }
    private void guessWord() {
        if (!gameActive) {
            JOptionPane.showMessageDialog(this, "Once oyunu baslatiniz.");
            return;
        }
        String guess = textWord.getText().trim().toUpperCase(turkish);
        textWord.setText("");
        if (guess.length() == 0) {
            JOptionPane.showMessageDialog(this, "Kelime tahmini giriniz.");
            return;
        }
        if (guess.equals(selectedWord)) {
            for (int i = 0; i < wordLetters.length; i++) {
                visibleLetters[i] = wordLetters[i];
                wordBoxes.get(i).setText(wordLetters[i]);
            }
            finishGame(true);
        } else {
            labelStatus.setText("Kelime tahmini yanlis.");
            wrongGuess();
        }
    }
    private void wrongGuess() {
        wrongCount++;
        labelWrong.setText("Yanlis: " + wrongCount + " / 11");
        showImage(wrongCount);
        if (wrongCount >= 11) {
            finishGame(false);
        }
    }
    private void checkWin() {
        for (int i = 0; i < visibleLetters.length; i++) {
            if (visibleLetters[i].equals("*")) {
                return;
            }
        }
        finishGame(true);
    }
    private void finishGame(boolean won) {
        gameActive = false;
        if (timer != null) {
            timer.stop();
        }
        setGuessAreaEnabled(false);
        String result = won ? "Kazandi" : "Kaybetti";
        labelStatus.setText("Oyun bitti. Sonuc: " + result + " Kelime: " + selectedWord);
        writeGameRecord(result);
        writeLog(won ? "OYUN_KAZANILDI" : "OYUN_KAYBEDILDI",
                "Kelime: " + selectedWord + ", Sure: " + seconds + " sn");
        refreshTables();
        JOptionPane.showMessageDialog(this,
                "Sonuc: " + result + "\nKelime: " + selectedWord + "\nSure: " + seconds + " sn");
    }
    private void setGuessAreaEnabled(boolean active) {
        textLetter.setEnabled(active);
        textWord.setEnabled(active);
        buttonLetter.setEnabled(active);
        buttonWord.setEnabled(active);
        if (!active) {
        }
    }
    private void writeGuesses() {
        labelGuesses.setText("Tahmin edilen harfler: " + String.join(", ", guesses));
    }
    private void showImage(int imageNo) {
        ImageIcon icon = new ImageIcon(imageFolder + "\\" + imageNo + ".jpg");
        if (icon.getIconWidth() <= 0) {
            labelImage.setIcon(null);
            labelImage.setText(imageNo + ".jpg bulunamadi.");
            return;
        }
        int targetW = labelImage.getWidth() - 20;
        int targetH = labelImage.getHeight() - 20;
        if (targetW <= 0) {
            targetW = 420;
        }
        if (targetH <= 0) {
            targetH = 300;
        }
        double ratio = Math.min((double) targetW / icon.getIconWidth(),
                (double) targetH / icon.getIconHeight());
        ratio = Math.min(ratio, 1.0);
        int w = (int) (icon.getIconWidth() * ratio);
        int h = (int) (icon.getIconHeight() * ratio);
        Image image = icon.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
        labelImage.setText("");
        labelImage.setIcon(new ImageIcon(image));
    }
    private String[] splitLetters(String word) {
        String[] letters = new String[word.length()];
        for (int i = 0; i < word.length(); i++) {
            letters[i] = String.valueOf(word.charAt(i));
        }
        return letters;
    }
    private boolean isTurkishLetter(String letter) {
        if (letter.equals("Q") || letter.equals("W") || letter.equals("X")) {
            return false;
        }
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i].equals(letter)) {
                return true;
            }
        }
        return false;
    }
    private boolean checkPassword() {
        String currentPassword = readPassword();
        if (currentPassword.length() == 0) {
            return createFirstPassword();
        }
        for (int i = 1; i <= 3; i++) {
            String entered = askPassword("Sifre Girisi (" + i + "/3)");
            if (entered == null) {
                writeLog("SIFRE_IPTAL", "Kullanici sifre ekranini kapatti");
                return false;
            }
            if (entered.equals(currentPassword)) {
                writeLog("SIFRE_DOGRU", "Kullanici girisi basarili");
                return true;
            }
            writeLog("SIFRE_HATALI", "Hatali sifre denemesi: " + i);
            JOptionPane.showMessageDialog(this, "Sifre hatali.");
        }
        writeLog("PROGRAM_KAPANDI", "3 kez hatali sifre girildi");
        JOptionPane.showMessageDialog(this, "3 kez hatali sifre girildi. Program kapatiliyor.");
        return false;
    }
    private boolean createFirstPassword() {
        String newPassword = askPassword("Ilk sifreyi belirleyiniz");
        if (newPassword == null || newPassword.length() == 0) {
            writeLog("SIFRE_OLUSTURMA_IPTAL", "Sifre belirlenmedi");
            JOptionPane.showMessageDialog(this, "Sifre bos olamaz.");
            return false;
        }
        writePassword(newPassword);
        writeLog("SIFRE_OLUSTURULDU", "Ilk sifre kaydedildi");
        return true;
    }
    private String askPassword(String title) {
        JPasswordField field = new JPasswordField();
        int answer = JOptionPane.showConfirmDialog(this, field, title, JOptionPane.OK_CANCEL_OPTION);
        if (answer != JOptionPane.OK_OPTION) {
            return null;
        }
        return new String(field.getPassword()).trim();
    }
    private boolean isPasswordCorrect(String description) {
        String entered = askPassword("Sifre Kontrol");
        if (entered == null) {
            writeLog("SIFRE_IPTAL", description);
            return false;
        }
        boolean correct = entered.equals(readPassword());
        writeLog(correct ? "SIFRE_DOGRU" : "SIFRE_HATALI", description);
        if (!correct) {
            JOptionPane.showMessageDialog(this, "Sifre hatali.");
        }
        return correct;
    }
    private void readWords() {
        words.clear();
        try (BufferedReader br = openReader(wordFile)) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                int separatorIndex = line.indexOf(';');
                if (separatorIndex >= 0) {
                    line = line.substring(0, separatorIndex).trim();
                }
                if (line.length() >= 6) {
                    words.add(line);
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Kelimeler okunamadi.");
        }
    }
    private void refreshTables() {
        fillTable((DefaultTableModel) tableScores.getModel(), gameFile, 4);
        fillTable((DefaultTableModel) tableLogs.getModel(), logFile, 3);
    }
    private void fillTable(DefaultTableModel model, String filePath, int columnCount) {
        model.setRowCount(0);
        try (BufferedReader br = openReader(filePath)) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().length() == 0) {
                    continue;
                }
                String[] parts = line.split("\\|");
                Object[] row = new Object[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    row[i] = i < parts.length ? parts[i] : "";
                }
                model.addRow(row);
            }
        } catch (Exception ex) {
        }
    }
    private void clearFile(String filePath, String name) {
        if (!isPasswordCorrect(name + " temizleme")) {
            return;
        }
        try (BufferedWriter bw = openWriter(filePath, false)) {
            bw.write("");
            JOptionPane.showMessageDialog(this, name + " temizlendi.");
            refreshTables();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Dosya temizlenemedi.");
        }
    }
    private void prepareFiles() {
        new File(imageFolder).mkdirs();
        new File(textFolder).mkdirs();
        createFileIfMissing(wordFile);
        createFileIfMissing(passwordFile);
        createFileIfMissing(logFile);
        createFileIfMissing(gameFile);
        fillWordFileIfEmpty();
    }
    private void createFileIfMissing(String path) {
        try {
            File filePath = new File(path);
            if (!filePath.exists()) {
                filePath.createNewFile();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, path + " olusturulamadi.");
        }
    }
    private void fillWordFileIfEmpty() {
        if (new File(wordFile).length() > 0) {
            return;
        }
        String[] defaults = {
            "Kahvaltı",
            "Merdiven",
            "Kaptanlık",
            "Televizyon",
            "Çiftçilik",
            "Gözlükçü",
            "Tornavida",
            "Karınca",
            "Patates",
            "Mandolin",
            "Balıkçılar",
            "Kumsallar",
            "Yazıcılar",
            "Kelebekler",
            "Lokomotif",
            "Şelaleler",
            "Kavanozlar",
            "Ayakkabıcı",
            "Manzaralar",
            "Dondurma",
            "Kıyafetler",
            "Fotoğrafçı",
            "Radyasyon",
            "Mikroskop",
            "Maceraperest",
            "Seyahatler",
            "Kütükler",
            "Gökkuşağı",
            "Tiyatrocu",
            "Uydular"
        };
        try (BufferedWriter bw = openWriter(wordFile, false)) {
            for (int i = 0; i < defaults.length; i++) {
                bw.write(defaults[i]);
                bw.newLine();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Varsayilan kelimeler yazilamadi.");
        }
    }
    private String readPassword() {
        try (BufferedReader br = openReader(passwordFile)) {
            String password = br.readLine();
            return password == null ? "" : password.trim();
        } catch (Exception ex) {
            return "";
        }
    }
    private void writePassword(String password) {
        try (BufferedWriter bw = openWriter(passwordFile, false)) {
            bw.write(password);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Sifre yazilamadi.");
        }
    }
    private void writeLog(String tag, String description) {
        try (BufferedWriter bw = openWriter(logFile, true)) {
            bw.write(dateText() + "|" + tag + "|" + description);
            bw.newLine();
        } catch (Exception ex) {
        }
    }
    private void writeGameRecord(String result) {
        try (BufferedWriter bw = openWriter(gameFile, true)) {
            bw.write(dateText() + "|" + seconds + "|" + result + "|" + selectedWord);
            bw.newLine();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Oyun kaydi yazilamadi.");
        }
    }
    private String dateText() {
        return LocalDateTime.now().format(dateTimeFormat);
    }
    private BufferedReader openReader(String path) throws Exception {
        return new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));
    }
    private BufferedWriter openWriter(String path, boolean append) throws Exception {
        return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path, append), StandardCharsets.UTF_8));
    }
    private static class RoundedButtonUI extends javax.swing.plaf.basic.BasicButtonUI {
        private Color color;
        private int radius;

        public RoundedButtonUI(Color color, int radius) {
            this.color = color;
            this.radius = radius;
        }

        public void paint(Graphics g, JComponent c) {
            AbstractButton button = (AbstractButton) c;
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            Color fillColor = color;
            if (!button.isEnabled()) {
                fillColor = new Color(51, 65, 85);
            } else if (button.getModel().isPressed()) {
                fillColor = color.darker();
            } else if (button.getModel().isRollover()) {
                fillColor = color.brighter();
            }

            g2.setColor(fillColor);
            g2.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), radius, radius);
            g2.setColor(fillColor.darker());
            g2.drawRoundRect(0, 0, c.getWidth() - 1, c.getHeight() - 1, radius, radius);
            g2.dispose();
            super.paint(g, c);
        }

        protected void paintText(Graphics g, JComponent c, Rectangle textRect, String text) {
            AbstractButton button = (AbstractButton) c;
            FontMetrics fm = g.getFontMetrics();
            int y = textRect.y + ((textRect.height - fm.getHeight()) / 2) + fm.getAscent();
            g.setColor(button.isEnabled() ? button.getForeground() : new Color(226, 232, 240));
            javax.swing.plaf.basic.BasicGraphicsUtils.drawStringUnderlineCharAt(
                    g, text, button.getDisplayedMnemonicIndex(), textRect.x, y);
        }
    }
    private static class DarkTabUI extends javax.swing.plaf.basic.BasicTabbedPaneUI {
        private Color selectedColor;
        private Color normalColor;
        private Color borderColor;
        private Color textColor;

        public DarkTabUI(Color selectedColor, Color normalColor, Color borderColor, Color textColor) {
            this.selectedColor = selectedColor;
            this.normalColor = normalColor;
            this.borderColor = borderColor;
            this.textColor = textColor;
        }

        protected void installDefaults() {
            super.installDefaults();
            tabInsets = new Insets(7, 14, 7, 14);
            selectedTabPadInsets = new Insets(0, 0, 0, 0);
            contentBorderInsets = new Insets(1, 1, 1, 1);
        }

        protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex,
                int x, int y, int w, int h, boolean isSelected) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(isSelected ? selectedColor : normalColor);
            g2.fillRoundRect(x + 1, y + 2, w - 3, h - 3, 10, 10);
            g2.dispose();
        }

        protected void paintTabBorder(Graphics g, int tabPlacement, int tabIndex,
                int x, int y, int w, int h, boolean isSelected) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(isSelected ? borderColor : borderColor.darker());
            g2.drawRoundRect(x + 1, y + 2, w - 3, h - 3, 10, 10);
            g2.dispose();
        }

        protected void paintText(Graphics g, int tabPlacement, Font font, FontMetrics metrics,
                int tabIndex, String title, Rectangle textRect, boolean isSelected) {
            g.setFont(font);
            g.setColor(textColor);
            javax.swing.plaf.basic.BasicGraphicsUtils.drawStringUnderlineCharAt(
                    g, title, -1, textRect.x, textRect.y + metrics.getAscent());
        }

        protected void paintFocusIndicator(Graphics g, int tabPlacement, Rectangle[] rects,
                int tabIndex, Rectangle iconRect, Rectangle textRect, boolean isSelected) {
        }
    }
    private static class RoundedBorder extends javax.swing.border.AbstractBorder {
        private Color color;
        private int radius;

        public RoundedBorder(Color color, int radius) {
            this.color = color;
            this.radius = radius;
        }

        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(color);
            g2.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
            g2.dispose();
        }

        public Insets getBorderInsets(Component c) {
            return new Insets(6, 8, 6, 8);
        }

        public Insets getBorderInsets(Component c, Insets insets) {
            insets.left = 8;
            insets.right = 8;
            insets.top = 6;
            insets.bottom = 6;
            return insets;
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonStart;
    private javax.swing.JButton buttonLetter;
    private javax.swing.JButton buttonTheme;
    private javax.swing.JButton buttonWord;
    private javax.swing.JButton buttonLogClear;
    private javax.swing.JButton buttonLogRefresh;
    private javax.swing.JButton buttonScoreClear;
    private javax.swing.JButton buttonScoreRefresh;
    private javax.swing.JButton buttonRestart;
    private javax.swing.JMenuItem itemStart;
    private javax.swing.JMenuItem itemExit;
    private javax.swing.JMenuItem itemRefreshTables;
    private javax.swing.JMenuItem itemRestart;
    private javax.swing.JLabel labelStatus;
    private javax.swing.JLabel labelWrong;
    private javax.swing.JLabel labelLetterGuess;
    private javax.swing.JLabel labelWordGuess;
    private javax.swing.JLabel labelImage;
    private javax.swing.JLabel labelTime;
    private javax.swing.JLabel labelGuesses;
    private javax.swing.JPopupMenu.Separator menuSeparator;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuRecords;
    private javax.swing.JMenu menuGame;
    private javax.swing.JPanel panelInfo;
    private javax.swing.JPanel panelWord;
    private javax.swing.JPanel panelLogButtons;
    private javax.swing.JPanel panelLogTab;
    private javax.swing.JPanel panelMiddle;
    private javax.swing.JPanel panelGameButtons;
    private javax.swing.JPanel panelGameTab;
    private javax.swing.JPanel panelImageSide;
    private javax.swing.JPanel panelScoreButtons;
    private javax.swing.JPanel panelScoreTab;
    private javax.swing.JPanel panelGuessSide;
    private javax.swing.JPanel panelGuess;
    private javax.swing.JPanel panelTop;
    private javax.swing.JScrollPane scrollLogs;
    private javax.swing.JScrollPane scrollScores;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tableLogs;
    private javax.swing.JTable tableScores;
    private javax.swing.JTextField textLetter;
    private javax.swing.JTextField textWord;
    // End of variables declaration//GEN-END:variables
}

