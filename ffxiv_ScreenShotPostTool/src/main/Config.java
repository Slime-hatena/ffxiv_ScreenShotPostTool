package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class Config {

	private static HashMap<String, String> conf = new HashMap<>();

	public static final String KEY_SAVING_DIRECTORY_PATH = "SavingDirectoryPath";
	public static final String KEY_ACCESSTOKEN = "AccessToken";
	public static final String KEY_TOKENSECRET = "TokenSecret";

	public static void load() { // ini生成

		if (!new File("./ffxiv_sspt.ini").exists()) { // iniがなければ

			gen();

		}

		try (BufferedReader in = new BufferedReader(new InputStreamReader(
				new FileInputStream(new File("./ffxiv_sspt.ini"))))) {

			String s;
			while ((s = in.readLine()) != null) {

				String key = s.split("=")[0];
				String val = s.split("=")[1];
				conf.put(key, val);

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void gen() {
		try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(new File("./ffxiv_sspt.ini"))))) {
			out.write("SavingDirectoryPath="
					+ System.getProperty("user.home")
					+ "\\Documents\\My Games\\FINAL FANTASY XIV - A Realm Reborn\\screenshots\n");// 保存先デフォ
			out.write("AccessToken=null\n");// アクセストークン
			out.write("TokenSecret=null\n"); // トークンシークレット

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void save() {

		try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(new File("./ffxiv_sspt.ini"))))) {
			out.write("SavingDirectoryPath="
					+ conf.get(KEY_SAVING_DIRECTORY_PATH) + "\n");// 保存先デフォ
			out.write("AccessToken=" + conf.get(KEY_ACCESSTOKEN) + "\n");// アクセストークン
			out.write("TokenSecret=" + conf.get(KEY_TOKENSECRET) + "\n");// トークンシークレット

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// 以下iniからロード/セーブ処理

	public static String getPath() {

		return conf.get(KEY_SAVING_DIRECTORY_PATH);
	}

	public static String getAccessToken() {

		return conf.get(KEY_ACCESSTOKEN);

	}

	public static String getTokenSecret() {

		return conf.get(KEY_TOKENSECRET);

	}

	public static void setPath(String path) {

		conf.put(KEY_SAVING_DIRECTORY_PATH, path);
		System.out.println("[DEBUG] " + path);
	}

	public static void setAccessToken(String token) {

		conf.put(KEY_ACCESSTOKEN, token);

	}

	public static void setTokenSecret(String Secret) {

		conf.put(KEY_TOKENSECRET, Secret);
	}

	public static void accsesTokenLoad() {

		TwitterFactory factory = new TwitterFactory();
		AccessToken token = new AccessToken(getAccessToken(), getTokenSecret());
		Frame.twitter = factory.getInstance();
		Frame.twitter.setOAuthAccessToken(token);

		System.out.println(token);

	}

}