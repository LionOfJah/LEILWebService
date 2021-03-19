package com.icicibank.apimgmt.controller;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.icicibank.apimgmt.model.RequestModel;
import com.icicibank.apimgmt.model.ResponseModel;
import com.icicibank.apimgmt.service.LEILWebAppService;

@RestController
@RequestScope
@RequestMapping("/api/v0")
public class LEILAppController {

	@Autowired
	RequestModel requestModel;
	
	@Autowired
	LEILWebAppService service;
	
	static Logger logger = LoggerFactory.getLogger(LEILAppController.class);
	@PostMapping("/generateRequest")
	public ResponseEntity<RequestModel> generateRequest(@RequestBody RequestModel requestModel) throws InvalidKeyException, SignatureException, NoSuchAlgorithmException, UnsupportedEncodingException{
		
		logger.info(requestModel.toString());
		requestModel =service.generateRequestPacket(requestModel);
		
		return ResponseEntity.ok().body(requestModel);
	}
	
	@PostMapping("/verifySignature")
	public ResponseEntity<String> verifySignature(@RequestBody ResponseModel responseModel){
		logger.info("response Data "+responseModel.toString());
		
		
		return null;
		
	}
}