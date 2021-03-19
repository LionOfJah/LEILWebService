package com.icicibank.apimgmt.service.impl;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import com.icicibank.apimgmt.model.RequestModel;
import com.icicibank.apimgmt.model.ResponseModel;
import com.icicibank.apimgmt.service.LEILWebAppService;

@Service
@RequestScope 
public class LEILWebAppServiceImpl implements LEILWebAppService {

	private static final String HMAC_SHA256 = "HmacSHA256";

	Logger logger = LoggerFactory.getLogger(LEILWebAppServiceImpl.class);
	
	@Value("${app.hash.secretKey}")
	String secretKey;
	@Override
	public RequestModel generateRequestPacket(RequestModel requestModel) throws InvalidKeyException, SignatureException, NoSuchAlgorithmException, UnsupportedEncodingException {
		
		String concatString = requestModel.getClientId()+requestModel.getLeiNumber()+requestModel.getReferenceNumber();
		String checksum=calculateHMAC(concatString, secretKey);
		requestModel.setCheckSum(checksum);
		String identifier = calculateHMAC(requestModel.getIdentifier(), secretKey);
		requestModel.setIdentifier(identifier);
		return requestModel;
	}




public  String calculateHMAC(String data, String key)
	    throws SignatureException, NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException
	{
		logger.info(" data "+data);
		if(!data.isEmpty()) {
			byte[] keyBytes=key.getBytes();
		    SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, HMAC_SHA256);
		    Mac mac = Mac.getInstance(HMAC_SHA256);
		    mac.init(secretKeySpec);
		    byte [] dataArray=mac.doFinal(data.getBytes());
		    return Base64.getEncoder().encodeToString(dataArray);
		}else {
			
			return data;
		}
		
	    //logger.info(Base64.getEncoder().encodeToString(dataArray));
	    
	}




@Override
public String verifySignature(ResponseModel responseModel) {
	
	return null;
}

}