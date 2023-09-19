package com.coding.register.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.coding.register.models.LoginUser;
import com.coding.register.models.User;
import com.coding.register.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;

//	Check password, confirmPassword, email
	public User register(User newUser, BindingResult result) {
// TO-DO - Reject values or register if no errors:

		// Reject if email is taken (present in database)
//		1 Find user in the DB by email
		Optional<User> optionalUser = userRepo.findByEmail(newUser.getEmail());
//		2 If the email is present, reject
		if (optionalUser.isPresent()) {
			result.rejectValue("email", "unique", "This email is already registered.");
		}
		// Reject if password doesn't match confirmation
		if (!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "matches", "The passwords do not match.");
		}
		// Return null if result has errors
		if (result.hasErrors()) {
			return null;
		}
		// Hash and set password, save user to database
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);

		return userRepo.save(newUser);
	}

	// This method will be called from the controller
	// whenever a user submits a login form.
	public User login(LoginUser newLogin, BindingResult result) {
		// TO-DO - Reject values:
//		1 Find user in the DB by email
		Optional<User> optionalUser = userRepo.findByEmail(newLogin.getEmail());
//		2 If the email is not present, reject
		if (optionalUser.isEmpty()) {
			result.rejectValue("email", "unique", "This email is not registered.");
			return null; //If the optionalUser is empty then we cannot get the user
		}
//		3.1 Grab the user from potential user
		User user = optionalUser.get();
//		3.2 If BCrypt password match fails
		if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
		    result.rejectValue("password", "Matches", "Invalid Password!");
		}
//		4 If results has errors, return
		if (result.hasErrors()) {
			return null;
		}
//		Otherwise, return the user object

		
		return user;
	}

}
