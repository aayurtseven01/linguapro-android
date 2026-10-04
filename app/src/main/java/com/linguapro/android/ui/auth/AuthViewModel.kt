package com.linguapro.android.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.linguapro.android.data.AccountResult
import com.linguapro.android.data.FirebaseAccountRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

internal data class AuthRequest(val login: Boolean, val name: String, val email: String, val password: String)
internal data class AuthState(val busy: Boolean = false, val result: AccountResult? = null)

/** Retains the operation across configuration changes; credentials never enter saved UI state. */
internal class AuthViewModel(
    private val authenticate: (AuthRequest, (AccountResult) -> Unit) -> Unit
) : ViewModel() {
    private val mutableState = MutableStateFlow(AuthState())
    val state: StateFlow<AuthState> = mutableState

    fun submit(request: AuthRequest) {
        if (mutableState.value.busy) return
        mutableState.value = AuthState(busy = true)
        val completed: (AccountResult) -> Unit = { mutableState.value = AuthState(result = it) }
        try { authenticate(request, completed) }
        catch (_: Exception) { completed(AccountResult.Error("Bağlantı kurulamadı. Lütfen tekrar dene.")) }
    }

    fun consumeResult() { mutableState.value = mutableState.value.copy(result = null) }

    class Factory(private val accounts: FirebaseAccountRepository) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            require(modelClass == AuthViewModel::class.java)
            return AuthViewModel { request, done ->
                if (request.login) accounts.signIn(request.email, request.password, done)
                else accounts.register(request.name, request.email, request.password, done)
            } as T
        }
    }
}
