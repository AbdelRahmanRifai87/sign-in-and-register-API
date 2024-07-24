package com.authorizationAPI.authorization.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.authorizationAPI.authorization.model.AutModel;
import com.authorizationAPI.authorization.model.User;

@Service
public class AuthService {

    @Autowired
    private AutModel authModel;

    public void register(String name,String password){
        User u =new User();
        u.setUserName(name);
        u.setPassword(password);
        authModel.add(u);
    }

    public boolean login(String name,String password) {

        for (int i = 0; i < authModel.getUserList().size(); i++) {
            String uname=authModel.getUserList().get(i).getUserName();
            String upas=authModel.getUserList().get(i).getPassword();
            if (uname.equals(name) && upas.equals(password)) {
                return true;
            }
        }
        return false;
    }
    
    public String printList(){
        return authModel.print();
    }
}
