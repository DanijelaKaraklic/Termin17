package rs.aleph.android.example12.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import rs.aleph.android.example12.R;
import rs.aleph.android.example12.activities.FirstActivity;
import rs.aleph.android.example12.activities.SecondActivity;
import rs.aleph.android.example12.providers.JeloProvider;

/**
 * Created by androiddevelopment on 20.10.17..
 */

public class ListFragment extends Fragment {
    OnItemSelectedListener listener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast toast = Toast.makeText(getActivity(), "ListFragment.onCreate()", Toast.LENGTH_SHORT);
        toast.show();

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Toast toast = Toast.makeText(getActivity(), "ListFragment.onActivityCreated()", Toast.LENGTH_SHORT);
        toast.show();

        final List<String> mealNames = JeloProvider.getJeloNames();

        // Creates an ArrayAdaptar from the array of String
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item, mealNames);

        ListView listView = (ListView) getActivity().findViewById(R.id.listofMeals);

        // Assigns ArrayAdaptar to ListView
        listView.setAdapter(dataAdapter);

        // Starts the SecondActivity and sends it the selected URL as an extra data
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listener.onItemSelected(position);
            }
        });

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Toast toast = Toast.makeText(getActivity(), "ListFragment.onCreateView()", Toast.LENGTH_SHORT);
        toast.show();

        if (container == null)
            return null;

        View view = inflater.inflate(R.layout.fragment_list,container,false);

        return view;
    }
}
