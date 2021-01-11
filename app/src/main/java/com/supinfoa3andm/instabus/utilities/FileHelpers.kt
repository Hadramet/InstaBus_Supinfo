package com.supinfoa3andm.instabus.utilities

import android.content.Context

class FileHelpers {
    companion object {
        fun getFileFromResources (context: Context, resourcesId: Int) : String
        {
            return context.resources.openRawResource(resourcesId).use {
                it.bufferedReader().use {
                    it.readText()
                }
            }
        }
        fun getFileFromAssets (context: Context, asset: String) : String
        {
            return context.assets.open(asset).use {
                it.bufferedReader().use {
                    it.readText()
                }
            }
        }
    }
}