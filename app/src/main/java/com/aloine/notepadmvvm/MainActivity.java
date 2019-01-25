package com.aloine.notepadmvvm;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.aloine.notepadmvvm.adapter.NoteAdapter;
import com.aloine.notepadmvvm.database.model.Note;
import com.aloine.notepadmvvm.database.viewmodel.NoteViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
private NoteViewModel noteViewModel;
private NoteAdapter noteAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    noteViewModel = ViewModelProviders.of(this).get(NoteViewModel.class);
    noteViewModel.getAllNotes().observe(this, new Observer<List<Note>>() {
        @Override
        public void onChanged(@Nullable List<Note> notes) {
            //update RecyclerView later
            noteAdapter.setNotes(notes);

        }
    });
    }

    private void init() {
        RecyclerView  recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        noteAdapter = new NoteAdapter();
        recyclerView.setAdapter(noteAdapter);
    }
}
