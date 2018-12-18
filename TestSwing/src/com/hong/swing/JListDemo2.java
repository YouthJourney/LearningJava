package com.hong.swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JListDemo2 {
	JFrame frame = new JFrame("JList Demo 2");
	@SuppressWarnings("rawtypes")
	JList dataList;

	JPanel panel = new JPanel();
	JRadioButton rb1, rb2, rb3;
	JTextArea ta = new JTextArea(3, 40);

	public static void main(String args[]) {
		JListDemo2 ld2 = new JListDemo2();
		ld2.go();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void go() {
		String[] data = { "Monday", "Tuesday", "Wednesday", "Thusday", "Friday", "Saturday", "Sunday" };
		dataList = new JList(data);

		dataList.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					@SuppressWarnings("deprecation")
					Object[] selections = dataList.getSelectedValues();
					String values = "\n";
					for (int i = 0; i < selections.length; i++) {
						values = values + selections[i] + "  ";
					}
					ta.append(values);
				}
			}
		});
		dataList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) // 单击
				{ // 根据坐标位置得到列表可选项序号
					int index = dataList.locationToIndex(e.getPoint());
					ta.append("\nClicked on Item " + index);
				}

				if (e.getClickCount() == 2) // 双击
				{
					int index = dataList.locationToIndex(e.getPoint());
					ta.append("\nDouble clicked on Item " + index);
				}
			}
		});

		// 将列表放入滚动窗格JScrollPane中
		JScrollPane jsp = new JScrollPane(dataList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		Container cp = frame.getContentPane();
		cp.add(jsp, BorderLayout.CENTER);

		rb1 = new JRadioButton("SINGLE SELECTION");
		rb2 = new JRadioButton("SINGLE_INTERVAL_SELECTION");
		rb3 = new JRadioButton("MULTIPLE_INTERVAL_SELECTION", true);
		ButtonGroup group = new ButtonGroup();
		group.add(rb1);
		group.add(rb2);
		group.add(rb3);

		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JRadioButton rb = (JRadioButton) e.getSource(); // 取得事件源
				if (rb == rb1) {
					dataList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				} else if (rb == rb2) {
					dataList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
				} else {
					dataList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
				}
			}
		};

		rb1.addActionListener(al);
		rb2.addActionListener(al);
		rb3.addActionListener(al);

		panel.setLayout(new GridLayout(3, 1));
		panel.add(rb1);
		panel.add(rb2);
		panel.add(rb3);

		cp.add(panel, BorderLayout.EAST);
		JScrollPane jsp2 = new JScrollPane(ta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		cp.add(jsp2, BorderLayout.SOUTH);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
