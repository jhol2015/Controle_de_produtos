package br.com.jholdev.controledeprodutos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterProduto extends RecyclerView.Adapter<AdapterProduto.MyViewHolder> {
    private List<Produto> produtoList;

    public AdapterProduto(List<Produto> produtoList) {
        this.produtoList = produtoList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_produto, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //pega as informações de cada produto
        Produto produto = produtoList.get(position);

        holder.txtProduto.setText(produto.getNome());
        holder.txtEstoque.setText(String.valueOf(produto.getEstoque()));
        holder.txtValor.setText(String.valueOf(produto.getValor()));
    }

    @Override
    public int getItemCount() {
        return produtoList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtProduto, txtEstoque, txtValor;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtProduto = itemView.findViewById(R.id.txt_produto);
            txtEstoque = itemView.findViewById(R.id.txt_estoque);
            txtValor = itemView.findViewById(R.id.txt_valor);
        }
    }
}
