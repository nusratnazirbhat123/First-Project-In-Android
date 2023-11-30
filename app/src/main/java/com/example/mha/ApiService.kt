import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


interface ApiService {
    @POST("api/hcw/auth/login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>
}





