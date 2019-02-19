package amat.edacious

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class FoodAdapter  (

    private val context: Context,
    private val food: List<Food>,
    private val listener: (Food) -> Unit
)
    : RecyclerView.Adapter<FoodAdapter.NextViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = NextViewHolder(
        LayoutInflater.from(context).inflate(
            R.layout.food_adapter, parent, false

        )

    )


    override fun getItemCount(): Int = food.size


    override fun onBindViewHolder(holder: NextViewHolder, position: Int) {


        holder.bindItem(food[position], listener)


    }

    class NextViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val judul= view.findViewById<TextView>(R.id.judul)
        private val image= view.findViewById<ImageView>(R.id.imageViewbanner)
        private val imagestatus= view.findViewById<ImageView>(R.id.imagestatus)
        private val pembuat= view.findViewById<TextView>(R.id.textView3)
        fun bindItem(
            food: Food,
            listener: (Food) -> Unit
        ) {
            if (food.Status){
                Picasso.get().load(R.drawable.like).into(imagestatus)
                //imagestatus.setImageResource(R.drawable.like)
            }else{
                //imagestatus.setImageResource(R.drawable.dislike)
                Picasso.get().load(R.drawable.dislike).into(imagestatus)
            }

            imagestatus.setOnClickListener{

            }
            judul.text=food.judul
            pembuat.text=food.pembuat
            Picasso.get().load(food.image).fit().centerCrop().into(image)
            //image.setImageResource(food.image)

            itemView.setOnClickListener {
                listener(food)
            }
        }

    }
}