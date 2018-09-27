package com.capgemini;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
	
	public MyUser findByUserName(String uname);
    public MyUser findByPhone(String phone);
    public MyUser findByUserMail(String email);
    public MyUser findByPassword(String password);


}
