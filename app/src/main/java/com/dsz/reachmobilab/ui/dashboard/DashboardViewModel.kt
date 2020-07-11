package com.dsz.reachmobilab.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dsz.reachmobilab.domain.Countries
import com.dsz.reachmobilab.repo.remote.LeaguesRepositoryImpl
import kotlinx.coroutines.launch

class DashboardViewModel : ViewModel() {

    private val _countries: MutableLiveData<Countries> = MutableLiveData()

    val countries: LiveData<Countries> get() = _countries

    fun searchAllLeaguesByCountry(c: String) {
        viewModelScope.launch {
            _countries.value = LeaguesRepositoryImpl.searchAllLeaguesByCountry(c)
        }
    }

}