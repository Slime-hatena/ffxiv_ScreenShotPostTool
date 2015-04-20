package main;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import twitter4j.StatusUpdate;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class RelativeTwitter {

	public static void tweet() {

		Frame.tweetStatsLabel.setForeground(Color.red);
		Frame.tweetStatsLabel.setText("ツイートに失敗しました・・・再起動してください。");

		StatusUpdate statusUpdate = new StatusUpdate(
				Frame.bodyTextArea.getText() + " "
						+ Frame.tagsTextArer.getText());

		ImageIcon postimg = new ImageIcon(FileCheck.selectedImg().getPath());
		Image instImg = postimg.getImage();
		BufferedImage thmb = new BufferedImage(instImg.getWidth(null),
				instImg.getHeight(null), BufferedImage.TYPE_INT_RGB);
		Graphics g = thmb.getGraphics();
		g.drawImage(instImg, 0, 0, null);

		File resizedImg;

		try {

			resizedImg = File.createTempFile("temp", ".jpg");
			ImageIO.write(thmb, "JPG", resizedImg);

			statusUpdate.setMedia(resizedImg);
		} catch (IOException e2) {
			e2.printStackTrace();
		}

		try {
			Frame.twitter.updateStatus(statusUpdate);

			Frame.tweetStatsLabel.setForeground(Color.BLUE);
			Frame.tweetStatsLabel.setText("ツイートに成功しました！");
		} catch (TwitterException e1) {
			Frame.tweetStatsLabel.setForeground(Color.RED);
			Frame.tweetStatsLabel.setText("ツイートに失敗しました・・・再起動してください。");
			e1.printStackTrace();
		}

	}

	public static void OAuthCertification() {

		Frame.pin = Frame.textField.getText();

		// PINの読み込み
		try {
			Frame.accessToken = Frame.twitter.getOAuthAccessToken(
					Frame.requestToken, Frame.pin);

			Frame.user = Frame.twitter.verifyCredentials();

			Frame.accessToken = Frame.twitter.getOAuthAccessToken(
					Frame.requestToken, Frame.pin);
			Config.setAccessToken(Frame.accessToken.getToken());

			Frame.user = Frame.twitter.verifyCredentials();

			Config.setAccessToken(Frame.accessToken.getToken());
			Config.setTokenSecret(Frame.accessToken.getTokenSecret());
			Config.save();

		} catch (TwitterException e1) {

			e1.printStackTrace();
		}

		Frame.lblaccountName.setText("ログイン中 : @" + Frame.user.getScreenName());

	}

	public static void OAuthIssue() {

		Frame.twitter = TwitterFactory.getSingleton();
		// Twitterオブジェクト作成

		try {
			Frame.requestToken = Frame.twitter.getOAuthRequestToken();
		} catch (TwitterException e2) {
			e2.printStackTrace();
		}
		// リクエストトークン作成

		// アクセストークン作成
		new BufferedReader(new InputStreamReader(System.in));
		// 読み込み準備

		Desktop desktop = Desktop.getDesktop();
		try {
			desktop.browse(new URI(Frame.requestToken.getAuthorizationURL()));
		} catch (IOException | URISyntaxException e2) {
			e2.printStackTrace();
		}

	}

}
