public static boolean isNetworkAvailable (Context context) {  
    if (connectedToTheNetwork(context)) {
        try {
            HttpURLConnection urlc = (HttpURLConnection) 
                (new URL("http://clients3.google.com/generate_204")
                .openConnection());
            urlc.setRequestProperty("User-Agent", "Android");
            urlc.setRequestProperty("Connection", "close");
            urlc.setConnectTimeout(1500); 
            urlc.connect();
            return (urlc.getResponseCode() == 204 &&
                        urlc.getContentLength() == 0);
        } catch (IOException e) {
            Log.e(TAG, "Error checking internet connection", e);
        }
    } else {
        Log.d(TAG, "No network available!");
    }
    return false;
}