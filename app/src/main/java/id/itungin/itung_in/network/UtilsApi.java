package id.itungin.itung_in.network;

public class UtilsApi {
    public static final String BASE_URL_API = "https://api-itungin.herokuapp.com/api/";

    // Mendeklarasikan Interface BaseApiService
    public static BaseApiService getAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(BaseApiService.class);
    }
}
