package main;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import twitter4j.Twitter;
import twitter4j.User;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

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

		JFrame frame = new JFrame("FFXIV ScreenShotPostTool");
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(700, 500);
		frame.setVisible(true);

		JLabel imgPrev = new JLabel();
		imgPrev.setBounds(314, 109, 355, 220);

		frame.getContentPane().add(imgPrev);

		JTextArea pathTextArea = new JTextArea();
		pathTextArea.setEditable(false);
		pathTextArea.setEnabled(false);
		pathTextArea.setBounds(125, 33, 544, 56);
		pathTextArea.setText((FileCheck.getPath()));
		frame.getContentPane().add(pathTextArea);
		pathTextArea.setLineWrap(true);

		JLabel infoLabel1 = new JLabel("スクリーンショットの有るファイルパスを選択");
		infoLabel1.setBounds(12, 10, 377, 13);
		frame.getContentPane().add(infoLabel1);

		tagsTextArer = new JTextField();
		tagsTextArer.setBounds(22, 234, 280, 19);
		tagsTextArer.setText("#FF14 #FFXIV");
		frame.getContentPane().add(tagsTextArer);
		tagsTextArer.setColumns(10);

		JButton prevButton = new JButton("<<");
		prevButton.setBounds(324, 339, 91, 21);
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
		frame.getContentPane().add(prevButton);

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
		nextButton.setBounds(578, 339, 91, 21);
		frame.getContentPane().add(nextButton);

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
		latestButton.setBounds(451, 339, 91, 21);
		frame.getContentPane().add(latestButton);

		lblaccountName = new JLabel("");
		lblaccountName.setBounds(12, 448, 400, 13);
		frame.getContentPane().add(lblaccountName);

		JLabel lblNewLabel_1 = new JLabel("Ver 0.20");
		lblNewLabel_1.setBounds(619, 448, 63, 13);
		frame.getContentPane().add(lblNewLabel_1);

		JButton oAtuhButton1 = new JButton("①Twitter認証ページを開く");
		oAtuhButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				RelativeTwitter.OAuthIssue();

			}
		});
		oAtuhButton1.setBounds(12, 286, 221, 21);
		frame.getContentPane().add(oAtuhButton1);

		JLabel configLabel = new JLabel("設定");
		configLabel.setBounds(12, 263, 208, 13);
		frame.getContentPane().add(configLabel);

		JLabel oAtuhTextArea = new JLabel("②Pinを入力");
		oAtuhTextArea.setBounds(22, 313, 73, 13);
		frame.getContentPane().add(oAtuhTextArea);

		textField = new JTextField();
		textField.setBounds(96, 313, 137, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JButton oAtuhButton2 = new JButton("③認証");
		oAtuhButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				RelativeTwitter.OAuthCertification();

			}

		});
		oAtuhButton2.setBounds(12, 339, 221, 21);
		frame.getContentPane().add(oAtuhButton2);

		JButton selectionPath = new JButton("選択");
		selectionPath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				FileCheck.setDir(new Chooser().choose(frame));
				pathTextArea.setText(FileCheck.getPath());

			}
		});
		selectionPath.setBounds(22, 34, 91, 21);
		frame.getContentPane().add(selectionPath);

		bodyTextArea = new JTextArea();
		bodyTextArea.setColumns(10);
		bodyTextArea.setBounds(22, 120, 280, 81);
		bodyTextArea.setLineWrap(true);
		frame.getContentPane().add(bodyTextArea);

		tweetStatsLabel = new JLabel("");
		tweetStatsLabel.setBounds(286, 419, 262, 21);
		frame.getContentPane().add(tweetStatsLabel);

		JLabel bodyLabel = new JLabel("本文");
		bodyLabel.setBounds(12, 98, 50, 13);
		frame.getContentPane().add(bodyLabel);

		JButton tweetButton = new JButton("つぶやく");
		tweetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

		RelativeTwitter.tweet();


			}
		});
		tweetButton.setBounds(551, 401, 118, 36);
		frame.getContentPane().add(tweetButton);

		JLabel tagsLabel = new JLabel("ハッシュタグ");
		tagsLabel.setBounds(12, 211, 137, 13);
		frame.getContentPane().add(tagsLabel);

		presentCounts = new JLabel("");
		presentCounts.setFont(new Font("MS UI Gothic", Font.PLAIN, 18));
		presentCounts.setHorizontalAlignment(SwingConstants.RIGHT);
		presentCounts.setBounds(412, 370, 73, 21);
		frame.getContentPane().add(presentCounts);

		maxCounts = new JLabel("");
		maxCounts.setFont(new Font("MS UI Gothic", Font.PLAIN, 18));
		maxCounts.setHorizontalAlignment(SwingConstants.LEFT);
		maxCounts.setBounds(508, 370, 111, 21);
		frame.getContentPane().add(maxCounts);

		JLabel qtyLabel = new JLabel("/");
		qtyLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		qtyLabel.setFont(new Font("MS UI Gothic", Font.PLAIN, 18));
		qtyLabel.setBounds(482, 370, 19, 21);
		frame.getContentPane().add(qtyLabel);

		JButton helpButton = new JButton("?");
		helpButton.setBounds(657, 2, 37, 21);
		frame.getContentPane().add(helpButton);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(700, 500);
		frame.setVisible(true);

	}
}
