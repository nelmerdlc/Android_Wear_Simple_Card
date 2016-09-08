package com.nelmer.wearsimplecard;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.wearable.view.CardFragment;
import android.view.Gravity;

/**
 * Created by Ros on 8/12/2016.
 */
public class SimpleCard extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //this is where we obtain an instance of the CardFragment in order to add it to the activity.
        FragmentManager fragmentManager = getFragmentManager();
        //and here we also use the FragmentTransaction to handle guess what...yes, the transactions hahaha.
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //here is basically where we create an instance of the CardFragment and we put the content to display; a title, the description inside the card and the icon.
        CardFragment cardFragment = CardFragment.create("Card Title", "Card Content", R.drawable.ic_watch);
        //in this line we tell the card to show at the bottom of the screen. You can say BOTTOM or TOP. THIS LINE IS OPTIONAL. THE APP WON'T CRASH IF YOU JUST DON'T PUT IT.
        cardFragment.setCardGravity(Gravity.BOTTOM);

        //so all the content we specified in the CardFragment we will add it to the container created in XML
        fragmentTransaction.add(R.id.frame_layout, cardFragment);
        //and just like github don't forget to commit just to make sure this changes take effect
        fragmentTransaction.commit();
    }
}