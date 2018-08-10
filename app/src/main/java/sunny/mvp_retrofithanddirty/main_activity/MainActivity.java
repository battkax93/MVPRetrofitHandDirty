package sunny.mvp_retrofithanddirty.main_activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sunny.mvp_retrofithanddirty.R;
import sunny.mvp_retrofithanddirty.main_activity.adapter.xAdapter;
import sunny.mvp_retrofithanddirty.main_activity.data.model.Answer.Answer;
import sunny.mvp_retrofithanddirty.main_activity.data.model.Answer.Item;
import sunny.mvp_retrofithanddirty.main_activity.data.remote.RemoteStack.ApiUtils;
import sunny.mvp_retrofithanddirty.main_activity.data.remote.RemoteStack.SOService;

public class MainActivity extends AppCompatActivity implements MainContract.mainView {

    RecyclerView recTest;
    MainContract.presenter presenter;
    SwipeRefreshLayout swipeRefreshLayout;
    SOService mServices;
    xAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainPresenter(this);
        init();
        presenter.loadAnswer(mServices,mAdapter, this);
    }

    public void init() {
        mServices = ApiUtils.getSOService();
        recTest = findViewById(R.id.rec_test);
        swipeRefreshLayout = findViewById(R.id.swiperefresh);
        mAdapter = new xAdapter(getApplicationContext(), new ArrayList<Item>(0));

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recTest.setLayoutManager(layoutManager);
        recTest.setAdapter(mAdapter);
        recTest.setHasFixedSize(true);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL);
        recTest.addItemDecoration(itemDecoration);
    }


    @Override
    public void showProgress() {
        Toast.makeText(this, "clicked", Toast.LENGTH_LONG).show();
    }

    @Override
    public void hideProgress() {

    }
}
