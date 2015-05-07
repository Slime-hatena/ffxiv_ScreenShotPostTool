package main;

import java.awt.Component;
import java.io.File;

import javax.swing.JFileChooser;

/**
 *
 *  Copyright (c) 2015 Slime_hatena
 *  FFXIV Screen Shot Post Tool by Slime_hatena is licensed
 *    under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License.
 *    http://creativecommons.org/licenses/by-nc-sa/4.0/
 *    Created on: 2015/05/08
 */


public class Chooser {

	public File choose(Component parent) {

		JFileChooser filepath_chooser = new JFileChooser();
		filepath_chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		filepath_chooser.setDialogType(JFileChooser.OPEN_DIALOG);

		int selected = filepath_chooser.showOpenDialog(parent);
		if (selected == JFileChooser.APPROVE_OPTION) {

			Config.setPath(filepath_chooser.getSelectedFile() + "");
			Config.save();
			return filepath_chooser.getSelectedFile();

		}
		return new File("C:\\");

	}
}
