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
    }
}