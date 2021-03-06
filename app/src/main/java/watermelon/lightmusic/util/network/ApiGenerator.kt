package watermelon.lightmusic.util.network

import android.content.Context
import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import kotlin.reflect.KClass

/**
 * description ： 获取服务的工具类
 * author : Watermelon02
 * email : 1446157077@qq.com
 * date : 2022/6/20 11:01
 */
object ApiGenerator {

    private lateinit var instance: Retrofit

    fun <T : Any> getApiService(
        clazz: KClass<T>,
    ): T {
        return instance.create(clazz.java)
    }

    private fun OkHttpClient.Builder.defaultOkhttpConfig(context: Context): OkHttpClient {
        connectTimeout(10, TimeUnit.SECONDS)
        readTimeout(10, TimeUnit.SECONDS)
        /*addInterceptor(HttpLoggingInterceptor(object :HttpLoggingInterceptor.Logger{
            override fun log(message: String) {
                Log.d("testTag", "log: $message")
            }
        }).apply { this.level = HttpLoggingInterceptor.Level.BODY })*/
        cookieJar(LoginService(context)) // 给每条请求增加 cookie
        return build()
    }

    fun init(context: Context) {
        instance =
            Retrofit.Builder().baseUrl("https://netease-cloud-music-api-topaz-six.vercel.app")
                .client(OkHttpClient().newBuilder().defaultOkhttpConfig(context))
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()).build()
    }

}