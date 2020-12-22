package com.satyam.newswala.apiKey;

public class News {

    public static String CATEGORY = "https://newsapi.org/v2/everything?q=";
    public static String CATEGORY1 = "https://newsapi.org/v2/";
    public static String HOT     = "https://newsapi.org/v2/everything?q=global&apiKey=523ed99ebfd74e6bbbcca29b713c1383";
    public static String API_KEY = "&apiKey=523ed99ebfd74e6bbbcca29b713c1383";
    public static String SEARCH  = "";
    public static String INDIA   = "https://newsapi.org/v2/top-headlines?country=in&apiKey=523ed99ebfd74e6bbbcca29b713c1383";
    public static String WORLD   = "https://newsapi.org/v2/top-headlines?country=us&apiKey=523ed99ebfd74e6bbbcca29b713c1383";
    public static String ENTERTAINMENT = CATEGORY+"entertainment"+API_KEY;
    public static String TECH = CATEGORY+"tech"+API_KEY;
    public static String SCIENCE = CATEGORY+"science"+API_KEY;
    public static String POLITICS = CATEGORY+"politics"+API_KEY;
    public static String SPORTS = CATEGORY+"sports"+API_KEY;
    public static String ECONOMICS = CATEGORY+"economics"+API_KEY;

    public static String QUERY   = "https://newsapi.org/v2/everything?q="+SEARCH+API_KEY;

}
