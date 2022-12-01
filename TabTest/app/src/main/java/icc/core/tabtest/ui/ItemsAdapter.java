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
import icc.core.tabtest.model.Item;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemViewHolder> {
    // フィールド
    private final Context context;
    private final List<Item> items;
    //コンストラクタ
    public ItemsAdapter(Context context,List<Item> items){
        this.context = context;
        this.items = items;
    }
    /* 以下３つのメソッドをオーバーライド */
    @NonNull
    @Override
    public ItemsAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // itemのインスタンスをinflateして返す
        return new ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsAdapter.ItemViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    // RecyclerView.ViewHolderを継承したItemViewHolder
    public static class ItemViewHolder extends RecyclerView.ViewHolder{
        private final View view;
        // superクラスのコンストラクタを子クラスにも定義
        public ItemViewHolder(View view){
            super(view);
            this.view = view;
        }
        // TextViewにitemを設定するインスタンスメソッド
        public void bind(Item item){
            TextView textView = (TextView) view.findViewById(R.id.textViewContent);
            textView.setText(item.getContent());
        }
    }
}
