package main;

/**
 * Copyright (c) 2015 Slime_hatena FFXIV Screen Shot Post Tool by Slime_hatena
 * is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0
 * International License. http://creativecommons.org/licenses/by-nc-sa/4.0/
 * Created on: 2015/05/08
 */

public class Start {
	static int imgCount = 0;
	static String SoftwereVersion = "020";
	static boolean doUpdate = true;

	public static void main(String[] args) {

		Config.load();
		
		UpdateChecker.main();

		Config.accsesTokenLoad();

		new Frame();

	}

}
