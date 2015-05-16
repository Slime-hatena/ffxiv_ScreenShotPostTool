package main;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Copyright (c) 2015 Slime_hatena FFXIV Screen Shot Post Tool by Slime_hatena
 * is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0
 * International License. http://creativecommons.org/licenses/by-nc-sa/4.0/
 * Created on: 2015/05/08
 */

public class UpdateChecker {
	static String new_veasion;

	public static void main() {
		try {
			URL url = new URL(
					"https://dl.dropboxusercontent.com/s/9uy0wll3sc8862h/DONT_MOVE__spt_checkpoint.txt");
			InputStream v = url.openStream();

			BufferedReader d = new BufferedReader(new InputStreamReader(v));
			new_veasion = d.readLine();

		} catch (Exception e) {
			System.err.println(e);
		}

		System.out.println("ソフトバージョン" + Start.SoftwereVersion);
		System.out.println("最新バージョン" + new_veasion);

		if (Start.SoftwereVersion.equals(new_veasion)) {
			Start.doUpdate = false;
			System.out.println("こうしんないよ");

			return;
		}

	}
}
