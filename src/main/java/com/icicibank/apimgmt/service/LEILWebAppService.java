package com.icicibank.apimgmt.service;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;

import org.springframework.stereotype.Service;

import com.icicibank.apimgmt.model.RequestModel;
import com.icicibank.apimgmt.model.ResponseModel;

@Service
public interface LEILWebAppService {

	public RequestModel generateRequestPacket(RequestModel requestModel) throws InvalidKeyException, SignatureException, NoSuchAlgorithmException, UnsupportedEncodingException;

	public String verifySignature(ResponseModel responseModel);
}
