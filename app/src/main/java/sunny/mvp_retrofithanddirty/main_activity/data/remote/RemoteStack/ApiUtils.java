package sunny.mvp_retrofithanddirty.main_activity.data.remote.RemoteStack;


import sunny.mvp_retrofithanddirty.main_activity.Globals;

public class ApiUtils {


    private ApiUtils() {}

    //set baseUrl & time out here
    public static SOService getSOService() {
        return RetrofitClient.getClient(Globals.BASE_URL_STACK, Globals.timeout).create(SOService.class);
    }
}
