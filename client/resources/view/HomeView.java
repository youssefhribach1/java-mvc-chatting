package resources.view;

import controller.DispatcherController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeView implements IView {
    private DispatcherController dispatcherController = DispatcherController.getInstance();
    private static HomeView home = new HomeView();
    private IndexView idx = IndexView.getInstance();
    private Button loginButton, registerButton;
    private Label titleLabel, textLabel;
    private TextField id, pw;

    public static HomeView getInstance(){
        return home;
    }

    private HomeView() {
    }

    @Override
    public void show() {
        init();
        addEventListener();
    }

    private void init() {
        idx.frame.removeAll();
        idx.frame.setTitle("Login");
        idx.frame.setLayout(new GridLayout(6, 0));

        loginButton = new Button("Login");
        registerButton = new Button("RegisterView");
        id = new TextField();
        pw = new TextField();
        pw.setEchoChar('*');
        textLabel = new Label();
        titleLabel = new Label("로그인이 필요한 서비스 입니다.");
        titleLabel.setAlignment(Label.CENTER);

        idx.frame.add(titleLabel);
        idx.frame.add(id);
        idx.frame.add(pw);
        idx.frame.add(loginButton);
        idx.frame.add(registerButton);
        idx.frame.add(textLabel);

        idx.frame.setVisible(true);
    }
    private void addEventListener() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispatcherController.setUserName(id.getText());
                IndexView.getInstance().show("roomList");
            }
        });
        registerButton.addActionListener(e -> IndexView.getInstance().show("register"));
    }
}
