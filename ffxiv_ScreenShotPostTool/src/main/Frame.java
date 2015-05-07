package main;

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
	static JTextField tagsTextArer;
	static JTextField textField;
	static JTextArea bodyTextArea;
	private JLabel maxCounts;
	private JLabel presentCounts;
	static JLabel tweetStatsLabel;
	static JLabel lblaccountName;
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

		JFrame frmScreenshotposttool = new JFrame("FFXIV ScreenShotPostTool");
		frmScreenshotposttool.setTitle("ScreenShotPostTool");

		frmScreenshotposttool.getContentPane().setLayout(null);
		Toolkit tk = Toolkit.getDefaultToolkit();
		frmScreenshotposttool.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Slime_hatena\\git\\ffxiv_ScreenShotPostTool\\ffxiv_ScreenShotPostTool\\bin\\main\\icon.png"));
		frmScreenshotposttool.setLocationByPlatform(true);
		frmScreenshotposttool.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmScreenshotposttool.setResizable(false);
		frmScreenshotposttool.setSize(300, 500);

		frmScreenshotposttool.setVisible(true);

		JLabel imgPrev = new JLabel();
		imgPrev.setBounds(12, 186, 274, 132);

		frmScreenshotposttool.getContentPane().add(imgPrev);

		tagsTextArer = new JTextField();
		tagsTextArer.setBounds(56, 157, 230, 30);
		tagsTextArer.setText("#FF14share #FF14");
		frmScreenshotposttool.getContentPane().add(tagsTextArer);
		tagsTextArer.setColumns(10);

		JButton prevButton = new JButton("<<");
		prevButton.setBounds(12, 328, 73, 21);
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
			}
		});
		nextButton.setBounds(213, 328, 73, 21);
		frmScreenshotposttool.getContentPane().add(nextButton);

		JButton latestButton = new JButton("最新");
		latestButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				imgPrev.setIcon(new ImageIcon(FileCheck
						.latestImageIcon()
						.getImage()
						.getScaledInstance(imgPrev.getWidth(),
								imgPrev.getHeight(), Image.SCALE_SMOOTH)));
				maxCounts.setText(FileCheck.getLength() + "");
				presentCounts.setText((FileCheck.getLength() - FileCheck.lastImg)
						+ "");
			}
		});
		latestButton.setBounds(97, 328, 104, 21);
		frmScreenshotposttool.getContentPane().add(latestButton);

		lblaccountName = new JLabel("");
		lblaccountName.setBounds(12, 448, 400, 13);
		frmScreenshotposttool.getContentPane().add(lblaccountName);

		bodyTextArea = new JTextArea();
		bodyTextArea.setColumns(10);
		bodyTextArea.setBounds(12, 88, 274, 50);
		bodyTextArea.setLineWrap(true);
		frmScreenshotposttool.getContentPane().add(bodyTextArea);

		JLabel bodyLabel = new JLabel("本文");
		bodyLabel.setBounds(23, 69, 50, 13);
		frmScreenshotposttool.getContentPane().add(bodyLabel);

		JButton tweetButton = new JButton("つぶやく");
		tweetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				RelativeTwitter.tweet();

			}
		});
		tweetButton.setBounds(168, 402, 118, 36);
		frmScreenshotposttool.getContentPane().add(tweetButton);

		JLabel tagsLabel = new JLabel("タグ");
		tagsLabel.setBounds(12, 160, 32, 13);
		frmScreenshotposttool.getContentPane().add(tagsLabel);

		presentCounts = new JLabel("");
		presentCounts.setFont(new Font("MS UI Gothic", Font.PLAIN, 18));
		presentCounts.setHorizontalAlignment(SwingConstants.RIGHT);
		presentCounts.setBounds(12, 359, 125, 21);
		frmScreenshotposttool.getContentPane().add(presentCounts);

		maxCounts = new JLabel("");
		maxCounts.setFont(new Font("MS UI Gothic", Font.PLAIN, 18));
		maxCounts.setHorizontalAlignment(SwingConstants.LEFT);
		maxCounts.setBounds(160, 359, 111, 21);
		frmScreenshotposttool.getContentPane().add(maxCounts);

		JLabel qtyLabel = new JLabel("/");
		qtyLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		qtyLabel.setFont(new Font("MS UI Gothic", Font.PLAIN, 18));
		qtyLabel.setBounds(135, 359, 19, 21);
		frmScreenshotposttool.getContentPane().add(qtyLabel);

										JLabel infoLabel1 = new JLabel("スクリーンショットの有るフォルダを選択");
										infoLabel1.setBounds(12, 2, 274, 13);
										frmScreenshotposttool.getContentPane().add(infoLabel1);

												JButton selectionPath = new JButton("選択");
												selectionPath.setBounds(12, 17, 84, 21);
												frmScreenshotposttool.getContentPane().add(selectionPath);

														JTextArea pathTextArea = new JTextArea();
														pathTextArea.setBounds(108, 16, 178, 62);
														frmScreenshotposttool.getContentPane().add(pathTextArea);
														pathTextArea.setEditable(false);
														pathTextArea.setEnabled(false);
														pathTextArea.setText((FileCheck.getPath()));
														pathTextArea.setLineWrap(true);
						selectionPath.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {

								FileCheck.setDir(new Chooser().choose(frmScreenshotposttool));
								pathTextArea.setText(FileCheck.getPath());

							}
						});

		frmScreenshotposttool.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmScreenshotposttool.setResizable(false);

		JMenuBar menuBar = new JMenuBar();
		frmScreenshotposttool.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Twitter認証");
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

										JMenu mnNewMenu_1 = new JMenu("ヘルプ");
										menuBar.add(mnNewMenu_1);

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
