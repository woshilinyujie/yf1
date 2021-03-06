package jh.zkj.com.yf.Presenter.Order;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import jh.zkj.com.yf.API.OrderAPI;
import jh.zkj.com.yf.Activity.Order.OrderConfig;
import jh.zkj.com.yf.Activity.Order.ReceivableDetailActivity;
import jh.zkj.com.yf.Bean.HarvestModeBean;
import jh.zkj.com.yf.Bean.ReceivableTypeBean;
import jh.zkj.com.yf.Contract.Order.ReceivableDetailContract;
import jh.zkj.com.yf.Mutils.BigDecimalUtils;
import jh.zkj.com.yf.Mview.LoadingDialog;
import jh.zkj.com.yf.R;

/**
 * Created by wdefer
 * 2018/11/6
 * use
 */
public class ReceivableDetailPresenter implements ReceivableDetailContract.IReceivableDetailPresenter {

    private final ReceivableDetailActivity activity;
    private RecyclerView recycler;
    private Adapter adapter;
    private OrderAPI api;

    public ReceivableDetailPresenter(ReceivableDetailActivity activity) {
        this.activity = activity;
        initView();
        initData();
        initListener();
    }

    private void initView() {
        recycler = activity.getRecycler();
        initAdapter();
    }

    private void initAdapter() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false);
        recycler.setLayoutManager(layoutManager);
        adapter = new Adapter();
        recycler.setAdapter(adapter);
    }

    private void initData() {
        api = new OrderAPI(activity);
        String uuid = activity.getIntent().getStringExtra(OrderConfig.TYPE_STRING_BILL_UUID);
        activity.setRemake(activity.getIntent().getStringExtra(OrderConfig.TYPE_STRING_OUT_REMARK));
        if(!TextUtils.isEmpty(uuid)){
            getCashierTypeDetail("/" + uuid, uuid);
        }
    }

    private void initListener() {
        activity.getTitleLayout().getLeftImage().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.finish();
            }
        });
    }


    /**
     * 使用：
     */
    class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

        private ArrayList<ReceivableTypeBean> mArr = new ArrayList<>();

        //后期传入刷新
        public void notifyData(ArrayList<ReceivableTypeBean> arr) {
            mArr.clear();
            if (arr != null) {
                mArr.addAll(arr);
            }
            notifyDataSetChanged();
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_receivable_detail, parent, false);
            return new ViewHolder(view);
        }

        public ReceivableTypeBean getItem(int position) {
            if (mArr != null && mArr.size() > position) {
                return mArr.get(position);
            }
            return null;
        }

        @Override
        public int getItemViewType(int position) {
            return super.getItemViewType(position);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            ReceivableTypeBean item = getItem(position);
            if(item != null){
//                holder.type.setText("收款方式" + position);
                holder.content.setText(item.getCashierTypeName());
                BigDecimal bigDecimal = BigDecimalUtils.getBigDecimal(item.getAmount(), 2);

                holder.price.setText(BigDecimalUtils.fmtMicrometer(bigDecimal.toString()) + "\u3000元");
            }
        }

        @Override
        public int getItemCount() {
            return mArr == null ? 0 : mArr.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            @BindView(R.id.receivable_detail_price)
            TextView price;
//            @BindView(R.id.receivable_detail_type)
//            TextView type;
            @BindView(R.id.receivable_detail_content)
            TextView content;
            private View view;

            public ViewHolder(View itemView) {
                super(itemView);
                view = itemView;
                ButterKnife.bind(this, view);
            }
        }
    }


    //******************************************************************************************
    //获取收款方式
    public void getCashierTypeDetail(String uuid, String bizSoOutUuid) {

        api.getCashierTypeDetail(uuid, bizSoOutUuid, new OrderAPI.IResultMsg<ArrayList<ReceivableTypeBean>>() {
            @Override
            public void Result(ArrayList<ReceivableTypeBean> bean) {
                if(bean != null){
                    boolean has = false;
                    for (int i = 0; i < bean.size(); i++){
                        if("现金".equals(bean.get(i).getCashierTypeName())){
                            has = true;
                            break;
                        }
                    }

                    if(!has){
                        ReceivableTypeBean moneyBean = new ReceivableTypeBean();
                        moneyBean.setCashierTypeName("现金");
                        moneyBean.setAmount("0");
                        bean.add(0, moneyBean);
                    }
                    adapter.notifyData(bean);
                }
            }

            @Override
            public void Error(String json) {

            }
        });
    }

}
