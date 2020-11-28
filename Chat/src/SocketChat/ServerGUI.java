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

public class ServerGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textPort;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerGUI frame = new ServerGUI();
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
	public ServerGUI() {
		initServerGUI();
	}

	public void initServerGUI() {
		setTitle("SocketChat");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(71, 18, 580, 68);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("OPEN PORT");
		lblNewLabel.setBounds(49, 23, 88, 17);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblNewLabel);

		textPort = new JTextField();
		textPort.setFont(new Font("Tahoma", Font.BOLD, 12));
		textPort.setBounds(147, 16, 107, 34);
		panel.add(textPort);
		textPort.setColumns(10);

		JButton btnStart = new JButton("Start");
		btnStart.setBackground(Color.DARK_GRAY);
		btnStart.setForeground(Color.GREEN);
		btnStart.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnStart.setFocusable(false);

		btnStart.setBounds(282, 8, 75, 46);
		panel.add(btnStart);

		JButton btnGetIp = new JButton("Get IP");
		btnGetIp.setBackground(Color.DARK_GRAY);
		btnGetIp.setForeground(Color.YELLOW);
		btnGetIp.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGetIp.setBounds(482, 8, 88, 46);
		btnGetIp.setFocusable(false);
		panel.add(btnGetIp);
		

		JButton btnStop = new JButton("Stop");
		btnStop.setForeground(Color.RED);
		btnStop.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnStop.setBackground(Color.DARK_GRAY);
		btnStop.setBounds(382, 8, 75, 46);
		btnStop.setFocusable(false);
		panel.add(btnStop);
		
		ChatPanel1 chatPanel = new ChatPanel1();
		chatPanel.setBounds(27, 98, 678, 448);
		contentPane.add(chatPanel);

		
	}
}
