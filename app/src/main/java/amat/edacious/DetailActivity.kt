package amat.edacious

import amat.edacious.fragment.*
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_detail.*
import android.content.Intent



class DetailActivity : AppCompatActivity() {

    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null

    private var statusPager=0

    var onStartCount =0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        onStartCount=1
        if (savedInstanceState ==null){
            this.overridePendingTransition(R.anim.anim_slide_in_left,
                R.anim.anim_slide_out_left)
        }else{
            onStartCount=2
        }

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title="Return"

        // Create the adapter that will return a fragment for each of the three

        // primary sections of the activity.

        //this.overridePendingTransition(R.anim.right_to_left,0)
        this.overridePendingTransition(R.anim.anim_slide_in_right,R.anim.anim_slide_in_right)

        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)

        // Set up the ViewPager with the sections adapter.

        container.adapter = mSectionsPagerAdapter

        container.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))

        tabs.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(container))

        container.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{

            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

                if (position==0){

                    //fab.setImageDrawable(resources.getDrawable(R.drawable.ic_action_add_room))

                }else if(position==1){

                    //fab.setImageDrawable(resources.getDrawable(R.drawable.ic_action_add_tenant))

                }

                else if(position==2){

                    //fab.setImageDrawable(resources.getDrawable(R.drawable.ic_action_spend))

                }



            }



            override fun onPageSelected(position: Int) {

                statusPager=position

            }



        })

        fab.setOnClickListener {
            val a="Lemmon Drink\n\nIt's always a great time to get \"Back to Cool\" and enjoy a picnic with family and friends." +
                    "\n\n\nThe refrigerated dairy aisle of your local grocery store for your outdoor gatherings, such as cheeses, breads, jello, dips, puddings, yogurts, juices, and much more. Try deas like these for a very tasty picnic"
            val message = "Text I want to share."
            val share = Intent(Intent.ACTION_SEND)
            share.type = "text/plain"
            share.putExtra(Intent.EXTRA_TEXT, a)

            startActivity(Intent.createChooser(share, "Share To"))
        }
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

    override fun onBackPressed() {
        finish()
        super.onBackPressed()
    }

    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        private val pages = listOf(
            FragmentDirection(),
            FragmentIngredient(),
            FragmentReview(),
            FragmentSugestion(),
            FragmentAbout()
        )

        override fun getItem(position: Int): Fragment {
            return pages[position]
        }

        override fun getCount(): Int {
            return pages.size

        }

    }
}
