package com.hong.swing;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JLabelDemo {
	JFrame frame = new JFrame("JLabel Demo");
	JLabel label1, label2, label3, label4, label5;

	public static void main(String args[]) {
		JLabelDemo ld = new JLabelDemo();
		ld.go();
	}

	public void go() {
		label1 = new JLabel("Only Text Label");
		label2 = new JLabel("Right Label", JLabel.RIGHT); // 右对齐

		ImageIcon icon = new ImageIcon("dukeWaveRed.gif");

		label3 = new JLabel(icon);
		label3.setVerticalAlignment(JLabel.BOTTOM); // 底部对齐

		label4 = new JLabel("Image and Text", icon, JLabel.LEFT); // 左对齐
		label4.setVerticalAlignment(JLabel.TOP); // 顶部对齐

		// 设置文本信息和图标的相对位置：文本信息在图标的底部，与图标中间对齐
		label4.setVerticalTextPosition(JLabel.BOTTOM);
		label4.setHorizontalTextPosition(JLabel.CENTER);

		label5 = new JLabel("Input your name here");
		JTextField nameField = new JTextField(12);

		JPanel panel = new JPanel();
		panel.add(label5);
		panel.add(nameField);

		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(3, 1)); // 3行1列
		panel2.add(label1);
		panel2.add(label2);
		panel2.add(panel);

		Container cp = frame.getContentPane();
		cp.setLayout(new GridLayout(3, 1));
		cp.add(panel2);
		cp.add(label3);
		cp.add(label4);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 350);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
