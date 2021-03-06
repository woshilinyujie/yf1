package jh.zkj.com.yf.API;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import jh.zkj.com.yf.Bean.ArticleBean;
import jh.zkj.com.yf.Bean.LineDataBean;
import jh.zkj.com.yf.Bean.PieDataBean;
import jh.zkj.com.yf.Bean.ShopNameBean;
import jh.zkj.com.yf.Mutils.GsonUtils;
import jh.zkj.com.yf.Mutils.PrefUtils;
import jh.zkj.com.yf.Mview.LoadingDialog;
import jh.zkj.com.yf.Mview.Toast.MToast;

/**
 * Created by linyujie on 18/11/5.
 */

public class AnalyseAPI {
    public final String API=APIConstant.API;
    private LoadingDialog dialog;


    /**
     * 获取公司名
     */
    public void getShopName(final Context context, final IResultMsg<ShopNameBean> iResultMsg){
        if (dialog == null)
            dialog = new LoadingDialog(context);
        dialog.showLoading();
        String TOKEN= PrefUtils.getString(context,"erp_token","");
        OkGo.<String>get(API+":3001/"+HttpConstant.HTTP_BASIC_DATA_COMPANY).tag(context)
               .params("access_token",TOKEN)
                .params("type","company")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        if (dialog.isShowing())
                            dialog.dismissLoading();
                        String s = response.body().toString();
                        try {
                            ShopNameBean shopNameBean = GsonUtils.GsonToBean(s, ShopNameBean.class);
                            if(shopNameBean.getCode()==0 &&shopNameBean.getData()!=null){
                                iResultMsg.Result(shopNameBean);
                            }else{
                                MToast.makeText(context,shopNameBean.getMsg(), Toast.LENGTH_SHORT).show();
                            }
                        }catch (Exception e){
                            showToast(context,e.toString());
                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        if (dialog.isShowing())
                            dialog.dismissLoading();
                    }
                });
    }
    /**
     *
     * @param companyCode  店铺代码
     * @param startDate
     * @param endDate
     * @param classifyUuid  商品分类
     * @param brandUuid     商品品牌
     * @param skuName       商品型号
     * @param type       qty销量  sale_amount销售额  profit利润
     */
    public void LineDate(final Context context, String type, String companyCode, String startDate, String endDate
    , String classifyUuid , String  brandUuid, String  skuName,String companyUuid,String searchType,final IResultMsg<LineDataBean> iResultMsg){
        String TOKEN= PrefUtils.getString(context,"erp_token","");
        if (dialog == null)
            dialog = new LoadingDialog(context);
        dialog.showLoading();
        if(TextUtils.isEmpty(classifyUuid)|| classifyUuid.equals("请选择")){
            classifyUuid="";
        }
        if(TextUtils.isEmpty(brandUuid)||brandUuid.equals("请选择")){
            brandUuid="";
        }
        if(TextUtils.isEmpty(skuName)||skuName.equals("请选择")){
            skuName="";
        }
        OkGo.<String>get(API+":3001/report/analysis/graph/statistics").tag(context)
                .params("access_token",TOKEN)
                .params("companyCode",companyCode)
                .params("companyUuid",companyUuid)
                .params("searchType",searchType)
                .params("startDate",startDate)
                .params("endDate",endDate)
                .params("classifyUuid",classifyUuid)
                .params(" brandUuid",brandUuid)
                .params("skuName",skuName)
                .params("type",type)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String s = response.body().toString();
                        try {
                            LineDataBean lineData = GsonUtils.GsonToBean(s, LineDataBean.class);
                            if(lineData.getCode()==0 &&lineData.getData()!=null){
                                iResultMsg.Result(lineData);
                            }else{
                                MToast.makeText(context,lineData.getMsg(),Toast.LENGTH_SHORT).show();
                            }
                        }catch (Exception e){
                            showToast(context,e.toString());
                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                    }
                });
    }

    /**
     *
     * @param companyCode  店铺代码
     * @param startDate
     * @param endDate
     * @param searchType product商品 store 门店 clerk店员
     * @param classifyUuid  商品分类
     * @param brandUuid     商品品牌
     * @param skuName       商品型号
     * @param aggType       searchType=product 时必传   品牌brand_uuid  分类classify_uuid 型号sku_name  商品全称sku_full_name
     * @param type       qty销量  sale_amount销售额  profit利润
     */
    public void pieDate(final Context context, String type, String companyCode, String startDate, String endDate
    , String classifyUuid , String  brandUuid, String  skuName,String searchType,
            String aggType,final IResultMsg<PieDataBean> iResultMsg){
        if (dialog == null)
            dialog = new LoadingDialog(context);
        if(!dialog.isShowing())
            dialog.showLoading();
        if(TextUtils.isEmpty(classifyUuid)|| classifyUuid.equals("请选择")){
            classifyUuid="";
        }
        if(TextUtils.isEmpty(brandUuid)||brandUuid.equals("请选择")){
            brandUuid="";
        }
        if(TextUtils.isEmpty(skuName)||skuName.equals("请选择")){
            skuName="";
        }
        String TOKEN= PrefUtils.getString(context,"erp_token","");
        OkGo.<String>get(API+":3001/report/analysis/pie/statistics").tag(context)
                .params("access_token",TOKEN)
                .params("companyCode",companyCode)
                .params("startDate",startDate)
                .params("endDate",endDate)
                .params("classifyUuid",classifyUuid)
                .params(" brandUuid",brandUuid)
                .params("skuName",skuName)
                .params("type",type)
                .params("searchType",searchType)
                .params("aggType",aggType)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        if (dialog.isShowing())
                            dialog.dismissLoading();
                        String s = response.body().toString();
                        try {
                            PieDataBean pieData = GsonUtils.GsonToBean(s, PieDataBean.class);
                            if(pieData.getCode()==0 &&pieData.getData()!=null){
                                iResultMsg.Result(pieData);
                            }else{
                                MToast.makeText(context,pieData.getMsg(),Toast.LENGTH_SHORT).show();
                            }
                        }catch (Exception e){
                            showToast(context,e.toString());
                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        if (dialog.isShowing())
                            dialog.dismissLoading();
                        super.onError(response);
                    }
                });
    }

    /**
     * 商品分类
     */
    public  void getClassify(final Context context, final IResultMsg<ArticleBean> iResultMsg ){
        String TOKEN= PrefUtils.getString(context,"erp_token","");
        OkGo.<String>get(API+":3001/"+HttpConstant.HTTP_BASIC_DATA_CLASSIFY).tag(context)
                .params("access_token",TOKEN)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String s = response.body().toString();
                        try {
                            ArticleBean articleBean = GsonUtils.GsonToBean(s, ArticleBean.class);
                            if(articleBean.getCode()==0&&articleBean.getData()!=null){
                                iResultMsg.Result(articleBean);
                            }else{
                                showToast(context,articleBean.getMsg());
                            }
                        }catch (Exception e){
                            showToast(context,e.toString());
                        }
                    }
                });
    }
    /**
     * 商品品牌
     */
    public  void getBrand(final Context context, final IResultMsg<ArticleBean> iResultMsg ){
        String TOKEN= PrefUtils.getString(context,"erp_token","");
        OkGo.<String>get(API+":3001/"+HttpConstant.HTTP_BASIC_DATA_BRAND).tag(context)
                .params("access_token",TOKEN)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String s = response.body().toString();
                        try {
                            ArticleBean articleBean = GsonUtils.GsonToBean(s, ArticleBean.class);
                            if(articleBean.getCode()==0&&articleBean.getData()!=null){
                                iResultMsg.Result(articleBean);
                            }else{
                                showToast(context,articleBean.getMsg());
                            }
                        }catch (Exception e){
                            showToast(context,e.toString());
                        }
                    }
                });
    }
    /**
     * 商品型号
     */
    public  void getProduct(final Context context, final IResultMsg<ArticleBean> iResultMsg ){
        String TOKEN= PrefUtils.getString(context,"erp_token","");
        OkGo.<String>get(API+":3001/"+HttpConstant.HTTP_BASIC_DATA_PRODUCT).tag(context)
                .params("access_token",TOKEN)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String s = response.body().toString();
                        try {
                            ArticleBean articleBean = GsonUtils.GsonToBean(s, ArticleBean.class);
                            if(articleBean.getCode()==0&&articleBean.getData()!=null){
                                iResultMsg.Result(articleBean);
                            }else{
                                showToast(context,articleBean.getMsg());
                            }
                        }catch (Exception e){
                            showToast(context,e.toString());
                        }
                    }
                });
    }

    public interface IResultMsg<T> {
        void Result(T bean);

        void Error(String json);
    }

    public void showToast(Context context, String msg) {
        MToast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
