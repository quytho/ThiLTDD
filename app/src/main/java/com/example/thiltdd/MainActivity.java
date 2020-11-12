package com.example.thiltdd;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    Context context;
    RelativeLayout gridviewdata;
    ArrayList<danhba> productData;
    danhbaAdapter productAdapter;
    danhba productModel;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_main);

        //getviews
        gridView = findViewById(R.id.gridview);
        gridviewdata = findViewById(R.id.gridviewdata);
        productData = new ArrayList<>();

        //add Countries Data
        populateProductData();
        gridView.setOnItemLongClickListener(new ItemLongClickRemove());
        productAdapter = new danhbaAdapter(context,productData);
        gridView.setAdapter(productAdapter);
        registerForContextMenu(gridView);
        gridView = findViewById(R.id.gridview);
        gridView.setOnItemLongClickListener(new ItemLongClickRemove());
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(context,productData.get(position).getNamedh(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),GridItemActivity.class);
                intent.putExtra("name",productData.get(position).getNamedh());
                intent.putExtra("image",productData.get(position).getImages());
                startActivity(intent);
            }
        });

    }
    private void populateProductData() {
        //product1
        productModel = new danhba();
        productModel.setId(1);
        productModel.setNamedh("văn quý thọ");
        productModel.setImages(R.drawable.dh1);
        productData.add(productModel);

        //product2
        productModel = new danhba();
        productModel.setId(1);
        productModel.setNamedh("văn quý thạnh");
        productModel.setImages(R.drawable.dh2);
        productData.add(productModel);


        productModel = new danhba();
        productModel.setId(1);
        productModel.setNamedh("lê văn q");
        productModel.setImages(R.drawable.dh3);
        productData.add(productModel);



        productModel = new danhba();
        productModel.setId(1);
        productModel.setNamedh("trần văn minh");
        productModel.setImages(R.drawable.dh4);
        productData.add(productModel);


        productModel = new danhba();
        productModel.setId(1);
        productModel.setNamedh("văn quý thọ");
        productModel.setImages(R.drawable.dh5);
        productData.add(productModel);

        productModel = new danhba();
        productModel.setId(1);
        productModel.setNamedh("văn quý thọ");
        productModel.setImages(R.drawable.dh6);
        productData.add(productModel);


        productModel = new danhba();
        productModel.setId(1);
        productModel.setNamedh("văn quý thọ");
        productModel.setImages(R.drawable.dh1);
        productData.add(productModel);
    }
    private class ItemLongClickRemove implements AdapterView.OnItemLongClickListener {
        @Override
        public boolean onItemLongClick(AdapterView parent, View view, final int position, long id) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
            alertDialogBuilder.setMessage("Bạn có muốn xóa sản phẩm này?");
            alertDialogBuilder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // xóa sp đang nhấn giữ
                    productData.remove(position);
                    //cập nhật lại gridview
                    productAdapter.notifyDataSetChanged();
                }
            });
            alertDialogBuilder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            alertDialogBuilder.show();
            return true;
        }
    }
}