package pro.conflux.wallet.ui.activity;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import pro.conflux.wallet.R;
import pro.conflux.wallet.base.BaseActivity;
import pro.conflux.wallet.ui.adapter.MessageCenterAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class TransactionsActivity extends BaseActivity {
    private static final int SWITCH_WALLET_REQUEST = 1101;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_btn)
    ImageView ivBtn;
    @BindView(R.id.rl_btn)
    LinearLayout rlBtn;
    @BindView(R.id.lv_trading_record)
    ListView lvTradingRecord;
    @BindView(R.id.swipeRefresh)
    SwipeRefreshLayout swipeRefresh;

    private List<String> strings;
    private MessageCenterAdapter drawerWalletAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_trading_record;
    }

    @Override
    public void initToolBar() {
        tvTitle.setText(R.string.trading_record_title);
        ivBtn.setImageResource(R.drawable.ic_acount_switch);
        rlBtn.setVisibility(View.VISIBLE);
    }

    @Override
    public void initDatas() {
        strings = new ArrayList<>();
        drawerWalletAdapter = new MessageCenterAdapter(this, strings, R.layout.list_item_news_center);
        lvTradingRecord.setAdapter(drawerWalletAdapter);
    }

    @Override
    public void configViews() {
//        swipeRefresh.setRefreshing(true);
    }

    @OnClick(R.id.rl_btn)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_btn:
                Intent intent = new Intent(this,SwitchWalletActivity.class);
                startActivityForResult(intent,SWITCH_WALLET_REQUEST);
                break;
        }
    }
}
