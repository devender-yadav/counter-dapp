package com.dev.dapp.ethereum.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.web3j.crypto.CipherException;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(CipherException.class)
	public ModelAndView handleWalletPasswordError(HttpServletRequest request, Exception e) {
		ModelAndView modelAndView = new ModelAndView("failure");
		modelAndView.addObject("message", "Ethereum credentials are wrong. Please check ethereum password!");
		return modelAndView;
	}

	@ExceptionHandler(IOException.class)
	public ModelAndView handleWalletFileError(HttpServletRequest request, Exception e) {
		ModelAndView modelAndView = new ModelAndView("failure");
		modelAndView.addObject("message", "Ethereum credentials are wrong. Please check ethereum wallet file!");
		return modelAndView;
	}

}
