package jh.zkj.com.yf.Contract.Stock;

import android.content.Intent;

/**
 * Created by wdefer
 * 2018/11/15
 * use
 */
public class SerialNoContract {
    public interface ISerialNoView{
    }

    public interface ISerialNoPresenter{
        void clearFindEt();
        void showFilterPopup();
        void openScan();
        void deleteHistory();
        void onActivityResult(int requestCode, int resultCode, Intent data);
    }
}
