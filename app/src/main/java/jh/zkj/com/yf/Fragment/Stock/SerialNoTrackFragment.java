package jh.zkj.com.yf.Fragment.Stock;

import android.content.Intent;
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
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import jh.zkj.com.yf.Contract.Stock.SerialNoContract;
import jh.zkj.com.yf.Contract.Stock.SerialNoTrackContract;
import jh.zkj.com.yf.Fragment.MBaseFragment;
import jh.zkj.com.yf.Presenter.Stock.SerialNoPresenter;
import jh.zkj.com.yf.Presenter.Stock.SerialNoTrackPresenter;
import jh.zkj.com.yf.R;

/**
 * Created by wdefer
 * 2018/11/16
 * use
 */
public class SerialNoTrackFragment extends MBaseFragment implements SerialNoTrackContract.ISerialNoTrackiew{
    //清空
    @BindView(R.id.serial_no_track_clear_img)
    ImageView mCommStockClearImg;
    //search
    @BindView(R.id.serial_no_track_search)
    EditText search;
//``
    //recycler
    @BindView(R.id.serial_no_track_recycler)
    RecyclerView recycler;
    //扫码
    @BindView(R.id.serial_no_track_scan)
    ImageView scan;

    @BindView(R.id.serial_no_track_msg_layout)
    LinearLayout msgLayout;
    //历史搜索记录
    @BindView(R.id.serial_no_track_history)
    LinearLayout history;
    //历史记录Layout
    @BindView(R.id.serial_no_track_history_layout)
    LinearLayout historyLayout;
    //title
    @BindView(R.id.serial_no_title)
    LinearLayout titleLayout;
    //序列号
    @BindView(R.id.serial_no_num)
    TextView serialNo;
    //商品名字
    @BindView(R.id.serial_no_name)
    TextView serialNoName;

    private Unbinder bind;
    private SerialNoTrackPresenter presenter;
    private View mainView;

    public static SerialNoTrackFragment newInstance() {
        return new SerialNoTrackFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mainView = inflater.inflate(R.layout.fragment_serial_no_track, null);
        bind = ButterKnife.bind(this, mainView);
        presenter = new SerialNoTrackPresenter(this);
        return mainView;
    }

    @OnClick({R.id.serial_no_track_scan, R.id.serial_no_track_clear_img, R.id.serial_no_track_delete})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //扫码
            case R.id.serial_no_track_scan: {
                presenter.openScan();
                break;
            }
            //清空edittext
            case R.id.serial_no_track_clear_img: {
                setSearchText("");
                break;
            }
            //删除历史
            case R.id.serial_no_track_delete: {
                presenter.deleteHistory();
                break;
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        bind.unbind();
    }

    public ImageView getmCommStockClearImg() {
        return mCommStockClearImg;
    }

    public EditText getSearch() {
        return search;
    }

//    public TextView getCommodity() {
//        return commodity;
//    }

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

    public LinearLayout getHistory(){
        return history;
    }

    public LinearLayout getHistoryLayout(){
        return historyLayout;
    }

    public LinearLayout getTitleLayout() {
        return titleLayout;
    }

    public void setSerialNo(String s) {
        serialNo.setText(s);
    }

    public void setSerialNoName(String s) {
        serialNoName.setText(s);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        presenter.onActivityResult(requestCode, resultCode, data);
    }
}
