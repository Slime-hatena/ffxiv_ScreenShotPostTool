package main;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.ImageIcon;

public class FileCheck {

	static int lastImg = 0;
	static File dir;
	static String filename;

	public static String getPath() {

		return dir.getPath();

	}

	public static File getDir() {
		return dir;
	}

	static {
		dir = new File("C:\\_testdir");
	}

	public static void setDir(File path) {
		dir = path;
	}

	public static void setDir(String path) {
		dir = new File(path);
	}

	public static File latestFile() {

		File[] files = dir.listFiles(new FileFilter() {

			@Override
			public boolean accept(File pathname) {
				String name = pathname.getName();
				if (name.endsWith(".png") || name.endsWith(".jpg")) {
					filename = name;
					return true;
				}

				return false;
			}
		});

		Arrays.sort(files, Collections.reverseOrder());
		lastImg = 0;
		return files[0];
	}

	public static ImageIcon latestImageIcon() {
		return new ImageIcon(latestFile().getPath());

	}

	public static File prevFile() {

		File[] files = dir.listFiles(new FileFilter() {

			@Override
			public boolean accept(File pathname) {
				String name = pathname.getName();
				if (name.endsWith(".png") || name.endsWith(".jpg")) {
					filename = name;
					return true;
				}

				return false;
			}
		});
		if (lastImg >= files.length) {
			lastImg = 0;
		}
		Arrays.sort(files, Collections.reverseOrder());

		return files[lastImg++];
	}

	public static ImageIcon prevImageIcon() {
		return new ImageIcon(prevFile().getPath());

	}

	public static File nextFile() {

		File[] files = dir.listFiles(new FileFilter() {

			@Override
			public boolean accept(File pathname) {
				String name = pathname.getName();
				if (name.endsWith(".png") || name.endsWith(".jpg")) {
					filename = name;
					return true;
				}

				return false;
			}
		});
		if (lastImg <= 0) {
			lastImg = files.length;
		}
		Arrays.sort(files, Collections.reverseOrder());

		return files[--lastImg];
	}

	public static ImageIcon nextImageIcon() {
		return new ImageIcon(nextFile().getPath());

	}

	/*
	 * 選択中のファイルを取得
	 */
	public static File selectedImg() {

		File[] files = dir.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				String name = pathname.getName();
				if (name.endsWith(".png") || name.endsWith(".jpg")) {
					filename = name;
					return true;
				}
				return false;
			}
		});

		return files[lastImg];

	}
}
