package com.hong.swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JFileChooserDemo implements ActionListener {
	JFrame frame = new JFrame("JFileChooser Demo");
	JFileChooser fc = new JFileChooser();
	JTextField tf = new JTextField();
	JButton openButton, saveButton, deleteButton;

	public static void main(String args[]) {
		JFileChooserDemo fcd = new JFileChooserDemo();
		fcd.go();
	}

	public void go() {
		ImageIcon openIcon = new ImageIcon("open.gif");
		openButton = new JButton("Open a File...", openIcon);

		openButton.addActionListener(this);

		ImageIcon saveIcon = new ImageIcon("save.gif");
		saveButton = new JButton("Save a File...", saveIcon);
		saveButton.addActionListener(this);

		ImageIcon deleteIcon = new ImageIcon("delete.gif");
		deleteButton = new JButton("Delete a File...", deleteIcon);
		deleteButton.addActionListener(this);

		JPanel jp = new JPanel();
		jp.add(openButton);
		jp.add(saveButton);
		jp.add(deleteButton);

		Container cp = frame.getContentPane();
		cp.add(jp, BorderLayout.CENTER);
		cp.add(tf, BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 200);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();

		// “打开”文件对话框
		if (button == openButton) {
			int select = fc.showOpenDialog(frame);
			if (select == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				tf.setText("Opening: " + file.getName());
			} else {
				tf.setText("Open command cancelled by user");
			}
		}

		// “保存”文件对话框
		if (button == saveButton) {
			int select = fc.showSaveDialog(frame);
			if (select == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				tf.setText("Saving: " + file.getName());
			} else {
				tf.setText("Save command cancelled by user");
			}
		}

		// “删除”文件对话框
		if (button == deleteButton) {
			int select = fc.showDialog(frame, "删除");
			if (select == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				tf.setText("Deleting: " + file.getName());
			} else {
				tf.setText("Delete command cancelled by user");
			}
		}
	}
}
