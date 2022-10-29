package com.example.androidguidestudy.data.remote

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

/**
 * @author : Mingaleev D
 * @data : 29/10/2022
 */
@Root(name = "link", strict = false)
data class AndroidEssenceLink(
   @field: Attribute(name = "href")
   @param: Attribute(name = "href")
   val href: String = ""
)