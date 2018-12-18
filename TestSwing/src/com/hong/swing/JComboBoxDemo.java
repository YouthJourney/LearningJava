package com.hong.swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class JComboBoxDemo {
	JFrame frame = new JFrame("JComboBox Demo");
	@SuppressWarnings("rawtypes")
	JComboBox jcb1, jcb2;
	JTextArea ta = new JTextArea(0, 30); // 用于显示结果的文本区

	public static void main(String args[]) {
		JComboBoxDemo cbd = new JComboBoxDemo();
		cbd.go();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void go() { // 创建内部JPanel容器
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();

		String[] itemList = { "One", "Two", "Three", "Four", "Five" };
		jcb1 = new JComboBox(itemList);
		jcb1.setSelectedIndex(3); // 设置第4个可选项为当前的显示项

		p1.add(jcb1);
		Border etched = BorderFactory.createEtchedBorder();
		Border border = BorderFactory.createTitledBorder(etched, "Uneditable JComboBox");
		p1.setBorder(border);

		jcb2 = new JComboBox();

		// 添加4个可选项
		jcb2.addItem("Six");
		jcb2.addItem("Seven");
		jcb2.addItem("Eight");
		jcb2.addItem("nine");

		// 将jcb2设置为可编辑的
		jcb2.setEditable(true);

		p2.add(jcb2);
		border = BorderFactory.createTitledBorder(etched, "Editable JComboBox");
		p2.setBorder(border);

		JScrollPane jp = new JScrollPane(ta);
		p3.setLayout(new BorderLayout());
		p3.add(jp);
		border = BorderFactory.createTitledBorder(etched, "Results");
		p3.setBorder(border);

		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox jcb = (JComboBox) e.getSource();

				if (jcb == jcb1) { // 将选项插入jcb2的第一个位置
					jcb2.insertItemAt(jcb1.getSelectedItem(), 0);
					ta.append("\nItem " + jcb1.getSelectedItem() + "  inserted");
				} else {
					ta.append("\n You selected item : " + jcb2.getSelectedItem());
					jcb2.addItem(jcb2.getSelectedItem());
				}
			}
		};

		jcb1.addActionListener(al);
		jcb2.addActionListener(al);

		p4.setLayout(new GridLayout(0, 1));
		p4.add(p1);
		p4.add(p2);

		Container cp = frame.getContentPane();
		cp.setLayout(new GridLayout(0, 1));
		cp.add(p4);
		cp.add(p3);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
