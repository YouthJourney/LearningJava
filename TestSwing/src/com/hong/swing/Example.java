package com.hong.swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Example implements ActionListener {
	JFrame f;
	JButton b;
	JTextArea ta;
	JScrollPane sp;

	public static void main(String args[]) {
		Example exam = new Example();
		exam.go();
	}

	public void go() {
		f = new JFrame("Example");
		b = new JButton("Get Available Font Family Names");

		// 设置按钮的前景色、背景色和字体
		b.setForeground(Color.blue);
		b.setBackground(Color.green);
		Font font = new Font("SansSerif", Font.BOLD + Font.ITALIC, 18);
		b.setFont(font);

		b.addActionListener(this);
		f.getContentPane().add(b, "South");

		ta = new JTextArea();

		// 设置文本区的前景色、背景色和字体
		ta.setForeground(Color.blue);
		ta.setBackground(Color.green);
		font = new Font("Dialog", Font.BOLD, 14);
		ta.setFont(font);

		sp = new JScrollPane(ta, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		f.getContentPane().add(sp, "Center");

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(350, 350);
		f.setVisible(true);
		f.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ta.setText("");
		String[] fontFamilyNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();// 获取字体名列表
		ta.setText("number = " + fontFamilyNames.length + "\n");
		for (int i = 0; i < fontFamilyNames.length; i++) {
			ta.append(fontFamilyNames[i] + "\n");
		}
	}
}
