package com.capgemini;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService{
	
    @Autowired
    private UserRepository repo;
    UserService(UserRepository repo)
    {
    	this.repo=repo;
    }
    
    
 public MyUser findByPhone(String phone) {
        // TODO Auto-generated method stub
        return repo.findByPhone(phone);
 }


	public MyUser findByUserMail(String userMail)
	{	
		System.out.println(repo);
		return repo.findByUserMail(userMail);		
	}	
	public MyUser findByPassword(String password)
	{
		return repo.findByPassword(password);
	}	
	
	public MyUser findByUserName(String userMail)
	{
		return repo.findByUserName(userMail);
	}
}