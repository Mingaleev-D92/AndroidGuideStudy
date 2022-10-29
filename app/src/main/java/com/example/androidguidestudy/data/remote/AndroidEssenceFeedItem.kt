package com.example.androidguidestudy.data.remote

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "entry", strict = false)
data class AndroidEssenceFeedItem(
   @field: Element(name = "title")
   @param: Element(name = "title")
   val title: String
)