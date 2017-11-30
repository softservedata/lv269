package com.softserve.edu.opencart.pages.user;

public class MyAccountPage extends AColumnRightUserComponent {

    public MyAccountPage() {
        super();
    }

    //----------Bussiness logic

    public EditAccountPage gotoEditAccountPageFromRightColumn() {
        clickEditAccount();
        return new EditAccountPage();
    }


}