import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: LoginRepository) : ViewModel() {

    private val _loginResult = MutableLiveData<String>()
    val loginResult: LiveData<String> get() = _loginResult

    fun login(username: String, password: String) {
        viewModelScope.launch {
            try {
                val response = repository.login(username, password)
                if (response.isSuccessful) {
                    _loginResult.value = "Login successful, token: ${response.body()?.token}"
                } else {
                    _loginResult.value = "Login failed: ${response.message()}"
                }
            } catch (e: Exception) {
                _loginResult.value = "Login failed: ${e.message}"
            }
        }
    }
}
