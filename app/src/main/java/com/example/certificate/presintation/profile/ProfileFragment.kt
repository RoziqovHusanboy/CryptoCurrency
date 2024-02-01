package com.example.certificate.presintation.profile

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.certificate.databinding.FragmentProfileBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    var FACEBOOK_URL = "https://www.facebook.com/"
    var FACEBOOK_PAGE_ID = "husanboy.roziqov/"
    var INSTAGRAMM_URL = "https://www.instagram.com/_roz1qov_"
    var TELEGRAMM_URL = "https://telegram.me/khroz1qov"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            exit.setOnClickListener {
                requireActivity().finish()
            }
            shareTV.setOnClickListener {
                val appPackageName = requireContext().packageName
                val sendIntent = Intent()
                sendIntent.action = Intent.ACTION_SEND
                sendIntent.putExtra(
                    Intent.EXTRA_TEXT,
                    "Check out the App at: https://play.google.com/store/apps/details?id=$appPackageName" // after adding app to play store, will change link
                )
                sendIntent.type = "text/plain"
                requireContext().startActivity(sendIntent)
            }

            binding.about.setOnClickListener {
                findNavController().navigate(ProfileFragmentDirections.actionProfileFragmentToAboutFragment())
            }

            phone.setOnClickListener {
                val intent = Intent(Intent.ACTION_DIAL)
                val number = 918690342
                intent.data = Uri.parse("tel:+992$number")
                startActivity(intent)
            }

            imageFacebook.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW)
                val facebookURL = getSocialPageURL(requireContext(), FACEBOOK_URL, FACEBOOK_PAGE_ID)
                intent.setData(Uri.parse(facebookURL)).apply {
                    startActivity(this)
                }

            }
            imageInstagramm.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(INSTAGRAMM_URL)).apply {
                    startActivity(this)
                }
            }
            imageTelegramm.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(TELEGRAMM_URL)).apply {
                    startActivity(this)
                }


            }
        }
    }

    fun getSocialPageURL(context: Context, url: String, pageID: String): String? {
        val packageManager = context.packageManager
        return try {
            val versionCode = packageManager.getPackageInfo("com.facebook.orca", 0).versionCode
            if (versionCode >= 3002850) { //newer versions of fb app
                "fb://facewebmodal/f?href=$url"
            } else { //older versions of fb app
                "fb://page/$pageID"
            }
        } catch (e: PackageManager.NameNotFoundException) {
            FACEBOOK_URL //normal web url
        }
    }
}