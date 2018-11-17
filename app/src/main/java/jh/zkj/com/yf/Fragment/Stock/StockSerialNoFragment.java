package jh.zkj.com.yf.Fragment.Stock;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import jh.zkj.com.yf.Fragment.MBaseFragment;
import jh.zkj.com.yf.Presenter.Stock.CommodityPresenter;
import jh.zkj.com.yf.Presenter.Stock.SerialNoPresenter;
import jh.zkj.com.yf.R;

/**
 * Created by wdefer
 * 2018/11/15
 * use 库存序列号
 */
public class StockSerialNoFragment extends MBaseFragment {
    //筛选
    @BindView(R.id.serial_on_stoke_filter)
    ImageView mCommStockFilter;
    //清空
    @BindView(R.id.serial_on_stoke_clear_img)
    ImageView mCommStockClearImg;
    //search
    @BindView(R.id.serial_on_stoke_search)
    EditText search;
    //商店名
    @BindView(R.id.serial_on_stoke_text)
    TextView commodity;
    //recycler
    @BindView(R.id.serial_on_stoke_recycler)
    RecyclerView recycler;
    //扫码
    @BindView(R.id.serial_on_stoke_scan)
    ImageView scan;

    @BindView(R.id.serial_on_stoke_msg_layout)
    LinearLayout msgLayout;
    private Unbinder bind;
    private SerialNoPresenter presenter;
    private View mainView;

    public static StockSerialNoFragment newInstance() {
        return new StockSerialNoFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mainView = inflater.inflate(R.layout.fragment_serial_no_stock, null);
        bind = ButterKnife.bind(this, mainView);
        presenter = new SerialNoPresenter(this);
        return mainView;
    }

    @OnClick({R.id.serial_on_stoke_clear_img, R.id.serial_on_stoke_filter})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //清空edittext
            case R.id.stock_clear_img: {

                break;
            }

            case R.id.stock_filter: {

                break;
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        bind.unbind();
    }

    public ImageView getmCommStockFilter() {
        return mCommStockFilter;
    }

    public ImageView getmCommStockClearImg() {
        return mCommStockClearImg;
    }

    public EditText getSearch() {
        return search;
    }

    public TextView getCommodity() {
        return commodity;
    }

    public RecyclerView getRecyclerView() {
        return recycler;
    }

    public LinearLayout getMsgLayout() {
        return msgLayout;
    }

    public View getMainView() {
        return mainView;
    }

    public void setSearchText(String s){
        search.setText(s);
    }
}