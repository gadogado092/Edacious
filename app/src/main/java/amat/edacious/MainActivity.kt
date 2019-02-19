package amat.edacious

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var adapter: FoodAdapter

    private var listRoomType : MutableList<Food> = mutableListOf()
    var onStartCount =0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        onStartCount=1
        if (savedInstanceState ==null){
            this.overridePendingTransition(R.anim.anim_slide_in_left,
                R.anim.anim_slide_out_left)
        }else{
            onStartCount=2
        }

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)


        title=""
        //toolbar.setLogo(R.drawable.logo2)
       /* val i= Intent(this,Splash::class.java)
        startActivity(i)
        finish()*/
        //this.overridePendingTransition(R.anim.left_to_right,R.anim.right_to_left)
        this.overridePendingTransition(R.anim.anim_slide_in_left,0)
        adapter= FoodAdapter(this,listRoomType){

            val i= Intent(this,DetailActivity::class.java)
            startActivity(i)
        }

        list.layoutManager= LinearLayoutManager(this)
        list.setHasFixedSize(true)
        list.adapter=adapter

        val food1=Food("Avocado Ice Cream","Nam dapidu",true,R.drawable.menu1)
        val food2=Food("Ice Cream Truffles","Breyers",false,R.drawable.menu2)
        val food3=Food("Avocado Ice Cream","Amat",true,R.drawable.menu3)

        listRoomType.add(food1)
        listRoomType.add(food2)
        listRoomType.add(food3)

        adapter.notifyDataSetChanged()
    }

    override fun onStart() {
        super.onStart()
        if (onStartCount > 1){
            this.overridePendingTransition(R.anim.anim_slide_in_right,
                R.anim.anim_slide_out_right)
        } else if (onStartCount ==1){
            onStartCount++
        }
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                // Handle the camera action
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
