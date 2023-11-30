import retrofit2.Response

class LoginRepository(private val apiService: ApiService) {
    suspend fun login(username: String, password: String): Response<LoginResponse> {
        val request = LoginRequest(username, password)
        return apiService.login(request)
    }
}
