package com.juvlinhares.workshopmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {

	public static String decodeParam(String text) {
		try {
			return URLDecoder.decode(text, "UTF-8");//pede o texto e o padrão da web
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
}
