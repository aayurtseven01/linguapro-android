package com.linguapro.android

import com.linguapro.android.data.AccountResult
import com.linguapro.android.ui.auth.AuthRequest
import com.linguapro.android.ui.auth.AuthViewModel
import org.junit.Assert.*
import org.junit.Test

class AuthViewModelTest {
    private val request = AuthRequest(true, "", "test@example.test", "test-password")

    @Test fun repeatedTapDoesNotCreateAnotherPendingAuthentication() {
        var attempts = 0
        var complete: ((AccountResult) -> Unit)? = null
        val model = AuthViewModel { _, done -> attempts++; complete = done }
        model.submit(request)
        model.submit(request)
        assertEquals(1, attempts)
        assertTrue(model.state.value.busy)
        complete!!(AccountResult.Success("alice", "Alice", request.email))
        assertFalse(model.state.value.busy)
        assertEquals("alice", model.state.value.result?.uid)
    }

    @Test fun completedResultRemainsAvailableUntilTheScreenConsumesIt() {
        val model = AuthViewModel { _, done -> done(AccountResult.Success("alice", "Alice", request.email)) }
        model.submit(request)
        assertNotNull(model.state.value.result)
        model.consumeResult()
        assertNull(model.state.value.result)
        assertFalse(model.state.value.busy)
    }

    @Test fun synchronousFailureDoesNotLeaveTheFormPermanentlyBusy() {
        val model = AuthViewModel { _, _ -> error("Connection unavailable") }
        model.submit(request)
        assertFalse(model.state.value.busy)
        assertNotNull(model.state.value.result?.error)
    }
}
