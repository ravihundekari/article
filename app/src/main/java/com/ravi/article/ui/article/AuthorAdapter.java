package com.ravi.article.ui.article;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.ravi.article.R;
import com.ravi.article.data.model.Author;
import com.ravi.article.util.GlideApp;
import com.ravi.article.widget.RobotoTextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

class AuthorAdapter extends RecyclerView.Adapter<AuthorAdapter.ViewHolder> {
    private Context context;
    private List<Author> authorList;

    AuthorAdapter(Context context, List<Author> authorList) {
        this.context = context;
        this.authorList = authorList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_authors, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Author author = authorList.get(position);
        if (author != null) {
            holder.llAuthorDetails.setVisibility(View.VISIBLE);
            setAuthorImage(holder, author);
            setAuthorName(holder, author);
        } else
            holder.llAuthorDetails.setVisibility(View.GONE);
    }

    private void setAuthorName(@NonNull ViewHolder holder, Author author) {
        String authorName = author.getFullName();
        if (authorName != null)
            holder.tvAuthorName.setText(authorName);
    }

    private void setAuthorImage(@NonNull ViewHolder holder, Author author) {
        String authorImageUri = author.getPicture();
        if (authorImageUri != null) {
            GlideApp.with(context)
                    .load(authorImageUri)
                    .error(R.drawable.ic_default_profile)
                    .placeholder(R.drawable.ic_placeholder)
                    .into(holder.civAuthorImage);
        }
    }

    @Override
    public int getItemCount() {
        return authorList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.civ_author_image)
        CircleImageView civAuthorImage;
        @BindView(R.id.tv_author_name)
        RobotoTextView tvAuthorName;
        @BindView(R.id.ll_author_details)
        LinearLayout llAuthorDetails;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
