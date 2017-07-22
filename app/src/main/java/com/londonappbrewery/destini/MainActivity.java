package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //CONSTANTS

    final int Story_ONE_INDEX = 0;
    final int STORY_TWO_INDEX = 2;
    final int STORY_THREE_INDEX = 1;
    final int END_FOUR_INDEX = 3;
    final int END_FIVE_INDEX = 4;
    final int END_SIX_INDEX = 5;
    
    Button mTopButton;
    Button mBottomButton;
    TextView mEvent;
    int mIndex;

    // holds (load string, index to go for top but, index to go for bottom but, top but string, bot but string)
    StoryEvent[] stories = {
        new StoryEvent(R.string.T1_Story, STORY_THREE_INDEX, STORY_TWO_INDEX, R.string.T1_Ans1, R.string.T1_Ans2),
            new StoryEvent(R.string.T3_Story, END_SIX_INDEX, END_FIVE_INDEX, R.string.T3_Ans1, R.string.T3_Ans2),
            new StoryEvent(R.string.T2_Story, STORY_THREE_INDEX, END_FOUR_INDEX, R.string.T2_Ans1, R.string.T2_Ans2),
            new StoryEvent(R.string.T4_End, -1, Story_ONE_INDEX, R.string.Close, R.string.Restart),
            new StoryEvent(R.string.T5_End, -1, Story_ONE_INDEX, R.string.Close, R.string.Restart),
            new StoryEvent(R.string.T6_End, -1, Story_ONE_INDEX, R.string.Close, R.string.Restart)
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //in case of screen rotation releases the index
        if (savedInstanceState != null) {
            mIndex = savedInstanceState.getInt("Index");

        } else {
            mIndex = 0;
        }

        mTopButton = (Button) findViewById(R.id.buttonTop);
        mBottomButton = (Button) findViewById(R.id.buttonBottom);
        mEvent = (TextView) findViewById(R.id.storyTextView);

        updateScreen();
    }

    //saves index in case of screen rotation -> refer to app lifecycle
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("Index", mIndex);
    }

    //when top button is clicked
    public void topClick(View v) {
        if (stories[mIndex].getTopID() == -1) {
            finish();
        }

        mIndex = stories[mIndex].getTopID();
        updateScreen();
    }

    //when top button is clicked
    public void bottomClick(View v) {
        mIndex = stories[mIndex].getBottomID();
        updateScreen();
    }

    //updates screen. Happens onCreate and when button are clicked
    public void updateScreen(){
        mEvent.setText(stories[mIndex].getLoadID());
        mTopButton.setText(stories[mIndex].getTopBText());
        mBottomButton.setText(stories[mIndex].getBottomBText());
    }
}
