// UserRepository.kt
class UserRepository(private val apiService: ApiService1) {

    suspend fun registerUser(firstName: String, lastName: String, address: String) {
        apiService.registerUser(firstName, lastName, address)
    }
}
