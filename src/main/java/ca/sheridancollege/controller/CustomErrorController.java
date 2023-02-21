package ca.sheridancollege.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomErrorController implements ErrorController {
	
	@GetMapping("/error")
	public String handleErrors(HttpServletRequest request) {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		
		if (status != null) {
			Integer statusCode = Integer.valueOf(status.toString());
			
			// If error 404 OR error 401
			if (statusCode == HttpStatus.NOT_FOUND.value() || statusCode == HttpStatus.UNAUTHORIZED.value() ) {
				return "error/404.html";
			}
		}
		
		return "error/404.html";
	}
}
