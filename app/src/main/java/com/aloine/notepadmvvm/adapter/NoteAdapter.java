package com.aloine.notepadmvvm.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aloine.notepadmvvm.R;
import com.aloine.notepadmvvm.database.model.Note;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder>  {
    private List<Note> notes = new ArrayList<>();



    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item,parent,false);

        return new NoteHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        Note currentNote = notes.get(position);
            holder.textViewTitle.setText(currentNote.getTitle());
            holder.textViewDescription.setText(currentNote.getDescription());
            holder.textViewPriority.setText(String.valueOf(currentNote.getPriority()));

    }

    @Override
    public int getItemCount() {
        return notes.size();
    }
    public void setNotes(List<Note> notes) {
        this.notes = notes;
        notifyDataSetChanged();

    }

    class NoteHolder extends RecyclerView.ViewHolder{
        private TextView textViewTitle, textViewDescription, textViewPriority;

        public NoteHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.text_view_title);
            textViewDescription = itemView.findViewById(R.id.text_view_description);
            textViewPriority = itemView.findViewById(R.id.text_view_priority);
        }
    }
}
