package com.nilsson.tipspromenad

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.nilsson.tipspromenad.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment(R.layout.fragment_first) {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentFirstBinding.bind(view)

        // Set up the WebView
        binding.webView.apply {
            webViewClient = WebViewClient() // ensures links open in WebView
            settings.javaScriptEnabled = true
            loadUrl("https://nilsson82.github.io/TipspromenadQuizWebPage/")
        }

        // Button navigation (already in your code)
        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
