package SocketChat_Ver1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    private int port;
    public static ArrayList<Socket> sockets;


    public Server(int port) {
        this.port = port;
        sockets = new ArrayList<>();
    }

    public void excute() throws IOException {
        ServerSocket ss = new ServerSocket(port);
        System.out.println("Server khời động thành công...");
        WriteServer writeServer = new WriteServer();
        writeServer.start();
        System.out.println("Listening....");
        while (true){
            Socket socket = ss.accept();
            sockets.add(socket);
            System.out.println("Đã kết nối với: " + socket);
            ReadServer readServer = new ReadServer(socket);
            readServer.start();
        }

    }

    public static void main(String[] args) throws IOException {
        Server server = new Server(12345);
        server.excute();
    }

}


class ReadServer extends Thread {
    private Socket socket;

    public ReadServer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(socket.getInputStream());
            while (true) {
                String mess = dis.readUTF();
                if(mess.contains("exit")){
                    dis.close();
                    socket.close();
                    Server.sockets.remove(socket);
                    System.out.println("Đã ngắt kết nối với: " + socket);
                    continue;
                }
                for (Socket s : Server.sockets) {
                    if(s.getPort() != socket.getPort()){
                        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                        dos.writeUTF(mess);
                    }

                }
                System.out.println(mess);
            }
        } catch (Exception e) {

            try {
                dis.close();
                socket.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }
    }

}

class WriteServer extends Thread {


    @Override
    public void run() {
        DataOutputStream dos = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                String mess = br.readLine();
                for (Socket s : Server.sockets) {
                    dos = new DataOutputStream(s.getOutputStream());
                    dos.writeUTF("Admin: " + mess);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}




