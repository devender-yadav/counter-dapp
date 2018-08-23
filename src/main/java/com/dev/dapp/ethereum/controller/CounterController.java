package com.dev.dapp.ethereum.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dev.dapp.ethereum.service.Web3jService;
import com.dev.dapp.ethereum.util.CommonUtil;

@Controller
public class CounterController {

	@Autowired
	private Web3jService web3jService;

	@RequestMapping("/")
	ModelAndView home() throws Exception {
		return new ModelAndView("login");
	}

	@RequestMapping("/version")
	ModelAndView version() throws Exception {
		ModelAndView model = new ModelAndView("success");
		model.addObject("message", "Successfully connected to the web3j version - " + web3jService.getClientVersion());
		return model;
	}

	@RequestMapping(value = "/deploycounter", method = RequestMethod.GET)
	public ModelAndView deployCounterForm() throws Exception {
		return new ModelAndView("deploy");
	}

	@RequestMapping(value = "/searchcounter", method = RequestMethod.GET)
	public ModelAndView searchContract() throws Exception {
		return new ModelAndView("search");
	}

	@RequestMapping(value = "/deploycounter.do", method = RequestMethod.POST)
	public ModelAndView deployCounter(@RequestParam("password") String password,
			@RequestParam(value = "wallet", required = true) MultipartFile walletFile) throws Exception {
		// FIXME : Better logic should be used instead of creating file in current
		// directory.
		File wallet = CommonUtil.convert(walletFile);
		String contractAddress;
		try {
			contractAddress = web3jService.deployContract(wallet, password);
		} finally {
			wallet.delete();
		}
		ModelAndView model = new ModelAndView("home");
		model.addObject("message", "Counter contract successfully deployed at the address - " + contractAddress);
		model.addObject("count", web3jService.getCounterValue());
		return model;
	}

	@RequestMapping(value = "/searchcounter.do", method = RequestMethod.POST)
	public ModelAndView searchCounter(@RequestParam("password") String password,
			@RequestParam(value = "wallet", required = true) MultipartFile walletFile,
			@RequestParam("contractAddress") String contractAddress) throws Exception {
		// FIXME : Better logic should be used instead of creating file in current
		// directory.
		File wallet = CommonUtil.convert(walletFile);
		try {
			web3jService.fetchContract(wallet, password, contractAddress);
		} finally {
			wallet.delete();
		}
		ModelAndView model = new ModelAndView("home");
		model.addObject("message", "Successfully found counter contract on the address - " + contractAddress);
		model.addObject("count", web3jService.getCounterValue());
		return model;
	}

	@RequestMapping(value = "/getcounter", method = RequestMethod.GET)
	public ModelAndView getCounter() throws Exception {
		ModelAndView model = new ModelAndView("home");
		model.addObject("message", "Successfully fetched counter value.");
		model.addObject("count", web3jService.getCounterValue());
		return model;
	}

	@RequestMapping(value = "/inccounter", method = RequestMethod.GET)
	public ModelAndView incCounter() throws Exception {
		String txHash = web3jService.increaseCounterValue();
		ModelAndView model = new ModelAndView("home");
		model.addObject("message",
				"Successfully incremented counter value. Check transaction hash for more details : " + txHash);
		model.addObject("count", web3jService.getCounterValue());
		return model;
	}

	@RequestMapping(value = "/deccounter", method = RequestMethod.GET)
	public ModelAndView decCounter() throws Exception {
		String txHash = web3jService.decreaseCounterValue();
		ModelAndView model = new ModelAndView("home");
		model.addObject("message",
				"Successfully decremented counter value. Check transaction hash for more details :" + txHash);
		model.addObject("count", web3jService.getCounterValue());
		return model;
	}

}
