/*
 * Created on Dec 20, 2020
 *
 */
package main;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import util.Utility;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import music.Musician;
import music.Song;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class SongDialog extends JDialog {
    private JPanel panelSouth;
    private JPanel panelCenter;
    private JButton btnOk;
    private JButton btnCancel;
    private JLabel lblTitle;
    private JTextField textFieldTitle;
    private JLabel lblAuthor;
    private JComboBox comboBoxAuthor;
    private JLabel lblYear;
    private JTextField textFieldYear;
    private JLabel lblLyrics;
    private JScrollPane scrollPaneLyrics;
    private JTextArea textAreaLyrics;
    
    private SongDialog songDialog = this;
    private Song song;
    private List<Musician> musicians;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SongDialog dialog = new SongDialog();
                    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    dialog.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the dialog.
     */
    public SongDialog() {
        setTitle("Song");
        setBounds(100, 100, 450, 300);
        getContentPane().add(getPanelSouth(), BorderLayout.SOUTH);
        getContentPane().add(getPanelCenter(), BorderLayout.CENTER);
    }

    public SongDialog(JFrame frm, boolean modal) {
        super(frm, modal);
        setTitle("Song");
        setBounds(100, 100, 450, 300);
        getContentPane().add(getPanelSouth(), BorderLayout.SOUTH);
        getContentPane().add(getPanelCenter(), BorderLayout.CENTER);
    }
    
    public SongDialog(JFrame frm, boolean modal, List<Musician> musicians) {
        this(frm, modal);
        this.musicians = musicians;
        // populate comboBoxAuthor
        for (Musician m : musicians) {
            getComboBoxAuthor().addItem(m.getName());
        }
    }
    
    public Song showDialog() {
        songDialog.setVisible(true);
        dispose();
        return song;
    }

    private JPanel getPanelSouth() {
        if (panelSouth == null) {
        	panelSouth = new JPanel();
        	panelSouth.add(getBtnOk());
        	panelSouth.add(getBtnCancel());
        }
        return panelSouth;
    }
    private JPanel getPanelCenter() {
        if (panelCenter == null) {
        	panelCenter = new JPanel();
        	panelCenter.setLayout(new MigLayout("", "[][grow]", "[][][][grow]"));
        	panelCenter.add(getLblTitle(), "cell 0 0,alignx left");
        	panelCenter.add(getTextFieldTitle(), "cell 1 0,growx");
        	panelCenter.add(getLblAuthor(), "cell 0 1,alignx trailing");
        	panelCenter.add(getComboBoxAuthor(), "cell 1 1,growx");
        	panelCenter.add(getLblYear(), "cell 0 2,alignx left");
        	panelCenter.add(getTextFieldYear(), "cell 1 2,growx");
        	panelCenter.add(getLblLyrics(), "cell 0 3");
        	panelCenter.add(getScrollPaneLyrics(), "cell 1 3,grow");
        }
        return panelCenter;
    }
    private JButton getBtnOk() {
        if (btnOk == null) {
        	btnOk = new JButton("OK");
        	btnOk.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
//        	        song = null;
        	        song = new Song();
                    song.setTitle(textFieldTitle.getText());
                    song.setYear(Integer.parseInt(textFieldYear.getText()));
                    song.setAuthor(Utility.findMusician(((String) comboBoxAuthor.getSelectedItem()), musicians));
                    song.setLyrics(textAreaLyrics.getText());
                    
        	        songDialog.setVisible(false);
        	    }
        	});
        }
        return btnOk;
    }
    private JButton getBtnCancel() {
        if (btnCancel == null) {
        	btnCancel = new JButton("Cancel");
        	btnCancel.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
                    song = null;
                    songDialog.setVisible(false);
        	    }
        	});
        }
        return btnCancel;
    }
    private JLabel getLblTitle() {
        if (lblTitle == null) {
        	lblTitle = new JLabel("Title");
        }
        return lblTitle;
    }
    private JTextField getTextFieldTitle() {
        if (textFieldTitle == null) {
        	textFieldTitle = new JTextField();
        	textFieldTitle.setColumns(10);
        }
        return textFieldTitle;
    }
    private JLabel getLblAuthor() {
        if (lblAuthor == null) {
        	lblAuthor = new JLabel("Author");
        }
        return lblAuthor;
    }
    private JComboBox getComboBoxAuthor() {
        if (comboBoxAuthor == null) {
        	comboBoxAuthor = new JComboBox();
        }
        return comboBoxAuthor;
    }
    private JLabel getLblYear() {
        if (lblYear == null) {
        	lblYear = new JLabel("Year");
        }
        return lblYear;
    }
    private JTextField getTextFieldYear() {
        if (textFieldYear == null) {
        	textFieldYear = new JTextField();
        	textFieldYear.setColumns(10);
        }
        return textFieldYear;
    }
    private JLabel getLblLyrics() {
        if (lblLyrics == null) {
        	lblLyrics = new JLabel("Lyrics");
        }
        return lblLyrics;
    }
    private JScrollPane getScrollPaneLyrics() {
        if (scrollPaneLyrics == null) {
        	scrollPaneLyrics = new JScrollPane();
        	scrollPaneLyrics.setViewportView(getTextAreaLyrics());
        }
        return scrollPaneLyrics;
    }
    private JTextArea getTextAreaLyrics() {
        if (textAreaLyrics == null) {
        	textAreaLyrics = new JTextArea();
        }
        return textAreaLyrics;
    }
}
