package com.cbre.util;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static io.restassured.specification.ProxySpecification.host;

public class APIUtil {

	/**
	 * GET
	 *
	 * @param url
	 * @param headers
	 * @return
	 */
	public static Response get(String url, Map<String, String> headers) {

		Response resp = RestAssured.given().headers(headers).get(url);
		System.out.println("status code ::" + resp.getStatusCode());
		return resp;
	}

	/**
	 *
	 * @param url
	 * @param headers
	 * @param queryParameters
	 * @return
	 */
	public static Response getWithQueryParameter(String url, Map<String, String> headers, Map queryParameters) {
		Response resp = RestAssured.given().headers(headers).queryParameters(queryParameters).get(url);
		return resp;
	}

	public static Response post(String baseURL, Map<String, String> headers, String contentType, String body,
			String url) {
		url = baseURL + url;
		Response resp = RestAssured.given().headers(headers).contentType(contentType).body(body).post(url);
		System.out.println("Status code ::" + resp.getStatusCode());
		return resp;
	}
}
