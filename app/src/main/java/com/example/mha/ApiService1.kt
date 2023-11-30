import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService1 {
    @FormUrlEncoded
    @POST("api/hcw/auth/register")
    suspend fun registerUser(
        @Field("firstname") firstName: String,
        @Field("lastname") lastName: String,
        @Field("address") address: String
    )

    companion object {
        private const val BASE_URL = "https://mha-admin-panel-eiger.vercel.app/"

        fun create(): ApiService1 {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(ApiService1::class.java)
        }
    }
}
