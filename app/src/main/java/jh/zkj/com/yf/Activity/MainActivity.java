package jh.zkj.com.yf.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jh.zkj.com.yf.Contract.MainContract;
import jh.zkj.com.yf.Mview.MainViewPager;
import jh.zkj.com.yf.R;

/**
 * linyujie
 */

public class MainActivity extends MBaseActivity implements MainContract.IMainView {


    @BindView(R.id.main_activity_home_page)
    ImageView mainActivityHomePage;
    @BindView(R.id.main_activity_price_list)
    ImageView mainActivityPriceList;
    @BindView(R.id.main_activity_open_bill)
    ImageView mainActivityOpenBill;
    @BindView(R.id.main_activity_retail_list)
    ImageView mainActivityRetailList;
    @BindView(R.id.main_activity_my)
    ImageView mainActivityMy;
    @BindView(R.id.main_activity_home_text)
    TextView mainActivityHomeText;
    @BindView(R.id.main_activity_price_list_text)
    TextView mainActivityPriceListText;
    @BindView(R.id.main_activity_retail_list_text)
    TextView mainActivityRetailListText;
    @BindView(R.id.main_activity_my_text)
    TextView mainActivityMyText;
    @BindView(R.id.main_activity_open_bill_text)
    TextView mainActivityOpenBillText;
    @BindView(R.id.home_activity_view_page)
    MainViewPager homeActivityViewPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.main_activity_home_page, R.id.main_activity_price_list, R.id.main_activity_open_bill, R.id.main_activity_retail_list, R.id.main_activity_my})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.main_activity_home_page://首页
                break;
            case R.id.main_activity_price_list://报价单
                break;
            case R.id.main_activity_open_bill://开单
                break;
            case R.id.main_activity_retail_list://零售单
                break;
            case R.id.main_activity_my://我的
                break;
        }
    }

    @Override
    public ImageView getHomePageIv() {
        return mainActivityHomePage;
    }

    @Override
    public ImageView getPriceListIv() {
        return mainActivityPriceList;
    }

    @Override
    public ImageView getOpenBillIv() {
        return mainActivityOpenBill;
    }

    @Override
    public ImageView getRetailListIv() {
        return mainActivityRetailList;
    }

    @Override
    public ImageView getMyIv() {
        return mainActivityMy;
    }

    @Override
    public TextView getHomePageTv() {
        return mainActivityHomeText;
    }

    @Override
    public TextView getPriceListTv() {
        return mainActivityPriceListText;
    }

    @Override
    public TextView getOpenBillTv() {
        return mainActivityOpenBillText;
    }

    @Override
    public TextView getRetailListTv() {
        return mainActivityRetailListText;
    }

    @Override
    public TextView getMyTv() {
        return mainActivityMyText;
    }

    @Override
    public void setHomePageIvBg(int resource) {

    }

    @Override
    public void setPriceListBg(int resource) {

    }

    @Override
    public void setOpenBillBg(int resource) {

    }

    @Override
    public void setRetailListBg(int resource) {

    }

    @Override
    public void setMyBg(int resource) {

    }

    @Override
    public void setHomePageTvColor(int color) {
        mainActivityHomeText.setTextColor(color);
    }

    @Override
    public void setPriceListColor(int color) {
        mainActivityPriceListText.setTextColor(color);
    }

    @Override
    public void setOpenBillColor(int color) {
        mainActivityOpenBillText.setTextColor(color);
    }

    @Override
    public void setRetailListColor(int color) {
        mainActivityRetailListText.setTextColor(color);
    }

    @Override
    public void setMyColor(int color) {
        mainActivityMyText.setTextColor(color);
    }
}
