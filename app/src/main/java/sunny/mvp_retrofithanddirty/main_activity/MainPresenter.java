package sunny.mvp_retrofithanddirty.main_activity;

import android.app.Activity;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sunny.mvp_retrofithanddirty.main_activity.adapter.xAdapter;
import sunny.mvp_retrofithanddirty.main_activity.data.model.Answer.Answer;
import sunny.mvp_retrofithanddirty.main_activity.data.remote.RemoteStack.SOService;

/**
 * Created by Wayan-MECS on 8/10/2018.
 */

public class MainPresenter implements MainContract.presenter {

    MainContract.mainView mainView;

    public MainPresenter(MainContract.mainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void onDestroyer() {

    }

    @Override
    public void onRefreshButtonClick() {
        mainView.showProgress();
    }

    @Override
    public void requestDataFromServer() {

    }

    @Override
    public void loadAnswer(SOService s, final xAdapter adapter, final Activity act) {
        s.getAnswers().enqueue(new Callback<Answer>() {
            @Override
            public void onResponse(Call<Answer> call, Response<Answer> response) {
                if(response.isSuccessful()){
                    adapter.updateAnswers(response.body().getItems());
                } else {
                    Toast.makeText(act,"Check your connection",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Answer> call, Throwable t) {

            }
        });
    }


}
