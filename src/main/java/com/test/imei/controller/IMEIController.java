package com.test.imei.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.imei.pojo.IMEIRequest;
import com.test.imei.pojo.IMEIResponse;

@RestController
public class IMEIController {
	
	
	@CrossOrigin(origins = "http://localhost:8080")
	@PostMapping(value="/imeiValidation" , consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_FORM_URLENCODED_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
	public IMEIResponse convertCurrency(@RequestBody IMEIRequest request) {
		IMEIResponse result = validate(request.getImeiNumber());
		return result;
		}

		public static IMEIResponse validate(Long input) {
			IMEIResponse response = new IMEIResponse();
		// long n = 290154273637911L;

		// 290154203237518L;
		// 490154203237518 2681300317479120L
		boolean isvalid = validateIMEI(input);

		response.setStatus(isvalid);
		System.out.println("Input Status: " + isvalid);

		if (!isvalid) {
		int index = 14;
		String inputString = Long.toString(input);
		String[] strSplit = inputString.split("");
		ArrayList<String> strList = new ArrayList<String>(Arrays.asList(strSplit));

		for (int i = 0; i <= 9; i++) {

		strList.set(index, String.valueOf(i));

		String s1 = "";
		for (String s : strList) {
		s1 = s1 + s;
		}
		boolean isvalidCHange = validateIMEI(Long.parseLong(s1));
		if (isvalidCHange) {
		System.out.println("Valid Digit : " + i + "@ Position : " + index);
		response.setStatus(true);
		response.setValidDigit(i);
		response.setResponseMessage("Valid Digit : " + i + "@ Position : " + index);
		break;
		} else {
		if (i != 9) {
		continue;
		} else {
		i = 0;
		index++;
		continue;
		}

		}

		}
		} else {
		System.out.println("Provided IMEI number is valid. Please provide valid IMEI number ");
		}
		return response;
		}

		public static boolean validateIMEI(long inputIMEI) {

		String s = Long.toString(inputIMEI);
		int len = s.length();

		if (len != 15)
		return false;

		int sum = 0;
		for (int i = len; i >= 1; i--) {
		int d = (int) (inputIMEI % 10);

		// Doubling every alternate digit
		if (i % 2 == 0)
		d = 2 * d;

		// Finding sum of the digits
		sum += sumDig(d);
		inputIMEI = inputIMEI / 10;
		}

		return (sum % 10 == 0);
		}

		static int sumDig(int n) {
		int a = 0;
		while (n > 0) {
		a = a + n % 10;
		n = n / 10;
		}
		return a;
		}

		}