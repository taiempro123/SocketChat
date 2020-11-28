package SocketChat;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class ChatPanel1 extends JPanel {

	/**
	 * Create the panel.
	 */
	JTextArea textInput = new JTextArea();
	JTextArea textChat = new JTextArea();

	public ChatPanel1() {

		init();

	}

	public void init() {
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Chat");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(245, 0, 139, 37);
		add(lblNewLabel);

		JButton btnSend = new JButton("Send");
		btnSend.setForeground(Color.CYAN);
		btnSend.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSend.setBackground(Color.PINK);
		btnSend.setBounds(551, 365, 89, 71);
		btnSend.setFocusable(false);
		add(btnSend);

		JLabel lblEnterTheMessage = new JLabel("Enter the message below to send");
		lblEnterTheMessage.setForeground(Color.BLUE);
		lblEnterTheMessage.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblEnterTheMessage.setBounds(27, 340, 209, 14);
		add(lblEnterTheMessage);

		textChat.setBounds(27, 48, 613, 278);
		textChat.setEditable(false);
		add(textChat);

		textInput.setBounds(27, 366, 479, 70);
		add(textInput);

	}
}
