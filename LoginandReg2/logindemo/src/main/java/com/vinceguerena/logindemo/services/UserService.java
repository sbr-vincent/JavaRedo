package com.vinceguerena.logindemo.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.vinceguerena.logindemo.models.LoginUser;
import com.vinceguerena.logindemo.models.User;
import com.vinceguerena.logindemo.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    // !To-DO Write register and login methods
    public User register(User newUser, BindingResult result){
        //! TO-DO: Additional Validations!
        // TO-DO - Reject values or register if no errors:
        // Reject if email is taken (present in database)
        Optional<User> optionalUser = userRepo.findByEmail(newUser.getEmail());
        if(optionalUser.isPresent()) {
            result.rejectValue("email", "unique", "This email is already registered.");
        }
        // Reject if password doesn't match confirmation
        if(!newUser.getPassword().equals(newUser.getConfirm())) {
            result.rejectValue("confirm", "matches", "The passwords do not match.");
        }
        // Return null if result has errors
        if (result.hasErrors()){
            return null;
        }
        // Hash and set password, save user to database
        String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        newUser.setPassword(hashed);

        return userRepo.save(newUser);
    }

    public User login(LoginUser newLogin, BindingResult result) {
        //! TO-DO Additional validations
        // TO-DO - Reject values:
        
    	// Find user in the DB by email
        Optional<User> optionalUser = userRepo.findByEmail(newLogin.getEmail());

        // Reject if NOT present
        if(optionalUser.isEmpty()) {
            result.rejectValue("email", "unique", "This email is not registered!");
            return null;
        }

        User user = optionalUser.get();
        // Reject if BCrypt password match fails
        if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
            result.rejectValue("password", "Matches", "Invalid Password!");
        }
        // Return null if result has errors
        if(result.hasErrors()) {
            return null;
        }
        // Otherwise, return the user object
        return user;
    }





}
