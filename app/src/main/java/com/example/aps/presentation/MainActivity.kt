package com.example.aps.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.aps.databinding.ActivityMainBinding
import com.example.aps.presentation.model.ObjectPresentation
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
            { action ->
                when (action) {
                    is ViewAction.Error -> errorState()
                    is ViewAction.Success -> showInfo(action.info)
                }
            }
        )
    }

    private fun errorState() {
        val toast = Toast.makeText(
            this,
            "Erro, tente novamente",
            Toast.LENGTH_SHORT
        ).show()

        binding.progressBar.visibility = View.GONE
    }
    private fun showInfo(action: ObjectPresentation) {
        with(binding) {
            setupView(false)
            loadImage(action.icon, imgIcon)
            txtCidade.text = action.name
            txtTemp.text = "${action.temperature} °C"
            txtClima.text = action.text
            txtQualidade.text = action.airQuality
        }
        setupView(true)
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
                imgIcon.visibility = View.VISIBLE
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