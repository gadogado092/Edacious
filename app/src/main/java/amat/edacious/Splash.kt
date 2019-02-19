package amat.edacious

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_splash.*

class Splash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        imageView5.setOnClickListener {
            val i= Intent(this,LoginActivity::class.java)
            startActivity(i)
        }

        imageView6.setOnClickListener {
            val i= Intent(this,MainActivity::class.java)
            startActivity(i)
            finish()
        }
    }
}
