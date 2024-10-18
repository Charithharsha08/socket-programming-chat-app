package lk.ijse.socketprogrammingchatapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientSideController {

    @FXML
    private TextArea textArea;

    @FXML
    private TextField textfield;

    @FXML
    private Button btnSend;

    ServerSocket serverSocket;

    Socket socket;
DataInputStream dataInputStream;
    DataOutputStream dataOutputStream;

    String message = "";

    public void initialize() {
        new Thread(() -> {



        try {

       socket = new Socket("127.0.0.1", 5000);

            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            while (!message.equals("Exit")) {
                message = dataInputStream.readUTF();
                textArea.appendText("Sever : " +message + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        }).start();
    }
    @FXML
    void btnSendOnAction(ActionEvent event) {
        try {
            dataOutputStream.writeUTF(textfield.getText().trim());
            dataOutputStream.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
