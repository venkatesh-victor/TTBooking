package com.venkatesh.ticketbooking.separateuser;

import com.venkatesh.ticketbooking.admin.AdminView;
import com.venkatesh.ticketbooking.separateuser.SeparateUserModel;
import com.venkatesh.ticketbooking.user.UserView;

import java.util.Scanner;

public class SeparateUserView {
    Scanner sc = new Scanner(System.in);

    private SeparateUserModel separateUserModel;
    public SeparateUserView() {
        this.separateUserModel = new SeparateUserModel(this);
    }

    public void init() {
        System.out.println("Are you an admin? y/n");
        char choice = sc.next().charAt(0);
        switch (choice) {
            case 'y':
                AdminView adminView = new AdminView();
                adminView.init();
                break;
            case 'n':
                UserView userView = new UserView();
                userView.init();
                break;
            default:
                System.out.println("Try again.");
                break;
        }
    }
}
