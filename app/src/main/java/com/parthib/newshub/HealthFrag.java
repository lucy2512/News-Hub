package com.parthib.newshub;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HealthFrag extends Fragment {

	String api="22d38fb887fd4b04886b0176ffe824f8";
	ArrayList<ModelClass> modelClassArrayList;
	private RecyclerView recyclerViewofhealth;
	Adapter adapter;
	String country="in";
	private String category="health";

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.healthfrag,null);

		recyclerViewofhealth=v.findViewById(R.id.healthf);
		modelClassArrayList=new ArrayList<>();
		recyclerViewofhealth.setLayoutManager(new LinearLayoutManager(getContext()));
		adapter=new Adapter(getContext(),modelClassArrayList);
		recyclerViewofhealth.setAdapter(adapter);

		findNews();

		return v;
	}

	private void findNews() {
		APIutils.getAPIinterface().getCategoryNews(country, category, 100, api).enqueue(new Callback<News>() {
			@Override
			public void onResponse(Call<News> call, Response<News> response) {
				if (response.isSuccessful()) {
					modelClassArrayList.addAll(response.body().getArticles());
					adapter.notifyDataSetChanged();
				}
			}

			@Override
			public void onFailure(Call<News> call, Throwable t) {

			}
		});
	}
}
