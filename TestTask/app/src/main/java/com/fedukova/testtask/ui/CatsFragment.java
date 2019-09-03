package com.fedukova.testtask.ui;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fedukova.testtask.R;
import com.fedukova.testtask.activities.DetailsActivity;
import com.fedukova.testtask.api.NetworkService;
import com.fedukova.testtask.entity.Animal;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CatsFragment extends Fragment {

    private RecyclerView   mRecyclerView;
    private  TabListAdapter mTabListAdapter;
    private  List<Animal>   mDataList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cats_dogs_fragment, container, false);
        mRecyclerView = view.findViewById(R.id.list_recycler_view);
        mTabListAdapter = new TabListAdapter(mDataList);
        mTabListAdapter.setOnItemClickListener(new TabListAdapter.OnListItemClickListener() {
            @Override
            public void onListItemClicked(int position) {

                Intent intent = new Intent(getContext(), DetailsActivity.class)
                        .putExtra("position", position)
                        .putExtra(Animal.ANIMAL, mDataList.get(position));
                startActivity(intent);
            }
        });
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mTabListAdapter);
        initList();
        return view;
    }

    private void initList(){
        NetworkService.getNetworkInstance().getData().getCats().enqueue(new Callback<List<Animal>>() {
            @Override
            public void onResponse(Call<List<Animal>> call, Response<List<Animal>> response) {
                mDataList = response.body();
            }

            @Override
            public void onFailure(Call<List<Animal>> call, Throwable t) {

            }
        });


    }
}
