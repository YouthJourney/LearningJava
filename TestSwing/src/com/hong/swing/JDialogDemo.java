package com.hong.swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JDialogDemo implements ActionListener {
	JFrame frame;
	JDialog dialog;
	JButton button;

	public static void main(String args[]) {
		JDialogDemo jd = new JDialogDemo();
		jd.go();
	}

	public void go() {
		frame = new JFrame("JDialog Demo");
		dialog = new JDialog(frame, "Dialog", true);
		dialog.getContentPane().add(new JLabel("Hello,I'm a Dialog"));
		// 在对话框中添加组件
		dialog.setSize(60, 40);

		button = new JButton("Show Dialog");
		button.addActionListener(this);

		Container cp = frame.getContentPane();
		cp.add(button, BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) { // 显示对话框
		dialog.setVisible(true);
	}
}
