package sunny.mvp_retrofithanddirty.main_activity.data.remote.RemoteStack;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import sunny.mvp_retrofithanddirty.main_activity.Globals;
import sunny.mvp_retrofithanddirty.main_activity.data.model.Answer.Answer;

/**
 * Created by Chike on 12/3/2016.
 */


public interface SOService {

    String url = Globals.BASE_URL_STACK2;

    @GET(url)
    Call<Answer> getAnswers();

    @GET(url)
    Call<Answer> getDisplayImage();
    // RxJava
    // Observable<SOAnswersResponse> getAnswers();

    @GET(url)
    Call<List<Answer>> getAnswers(@Query("tagged") String tags);


}
