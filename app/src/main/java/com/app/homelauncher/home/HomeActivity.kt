package com.app.homelauncher.home

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.homelauncher.R
import com.app.homelauncher.base.BaseActivity


class HomeActivity : BaseActivity() {
    private var manager: PackageManager? = null
    private var apps: ArrayList<AppDetail>? = null
    private var applist: RecyclerView? = null
    private var adapter:AppListAdapter?=null


    override fun init() {
    }

    override fun updateUi() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        applist = findViewById(R.id.applist);
        loadApps()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.home_activity_menu, menu)
        val searchItem: MenuItem = menu!!.findItem(R.id.action_search)

        val searchView: SearchView = searchItem.getActionView() as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
               Log.e("search",newText)
                adapter?.filter?.filter(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                // task HERE
                return false
            }

        })


        return true
    }

    @SuppressLint("QueryPermissionsNeeded")
    private fun loadApps() {
        manager = getPackageManager();
        apps = ArrayList<AppDetail>();

        val i = Intent(Intent.ACTION_MAIN, null);
        i.addCategory(Intent.CATEGORY_LAUNCHER);

        val availableActivities = manager?.queryIntentActivities(i, 0);
        if (availableActivities != null) {
            Log.e("available", availableActivities.size.toString())
            for (ri in availableActivities) {
                val app = AppDetail();
                app.label = ri.loadLabel(manager);
                app.name = ri.activityInfo.name;
                app.pkgname=ri.activityInfo.packageName
                app.icon = ri.activityInfo.loadIcon(manager);
                apps?.add(app);
            }

             adapter = AppListAdapter(apps!!)
            applist?.layoutManager = GridLayoutManager(this, 4)
            applist?.adapter = adapter


        }


    }
}