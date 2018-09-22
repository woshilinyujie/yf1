package jh.zkj.com.yf.Fragment.Retail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import jh.zkj.com.yf.Contract.Retail.RetailListContract;
import jh.zkj.com.yf.Fragment.MBaseFragment;
import jh.zkj.com.yf.Presenter.Retail.RetailListPresenter;
import jh.zkj.com.yf.R;

/**
 * Created by wdefer
 * on 2018/9/19
 * use 零售单中的列表
 */
public class RetailListFragment extends MBaseFragment implements RetailListContract.IRetailView{

    @BindView(R.id.retail_list_recycler)
    RecyclerView recyclerView;
    @BindView(R.id.retail_list_refresh)
    TwinklingRefreshLayout refresh;
    private RetailListPresenter presenter;

    public static RetailListFragment newInstance() {
        RetailListFragment fragment = new RetailListFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_retail_list, null);
        ButterKnife.bind(this, view);
        presenter = new RetailListPresenter(this);
        return view;
    }

    @Override
    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    @Override
    public TwinklingRefreshLayout getTwinklingRefreshLayout() {
        return refresh;
    }

    @Override
    public void setListAdapter(RecyclerView.Adapter adapter) {
        recyclerView.setAdapter(adapter);
    }
}
