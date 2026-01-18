package com.example.burgerkotlin.ui.onboarding

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.burgerkotlin.R
import com.example.burgerkotlin.databinding.ActivityOnboardingBinding
import com.example.burgerkotlin.ui.auth.WelcomeActivity

class OnboardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnboardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
                val layoutDots = findViewById<LinearLayout>(R.id.layoutDots)
                val btnLetsGo = findViewById<Button>(R.id.btnLetsGo)
                val tvSkip = findViewById<TextView>(R.id.tvSkip)*/

        binding.viewPager.adapter = OnboardingAdapter(
            listOf(
                OnboardingItem(
                    R.drawable.burger1,
                    "WELCOME to BURGER STATION!",
                    "Delicious burgers made from the freshest, highest quality ingredients every day"
                ),
                OnboardingItem(
                    R.drawable.burger2,
                    "Enjoy Your Favorite Burger!",
                    "Choose your favorite burger with a consistent and fresh taste with every order"
                ),
                OnboardingItem(
                    R.drawable.burger3,
                    "Fresh Burgers, Served On Time!",
                    "Hot juicy burgers served fast on time anytime"
                )
            )
        )

        val dots = arrayOf(
            binding.dot1,
            binding.dot2,
            binding.dot3
        )

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                for (i in dots.indices) {
                    val params = dots[i].layoutParams as LinearLayout.LayoutParams
                    if (i == position) {
                        params.width =
                            resources.getDimensionPixelSize(R.dimen.dot_active_width)
                        dots[i].setBackgroundResource(R.drawable.dot_active)
                    } else {
                        params.width =
                            resources.getDimensionPixelSize(R.dimen.dot_inactive_size)
                        dots[i].setBackgroundResource(R.drawable.dot_inactive)
                    }
                    dots[i].layoutParams = params
                }

                if (position == dots.size - 1) {
                    binding.layoutDots.visibility = View.GONE
                    binding.btnLetsGo.visibility = View.VISIBLE
                } else {
                    binding.layoutDots.visibility = View.VISIBLE
                    binding.btnLetsGo.visibility = View.GONE
                }
            }
        })

        binding.tvSkip.setOnClickListener {
            goToWelcome()
        }

        binding.btnLetsGo.setOnClickListener {
            goToWelcome()
        }
    }

    private fun goToWelcome() {
        startActivity(Intent(this, WelcomeActivity::class.java))
        finish()
    }
}
