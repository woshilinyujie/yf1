package jh.zkj.com.yf.Activity.Order;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import jh.zkj.com.yf.Activity.MBaseActivity;
import jh.zkj.com.yf.Contract.Order.RetailReceivableContract;
import jh.zkj.com.yf.Mview.TitleLayout;
import jh.zkj.com.yf.Presenter.Order.RetailReceivablePresenter;
import jh.zkj.com.yf.R;

/**
 * Created by wdefer
 * on 2018/9/21
 * use零售收款
 */
public class RetailReceivableActivity extends MBaseActivity implements RetailReceivableContract.IRetailOrderView {

    @BindView(R.id.retail_receivable_main)
    ConstraintLayout main;
    @BindView(R.id.retail_list_space)
    View space;
    @BindView(R.id.retail_list_order)
    TextView order;
    @BindView(R.id.retail_list_order_status)
    TextView orderStatus;
    @BindView(R.id.retail_list_name)
    TextView name;
    @BindView(R.id.retail_list_phone)
    TextView phone;
    @BindView(R.id.retail_list_number)
    TextView number;
    @BindView(R.id.retail_list_order_title)
    TextView orderTitle;
    @BindView(R.id.retail_list_date)
    TextView date;
    @BindView(R.id.retail_list_money)
    TextView money;
    @BindView(R.id.retail_receivable_recycler)
    RecyclerView recyclerView;
    @BindView(R.id.retail_receivable_title)
    TitleLayout titleLayout;
    private RetailReceivablePresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retail_receivable);
        ButterKnife.bind(this);
        presenter = new RetailReceivablePresenter(this);
    }

    @Override
    public ConstraintLayout getMainLayout() {
        return main;
    }

    @Override
    public View getSpace() {
        return space;
    }

    @Override
    public TextView getOrder() {
        return order;
    }

    @Override
    public TextView getOrderStatus() {
        return orderStatus;
    }

    @Override
    public TextView getName() {
        return name;
    }

    @Override
    public TextView getPhone() {
        return phone;
    }

    @Override
    public TextView getNumber() {
        return number;
    }

    @Override
    public TextView getOrderTitle() {
        return orderTitle;
    }

    @Override
    public TextView getDate() {
        return date;
    }

    @Override
    public TextView getMoney() {
        return money;
    }

    @Override
    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    @Override
    public TitleLayout getTitleLayout() {
        return titleLayout;
    }
}