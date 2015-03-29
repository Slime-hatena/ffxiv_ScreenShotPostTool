package main;

import java.awt.Component;
import java.io.File;

import javax.swing.JFileChooser;

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
