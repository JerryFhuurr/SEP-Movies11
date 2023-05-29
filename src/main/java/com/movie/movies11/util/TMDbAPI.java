package com.movie.movies11.util;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class TMDbAPI {

  public String getPosterPath(String movieId) throws JSONException
  {
    JSONObject json = new JSONObject();
    String apiKey = "a1d579240045bb45c21c03bdc18a0f57";
    String image = new String();
    String jsonString = "";
    try {
      String apiUrl = "https://api.themoviedb.org/3/find/tt" +
          movieId +
          "?api_key=" + apiKey +
          "&external_source=imdb_id";

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
      image = json.getJSONArray( "movie_results").getJSONObject(0).get("poster_path").toString();
    } catch (IOException e) {
      e.printStackTrace();
    }

    String finial = "http://image.tmdb.org/t/p/w500/" + image;
    System.out.println(finial);
    return finial;
  }

  public String getOverview(String movieId) throws JSONException
  {
    JSONObject json = new JSONObject();
    String apiKey = "a1d579240045bb45c21c03bdc18a0f57";
    String overview = new String();
    String jsonString = "";
    try {
      String apiUrl = "https://api.themoviedb.org/3/find/tt" +
          movieId +
          "?api_key=" + apiKey +
          "&external_source=imdb_id";

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
      overview = json.getJSONArray( "movie_results").getJSONObject(0).get("overview").toString();
    } catch (IOException e) {
      e.printStackTrace();
    }

    System.out.println(overview);
    return overview;
  }

  public String getLanguage(String movieId) throws JSONException
  {
    JSONObject json = new JSONObject();
    String apiKey = "a1d579240045bb45c21c03bdc18a0f57";
    String lan = new String();
    String jsonString = "";
    try {
      String apiUrl = "https://api.themoviedb.org/3/find/tt" +
          movieId +
          "?api_key=" + apiKey +
          "&external_source=imdb_id";

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
      lan = json.getJSONArray( "movie_results").getJSONObject(0).get("original_language").toString();
    } catch (IOException e) {
      e.printStackTrace();
    }

    System.out.println(lan);
    return lan;
  }

  public String getCountry(String movieId)
      throws JSONException, MalformedURLException
  {
    JSONObject json = new JSONObject();
    String apiKey = "a1d579240045bb45c21c03bdc18a0f57";
    String tmdbid = new String();
    String jsonString = "";
    try
    {
      String apiUrl =
          "https://api.themoviedb.org/3/find/tt" + movieId + "?api_key=" + apiKey + "&external_source=imdb_id";

      // Create URL object and open connection
      URL url = new URL(apiUrl);
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();

      // Set request method
      connection.setRequestMethod("GET");

      // Read response
      BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      StringBuilder response = new StringBuilder();
      String line;
      while ((line = reader.readLine()) != null)
      {
        response.append(line);
      }
      reader.close();

      // Parse JSON response
      json = new JSONObject(response.toString());
      tmdbid = json.getJSONArray("movie_results").getJSONObject(0).get("id").toString();

      try
      {
        apiUrl = "https://api.themoviedb.org/3/movie/" +
            tmdbid +
            "?api_key=" + apiKey;

        // Create URL object and open connection
        url = new URL(apiUrl);
        connection = (HttpURLConnection) url.openConnection();

        // Set request method
        connection.setRequestMethod("GET");

        // Read response
        reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        response = new StringBuilder();
        while ((line = reader.readLine()) != null)
        {
          response.append(line);
        }
        reader.close();

        // Parse JSON response
        json = new JSONObject(response.toString());
        // TODO: Extract poster path from JSON and handle accordingly

      }
      catch (IOException e)
      {
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
    catch (ProtocolException e)
    {
      throw new RuntimeException(e);
    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }
  }

  public String getGenres(String movieId)
      throws JSONException, MalformedURLException
  {
    JSONObject json = new JSONObject();
    String apiKey = "a1d579240045bb45c21c03bdc18a0f57";
    String tmdbid = new String();
    String jsonString = "";
    try
    {
      String apiUrl =
          "https://api.themoviedb.org/3/find/tt" + movieId + "?api_key=" + apiKey + "&external_source=imdb_id";

      // Create URL object and open connection
      URL url = new URL(apiUrl);
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();

      // Set request method
      connection.setRequestMethod("GET");

      // Read response
      BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      StringBuilder response = new StringBuilder();
      String line;
      while ((line = reader.readLine()) != null)
      {
        response.append(line);
      }
      reader.close();

      // Parse JSON response
      json = new JSONObject(response.toString());
      tmdbid = json.getJSONArray("movie_results").getJSONObject(0).get("id").toString();

      try
      {
        apiUrl = "https://api.themoviedb.org/3/movie/" +
            tmdbid +
            "?api_key=" + apiKey;

        // Create URL object and open connection
        url = new URL(apiUrl);
        connection = (HttpURLConnection) url.openConnection();

        // Set request method
        connection.setRequestMethod("GET");

        // Read response
        reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        response = new StringBuilder();
        while ((line = reader.readLine()) != null)
        {
          response.append(line);
        }
        reader.close();

        // Parse JSON response
        json = new JSONObject(response.toString());
        // TODO: Extract poster path from JSON and handle accordingly

      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
      catch (JSONException e)
      {
        throw new RuntimeException(e);
      }

      String finial = json.get("genres").toString();
      System.out.println(finial);
      return finial;
    }
    catch (ProtocolException e)
    {
      throw new RuntimeException(e);
    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }
  }
}

