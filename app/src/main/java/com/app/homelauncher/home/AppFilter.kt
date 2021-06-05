package com.app.homelauncher.home

import android.util.Log
import android.widget.Filter

class AppFilter(var adapter: AppListAdapter, var list: ArrayList<AppDetail>) : Filter() {
    var filterlist = ArrayList<AppDetail>()

    override fun performFiltering(constraint: CharSequence?): FilterResults {
        filterlist.clear()
        val result = FilterResults()

        if (constraint?.length == 0) {
            filterlist.addAll(list)
        } else {
            val filterpattern = constraint.toString().toLowerCase().trim()
            for (app in list) {
                var label =app.label?.toString()?.toLowerCase()?.trim()
                if (label?.contains(filterpattern)!!) {
                    filterlist.add(app)
                }
            }
        }
        result.values = filterlist
        result.count = filterlist.size
        Log.e("search","filterlist.size -"+filterlist.size )

        return result
    }

    override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
        adapter.filterlist.clear()
        adapter.filterlist.addAll(results?.values as ArrayList<AppDetail>)
        adapter.notifyDataSetChanged()

    }
}