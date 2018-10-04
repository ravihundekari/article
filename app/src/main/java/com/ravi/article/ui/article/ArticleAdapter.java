package com.ravi.article.ui.article;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ravi.article.R;
import com.ravi.article.data.model.Datum;
import com.ravi.article.di.scope.ActivityContext;
import com.ravi.article.util.Constants;
import com.ravi.article.util.DateUtil;
import com.ravi.article.util.GlideApp;
import com.ravi.article.widget.RobotoTextView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {
    private Context context;
    private List<Datum> articleList;
    private final RecyclerView.RecycledViewPool viewPool;

    @Inject
    ArticleAdapter(@ActivityContext Context context) {
        this.context = context;
        articleList = new ArrayList<>();
        viewPool = new RecyclerView.RecycledViewPool();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_article, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.rvAuthors.setRecycledViewPool(viewPool);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Datum article = articleList.get(position);
        if (article != null) {
            holder.tvTitle.setText(article.getTitle());
            setArticleFeaturedImage(holder, article);
            setArticleDescription(holder, article);
            setArticlePublishDate(holder, article);
            setArticleAuthors(holder, article);
            setFeaturedArticle(holder, article);
        }
    }

    private void setFeaturedArticle(@NonNull ViewHolder holder, Datum article) {
        if (article.getFeaturedArticle())
            holder.ivFeaturedArticle.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_check_circle));
        else
            holder.ivFeaturedArticle.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_cross_circle));
    }

    private void setArticleAuthors(@NonNull ViewHolder holder, Datum article) {
        AuthorAdapter authorAdapter = new AuthorAdapter(context, article.getAuthors());
        holder.rvAuthors.setLayoutManager(new GridLayoutManager(context, 2));
        holder.rvAuthors.setAdapter(authorAdapter);
    }

    private void setArticlePublishDate(@NonNull ViewHolder holder, Datum article) {
        Date date = DateUtil.parseDate(Constants.YYYY_MM_DD_FORMAT, article.getPublishDate());
        if (date != null)
            holder.tvPublishDate.setText(DateUtil.getFormattedDate(Constants.DD_MMM_YYYY_FORMAT, date));
    }

    private void setArticleDescription(@NonNull ViewHolder holder, Datum article) {
        String description = article.getDescription();
        if (description != null && !description.isEmpty()) {
            holder.tvDescription.setVisibility(View.VISIBLE);
            holder.tvDescription.setText(article.getDescription());
        } else
            holder.tvDescription.setVisibility(View.GONE);
    }

    private void setArticleFeaturedImage(@NonNull ViewHolder holder, Datum article) {
        if (!article.getFeaturedImage().isEmpty()) {
            GlideApp.with(context)
                    .load(article.getFeaturedImage().get(0).getImageFile())
                    .error(R.drawable.ic_error_occured)
                    .placeholder(R.drawable.ic_placeholder)
                    .into(holder.ivFeaturedImage);
        } else
            holder.ivFeaturedImage.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_error_occured));
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    void setArticleList(List<Datum> data) {
        articleList = data;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_featured_image)
        ImageView ivFeaturedImage;
        @BindView(R.id.tv_title)
        RobotoTextView tvTitle;
        @BindView(R.id.tv_description)
        RobotoTextView tvDescription;
        @BindView(R.id.tv_publish_date)
        RobotoTextView tvPublishDate;
        @BindView(R.id.rv_authors)
        RecyclerView rvAuthors;
        @BindView(R.id.iv_featured_article)
        ImageView ivFeaturedArticle;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
