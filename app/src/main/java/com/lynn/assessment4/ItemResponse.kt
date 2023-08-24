package com.lynn.assessment4

data class ItemResponse(
    var items:List<Items>,
    var total:Int,
    var skip:Int,
    var limit:Int
)
