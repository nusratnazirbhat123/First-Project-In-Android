import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class LoginViewModelFactory(private val repository: LoginRepository) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

    @Suppress("UNCHECKED_CAST")
    fun <T : ViewModel> createNonNullable(modelClass: Class<T>): T {
        return create(modelClass) ?: throw IllegalArgumentException("Unknown ViewModel class")
    }

}
