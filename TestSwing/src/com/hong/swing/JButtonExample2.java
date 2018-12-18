package com.hong.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JButtonExample2 extends WindowAdapter implements ActionListener {
	JFrame f;
	JPanel p;
	JButton b1, b2;
	JTextField tf;
	int tag = 0;

	public static void main(String args[]) {
		JButtonExample2 be = new JButtonExample2();
		be.go();
	}

	public void go() {
		f = new JFrame("JButton  Example2");

		b1 = new JButton("Sample");
		b1.setMnemonic(KeyEvent.VK_S); // 设置快捷键
		b1.setActionCommand("Sample"); // 设置命令名
		b1.addActionListener(this);

		b2 = new JButton("Disable Sample");
		b2.setMnemonic(KeyEvent.VK_A); // 设置快捷键
		b2.setActionCommand("disable"); // 设置命令名
		b2.addActionListener(this);

		p = new JPanel();
		p.add(b1);
		p.add(b2);

		f.getContentPane().add(p, "South");

		tf = new JTextField();
		f.getContentPane().add(tf, "Center");

		f.addWindowListener(this);
		f.setSize(300, 150);
		f.setVisible(true);
		f.setLocationRelativeTo(null);
	}

	// 实现ActionListener接口中的actionPerformed()方法
	@Override
	public void actionPerformed(ActionEvent e) {
		String s1 = "You have pressed the Button!";
		String s2 = "You do another time!";

		// 根据命令名进行判断
		if (e.getActionCommand() == "Sample") {
			if (tag == 0) {
				tf.setText(s1);
				tag = 1;
			} else {
				tf.setText(s2);
				tag = 0;
			}
		}
		if (e.getActionCommand() == "disable") {
			b1.setEnabled(false); // 设置Sample按钮为不可用
			b2.setText("Enable Sample"); // 修改显示文本
			b2.setActionCommand("enable"); // 修改命令名
		}
		if (e.getActionCommand() == "enable") {
			b1.setEnabled(true); // 设置Sample按钮为可用
			b2.setText("Disable Sample");
			b2.setActionCommand("disable");
		}
	}

	// 重载WindowAdapter类中的windowClosing()方法
	@Override
	public void windowClosing(WindowEvent e) { // 结束程序运行
		System.exit(0);
	}
}
