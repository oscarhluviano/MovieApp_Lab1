package com.example.movieapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.FragmentResultListener

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var title:String? = null
    private var descripcion:String? = null
    private var video:Int? = null
    private var img:Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        parentFragmentManager.setFragmentResultListener("datosf1", this, FragmentResultListener { requestKey, result ->
            title = result.getString("titulo", "")
            descripcion = result.getString("description","")
            video = result.getInt("video", 0)
            img = result.getInt("img", 0)

            Toast.makeText(context, "Datos recibidos del fragment 2: $title y $video", Toast.LENGTH_LONG).show()
            view.findViewById<TextView>(R.id.tvTitle).text = title
            view.findViewById<TextView>(R.id.tvDesc).text = descripcion
            view.findViewById<ImageView>(R.id.ivCaption).setImageResource(img!!)

            val v1 = view.findViewById<VideoView>(R.id.videoView)
            v1.setVideoPath("android.resource://"+context!!.packageName+"/"+video)
            val mc: MediaController = MediaController(context)
            mc.setAnchorView(v1)
            v1.setMediaController(mc)
            v1.start()
        })

    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DetailsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic fun newInstance(param1: String, param2: String) =
                DetailsFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}