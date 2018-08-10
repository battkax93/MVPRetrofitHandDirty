package sunny.mvp_retrofithanddirty.main_activity;

import android.app.Activity;

import java.util.ArrayList;

import sunny.mvp_retrofithanddirty.main_activity.adapter.xAdapter;
import sunny.mvp_retrofithanddirty.main_activity.data.remote.RemoteStack.SOService;

/**
 * Created by Wayan-MECS on 8/9/2018.
 */

public interface MainContract {

    interface presenter{
        void onDestroyer();
        void onRefreshButtonClick();
        void requestDataFromServer();
        void loadAnswer(SOService s, xAdapter adapter, Activity act);
    }

    interface mainView{
        void showProgress();
        void hideProgress();
    }
}
