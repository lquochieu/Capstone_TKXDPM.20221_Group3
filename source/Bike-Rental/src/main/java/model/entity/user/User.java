package model.entity.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import utils.UserInfo;

/**
 * entity user class
 *
 * @author Group 3
 */
@AllArgsConstructor
@Getter
@Setter
public class User {
    private static User user;
    private int id;
    private String name;

    public static User getInstance() {
        if (user == null) {
            return new User(UserInfo.USER_ID, UserInfo.USER_NAME);
        }
        return user;
    }
};
