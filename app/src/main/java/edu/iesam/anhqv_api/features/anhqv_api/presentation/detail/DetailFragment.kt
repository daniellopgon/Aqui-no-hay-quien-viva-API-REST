package edu.iesam.anhqv_api.features.anhqv_api.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import edu.iesam.anhqv_api.databinding.DetailFragmentBinding
import edu.iesam.anhqv_api.features.anhqv_api.core.api.ApiClient
import edu.iesam.anhqv_api.features.anhqv_api.data.CharacterDataRepository
import edu.iesam.anhqv_api.features.anhqv_api.data.remote.api.ApiRemoteDataSource
import edu.iesam.anhqv_api.features.anhqv_api.domain.GetCharacterByIdUseCase

class DetailFragment : Fragment() {
    private var _binding: DetailFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DetailFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    private val detailViewModel = DetailViewModel(
        GetCharacterByIdUseCase(
            CharacterDataRepository(
                ApiRemoteDataSource(
                    ApiClient()
                )
            )
        )
    )

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}