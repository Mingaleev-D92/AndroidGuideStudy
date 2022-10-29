package com.example.androidguidestudy.data.remote

import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

/**
 * @author : Mingaleev D
 * @data : 29/10/2022
 */
@Root(name = "feed", strict = false)
data class AndroidEssenceFeed(
   @field: ElementList(name = "entry", inline = true)
   @param: ElementList(name = "entry", inline = true)
   val items: List<AndroidEssenceFeedItem>? = null
)