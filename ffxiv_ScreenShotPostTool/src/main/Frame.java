package main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import twitter4j.Twitter;
import twitter4j.User;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

/**
 *
 *  Copyright (c) 2015 Slime_hatena
 *  FFXIV Screen Shot Post Tool by Slime_hatena is licensed
 *    under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License.
 *    http://creativecommons.org/licenses/by-nc-sa/4.0/
 *    Created on: 2015/05/08
 */




public class Frame {
	static JFrame frmScreenshotposttool = new JFrame("FFXIV ScreenShotPostTool");
	static JTextField tagsTextArer;
	static JTextField textField;
	static JTextArea bodyTextArea;
	private JLabel maxCounts;
	private JLabel presentCounts;
	static JLabel tweetStatsLabel;
	static JLabel qtyLabel = new JLabel("");
	static User user;
	static Twitter twitter;
	static String pin = null;
	static RequestToken requestToken = null;
	static AccessToken accessToken = null;





	public Frame() {

		try {
			UIManager.setLookAndFeel(NimbusLookAndFeel.class.getName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}


		frmScreenshotposttool.setTitle("ssPostTool");

		frmScreenshotposttool.getContentPane().setLayout(null);
		frmScreenshotposttool.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Slime_hatena\\git\\ffxiv_ScreenShotPostTool\\ffxiv_ScreenShotPostTool\\bin\\main\\icon.png"));
		frmScreenshotposttool.setLocationByPlatform(true);
		frmScreenshotposttool.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmScreenshotposttool.setResizable(false);
		frmScreenshotposttool.setSize(210, 365);

		frmScreenshotposttool.setVisible(true);

		JLabel imgPrev = new JLabel();
		imgPrev.setBounds(5, 100, 190, 120);

		frmScreenshotposttool.getContentPane().add(imgPrev);

		tagsTextArer = new JTextField();
		tagsTextArer.setBounds(30, 75, 165, 21);
		tagsTextArer.setText("#FF14share #FF14");
		frmScreenshotposttool.getContentPane().add(tagsTextArer);
		tagsTextArer.setColumns(10);

		JButton prevButton = new JButton("<<");
		prevButton.setBounds(5, 225, 50, 20);
		prevButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imgPrev.setIcon(new ImageIcon(FileCheck
						.prevImageIcon()
						.getImage()
						.getScaledInstance(imgPrev.getWidth(),
								imgPrev.getHeight(), Image.SCALE_SMOOTH)));
				maxCounts.setText(FileCheck.getLength() + "");
				presentCounts.setText((FileCheck.getLength() - FileCheck.lastImg)
						+ "");
				frmScreenshotposttool.setAlwaysOnTop(SetConfig.status);
			}
		});
		frmScreenshotposttool.getContentPane().add(prevButton);

		JButton nextButton = new JButton(">>");
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				imgPrev.setIcon(new ImageIcon(FileCheck
						.nextImageIcon()
						.getImage()
						.getScaledInstance(imgPrev.getWidth(),
								imgPrev.getHeight(), Image.SCALE_SMOOTH)));
				maxCounts.setText(FileCheck.getLength() + "");
				presentCounts.setText((FileCheck.getLength() - FileCheck.lastImg)
						+ "");
				frmScreenshotposttool.setAlwaysOnTop(SetConfig.status);
			}
		});
		nextButton.setBounds(150, 225, 50, 20);
		frmScreenshotposttool.getContentPane().add(nextButton);

		JButton latestButton = new JButton("最新");
		latestButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				qtyLabel.setText("/");
				imgPrev.setIcon(new ImageIcon(FileCheck
						.latestImageIcon()
						.getImage()
						.getScaledInstance(imgPrev.getWidth(),
								imgPrev.getHeight(), Image.SCALE_SMOOTH)));
				maxCounts.setText(FileCheck.getLength() + "");
				presentCounts.setText((FileCheck.getLength() - FileCheck.lastImg)
						+ "");

				frmScreenshotposttool.setAlwaysOnTop(SetConfig.status);

			}
		});
		latestButton.setBounds(60, 225, 85, 20);
		frmScreenshotposttool.getContentPane().add(latestButton);

		bodyTextArea = new JTextArea();
		bodyTextArea.setColumns(10);
		bodyTextArea.setBounds(10, 17, 185, 50);
		bodyTextArea.setLineWrap(true);
		frmScreenshotposttool.getContentPane().add(bodyTextArea);

		JLabel bodyLabel = new JLabel("本文");
		bodyLabel.setBounds(5, 3, 50, 13);
		frmScreenshotposttool.getContentPane().add(bodyLabel);

		JButton tweetButton = new JButton("つぶやく");
		tweetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				RelativeTwitter.tweet();


				bodyTextArea.setText("");

			}
		});
		tweetButton.setBounds(112, 275, 85, 30);
		frmScreenshotposttool.getContentPane().add(tweetButton);

		JLabel tagsLabel = new JLabel("タグ");
		tagsLabel.setBounds(5, 77, 32, 13);
		frmScreenshotposttool.getContentPane().add(tagsLabel);

		presentCounts = new JLabel("");
		presentCounts.setFont(new Font("MS UI Gothic", Font.PLAIN, 14));
		presentCounts.setHorizontalAlignment(SwingConstants.RIGHT);
		presentCounts.setBounds(16, 248, 85, 21);
		frmScreenshotposttool.getContentPane().add(presentCounts);

		maxCounts = new JLabel("");
		maxCounts.setFont(new Font("MS UI Gothic", Font.PLAIN, 14));
		maxCounts.setHorizontalAlignment(SwingConstants.LEFT);
		maxCounts.setBounds(112, 248, 90, 21);
		frmScreenshotposttool.getContentPane().add(maxCounts);


		qtyLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		qtyLabel.setFont(new Font("MS UI Gothic", Font.PLAIN, 16));
		qtyLabel.setBounds(95, 248, 15, 21);
		frmScreenshotposttool.getContentPane().add(qtyLabel);

														JLabel doUpdate = new JLabel("");
														doUpdate.setBounds(5, 191, 154, 29);
														frmScreenshotposttool.getContentPane().add(doUpdate);
														doUpdate.setForeground(Color.BLUE);

														if (Start.doUpdate == true){
															doUpdate.setText("アップデートがあります！");
														}

		frmScreenshotposttool.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmScreenshotposttool.setResizable(false);

		JMenuBar menuBar = new JMenuBar();
		frmScreenshotposttool.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("認証");
		menuBar.add(mnNewMenu);

				JButton oAtuhButton1 = new JButton("①Twitter認証ページを開く");
				mnNewMenu.add(oAtuhButton1);

						JLabel oAtuhTextArea = new JLabel("②Pinを入力");
						mnNewMenu.add(oAtuhTextArea);

								textField = new JTextField();
								mnNewMenu.add(textField);
								textField.setColumns(10);

										JButton oAtuhButton2 = new JButton("③認証");
										mnNewMenu.add(oAtuhButton2);

										JMenu mnNewMenu_1 = new JMenu("設定");
										menuBar.add(mnNewMenu_1);

												JButton button = new JButton("設定");
												button.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent e) {

														SetConfig.main(null);
													}
												});
												mnNewMenu_1.add(button);

												JButton helpButton = new JButton("license");
												mnNewMenu_1.add(helpButton);
												helpButton.setFont(new Font("MS UI Gothic", Font.PLAIN, 12));

														tweetStatsLabel = new JLabel("");
														menuBar.add(tweetStatsLabel);
												helpButton.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent e) {

														Help.main(null);

													}
												});
										oAtuhButton2.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {

												RelativeTwitter.OAuthCertification();

											}

										});
										oAtuhButton1.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {

												RelativeTwitter.OAuthIssue();

											}
										});
		frmScreenshotposttool.setVisible(true);

	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}



		});
	}








}
