package bobby.irawan.ministockbit.presentation.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import bobby.irawan.ministockbit.presentation.R
import bobby.irawan.ministockbit.presentation.databinding.FragmentLoginBinding
import bobby.irawan.ministockbit.presentation.login.viewmodel.LoginViewModel
import bobby.irawan.ministockbit.presentation.utils.Constants.LoginFlow.HomePage
import bobby.irawan.ministockbit.presentation.utils.ValidationHelper.assertNotEmpty
import com.afollestad.vvalidator.form
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModel<LoginViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpListener()
        setUpObserver()
    }

    private fun setUpListener() {
        with(binding) {
            form {
                inputLayout(textInputLayoutEmail) {
                    assertNotEmpty()
                }
                inputLayout(textInputLayoutPassword) {
                    assertNotEmpty()
                }
                submitWith(R.id.button_login) {
                    if (it.success()) {
                        viewModel.onSaveDataLogin(editTextEmail.text.toString())
                        navigateToWatchList()
                    }
                }
            }
        }
    }

    private fun setUpObserver() {
        viewModel.loginFlow.observe(viewLifecycleOwner) {
            when (it) {
                HomePage -> navigateToWatchList()
            }
        }
    }

    private fun navigateToWatchList() {
        val action = LoginFragmentDirections.actionLoginFragmentToWatchListFragment()
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() =
            LoginFragment()
    }

}