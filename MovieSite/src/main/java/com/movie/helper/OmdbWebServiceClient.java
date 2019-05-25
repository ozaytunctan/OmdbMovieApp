package com.movie.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.movie.properties.MovieProperties;

@Component
public class OmdbWebServiceClient {

	private MovieProperties movieProperties;

	private Integer connectionTimeOut;

	private Logger logger = Logger.getLogger(OmdbWebServiceClient.class);


	public OmdbWebServiceClient(MovieProperties movieProperties) {
		this.movieProperties = movieProperties;
		this.connectionTimeOut = 10000;
	}

	public String sendGetRequest(String title) {

		StringBuilder response = new StringBuilder();

		String url = createRequestUrl(title);

		try {
			URL uri = new URL(url);

			HttpURLConnection connection = (HttpURLConnection) uri.openConnection();

			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty("Accept", "application/json");
			connection.setRequestProperty("Accept-Charset", StandardCharsets.UTF_8.name());
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(this.connectionTimeOut);
			connection.setUseCaches(false);
			connection.setDoOutput(true);

			BufferedReader lineRead = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line = "";

			while ((line = lineRead.readLine()) != null) {
				response.append(line);
			}
			lineRead.close();

		} catch (IOException e) {
			logger.info("OmdbWebServiceClient.java -->request metod error:" + e);
			response.append("");
		}

		return response.toString();
	}

	private String createRequestUrl(String title) {
		if (Objects.nonNull(title) &&  !title.isEmpty())
			return String.format(movieProperties.getOmdbBaseUrl(), title);
		return "";
	}

	public Integer getConnectionTimeOut() {
		return connectionTimeOut;
	}

	public void setConnectionTimeOut(Integer connectionTimeOut) {
		this.connectionTimeOut = connectionTimeOut;
	}

}
