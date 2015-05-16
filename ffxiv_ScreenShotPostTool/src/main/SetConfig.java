package main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 * Copyright (c) 2015 Slime_hatena FFXIV Screen Shot Post Tool by Slime_hatena
 * is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0
 * International License. http://creativecommons.org/licenses/by-nc-sa/4.0/
 * Created on: 2015/05/08
 */

public class SetConfig {

	static boolean status = false;

	private JFrame frame;

	JCheckBox checkBox = new JCheckBox("ウィンドウを最前面に表示する");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetConfig window = new SetConfig();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SetConfig() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.getContentPane().setLayout(null);

		JTextArea pathTextArea = new JTextArea();

		JLabel label = new JLabel("スクリーンショットの有るフォルダを選択");
		label.setBounds(12, 10, 240, 13);
		frame.getContentPane().add(label);

		JButton button = new JButton("選択");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				FileCheck.setDir(new Chooser().choose(frame));
				pathTextArea.setText(FileCheck.getPath());

			}
		});

		button.setBounds(243, 6, 84, 21);
		frame.getContentPane().add(button);

		pathTextArea.setText(FileCheck.getPath());

		pathTextArea.setLineWrap(true);
		pathTextArea.setEnabled(false);
		pathTextArea.setEditable(false);
		pathTextArea.setBounds(12, 33, 410, 47);
		frame.getContentPane().add(pathTextArea);

		JCheckBox checkBox = new JCheckBox("常に最前面に表示");
		checkBox.setBounds(12, 86, 142, 21);
		frame.getContentPane().add(checkBox);

		checkBox.setBounds(12, 86, 200, 21);

		JButton button_1 = new JButton("適用");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				status = checkBox.isSelected();



			}
		});
		button_1.setBounds(331, 230, 91, 21);
		frame.getContentPane().add(button_1);

	}
}
