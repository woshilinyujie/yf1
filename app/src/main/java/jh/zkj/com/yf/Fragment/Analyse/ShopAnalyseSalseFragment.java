package jh.zkj.com.yf.Fragment.Analyse;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import jh.zkj.com.yf.Fragment.MBaseFragment;
import jh.zkj.com.yf.Mview.MeasureListView;
import jh.zkj.com.yf.Presenter.Analyse.ShopAnalyseSalseFragmentPresenter;
import jh.zkj.com.yf.R;

/**
 * Created by linyujie on 18/10/11.
 * 门店经营分析    销量
 */

public class ShopAnalyseSalseFragment extends MBaseFragment {

    @BindView(R.id.sales_chart)
    LineChart salesChart;
    Unbinder unbinder;
    @BindView(R.id.sales_pie_chart)
    PieChart salesPieChart;
    @BindView(R.id.sales_table_list)
    MeasureListView salesTableList;
    @BindView(R.id.sales_all)
    TextView salesAll;

    private View rootView;
    private ShopAnalyseSalseFragmentPresenter present;
    private String endData;
    private String startData;
    private String conpanyCode;
    private String shopName;
    private String companyUuid;

    public static ShopAnalyseSalseFragment newInstance(String shopName, String startData, String endData, String conpanyCode,String companyUuid) {
        ShopAnalyseSalseFragment fragment = new ShopAnalyseSalseFragment();
        Bundle bundle = new Bundle();
        bundle.putString("endData", endData);
        bundle.putString("startData", startData);
        bundle.putString("conpanyCode", conpanyCode);
        bundle.putString("shopName", shopName);
        bundle.putString("shopName", shopName);
        bundle.putString("companyUuid", companyUuid);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        endData = getArguments().getString("endData");
        startData = getArguments().getString("startData");
        conpanyCode = getArguments().getString("conpanyCode");
        shopName = getArguments().getString("shopName");
        companyUuid = getArguments().getString("companyUuid");

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = View.inflate(getActivity(), R.layout.shop_analyse_salse_layout, null);
        unbinder = ButterKnife.bind(this, rootView);
        present = new ShopAnalyseSalseFragmentPresenter(this);
        present.getLinCharData(shopName, conpanyCode, startData, endData, "", "", "",companyUuid,"store");
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public LineChart getSalesChart() {
        return salesChart;
    }

    public PieChart getSalesPieChart() {
        return salesPieChart;
    }

    public MeasureListView getSalesTableList() {
        return salesTableList;
    }

    public ShopAnalyseSalseFragmentPresenter getPresent() {
        return present;
    }

    public TextView getSalesAll() {
        return salesAll;
    }

    public void setSalesAllTx(String s){
        salesAll.setText(s);
    }
}
