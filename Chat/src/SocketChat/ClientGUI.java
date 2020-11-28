package SocketChat;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ClientGUI extends JFrame  {

	private JPanel contentPane;
	private JTextField textName;
	private JTextField textIP;
	private JTextField textPort;
	



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientGUI frame = new ClientGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClientGUI() {
		initClientGUI();
	}

	public void initClientGUI() {
		setTitle("Client");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		ChatPanel1 chatPanel = new ChatPanel1();
		chatPanel.setBounds(27, 98, 678, 448);
		contentPane.add(chatPanel);

		JPanel panel = new JPanel();
		panel.setBounds(27, 11, 678, 88);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("NAME");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 35, 48, 14);
		panel.add(lblNewLabel);

		textName = new JTextField();
		textName.setFont(new Font("Tahoma", Font.BOLD, 12));
		textName.setBounds(56, 27, 129, 34);
		panel.add(textName);
		textName.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("IP");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(195, 35, 48, 14);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("PORT");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(402, 35, 48, 14);
		panel.add(lblNewLabel_2);

		textIP = new JTextField();
		textIP.setFont(new Font("Tahoma", Font.BOLD, 12));
		textIP.setColumns(10);
		textIP.setBounds(222, 27, 170, 34);
		panel.add(textIP);

		textPort = new JTextField();
		textPort.setFont(new Font("Tahoma", Font.BOLD, 12));
		textPort.setColumns(10);
		textPort.setBounds(452, 27, 63, 34);
		panel.add(textPort);

		JButton btnConnect = new JButton("Connect");
		btnConnect.setBackground(Color.DARK_GRAY);
		btnConnect.setForeground(Color.YELLOW);
		btnConnect.setFocusable(false);

		btnConnect.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConnect.setBounds(535, 20, 106, 44);
		panel.add(btnConnect);
	}
}
