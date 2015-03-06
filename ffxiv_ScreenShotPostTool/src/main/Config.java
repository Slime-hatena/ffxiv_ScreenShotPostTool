package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Config {

	public static void load() {

		File ini = new File("./ffxiv_sspt.ini");
		if (!ini.exists()) {
			try {
				FileOutputStream out = new FileOutputStream(new File(
						"./ffxiv_sspt.ini"));
				out.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			FileInputStream in = new FileInputStream(new File(
					"./ffxiv_sspt.ini"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void save() {

	}

}
