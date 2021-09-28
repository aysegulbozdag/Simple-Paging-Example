package com.example.listwithpaging.model


data class RickyAndMortList(val info: info, val results: List<CharacterData>)
data class CharacterData(val name: String?, val species: String?, val image: String?)
data class info(val count: Int?, val pages: String?, val next: String?, val prev: String?)
