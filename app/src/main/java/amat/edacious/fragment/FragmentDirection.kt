package amat.edacious.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import amat.edacious.R
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.squareup.picasso.Picasso

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class FragmentDirection : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =inflater.inflate(R.layout.fragment_direction, container, false)

        val imageView=view.findViewById<ImageView>(R.id.imageView8)
        val rating=view.findViewById<RatingBar>(R.id.ratingBar)
        val detail=view.findViewById<TextView>(R.id.textView5)
        detail.text="It's always a great time to get \"Back to Cool\" and enjoy a picnic with family and friends." +
                "\n\n\nThe refrigerated dairy aisle of your local grocery store for your outdoor gatherings, such as cheeses, breads, jello, dips, puddings, yogurts, juices, and much more. Try deas like these for a very tasty picnic"
        rating.rating= 3.5F
        Picasso.get().load(R.drawable.imagedetail).centerCrop().fit().into(imageView)
        return view
    }


}
