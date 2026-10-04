package com.linguapro.android.billing

import android.app.Activity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class ProViewModel @Inject constructor(private val billing: ProBillingRepository) : ViewModel() {
    val state = billing.state
    fun load() = viewModelScope.launch { billing.loadOffers() }
    fun restore() = viewModelScope.launch { billing.restore() }
    fun onResume() = viewModelScope.launch { billing.restore(silent = true) }
    fun buy(activity: Activity, offer: ProOffer) = billing.purchase(activity, offer)
    fun canUsePro() = billing.canUsePro()
}
