package com.chh.cleanarchitecture.presentation.binding

import android.animation.Animator
import android.animation.ValueAnimator
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.graphics.ColorUtils
import androidx.databinding.BindingAdapter
import androidx.palette.graphics.Palette
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.chh.cleanarchitecture.presentation.model.PokemonTypeModel
import com.chh.cleanarchitecture.presentation.ui.adapter.PokemonPagingAdapter
import com.chh.cleanarchitecture.presentation.ui.adapter.PokemonTypeAdapter
import com.chh.cleanarchitecture.presentation.ui.base.UiState
import com.chh.cleanarchitecture.presentation.util.PokemonColorUtils
import com.google.android.material.card.MaterialCardView

@BindingAdapter("adapter")
fun RecyclerView.bindAdapter(adapter: PokemonPagingAdapter) {
    this.adapter = adapter
    setHasFixedSize(true)
}

@BindingAdapter("items")
fun RecyclerView.bindItems(items: List<PokemonTypeModel>?) {
    if (items?.isEmpty() == true) return
    (adapter as? PokemonTypeAdapter)?.submitList(items)
}

@BindingAdapter("image", "background")
fun AppCompatImageView.bindImage(thumbnailUrl: String, view: ConstraintLayout) {
    Glide.with(this)
        .load(thumbnailUrl)
        .listener(
            object : RequestListener<Drawable> {
                override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>, isFirstResource: Boolean,): Boolean {
                    return false
                }

                override fun onResourceReady(resource: Drawable, model: Any, target: Target<Drawable>?, dataSource: DataSource, isFirstResource: Boolean): Boolean {
                    val drawable = resource as BitmapDrawable
                    val bitmap = drawable.bitmap
                    Palette.Builder(bitmap).generate { palette ->
                        val dominant = palette?.dominantSwatch?.rgb
                        val darkMuted = palette?.darkMutedSwatch?.rgb
                        val darkVibrant = palette?.darkVibrantSwatch?.rgb
                        val lightMuted = palette?.lightMutedSwatch?.rgb
                        val lightVibrant = palette?.lightVibrantSwatch?.rgb

                        val background = listOfNotNull(dominant, darkMuted, darkVibrant).firstOrNull()
                        val border = listOfNotNull(lightMuted, lightVibrant, dominant).firstOrNull()

                        createView(view, background, border)
                    }
                    return false
                }
            },
        ).into(this)
}

private fun createView(view: View, background: Int?, border: Int?) {
    val shape = GradientDrawable()
    shape.shape = GradientDrawable.RECTANGLE
    shape.cornerRadius = 20f
    background?.let { shape.setColor(it) }
    border?.let { shape.setStroke(10, it) }
    view.background = shape
}

@BindingAdapter("image", "background", "name")
fun AppCompatImageView.bindImage(thumbnailUrl: String, view: ConstraintLayout, textView: AppCompatTextView) {
    Glide.with(this)
        .load(thumbnailUrl)
        .listener(
            object : RequestListener<Drawable> {
                override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>, isFirstResource: Boolean,): Boolean {
                    return false
                }

                override fun onResourceReady(resource: Drawable, model: Any, target: Target<Drawable>?, dataSource: DataSource, isFirstResource: Boolean): Boolean {
                    val drawable = resource as BitmapDrawable
                    val bitmap = drawable.bitmap
                    Palette.Builder(bitmap).generate { palette ->
                        val dark = palette?.darkMutedSwatch?.rgb
                        val light = palette?.lightVibrantSwatch?.rgb
                        dark?.let { view.setBackgroundColor(dark) }
                        light?.let { textView.setTextColor(light) }
                    }
                    return false
                }
            },
        ).into(this)
}

@BindingAdapter("toast")
fun View.bindToast(throwable: Throwable?) {
    throwable?.message?.let { errorMessage ->
        Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
    }
}

@BindingAdapter("show")
fun LottieAnimationView.bindShow(uiState: UiState) {
    removeAllAnimatorListeners()
    addAnimatorListener(object : Animator.AnimatorListener {
        override fun onAnimationStart(animation: Animator) {
            visibility = View.VISIBLE
        }

        override fun onAnimationEnd(animation: Animator) {
            visibility = View.GONE
        }

        override fun onAnimationCancel(animation: Animator) {}

        override fun onAnimationRepeat(animation: Animator) {}
    })

    visibility = if (uiState !is UiState.Loading && !isAnimating) {
        View.GONE
    } else {
        View.VISIBLE
    }

    setRepeatCount(if (uiState is UiState.Loading) ValueAnimator.INFINITE else 0)
    if (!isAnimating) {
        playAnimation()
    }
}

@BindingAdapter("type")
fun MaterialCardView.bindType(type: PokemonTypeModel) {
    val color = ContextCompat.getColor(this.context, PokemonColorUtils.getTypeColor(type.baseName))
    val alpha = ColorUtils.setAlphaComponent(color, (256 * 0.7).toInt())
    setCardBackgroundColor(alpha)
    strokeColor = color
}
