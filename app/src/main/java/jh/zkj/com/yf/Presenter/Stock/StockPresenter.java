package jh.zkj.com.yf.Presenter.Stock;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

import jh.zkj.com.yf.Contract.Stock.StockContract;
import jh.zkj.com.yf.Fragment.Stock.CommodityStockFragment;
import jh.zkj.com.yf.Fragment.Stock.SerialNoTrackFragment;
import jh.zkj.com.yf.Fragment.Stock.SkuStockFragment;
import jh.zkj.com.yf.Fragment.Stock.StockFragment;
import jh.zkj.com.yf.Fragment.Stock.StockListFragment;
import jh.zkj.com.yf.Fragment.Stock.StockSerialNoFragment;

/**
 * Created by wdefer
 * 2018/10/11
 * use
 */
public class StockPresenter implements StockContract.IStockPresenter {

    private final StockFragment fragment;
    private String[] titles;
    private ArrayList<Fragment> fragments = new ArrayList<>();

    public StockPresenter(StockFragment fragment){
        this.fragment = fragment;
        initPresenter();
    }

    private void initPresenter() {
        titles = new String[]{"商品库存", "库存序列号", "序列号跟踪", "分仓库存"};
//        StockListFragment commodityStocks = StockListFragment.newInstance(StockListFragment.TYPE_COMMODITY_STOCKS);
        CommodityStockFragment commodityStocks = CommodityStockFragment.newInstance();
//        StockListFragment stockNumber = StockListFragment.newInstance(StockListFragment.TYPE_STOCK_NUMBER);
        StockSerialNoFragment stockNumber = StockSerialNoFragment.newInstance();
//        StockListFragment numberTrack = StockListFragment.newInstance(StockListFragment.TYPE_NUMBER_TRACK);
        SerialNoTrackFragment numberTrack = SerialNoTrackFragment.newInstance();
//        StockListFragment childWarehouse = StockListFragment.newInstance(StockListFragment.TYPE_CHILD_WAREHOUSE_STOCKS);
        SkuStockFragment childWarehouse = SkuStockFragment.newInstance();
        fragments.add(commodityStocks);
        fragments.add(stockNumber);
        fragments.add(numberTrack);
        fragments.add(childWarehouse);
        if (fragment.getActivity() != null) {
            fragment.getViewPager().setAdapter(new FragmentPagerAdapter(
                    fragment.getActivity().getSupportFragmentManager()) {
                @Override
                public Fragment getItem(int position) {
                    return fragments.get(position);
                }

                @Override
                public int getCount() {
                    return fragments.size();
                }

                @Override
                public CharSequence getPageTitle(int position) {
                    return titles[position];
                }
            });
            //绑定 vp
            fragment.getSlidingTab().setViewPager(fragment.getViewPager());
        }
    }
}
