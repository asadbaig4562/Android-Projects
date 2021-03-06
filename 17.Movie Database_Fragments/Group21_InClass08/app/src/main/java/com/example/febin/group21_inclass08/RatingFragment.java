package com.example.febin.group21_inclass08;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RatingFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class RatingFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    final static  String MOVIE_LIST="List";

    TextView textViewTitle;
    TextView textViewDescription;
    TextView textViewGenre;
    TextView textViewRating;
    TextView textViewYear;
    TextView textViewLink;
    int page=0;
    int size;
    ImageButton imageButtonFirst;
    ImageButton imageButtonPrevious;
    ImageButton imageButtonNext;
    ImageButton imageButtonLast;
    Button buttonFinish;
    ArrayList<Movies> moviesYear=new ArrayList<>();

    public RatingFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        moviesYear=(ArrayList<Movies>) getArguments().getSerializable(MOVIE_LIST);

        return inflater.inflate(R.layout.fragment_rating, container, false);
    }



    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        size=moviesYear.size();
        textViewTitle =(TextView)getActivity().findViewById(R.id.textViewTitleValueRating);
        textViewDescription =(TextView)getActivity().findViewById(R.id.textViewDesValueRating);
        textViewGenre =(TextView)getActivity().findViewById(R.id.textViewGenreValueRating);
        textViewRating =(TextView)getActivity().findViewById(R.id.textViewRatingValueRating);
        textViewYear =(TextView)getActivity().findViewById(R.id.textViewYearvalueRating);
        textViewLink =(TextView)getActivity().findViewById(R.id.textViewLinkValueRating);

        Collections.sort(moviesYear, new Comparator<Movies>() {
            @Override
            public int compare(Movies o1, Movies o2) {
                return o1.getRating()-(o2.getRating());
            }
        });
        textViewTitle.setText(moviesYear.get(page).getName());
        textViewDescription.setText(moviesYear.get(page).getDescription());
        textViewGenre.setText(moviesYear.get(page).getGenre());
        textViewRating.setText(""+moviesYear.get(page).getRating());
        textViewYear.setText(""+moviesYear.get(page).getYear());
        textViewLink.setText(moviesYear.get(page).getLink());

        imageButtonFirst=(ImageButton)getActivity().findViewById(R.id.imageButtonFirstRating);
        imageButtonPrevious=(ImageButton)getActivity().findViewById(R.id.imageButtonPreviousRating);
        imageButtonLast=(ImageButton)getActivity().findViewById(R.id.imageButtonLastRating);
        imageButtonNext=(ImageButton)getActivity().findViewById(R.id.imageButtonNextRating);
        buttonFinish=(Button)getActivity().findViewById(R.id.finishButtonRatting);

        imageButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickNext();
            }
        });
        imageButtonLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickLast();
            }
        });
        imageButtonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickFirst();
            }
        });
        imageButtonPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickPrevious();
            }
        });
        buttonFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishButton();
            }
        });

    }

    public void finishButton()
    {
        mListener.finishRating();
    }
    public void clickFirst()
    {
        if(page==0)
        {
            Toast.makeText(getActivity(),"Already Displaying the first Movie",Toast.LENGTH_SHORT).show();
        }
        else
        {
            page=0;
            textViewTitle.setText(moviesYear.get(page).getName());
            textViewDescription.setText(moviesYear.get(page).getDescription());
            textViewGenre.setText(moviesYear.get(page).getGenre());
            textViewRating.setText(""+moviesYear.get(page).getRating());
            textViewYear.setText(""+moviesYear.get(page).getYear());
            textViewLink.setText(moviesYear.get(page).getLink());
        }
    }
    public void clickPrevious()
    {
        if(page==0)
        {
            Toast.makeText(getActivity(),"There is no previous movie to display",Toast.LENGTH_SHORT).show();
        }
        else
        {
            page=page-1;
            textViewTitle.setText(moviesYear.get(page).getName());
            textViewDescription.setText(moviesYear.get(page).getDescription());
            textViewGenre.setText(moviesYear.get(page).getGenre());
            textViewRating.setText(""+moviesYear.get(page).getRating());
            textViewYear.setText(""+moviesYear.get(page).getYear());
            textViewLink.setText(moviesYear.get(page).getLink());
        }
    }
    public void clickNext()
    {
        if(page==size-1)
        {
            Toast.makeText(getActivity(),"There is no next movie to display",Toast.LENGTH_SHORT).show();
        }
        else
        {
            page=page+1;
            textViewTitle.setText(moviesYear.get(page).getName());
            textViewDescription.setText(moviesYear.get(page).getDescription());
            textViewGenre.setText(moviesYear.get(page).getGenre());
            textViewRating.setText(""+moviesYear.get(page).getRating());
            textViewYear.setText(""+moviesYear.get(page).getYear());
            textViewLink.setText(moviesYear.get(page).getLink());
        }
    }
    public void clickLast()
    {
        if(page==size-1)
        {
            Toast.makeText(getActivity(),"There is no next movie to display",Toast.LENGTH_SHORT).show();
        }
        else
        {
            page=size-1;
            textViewTitle.setText(moviesYear.get(page).getName());
            textViewDescription.setText(moviesYear.get(page).getDescription());
            textViewGenre.setText(moviesYear.get(page).getGenre());
            textViewRating.setText(""+moviesYear.get(page).getRating());
            textViewYear.setText(""+moviesYear.get(page).getYear());
            textViewLink.setText(moviesYear.get(page).getLink());
        }
    }

    public interface OnFragmentInteractionListener {

        public void finishRating();
    }
}
