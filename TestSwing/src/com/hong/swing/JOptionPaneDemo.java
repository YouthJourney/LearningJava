package com.hong.swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JOptionPaneDemo implements ActionListener {
	JFrame frame = new JFrame("JOptionPane Demo");
	JTextField tf = new JTextField();
	JButton messageButton, ConfirmButton, InputButton, OptionButton;

	public static void main(String args[]) {
		JOptionPaneDemo opd = new JOptionPaneDemo();
		opd.go();
	}

	public void go() {
		messageButton = new JButton("message dialog");
		messageButton.addActionListener(this);
		ConfirmButton = new JButton("Confirm dialog");
		ConfirmButton.addActionListener(this);
		InputButton = new JButton("Input dialog");
		InputButton.addActionListener(this);
		OptionButton = new JButton("Option dialog");
		OptionButton.addActionListener(this);

		JPanel jp = new JPanel();
		jp.add(messageButton);
		jp.add(ConfirmButton);
		jp.add(InputButton);
		jp.add(OptionButton);

		Container cp = frame.getContentPane();
		cp.add(jp, BorderLayout.CENTER);
		cp.add(tf, BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();

		// 信息对话框
		if (button == messageButton) {
			JOptionPane.showMessageDialog(frame, "File not found.", "An error", JOptionPane.ERROR_MESSAGE);
		}

		// 确认对话框
		if (button == ConfirmButton) {
			int select = JOptionPane.showConfirmDialog(frame, "Create one", "Confirm", JOptionPane.YES_NO_OPTION);
			if (select == JOptionPane.YES_OPTION) {
				tf.setText("choose YES");
			}
			if (select == JOptionPane.NO_OPTION) {
				tf.setText("choose NO");
			}
			if (select == JOptionPane.CLOSED_OPTION) {
				tf.setText("Closed");
			}
		}

		// 输入对话框
		if (button == InputButton) {
			Object[] possibleValues = { "First", "Second", "Third" };
			Object selectedValue = JOptionPane.showInputDialog(frame, "Choose one", "Input",
					JOptionPane.INFORMATION_MESSAGE, null, possibleValues, possibleValues[0]);
			if (selectedValue != null) {
				tf.setText(selectedValue.toString());
			} else {
				tf.setText("Closed");
			}
		}

		// 选项对话框
		if (button == OptionButton) {
			Object[] options = { "OK", "CANCEL" };
			int select = JOptionPane.showOptionDialog(frame, "Click OK to continue", "Warning",
					JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
			if (select == 0) {
				tf.setText("choose OK");
			} else if (select == 1) {
				tf.setText("choose CANCEL");
			} else if (select == -1) {
				tf.setText("Closed");
			}
		}
	}
}
