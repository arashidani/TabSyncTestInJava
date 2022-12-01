package icc.core.tabtest.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.ahmadhamwi.tabsync.TabbedListMediator;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import icc.core.tabtest.R;
import icc.core.tabtest.model.Category;
import icc.core.tabtest.model.Item;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private RecyclerView recyclerView;
    private final List<Category> categories = new ArrayList<>();

    // OnCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // オリジナルのメソッドたちを実行
        loadCategories();
        initViews();
        initTabLayout();
        initRecycler();
        initMediator();//new

    }
    /* オリジナルのメソッドたちを定義*/
    private void loadCategories(){
        // Categoryインスタンスを追加していく
        categories.add(new Category("category 1",
                new Item("Item1-1"),
                new Item("Item1-2"),
                new Item("Item1-3"),
                new Item("Item1-4"))
        );
        categories.add(new Category("category 2",
                new Item("Item2-1"),
                new Item("Item2-2"),
                new Item("Item2-3"),
                new Item("Item2-4"),
                new Item("Item2-5"))
        );
        categories.add(new Category("category 3",
                new Item("Item3-1"),
                new Item("Item3-2"))
        );
        categories.add(new Category("category 4",
                new Item("Item4-1"),
                new Item("Item4-2"),
                new Item("Item4-3"),
                new Item("Item4-4"),
                new Item("Item4-5"))
        );
    }
    private void initViews(){
        tabLayout = findViewById(R.id.tabLayout);
        recyclerView = findViewById(R.id.recyclerView);
    }
    private void initTabLayout(){
        for(Category category: categories){
            tabLayout.addTab(tabLayout.newTab().setText(category.getName()));
        }
    }
    private void initRecycler(){
        recyclerView.setAdapter(new CategoriesAdapter(this,categories));
    }
    private void initMediator(){
        // TabbedListMediatorの第３引数がList<Integer>なので定義
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < categories.size();i++){
            indices.add(i);
        }
        new TabbedListMediator(
                recyclerView,
                tabLayout,
                indices,
                false
        ).attach();
    }
}