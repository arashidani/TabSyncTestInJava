package icc.core.tabtest.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import icc.core.tabtest.R;
import icc.core.tabtest.model.Category;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoryViewHolder> {
    // フィールド
    private final Context context;
    private final List<Category> listOfCategories;
    // コンストラクタ
    public CategoriesAdapter(Context context,List<Category> listOfCategories){
        this.context = context;
        this.listOfCategories = listOfCategories;
    }
    /* 以下３つのメソッドをオーバーライド */
    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // カテゴリーのインスタンスをinflateして返す
        return new CategoryViewHolder(LayoutInflater.from(context).inflate(R.layout.item_category, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.bind(listOfCategories.get(position));
    }

    @Override
    public int getItemCount() {
        return listOfCategories.size();
    }

    // RecyclerView.ViewHolderを継承したCategoryViewHolder
    public static class CategoryViewHolder extends RecyclerView.ViewHolder{
        private final View view;
        // RecyclerView.ViewHolderを継承したCategoryViewHolder
        public CategoryViewHolder(View view){
            super(view);
            this.view = view;
        }
        // TextViewとRecycleViewにカテゴリの設定をするインスタンス・メソッド
        public void bind(Category category){
            TextView textView = (TextView) view.findViewById(R.id.categoryName);
            textView.setText(category.getName());

            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
            recyclerView.setAdapter(new ItemsAdapter(view.getContext(),category.getListOfItems()));
        }
    }
}
