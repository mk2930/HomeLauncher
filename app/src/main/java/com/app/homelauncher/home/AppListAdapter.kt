package com.app.homelauncher.home

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.app.homelauncher.R
import com.app.homelauncher.databinding.LayoutApplistAdapterBinding

class AppListAdapter(var list: ArrayList<AppDetail>) :
    RecyclerView.Adapter<AppListAdapter.ApplistViewHolder>(), Filterable {
    var vm: ApplistAdapterViewModel? = null
    var binding: LayoutApplistAdapterBinding? = null
    private var appfilter: AppFilter? = null
    var filterlist = ArrayList<AppDetail>()
    init {
        filterlist.addAll(list)
    }



    inner class ApplistViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        var icon: ImageView = view.findViewById(R.id.icon)
        var appname: TextView = view.findViewById(R.id.appname)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApplistViewHolder {
       return ApplistViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_applist_adapter,parent,false))
    }

    override fun getItemCount(): Int {
        return filterlist.size
    }


    override fun onBindViewHolder(holder: ApplistViewHolder, position: Int) {

        holder.icon?.setImageDrawable(filterlist.get(position).icon)
        holder.appname?.text = filterlist.get(position).label

    }

    override fun getFilter(): Filter {
            appfilter = AppFilter(this, list)
        return appfilter as AppFilter
    }

}