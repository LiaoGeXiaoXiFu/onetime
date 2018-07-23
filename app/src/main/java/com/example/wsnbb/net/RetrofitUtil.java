package com.example.wsnbb.net;

import com.example.wsnbb.constent.Api;
import com.example.wsnbb.constent.ApiService;

import java.io.File;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 * ━━━━━━草泥马神兽出没━━━━━━
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛Code is far away from bug with the animal protecting
 * 　　　　┃　　　┃ 神兽保佑,代码无bug
 * 　　　　┃　　　┃
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 *
 * ━━━━━━当善良的人摘下面具.你连下跪的机会都没有━━━━━━
 */

public class RetrofitUtil {
    private static RetrofitUtil retrofitUtil;
    private static ApiService apiFunction;

    private RetrofitUtil() {
        OkHttpClient mOkHttpClient = new OkHttpClient.Builder()
                .connectTimeout(5000, TimeUnit.SECONDS)
                .readTimeout(5000, TimeUnit.SECONDS)
                .writeTimeout(5000, TimeUnit.SECONDS)
                //添加日志拦截器
//                .addInterceptor(InterceptorUtil.HeaderInterceptor())
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
        Retrofit mRetrofit = new Retrofit.Builder()
                .baseUrl(Api.UUU)
                .addConverterFactory(GsonConverterFactory.create())//添加gson转换器
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//添加rxjava转换器
                .client(mOkHttpClient)
                .build();
        apiFunction = mRetrofit.create(ApiService.class);
    }

    public static RetrofitUtil getInstence() {
        if (retrofitUtil == null) {
            synchronized (RetrofitUtil.class) {
                if (retrofitUtil == null)
                    retrofitUtil = new RetrofitUtil();
            }

        }
        return retrofitUtil;
    }


    public ApiService API() {
        return apiFunction;
    }

    /**
     * post请求上传文件
     * 参数1 url
     * 参数2 回调Callback
     */
    public static void upLoadFile(String path, Map<String, Object> params, Callback callback) {

        //创建OkHttpClient请求对象
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(5000, TimeUnit.SECONDS)
                .readTimeout(5000, TimeUnit.SECONDS)
                .writeTimeout(5000, TimeUnit.SECONDS)
                .build();

        MultipartBody.Builder builder = new MultipartBody.Builder();
        //设设置类型 以表单的形式提交
        builder.setType(MultipartBody.FORM);

        for (Map.Entry<String, Object> entry : params.entrySet()) {

            Object object = entry.getValue();
            if (!(object instanceof File)) {
                builder.addFormDataPart(entry.getKey(), object.toString());
            } else {
                File file = (File) object;
                builder.addFormDataPart(entry.getKey(), file.getName().trim(),
                        RequestBody.create(MediaType.parse("img/png"), file));

                //img/png -> application/octet-stream
            }
        }

        Request request = new Request.Builder()
                .post(builder.build())
                .url(path)
                .build();

        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);
    }
}
