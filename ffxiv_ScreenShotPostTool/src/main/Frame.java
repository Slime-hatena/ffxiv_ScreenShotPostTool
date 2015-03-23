package main;

import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import twitter4j.Status;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

public class Frame {
	private JTextField txtffxivff;
	private JTextField textField;
	private JTextArea textField_1;
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

		JTextArea txtrCusersdocumentsmy = new JTextArea();
		txtrCusersdocumentsmy.setEditable(false);
		txtrCusersdocumentsmy.setEnabled(false);
		txtrCusersdocumentsmy.setBounds(125, 33, 544, 56);
		txtrCusersdocumentsmy
				.setText((FileCheck.getPath()));
		frame.getContentPane().add(txtrCusersdocumentsmy);
		txtrCusersdocumentsmy.setLineWrap(true);

		JLabel lblNewLabel = new JLabel("スクリーンショットの有るファイルパスを選択");
		lblNewLabel.setBounds(12, 10, 377, 13);
		frame.getContentPane().add(lblNewLabel);

		txtffxivff = new JTextField();
		txtffxivff.setBounds(22, 234, 280, 19);
		txtffxivff.setText("#FF14 #FFXIV");
		frame.getContentPane().add(txtffxivff);
		txtffxivff.setColumns(10);

		JButton btnNewButton = new JButton("<<");
		btnNewButton.setBounds(324, 339, 91, 21);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imgPrev.setIcon(new ImageIcon(FileCheck
						.prevImageIcon()
						.getImage()
						.getScaledInstance(imgPrev.getWidth(),
								imgPrev.getHeight(), Image.SCALE_SMOOTH)));

			}
		});
		frame.getContentPane().add(btnNewButton);

		JButton button = new JButton(">>");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				imgPrev.setIcon(new ImageIcon(FileCheck
						.nextImageIcon()
						.getImage()
						.getScaledInstance(imgPrev.getWidth(),
								imgPrev.getHeight(), Image.SCALE_SMOOTH)));

			}
		});
		button.setBounds(578, 339, 91, 21);
		frame.getContentPane().add(button);

		JButton button_1 = new JButton("最新");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				imgPrev.setIcon(new ImageIcon(FileCheck
						.latestImageIcon()
						.getImage()
						.getScaledInstance(imgPrev.getWidth(),
								imgPrev.getHeight(), Image.SCALE_SMOOTH)));

			}
		});
		button_1.setBounds(451, 339, 91, 21);
		frame.getContentPane().add(button_1);

		JLabel lblaccountName = new JLabel("");
		lblaccountName.setBounds(12, 448, 400, 13);
		frame.getContentPane().add(lblaccountName);

		JLabel lblNewLabel_1 = new JLabel("Ver 0.12");
		lblNewLabel_1.setBounds(619, 448, 63, 13);
		frame.getContentPane().add(lblNewLabel_1);

		JButton btnNewButton_1 = new JButton("①Twitter認証ページを開く");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				twitter = TwitterFactory.getSingleton();
				// Twitterオブジェクト作成


				try {
					requestToken = twitter.getOAuthRequestToken();
				} catch (TwitterException e2) {
					// TODO 自動生成された catch ブロック
					e2.printStackTrace();
				}
				// リクエストトークン作成

				// アクセストークン作成
				BufferedReader br = new BufferedReader(new InputStreamReader(
						System.in));
				// 読み込み準備

				Desktop desktop = Desktop.getDesktop();
				try {
					desktop.browse(new URI(requestToken.getAuthorizationURL()));
				} catch (IOException | URISyntaxException e2) {
					// TODO 自動生成された catch ブロック
					e2.printStackTrace();
				}

				// URLの表示

			}
		});
		btnNewButton_1.setBounds(12, 286, 221, 21);
		frame.getContentPane().add(btnNewButton_1);

		JLabel label = new JLabel("設定");
		label.setBounds(12, 263, 208, 13);
		frame.getContentPane().add(label);

		JLabel lblpin = new JLabel("②Pinを入力");
		lblpin.setBounds(22, 313, 73, 13);
		frame.getContentPane().add(lblpin);

		textField = new JTextField();
		textField.setBounds(96, 313, 137, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JButton button_2 = new JButton("③認証");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				pin = textField.getText();

				// PINの読み込み
				try {
					accessToken = twitter.getOAuthAccessToken(requestToken, pin);

					user = twitter.verifyCredentials();

					accessToken = twitter.getOAuthAccessToken(requestToken, pin);
					Config.setAccessToken(accessToken.getToken());

					user = twitter.verifyCredentials();

					Config.setAccessToken(accessToken.getToken());
					Config.setTokenSecret(accessToken.getTokenSecret());
					Config.save();

				} catch (TwitterException e1) {
					// TODO 自動生成された catch ブロック
					e1.printStackTrace();
				}

				String TwitterSn = user.getScreenName();
				lblaccountName.setText("ログイン中 : @" + TwitterSn);

			}

		});
		button_2.setBounds(12, 339, 221, 21);
		frame.getContentPane().add(button_2);

		JButton button_3 = new JButton("選択");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				FileCheck.setDir(new Chooser().choose(frame));
				txtrCusersdocumentsmy.setText(FileCheck.getPath());

			}
		});
		button_3.setBounds(22, 34, 91, 21);
		frame.getContentPane().add(button_3);

		textField_1 = new JTextArea();
		textField_1.setText("");
		textField_1.setColumns(10);
		textField_1.setBounds(22, 120, 280, 81);
		textField_1.setLineWrap(true);
		frame.getContentPane().add(textField_1);

		JLabel label_1 = new JLabel("本文");
		label_1.setBounds(12, 98, 50, 13);
		frame.getContentPane().add(label_1);

		JButton button_4 = new JButton("つぶやく");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StatusUpdate statusUpdate = new StatusUpdate(textField_1.getText());

				ImageIcon postimg = new ImageIcon(FileCheck.selectedImg().getPath());
				Image instImg = postimg.getImage();
				BufferedImage thmb =new BufferedImage(instImg.getWidth(null),instImg.getHeight(null),BufferedImage.TYPE_INT_RGB);
				Graphics g = thmb.getGraphics();
				g.drawImage(instImg,0,0,null);

				File resizedImg;
				try {
					resizedImg = File.createTempFile("temp",".jpg");
					ImageIO.write(thmb, "JPG",resizedImg);

					statusUpdate.setMedia(resizedImg);
				} catch (IOException e2) {
					// TODO 自動生成された catch ブロック
					e2.printStackTrace();
				}



				try {
					Status status = twitter.updateStatus(statusUpdate);
				} catch (TwitterException e1) {
					// TODO 自動生成された catch ブロック
					e1.printStackTrace();
				}
			}
		});
		button_4.setBounds(551, 402, 118, 36);
		frame.getContentPane().add(button_4);

		JLabel label_2 = new JLabel("ハッシュタグ");
		label_2.setBounds(12, 211, 137, 13);
		frame.getContentPane().add(label_2);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(700, 500);
		frame.setVisible(true);

	}
}
