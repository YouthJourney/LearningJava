package com.hong.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class JTextAreaDemo {
	JFrame frame = new JFrame("JTextArea Demo");
	JTextArea ta1, ta2;
	JButton copy, clear;

	public static void main(String args[]) {
		JTextAreaDemo tad = new JTextAreaDemo();
		tad.go();
	}

	public void go() {
		ta1 = new JTextArea(3, 15);
		ta1.setSelectedTextColor(Color.red); // 设置选中文本的颜色为红色
		ta2 = new JTextArea(7, 20);
		ta2.setEditable(false); // 设置为不可编辑的

		// 放置到JScrollPane中
		JScrollPane jsp1 = new JScrollPane(ta1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		JScrollPane jsp2 = new JScrollPane(ta2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		copy = new JButton("Copy");
		// 将ta1中选中文本或所有内容复制到ta2
		copy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (ta1.getSelectedText() != null) {
					ta2.append(ta1.getSelectedText() + "\n");
				} else {
					ta2.append("\n" + ta1.getText() + "\n");
				}
			}
		});

		clear = new JButton("Clear");
		// 将ta2中的内容清空
		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ta2.setText("");
			}
		});

		JPanel panel1 = new JPanel();
		panel1.add(jsp1);
		panel1.add(copy);
		Border etched = BorderFactory.createEtchedBorder();
		panel1.setBorder(etched);

		JPanel panel2 = new JPanel();
		panel2.add(jsp2);
		panel2.add(clear);
		panel2.setBorder(etched);

		Container cp = frame.getContentPane();
		cp.add(panel1, BorderLayout.CENTER);
		cp.add(panel2, BorderLayout.SOUTH);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
