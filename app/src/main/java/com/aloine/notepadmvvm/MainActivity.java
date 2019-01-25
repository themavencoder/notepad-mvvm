package com.aloine.notepadmvvm;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.aloine.notepadmvvm.model.Note;
import com.aloine.notepadmvvm.viewmodel.NoteViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
private NoteViewModel noteViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    noteViewModel = ViewModelProviders.of(this).get(NoteViewModel.class);
    noteViewModel.getAllNotes().observe(this, new Observer<List<Note>>() {
        @Override
        public void onChanged(@Nullable List<Note> notes) {
            //update RecyclerView later
        }
    });
    }
}
