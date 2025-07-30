package com.example.nectar.presentation.searchscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nectar.domain.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SearchViewModel @Inject constructor(
    private val productRepository: ProductRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(SearchScreenState())
    val uiState: StateFlow<SearchScreenState> = _uiState.asStateFlow()


    init {
        onSearch()
    }

    fun onSearchQueryChange(query: String) {
        _uiState.value = _uiState.value.copy(searchQuery = query)
        onSearch()
    }

    private fun onSearch() {
        val query = _uiState.value.searchQuery
        viewModelScope.launch {
            productRepository.searchProductsByName(query).collectLatest { results ->
                _uiState.value = _uiState.value.copy(searchResults = results)
            }
        }
    }
    fun clearSearchResults() {
        _uiState.value = _uiState.value.copy(searchResults = emptyList() , searchQuery = "")
    }


}