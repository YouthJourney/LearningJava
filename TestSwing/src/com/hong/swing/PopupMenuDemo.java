package com.hong.swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;

public class PopupMenuDemo extends MouseAdapter implements ActionListener {
	JFrame frame = new JFrame("Popup Menu Demo");
	JPopupMenu popup = new JPopupMenu();
	JTextField tf = new JTextField();
	JLabel label = new JLabel("Try to click left and right button");

	public static void main(String args[]) {
		PopupMenuDemo popupMenuDemo = new PopupMenuDemo();
		popupMenuDemo.go();
	}

	public void go() { // 弹出式菜单中的菜单项
		JMenuItem menuItem = new JMenuItem("New", KeyEvent.VK_N);
		menuItem.addActionListener(this);
		popup.add(menuItem);
		menuItem = new JMenuItem("Load", KeyEvent.VK_L);
		menuItem.addActionListener(this);
		popup.add(menuItem);
		menuItem = new JMenuItem("Save", KeyEvent.VK_S);
		menuItem.addActionListener(this);
		popup.add(menuItem);

		popup.addSeparator(); // 加入分隔线

		menuItem = new JMenuItem("Copy", KeyEvent.VK_C);
		menuItem.addActionListener(this);
		popup.add(menuItem);
		menuItem = new JMenuItem("Cut", KeyEvent.VK_T);
		menuItem.addActionListener(this);
		popup.add(menuItem);
		menuItem = new JMenuItem("Paste", KeyEvent.VK_P);
		menuItem.addActionListener(this);
		popup.add(menuItem);

		label.addMouseListener(this);

		tf.setEditable(false); // 设置为不可编辑的

		Container cp = frame.getContentPane();
		cp.add(label, BorderLayout.CENTER);
		cp.add(tf, BorderLayout.SOUTH);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 200);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

	// 改写MouseAdapter中的方法
	@Override
	public void mousePressed(MouseEvent e) {
		maybeShowPopup(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		maybeShowPopup(e);
	}

	private void maybeShowPopup(MouseEvent e) {
		if (e.isPopupTrigger()) { // 判断是否单击了引发弹出式菜单的鼠标键
			popup.show(e.getComponent(), e.getX(), e.getY());
		}
	}

	// 实现ActionListener接口中的方法
	@Override
	public void actionPerformed(ActionEvent e) {
		tf.setText(e.getActionCommand());

		if (e.getActionCommand() == "Exit") {
			System.exit(0);
		}
	}
}
