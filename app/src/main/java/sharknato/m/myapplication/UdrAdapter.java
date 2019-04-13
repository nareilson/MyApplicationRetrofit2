package sharknato.m.myapplication;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class UdrAdapter extends RecyclerView.Adapter<UdrAdapter.UdrViewHolder> {


    List<Udr> lista;
    public UdrAdapter(List<Udr> lista){
        this.lista = lista;
    }

    @NonNull
    @Override
    public UdrViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.udr_linha,viewGroup,false);
        return new UdrViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull UdrViewHolder udrViewHolder, int position) {
        udrViewHolder.bindUdrs(lista.get(position));

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class UdrViewHolder extends RecyclerView.ViewHolder {

        TextView id;
        TextView creatAt;
        TextView nome;
        TextView avatar;
        public UdrViewHolder(View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.id);
            creatAt = itemView.findViewById(R.id.creatAt);
            nome= itemView.findViewById(R.id.nome);
            avatar = itemView.findViewById(R.id.avatar);



            }

        public void bindUdrs(Udr udr){
            id.setText(String.valueOf(udr.getId()));
            creatAt.setText(String.valueOf(udr.getCreatedAt()));
            nome.setText(udr.getName());
            avatar.setText(String.valueOf(udr.getAvatar()));
        }
    }


}
