package com.example.movieapp.ui.slideshow

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentSlideshowBinding

class SlideshowFragment : Fragment() {

    private var _binding: FragmentSlideshowBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val slideshowViewModel =
            ViewModelProvider(this)[SlideshowViewModel::class.java]

        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener(){
            if (verifyET()){
               Navigation.findNavController(view).navigate(R.id.action_slideshowFragment_to_nav_home)
            }
        }

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun verifyET(): Boolean {
        return when {
            binding.etPersonName.text.isEmpty() -> {
                binding.etPersonName.error = "Error"
                false
            } (binding.etEmailAddress.text.isEmpty() && isEmailValid(binding.etEmailAddress.text.toString())) -> {
                binding.etEmailAddress.error = "Error"
                false
            }
            binding.etPassword.text.isEmpty() ->{
                binding.etPassword.error = "Error"
                false
            }else -> {
                true
            }
        }
    }

    fun isEmailValid(email: CharSequence?): Boolean {
        val emailAddress: String = email.toString().trim()

        return !Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches()
    }

    fun isValidPassword(password: String?) : Boolean {
        password?.let {
            val passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$"
            val passwordMatcher = Regex(passwordPattern)

            return passwordMatcher.find(password) != null
        } ?: return false
    }
}