package com.springboot.fyp.validationmapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.springboot.fyp.entities.Users;
import com.springboot.fyp.servieslayer.ServiceLayer;

@Component
public class UserValidator implements Validator {
	
	@Autowired
	private ServiceLayer userService;

	@Override
	public boolean supports(Class<?> aClass) {
		return Users.class.equals(aClass);
	}

	@Override
	public void validate(Object o, Errors errors) {
		RegistrationMapper registrationMapper = (RegistrationMapper) o;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "formemail", "NotEmpty");
		if (registrationMapper.getFormemail().length() < 6 || registrationMapper.getFormemail().length() > 32) {
			errors.rejectValue("formemail", "Size.userForm.formemail");
		}
		if (userService.existByEmail(registrationMapper.getFormemail())) {
			errors.rejectValue("formemail", "Duplicate.userForm.formemail");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "formpassword", "NotEmpty");
		if (registrationMapper.getFormpassword().length() < 6 || registrationMapper.getFormpassword().length() > 32) {
			errors.rejectValue("formpassword", "Size.userForm.formpassword");
		}

		if (!registrationMapper.getPasswordConfirm().equals(registrationMapper.getFormpassword())) {
			errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
		}
		if (registrationMapper.getName().length() < 3 || registrationMapper.getName().length() > 32) {
			errors.rejectValue("name", "Size.userForm.name");
		}
		if (registrationMapper.getPhoneNo().length() < 11 || registrationMapper.getPhoneNo().length() > 12) {
			errors.rejectValue("phoneNo", "Size.userForm.phoneNo");
		}
		if (!registrationMapper.getPhoneNo().matches("^03\\d{2}-\\d{7}")) {
			errors.rejectValue("phoneNo", "Correct.userForm.phoneNo");

		}
	}
}
