package com.softserve.edu.opencart.data.field;

import com.softserve.edu.opencart.data.products.ProductRepository;
import com.softserve.edu.opencart.data.users.UserRepository;

public class MessageRepository {
    private static volatile MessageRepository instance = null;

    private MessageRepository() {
    }

    public static MessageRepository get() {
        if (instance == null) {
            synchronized (MessageRepository.class) {
                if (instance == null) {
                    instance = new MessageRepository();
                }
            }
        }
        return instance;
    }


}
