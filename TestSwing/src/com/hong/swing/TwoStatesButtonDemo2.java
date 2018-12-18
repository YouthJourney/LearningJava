package com.hong.swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class TwoStatesButtonDemo2 {
	JFrame frame = new JFrame("Two States Button Demo 2");

	JCheckBox cb1 = new JCheckBox("JCheckBox 1");
	JCheckBox cb2 = new JCheckBox("JCheckBox 2");
	JCheckBox cb3 = new JCheckBox("JCheckBox 3");

	JCheckBox cb4 = new JCheckBox("JCheckBox 4");
	JCheckBox cb5 = new JCheckBox("JCheckBox 5");
	JCheckBox cb6 = new JCheckBox("JCheckBox 6");

	JRadioButton rb1 = new JRadioButton("JRadioButton 1");
	JRadioButton rb2 = new JRadioButton("JRadioButton 2");
	JRadioButton rb3 = new JRadioButton("JRadioButton 3");

	JRadioButton rb4 = new JRadioButton("JRadioButton 4");
	JRadioButton rb5 = new JRadioButton("JRadioButton 5");
	JRadioButton rb6 = new JRadioButton("JRadioButton 6");

	JTextArea ta = new JTextArea(); // 用于显示结果的文本区

	public static void main(String args[]) {
		TwoStatesButtonDemo2 ts = new TwoStatesButtonDemo2();
		ts.go();
	}

	public void go() {
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		JPanel p5 = new JPanel();
		JPanel pa = new JPanel();
		JPanel pb = new JPanel();

		p1.add(cb1);
		p1.add(cb2);
		p1.add(cb3);
		Border etched = BorderFactory.createEtchedBorder();
		Border border = BorderFactory.createTitledBorder(etched, "JCheckBox");
		p1.setBorder(border); // 设置边框

		p2.add(cb4);
		p2.add(cb5);
		p2.add(cb6);
		border = BorderFactory.createTitledBorder(etched, "JCheckBox Group");
		p2.setBorder(border); // 设置边框

		// 创建ButtonGroup按钮组，并在组中添加按钮
		ButtonGroup group1 = new ButtonGroup();
		group1.add(cb4);
		group1.add(cb5);
		group1.add(cb6);

		p3.add(rb1);
		p3.add(rb2);
		p3.add(rb3);
		border = BorderFactory.createTitledBorder(etched, "JRadioButton");
		p3.setBorder(border); // 设置边框

		p4.add(rb4);
		p4.add(rb5);
		p4.add(rb6);
		border = BorderFactory.createTitledBorder(etched, "JRadioButton Group");
		p4.setBorder(border); // 设置边框

		// 创建ButtonGroup按钮组，并在组中添加按钮
		ButtonGroup group2 = new ButtonGroup();
		group2.add(rb4);
		group2.add(rb5);
		group2.add(rb6);

		JScrollPane jp = new JScrollPane(ta);
		p5.setLayout(new BorderLayout());
		p5.add(jp);
		border = BorderFactory.createTitledBorder(etched, "Results");
		p5.setBorder(border); // 设置边框

		ItemListener il = new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				JCheckBox cb = (JCheckBox) e.getSource(); // 取得事件源
				if (cb == cb1) {
					ta.append("\n JCheckBox Button 1 " + cb1.isSelected());
				} else if (cb == cb2) {
					ta.append("\n JCheckBox Button 2 " + cb2.isSelected());
				} else if (cb == cb3) {
					ta.append("\n JCheckBox Button 3 " + cb3.isSelected());
				} else if (cb == cb4) {
					ta.append("\n JCheckBox Button 4 " + cb4.isSelected());
				} else if (cb == cb5) {
					ta.append("\n JCheckBox Button 5 " + cb5.isSelected());
				} else {
					ta.append("\n JCheckBox Button 6 " + cb6.isSelected());
				}
			}
		};

		cb1.addItemListener(il);
		cb2.addItemListener(il);
		cb3.addItemListener(il);
		cb4.addItemListener(il);
		cb5.addItemListener(il);
		cb6.addItemListener(il);

		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JRadioButton rb = (JRadioButton) e.getSource(); // 取得事件源
				if (rb == rb1) {
					ta.append("\n You selected Radio Button 1 " + rb1.isSelected());
				} else if (rb == rb2) {
					ta.append("\n You selected Radio Button 2 " + rb2.isSelected());
				} else if (rb == rb3) {
					ta.append("\n You selected Radio Button 3 " + rb3.isSelected());
				} else if (rb == rb4) {
					ta.append("\n You selected Radio Button 4 " + rb4.isSelected());
				} else if (rb == rb5) {
					ta.append("\n You selected Radio Button 5 " + rb5.isSelected());
				} else {
					ta.append("\n You selected Radio Button 6 " + rb6.isSelected());
				}
			}
		};

		rb1.addActionListener(al);
		rb2.addActionListener(al);
		rb3.addActionListener(al);
		rb4.addActionListener(al);
		rb5.addActionListener(al);
		rb6.addActionListener(al);

		pa.setLayout(new GridLayout(0, 1));
		pa.add(p1);
		pa.add(p2);
		pb.setLayout(new GridLayout(0, 1));
		pb.add(p3);
		pb.add(p4);

		Container cp = frame.getContentPane();
		cp.setLayout(new GridLayout(0, 1));
		cp.add(pa);
		cp.add(pb);
		cp.add(p5);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
