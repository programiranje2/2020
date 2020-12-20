/*
 * Created on Dec 13, 2020
 *
 */
package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import util.Utility;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.Dimension;
import javax.swing.JRadioButton;
import javax.swing.JSplitPane;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import music.Musician;
import music.Song;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class MainAppWindow {

    private JFrame frmRemember;
    private JMenuBar menuBar;
    private JMenu mnFile;
    private JMenu mnEdit;
    private JMenu mnHelp;
    private JMenuItem mntmAbout;
    private JPanel panelNorth;
    private JPanel panelWest;
    private JPanel panelEast;
    private JPanel panelSouth;
    private JPanel panelCenter;
    private JLabel lblJohnLennon;
    private JLabel lblSong;
    private JComboBox songComboBox;
    private JLabel lblAuthor;
    private JLabel lblAuthorName;
    private JLabel lblYear;
    private JLabel lblYearText;
    private JButton btnModifySong;
    private JButton btnSaveSong;
    private JLabel lblMusician;
    private JComboBox musicianComboBox;
    private JLabel lblNationality;
    private JLabel lblNationalityText;
    private JButton btnClose;
    private JLabel lblDetails;
    private JRadioButton rdbtnBasic;
    private JRadioButton rdbtnStandard;
    private JRadioButton rdbtnAll;
    private JSplitPane splitPane;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JScrollPane scrollPaneLeft;
    private JScrollPane scrollPaneRight;
    private JTextArea textArea;
    private JLabel lblIllustration;
    private JMenuItem mntmNewSong;
    private JMenuItem mntmNewMusician;
    
    private Song song;
    private List<Song> songs = new ArrayList<Song>();
    private Musician musician;
    private List<Musician> musicians = new ArrayList<Musician>();
    
//    private MusicianDialog musicianDialog;
//    private SongDialog songDialog;
    
    private JButton btnModifyMusician;
    private JButton btnSaveMusician;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainAppWindow window = new MainAppWindow();
                    window.frmRemember.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public MainAppWindow() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmRemember = new JFrame();
        frmRemember.setTitle("Remember");
        frmRemember.setBounds(100, 100, 896, 505);
        frmRemember.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmRemember.setJMenuBar(getMenuBar());
        frmRemember.getContentPane().add(getPanelNorth(), BorderLayout.NORTH);
        frmRemember.getContentPane().add(getPanelWest(), BorderLayout.WEST);
        frmRemember.getContentPane().add(getPanelEast(), BorderLayout.EAST);
        frmRemember.getContentPane().add(getPanelSouth(), BorderLayout.SOUTH);
        frmRemember.getContentPane().add(getPanelCenter(), BorderLayout.CENTER);
        
        deserializeMusicians();
        deserializeSongs();
        populateMainAppWindow();
    }

    private JMenuBar getMenuBar() {
        if (menuBar == null) {
        	menuBar = new JMenuBar();
        	menuBar.add(getMnFile());
        	menuBar.add(getMnEdit());
        	menuBar.add(getMnHelp());
        }
        return menuBar;
    }
    private JMenu getMnFile() {
        if (mnFile == null) {
        	mnFile = new JMenu("File");
        	mnFile.add(getMntmNewMusician());
        	mnFile.add(getMntmNewSong());
        }
        return mnFile;
    }
    private JMenu getMnEdit() {
        if (mnEdit == null) {
        	mnEdit = new JMenu("Edit");
        }
        return mnEdit;
    }
    private JMenu getMnHelp() {
        if (mnHelp == null) {
        	mnHelp = new JMenu("Help");
        	mnHelp.add(getMntmAbout());
        }
        return mnHelp;
    }
    private JMenuItem getMntmAbout() {
        if (mntmAbout == null) {
        	mntmAbout = new JMenuItem("About");
        	mntmAbout.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent arg0) {
        	        JOptionPane.showMessageDialog(frmRemember, "A simple Swing application inspired by the life and work of John Lennon.");
        	    }
        	});
        }
        return mntmAbout;
    }
    private JPanel getPanelNorth() {
        if (panelNorth == null) {
        	panelNorth = new JPanel();
        	panelNorth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        	panelNorth.add(getLblJohnLennon());
        }
        return panelNorth;
    }
    private JPanel getPanelWest() {
        if (panelWest == null) {
        	panelWest = new JPanel();
        	panelWest.setLayout(new MigLayout("", "[grow]", "[][][][][][][grow][][]"));
        	panelWest.add(getLblSong(), "cell 0 0");
        	panelWest.add(getSongComboBox(), "cell 0 1,growx");
        	panelWest.add(getLblAuthor(), "cell 0 2");
        	panelWest.add(getLblAuthorName(), "cell 0 3,alignx left");
        	panelWest.add(getLblYear(), "cell 0 4");
        	panelWest.add(getLblYearText(), "cell 0 5,alignx left");
        	panelWest.add(getBtnModifySong(), "cell 0 7,growx");
        	panelWest.add(getBtnSaveSong(), "cell 0 8,growx");
        }
        return panelWest;
    }
    private JPanel getPanelEast() {
        if (panelEast == null) {
        	panelEast = new JPanel();
        	panelEast.setLayout(new MigLayout("", "[grow][grow]", "[][][][][grow][][][]"));
        	panelEast.add(getLblMusician(), "cell 0 0");
        	panelEast.add(getMusicianComboBox(), "cell 0 1,growx");
        	panelEast.add(getLblNationality(), "cell 0 2");
        	panelEast.add(getLblNationalityText(), "cell 0 3,alignx left");
        	panelEast.add(getBtnModifyMusician(), "cell 0 5,growx");
        	panelEast.add(getBtnSaveMusician(), "cell 0 6,growx");
        	panelEast.add(getBtnClose(), "cell 0 7,growx");
        }
        return panelEast;
    }
    private JPanel getPanelSouth() {
        if (panelSouth == null) {
        	panelSouth = new JPanel();
        	panelSouth.setLayout(new MigLayout("", "[grow][][][][grow]", "[][]"));
        	panelSouth.add(getLblDetails(), "cell 1 0 3 1,alignx center");
        	panelSouth.add(getRdbtnBasic(), "cell 1 1");
        	panelSouth.add(getRdbtnStandard(), "cell 2 1");
        	panelSouth.add(getRdbtnAll(), "cell 3 1");
        }
        return panelSouth;
    }
    private JPanel getPanelCenter() {
        if (panelCenter == null) {
        	panelCenter = new JPanel();
        	panelCenter.setLayout(new MigLayout("", "[grow]", "[grow]"));
        	panelCenter.add(getSplitPane(), "cell 0 0,grow");
        }
        return panelCenter;
    }
    private JLabel getLblJohnLennon() {
        if (lblJohnLennon == null) {
        	lblJohnLennon = new JLabel("John Lennon");
        	lblJohnLennon.setForeground(new Color(0, 128, 128));
        	lblJohnLennon.setFont(new Font("Arial", Font.BOLD, 16));
        }
        return lblJohnLennon;
    }
    private JLabel getLblSong() {
        if (lblSong == null) {
        	lblSong = new JLabel("Song");
        }
        return lblSong;
    }
    private JComboBox getSongComboBox() {
        if (songComboBox == null) {
        	songComboBox = new JComboBox();
        	songComboBox.addItemListener(new ItemListener() {
        	    public void itemStateChanged(ItemEvent arg0) {
        	        if (arg0.getStateChange() == ItemEvent.SELECTED) {
        	            Song s = Utility.findSong(((String) songComboBox.getSelectedItem()), songs);
        	            populateSongInfo(s);
        	            matchMusicianToSong();
        	        }
        	    }
        	});
        	songComboBox.setPreferredSize(new Dimension(120, 20));
//            songComboBox.addItem("Mother");
//            songComboBox.addItem("I Found Out");
//            songComboBox.addItem("Isolation");
        }
        return songComboBox;
    }
    private JLabel getLblAuthor() {
        if (lblAuthor == null) {
        	lblAuthor = new JLabel("Author");
        }
        return lblAuthor;
    }
    private JLabel getLblAuthorName() {
        if (lblAuthorName == null) {
        	lblAuthorName = new JLabel("");
        	lblAuthorName.setForeground(new Color(30, 144, 255));
        	lblAuthorName.setFont(new Font("Arial", Font.BOLD, 13));
        }
        return lblAuthorName;
    }
    private JLabel getLblYear() {
        if (lblYear == null) {
        	lblYear = new JLabel("Year");
        }
        return lblYear;
    }
    private JLabel getLblYearText() {
        if (lblYearText == null) {
        	lblYearText = new JLabel("");
        	lblYearText.setFont(new Font("Arial", Font.BOLD, 11));
        }
        return lblYearText;
    }
    private JButton getBtnModifySong() {
        if (btnModifySong == null) {
        	btnModifySong = new JButton("Modify");
        }
        return btnModifySong;
    }
    private JButton getBtnSaveSong() {
        if (btnSaveSong == null) {
        	btnSaveSong = new JButton("Save");
        	btnSaveSong.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        serializeSongs();
        	    }
        	});
        }
        return btnSaveSong;
    }
    private JLabel getLblMusician() {
        if (lblMusician == null) {
        	lblMusician = new JLabel("Musician");
        	lblMusician.setPreferredSize(new Dimension(120, 14));
        }
        return lblMusician;
    }
    private JComboBox getMusicianComboBox() {
        if (musicianComboBox == null) {
        	musicianComboBox = new JComboBox();
        	musicianComboBox.addItemListener(new ItemListener() {
        	    public void itemStateChanged(ItemEvent arg0) {
        	        if (arg0.getStateChange() == ItemEvent.SELECTED) {
        	            Musician m = Utility.findMusician(((String) musicianComboBox.getSelectedItem()), musicians);
        	            populateMusicianInfo(m);
        	            matchSongToMusician();
        	        }
        	    }
        	});
        }
        return musicianComboBox;
    }
    private JLabel getLblNationality() {
        if (lblNationality == null) {
        	lblNationality = new JLabel("Nationality");
        }
        return lblNationality;
    }
    private JLabel getLblNationalityText() {
        if (lblNationalityText == null) {
        	lblNationalityText = new JLabel("");
        	lblNationalityText.setForeground(new Color(0, 139, 139));
        	lblNationalityText.setFont(new Font("Arial", Font.BOLD, 13));
        }
        return lblNationalityText;
    }
    private JButton getBtnClose() {
        if (btnClose == null) {
        	btnClose = new JButton("Close");
        }
        return btnClose;
    }
    private JLabel getLblDetails() {
        if (lblDetails == null) {
        	lblDetails = new JLabel("Details");
        	lblDetails.setFont(new Font("Tahoma", Font.BOLD, 13));
        	lblDetails.setForeground(new Color(153, 0, 102));
        }
        return lblDetails;
    }
    private JRadioButton getRdbtnBasic() {
        if (rdbtnBasic == null) {
        	rdbtnBasic = new JRadioButton("Basic");
        	rdbtnBasic.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        getPanelCenter().setVisible(false);
        	        getLblMusician().setVisible(false);
        	        getMusicianComboBox().setVisible(false);
        	        getLblNationality().setVisible(false);
        	        getLblNationalityText().setVisible(false);
        	        getBtnModifyMusician().setVisible(false);
        	        getBtnSaveMusician().setVisible(false);
        	        getBtnClose().setVisible(false);
        	    }
        	});
        	buttonGroup.add(rdbtnBasic);
        }
        return rdbtnBasic;
    }
    private JRadioButton getRdbtnStandard() {
        if (rdbtnStandard == null) {
        	rdbtnStandard = new JRadioButton("Standard");
        	rdbtnStandard.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
                    getPanelCenter().setVisible(true);
                    getLblMusician().setVisible(false);
                    getMusicianComboBox().setVisible(false);
                    getLblNationality().setVisible(false);
                    getLblNationalityText().setVisible(false);
                    getBtnModifyMusician().setVisible(false);
                    getBtnSaveMusician().setVisible(false);
                    getBtnClose().setVisible(false);
        	    }
        	});
        	rdbtnStandard.setSelected(true);
        	buttonGroup.add(rdbtnStandard);
        }
        return rdbtnStandard;
    }
    private JRadioButton getRdbtnAll() {
        if (rdbtnAll == null) {
        	rdbtnAll = new JRadioButton("All");
        	rdbtnAll.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
                    getPanelCenter().setVisible(true);
                    getLblMusician().setVisible(true);
                    getMusicianComboBox().setVisible(true);
                    getLblNationality().setVisible(true);
                    getLblNationalityText().setVisible(true);
                    getBtnModifyMusician().setVisible(true);
                    getBtnSaveMusician().setVisible(true);
                    getBtnClose().setVisible(true);
        	    }
        	});
        	buttonGroup.add(rdbtnAll);
        }
        return rdbtnAll;
    }
    private JSplitPane getSplitPane() {
        if (splitPane == null) {
        	splitPane = new JSplitPane();
        	splitPane.setOneTouchExpandable(true);
        	splitPane.setDividerSize(8);
        	splitPane.setLeftComponent(getScrollPaneLeft());
        	splitPane.setRightComponent(getScrollPaneRight());
        	splitPane.setDividerLocation(250);
        }
        return splitPane;
    }
    private JScrollPane getScrollPaneLeft() {
        if (scrollPaneLeft == null) {
        	scrollPaneLeft = new JScrollPane();
        	scrollPaneLeft.setViewportView(getTextArea());
        }
        return scrollPaneLeft;
    }
    private JScrollPane getScrollPaneRight() {
        if (scrollPaneRight == null) {
        	scrollPaneRight = new JScrollPane();
        	scrollPaneRight.setViewportView(getLblIllustration());
        }
        return scrollPaneRight;
    }
    private JTextArea getTextArea() {
        if (textArea == null) {
        	textArea = new JTextArea();
        }
        return textArea;
    }
    private JLabel getLblIllustration() {
        if (lblIllustration == null) {
        	lblIllustration = new JLabel("");
        	lblIllustration.setHorizontalAlignment(SwingConstants.CENTER);
        	lblIllustration.setIcon(new ImageIcon("M:\\Vladan\\Courses\\P2\\My Java Programs\\Eclipse Workspace\\John Lennon\\resources\\Lennon.jpg"));
        }
        return lblIllustration;
    }
    private JMenuItem getMntmNewSong() {
        if (mntmNewSong == null) {
        	mntmNewSong = new JMenuItem("New song...");
        	mntmNewSong.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        song = (new SongDialog(frmRemember, true, musicians)).showDialog();
        	        if (song != null) {
        	            songs.add(song);
        	            songComboBox.addItem(song.getTitle());
        	            songComboBox.setSelectedIndex(songComboBox.getItemCount() - 1);
        	            populateSongInfo(song);
        	        }
        	    }
        	});
        }
        return mntmNewSong;
    }
    private JMenuItem getMntmNewMusician() {
        if (mntmNewMusician == null) {
        	mntmNewMusician = new JMenuItem("New musician...");
        	mntmNewMusician.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        musician = (new MusicianDialog(frmRemember, true)).showDialog();
        	        if (musician != null) {                                                // OK clicked in NewMusician dialog, not Cancel
        	            musicians.add(musician);
        	            getMusicianComboBox().addItem(musician.getName());
        	            getMusicianComboBox().setSelectedIndex(musicianComboBox.getItemCount() - 1);
        	            populateMusicianInfo(musician);
        	        }
//        	        System.out.println(musician);
        	    }
        	});
        }
        return mntmNewMusician;
    }
    private JButton getBtnModifyMusician() {
        if (btnModifyMusician == null) {
        	btnModifyMusician = new JButton("Modify");
        	btnModifyMusician.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent arg0) {
                    musician = (new MusicianDialog(frmRemember, true)).showDialog();
                    if (musician != null) {                                                // OK clicked in NewMusician dialog, not Cancel
                        musicians.remove(Utility.findMusician(((String) musicianComboBox.getSelectedItem()), musicians));
                        musicianComboBox.removeItemAt(musicianComboBox.getSelectedIndex());
                        musicians.add(musician);
                        musicianComboBox.addItem(musician.getName());
                        musicianComboBox.setSelectedIndex(musicianComboBox.getItemCount() - 1);
                        populateMusicianInfo(musician);
                    }
        	    }
        	});
        }
        return btnModifyMusician;
    }
    private JButton getBtnSaveMusician() {
        if (btnSaveMusician == null) {
        	btnSaveMusician = new JButton("Save");
        	btnSaveMusician.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        serializeMusicians();
        	    }
        	});
        }
        return btnSaveMusician;
    }
    
    
    private void serializeMusicians() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File(Utility.getDataDir() + "musicians.serialized")))) {
            out.writeObject(musicians);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    private List<Musician> deserializeMusicians() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File(Utility.getDataDir() + "musicians.serialized")))) {
            musicians = (List<Musician>) in.readObject();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return musicians;
    }
    
    private void serializeSongs() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File(Utility.getDataDir() + "songs.serialized")))) {
            out.writeObject(songs);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    private List<Song> deserializeSongs() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File(Utility.getDataDir() + "songs.serialized")))) {
            songs = (List<Song>) in.readObject();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return songs;
    }
    
    private void populateMainAppWindow() {
        for (Musician m : musicians) {
            getMusicianComboBox().addItem(m.getName());
        }
        if (getMusicianComboBox().getItemCount() > 0) {
            getMusicianComboBox().setSelectedIndex(0);
            // TO-DO: update main app window with the selected musician's photo, songs and selected-song lyrics
        }
        for (Song s : songs) {
            getSongComboBox().addItem(s.getTitle());
        }
        if (getSongComboBox().getItemCount() > 0) {
            getSongComboBox().setSelectedIndex(0);
            // TO-DO: update main app window with the song author's photo and the selected-song lyrics
       }
    }
    
    private void populateMusicianInfo(Musician m) {
        getLblIllustration().setIcon(m.getIcon());
        getLblNationalityText().setText(m.getNationality().name());
    }
    
    private void populateSongInfo(Song s) {
        getLblAuthorName().setText(s.getAuthor().getName());
        getLblYearText().setText(String.valueOf(s.getYear()));
        getTextArea().setText(s.getLyrics());
        getLblIllustration().setIcon(s.getAuthor().getIcon());
    }
    
    private void matchMusicianToSong() {
        Song s = Utility.findSong(((String) songComboBox.getSelectedItem()), songs);
        Musician m = (Musician) s.getAuthor();
        String name = m.getName();
        for (int i = 0; i < musicianComboBox.getItemCount(); i++) {
            if (name.equals((String) musicianComboBox.getItemAt(i))) {
                musicianComboBox.setSelectedIndex(i);
                populateMusicianInfo(m);
                break;
            }
        }
    }
    
    private void matchSongToMusician() {
        Musician m = Utility.findMusician((String) musicianComboBox.getSelectedItem(), musicians);
        for (Song s : songs) {
            if (((Musician) s.getAuthor()).equals(m)) {
                songComboBox.setSelectedItem(s.getTitle());
                populateSongInfo(s);
                break;
            }
        }
    }
}
