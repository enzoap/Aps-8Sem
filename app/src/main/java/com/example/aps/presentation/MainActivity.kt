package com.example.aps.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.aps.R
import com.example.aps.databinding.ActivityMainBinding
import com.example.aps.presentation.model.WeatherPresentation
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: WeatherViewModel by viewModel()
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupView(false)
        observerLiveData()
        setupClicks()
    }

    private fun observerLiveData() {
        viewModel.resultSuccess.observe(
            this
        ) { state ->
            when (state) {
                is ViewState.Error -> errorState(state.message)
                is ViewState.Success -> successState(state.info)
                is ViewState.HideLoading -> hideLoading()
                is ViewState.ShowLoading -> showLoading()
            }
        }
    }

    private fun errorState(message: String) {
        Toast.makeText(
            this,
            message,
            Toast.LENGTH_SHORT
        ).show()

        binding.progressBar.visibility = View.GONE
    }

    private fun showLoading() {
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun hideLoading() {
        binding.progressBar.visibility = View.GONE
    }

    private fun successState(state: WeatherPresentation) {
        with(binding) {
            setupView(false)
            loadImage(state.icon, imgIcon)
            txtCidade.text = state.name
            txtTemp.text = getString(R.string.temperatura, state.temperature)
            txtClima.text = state.text
            txtQualidade.text = state.airQuality
        }
        setupView(true)
    }


    private fun setupClicks() {
        binding.btnAtualizar.setOnClickListener {
            viewModel.getWeatherInfo()
        }
    }

    private fun setupView(visible: Boolean) {
        if (visible) {
            with(binding) {
                txtQualidade.visibility = View.VISIBLE
                txtClima.visibility = View.VISIBLE
                txtQualidade.visibility = View.VISIBLE
                txtTemp.visibility = View.VISIBLE
                textView7.visibility = View.VISIBLE
                txtCidade.visibility = View.VISIBLE
                imgIcon.visibility = View.VISIBLE
            }
        } else {
            with(binding){
                txtQualidade.visibility = View.GONE
                txtClima.visibility = View.GONE
                txtQualidade.visibility = View.GONE
                txtTemp.visibility = View.GONE
                textView7.visibility = View.GONE
                txtCidade.visibility = View.GONE
                imgIcon.visibility = View.GONE
            }
        }
    }

    private fun loadImage(url: String , imageView: ImageView) {
        Glide.with(this)
            .load(url)
            .skipMemoryCache(true)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .into(imageView)
    }
}