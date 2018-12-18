package com.hong.swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Drawing implements ActionListener {
	JFrame frame;
	MyButton button;
	MyPanel panel;
	int tag = 1;

	public static void main(String args[]) {
		Drawing de = new Drawing();
		de.go();
	}

	public void go() {
		frame = new JFrame("Drawing  Example");
		frame.setLocationRelativeTo(null);
		// frame.setSize(new Dimension(500, 600));
		button = new MyButton("Draw");
		button.addActionListener(this);
		frame.getContentPane().add(button, "South");

		panel = new MyPanel();
		frame.getContentPane().add(panel, "Center");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(360, 200);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) { // 按钮上的文本在Draw与Clear间切换
		if (tag == 0) {
			tag = 1;
			button.setText("Draw");
		} else {
			tag = 0;
			button.setText("Clear");
		}
		panel.repaint();// 重绘panel
	}

	// 自定义的button
	class MyButton extends JButton {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		MyButton(String text) {
			super(text);
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.red);
			int width = getWidth();
			int height = getHeight();
			g.drawOval(4, 4, width - 8, height - 8);// 绘制椭圆
		}
	}

	// 自定义的panel
	class MyPanel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			if (tag == 0) {
				g.setColor(Color.blue); // 设置颜色
				g.drawLine(40, 25, 30, 50); // 绘制直线
				g.setColor(Color.green);
				g.drawRect(100, 50, 100, 46);// 绘制矩形
				g.setColor(Color.red);
				g.drawRoundRect(73, 32, 56, 37, 10, 16); // 绘制圆角矩形
				g.setColor(Color.yellow);
				g.fillOval(180, 60, 60, 45); // 绘制填充椭圆
				g.setColor(Color.pink);
				g.fillArc(250, 32, 90, 60, 15, 30); // 绘制填充圆弧
			}
		}
	}
}
