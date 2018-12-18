package com.hong.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class JTextFieldDemo2 {
	JFrame frame = new JFrame("JTextField Demo2");
	JLabel nameLabel = new JLabel("User Name");
	JLabel pwLabel = new JLabel("Password");
	JTextField nameField = new JTextField();
	JPasswordField pwField = new JPasswordField();
	JTextArea ta = new JTextArea(5, 20);

	public static void main(String args[]) {
		JTextFieldDemo2 tfd2 = new JTextFieldDemo2();
		tfd2.go();
	}

	public void go() {
		UpperCaseDocument ucDocument = new UpperCaseDocument();
		nameField.setDocument(ucDocument);
		nameField.setForeground(Color.red);

		nameField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = nameField.getText(); // 获取文本域的内容
				ta.append("\nUser Name : " + username); // 显示在文本区中
			}
		});

		pwField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				char[] pw = pwField.getPassword(); // 获取文本域的内容
				String password = new String(pw);
				ta.append("\nPassword : " + password);
			}
		});

		JPanel labelPanel = new JPanel();
		labelPanel.setLayout(new GridLayout(2, 1));
		labelPanel.add(nameLabel);
		labelPanel.add(pwLabel);

		JPanel fieldPanel = new JPanel();
		fieldPanel.setLayout(new GridLayout(2, 1));
		fieldPanel.add(nameField);
		fieldPanel.add(pwField);

		JPanel northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(1, 2));
		northPanel.add(labelPanel);
		northPanel.add(fieldPanel);

		JScrollPane jsp = new JScrollPane(ta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		Container cp = frame.getContentPane();
		cp.add(northPanel, BorderLayout.NORTH);
		cp.add(jsp, BorderLayout.CENTER);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}

//自定义的Document,当用户输入字符时,自动将小写字母装换为大写字母
class UpperCaseDocument extends PlainDocument {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void insertString(int offset, String string, AttributeSet attributeSet) throws BadLocationException {
		string = string.toUpperCase(); // 转换为大写字符
		super.insertString(offset, string, attributeSet);
	}
}
