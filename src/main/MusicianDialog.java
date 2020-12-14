/*
 * Created on Dec 13, 2020
 *
 */
package main;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;

import music.Musician;
import net.miginfocom.swing.MigLayout;
import util.Nationality;
import util.Utility;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class MusicianDialog extends JDialog {
    private JPanel panelSouth;
    private JTabbedPane tabbedPaneCenter;
    private JPanel panelPhoto;
    private JButton btnOk;
    private JButton btnCancel;
    private JPanel panelData;
    
    private Musician musician;
    private MusicianDialog musicianDialog = this;
    private JLabel lblName;
    private JLabel lblNationality;
    private JLabel lblAge;
    private JLabel lblAlive;
    private JTextField textFieldName;
    private JComboBox comboBoxNationality;
    private JSpinner spinnerAge;
    private JComboBox comboBoxAlive;
    private JLabel lblSelectPhoto;
    private JComboBox comboBoxPhotoFilename;
    private JScrollPane scrollPanePhoto;
    private JLabel lblSelectedPhoto;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MusicianDialog dialog = new MusicianDialog();
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
    public MusicianDialog() {
        setTitle("Musician");
        setBounds(100, 100, 450, 300);
        getContentPane().add(getPanelSouth(), BorderLayout.SOUTH);
        getContentPane().add(getTabbedPaneCenter(), BorderLayout.CENTER);

    }

    public MusicianDialog(JFrame owner, boolean modal) {
        super(owner, modal);
        setTitle("Musician");
        setBounds(200, 200, 450, 300);
        getContentPane().add(getPanelSouth(), BorderLayout.SOUTH);
        getContentPane().add(getTabbedPaneCenter(), BorderLayout.CENTER);

    }
    
    public Musician showDialog() {
        musicianDialog.setVisible(true);
        dispose();
        return musician;
    }

    private JPanel getPanelSouth() {
        if (panelSouth == null) {
        	panelSouth = new JPanel();
        	panelSouth.add(getBtnOk());
        	panelSouth.add(getBtnCancel());
        }
        return panelSouth;
    }
    private JTabbedPane getTabbedPaneCenter() {
        if (tabbedPaneCenter == null) {
        	tabbedPaneCenter = new JTabbedPane(JTabbedPane.TOP);
        	tabbedPaneCenter.addTab("Data", null, getPanelData(), null);
        	tabbedPaneCenter.addTab("Photo", null, getPanelPhoto(), null);
        }
        return tabbedPaneCenter;
    }
    private JPanel getPanelPhoto() {
        if (panelPhoto == null) {
        	panelPhoto = new JPanel();
        	panelPhoto.setLayout(new MigLayout("", "[grow][grow]", "[][grow]"));
        	panelPhoto.add(getLblSelectPhoto(), "cell 0 0,alignx trailing");
        	panelPhoto.add(getComboBoxPhotoFilename(), "cell 1 0,growx");
        	panelPhoto.add(getScrollPanePhoto(), "cell 0 1 2 1,grow");
        }
        return panelPhoto;
    }
    private JButton getBtnOk() {
        if (btnOk == null) {
        	btnOk = new JButton("OK");
        	btnOk.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
//        	        musician = null;
        	        musician = new Musician();
        	        musician.setName(getTextFieldName().getText());
        	        musician.setAge(Integer.parseInt((String) getSpinnerAge().getValue()));
        	        musician.setAlive((boolean) ((String) (comboBoxAlive.getSelectedItem())).equals("ALIVE") ? true : false); 
        	        for (Nationality n : Nationality.values()) {
        	            if (n.name().equals((String) comboBoxNationality.getSelectedItem())) {
        	                musician.setNationality(n);
        	            }
        	        }
        	        musician.setIcon(lblSelectedPhoto.getIcon());
        	        musicianDialog.setVisible(false);
        	    }
        	});
        }
        return btnOk;
    }
    private JButton getBtnCancel() {
        if (btnCancel == null) {
        	btnCancel = new JButton("Cancel");
        	btnCancel.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent arg0) {
        	        musician = null;
        	        musicianDialog.setVisible(false);
        	    }
        	});
        }
        return btnCancel;
    }
    private JPanel getPanelData() {
        if (panelData == null) {
        	panelData = new JPanel();
        	panelData.setLayout(new MigLayout("", "[][grow]", "[][][][]"));
        	panelData.add(getLblName(), "cell 0 0,alignx left");
        	panelData.add(getTextFieldName(), "cell 1 0,growx");
        	panelData.add(getLblNationality(), "cell 0 1,alignx left");
        	panelData.add(getComboBoxNationality(), "cell 1 1,growx");
        	panelData.add(getLblAge(), "cell 0 2,alignx left");
        	panelData.add(getSpinnerAge(), "cell 1 2,growx");
        	panelData.add(getLblAlive(), "cell 0 3,alignx left");
        	panelData.add(getComboBoxAlive(), "cell 1 3,growx");
        }
        return panelData;
    }
    private JLabel getLblName() {
        if (lblName == null) {
        	lblName = new JLabel("Name");
        	lblName.setHorizontalAlignment(SwingConstants.LEFT);
        	lblName.setHorizontalTextPosition(SwingConstants.LEFT);
        }
        return lblName;
    }
    private JLabel getLblNationality() {
        if (lblNationality == null) {
        	lblNationality = new JLabel("Nationality");
        }
        return lblNationality;
    }
    private JLabel getLblAge() {
        if (lblAge == null) {
        	lblAge = new JLabel("Age");
        }
        return lblAge;
    }
    private JLabel getLblAlive() {
        if (lblAlive == null) {
        	lblAlive = new JLabel("Alive");
        }
        return lblAlive;
    }
    private JTextField getTextFieldName() {
        if (textFieldName == null) {
        	textFieldName = new JTextField();
        	textFieldName.setColumns(10);
        }
        return textFieldName;
    }
    private JComboBox getComboBoxNationality() {
        if (comboBoxNationality == null) {
        	comboBoxNationality = new JComboBox();
            // populate combo box
        	for (Nationality nat : Nationality.values()) {
        	    comboBoxNationality.addItem(nat.name());
        	}
        }
        return comboBoxNationality;
    }
    private JSpinner getSpinnerAge() {
        if (spinnerAge == null) {
        	spinnerAge = new JSpinner();
        }
        return spinnerAge;
    }
    private JComboBox getComboBoxAlive() {
        if (comboBoxAlive == null) {
        	comboBoxAlive = new JComboBox();
        }
        // populate combo box
        comboBoxAlive.addItem("ALIVE");
        comboBoxAlive.addItem("DECEASED");
        return comboBoxAlive;
    }
    private JLabel getLblSelectPhoto() {
        if (lblSelectPhoto == null) {
        	lblSelectPhoto = new JLabel("Select photo");
        }
        return lblSelectPhoto;
    }
    private JComboBox getComboBoxPhotoFilename() {
        if (comboBoxPhotoFilename == null) {
        	comboBoxPhotoFilename = new JComboBox();
        	for (String f : Utility.getPhotoFilenames()) {
        	    comboBoxPhotoFilename.addItem(f);
        	}
        	comboBoxPhotoFilename.setSelectedItem("Lennon.jpg");
            getLblSelectedPhoto().setIcon(new ImageIcon(Utility.getResourcesDir() + (String) comboBoxPhotoFilename.getSelectedItem()));
            
        	comboBoxPhotoFilename.addItemListener(new ItemListener() {
        	    public void itemStateChanged(ItemEvent arg0) {
        	        if (arg0.getStateChange() == ItemEvent.SELECTED) {
        	            String selectedPhotoFilename = null;
        	            for (String filename : Utility.getPhotoFilenames()) {
        	                if (filename.equals((String) comboBoxPhotoFilename.getSelectedItem())) {
        	                    selectedPhotoFilename = filename;
        	                    break;
        	                }
        	            }
//        	            lblIllustration.setIcon(new ImageIcon("M:\\Vladan\\Courses\\P2\\My Java Programs\\Eclipse Workspace\\John Lennon\\resources\\Lennon.jpg"));
        	            lblSelectedPhoto.setIcon(new ImageIcon(Utility.getResourcesDir() + selectedPhotoFilename));
        	        }
        	    }
        	});
        }
        return comboBoxPhotoFilename;
    }
    private JScrollPane getScrollPanePhoto() {
        if (scrollPanePhoto == null) {
        	scrollPanePhoto = new JScrollPane();
        	scrollPanePhoto.setViewportView(getLblSelectedPhoto());
        }
        return scrollPanePhoto;
    }
    private JLabel getLblSelectedPhoto() {
        if (lblSelectedPhoto == null) {
        	lblSelectedPhoto = new JLabel("");
        	lblSelectedPhoto.setHorizontalAlignment(SwingConstants.CENTER);
        }
        return lblSelectedPhoto;
    }
}
