module lk.ijse.socketprogrammingchatapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens lk.ijse.socketprogrammingchatapp to javafx.fxml;
    exports lk.ijse.socketprogrammingchatapp;
}