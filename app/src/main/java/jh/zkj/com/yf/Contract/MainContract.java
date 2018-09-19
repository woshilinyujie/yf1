package jh.zkj.com.yf.Contract;

import android.widget.ImageView;
import android.widget.TextView;

import jh.zkj.com.yf.Mview.MainViewPager;

/**
 * Created by linyujie on 18/9/17.
 */

public class MainContract {
    public interface IMainView{
        ImageView getHomePageIv();
        ImageView getPriceListIv();
        ImageView getOpenBillIv();
        ImageView getRetailListIv();
        ImageView getMyIv();
        TextView getHomePageTv();
        TextView getPriceListTv();
        TextView getOpenBillTv();
        TextView getRetailListTv();
        TextView getMyTv();
        void setHomePageIvBg(int resource);
        void setPriceListBg(int resource);
        void setOpenBillBg(int resource);
        void setRetailListBg(int resource);
        void setMyBg(int resource);
        void setHomePageTvColor(int color);
        void setPriceListColor(int color);
        void setOpenBillColor(int color);
        void setRetailListColor(int color);
        void setMyColor(int color);


    }
    public interface IMainPresenter{
        //viewpager配置
        void initPager(MainViewPager pager);
        //点击首页
        void selectHome(MainViewPager pager);
        //点击报价单
        void selectPriceList(MainViewPager pager);
        //点击开单
        void selectOpenBill(MainViewPager pager);
        //点击零售
        void selectRetailList(MainViewPager pager);
        //点击我的
        void selectMy(MainViewPager pager);
    }
}
