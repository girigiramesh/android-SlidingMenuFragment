package com.sidemenufragment.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sidemenufragment.R;
import com.sidemenufragment.model.ItemSideMenu;

import java.util.List;

/**
 * Created by Ramesh on 8/30/16.
 */
public class SideMenuAdapter extends BaseAdapter {
    private Context context;
    private List<ItemSideMenu> lstItem;
    ImageView imageView;
    TextView textView;

    public SideMenuAdapter(Context context, List<ItemSideMenu> lstItem) {
        this.context = context;
        this.lstItem = lstItem;
    }

    @Override
    public int getCount() {
        return lstItem.size();
    }

    @Override
    public Object getItem(int i) {
        return lstItem.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view1 = View.inflate(context, R.layout.item_side_menu, null);
        imageView = (ImageView) view1.findViewById(R.id.item_img);
        textView = (TextView) view1.findViewById(R.id.item_title);
        ItemSideMenu item = lstItem.get(i);
        imageView.setImageResource(item.getImgid());
        textView.setText(item.getTitle());
        return view1;
    }
}
