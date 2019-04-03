package com.example.audiodb.Adapters;

public interface ItemTouchHelperAdapter {


    void onItemMove(int fromPosition, int toPosition);

    void onItemDismiss(int position);
}