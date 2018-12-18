package com.hong.swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class JListDemo {
	JFrame frame = new JFrame("JList Demo");
	@SuppressWarnings("rawtypes")
	JList list;
	DefaultListModel<String> listModel;
	JPanel panel;
	JTextField tf;
	JButton button;

	public static void main(String args[]) {
		JListDemo ld = new JListDemo();
		ld.go();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void go() {
		listModel = new DefaultListModel();

		// 添加可选项
		listModel.addElement("one ");
		listModel.addElement("two ");
		listModel.addElement("three ");
		listModel.addElement("four ");

		list = new JList(listModel); // 创建列表
		list.setFont(new Font("宋体", Font.PLAIN, 12));

		// 将列表放入滚动窗格JScrollPane中
		JScrollPane jsp = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		Container cp = frame.getContentPane();
		cp.add(jsp);

		tf = new JTextField(15); // 输入新可选项的文本域
		tf.setFont(new Font("宋体", Font.PLAIN, 12));
		button = new JButton("add new item");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				listModel.addElement(tf.getText()); // 添加新的可选项
			}
		});
		panel = new JPanel();
		panel.add(tf);
		panel.add(button);

		cp.add(panel, BorderLayout.SOUTH);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		frame.setSize(300, 300);
		frame.setLocationRelativeTo(null);
	}
}
