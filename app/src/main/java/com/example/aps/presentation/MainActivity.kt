package com.example.aps.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.aps.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModel()
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupView(false)
        viewModel.call()
        observerLiveData()
        setupClicks()
    }

    private fun observerLiveData() {
        viewModel.resultSuccess.observe(
            this,
            {
                with(binding) {
                    progressBar.visibility = View.VISIBLE
                    loadImage(it.icon, imgIcon)
                    txtCidade.text = it.name
                    txtTemp.text = it.temperature
                    txtClima.text = it.text
                    txtQualidade.text = it.airQuality
                }
                setupView(true)
            }
        )
    }

    private fun setupClicks() {
        binding.btnAtualizar.setOnClickListener {
            setupView(false)
            viewModel.call()
        }
    }

    private fun setupView(visible: Boolean) {
        if (visible) {
            with(binding) {
                progressBar.visibility = View.GONE
                txtQualidade.visibility = View.VISIBLE
                txtClima.visibility = View.VISIBLE
                txtQualidade.visibility = View.VISIBLE
                txtTemp.visibility = View.VISIBLE
                textView7.visibility = View.VISIBLE
                txtCidade.visibility = View.VISIBLE
            }
        } else {
            with(binding){
                progressBar.visibility = View.VISIBLE
                txtQualidade.visibility = View.GONE
                txtClima.visibility = View.GONE
                txtQualidade.visibility = View.GONE
                txtTemp.visibility = View.GONE
                textView7.visibility = View.GONE
                txtCidade.visibility = View.GONE
            }
        }
    }

    private fun loadImage(url: String , imageView: ImageView) {
        Glide.with(this)
            .load("https:$url")
            .skipMemoryCache(true)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .into(imageView)
    }
}