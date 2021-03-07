package com.jacaranda.appDojoAfdam.security.common;

public class SecurityConstants {

	public static final String SECRET = "GonzKeyToGenJWT_afdamD_@_GonzKeyToGenJWT_afdamD_@_GonzKeyToGenJWT_afdamD";

	public static final long EXPIRATION_TIME = 7_200_000; //Dos hora
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
	public static final String SIGN_UP_URL = "/user/sign-up";
	public static final String LOG_IN = "/user/login";

}
