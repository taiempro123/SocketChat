package SocketChat_Ver1;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private InetAddress host;
    private int port;

    public Client(InetAddress host, int port) {
        this.host = host;
        this.port = port;
    }


    public void execute() throws IOException {
        System.out.println("Hãy nhập tên của bạn...");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println("Nhập tin nhắn:...");
        Socket client = new Socket(host, port);
        ReadClient readClient = new ReadClient(client);
        readClient.start();
        WriteClient writeClient = new WriteClient(client, name);
        writeClient.start();
    }

    public static void main(String[] args) throws IOException {

        Client client = new Client(InetAddress.getLocalHost(), 12345);
        client.execute();
    }

}

class ReadClient extends Thread {
    private Socket client;

    public ReadClient(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(client.getInputStream());
            while (true) {
                String mess = dis.readUTF();
                System.out.println(mess);
            }
        } catch (Exception e) {
            try {
                dis.close();
                client.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        }
    }


}

class WriteClient extends Thread {
    private Socket client;
    private String name;

    public WriteClient(Socket client, String name) {
        this.client = client;
        this.name = name;
    }

    @Override
    public void run() {
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(client.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                String mess = br.readLine();
                dos.writeUTF(name+ ": "+mess);

            }
        } catch (Exception e) {
            try {
                dos.close();
                client.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        }
    }


}
