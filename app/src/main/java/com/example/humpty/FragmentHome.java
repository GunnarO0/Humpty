package com.example.humpty;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class FragmentHome extends Fragment {

    Random r = new Random();
    int nextPage;
    ImageView img;
    TextView location;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentHome() {
        // Required empty public constructor
    }

    public static FragmentHome newInstance(String param1, String param2) {
        FragmentHome fragment = new FragmentHome();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View view = inflater.inflate(R.layout.fragment_home, container, false);

        nextPage = 1;

        final ImageButton veto = (ImageButton) view.findViewById(R.id.veto);
        veto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NextEntry();
                // User Loses their single veto
            }
        });
        final ImageButton thumbsDown = (ImageButton) view.findViewById(R.id.thumbsDown);
        thumbsDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NextEntry();
                // Entry gets a -1
            }
        });
        final ImageButton thumbUp = (ImageButton) view.findViewById(R.id.thumbsUp);
        thumbUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NextEntry();
                // Entry gets a +1
            }
        });
        final ImageButton heart = (ImageButton) view.findViewById(R.id.heart);
        heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NextEntry();
                // Entry is save to user favorites
            }
        });

        img = (ImageView) view.findViewById(R.id.swipeView);
        location = (TextView) view.findViewById(R.id.locationText);

        return view;
    }



    private void NextEntry(){
        int nextID = 0;
        String locationTitle = "";
        switch (nextPage){
            case 0: nextID = R.drawable.swipe_chimes;
                    locationTitle = "The Chimes";
                    break;
            case 1: nextID = R.drawable.swipe_chickfila;
                    locationTitle = "Chick-Fil-A";
                    break;
            case 2: nextID = R.drawable.swipe_jinya;
                    locationTitle = "Jinya";
                    break;
            case 3: nextID = R.drawable.swipe_popeys;
                    locationTitle = "Popeyes";
                    break;
            case 4: nextID = R.drawable.swipe_roulsdeli;
                    locationTitle = "Roul's Deli";
                    break;
            default: startActivity(new Intent(getActivity().getApplicationContext(),ActivityWinner.class));
                    break;
        }
        nextPage++;
        img.setImageResource(nextID);
        location.setText(locationTitle);
    }

}