package com.linguapro.android

import com.linguapro.android.billing.VerifiedSubscription
import org.junit.Assert.*
import org.junit.Test

class ProAccessTest {
    @Test fun paidAccessRequiresTheRightAccountAndFreshUnexpiredServerEvidence() {
        val pro = VerifiedSubscription("alice", true, 200_000_000L, 1_000L)
        assertTrue(pro.allowsAccess("alice", 2_000L))
        assertFalse(pro.allowsAccess("bob", 2_000L))
        assertFalse(pro.allowsAccess(null, 2_000L))
        assertFalse(pro.copy(active = false).allowsAccess("alice", 2_000L))
        assertFalse(pro.allowsAccess("alice", 1L))
        assertFalse(pro.allowsAccess("alice", 90_000_000L))
        assertFalse(pro.copy(expiresAt = 2_000L).allowsAccess("alice", 2_000L))
    }
}
