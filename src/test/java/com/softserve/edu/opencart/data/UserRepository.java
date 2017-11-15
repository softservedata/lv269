package com.softserve.edu.opencart.data;

public final class UserRepository {

    private static volatile UserRepository instance = null;

    private UserRepository() {
    }
    
    public static UserRepository get() {
        if (instance == null) {
            synchronized (UserRepository.class) {
                if (instance == null) {
                    instance = new UserRepository();
                }
            }
        }
        return instance;
    }
    

}
