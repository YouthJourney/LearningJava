package com.hong.swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class MenuDemo implements ItemListener, ActionListener {
	JFrame frame = new JFrame("Menu Demo");
	JTextField tf = new JTextField();

	public static void main(String args[]) {
		MenuDemo menuDemo = new MenuDemo();
		menuDemo.go();
	}

	public void go() {
		JMenuBar menubar = new JMenuBar(); // 菜单栏
		frame.setJMenuBar(menubar);

		JMenu menu, submenu; // 菜单和子菜单
		JMenuItem menuItem; // 菜单项

		// 建立File菜单
		menu = new JMenu("File");
		menu.setMnemonic(KeyEvent.VK_F);
		menubar.add(menu);

		// File中的菜单项
		menuItem = new JMenuItem("Open...");
		menuItem.setMnemonic(KeyEvent.VK_O);// 设置快捷键
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK)); // 设置加速键
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Save", KeyEvent.VK_S);
		menuItem.addActionListener(this);
		menuItem.setEnabled(false);// 设置为不可用
		menu.add(menuItem);

		menuItem = new JMenuItem("Close");
		menuItem.setMnemonic(KeyEvent.VK_C);
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menu.add(new JSeparator());// 加入分隔线

		menuItem = new JMenuItem("Exit");
		menuItem.setMnemonic(KeyEvent.VK_E);
		menuItem.addActionListener(this);
		menu.add(menuItem);

		// 建立Option菜单
		menu = new JMenu("Option");
		menubar.add(menu);

		// Option中的菜单项
		menu.add("Font...");

		// 建立子菜单
		submenu = new JMenu("Color...");
		menu.add(submenu);

		menuItem = new JMenuItem("Foreground");
		menuItem.addActionListener(this);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK)); // 设置加速键
		submenu.add(menuItem);
		menuItem = new JMenuItem("Background");
		menuItem.addActionListener(this);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, ActionEvent.ALT_MASK)); // 设置加速键
		submenu.add(menuItem);

		menu.addSeparator();// 加入分隔线
		JCheckBoxMenuItem cm = new JCheckBoxMenuItem("Always On Top");
		cm.addItemListener(this);
		menu.add(cm);

		menu.addSeparator();
		JRadioButtonMenuItem rm = new JRadioButtonMenuItem("Small", true);
		rm.addItemListener(this);
		menu.add(rm);
		ButtonGroup group = new ButtonGroup();
		group.add(rm);

		rm = new JRadioButtonMenuItem("Large");
		rm.addItemListener(this);
		menu.add(rm);
		group.add(rm);

		// 建立Help菜单
		menu = new JMenu("Help");
		menubar.add(menu);

		menuItem = new JMenuItem("about...", new ImageIcon("dukeWaveRed.gif"));
		menuItem.addActionListener(this);
		menu.add(menuItem);

		tf.setEditable(false); // 设置为不可编辑的

		Container cp = frame.getContentPane();
		cp.add(tf, BorderLayout.SOUTH);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 200);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

	// 实现ItemListener接口中的方法
	@Override
	public void itemStateChanged(ItemEvent e) {
		int state = e.getStateChange();
		JMenuItem amenuItem = (JMenuItem) e.getSource();
		String command = amenuItem.getText();
		if (state == ItemEvent.SELECTED) {
			tf.setText(command + " SELECTED");
		} else {
			tf.setText(command + " DESELECTED");
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
