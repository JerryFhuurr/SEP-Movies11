package com.movie.movies11.util;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class TMDbAPI {

  public String getPosterPath(int movieId) throws JSONException
  {
    JSONObject json = new JSONObject();
    String apiKey = "a1d579240045bb45c21c03bdc18a0f57";
    String jsonString = "";
    try {
      String apiUrl = "https://api.themoviedb.org/3/movie/" +
          movieId +
          "?api_key=" + apiKey;

      // Create URL object and open connection
      URL url = new URL(apiUrl);
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();

      // Set request method
      connection.setRequestMethod("GET");

      // Read response
      BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      StringBuilder response = new StringBuilder();
      String line;
      while ((line = reader.readLine()) != null) {
        response.append(line);
      }
      reader.close();

      // Parse JSON response
      json = new JSONObject(response.toString());

    } catch (IOException e) {
      e.printStackTrace();
    }
    catch (JSONException e)
    {
      throw new RuntimeException(e);
    }

    String finial = "http://image.tmdb.org/t/p/w500/" + json.get("poster_path");
    System.out.println(finial);
    return finial;
  }

  public String getOverview(int movieId) throws JSONException
  {
    JSONObject json = new JSONObject();
    String apiKey = "a1d579240045bb45c21c03bdc18a0f57";
    String jsonString = "";
    try {
      String apiUrl = "https://api.themoviedb.org/3/movie/" +
          movieId +
          "?api_key=" + apiKey;

      // Create URL object and open connection
      URL url = new URL(apiUrl);
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();

      // Set request method
      connection.setRequestMethod("GET");

      // Read response
      BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      StringBuilder response = new StringBuilder();
      String line;
      while ((line = reader.readLine()) != null) {
        response.append(line);
      }
      reader.close();

      // Parse JSON response
      json = new JSONObject(response.toString());
      // TODO: Extract poster path from JSON and handle accordingly

    } catch (IOException e) {
      e.printStackTrace();
    }
    catch (JSONException e)
    {
      throw new RuntimeException(e);
    }

    String finial = json.get("overview").toString();
    System.out.println(finial);
    return finial;
  }

  public String getLanguage(int movieId) throws JSONException
  {
    JSONObject json = new JSONObject();
    String apiKey = "a1d579240045bb45c21c03bdc18a0f57";
    String jsonString = "";
    try {
      String apiUrl = "https://api.themoviedb.org/3/movie/" +
          movieId +
          "?api_key=" + apiKey;

      // Create URL object and open connection
      URL url = new URL(apiUrl);
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();

      // Set request method
      connection.setRequestMethod("GET");

      // Read response
      BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      StringBuilder response = new StringBuilder();
      String line;
      while ((line = reader.readLine()) != null) {
        response.append(line);
      }
      reader.close();

      // Parse JSON response
      json = new JSONObject(response.toString());
      // TODO: Extract poster path from JSON and handle accordingly

    } catch (IOException e) {
      e.printStackTrace();
    }
    catch (JSONException e)
    {
      throw new RuntimeException(e);
    }

    String finial = json.get("original_language").toString();
    System.out.println(finial);
    return finial;
  }

  public String getCountry(int movieId) throws JSONException
  {
    JSONObject json = new JSONObject();
    String apiKey = "a1d579240045bb45c21c03bdc18a0f57";
    String jsonString = "";
    try {
      String apiUrl = "https://api.themoviedb.org/3/movie/" +
          movieId +
          "?api_key=" + apiKey;

      // Create URL object and open connection
      URL url = new URL(apiUrl);
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();

      // Set request method
      connection.setRequestMethod("GET");

      // Read response
      BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      StringBuilder response = new StringBuilder();
      String line;
      while ((line = reader.readLine()) != null) {
        response.append(line);
      }
      reader.close();

      // Parse JSON response
      json = new JSONObject(response.toString());
      // TODO: Extract poster path from JSON and handle accordingly

    } catch (IOException e) {
      e.printStackTrace();
    }
    catch (JSONException e)
    {
      throw new RuntimeException(e);
    }

    String finial = json.get("production_countries").toString();
    System.out.println(finial);
    return finial;
  }
}