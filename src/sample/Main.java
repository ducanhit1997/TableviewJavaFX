package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        TableView<User> table = new TableView<User>();


        // Tạo cột UserName (Kiểu dữ liệu String)
        TableColumn<User, String> userNameCol //
                = new TableColumn<User, String>("User Name");

        // Tạo cột Email (Kiểu dữ liệu String)
        TableColumn<User, String> emailCol//
                = new TableColumn<User, String>("Email");

        // Tạo cột FullName (Kiểu dữ liệu String)
        TableColumn<User, String> fullNameCol//
                = new TableColumn<User, String>("Full Name");


        // Tạo 2 cột con cho cột FullName
        TableColumn<User, String> firstNameCol//
                = new TableColumn<User, String>("First Name");

        TableColumn<User, String> lastNameCol //
                = new TableColumn<User, String>("Last Name");

        // Active Column
        TableColumn<User, Boolean> activeCol//
                = new TableColumn<User, Boolean>("Active");


        // Định nghĩa cách để lấy dữ liệu cho mỗi ô.
        // Lấy giá trị từ các thuộc tính của UserAccount.
        userNameCol.setCellValueFactory(new PropertyValueFactory<>("userName"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        activeCol.setCellValueFactory(new PropertyValueFactory<>("active"));


        // Sét xắp xếp theo userName
        userNameCol.setSortType(TableColumn.SortType.DESCENDING);
        lastNameCol.setSortable(false);


        // Hiển thị các dòng dữ liệu
        ObservableList<User> list = getUserList();
        table.setItems(list);

        table.getColumns().addAll(userNameCol, emailCol, firstNameCol, lastNameCol, activeCol);

        StackPane root = new StackPane();
        root.setPadding(new Insets(5));
        root.getChildren().add(table);

        stage.setTitle("TableView (o7planning.org)");

        Scene scene = new Scene(root, 450, 300);
        stage.setScene(scene);
        stage.show();
    }

    private ObservableList<User> getUserList() {

        User user1 = new User(1L, "smith", "smith@gmail.com", //
                "Susan", "Smith", true);
        User user2 = new User(2L, "mcneil", "mcneil@gmail.com", //
                "Anne", "McNeil", true);
        User user3 = new User(3L, "white", "white@gmail.com", //
                "Kenvin", "White", false);

        ObservableList<User> list = FXCollections.observableArrayList(user1, user2, user3);
        return list;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
