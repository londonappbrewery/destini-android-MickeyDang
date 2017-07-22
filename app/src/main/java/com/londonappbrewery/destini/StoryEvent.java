package com.londonappbrewery.destini;

/**
 * Created by mickeydang on 2017-07-21.
 */

public class StoryEvent {

    int mLoadID;
    int mBottomID;
    int mTopID;
    int mBottomtext;
    int mTopText;

    public StoryEvent (int id_To_Load, int id_top_path, int id_bottom_path, int id_top_but_text, int id_bottom_but_text) {
        mLoadID = id_To_Load;
        mBottomID = id_bottom_path;
        mTopID = id_top_path;
        mBottomtext = id_bottom_but_text;
        mTopText = id_top_but_text;
    }

    public int getLoadID () {
        return mLoadID;
    }

    public int getBottomID() {
        return mBottomID;
    }

    public int getTopID () {
        return mTopID;
    }

    public int getTopBText () {
        return mTopText;
    }

    public int getBottomBText () {
        return mBottomtext;
    }


}
