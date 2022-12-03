package ktepin.penzasoft.dairy.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ktepin.penzasoft.dairy.databinding.FragmentCreateNotificationBinding
import ktepin.penzasoft.dairy.vm.CreateNotificationViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CreateNotificationFragment : Fragment() {

    private val createNotificationViewModel: CreateNotificationViewModel by viewModel()
    private var _binding: FragmentCreateNotificationBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentCreateNotificationBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}