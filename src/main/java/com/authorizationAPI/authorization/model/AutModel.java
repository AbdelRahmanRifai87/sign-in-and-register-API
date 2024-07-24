package com.authorizationAPI.authorization.model;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class AutModel {
    private List<User> UserList;

    public AutModel() {
        UserList = new ArrayList<>();
        UserList.add(new User("ahmad","123"));
        UserList.add(new User("omar", "222"));
        UserList.add(new User("mohamad", "444"));
        UserList.add(new User("oussama", "555"));
    }

    public List<User> getUserList() {
        return UserList;
    }

    public void add(User u){
        UserList.add(u);

    }
    
    public String print(){
        String printedList="";
        for(int i=0;i<UserList.size();i++){
           printedList+=UserList.get(i).toString()+"\n";
        }
        return printedList;
    }

    public void setUserList(List<User> userList) {
        UserList = userList;
    }

}
