package com.example.twoviewholder

sealed class RecyclerViewItem {
    data class VerticalItem(val icon: Int, val text: String) : RecyclerViewItem()
    data class HorizontalItem(val icon: Int, val text: String) : RecyclerViewItem()
}