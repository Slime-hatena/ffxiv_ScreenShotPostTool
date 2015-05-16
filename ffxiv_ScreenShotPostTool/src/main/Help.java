package main;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * Copyright (c) 2015 Slime_hatena FFXIV Screen Shot Post Tool by Slime_hatena
 * is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0
 * International License. http://creativecommons.org/licenses/by-nc-sa/4.0/
 * Created on: 2015/05/08
 */

public class Help {

	private JFrame frmSsptHelp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Help window = new Help();
					window.frmSsptHelp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Help() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSsptHelp = new JFrame();
		frmSsptHelp
				.setIconImage(Toolkit
						.getDefaultToolkit()
						.getImage(
								"C:\\Users\\Slime_hatena\\git\\ffxiv_ScreenShotPostTool\\ffxiv_ScreenShotPostTool\\bin\\main\\icon.png"));
		frmSsptHelp.setTitle("sspt Informations");
		frmSsptHelp.setBounds(100, 100, 500, 300);
		frmSsptHelp.getContentPane().setLayout(null);

		JLabel lblWebSite = new JLabel("Web site");
		lblWebSite.setBounds(12, 10, 59, 21);
		frmSsptHelp.getContentPane().add(lblWebSite);

		JButton btnFfxivsspttumblrcom = new JButton("ffxiv-sspt.tumblr.com");
		btnFfxivsspttumblrcom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Desktop desktop = Desktop.getDesktop();
				try {
					desktop.browse(new URI("http://ffxiv-sspt.tumblr.com/"));
				} catch (IOException | URISyntaxException e2) {
					e2.printStackTrace();
				}
			}
		});
		btnFfxivsspttumblrcom.setBounds(83, 10, 219, 21);
		frmSsptHelp.getContentPane().add(btnFfxivsspttumblrcom);

		JLabel lblLibrarys = new JLabel("Libraries");
		lblLibrarys.setBounds(12, 41, 50, 13);
		frmSsptHelp.getContentPane().add(lblLibrarys);

		JButton btnTwitterj = new JButton("Twitter4j");
		btnTwitterj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Desktop desktop = Desktop.getDesktop();
				try {
					desktop.browse(new URI("http://twitter4j.org/"));
				} catch (IOException | URISyntaxException e2) {
					e2.printStackTrace();
				}

			}
		});
		btnTwitterj
				.setIcon(new ImageIcon(
						"C:\\Users\\Slime_hatena\\git\\ffxiv_ScreenShotPostTool\\ffxiv_ScreenShotPostTool\\bin\\main\\powered-by-twitter4j-138x30.png"));
		btnTwitterj.setBounds(83, 41, 131, 32);
		frmSsptHelp.getContentPane().add(btnTwitterj);

		JButton btnMgscalr = new JButton("imgscalr");
		btnMgscalr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Desktop desktop = Desktop.getDesktop();
				try {
					desktop.browse(new URI(
							"http://www.thebuzzmedia.com/software/imgscalr-java-image-scaling-library/"));
				} catch (IOException | URISyntaxException e2) {
					e2.printStackTrace();
				}
			}
		});
		btnMgscalr.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		btnMgscalr.setBounds(83, 83, 131, 32);
		frmSsptHelp.getContentPane().add(btnMgscalr);

		JLabel lblVersion = new JLabel("Version");
		lblVersion.setBounds(12, 125, 50, 13);
		frmSsptHelp.getContentPane().add(lblVersion);

		JLabel label = new JLabel(Start.SoftwereVersion);
		label.setBounds(83, 125, 50, 13);
		frmSsptHelp.getContentPane().add(label);

		JLabel lbln = new JLabel(
				"<html>記載されている会社名・製品名・システム名などは、各社の商標、または登録商標です。 <br>Copyright (C) 2010 - 2015 SQUARE ENIX CO., LTD. All Rights Reserved. </html>");
		lbln.setBounds(21, 199, 451, 52);
		frmSsptHelp.getContentPane().add(lbln);

		JLabel lblAuthor = new JLabel("author　");
		lblAuthor.setBounds(12, 148, 50, 13);
		frmSsptHelp.getContentPane().add(lblAuthor);

		JButton btnslimehatena = new JButton("@Slime_hatena");
		btnslimehatena.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Desktop desktop = Desktop.getDesktop();
				try {
					desktop.browse(new URI("http://twitter.com/Slime_hatena"));
				} catch (IOException | URISyntaxException e2) {
					e2.printStackTrace();
				}
			}

		});
		btnslimehatena.setBounds(83, 148, 131, 21);
		frmSsptHelp.getContentPane().add(btnslimehatena);
	}
}
