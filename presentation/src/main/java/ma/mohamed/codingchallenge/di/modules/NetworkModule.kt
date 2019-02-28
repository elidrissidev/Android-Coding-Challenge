package ma.mohamed.codingchallenge.di.modules

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import ma.mohamed.codingchallenge.R
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Singleton
    @Provides
    fun provideCache(context: Context): Cache = Cache(
        File(context.cacheDir, "okHttp_cache"),
        10 * 1000 * 1000 // 10mb
    )

    @Singleton
    @Provides
    fun provideOkHttpClient(cache: Cache): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
        .cache(cache)
        .build()

    @Singleton
    @Provides
    fun provideRetrofit(context: Context, gson: Gson, client: OkHttpClient): Retrofit = Retrofit.Builder()
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(client)
        .baseUrl(context.getString(R.string.api_base_url))
        .build()
}
