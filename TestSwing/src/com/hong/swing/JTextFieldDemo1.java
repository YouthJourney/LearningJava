package com.hong.swing;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class JTextFieldDemo1 {
	JFrame frame = new JFrame("JTextField Demo 1");

	public static void main(String args[]) {
		JTextFieldDemo1 tfd1 = new JTextFieldDemo1();
		tfd1.go();
	}

	public void go() {
		JTextField tf11 = new JTextField("a", 9);
		JTextField tf12 = new JTextField("abcdefg", 10);
		JTextField tf13 = new JTextField("abc", 15);

		JPanel panel1 = new JPanel();// 使用缺省的FlowLayout
		panel1.add(tf11);
		panel1.add(tf12);
		panel1.add(tf13);
		Border etched = BorderFactory.createEtchedBorder();
		Border border = BorderFactory.createTitledBorder(etched, "FlowLayout Panel");
		panel1.setBorder(border);

		JTextField tf21 = new JTextField("a", 9);
		JTextField tf22 = new JTextField("abcdefg", 10);
		JTextField tf23 = new JTextField("abc", 15);

		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(0, 1)); // 使用GridLayout
		panel2.add(tf21);
		panel2.add(tf22);
		panel2.add(tf23);
		border = BorderFactory.createTitledBorder(etched, "GridLayout Panel");
		panel2.setBorder(border);

		Container cp = frame.getContentPane();
		cp.setLayout(new GridLayout(0, 1));
		cp.add(panel1);
		cp.add(panel2);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
